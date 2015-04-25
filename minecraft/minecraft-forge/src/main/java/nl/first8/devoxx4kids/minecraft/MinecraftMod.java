package nl.first8.devoxx4kids.minecraft;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import nl.first8.devoxx4kids.minecraft.blok1.BoemBlok;
import nl.first8.devoxx4kids.minecraft.blok2.BlaBlok;
import nl.first8.devoxx4kids.minecraft.blok3.Recepten;
import nl.first8.devoxx4kids.minecraft.blok4.SneeuwBalItem;
import nl.first8.devoxx4kids.minecraft.blok5.CreepyEiItem;
import nl.first8.devoxx4kids.minecraft.blok6.ErnstigeErts;
import nl.first8.devoxx4kids.minecraft.blok7.SkeletGetThisPartyStarted;
import nl.first8.devoxx4kids.minecraft.blok8.SpeelSpelerSpeelst;
import nl.first8.devoxx4kids.minecraft.blok9.BlokVuller;

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
		 add(event, new BlaBlok());
		 add(event, new SneeuwBalItem());
		 add(event, new CreepyEiItem());
		 addEvent(new ErnstigeErts());
		 addEvent(new SkeletGetThisPartyStarted());
		 addEvent(new BlokVuller());
		 addEvent(new SpeelSpelerSpeelst());
		 
		 ClientRegistry.registerKeyBinding(new KeyBinding("Varken", Keyboard.KEY_V, "key.categories.gameplay"));
	}

	

	


}
