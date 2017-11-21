package com.wordstalk.translate.common.service;

import com.wordstalk.translate.common.dao.ExportProjectDao;
import com.wordstalk.translate.common.vo.ProjectVO;
import com.wordstalk.translate.common.vo.export.AdminExportVO;
import com.wordstalk.translate.common.vo.export.PmExportVO;
import com.wordstalk.translate.common.vo.param.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by y on 16/10/2.
 */
@Service("exportProjectService")
public class ExportProjectService {

    @Autowired
    private ExportProjectDao exportProjectDao;

    @Autowired
    private ProjectService projectService;

    public List<PmExportVO> pmExportVOtList(PageParam param, boolean isPM){
        param.setRows(Integer.MAX_VALUE);
        param.setPage(0);
        List<ProjectVO> pList = (List<ProjectVO>) projectService.queryProjectList(param, isPM).getResults();
        List<PmExportVO> eList = exportProjectDao.exportProjectPm(param);
        List<PmExportVO> result = new ArrayList<PmExportVO>();
        Map<String, String> idMap = new HashMap<String, String>();
        for(ProjectVO p : pList){
            idMap.put(p.getId().toString(),"");
        }
        for(PmExportVO p : eList){
            if(idMap.containsKey(p.getProjectId())){
                result.add(p);
            }
        }
        return result;
    }

    public List<AdminExportVO> adminExportVOList(PageParam param, boolean isPM){
        param.setRows(Integer.MAX_VALUE);
        param.setPage(0);
        List<ProjectVO> pList = (List<ProjectVO>) projectService.queryProjectList(param, isPM).getResults();
        List<AdminExportVO> eList = exportProjectDao.exportProjectAdmin(param);
        List<AdminExportVO> result = new ArrayList<AdminExportVO>();
        /* 过滤导出符合筛选条件的项目*/
        Map<String, String> idMap = new HashMap<String, String>();
        for(ProjectVO p : pList){
            idMap.put(p.getId().toString(),"");
        }
        for(AdminExportVO p : eList){
            if(idMap.containsKey(p.getProjectId())){
                result.add(p);
            }
        }
        return result;
    }

    public void updateTrans(){
        this.exportProjectDao.updateTransField();
    }
}
