package nl.first8.devoxx4kids.minecraft;

import java.awt.Color;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.RegistryNamespacedDefaultedByKey;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLStateEvent;
import net.minecraftforge.fml.relauncher.Side;
import nl.first8.devoxx4kids.minecraft.blok6.ErnstigeErts;
import nl.first8.devoxx4kids.minecraft.other.NamedModel;

public class ModBase {
	public static final String MODID = "devoxx";
	public static final String VERSION = "1.0";

	public static final RegistryNamespacedDefaultedByKey blockRegistry = net.minecraftforge.fml.common.registry.GameData
			.getBlockRegistry();

	protected void add(FMLStateEvent event, NamedModel namedModel) {
		if (event.getSide() == Side.CLIENT) {
			registerItem(namedModel);
			addCustomMapper(namedModel);
		}
	}
	
	protected void addEvent(Object eventObject) {
		MinecraftForge.EVENT_BUS.register(eventObject);
		FMLCommonHandler.instance().bus().register(eventObject);
	}


	private void registerItem(NamedModel namedModel) {
		Item item = determineItem(namedModel);
		ModelResourceLocation location = new ModelResourceLocation(
				ModBase.MODID + ":" + namedModel.getName(), "inventory");
		ItemModelMesher itemMesher = Minecraft.getMinecraft().getRenderItem()
				.getItemModelMesher();
		itemMesher.register(item, 0, location);
	}

	private Item determineItem(NamedModel namedModel) {
		if (namedModel instanceof Item) {
			return (Item) namedModel;
		} else if (namedModel instanceof Block) {
			return Item.getItemFromBlock((Block) namedModel);
		}
		throw new IllegalArgumentException("Can't register this kind of item: "
				+ namedModel);
	}

	private void addCustomMapper(NamedModel namedModel) {
		if (namedModel.getProperty() != null) {
			IStateMapper mapper = new StateMap.Builder().addPropertiesToIgnore(
					new IProperty[] { namedModel.getProperty() }).build();
			if (namedModel instanceof Block) {
				BlockModelShapes blockModelShapes = Minecraft.getMinecraft()
						.getBlockRendererDispatcher().getBlockModelShapes();
				blockModelShapes.registerBlockWithStateMapper(
						(Block) namedModel, mapper);
			}
		}
	}
	
	private int convert(Color color) {
		return (color.getRed() << 16) + (color.getGreen() << 8) + color.getBlue();
	}
	
	protected RenderManager getRM() {
		return Minecraft.getMinecraft().getRenderManager();
	}

}
