package com.wordstalk.translate.common.service;

import com.wordstalk.translate.common.dao.CustomerDao;
import com.wordstalk.translate.common.dao.ProjectDao;
import com.wordstalk.translate.common.dao.UserDao;
import com.wordstalk.translate.common.util.MD5Utils;
import com.wordstalk.translate.common.vo.*;
import com.wordstalk.translate.common.vo.param.Page;
import com.wordstalk.translate.common.vo.param.PageParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

    private final static Logger logger = LoggerFactory.getLogger(CustomerService.class);


	public Page getCustomerList(PageParam param){
		try{
            param.setOffset(0);
            List<CustomerVO> results = this.customerDao.getCustomerList(param);
            Integer dataSum = this.customerDao.querySumOfCustomer(param);
            Page page = Page.createPage(param.getPage(), dataSum, param.getRows(), results);
            return page;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return null;
	}

    public List<CustomerVO> getAllCustomerList(PageParam param){
        try{
            List<CustomerVO> results = this.customerDao.getAllCustomerList(param);
            return results;
        }catch(Exception e){
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public List<CustomerVO> getCustomerDetail(CustomerVO vo){
        try{
            List<CustomerVO> results = this.customerDao.getCustomerDetail(vo);
            return results;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public boolean updateCustomerSubmit(CustomerVO vo) {
        try{
            if(vo.getId() == null || vo.getId().equals(new Integer("-1")))
                customerDao.insertCustomerVO(vo);
            else
                customerDao.updateCustomerVO(vo);
            return true;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return false;
    }


    public List<CustomerProjectVO> getProjectListByCustomer(CustomerVO vo) {
        try{
            List<CustomerProjectVO> results = this.customerDao.getProjectListByCustomer(vo);
            return results;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
