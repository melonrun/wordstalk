package com.wordstalk.translate.common.dao;

import java.util.List;
import com.wordstalk.translate.common.vo.ProjectPartVO;
import com.wordstalk.translate.common.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by y on 16/10/3.
 */
@Repository
public class ProjectAdminDetailDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProjectPartVO> queryAllProjectPartList(ProjectVO vo){
        String sql = "select a.*, b.name as translator_name from w_project_part a left join w_translators b " +
                "on a.translator_id=b.id where a.project_id = ? and a.part_type = 1";
        RowMapper<ProjectPartVO> rm = ParameterizedBeanPropertyRowMapper.newInstance(ProjectPartVO.class);
        return this.jdbcTemplate.query(sql, rm, new Object[]{vo.getId()});
    }

    public List<ProjectPartVO> queryAllProjectReviewPartList(ProjectVO vo){
        String sql = "select a.*, b.name as translator_name from w_project_part a left join w_translators b " +
                "on a.translator_id=b.id where a.project_id = ? and a.part_type = 2";
        RowMapper<ProjectPartVO> rm = ParameterizedBeanPropertyRowMapper.newInstance(ProjectPartVO.class);
        return this.jdbcTemplate.query(sql, rm, new Object[]{vo.getId()});
    }
}
