package autoreconnect.autoreconnect.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.text.Text;

import static autoreconnect.autoreconnect.event.KeyInputHandler.BHOPTOGGLE;


public class CheatLogicHandler extends Thread{
//    public static void TICK(){
//        while (true){
//            TICK();
//            BHOP_LOGIC_FUNCTION();
//        }
//    }
    @Override
    public void run(){
        while (BHOPTOGGLE) {ClientTickEvents.END_CLIENT_TICK.register(client -> {
                if (client.player.isOnGround() | client.player.isSprinting()){
//                  client.player.jump();
                    client.player.sendMessage(Text.of("THIS SHOULD BE WORKING RIGHT NOW"));
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            });
        }
        if (BHOPTOGGLE == false){
            return;
        }
    }

}
