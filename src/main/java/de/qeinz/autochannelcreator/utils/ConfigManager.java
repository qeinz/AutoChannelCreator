package de.qeinz.autochannelcreator.utils;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;

public class ConfigManager {

    private String serverIp;
    private String queryPort;
    private String nickname;
    private String username;
    private String password;
    private String channelIdCreator;
    private String channelIdPlacer;
    private String entryChannel;
    private String channelAdmin;

    public ConfigManager() {
        readConfig();
    }

    private void readConfig() {
        try {
            String currentWorkingDirectory = System.getProperty("user.dir");
            String configFilePath = currentWorkingDirectory + File.separator + "config.json";

            try (InputStream inputStream = new FileInputStream(configFilePath)) {
                JsonReader reader = Json.createReader(inputStream);
                if (reader != null) {
                    JsonObject jsonObject = reader.readObject();

                    serverIp = getStringOrDefault(jsonObject, "serverip", "");
                    queryPort = getStringOrDefault(jsonObject, "query_port", "");
                    nickname = getStringOrDefault(jsonObject, "nickname", "");
                    username = getStringOrDefault(jsonObject, "query_login", "");
                    password = getStringOrDefault(jsonObject, "query_password", "");
                    channelIdCreator = getStringOrDefault(jsonObject, "channel_id_creator", "");
                    channelIdPlacer = getStringOrDefault(jsonObject, "channelid_placer", "");
                    entryChannel = getStringOrDefault(jsonObject, "channelid_entry", "");
                    channelAdmin = getStringOrDefault(jsonObject, "channel_admin", "");
                } else {
                    System.err.println("Error: Could not create JsonReader. InputStream is null.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.err.println("Fehler beim Lesen der Konfigurationsdatei. Ein oder mehrere Werte fehlen.");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("Fehler beim Konstruieren des Dateipfads.");
            e.printStackTrace();
        }
    }

    private String getStringOrDefault(JsonObject jsonObject, String key, String defaultValue) {
        if (jsonObject.containsKey(key) && jsonObject.get(key) != null && !jsonObject.isNull(key)) {
            return jsonObject.getString(key);
        }
        return defaultValue;
    }

    public String getServerIp() {
        return serverIp;
    }

    public String getQueryPort() {
        return queryPort;
    }

    public String getNickname() {
        return nickname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getChannelIdCreator() {
        return channelIdCreator;
    }

    public String getChannelIdPlacer() {
        return channelIdPlacer;
    }

    public String getEntryChannel() {
        return entryChannel;
    }

    public String getChannelAdmin() {
        return channelAdmin;
    }
}
