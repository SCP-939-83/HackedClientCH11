package autoreconnect.autoreconnect.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.text.Text;

import static autoreconnect.autoreconnect.event.KeyInputHandler.BHOPTOGGLE;

public class CheatLogicHandler {
//    public static void TICK(){
//        while (true){
//            TICK();
//            BHOP_LOGIC_FUNCTION();
//        }
//    }
    public static void BHOP_LOGIC_FUNCTION(){
        while (BHOPTOGGLE){
            ClientTickEvents.END_CLIENT_TICK.register(client -> {
                client.player.sendMessage(Text.of("THIS SHOULD BE WORKING RIGHT NOW"));
                if (client.player.isOnGround()){
                    client.player.jump();
                }
            });
            if (BHOPTOGGLE == false){
                return;
            }
        }
    }
}
