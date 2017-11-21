package com.wordstalk.translate.common.service;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wordstalk.translate.common.util.FormatUtils;
import com.wordstalk.translate.common.vo.ExcelSheetVO;


@Service("exportService")
public class ExportService {
    
	private final static Logger LOG = LoggerFactory.getLogger(TranslatorService.class);
	
    private static final String REPORT = "report";
    private static final String DECODING = "UTF-8";
    private static final int SHEET_MAX_ROW = 65534;

    //创建多个sheet
    public void write2Excel(HttpServletRequest request, HttpServletResponse response, List<ExcelSheetVO> datas, String filename) {
            OutputStream os = null;
            WritableWorkbook wwb = null;
            try {
                setResponseContext(request, response, filename);
                os = response.getOutputStream();
                wwb = Workbook.createWorkbook(os);
                
                if(datas != null) {
                	for(int size=0; size<datas.size(); size++){
                		this.createExcelSheet(datas.get(size).getTitles(), datas.get(size).getColumns(),
                				datas.get(size).getResults(), wwb);
                	}
                }
            } catch (Exception e) {
                LOG.error("Export excel error happen!", e);
            } finally {
                if(wwb != null) {
                    try {
                        wwb.write();
                        wwb.close();
                    } catch (IOException e) {
                    } catch (WriteException e) {
                    }
                }
                
                if(os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
    
    public void write2Excel(HttpServletRequest request, HttpServletResponse response, String[] titles, String[] columns, 
        List<?> datas, String filename) {
        
        OutputStream os = null;
        WritableWorkbook wwb = null;
        try {
            setResponseContext(request, response, filename);
            os = response.getOutputStream();
            wwb = Workbook.createWorkbook(os);
            
            if(datas != null) {
                this.createExcelSheet(titles, columns, datas, wwb);
            }
        } catch (Exception e) {
            LOG.error("Export excel error happen!", e);
        } finally {
            if(wwb != null) {
                try {
                    wwb.write();
                    wwb.close();
                } catch (IOException e) {
                } catch (WriteException e) {
                }
            }
            
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private void createExcelSheet(String[] titles, String[] columns, List<?> datas, WritableWorkbook wwb) {
        
        // 计算表个数
        int dataRows = datas.size();
        int sheetCount = (dataRows % SHEET_MAX_ROW) == 0 ? (dataRows / SHEET_MAX_ROW) : (dataRows / SHEET_MAX_ROW + 1);
        
        List<String> attrs = new ArrayList<String>(columns.length);
        Collections.addAll(attrs, columns);
        
        try {
            int rows = SHEET_MAX_ROW;
            if (sheetCount <= 0) {
                writeTitles(titles, wwb.createSheet(REPORT+titles[0], 0));
            }
            for (int n = 0; n < sheetCount; n++) {
                // 创建表
                WritableSheet ws = wwb.createSheet(REPORT+titles[0] + n, n);
                // 写入列名
                writeTitles(titles, ws);
                // 写入数据
                if (n == sheetCount - 1) {
                    rows = dataRows - (SHEET_MAX_ROW * n);
                }
                for (int row = 1; row < rows + 1; row++) {
                    Object o = datas.get(SHEET_MAX_ROW * n + row - 1);
                    List<Field> fieldList = getPrivateFields(o.getClass());
                    this.blankData(o, fieldList, ws, attrs, row);
                }
            }
        } catch (Exception e) {
            LOG.error("Write data to excel error happen!", e);
        }
    }

    /**
     * 填充数据
     */
    private void blankData(Object obj, List<Field> fields, WritableSheet ws, List<String> attrs, 
        int row) throws IllegalAccessException, WriteException {
        
        int col = -1;
        for (Field field : fields) {
            field.setAccessible(true);
            col = attrs.indexOf(field.getName());
            if (col == -1) {
                continue;
            }
            Object value = field.get(obj);
            if (value != null) {
                Class<?> type = field.getType();
                if (int.class.equals(type) || Integer.class.equals(type)) {
                    ws.addCell(new jxl.write.Number(col, row, (Integer) value));
                } else if (long.class.equals(type) || Long.class.equals(type)) {
                    ws.addCell(new jxl.write.Number(col, row, (Long) value));
                } else if (float.class.equals(type) || Float.class.equals(type)) {
                	Float val = (Float)value;
                    ws.addCell(new jxl.write.Number(col, row, val));
                } else if (double.class.equals(type) || Double.class.equals(type)) {
                	Double val = (Double) value;
                    ws.addCell(new jxl.write.Number(col, row, val));
                } else {
                    ws.addCell(new Label(col, row, decode(value.toString())));
                }
            } else {
                ws.addCell(new Label(col, row, ""));
            }
        }
    }
    
    // 写标题
    private void writeTitles(String[] excelHeader, WritableSheet ws) throws WriteException {
        for (int i = 0; i < excelHeader.length; i++) {
            Label col = new Label(i, 0, excelHeader[i]);
            ws.addCell(col);
        }
    }

    // URL解码
    private String decode(String value) {
        try {
            return URLDecoder.decode(value, DECODING);
        } catch (Exception e) {
            return value;
        }
    }

    // 获取私有方法
    private List<Field> getPrivateFields(Class<?> clazz) {
        List<Field> resultList = new ArrayList<Field>();
        // 父类
        for (Field field : clazz.getSuperclass().getDeclaredFields()) {
            if (field.getModifiers() == Modifier.PRIVATE) {
                resultList.add(field);
            }
        }
        // 自己
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getModifiers() == Modifier.PRIVATE) {
                resultList.add(field);
            }
        }
        return resultList;
    }

    /**
     * 设置下载信息
     * 
     * @throws UnsupportedEncodingException 
     */
    private void setResponseContext(HttpServletRequest request, HttpServletResponse response, 
        String filename) throws UnsupportedEncodingException {
        response.setCharacterEncoding(DECODING);

        // IE浏览器
        String agent = request.getHeader("USER-AGENT");
        if (agent.lastIndexOf("IE") > -1) {
            response.setContentType("application/x-msdownload");
            String dispposition = "=?UTF-8?q?attachment; filename=" + gbk2ISO(filename) + ".xls";
            response.setHeader("content-disposition", dispposition);
        } else {
            // OPERA浏览器
            if (agent.lastIndexOf("Opera") > -1) {
                response.setContentType("application/x-act-msdownload;charset=UTF-8");
            } else {
                response.setContentType("application/vnd.ms-excel");
            }
            String fileName = response.encodeURL(utf82ISO(filename));
            if (agent.lastIndexOf("Safari") > -1 && agent.lastIndexOf("Chrome") > -1) {
            	 fileName = URLEncoder.encode(filename, DECODING);
            } else if (agent.lastIndexOf("Safari") > -1 && agent.lastIndexOf("Chrome") == -1) {
            	fileName = utf82ISO(filename);
            }
            response.setHeader("Content-disposition", "attachment;filename=\"" + fileName + ".xls\"");
        }
    }
    
    private String utf82ISO(String value) {
        try {
            return new String(value.getBytes("UTF-8"), "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            LOG.error(e.getMessage(), e);
        }
        return "";
    }

    private String gbk2ISO(String value) {
        try {
            return new String(value.getBytes("GBK"), "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
        	LOG.error(e.getMessage(), e);
        }
        return "";
    }
}
