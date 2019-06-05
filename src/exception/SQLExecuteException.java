package exception;

public class SQLExecuteException extends Exception {
    private String message;

    public SQLExecuteException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "SQL Execute Error " + message;
    }
}
