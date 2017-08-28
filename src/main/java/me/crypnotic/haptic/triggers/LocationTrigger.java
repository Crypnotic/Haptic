package me.crypnotic.haptic.triggers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

public class LocationTrigger implements ITrigger {

	private Integer x;
	private Integer y;
	private Integer z;
	private Integer chunkX;
	private Integer chunkZ;

	@Override
	public void update(Minecraft minecraft, EntityPlayerSP player) {
		this.x = (int) player.posX;
		this.y = (int) player.posY;
		this.z = (int) player.posZ;
		this.chunkX = player.chunkCoordX;
		this.chunkZ = player.chunkCoordZ;
	}

	@Override
	public String format() {
		return "Location: (" + (x != null ? x : 0) + ", " + (y != null ? y : 0) + ", " + (z != null ? z : 0) + ") ("
				+ (chunkX != null ? chunkX : 0) + ", " + (chunkZ != null ? chunkZ : 0) + ")";
	}
}
