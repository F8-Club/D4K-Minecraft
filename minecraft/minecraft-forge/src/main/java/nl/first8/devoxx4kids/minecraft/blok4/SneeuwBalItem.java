package nl.first8.devoxx4kids.minecraft.blok4;

import net.minecraft.block.properties.IProperty;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nl.first8.devoxx4kids.minecraft.other.NamedModel;

public class SneeuwBalItem extends Item implements NamedModel {
	private final String name = "sneeuwBal";

	public SneeuwBalItem() {
		setCreativeTab(CreativeTabs.tabMisc);
		register();
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn,
			EntityPlayer playerIn) {

		// worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 1.0F);
		// worldIn.spawnEntityInWorld(new EntityArrow(worldIn, playerIn, 1.0F));
		// worldIn.spawnEntityInWorld(maakKonijn(worldIn, playerIn));
		// playerIn.moveForward = 2.0F;
		// playerIn.inventory.addItemStackToInventory(new ItemStack(Items.egg, 1));

		return itemStackIn;
	}

	private EntityRabbit maakKonijn(World worldIn, EntityPlayer playerIn) {
		EntityRabbit konijn = new EntityRabbit(worldIn);
		konijn.setPosition(playerIn.getPosition().getX(), playerIn
				.getPosition().getY(), playerIn.getPosition().getZ());
		konijn.setInLove(playerIn);
		konijn.setAttackTarget(playerIn);
		return konijn;
	}

	private void register() {
		setUnlocalizedName(name);
		GameRegistry.registerItem(this, name);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public IProperty getProperty() {
		return null;
	}
}