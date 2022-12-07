package main.java.by.bsuir.WT.lab4.exeptions;

import java.sql.SQLException;

public class ConnectionException extends SQLException {
    public ConnectionException(String message) {
        super(message);
    }

    public ConnectionException() {
        super();
    }

    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionException(Throwable cause) {
        super(cause);
    }
}