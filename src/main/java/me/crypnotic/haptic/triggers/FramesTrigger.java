package me.crypnotic.haptic.triggers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

public class FramesTrigger implements ITrigger {

	private Integer fps;

	public void update(Minecraft minecraft, EntityPlayerSP player) {
		this.fps = Minecraft.getDebugFPS();
	}

	public String format() {
		return "Frames: " + (fps != null ? fps : -1);
	}
}
