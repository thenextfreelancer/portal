package com.documentviewer.util;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang.exception.ExceptionUtils;

public class ExceptionUtil {

	public static WebApplicationException throwWebApplicationException(Exception e) {
		return new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(ExceptionUtils.getRootCauseMessage(e)).type(MediaType.TEXT_PLAIN_TYPE).build());
	}

	public static WebApplicationException throwWebApplicationException() {
		return new WebApplicationException(Status.NOT_FOUND);
	}

	public static WebApplicationException throwUnauthorizedException() {
		return new WebApplicationException(Status.UNAUTHORIZED);
	}

	public static RuntimeException methodNotSupportedException() {
		return new RuntimeException("Method not supported");
	}

}
