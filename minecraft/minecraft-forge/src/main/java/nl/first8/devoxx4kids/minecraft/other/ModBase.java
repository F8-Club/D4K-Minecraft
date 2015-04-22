package nl.first8.devoxx4kids.minecraft.other;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.RegistryNamespacedDefaultedByKey;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLStateEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;
import net.minecraftforge.fml.relauncher.Side;
import nl.first8.devoxx4kids.minecraft.block1.*;
import nl.first8.devoxx4kids.minecraft.block2.TestBlok;

public class ModBase {
	public static final String MODID = "devoxx";
	public static final String VERSION = "1.0";
	
	public static final RegistryNamespacedDefaultedByKey blockRegistry = net.minecraftforge.fml.common.registry.GameData.getBlockRegistry();

	protected void addBlock(FMLStateEvent event, Block blok) {
		Item item = Item.getItemFromBlock(blok);
		// register renders
		if (event.getSide() == Side.CLIENT) {
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
			DevoxxBlok devoxxBlok = (DevoxxBlok) blok;
			ModelResourceLocation location = new ModelResourceLocation(
					ModBase.MODID + ":" + devoxxBlok.getName(),
					"inventory");
			renderItem.getItemModelMesher().register(Item.getItemFromBlock(blok), 0, location);
			if (devoxxBlok.getProperty() != null) {
				IStateMapper mapper = new StateMap.Builder().addPropertiesToIgnore(new IProperty[] {BlockTNT.EXPLODE}).build();
				Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().registerBlockWithStateMapper(blok, mapper);
			}

		}

	}
	
}
