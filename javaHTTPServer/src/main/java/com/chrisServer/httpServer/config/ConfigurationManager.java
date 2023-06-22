package com.chrisServer.httpServer.config;

import com.chrisServer.httpServer.util.Json;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigurationManager {
    private static ConfigurationManager myConfigurationManager;
    private static Configuration myCurrentConfiguration;

    private ConfigurationManager() {
    }

    public static ConfigurationManager getInstance(){
        if(myConfigurationManager == null){
            myConfigurationManager = new ConfigurationManager();
        }

        return myConfigurationManager;
    }

    /*
    * Used to load a configuration file by the path provided
    * */
    public void loadConfigurationFile(String filePath) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
        } catch(FileNotFoundException e) {
            throw new HttpConfigurationException(e);
        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        try{
            while((i = fileReader.read()) != -1){
                sb.append((char)i);
            }
        }catch (IOException e){
            throw new HttpConfigurationException(e);
        }

        try{
            JsonNode conf = Json.parse(sb.toString());
            myCurrentConfiguration = Json.fromJson(conf, Configuration.class);
        }catch(IOException e){
            throw new HttpConfigurationException("Error Parsing the Configuration File");
        }
        try{
            JsonNode conf = Json.parse(sb.toString());
            myCurrentConfiguration = Json.fromJson(conf, Configuration.class);
        }catch(IOException e){
            throw new HttpConfigurationException("Error Parsing the Configuration File, internal", e);
        }
    }

    /*
    *  Returns the Current loaded Configuration
    * */

    public Configuration getCurrentConfiguration(){
        if(myCurrentConfiguration == null){
            throw new HttpConfigurationException("No Current Configuration Set.");
        }
        return myCurrentConfiguration;
    }
}
