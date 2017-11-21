package com.wordstalk.translate.common.dao;

import com.wordstalk.translate.common.vo.ProjectPartVO;
import com.wordstalk.translate.datasource.annotation.Mapper;

/**
 * Created by y on 16/11/9.
 */
@Mapper
public interface DelProjectDao {
    void saveDelProjectPart(ProjectPartVO vo);
}
