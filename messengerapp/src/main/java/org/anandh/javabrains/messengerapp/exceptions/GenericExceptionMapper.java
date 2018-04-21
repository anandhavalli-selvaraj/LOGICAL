package org.anandh.javabrains.messengerapp.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.anandh.javabrains.messengerapp.model.ErrorMessage;

	public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable paramE) {
		ErrorMessage errorMessge=new ErrorMessage(paramE.getMessage(), 500, "http://javabrains.koushik.org");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessge).build();
	}

}
