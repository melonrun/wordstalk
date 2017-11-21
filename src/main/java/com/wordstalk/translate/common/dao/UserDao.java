package com.wordstalk.translate.common.dao;

import java.util.List;

import com.wordstalk.translate.common.vo.RoleVO;
import com.wordstalk.translate.common.vo.UserVO;
import com.wordstalk.translate.datasource.annotation.Mapper;

@Mapper
public interface UserDao {
	
	public UserVO queryUserByNameAndPass(UserVO vo);

	public List<RoleVO> queryUserRoleById(UserVO vo);
}
