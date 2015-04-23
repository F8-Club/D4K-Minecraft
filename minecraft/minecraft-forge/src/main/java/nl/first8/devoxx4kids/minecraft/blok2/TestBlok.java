package nl.first8.devoxx4kids.minecraft.blok2;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nl.first8.devoxx4kids.minecraft.other.NamedModel;

public class TestBlok extends Block implements NamedModel {

	private final String name = "testBlok";

	public TestBlok() {
		super(Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
		// setLightLevel(1.0F);
		// register();

	}

	/**
	 * Get the Item that this Block should drop when harvested.
	 */
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.diamond;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random random) {
		return 5;
	}

	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos,
			IBlockState state) {
		worldIn.playSound(d(pos.getX()), d(pos.getY()), d(pos.getZ()),
				"dig.stone", 1.0f, 1.0f, false);
		worldIn.playSound(d(pos.getX()), d(pos.getY()), d(pos.getZ()),
				"mob.cow.say", 1.0f, 1.0f, false);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public IProperty getProperty() {
		return null;
	}

	private void register() {
		setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
	}

	private double d(int x) {
		return Integer.valueOf(x).doubleValue();
	}

}
