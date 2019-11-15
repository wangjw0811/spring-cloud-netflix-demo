package utils.exception;

public class ServerException extends RuntimeException {

    protected String message;

    protected String code;

    public ServerException(String code){
        super();
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
