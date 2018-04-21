package org.anandh.javabrains.messengerapp.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.anandh.javabrains.messengerapp.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	

	@Override
	public Response toResponse(DataNotFoundException paramE) {
		// TODO Auto-generated method stub
		ErrorMessage errorMessge=new ErrorMessage(paramE.getMessage(), 404, "http://javabrains.koushik.org");
		return Response.status(Status.NOT_FOUND).entity(errorMessge).build();
	}

}
