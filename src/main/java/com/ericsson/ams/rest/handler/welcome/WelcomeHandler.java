package com.ericsson.ams.rest.handler.welcome;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ericsson.ams.service.TestService;

/**
 *
 */
@Path("/welcome")
public class WelcomeHandler {
	/**
	 * 
	 */
	@Resource
	private TestService testService;

	/**
	 * @return
	 */
	@GET
	@Produces(MediaType.TEXT_XML)
	public Response doGet() throws Exception {
		return Response.ok(MediaType.TEXT_XML).build();
	}
}