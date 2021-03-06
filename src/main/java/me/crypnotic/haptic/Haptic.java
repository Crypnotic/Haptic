package me.crypnotic.haptic;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import me.crypnotic.haptic.proxies.ClientProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Haptic.MODID, name = Haptic.NAME, version = Haptic.VERSION)
public class Haptic {

	public static final String MODID = "haptic";
	public static final String NAME = "Haptic";
	public static final String VERSION = "1.12-2.1.2";
	public static final Logger LOGGER = LogManager.getLogManager().getLogger(MODID);

	@SidedProxy(clientSide = "me.crypnotic.haptic.proxies.ClientProxy")
	private static ClientProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit();
	}
}
