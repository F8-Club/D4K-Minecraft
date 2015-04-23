package nl.first8.devoxx4kids.minecraft.other;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.ItemModelMesher;
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
import nl.first8.devoxx4kids.minecraft.blok1.*;
import nl.first8.devoxx4kids.minecraft.blok2.TestBlok;
import nl.first8.devoxx4kids.minecraft.blok4.SneeuwBalItem;

public class ModBase {
	public static final String MODID = "devoxx";
	public static final String VERSION = "1.0";
	
	public static final RegistryNamespacedDefaultedByKey blockRegistry = net.minecraftforge.fml.common.registry.GameData.getBlockRegistry();

	protected void add(FMLStateEvent event, NamedModel namedModel) {
		if (event.getSide() == Side.CLIENT) {
			registerItem(namedModel);
			addCustomMapper(namedModel);
		}
	}


	private void registerItem(NamedModel namedModel) {
		Item item = determineItem(namedModel);
		ModelResourceLocation location = new ModelResourceLocation(ModBase.MODID + ":" + namedModel.getName(),					"inventory");
		ItemModelMesher itemMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		itemMesher.register(item, 0, location);
	}
	
	private Item determineItem(NamedModel namedModel) {
		if (namedModel instanceof Item) {
			return (Item) namedModel;
		} else if (namedModel instanceof Block) {
			return Item.getItemFromBlock((Block) namedModel);
		}
		throw new IllegalArgumentException("Can't register this kind of item: " + namedModel);
	}

	private void addCustomMapper(NamedModel namedModel) {
		if (namedModel.getProperty() != null) {
			IStateMapper mapper = new StateMap.Builder().addPropertiesToIgnore(new IProperty[] {namedModel.getProperty()}).build();
			if (namedModel instanceof Block) {
				BlockModelShapes blockModelShapes = Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes();
				blockModelShapes.registerBlockWithStateMapper((Block) namedModel, mapper);
			}
		}
	}
	
	
}
