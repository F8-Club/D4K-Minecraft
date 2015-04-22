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
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;
import net.minecraftforge.fml.relauncher.Side;
import nl.first8.devoxx4kids.minecraft.block1.*;
import nl.first8.devoxx4kids.minecraft.block2.TestBlok;
import nl.first8.devoxx4kids.minecraft.other.DevoxxBlok;
import nl.first8.devoxx4kids.minecraft.other.ModBase;

@Mod(modid = MinecraftMod.MODID, version = MinecraftMod.VERSION)
public class MinecraftMod extends ModBase {
	public static final String MODID = "devoxx";
	public static final String VERSION = "1.0";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {


	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		//addBlock(event, new BoemBlok());
		addBlock(event, new TestBlok());

	}
	
	


}
