package autoreconnect.autoreconnect.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    static CheatLogicHandler bhopLogic = new CheatLogicHandler();
    public static final String KEY_CATEGORY_VISTACLIENT =  "key.category.vistaclient";
    public static final String KEY_VISTACLIENT_TESTKEY = "key.category.vistaclient.test";
    public static final String KEY_VISTACLIENT_BUNNYHOP = "key.category.vistaclient.bhop";
    public static KeyBinding testkey;
    public static KeyBinding bunnyhop;
    public static boolean BHOPTOGGLE = false;

    public static void registerKeyInputs() {
        //testkey
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(testkey.wasPressed()){
                client.player.jump();
            }
        });
        //bhop
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(bunnyhop.wasPressed()){
                BHOPTOGGLE = !BHOPTOGGLE;
                client.player.sendMessage(Text.of(String.valueOf(BHOPTOGGLE)));
                if (BHOPTOGGLE && client.player.isOnGround() && client.player.isSprinting()){
                    client.player.jump();
                }
//                else {return;}
                //                bhopLogic.start(); fucjing threads
                }
        });
    }
    public static void register() {
        testkey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_VISTACLIENT_TESTKEY,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G, //change for default
                KEY_CATEGORY_VISTACLIENT));

        bunnyhop = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_VISTACLIENT_BUNNYHOP,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_LEFT_ALT, //change for default
                KEY_CATEGORY_VISTACLIENT));
        registerKeyInputs();
    }
}
