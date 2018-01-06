package core.api.exceptions;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessageJSONResponse {
    private String errorMessage;
    private String errorKey;
    private String href;

    public ErrorMessageJSONResponse() {
    }

    public ErrorMessageJSONResponse(String errorMessage, String errorKey, String href) {
        this.errorMessage = errorMessage;
        this.errorKey = errorKey;
        this.href = href;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorKey() {
        return errorKey;
    }

    public void setErrorKey(String errorKey) {
        this.errorKey = errorKey;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
