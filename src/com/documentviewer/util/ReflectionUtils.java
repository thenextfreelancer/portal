package com.documentviewer.util;

import java.util.Set;

import javax.persistence.Entity;

import org.reflections.Reflections;

import com.documentviewer.config.PropertiesConfig;
import com.documentviewer.config.PropertiesConstant;

public class ReflectionUtils {

	public static Set<Class<?>> getJPAEntityAnnotatedClasses() throws Exception {
		return getAnnotatedClasses(Entity.class, PropertiesConfig.getString(PropertiesConstant.APP_BASE_PACKAGE));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set<Class<?>> getAnnotatedClasses(Class clazz, String basePackage) throws Exception {
		Reflections reflections = new Reflections(basePackage);
		Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(clazz);
		return annotated;
	}

}
