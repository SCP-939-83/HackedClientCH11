package Xray.Xray;

import autoreconnect.autoreconnect.event.KeyInputHandler;

public class Xrayclient {

    public void onInitializeClient() {
        KeyInputHandler.register();
//        CheatLogicHandler.TICK();
    }
}
