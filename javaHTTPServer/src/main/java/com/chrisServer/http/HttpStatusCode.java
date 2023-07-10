package com.chrisServer.http;

public enum HttpStatusCode {
    CLIENT_ERROR_400_BAD_REQUEST(400, "Bad Request"),
    CLIENT_ERROR_401_METHOD_NOT_ALLOWED(401, "Method Not Allowed"),
    CLIENT_ERROR_414_URI_TO_LONG(400, "URI Too Long"),

    SERVER_ERROR_500_INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    SERVER_ERROR_501_NOT_IMPLEMENTED(501, "Not Implemented")
    ;

    public final int STATUS_Code;
    public final String Message;

    HttpStatusCode(int STATUS_Code, String message) {
        this.STATUS_Code = STATUS_Code;
        Message = message;
    }
}
