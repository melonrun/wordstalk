package com.wordstalk.translate.common.service;

import java.util.List;

import com.wordstalk.translate.common.dao.ProjectAdminDetailDao;
import com.wordstalk.translate.common.dao.ProjectPartDao;
import com.wordstalk.translate.common.vo.ProjectPartVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wordstalk.translate.common.dao.ProjectAdminDao;
import com.wordstalk.translate.common.dao.ProjectDao;
import com.wordstalk.translate.common.vo.ProjectAdminVO;
import com.wordstalk.translate.common.vo.ProjectVO;

@Service("projectAdminService")
public class ProjectAdminService {

	private final static Logger logger = LoggerFactory.getLogger(ProjectAdminService.class);

	@Autowired
	private ProjectAdminDao projectAdminDao;

	@Autowired
	private ProjectPartDao projectPartDao;
	
	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private ProjectAdminDetailDao projectAdminDetailDao;

    public Double querAllTransCost(ProjectVO vo){
        try{
            return projectAdminDao.querTransCost(vo);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return 0.0;
    }

	public boolean saveProjectAdmin(ProjectAdminVO vo){
		try{
			if("".equals(vo.getEndDate()))
				vo.setEndDate(null);
			if(this.isProjectAdminExists(vo)){
				this.projectAdminDao.saveProjectAdmin(vo);
				this.projectPartDao.updatePmCheckout(vo);
			}else{
				this.projectAdminDao.insertProjectAdmin(vo);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return true;
	}
	
	private boolean isProjectAdminExists(ProjectAdminVO vo){
		ProjectAdminVO pVo = this.projectAdminDao.getProjectAdminUseId(vo);
		if(pVo == null)
			return false;
		return true;
	}

	public ProjectVO getProjectDetail(ProjectVO vo) {
		try{
			ProjectVO projectVO = this.projectDao.getProjectDetail(vo);
			return projectVO;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return null;
	}

    /**
     * 译员稿费List
     * @param vo
     * @return
     */
	public List<ProjectPartVO> querTransCost(ProjectVO vo) {
		try{
			return this.projectAdminDetailDao.queryAllProjectPartList(vo);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return null;
	}

    /**
     * 审校费用List
     * @param vo
     * @return
     */
    public List<ProjectPartVO> queryReviewCost(ProjectVO vo){
        try{
            return this.projectAdminDetailDao.queryAllProjectReviewPartList(vo);
        }catch(Exception e){
            logger.error(e.getMessage(), e);
        }
        return null;
    }
	
	public Long queryWordsNum(ProjectVO vo) {
		try{
			return this.projectAdminDao.queryWordsNum(vo);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public ProjectAdminVO getProjectAdminDetail(ProjectAdminVO vo) {
		try{
			ProjectAdminVO adminVo = this.projectAdminDao.getProjectAdminUseId(vo);
			return adminVo;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public List<ProjectAdminVO> exportAllProjectAdminList() {
		try{
			return this.projectAdminDao.exportAllProjectAdminList();
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return null;
	}
}
