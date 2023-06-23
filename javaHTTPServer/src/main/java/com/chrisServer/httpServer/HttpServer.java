package com.chrisServer.httpServer;

import com.chrisServer.httpServer.config.Configuration;
import com.chrisServer.httpServer.config.ConfigurationManager;
import com.chrisServer.httpServer.core.ServerListenerThread;

import java.io.IOException;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Server Starting");

        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        System.out.println("Using Port: " + conf.getPort());
        System.out.println("Using WebRoot: " + conf.getWebroot());

        try{
            ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(), conf.getWebroot());
            serverListenerThread.start();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
