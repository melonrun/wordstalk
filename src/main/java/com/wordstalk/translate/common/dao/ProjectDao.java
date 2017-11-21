package com.wordstalk.translate.common.dao;

import java.util.List;

import com.wordstalk.translate.common.vo.CustomerVO;
import com.wordstalk.translate.common.vo.ProjectPartVO;
import com.wordstalk.translate.common.vo.ProjectVO;
import com.wordstalk.translate.common.vo.param.PageParam;
import com.wordstalk.translate.datasource.annotation.Mapper;

@Mapper
public interface ProjectDao {

	/* 已完成 */
	public List<ProjectVO> queryFinishProjectListPM(PageParam param);
 
	public Integer querySumOfFinishProjectPM(PageParam param);

    public List<ProjectVO> queryFinishProjectListAdmin(PageParam param);

    public Integer querySumOfFinishProjectAdmin(PageParam param);

	/* 全部项目 */
	public List<ProjectVO> queryAllProjectList(PageParam param);

	public Integer querySumOfAllProject(PageParam param);

	/* 正在进行 */
	public List<ProjectVO> queryProjectRuningListPM(PageParam param);

	public Integer querySumOfRunningProjectPM(PageParam param);

	/* 交稿未结算 */
	public List<ProjectVO> queryUnSettleProjectListPM(PageParam param);

	public Integer querySumOfUnSettleProjectPM(PageParam param);

    /* 未录入项目 */
    public List<ProjectVO> queryUnSaveProjectList(PageParam param);

    public Integer querySumOfUnSaveProject(PageParam param);

    public List<ProjectVO> queryUnSettleProjectListAdmin(PageParam param);

    public Integer querySumOfUnSettleProjectAdmin(PageParam param);

	public ProjectVO getProjectDetail(ProjectVO vo);

	public void addProjectSubmit(ProjectVO vo);

	public void updateTranslatorSubmit(ProjectVO vo);

	public void updateWordsNum(ProjectPartVO vo);

	public void updateReviewWordsNum(ProjectPartVO vo);

	public List<ProjectVO> exportAllProjectList();

    int getLastProjectId();
}
