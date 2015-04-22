package nl.first8.devoxx4kids.minecraft.block2;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nl.first8.devoxx4kids.minecraft.other.DevoxxBlok;

public class TestBlok extends Block implements DevoxxBlok
{

	private final String name = "testBlok";

	public TestBlok() {
		super(Material.glass);
		this.setCreativeTab(CreativeTabs.tabBlock);
		super.setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
	}


	@Override
	public String getName() {
		return name;
	}


	
}
