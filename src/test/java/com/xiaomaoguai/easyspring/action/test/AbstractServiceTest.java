package com.xiaomaoguai.easyspring.action.test;

import org.apache.log4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/*
 * @Description :
 * @FileName: AbstractServiceTest.java
 * @Author :WeiHui.Zhang
 * @Data : 2014年11月10日 下午12:50:32
 * @Version:1.0.0
 */
@ContextConfiguration(locations = { "classpath*:META-INF/beans/spring-mybatis.xml" })
public class AbstractServiceTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	protected final static Logger logger = Logger.getLogger(AbstractServiceTest.class);
}
