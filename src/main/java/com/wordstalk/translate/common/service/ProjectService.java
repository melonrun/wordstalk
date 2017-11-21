package com.wordstalk.translate.common.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.wordstalk.translate.common.dao.ExportProjectDao;
import com.wordstalk.translate.common.vo.TranslatorVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wordstalk.translate.common.dao.ProjectDao;
import com.wordstalk.translate.common.vo.ConstantsField;
import com.wordstalk.translate.common.vo.ProjectPartVO;
import com.wordstalk.translate.common.vo.ProjectVO;
import com.wordstalk.translate.common.vo.param.Page;
import com.wordstalk.translate.common.vo.param.PageParam;

@Service("projectService")
public class ProjectService {

	private final static Logger logger = LoggerFactory.getLogger(ProjectService.class);
	
	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private ExportProjectDao exportProjectDao;
	
	public Page queryProjectList(PageParam param, boolean isPM) {
		try{
			param.setOffset(0);/*根据page参数 设置offset值 具体见实现*/
			if(param.getStatus() == ConstantsField.PROJECT_ALL){/*查询全部项目*/
				List<ProjectVO> results = this.projectDao.queryAllProjectList(param);
				Integer dataSum = this.projectDao.querySumOfAllProject(param);
				Page page = Page.createPage(param.getPage(), dataSum, param.getRows(), results);
				return page;
			}else if(param.getStatus() == ConstantsField.PROJECT_RUNNING){/* 正在进行*/
					List<ProjectVO> results = this.projectDao.queryProjectRuningListPM(param);
					Integer dataSum = this.projectDao.querySumOfRunningProjectPM(param);
					Page page = Page.createPage(param.getPage(), dataSum, param.getRows(), results);
					return page;
			}else if(param.getStatus() == ConstantsField.PROJECT_FINISH){/* 已完成*/
				if(isPM) {
					List<ProjectVO> results = this.projectDao.queryFinishProjectListPM(param);
					Integer dataSum = this.projectDao.querySumOfFinishProjectPM(param);
					Page page = Page.createPage(param.getPage(), dataSum, param.getRows(), results);
					return page;
				} else {
                    List<ProjectVO> results = this.projectDao.queryFinishProjectListAdmin(param);
                    Integer dataSum = this.projectDao.querySumOfFinishProjectAdmin(param);
                    Page page = Page.createPage(param.getPage(), dataSum, param.getRows(), results);
                    return page;
                }
			}else if(param.getStatus() == ConstantsField.PROJECT_UNSETTLE){/* 查询项目到期 未结算的项目 */
				if(isPM) {
					List<ProjectVO> results = this.projectDao.queryUnSettleProjectListPM(param);
					Integer dataSum = this.projectDao.querySumOfUnSettleProjectPM(param);
					Page page = Page.createPage(param.getPage(), dataSum, param.getRows(), results);
					return page;
				} else {
                    List<ProjectVO> results = this.projectDao.queryUnSettleProjectListAdmin(param);
                    Integer dataSum = this.projectDao.querySumOfUnSettleProjectAdmin(param);
                    Page page = Page.createPage(param.getPage(), dataSum, param.getRows(), results);
                    return page;
                }
			}else if(param.getStatus() == ConstantsField.PROJECT_UNSAVE){/* 未录入项目*/
                List<ProjectVO> results = this.projectDao.queryUnSaveProjectList(param);
                Integer dataSum = this.projectDao.querySumOfUnSaveProject(param);
                Page page = Page.createPage(param.getPage(), dataSum, param.getRows(), results);
                return page;
            }
			
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public ProjectVO getProjectDetail(ProjectVO vo) {
		try{
			return projectDao.getProjectDetail(vo);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public boolean addProjectSubmit(ProjectVO vo) {
		try{
			projectDao.addProjectSubmit(vo);
			return true;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return false;
	}

	public boolean updateTranslatorSubmit(ProjectVO vo) {
		try{
			projectDao.updateTranslatorSubmit(vo);
			return true;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return false;
		
	}

	public void updateWordsNum(ProjectPartVO vo) {
		try{
			projectDao.updateWordsNum(vo);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
	}

	public void updateReviewWordsNum(ProjectPartVO vo){
		try{
			projectDao.updateReviewWordsNum(vo);
		}catch (Exception e){
			logger.error(e.getMessage(), e);
		}
	}

	public List<ProjectVO> exportAllProjectList() {
		try{
			return projectDao.exportAllProjectList();
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public List<String> getAllCustomerName(){
		List<ProjectVO> list = projectDao.exportAllProjectList();
		Set<String> set = new HashSet<String>();
 		if(list.size() > 0){
			for(ProjectVO vo : list){
				set.add(vo.getCustomerName());
			}

		}
		return new ArrayList<>(set);
	}

	/**
	 * 根据项目信息筛选译员
	 * @param vo
	 * @return
	 */
	public List<TranslatorVO> filterTransByProject(ProjectVO vo){
		ProjectVO pVO = projectDao.getProjectDetail(vo);
		vo.setLanguageFrom(pVO.getLanguageFrom());
		vo.setLanguageTo(pVO.getLanguageTo());

		List<TranslatorVO> list = exportProjectDao.filterTransByProject(vo);
		return list;
	}

	public Integer getLastProjectId(){
        return projectDao.getLastProjectId();
    }
}
