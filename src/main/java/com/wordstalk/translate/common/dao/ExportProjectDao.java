package com.wordstalk.translate.common.dao;

import com.wordstalk.translate.common.vo.ProjectVO;
import com.wordstalk.translate.common.vo.TranslatorVO;
import com.wordstalk.translate.common.vo.export.AdminExportVO;
import com.wordstalk.translate.common.vo.export.PmExportVO;
import com.wordstalk.translate.common.vo.param.PageParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by y on 16/10/2.
 */
@Repository
public class
ExportProjectDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PmExportVO> exportProjectPm(PageParam param){
        String whereSql = " where 1=1 ";
        if(StringUtils.isNotBlank(param.getOther()))
            whereSql += " and a.customer_name like '%" + param.getOther() + "%'";
        if(StringUtils.isNotBlank(param.getSearchKey()))
            whereSql += " and a.project_name like '%" + param.getSearchKey() + "%'";
        if(StringUtils.isNotBlank(param.getName()) && !"-1".equals(param.getName()))
            whereSql += " and a.project_type = '" + param.getName() + "'";
        String sql = "select a.id as projectId, a.project_name as projectName, a.start_date as projectStartDate, a.end_date " +
                "as projectEndDate, IF(a.project_type=1,'非书籍', '书籍') as projectType," +
                "a.customer_name as customerName, a.language_from as languageFrom, a.language_to " +
                "as languageTo, a.words_count as wordsCount, a.review_words_count as reviewWordsCount, a.words_no_space " +
                "as wordsNoSpace, a.remarks as projectRemarks, IF(b.part_type=1,'初译', '审校') as partType," +
                "b.part_name as partName, c.name as translatorName,b.salary_std as partSalaryStd," +
                "b.salary_real as partSalaryReal, b.words_num as wordsNum, b.start_date as " +
                "partStartDate, b.end_date as partEndDate, b.comment as comment, IF(b.status=1, '是','否') as status," +
                "b.settle_date as settleDate from w_project a left join w_project_part b" +
                " on a.id = b.project_id  left join w_translators c on b.translator_id = c.id " +
                whereSql + " order by a.end_date desc, a.id desc";
        RowMapper<PmExportVO> rm = ParameterizedBeanPropertyRowMapper.newInstance(PmExportVO.class);
        return this.jdbcTemplate.query(sql, rm);
    }

    public List<AdminExportVO> exportProjectAdmin(PageParam param){
        String whereSql = " where 1=1 ";
        if(StringUtils.isNotBlank(param.getOther()))
            whereSql += " and a.customer_name like '%" + param.getOther() + "%'";
        if(StringUtils.isNotBlank(param.getSearchKey()))
            whereSql += " and a.project_name like '%" + param.getSearchKey() + "%'";
        if(StringUtils.isNotBlank(param.getName()) && !"-1".equals(param.getName()))
            whereSql += " and a.project_type = '" + param.getName() + "'";
        String sql = "select a.id as projectId, a.project_name as projectName, a.start_date as projectStartDate, a.end_date " +
                "as projectEndDate, IF(a.project_type=1,'非书籍', '书籍') as projectType," +
                "a.customer_name as customerName, a.language_from as languageFrom, a.language_to " +
                "as languageTo, a.words_count as wordsCount, a.review_words_count as reviewWordsCount, a.words_no_space " +
                "as wordsNoSpace, a.remarks as projectRemarks, IF(b.part_type=1,'初译', '审校') as partType," +
                "b.part_name as partName, c.name as translatorName, b.salary_std as partSalaryStd," +
                "b.salary_real as partSalaryReal, b.words_num as wordsNum, b.start_date as " +
                "partStartDate, b.end_date as partEndDate, b.comment as comment, IF(b.status=1, '是','否') as status," +
                "b.settle_date as settleDate, d.words_count as adminWordsCount, d.review_words_count as adminReviewWordsCount," +
                "d.charge_std as chargeStd, d.project_income as projectIncome, d.tran_cost as tranCost, d.review_cost " +
                "as reviewCost, d.manage_cost as manageCost, d.sale_commission as saleComm, d.sale_record as saleRecord, " +
                "d.tax_cost as taxCost, d.project_profit as projectProfit, d.profit_ratio as profitRatio, IF(d.account_status" +
                "=1, '是','否') as accountStatus,  d.end_date as adminEndDate "+
                " from w_project a left join w_project_part b on a.id = b.project_id left join w_translators c " +
                "on b.translator_id = c.id left join w_project_admin d on a.id=d.project_id " +
                whereSql + "order by a.end_date desc, a.id desc";
        RowMapper<AdminExportVO> rm = ParameterizedBeanPropertyRowMapper.newInstance(AdminExportVO.class);
        return this.jdbcTemplate.query(sql, rm);
    }

    public List<TranslatorVO> filterTransByProject(ProjectVO pVO){
        String whereSql = "";
        if(!"-1".equals(pVO.getCustomerName())){
            whereSql += " and c.customer_name like '%"+pVO.getCustomerName()+"%' ";
        }
        if(!"-1".equals(pVO.getRemarks())){
            whereSql += " and a.level = "+pVO.getRemarks();
        }
        if(StringUtils.isNotBlank(pVO.getTemp())){
            whereSql += " and a.name like '%" + pVO.getTemp() + "%' ";
        }
        String sql = "select a.name as name, a.work_experience as workExperience, a.spare_days_str as spareDayStr," +
                "a.remarks as remarks, a.salary as salary, a.id as id " +
                "  from w_translators a left join w_project_part b on a.id = b.translator_id left join " +
                "w_project c on c.id = b.project_id where a.status = 1 and a.language_list like '%"+
                pVO.getLanguageFrom()+"-"+ pVO.getLanguageTo()+"%' "+whereSql+" group by a.id order by a.part_num desc";
        RowMapper<TranslatorVO> rm = ParameterizedBeanPropertyRowMapper.newInstance(TranslatorVO.class);
        return this.jdbcTemplate.query(sql, rm);
    }

    public void updateTransField(){
        String sql = "select work_experience, skillful_field, id from w_translators";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for(Map<String, Object> item : list){
            String newRemarks = "背景:" + item.get("work_experience") + "。擅长领域:" + item.get("skillful_field");
            String uSql = "update w_translators set remarks = '"+newRemarks+
                    "' where id = '"+item.get("id").toString()+"'";
            jdbcTemplate.update(uSql);
        }
    }
}
