package com.chrisServer.httpServer.config;

import com.chrisServer.httpServer.core.ServerListenerThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpConfigurationException extends RuntimeException{

    private final static Logger LOGGER = LoggerFactory.getLogger(ServerListenerThread.class);

    public HttpConfigurationException() {
    }

    public HttpConfigurationException(String message) {
        super(message);
    }

    public HttpConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpConfigurationException(Throwable cause) {
        super(cause);
    }
}

