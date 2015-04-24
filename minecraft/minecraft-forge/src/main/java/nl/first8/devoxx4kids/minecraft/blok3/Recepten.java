package nl.first8.devoxx4kids.minecraft.blok3;

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
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nl.first8.devoxx4kids.minecraft.other.NamedModel;

public class Recepten  {

	public static void maakRecepten() {
		
		ItemStack diamanten = new ItemStack(Items.diamond, 5);
		ItemStack appel = new ItemStack(Items.golden_apple, 1);
		
		Object[] receptKlein = 
			   {"AA",
		    	"AA",
		    	'A', Blocks.dirt
			   };
		Object[] receptGroot = 
			{"AAA",
			 "ABA",
			 "AAA",
			 'A', Items.gold_ingot,
			 'B', Items.apple
			};
		
		// GameRegistry.addRecipe(diamanten, receptKlein);
		
	}

}
