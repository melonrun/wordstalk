package com.wordstalk.translate.common.dao;

import com.wordstalk.translate.common.vo.CustomerProjectVO;
import com.wordstalk.translate.common.vo.CustomerVO;
import com.wordstalk.translate.common.vo.param.PageParam;
import com.wordstalk.translate.datasource.annotation.Mapper;

import java.util.List;

/**
 * Created by y on 2017/8/15.
 */

@Mapper
public interface CustomerDao {

    List<CustomerVO> getCustomerList(PageParam param);

    List<CustomerVO> getAllCustomerList(PageParam param);

    List<CustomerVO> getCustomerDetail(CustomerVO vo);

    Integer querySumOfCustomer(PageParam param);

    void insertCustomerVO(CustomerVO vo);

    void updateCustomerVO(CustomerVO vo);

    List<CustomerProjectVO> getProjectListByCustomer(CustomerVO vo);
}
