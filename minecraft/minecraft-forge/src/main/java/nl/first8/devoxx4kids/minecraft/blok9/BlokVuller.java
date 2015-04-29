package nl.first8.devoxx4kids.minecraft.blok9;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
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
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nl.first8.devoxx4kids.minecraft.other.NamedModel;

public class BlokVuller {

	private IBlockState selectieBlok;
	private BlockPos selectieBlokPos;
	private boolean actief;

	@SubscribeEvent
	public void kiesBlok(PlayerInteractEvent event) {
		
		// activeer(); //Zet deze aan om de blokvuller te activeren

		Item activatieVoorwerp = Items.diamond_shovel;
		if (isRechterMuisMetVoorwerp(event, activatieVoorwerp)) {
			if (selectieBlok == null) {
				selecteerBlok(event);
			} else {
				vulBlokken(event);
			}
		}

	}



	/**
	 * Als er nog niets geselecteerd was, selecteer het blok
	 */
	private void selecteerBlok(PlayerInteractEvent event) {
		selectieBlok = event.world.getBlockState(event.pos);
		selectieBlokPos = new BlockPos(event.pos);
		zegOpChat(event.entityPlayer,
				"Heb blok %s geselecteerd op coordinaten %s", selectieBlok
						.getBlock().getUnlocalizedName(), selectieBlokPos);

	}

	/**
	 * Vul alles met het geselecteerde blok
	 */
	private void vulBlokken(PlayerInteractEvent event) {
		if (!event.pos.equals(selectieBlokPos)) {
			zegOpChat(
					event.entityPlayer,
					"Ga blok %s vullen van coordinaten %s tot %s",
					selectieBlok.getBlock().getUnlocalizedName(),
					selectieBlokPos, event.pos);
			vulBlokken(event.world, selectieBlok, selectieBlokPos, event.pos);
			selectieBlok = null;
			selectieBlokPos = null;

		}

	}

	private void vulBlokken(World wereld, IBlockState blok, BlockPos pos1,
			BlockPos pos2) {
		for (int x = Math.min(pos1.getX(), pos2.getX()); x <= Math.max(
				pos1.getX(), pos2.getX()); x++) {
			for (int y = Math.min(pos1.getY(), pos2.getY()); y <= Math.max(
					pos1.getY(), pos2.getY()); y++) {
				for (int z = Math.min(pos1.getZ(), pos2.getZ()); z <= Math.max(
						pos1.getZ(), pos2.getZ()); z++) {
					BlockPos pos = new BlockPos(x, y, z);
					wereld.setBlockState(pos, blok);
				}
			}

		}

	}
	
	private boolean isRechterMuisMetVoorwerp(PlayerInteractEvent event, Item activatieVoorwerp) {
		return actief && event.action == Action.RIGHT_CLICK_BLOCK && event.entityPlayer.getHeldItem() != null
				&& event.entityPlayer.getHeldItem().getItem() == activatieVoorwerp && event.entityPlayer.capabilities.isCreativeMode;
	}

	private void zegOpChat(EntityPlayer speler, String bericht,
			Object... vulling) {
		String message = String.format(bericht, vulling);
		IChatComponent chatComponent = new ChatComponentText(
				EnumChatFormatting.DARK_AQUA + message);
		speler.addChatComponentMessage(chatComponent);
	}
	
	private void activeer() {
		actief = true;
		
	}

}