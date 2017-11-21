package com.wordstalk.translate.common.dao;

import java.util.List;

import com.wordstalk.translate.common.vo.ProjectPartVO;
import com.wordstalk.translate.common.vo.ProjectVO;
import com.wordstalk.translate.common.vo.TranslatorVO;
import com.wordstalk.translate.common.vo.param.PageParam;
import com.wordstalk.translate.datasource.annotation.Mapper;

@Mapper
public interface TranslatorDao {
	
	public List<TranslatorVO> queryTranslatorList(PageParam param);
	
	public List<TranslatorVO> queryAllTranslator();
	
	public Integer querySumOfTranslator(PageParam param);

	public void saveTranslator(TranslatorVO vo);

	public TranslatorVO getTranslatorDetail(TranslatorVO vo);

	void updateTranslator(TranslatorVO vo);

	void updateTranslatorScore(TranslatorVO vo);

	void updatePartNumByTId(ProjectPartVO vo);
}
