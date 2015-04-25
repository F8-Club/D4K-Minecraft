package nl.first8.devoxx4kids.minecraft.blok8;

import java.util.Date;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.effect.EntityLightningBolt;
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
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.IEventListener;
import net.minecraftforge.fml.common.eventhandler.ListenerList;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nl.first8.devoxx4kids.minecraft.other.NamedModel;

public class SpeelSpelerSpeelst {
	
	private KeyBinding varkenKey;
	boolean geefGedonder = false;
	private Date laatsteBliksem = new Date();


	@SubscribeEvent
	public void spring(LivingJumpEvent event) {
		int springHoger = 1; //Verander dit naar 3 om hoger te springen
		event.entity.motionY *= springHoger;

	}
	
	@SubscribeEvent
	public void vecht(AttackEntityEvent event) {
		Entity slachtoffer = event.target;
		EntityPlayer speler = event.entityPlayer;

		float schade = 50F;
		
		// slachtoffer.attackEntityFrom(DamageSource.causePlayerDamage(speler), schade);
		// speler.heal(schade);
		
		
	}

	@SubscribeEvent
	public void val(LivingFallEvent event) {
		
		// event.damageMultiplier = 0;
		
	}
	
	@SubscribeEvent
	public void smid(ItemCraftedEvent event) {
		
		// event.crafting.stackSize *= 2;
		
		
	}
	
	@SubscribeEvent
	public void lach(PlayerTickEvent event) {
		if (varkenKey == null) {
			varkenKey = vindVarkenKey();
			
		}
		if (varkenKey.isKeyDown()) {
			String geluid = "mob.pig.say";
			
			// speelGuid(event.player, geluid);
			
		}
		
	}


	@SubscribeEvent
	public void gedonder(LivingAttackEvent event) {
		
		// geefGedonder = true;
		
		if (geefGedonder && event.entityLiving instanceof EntityPlayer) {
			Date nu = new Date();
			if (nu.getTime() - laatsteBliksem.getTime() > 3000) {
				World wereld = event.entity.worldObj;
				Entity boosdoener = event.source.getEntity();
				if (boosdoener != null) {
					EntityLightningBolt bliksems = new EntityLightningBolt(wereld, boosdoener.posX, boosdoener.posY, boosdoener.posZ);
					wereld.addWeatherEffect(bliksems);
					laatsteBliksem = nu;
					
				}
			}
			
		}
		
	}
	
	private void speelGuid(EntityPlayer speler, String geluid) {
		speler.worldObj.playSoundAtEntity(speler, geluid, 1.0F, 1.0F);
	}
	
	private KeyBinding vindVarkenKey() {
		KeyBinding resultaat = null;
		for (KeyBinding key : Minecraft.getMinecraft().gameSettings.keyBindings) {
			if (key.getKeyDescription().equals("Varken")) {
				resultaat = key;
				break;
			}
		}
		return resultaat;
	}
	


}