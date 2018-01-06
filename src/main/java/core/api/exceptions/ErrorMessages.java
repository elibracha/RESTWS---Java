package core.api.exceptions;

public enum ErrorMessages {

    MISSING_REQUIRED_FIELD("Missing required field, please check documentions for required fields"),
    RECORD_ALREADY_EXISTS("Record is already exist"),
    INTERNAL_SERVER_ERORR("Error: internal Error"),
    USER_ALREADY_EXIST("User already in Use");

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
