package com.hc.smm.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hc.ssm.po.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-dao.xml")
public class UserDaoImplTest {
	
	@Autowired
	private UserDao userDao;

	@Test
	public void testSelectById() {
		try {
			User user = userDao.selectById(40);
			assertEquals(40, (int)user.getId());
			System.out.println(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
