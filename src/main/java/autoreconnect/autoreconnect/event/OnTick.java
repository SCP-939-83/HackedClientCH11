package autoreconnect.autoreconnect.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class OnTick {
    public static void OnClientTickStart() {
        ClientTickEvents.START_CLIENT_TICK.register(client -> {

                }
        );
    }
}
