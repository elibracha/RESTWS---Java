package core.api.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {

        ErrorMessageJSONResponse errorMessage = new ErrorMessageJSONResponse(
               exception.getMessage(), ErrorMessages.INTERNAL_SERVER_ERORR.name(),
                "http://www.demoWebwervice.co.il/Doc"
        );
        return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
	}
}
