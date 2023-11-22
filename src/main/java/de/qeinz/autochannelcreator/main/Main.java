package de.qeinz.autochannelcreator.main;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.reconnect.ReconnectStrategy;
import de.qeinz.autochannelcreator.events.ClientLeaveEvent;
import de.qeinz.autochannelcreator.events.ClientMovedEvent;
import de.qeinz.autochannelcreator.utils.ConfigManager;

/**
 * JavaDoc this file!
 * Created: 19.11.2023
 *
 * @author Nikk (dominik@minesort.de)
 */
public class Main {

    public static TS3Api api;
    public static TS3Query query;
    public static ConfigManager configManager;
    public static int channelCreator_ID;
    public static int channelCreator_Placer;
    public static int entryChannel;
    public static int channelAdmin;

    public static void main(String[] args) {
        configManager = new ConfigManager();

        final TS3Config config = new TS3Config();
        config.setHost(configManager.getServerIp())
                .setFloodRate(TS3Query.FloodRate.UNLIMITED)
                .setQueryPort(Integer.parseInt(configManager.getQueryPort()))
                .setReconnectStrategy(ReconnectStrategy.exponentialBackoff());

        query = new TS3Query(config);
        query.connect();

        api = query.getApi();
        api.login(configManager.getUsername(), configManager.getPassword());
        api.selectVirtualServerById(Integer.parseInt(configManager.getVirtualserverID()));

        try {
            api.setNickname(configManager.getNickname());
        } catch (Exception ignored) {
        }

        initVariables();
        loadEvents();

        System.out.println("[Query] AutoChannelCreator was successfully launched!");
    }

    private static void initVariables() {
        channelCreator_ID = Integer.parseInt(Main.configManager.getChannelIdCreator());
        channelCreator_Placer = Integer.parseInt(Main.configManager.getChannelIdPlacer());
        entryChannel = Integer.parseInt(Main.configManager.getEntryChannel());
        channelAdmin = Integer.parseInt(Main.configManager.getChannelAdmin());
    }

    private static void loadEvents() {
        api.registerAllEvents();
        api.addTS3Listeners(new ClientMovedEvent());
        api.addTS3Listeners(new ClientLeaveEvent());
    }

}
