package nl.first8.devoxx4kids.minecraft.blok7;

import net.minecraft.block.properties.IProperty;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
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
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nl.first8.devoxx4kids.minecraft.other.NamedModel;

public class SkeletGetThisPartyStarted {

	@SubscribeEvent
	public void leveHetSkelet(EntityJoinWorldEvent event) {

		if (event.entity instanceof EntitySkeleton) {
			EntitySkeleton skelly = (EntitySkeleton) event.entity;
			
			// geefMooieKleding(skelly); // Geef dat skelet wat mooie spullen
						
			// geefLeven(skelly, 30); // Geef het skelet extra leven
			
		}


	}

	@SubscribeEvent
	public void daarIsDeVersteking(LivingDeathEvent event) {

		if (event.entity instanceof EntitySkeleton) {
			EntitySkeleton skelly = (EntitySkeleton) event.entity;
			
			// maakNieuweCreepers(event, 3); // Maak enkele creepers!
			
			// laatVoorwerpVallen(skelly, Items.gold_ingot, 1); // Laat goud vallen
			
		}


	}

	private void geefMooieKleding(EntityCreature skelly) {
		
		skelly.setCurrentItemOrArmor(0, new ItemStack(Items.golden_axe));
		skelly.setCurrentItemOrArmor(1, new ItemStack(Items.golden_helmet));
		skelly.setCurrentItemOrArmor(2, new ItemStack(Items.golden_chestplate));
		skelly.setCurrentItemOrArmor(3, new ItemStack(Items.golden_leggings));
		skelly.setCurrentItemOrArmor(4, new ItemStack(Items.golden_boots));
		

	}
	
	private void laatVoorwerpVallen(Entity entity, Item voorwerp, int aantal) {
		entity.dropItem(voorwerp, aantal);
		
	}


	
	private void maakNieuweCreepers(EntityEvent event, int hoeveel) {
		if (!event.entity.worldObj.isRemote) {
			for (int i = 0; i < hoeveel; i++) {
				EntityCreeper creepy = maakCreepy(event.entity);
				// creepy.setFire(5);
			}

		}
	}

	private EntityCreeper maakCreepy(final Entity entity) {
		EntityCreeper creepy = new EntityCreeper(entity.worldObj);
		creepy.setPosition(entity.posX, entity.posY, entity.posZ);
		entity.worldObj.spawnEntityInWorld(creepy);
		return creepy;
	}
	
	private void geefLeven(EntityLiving beestje, double leven) {
		beestje.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(leven);
	}


	private double d(int x) {
		return new Integer(x).doubleValue();
	}

}