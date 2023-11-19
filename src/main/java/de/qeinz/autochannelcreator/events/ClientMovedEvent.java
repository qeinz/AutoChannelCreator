package de.qeinz.autochannelcreator.events;

import com.github.theholywaffle.teamspeak3.api.event.TS3EventAdapter;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;
import de.qeinz.autochannelcreator.main.Main;
import de.qeinz.autochannelcreator.utils.ChannelCreatorService;

/**
 * JavaDoc this file!
 * Created: 19.11.2023
 *
 * @author Nikk (dominik@minesort.de)
 */
public class ClientMovedEvent extends TS3EventAdapter {

    @Override
    public void onClientMoved(com.github.theholywaffle.teamspeak3.api.event.ClientMovedEvent event) {
        Client client = Main.api.getClientInfo(event.getClientId());

        //Checke ob ein Channel zu löschen ist:
        ChannelCreatorService.deleteChannel();

        //Channel zum erstellen eines eigenen Channels
        if (event.getTargetChannelId() == Main.channelCreator_ID)
            ChannelCreatorService.createOwnChannel(client, Main.channelCreator_Placer,
                    Main.entryChannel, Main.channelAdmin);

    }
}
