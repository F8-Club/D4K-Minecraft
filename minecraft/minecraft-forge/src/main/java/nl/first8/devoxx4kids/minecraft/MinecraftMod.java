package nl.first8.devoxx4kids.minecraft;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import nl.first8.devoxx4kids.minecraft.blok1.BoemBlok;
import nl.first8.devoxx4kids.minecraft.blok2.TestBlok;
import nl.first8.devoxx4kids.minecraft.blok3.Recepten;
import nl.first8.devoxx4kids.minecraft.blok4.SneeuwBalItem;
import nl.first8.devoxx4kids.minecraft.blok5.CreepyEiItem;

@Mod(modid = MinecraftMod.MODID, version = MinecraftMod.VERSION)
public class MinecraftMod extends ModBase {
	public static final String MODID = "devoxx";
	public static final String VERSION = "1.0";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Recepten.maakRecepten();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		 add(event, new BoemBlok());
		 add(event, new TestBlok());
		 add(event, new SneeuwBalItem());
		 add(event, new CreepyEiItem());
	}


	


}
