package nl.first8.devoxx4kids.minecraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;
import net.minecraftforge.fml.relauncher.Side;
import nl.first8.devoxx4kids.minecraft.blok1.*;
import nl.first8.devoxx4kids.minecraft.blok2.TestBlok;
import nl.first8.devoxx4kids.minecraft.blok3.Recepten;
import nl.first8.devoxx4kids.minecraft.blok4.SneeuwBalItem;
import nl.first8.devoxx4kids.minecraft.other.NamedModel;
import nl.first8.devoxx4kids.minecraft.other.ModBase;

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
	}


}
