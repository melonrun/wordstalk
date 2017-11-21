package com.wordstalk.translate.common.dao;

import com.wordstalk.translate.common.vo.OrganizationVO;
import com.wordstalk.translate.datasource.annotation.Mapper;

import java.util.List;

/**
 * Created by y on 2017/8/15.
 */

@Mapper
public interface OrganizationDao {

    List<OrganizationVO> queryOrganList();

    void addOrganization(OrganizationVO vo);

    void delOrganization(OrganizationVO vo);
}
