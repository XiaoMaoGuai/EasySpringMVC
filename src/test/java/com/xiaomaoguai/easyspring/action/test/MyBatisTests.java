package com.xiaomaoguai.easyspring.action.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/*
 * @Description :
 * @FileName: MyBatisTests.java
 * @Author :WeiHui.Zhang
 * @Data : 2014年11月9日 下午4:15:54
 * @Version:1.0.0
 */
public class MyBatisTests {

	private static final Logger LOG = LoggerFactory.getLogger(MyBatisTests.class);
	
	@Test
	public void  config() throws Exception{
		ApplicationContext aContext = new FileSystemXmlApplicationContext("src/main/resources/META-INF/beans/spring-mybatis.xml");
		Object bean = aContext.getBean("sqlSessionFactory");
		LOG.info(bean.toString());
	}
}
