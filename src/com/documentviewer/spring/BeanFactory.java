package com.documentviewer.spring;

public class BeanFactory {

	public static Object getBean(String beanName) throws Exception {
		return SpringContext.INSTANCE.getSpringContextInstance().getBean(
				beanName);
	}
}
