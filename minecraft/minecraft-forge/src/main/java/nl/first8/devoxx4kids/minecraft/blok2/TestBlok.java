package nl.first8.devoxx4kids.minecraft.blok2;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.IBlockAccess;
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
		setLightLevel(1.0F); // Blok geeft licht!
		register();

	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.diamond; // Wat laat het blok vallen?
	}

	public int quantityDropped(Random random) {
		return 1; // Hoeveel laat het blok vallen?
	}

	public boolean onBlockActivated(World world, BlockPos pos,
			IBlockState state, EntityPlayer player, EnumFacing side,
			float hitX, float hitY, float hitZ) {

		String text = "Hallo daar!";
		zegOpChat(player, text);

		return super.onBlockActivated(world, pos, state, player, side, hitX,
				hitY, hitZ);
	}

	public void onBlockDestroyedByPlayer(World world, BlockPos pos,
			IBlockState state) {
		super.onBlockDestroyedByPlayer(world, pos, state);
		// speelGeluid(world, pos, "mob.cow.hurt");
		// maakKoeien(world, pos, 1);

	}

	private void zegOpChat(EntityPlayer player, String text) {
		String bericht = String.format(text, player.getName());
		ChatComponentText message = new ChatComponentText(EnumChatFormatting.BLUE + bericht);
		player.addChatMessage(message);

	}

	private void speelGeluid(World world, BlockPos pos, String geluid) {
		world.playSound(d(pos.getX()), d(pos.getY()), d(pos.getZ()), geluid,
				1.0f, 1.0f, false);
	}

	private void maakKoeien(World world, BlockPos pos, int hoeveel) {
		if (!world.isRemote) {
			Random random = new Random();
			for (int i = 0; i < hoeveel; i++) {
				EntityCow cow = new EntityCow(world);
				int x = pos.getX() - 2 + random.nextInt(4);
				int y = pos.getY() + random.nextInt(4);
				int z = pos.getZ() - 2 + random.nextInt(4);
				cow.setPosition(x, y, z);
				world.spawnEntityInWorld(cow);
			}
		}
	}

	public String getName() {
		return name;
	}

	public IProperty getProperty() {
		return null;
	}

	private void register() {
		setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
	}

	public boolean canHarvestBlock(IBlockAccess world, BlockPos pos,
			EntityPlayer player) {
		return true;
	}

	private double d(int x) {
		return Integer.valueOf(x).doubleValue();
	}

}
