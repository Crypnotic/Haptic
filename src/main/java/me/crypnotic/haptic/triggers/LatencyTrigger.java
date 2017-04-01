package me.crypnotic.haptic.triggers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;

public class LatencyTrigger implements ITrigger {

	private Integer latency;

	@Override
	public void update(Minecraft minecraft, EntityPlayerSP player) {
		NetHandlerPlayClient handler = minecraft.getNetHandler();
		if (handler == null) {
			return;
		}
		NetworkPlayerInfo info = handler.getPlayerInfo(player.getUniqueID());
		if (info == null) {
			return;
		}
		this.latency = info.getResponseTime();
	}

	@Override
	public String format() {
		return "Latency: " + (latency != null ? latency : -1) + "ms";
	}
}
