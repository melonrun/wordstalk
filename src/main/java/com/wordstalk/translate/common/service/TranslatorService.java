package com.wordstalk.translate.common.service;

import java.util.List;

import com.wordstalk.translate.common.util.DateUtils;
import com.wordstalk.translate.common.vo.ProjectPartVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wordstalk.translate.common.dao.TranslatorDao;
import com.wordstalk.translate.common.vo.ConstantsField;
import com.wordstalk.translate.common.vo.TranslatorVO;
import com.wordstalk.translate.common.vo.param.Page;
import com.wordstalk.translate.common.vo.param.PageParam;


@Service("translatorService")
public class TranslatorService {
	
	private final static Logger logger = LoggerFactory.getLogger(TranslatorService.class);
	
	@Autowired
	private TranslatorDao translatorDao;

	/**
	 * 导出全部
	 * @param param
	 * @return
	 */
	public List<TranslatorVO> queryTranslatorList(PageParam param){
		try{
			List<TranslatorVO> results = this.translatorDao.queryAllTranslator();
			for(TranslatorVO vo : results){
				vo.setLevelStr(ConstantsField.levelMap.get(vo.getLevel()));
			}
			return results;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	public Page queryTranslator(PageParam param){
		try{
			param.setOffset(0);
			if("-1".equals(param.getContractEndDate()))
				param.setContractEndDate(null);
			else if("1".equals(param.getContractEndDate()))//已经到期
				param.setContractEndDate(DateUtils.getCurrentDate("yyyy-MM-dd"));
			else if("2".equals(param.getContractEndDate())){
				param.setContractEndDate(null);
			}
			if("-1".equals(param.getLanguageFrom()) || "-1".equals(param.getLanguageTo())){
				param.setLanguageFrom(null);
			}else
				param.setLanguageFrom(param.getLanguageFrom()+"-"+param.getLanguageTo());

			List<TranslatorVO> results = this.translatorDao.queryTranslatorList(param);
			Integer dataSum = this.translatorDao.querySumOfTranslator(param);
			Page page = Page.createPage(param.getPage(), dataSum, param.getRows(), results);
			return page;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	public boolean saveTranslator(TranslatorVO vo){
		try{
			translatorDao.saveTranslator(vo);
			return true;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return false;
	}

	public TranslatorVO getTranslatorDetail(TranslatorVO vo) {
		try{
			return translatorDao.getTranslatorDetail(vo);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public boolean updateTranslator(TranslatorVO vo) {
		try{
			translatorDao.updateTranslator(vo);
			return true;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return false;
	}

	public boolean updateTranslatorScore(TranslatorVO vo){
		try{
			translatorDao.updateTranslatorScore(vo);
		}catch (Exception e){
			logger.error(e.getMessage(), e);
		}
		return false;
	}

	public void updatePartNumByTId(ProjectPartVO vo){
		try{
			translatorDao.updatePartNumByTId(vo);
		}catch (Exception e){
			logger.error(e.getMessage(), e);
		}
	}
}
