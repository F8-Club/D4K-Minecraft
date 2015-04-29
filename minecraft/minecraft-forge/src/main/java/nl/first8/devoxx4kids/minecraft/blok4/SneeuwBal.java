package nl.first8.devoxx4kids.minecraft.blok4;

import net.minecraft.block.properties.IProperty;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
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

public class SneeuwBal extends Item implements NamedModel {
	private final String name = "sneeuwBal";

	public SneeuwBal() {
		setCreativeTab(CreativeTabs.tabMisc);
		// activeer();  // Zet dit aan om de sneeuwbal te kunnen gebruiken!
	}

	public ItemStack onItemRightClick(ItemStack itemStackIn, World wereld,
			EntityPlayer speler) {

		speelGeluid(speler, "random.bow");  // Maakt geluid

		schietPijl(speler, 5);  // Schiet een pijl met een bepaalde kracht

		maakLiefKonijn(speler); // Maak ook maar een lief konijn

		geefVoorwerp(speler, Items.egg, 1); // Geef de speler ook maar wat voorwerpen

		return itemStackIn;
	}

	private void schietPijl(EntityPlayer player, int kracht) {
		EntityArrow pijl = new EntityArrow(player.worldObj, player, 1.0F);
		pijl.setKnockbackStrength(kracht);
		maakInWereld(player.worldObj, pijl);
	}

	private EntityRabbit maakLiefKonijn(EntityPlayer speler) {
		EntityRabbit konijn = new EntityRabbit(speler.worldObj);
		konijn.setPosition(speler.getPosition().getX(), speler.getPosition()
				.getY(), speler.getPosition().getZ());
		konijn.setInLove(speler);
		// konijn.setFire(5);
		maakInWereld(speler.worldObj, konijn);
		return konijn;
	}

	private void geefVoorwerp(EntityPlayer speler, Item item, int aantal) {
		speler.inventory.addItemStackToInventory(new ItemStack(item, aantal));

	}

	private void speelGeluid(EntityPlayer player, String geluid) {
		player.worldObj.playSoundAtEntity(player, geluid, 0.5F, 1.0F);
	}

	private void maakInWereld(World world, Entity entity) {
		world.spawnEntityInWorld(entity);
	}

	private void activeer() {
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