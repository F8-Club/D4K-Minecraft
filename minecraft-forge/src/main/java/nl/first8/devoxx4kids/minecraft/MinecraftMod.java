package nl.first8.devoxx4kids.minecraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;
import nl.first8.devoxx4kids.minecraft.block1.*;

@Mod(modid = MinecraftMod.MODID, version = MinecraftMod.VERSION)
public class MinecraftMod
{
    public static final String MODID = "devoxx";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	Block boem = new BoemBlock();
    	
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    }
}
