package de.qeinz.autochannelcreator.utils;

import com.github.theholywaffle.teamspeak3.api.ChannelProperty;
import com.github.theholywaffle.teamspeak3.api.wrapper.Channel;
import com.github.theholywaffle.teamspeak3.api.wrapper.ChannelInfo;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;
import de.qeinz.autochannelcreator.main.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * JavaDoc this file!
 * Created: 19.11.2023
 *
 * @author Nikk (dominik@minesort.de)
 */
public class ChannelCreatorService {
    public static HashMap<String, ArrayList<ChannelInfo>> channels = new HashMap<>();

    public static void loadChannels() {
        channels.put("channel", new ArrayList<ChannelInfo>());
    }

    private static int getChannelOrder(String name) {
        int i = 1;
        ArrayList<Integer> temp = new ArrayList<>();
        for (ChannelInfo info : channels.get(name.toLowerCase())) {
            int current = Integer.parseInt(info.getName().split("№")[1]);
            temp.add(current);
            if (i == current) {
                i++;
                while (temp.contains(i)) {
                    i++;
                }
            }
        }
        return i;
    }

    public static void deleteChannel() {
        ChannelInfo ci = null;
        for (String game : channels.keySet()) {
            for (ChannelInfo info : channels.get(game)) {
                Channel ch = Main.api.getChannelByNameExact(info.getName(), true);
                if (ch.getTotalClients() == 0) {
                    ci = info;
                }
            }
        }
        if (ci != null) {
            String name = ci.getName().replace("[lspacer]➩ Eigener ", "").split(" • ")[0].toLowerCase();
            channels.get(name).remove(ci);
            Main.api.deleteChannel(ci.getId());
        }
    }

    public static void createOwnChannel(Client client, int placer, int channelAdmin, int entryChannel) {
        try {
            Map<ChannelProperty, String> property = new HashMap<ChannelProperty, String>();
            property.put(ChannelProperty.CHANNEL_NAME, client.getNickname() + "'s Channel");
            property.put(ChannelProperty.CHANNEL_ORDER, String.valueOf(placer));
            property.put(ChannelProperty.CHANNEL_DESCRIPTION,
                    "[center][size=12]Channel erstellt von:\n[B]" + client.getNickname() + "[/B]");
            ChannelInfo ci = Main.api.getChannelInfo(Main.api.createChannel("channel2", property));
            property.clear();
            Main.api.moveClient(client.getId(), ci.getId());
            Main.api.setClientChannelGroup(channelAdmin, ci.getId(), client.getDatabaseId());
            Main.api.moveQuery(entryChannel);
            Main.api.sendPrivateMessage(client.getId(), "Dein Eigener - Channel wurde erfolgreich erstellt.");
        } catch (Exception exception) {
            Main.api.sendPrivateMessage(client.getId(), "Es gab einen Fehler bei der Erstellung deines Channels! " +
                    "\nMelde dich mit diesem Problem im Support!");
            System.out.println("Ein Fehler trat beim erstellen des Channels auf!");
        }
    }
}
