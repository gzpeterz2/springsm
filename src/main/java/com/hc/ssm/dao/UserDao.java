package com.hc.ssm.dao;

import java.sql.SQLException;
import java.util.List;

import com.hc.ssm.po.User;

/**
 * 
* @Title: UserDao.java
* @ClassName: UserDao 
* @Description: 功能是 User 的 Interface
* @author 海辰 张文   
* @date 2017年10月29日 下午6:57:58
* @version V1.0
 */
public interface UserDao {
	public List<User> selectList() throws SQLException;
	public boolean insert(User student) throws SQLException;
	public boolean update(User entity) throws SQLException;
	public boolean deleteById(Integer id) throws SQLException;
	public User selectById(Integer id) throws SQLException;
}
