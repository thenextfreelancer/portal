/**
 * 
 */
package com.documentviewer.web.api.rest.impl;

import java.util.Collections;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.documentviewer.entity.impl.User;
import com.documentviewer.service.impl.UserService;
import com.documentviewer.util.ApplicationUtils;
import com.documentviewer.web.api.rest.RestProvider;

/**
 * @author Arpit
 *
 */
public class UserRestProcess implements RestProvider<User> {
	
	@Autowired
	UserService userService;

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse getAll() throws Exception
    {
        return new RestResponse(true,userService.getEntities());
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("ADMIN")
    public RestResponse remove(User user) throws Exception
    {
        userService.deleteEntity(user);
        return new RestResponse(true);
    }
    
//    @POST
//    @Path("register")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @PermitAll
//    public Response createEntity(User user) throws Exception
//    {
//    	Response response = null;
//    	User newUser = userService.createEntity(user);
//    	response = ApplicationUtils.serialize(user);
//        return new RestResponse(true, Collections.singletonList(newUser));
//    }
    
    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public RestResponse update(User user) throws Exception
    {
        userService.updateEntity(user);
        return new RestResponse(true, Collections.singletonList(user));
    }    

	

}
