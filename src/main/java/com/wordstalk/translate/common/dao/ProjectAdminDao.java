package com.wordstalk.translate.common.dao;

import java.util.List;

import com.wordstalk.translate.common.vo.ProjectAdminVO;
import com.wordstalk.translate.common.vo.ProjectVO;
import com.wordstalk.translate.datasource.annotation.Mapper;

@Mapper
public interface ProjectAdminDao {
	
	public ProjectAdminVO getProjectAdminUseId(ProjectAdminVO vo);

	public void saveProjectAdmin(ProjectAdminVO vo);

	public void insertProjectAdmin(ProjectAdminVO vo);

	public Double querTransCost(ProjectVO vo);
	
	public Long queryWordsNum(ProjectVO vo);

	public List<ProjectAdminVO> exportAllProjectAdminList();

}
