package me.crypnotic.haptic.proxies;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import me.crypnotic.haptic.triggers.FramesTrigger;
import me.crypnotic.haptic.triggers.ITrigger;
import me.crypnotic.haptic.triggers.LatencyTrigger;
import me.crypnotic.haptic.triggers.LocationTrigger;
import me.crypnotic.haptic.triggers.Toggle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Post;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class ClientProxy {

	private List<ITrigger> triggers;
	private Toggle toggle;
	private boolean enabled;

	public void preInit() {
		this.triggers = new ArrayList<ITrigger>();
		this.toggle = new Toggle(this);
		this.enabled = true;

		toggle.init();

		triggers.add(new FramesTrigger());
		triggers.add(new LatencyTrigger());
		triggers.add(new LocationTrigger());

		MinecraftForge.EVENT_BUS.register(toggle);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onRender(Post event) {
		if (!enabled) {
			return;
		}
		Minecraft minecraft = Minecraft.getMinecraft();
		if (canRender(minecraft, event)) {
			FontRenderer renderer = minecraft.fontRendererObj;
			int i = 2;
			for (ITrigger trigger : triggers) {
				renderer.drawString(trigger.format(), 2, i, Color.LIGHT_GRAY.getRGB());
				i += 10;
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(ClientTickEvent event) {
		if (!enabled) {
			return;
		}
		Minecraft minecraft = Minecraft.getMinecraft();
		if (canUpdate(minecraft)) {
			EntityPlayerSP player = minecraft.player;
			for (ITrigger trigger : triggers) {
				trigger.update(minecraft, player);
			}
		}
	}

	private boolean canUpdate(Minecraft minecraft) {
		return minecraft.player != null && (minecraft.inGameHasFocus
				|| (minecraft.currentScreen != null && minecraft.ingameGUI.getChatGUI().getChatOpen()));
	}

	private boolean canRender(Minecraft minecraft, Post event) {
		return canUpdate(minecraft) && event.getType() == ElementType.TEXT;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
