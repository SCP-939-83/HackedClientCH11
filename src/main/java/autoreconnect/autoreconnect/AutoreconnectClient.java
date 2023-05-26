package autoreconnect.autoreconnect;

import autoreconnect.autoreconnect.event.CheatLogicHandler;
import autoreconnect.autoreconnect.event.KeyInputHandler;
import net.fabricmc.api.ClientModInitializer;

public class AutoreconnectClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
//        CheatLogicHandler.TICK();
    }
}
