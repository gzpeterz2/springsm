package com.hc.ssm.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hc.ssm.po.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-dao.xml")
public class UserMapperTest {
	@Autowired
	private UserMapper mapper;

	@Test
	public void testSelectByPrimaryKey() {
		User user = mapper.selectByPrimaryKey(40);
		int id = user.getId();
		assertEquals(40, id);
		System.out.println(user);
	}

}
