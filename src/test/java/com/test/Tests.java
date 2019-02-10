package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.test.entity.User;
import com.test.util.MyFreemarkerUtil;

public class Tests {
	
	private MyFreemarkerUtil myFreemarkerUtil;

	@Before
	public void before() throws Exception {
		myFreemarkerUtil = new MyFreemarkerUtil();
		myFreemarkerUtil.init("src/main/webapp/WEB-INF/templates");
	}
	
	@Test
	public void test01() throws Exception {
		List<User> userList = new ArrayList<>();
		userList.add(new User(1, "a"));
		userList.add(new User(2, "b"));
		
		Map<String, Object> map = new HashMap<>();
		map.put("message", "helloworld");
		map.put("userList", userList);
		
		myFreemarkerUtil.write("index.html", map);
	}
	
}
