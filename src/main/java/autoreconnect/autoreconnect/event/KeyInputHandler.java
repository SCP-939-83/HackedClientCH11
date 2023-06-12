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
    public static final String KEY_VISTACLIENT_SPEEDHACK = "key.category.vistaclient.speedhack";
    public static final String KEY_VISTACLIENT_LAUNCH = "key.category.vistaclient.launch";
    public static KeyBinding testkey;
    public static KeyBinding bunnyhop;
    public static KeyBinding speedhack;
    public static KeyBinding launch;
    public static boolean BHOPTOGGLE = false;
    public static boolean SPEEDTOGGLE = false;
    public static float SPEEDVALUE = 5;
    public static float SPEEDBUFFER;
    public static int LAUNCHSPEED = 100;
    public static boolean LAUNCHTOGGLE = false;

    public static void registerKeyInputs() {
        //testkey
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (testkey.wasPressed()) {
                client.player.jump();
            }
        });

        //bhop
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (bunnyhop.wasPressed()) {
                BHOPTOGGLE = !BHOPTOGGLE;
                client.player.sendMessage(Text.of(String.valueOf(BHOPTOGGLE)));
                int i = 0;
                while (BHOPTOGGLE && client.player.isOnGround() && client.player.isSprinting() && i < 100) {
                    client.player.jump();
                    i++;
                }
//                else {return;}
                //                bhopLogic.start(); fucjing threads
            }
        });

        //speed
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (speedhack.wasPressed()) {
                SPEEDBUFFER = client.player.speed;
                SPEEDTOGGLE = !SPEEDTOGGLE;
                client.player.sendMessage(Text.of(String.valueOf(SPEEDTOGGLE)));
                client.player.sendMessage(Text.of(String.valueOf(SPEEDVALUE)));
                client.player.sendMessage(Text.of(String.valueOf(SPEEDBUFFER)));
                if (SPEEDTOGGLE) {
                    client.player.speed += SPEEDVALUE;
                } else {
                    client.player.speed = SPEEDBUFFER;
                }
            }
        });

        //launch
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (LAUNCHTOGGLE || launch.wasPressed()) {
                int i = 0;
                LAUNCHTOGGLE = !LAUNCHTOGGLE;
                while (i < LAUNCHSPEED && client.player.isOnGround()) {
                    client.player.setSprinting(true);
                    client.player.jump();
                    i++;
                }
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

        speedhack = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_VISTACLIENT_SPEEDHACK,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_V, //change for default
                KEY_CATEGORY_VISTACLIENT));
        registerKeyInputs();

        launch = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_VISTACLIENT_LAUNCH,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_C, //change for default
                KEY_CATEGORY_VISTACLIENT));
    }
}
