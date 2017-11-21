package com.wordstalk.translate.common.dao;

import java.util.List;

import com.wordstalk.translate.common.vo.ProjectAdminVO;
import com.wordstalk.translate.common.vo.ProjectPartVO;
import com.wordstalk.translate.common.vo.ProjectVO;
import com.wordstalk.translate.common.vo.TranslatorVO;
import com.wordstalk.translate.common.vo.param.PageParam;
import com.wordstalk.translate.datasource.annotation.Mapper;

@Mapper
public interface ProjectPartDao {

	public void addProjectPartSubmit(ProjectPartVO vo);

	public void updateProjectPartSubmit(ProjectPartVO vo);

	public List<ProjectVO> queryProjectPartList(PageParam param);

	Integer querySumOfProjectPart(PageParam param);

	ProjectPartVO getProjectPartDetail(ProjectPartVO vo);

	List<ProjectPartVO>   getProjectPartByTid(PageParam param);

	Integer querySumOfProjectPartByTid(PageParam param);

	Integer queryProjectWordsNum(ProjectPartVO vo);

	List<ProjectPartVO> getAllProjectPartByTid(TranslatorVO vo);

	List<ProjectPartVO> exportAllProjectPartList(ProjectVO vo);

	void updatePartSettleStatus(ProjectPartVO vo);

	void updatePmCheckout(ProjectAdminVO vo);

	void deleteProjectPart(ProjectPartVO vo);

	Double queryTransAllCost(ProjectVO vo);

	void updatePmCheckoutById(ProjectPartVO vo);
}
