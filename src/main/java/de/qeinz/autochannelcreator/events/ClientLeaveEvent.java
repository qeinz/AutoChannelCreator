package de.qeinz.autochannelcreator.events;

import com.github.theholywaffle.teamspeak3.api.event.TS3EventAdapter;
import de.qeinz.autochannelcreator.utils.ChannelCreatorService;

/**
 * JavaDoc this file!
 * Created: 19.11.2023
 *
 * @author Nikk (dominik@minesort.de)
 */
public class ClientLeaveEvent extends TS3EventAdapter {

    @Override
    public void onClientLeave(com.github.theholywaffle.teamspeak3.api.event.ClientLeaveEvent e) {
        ChannelCreatorService.deleteChannel();
    }
}
