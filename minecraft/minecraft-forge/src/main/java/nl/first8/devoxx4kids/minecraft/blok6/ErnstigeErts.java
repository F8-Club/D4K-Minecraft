package nl.first8.devoxx4kids.minecraft.blok6;

import net.minecraft.block.properties.IProperty;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nl.first8.devoxx4kids.minecraft.other.NamedModel;

public class ErnstigeErts {
	
	@SubscribeEvent
	public void explode(BreakEvent event) {
		
		if (event.state.getBlock() == Blocks.redstone_ore) {
			
			maakExplosie(event, 5, true);
			
		}
		
		
		
	}
	
	
	private void maakExplosie(BreakEvent event, int explosie, boolean breekBlokken) {
		
		BlockPos blockPos = event.pos;
		event.world.createExplosion(null, d(blockPos.getX()), d(blockPos.getY()),
				d(blockPos.getZ()), explosie, breekBlokken);
	}
	
	
	private double d(int x) {
		return new Integer(x).doubleValue();
	}
	
}