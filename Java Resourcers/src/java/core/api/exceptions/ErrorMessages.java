package core.api.exceptions;

public enum ErrorMessages {

    MISSING_REQUIRED_FIELD("Missing required field, please check documentions for required fields"),
    RECORD_ALREADY_EXISTS("Record is already exist");

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
