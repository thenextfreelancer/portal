package com.documentviewer.web.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.documentviewer.util.ExceptionUtil;

public interface RestProvider<T> {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public default Response createEntity(T t) {
		throw ExceptionUtil.throwWebApplicationException();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public default Response updateEntity(T t) {
		throw ExceptionUtil.throwWebApplicationException();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public default Response deleteEntity(T t) {
		throw ExceptionUtil.throwWebApplicationException();
	}

	@GET
	@Path("/id:[0-9]")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public default Response getEntity(@PathParam("id") Long id) {
		throw ExceptionUtil.throwWebApplicationException();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public default Response getEntities(@Context UriInfo uriInfo, @Context HttpHeaders header) {
		throw ExceptionUtil.throwWebApplicationException();
	}

}
