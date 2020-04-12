package com.deadrising.mod;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.internal.EntitySpawnHandler;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.LinkedList;

import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

import com.deadrising.mod.client.tabs.TabFood;
import com.deadrising.mod.client.gui.GuiHealthbar;
import com.deadrising.mod.client.tabs.TabBlocks;
import com.deadrising.mod.client.tabs.TabMedical;
import com.deadrising.mod.client.tabs.TabMelee;
import com.deadrising.mod.common.CommonEvents;
import com.deadrising.mod.entity.EntityCrawler;
import com.deadrising.mod.entity.EntityDRZombie;
import com.deadrising.mod.init.ModBlocks;
import com.deadrising.mod.init.ModItems;
import com.deadrising.mod.network.PacketHandler;
import com.deadrising.mod.potions.PotionEffectRegistry;
import com.deadrising.mod.potions.ZombieVirus;
import com.deadrising.mod.proxy.CommonProxy;
import com.deadrising.mod.tileentity.TileEntityCrystal;
import com.deadrising.mod.utils.events.MainEvents;
import com.deadrising.mod.utils.handlers.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt.DirtType;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEnd;
import net.minecraft.world.biome.BiomeHell;
import net.minecraft.world.biome.BiomeVoid;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;




@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, acceptedMinecraftVersions = Reference.MOD_COMPATIBILITY)
public class deadrising {
	
	
	public static final Potion Infection = new ZombieVirus();
	 
	public static final CreativeTabs TabMelee = new TabMelee("tabmelee");
	public static final CreativeTabs TabMedical = new TabMedical("tabmedical");
	public static final CreativeTabs TabFood = new TabFood("tabfood");
	public static final CreativeTabs TabBlocks = new TabBlocks("tabblocks");

    public static final String MOD_ID = "deadrising";

	@Mod.Instance
	public static deadrising instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

	private static Logger logger;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		proxy.preInit(event);
		MinecraftForge.EVENT_BUS.register(new CommonEvents());
		PacketHandler.init();
		RegistryHandler.preInit();
		
		ForgeRegistries.POTIONS.register(Infection);
        PotionEffectRegistry.registerPotionTypes();
	
        // Registers this class so forge calls onBlockRegistryCreated and onItemRegistryCreated
        MinecraftForge.EVENT_BUS.register(this);

        // This allows the library to load models specified in the json files of the mod (in this example is not used)
       
    }

	
	@SideOnly(Side.CLIENT)
	@EventHandler
	public static void preinitOne(FMLPreInitializationEvent event)
	{
		RegistryHandler.preInitRegistriesOne();
	}
	


	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
		
		RegistryHandler.init();
		MinecraftForge.EVENT_BUS.register(new MainEvents());
		
		registerItemRenders();
		
 	
		proxy.init(event);

	}

	private void registerItemRenders() {
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
		RegistryHandler.postInit();
		
		//Handle Spawns
		Biome[] spawnBiomes = getAllSpawnBiomes();
		
		int prob = 3;
		int maxSpawn = 1;
		int minSpawn = 3;
		
		EntityRegistry.addSpawn(EntityDRZombie.class, prob, minSpawn, maxSpawn, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityCrawler.class, prob, minSpawn, maxSpawn, EnumCreatureType.MONSTER, spawnBiomes);
		
		
		EntityRegistry.removeSpawn(EntityZombie.class, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.removeSpawn(EntitySkeleton.class, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.removeSpawn(EntityCreeper.class, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.removeSpawn(EntitySpider.class, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.removeSpawn(EntityEnderman.class, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.removeSpawn(EntityCaveSpider.class, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.removeSpawn(EntityWitch.class, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.removeSpawn(EntityZombieVillager.class, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.removeSpawn(EntitySlime.class, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.removeSpawn(EntityChicken.class, EnumCreatureType.CREATURE, spawnBiomes);
		EntityRegistry.removeSpawn(EntityCow.class, EnumCreatureType.CREATURE, spawnBiomes);
		EntityRegistry.removeSpawn(EntitySheep.class, EnumCreatureType.CREATURE, spawnBiomes);
		EntityRegistry.removeSpawn(EntityPig.class, EnumCreatureType.CREATURE, spawnBiomes);
		EntityRegistry.removeSpawn(EntityHorse.class, EnumCreatureType.CREATURE, spawnBiomes);
		EntityRegistry.removeSpawn(EntityDonkey.class, EnumCreatureType.CREATURE, spawnBiomes);
		
		//MinecraftForge.EVENT_BUS.register(new GuiHealthbar());
	}

	@Mod.EventHandler
	public void onServerStarting(FMLServerStartingEvent event) {
		
	}

	public static Logger logger() {
		return logger;
	}

	private Biome[] getAllSpawnBiomes() {
        LinkedList<Biome> list = new LinkedList<>();
        Collection<Biome> biomes = ForgeRegistries.BIOMES.getValuesCollection();
        for (Biome bgb : biomes) {
            if (bgb instanceof BiomeVoid) {
                continue;
            }
            if (bgb instanceof BiomeEnd) {
                continue;
            }
            if (bgb instanceof BiomeHell) {
                continue;
            }
            if (!list.contains(bgb)) {
                list.add(bgb);
                if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
                    info("  >>> getAllSpawnBiomes: " + bgb.getBiomeName());
                }
            }
        }
        return list.toArray(new Biome[0]);
    }
	
	public void info(String s)
    {
        logger.info(s);
    }
	
}
