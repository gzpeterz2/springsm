package com.hc.ssm.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.hc.ssm.po.User;

/**
 * 
* @Title: UserDaoImpl.java
* @ClassName: UserDaoImpl 
* @Description: 功能是 student dao 的实现
* @author 海辰 张文   
* @date 2017年10月29日 下午7:06:17
* @version V1.0
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	
	public User selectById(Integer id) throws SQLException {
		User user = null;
		SqlSession sqlSession = this.getSqlSession();

		//第一个参数 是  namespace +  statementID
		//第二个参数  就是 我们的 输入参数
		user = sqlSession.selectOne("test.selectById", id);
		return user;
	}

	public boolean insert(User entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(User entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}



	public List<User> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> selectByName() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
