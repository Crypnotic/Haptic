package me.crypnotic.haptic.triggers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

public class LocationTrigger implements ITrigger {

	private Integer x;
	private Integer y;
	private Integer z;

	@Override
	public void update(Minecraft minecraft, EntityPlayerSP player) {
		this.x = (int) player.posX;
		this.y = (int) player.posY;
		this.z = (int) player.posZ;
	}

	@Override
	public String format() {
		return "Location: (" + (x != null ? x : 0) + ", " + (y != null ? y : 0) + ", " + (z != null ? z : 0) + ")";
	}
}
