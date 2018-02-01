package com.documentviewer.web.api.rest.impl;

import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.internal.util.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.documentviewer.entity.impl.Role;
import com.documentviewer.entity.impl.User;
import com.documentviewer.service.impl.UserService;
import com.documentviewer.util.ApplicationUtils;
import com.documentviewer.util.ExceptionUtil;
import com.documentviewer.web.api.rest.RestProvider;

@Component
@Path("users")
@PermitAll
public class UserRestProcessor  { //implements RestProvider<User>

	@Autowired
	UserService userService;
	private static final String AUTHENTICATION_SCHEME = "Basic";

	//@Override
	//@RolesAllowed(Role.ADMIN_ROLE)
	@PermitAll
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getEntities(@Context UriInfo uriInfo, @Context HttpHeaders header) {
		String reponse = "";
		try {
			reponse = ApplicationUtils.serialize("{true2}");
		} catch (Exception e) {
			ExceptionUtil.throwWebApplicationException(e);
		}
		return Response.ok(reponse).build();
	}
	
	//@Override
	//@RolesAllowed(Role.ADMIN_ROLE)
	@PermitAll
	@GET
	@Path("/id:[0-9]")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getEntity(@PathParam("id") Long id) {
		String reponse = "";
		try {
			System.out.println("getEntity");
		} catch (Exception e) {
			ExceptionUtil.throwWebApplicationException(e);
		}
		return Response.ok(reponse).build();
	}

	//@Override
	@PermitAll
	@Path("register")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createEntity(User user) {
		String response = "";
		try {
			Long id = userService.createEntity(user);
			user.setId(id);
			response = ApplicationUtils.serialize(user);
		} catch (Exception e) {
			ExceptionUtil.throwWebApplicationException(e);
		}
		return Response.ok(response).build();
	}
	
	//@Override
	@PermitAll
	@Path("delete")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEntity(User user) {
		String reponse = "";
		try {
			System.out.println("delete");
		} catch (Exception e) {
			ExceptionUtil.throwWebApplicationException(e);
		}
		return Response.ok(reponse).build();
	}

	//@Override
	@PermitAll
	@Path("update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEntity(User user) {
		String reponse = "";
		try {
			System.out.println("update");
		} catch (Exception e) {
			ExceptionUtil.throwWebApplicationException(e);
		}
		return Response.ok(reponse).build();
	}
	
	@POST
	@Path("login")
	@PermitAll
	//@RolesAllowed({Role.ADMIN_ROLE,Role.COMPANY_ROLE,Role.CONSULTANT_ROLE,Role.TALENT_ROLE})
	public Response login(@HeaderParam("Authorization") List<String> authorization) {
		String response = null;
		if (authorization != null) {
			try {
				
				String encodedUserPassword = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");
				String usernameAndPassword = new String(Base64.decode(encodedUserPassword.getBytes()));
				// Split username and password tokens
				final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
				final String username = tokenizer.nextToken();
				final String password = tokenizer.nextToken();
				User user = userService.findUserByUserName(username);
				
				if (user != null && user.getPassword().equals(password)) {
//					String authorizationHeaderForCurrentUser = new String(
//							Base64.encode((username + ":" + password).getBytes()));
					user.setAuthorizationToken(encodedUserPassword);
					user.setPassword(null);
					response = ApplicationUtils.serialize(user);
				} else {
					throw ExceptionUtil.throwUnauthorizedException();
				}
			} catch (Exception e) {
				throw ExceptionUtil.throwWebApplicationException(e);
			}
		} else {
			throw ExceptionUtil.throwUnauthorizedException();
		}
		return Response.ok(response).build();
	}

}
