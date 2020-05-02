package ru.geekbrains.main.site.at.util;

public class PageNotCreateException extends RuntimeException {
    public PageNotCreateException() {
    }

    public PageNotCreateException(String message) {
        super(message);
    }

    public PageNotCreateException(String message, Throwable cause) {
        super(message, cause);
    }

    public PageNotCreateException(Throwable cause) {
        super(cause);
    }

    public PageNotCreateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
