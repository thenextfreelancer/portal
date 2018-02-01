package com.documentviewer.util;

import java.io.StringWriter;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApplicationUtils {

	private static String applicationContextPath = null;

	public static String getContextPath() {
		return applicationContextPath;
	}

	public static String serialize(Object obj, Map<Class<?>, Class<?>> mixinConfig) throws Exception {
		StringWriter writer = new StringWriter();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);
		mapper.setSerializationInclusion(Include.NON_NULL);
		if (null != mixinConfig && !mixinConfig.isEmpty()) {
			mapper.setMixIns(mixinConfig);
		}
		mapper.writeValue(writer, obj);
		return writer.toString();
	}

	public static String serialize(Object obj) throws Exception {
		return serialize(obj, null);
	}

	public static void setContextPath(String contextPath) {
		applicationContextPath = contextPath;

	}
}
