package exception;

public class SQLParseException extends Exception {
    private String message;

    public SQLParseException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "SQL Parse Error " + message;
    }
}
