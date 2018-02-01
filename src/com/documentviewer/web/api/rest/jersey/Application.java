package com.documentviewer.web.api.rest.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.documentviewer.web.api.rest.exception.RestExceptionHandler;

public class Application extends ResourceConfig {
	/**
	 * Register JAX-RS application components.
	 */
	public Application() {
		packages("com.documentviewer.web.api.rest");
		register(RequestContextFilter.class);
		register(RestExceptionHandler.class);
	}
}