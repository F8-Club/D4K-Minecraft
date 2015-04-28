package nl.first8.devoxx4kids.minecraft.blok8;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class CreepyEiEntity extends EntityThrowable {

	private int explosieKracht = 2;
	private boolean explosieBreekBlokken = true;

	protected void onImpact(MovingObjectPosition positie) {

		maakExplosie(positie);
		maakCreepy(positie);
		verwijderSneeuwbal();

	}

	private void maakExplosie(MovingObjectPosition positie) {
		if (!this.worldObj.isRemote && positie.entityHit == null) {
			BlockPos blockPos = positie.getBlockPos();
			worldObj.createExplosion(this, d(blockPos.getX()),
					d(blockPos.getY()), d(blockPos.getZ()), explosieKracht,
					explosieBreekBlokken);
		}
	}

	private void maakCreepy(final MovingObjectPosition positie) {
		if (!this.worldObj.isRemote && positie.entityHit == null) {
			EntityCreeper creepy = new EntityCreeper(worldObj);
			creepy.setPosition(positie.getBlockPos().getX(), positie
					.getBlockPos().getY(), positie.getBlockPos().getZ());
			this.worldObj.spawnEntityInWorld(creepy);

			// creepy.setFire(10);
			// creepy.playLivingSound();
		}

	}

	public CreepyEiEntity(World worldIn) {
		super(worldIn);
	}

	public CreepyEiEntity(World worldIn, EntityLivingBase p_i1780_2_) {
		super(worldIn, p_i1780_2_);
	}

	public CreepyEiEntity(World worldIn, double p_i1781_2_, double p_i1781_4_,
			double p_i1781_6_) {
		super(worldIn, p_i1781_2_, p_i1781_4_, p_i1781_6_);
	}

	private double d(int x) {
		return new Integer(x).doubleValue();
	}

	private void verwijderSneeuwbal() {
		this.setDead();

	}

}