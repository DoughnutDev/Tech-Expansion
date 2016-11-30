package abused_master.TechExpansion.registry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

/**
 * Created by Mohammad on 11/29/2016.
 */
public class KeybindHandler {

    public static KeyBinding keybind;

    public static void init() {
        keybind = new KeyBinding("Jetpack Flight", Keyboard.KEY_SPACE, "Tech Expansion Keybinds");
        ClientRegistry.registerKeyBinding(keybind);
    }

}
