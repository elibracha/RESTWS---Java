package core.api.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UserServiceExceptionMapper implements ExceptionMapper<UserServiceException>{

	@Override
	public Response toResponse(UserServiceException exception) {

        ErrorMessageJSONResponse errorMessage = new ErrorMessageJSONResponse(
               exception.getMessage(), ErrorMessages.USER_ALREADY_EXIST.name(),
                "http://www.demoWebwervice.co.il/Doc"
        );
        return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
	}
}