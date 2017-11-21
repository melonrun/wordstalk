package com.wordstalk.translate.common.service;

import com.wordstalk.translate.common.dao.CustomerDao;
import com.wordstalk.translate.common.dao.OrganizationDao;
import com.wordstalk.translate.common.vo.CustomerVO;
import com.wordstalk.translate.common.vo.OrganizationVO;
import com.wordstalk.translate.common.vo.param.Page;
import com.wordstalk.translate.common.vo.param.PageParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("organizationService")
public class OrganizationService {

    @Autowired
    private OrganizationDao organizationDao;

    private final static Logger logger = LoggerFactory.getLogger(OrganizationService.class);


    public Page getOrganList(PageParam param){
        try{
            List<OrganizationVO> results = this.organizationDao.queryOrganList();
            Integer dataSum = results.size();
            Page page = Page.createPage(param.getPage(), dataSum, param.getRows(), results);
            return page;
        }catch(Exception e){
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public boolean addOrganization(OrganizationVO vo){
        try{
            organizationDao.addOrganization(vo);
            return true;
        }catch(Exception e){
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    public boolean delOrganization(OrganizationVO vo){
        try{
            organizationDao.delOrganization(vo);
            return true;
        }catch(Exception e){
            logger.error(e.getMessage(), e);
        }
        return false;
    }
}
