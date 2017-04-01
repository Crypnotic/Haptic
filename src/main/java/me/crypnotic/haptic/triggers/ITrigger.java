package me.crypnotic.haptic.triggers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

public interface ITrigger {

	void update(Minecraft minecraft, EntityPlayerSP player);

	String format();
}
