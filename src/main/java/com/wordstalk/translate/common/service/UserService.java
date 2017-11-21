package com.wordstalk.translate.common.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wordstalk.translate.common.dao.UserDao;
import com.wordstalk.translate.common.util.MD5Utils;
import com.wordstalk.translate.common.vo.RoleVO;
import com.wordstalk.translate.common.vo.UserVO;

@Service("userService")
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public UserVO queryUserByNameAndPass(UserVO vo) {
		if(StringUtils.isNotBlank(vo.getUserName()) && 
				StringUtils.isNotBlank(vo.getUserPass())){
			vo.setUserPass(MD5Utils.md5(vo.getUserPass()));
			return userDao.queryUserByNameAndPass(vo);
		}
		return null;
	}
	
	public List<RoleVO> queryUserRoleById(UserVO vo){
		if(vo.getId() > 0){
			return userDao.queryUserRoleById(vo);
		}
		return null;
	}
}
