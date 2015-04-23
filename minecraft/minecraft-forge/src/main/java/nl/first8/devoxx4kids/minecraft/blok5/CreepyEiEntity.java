package nl.first8.devoxx4kids.minecraft.blok5;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class CreepyEiEntity extends EntityThrowable {
	
	private EntityCreeper maakCreepy(final MovingObjectPosition position) {
		EntityCreeper creepy = new EntityCreeper(worldObj);
		creepy.setPosition(position.getBlockPos().getX(), position.getBlockPos().getY(),  position.getBlockPos().getZ());
		
		creepy.setFire(10);
		
		return creepy;
	}
	
	
    public CreepyEiEntity(World worldIn)
    {
        super(worldIn);
    }

    public CreepyEiEntity(World worldIn, EntityLivingBase p_i1780_2_)
    {
        super(worldIn, p_i1780_2_);
    }

    public CreepyEiEntity(World worldIn, double p_i1781_2_, double p_i1781_4_, double p_i1781_6_)
    {
        super(worldIn, p_i1781_2_, p_i1781_4_, p_i1781_6_);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition position)
    {
        for (int j = 0; j < 8; ++j)
        {
            this.worldObj.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, new int[] {Item.getIdFromItem(Items.egg)});
        }

        if (!this.worldObj.isRemote && position.entityHit == null)
        {
        	EntityCreeper creepy = maakCreepy(position);
			this.worldObj.spawnEntityInWorld(creepy);
			creepy.playLivingSound();
            this.setDead();
        }
    }

	
}