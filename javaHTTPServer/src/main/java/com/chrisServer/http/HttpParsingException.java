package com.chrisServer.http;

public class HttpParsingException extends Exception{

    private HttpStatusCode errorCode;

    public HttpParsingException(HttpStatusCode errorCode) {
        this.errorCode = errorCode;
    }

    public HttpStatusCode getErrorCode() {
        return errorCode;
    }
}
