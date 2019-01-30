package dave.com.retrofetch;

public class UploadResponse {
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String error;
    String message;

    public UploadResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }
}
