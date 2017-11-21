package com.wordstalk.translate.common.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import com.wordstalk.translate.common.dao.DelProjectDao;
import com.wordstalk.translate.common.util.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wordstalk.translate.common.dao.ProjectPartDao;
import com.wordstalk.translate.common.vo.ProjectPartVO;
import com.wordstalk.translate.common.vo.ProjectVO;
import com.wordstalk.translate.common.vo.TranslatorVO;
import com.wordstalk.translate.common.vo.param.Page;
import com.wordstalk.translate.common.vo.param.PageParam;

@Service("projectPartService")
public class ProjectPartService {

    private final static Logger logger = LoggerFactory.getLogger(ProjectPartService.class);

    @Autowired
    private ProjectPartDao projectPartDao;

    @Autowired
    private DelProjectDao delProjectDao;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TranslatorService translatorService;

    public boolean addProjectPartSubmit(ProjectPartVO vo) {
        try{
            if(vo.getId() == -1){
				/*插入数据*/
                projectPartDao.addProjectPartSubmit(vo);
            }else{
				/*更新*/
                ProjectPartVO pVo = this.getProjectPartDetail(vo);
                if("-1".equals(pVo.getPmCheckout())){
                    projectPartDao.updateProjectPartSubmit(vo);
                }else{
                    projectPartDao.updatePartSettleStatus(vo);
                }
            }
            /* 更新译员打分情况*/
            TranslatorVO tVo = new TranslatorVO();
            tVo.setId(Integer.valueOf(vo.getTranslatorId()));
            List<ProjectPartVO> pList = projectPartDao.getAllProjectPartByTid(tVo);
            double sum = 0.0;
            for(ProjectPartVO projectPartVO : pList)
                if(projectPartVO.getScoreAvg() != null)
                    sum += projectPartVO.getScoreAvg();
            Double scoreAvg = new BigDecimal(sum/pList.size()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            Integer level = 1;
            if(scoreAvg < 6.0)
                level = 2;
            else if(scoreAvg >= 6.0 && scoreAvg < 8.0)
                level = 3;
            else if(scoreAvg >= 8.0)
                level = 4;
            tVo.setLevel(level);
            tVo.setScoreAvg(scoreAvg);
            translatorService.updateTranslatorScore(tVo);

            this.updateWordsNumPartNum(vo);
            return true;
        }catch(Exception e){
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    private void updateWordsNumPartNum(ProjectPartVO vo){
		/* 更新项目的 总字数 分为初译和审校两部分*/
        Integer wordsNum = 0, reviewWordsNum = 0;
        if(vo.getPartType() == 1){
            wordsNum = projectPartDao.queryProjectWordsNum(vo);
            vo.setPartType(2);
            reviewWordsNum = projectPartDao.queryProjectWordsNum(vo);
        }else if(vo.getPartType() == 2){
            reviewWordsNum = projectPartDao.queryProjectWordsNum(vo);
            vo.setPartType(1);
            wordsNum = projectPartDao.queryProjectWordsNum(vo);
        }
            /* 保存初译字数*/
        vo.setWordsNum(wordsNum);
        projectService.updateWordsNum(vo);

            /* 保存审校字数*/
        vo.setWordsNum(reviewWordsNum);
        projectService.updateReviewWordsNum(vo);

            /* 更新译员区块数目*/
        translatorService.updatePartNumByTId(vo);
    }

    public Page getProjectPartList(PageParam param, ProjectPartVO vo) {
        try{
            if(vo.getProjectId() == null || vo.getProjectId() <= 0)
                return null;
            param.setOffset(0);/*根据page参数 设置offset值 具体见实现*/
            param.setProjectId(vo.getProjectId());
            List<ProjectVO> results = this.projectPartDao.queryProjectPartList(param);
            Integer dataSum = this.projectPartDao.querySumOfProjectPart(param);
            Page page = Page.createPage(param.getPage(), dataSum, param.getRows(), results);
            return page;
        }catch(Exception e){
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public ProjectPartVO getProjectPartDetail(ProjectPartVO vo) {
        try{
            if(vo.getId() == null || vo.getId() <= 0)
                return null;
            return projectPartDao.getProjectPartDetail(vo);
        }catch(Exception e){
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public Page getProjectPartByTid(PageParam param) {
        try{
            if(!StringUtils.isNotBlank(param.getSearchKey()))
                return null;
            param.setOffset(0);/*根据page参数 设置offset值 具体见实现*/
            List<ProjectPartVO> results = projectPartDao.getProjectPartByTid(param);

            Integer dataSum = this.projectPartDao.querySumOfProjectPartByTid(param);
            Page page = Page.createPage(param.getPage(), dataSum, param.getRows(), results);

            return page;
        }catch(Exception e){
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 更新区块PM结算状态
     * @param vo
     * @return
     */
    public boolean updatePartPmCheckout(ProjectPartVO vo){
        try{
            if(vo.getId() > 0){
                this.projectPartDao.updatePmCheckoutById(vo);
                return true;
            }
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 更新区块结算状态
     * @param vo
     * @return
     */
    public boolean updatePartSettleStatus(ProjectPartVO vo){
        try{
            if(vo.getId() > 0){
                ProjectPartVO pVo = this.projectPartDao.getProjectPartDetail(vo);
                if(!"-1".equals(pVo.getPmCheckout()) ){
                    if(vo.getStatus() == 1){
                        vo.setSettleDate(DateUtils.getCurDayDate());
                    }else if(vo.getStatus() == -1){
                        vo.setSettleDate("");
                    }
                    this.projectPartDao.updatePartSettleStatus(vo);
                    return true;
                }
            }
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 删除区块
     * @param vo
     * @return
     */
    public boolean deleteProjectPart(ProjectPartVO vo){
        try{
            ProjectPartVO pVo = this.getProjectPartDetail(vo);
            projectPartDao.deleteProjectPart(vo);

            delProjectDao.saveDelProjectPart(pVo);

            this.updateWordsNumPartNum(pVo);
            return true;
        }catch(Exception e){
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    public List<ProjectPartVO> getAllProjectPartByTid(TranslatorVO vo) {
        try{
            if(vo.getId() == null || vo.getId() < 0)
                return null;
            List<ProjectPartVO> list = projectPartDao.getAllProjectPartByTid(vo);
            return list;
        }catch(Exception e){
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public List<ProjectPartVO> exportAllProjectPartList(ProjectVO vo) {
        try{
            if(vo.getId() == null || vo.getId() < 0)
                return null;
            List<ProjectPartVO> list = projectPartDao.exportAllProjectPartList(vo);
            return list;
        }catch(Exception e){
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public Double queryAllTransCost(ProjectVO vo){
        try{
            return projectPartDao.queryTransAllCost(vo);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return 0.0;
    }

}
