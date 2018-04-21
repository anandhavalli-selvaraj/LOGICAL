package org.anandh.javabrains.messengerapp.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.uri.PathPattern.RightHandPath;

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)

public class InjectDemoResource {
	
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotation(@MatrixParam("param")String value,@HeaderParam("customValue") String header,@CookieParam("JSESSIONID")Cookie cookieName)
	{
		return"The Matrix Param value is "+ value+ " the header value is "+header+" the cookie name is "+cookieName.getName();
	}
	@GET
	@Path("context")
	public String getParams(@Context UriInfo uriInfo,@Context HttpHeaders httpHeaders)
	{
		String path=uriInfo.getAbsolutePath().toString();
		String cookie=httpHeaders.getCookies().toString();
		return "The absolute path is "+path+" and the cookie is "+cookie; 
	}
}
