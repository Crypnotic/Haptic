package me.crypnotic.haptic.triggers;

import org.lwjgl.input.Keyboard;

import me.crypnotic.haptic.proxies.ClientProxy;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Toggle {

	private final ClientProxy proxy;
	private final KeyBinding key;

	public Toggle(ClientProxy proxy) {
		this.proxy = proxy;
		this.key = new KeyBinding("key.toggle", Keyboard.KEY_F, "key.categories.haptic");
	}

	@SideOnly(Side.CLIENT)
	public void init() {
		ClientRegistry.registerKeyBinding(key);
	}

	public KeyBinding getKey() {
		return key;
	}

	@SubscribeEvent
	public void onKeyPress(KeyInputEvent event) {
		if (key.isPressed()) {
			proxy.setEnabled(!proxy.isEnabled());
		}
	}
}
