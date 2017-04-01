package me.crypnotic.haptic.triggers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

public class LatencyTrigger implements ITrigger {

	private Integer latency;

	@Override
	public void update(Minecraft minecraft, EntityPlayerSP player) {
		this.latency = minecraft.getNetHandler().getPlayerInfo(player.getUniqueID()).getResponseTime();
	}

	@Override
	public String format() {
		return "Latency: " + (latency != null ? latency : -1) + "ms";
	}
}
