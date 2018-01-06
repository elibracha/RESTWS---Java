package core.api.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MissingRequiredFieldsExceptionMapper implements ExceptionMapper<MissingRequiredFieldsException> {
    @Override
    public Response toResponse(MissingRequiredFieldsException exception) {

        ErrorMessageJSONResponse errorMessage = new ErrorMessageJSONResponse(
               exception.getMessage(), ErrorMessages.MISSING_REQUIRED_FIELD.name(),
                "http://www.demoWebwervice.co.il/Doc"
        );
        return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
    }
}
