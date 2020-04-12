package com.deadrising.mod.utils.events;

import java.util.ArrayDeque;
import java.util.List;

import com.deadrising.mod.deadrising;
import com.deadrising.mod.entity.EntityDRZombie;
import com.deadrising.mod.utils.handlers.ConfigHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;

@EventBusSubscriber
public class MainEvents 
{
	@SubscribeEvent
	public static void onPlayerLeave(PlayerEvent.PlayerLoggedOutEvent e)
	{
        if(!e.player.getEntityWorld().isRemote)
        {
    		ConfigHandler.ClientSide.HELMET = e.player.inventory.armorInventory.get(3);
            ConfigHandler.ClientSide.CHESTPLATE = e.player.inventory.armorInventory.get(2);
            ConfigHandler.ClientSide.LEGGINGS = e.player.inventory.armorInventory.get(1);
            ConfigHandler.ClientSide.BOOTS = e.player.inventory.armorInventory.get(0);
            ConfigHandler.ClientSide.lastMainItem = e.player.getHeldItemMainhand();
        }
	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onLivingDeath(LivingDeathEvent event) {
		EntityLivingBase ent = event.getEntityLiving();
		if (ent.world.isRemote) return;
		if (event.isCanceled()) return;

		if (ent instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();

			if(event.getSource() == DamageSource.WITHER)
			{
				EntityDRZombie z = new EntityDRZombie(ent.world);
				z.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND));
				z.setItemStackToSlot(EntityEquipmentSlot.HEAD, player.getItemStackFromSlot(EntityEquipmentSlot.HEAD));
				z.setItemStackToSlot(EntityEquipmentSlot.CHEST, player.getItemStackFromSlot(EntityEquipmentSlot.CHEST));
				z.setItemStackToSlot(EntityEquipmentSlot.LEGS, player.getItemStackFromSlot(EntityEquipmentSlot.LEGS));
				z.setItemStackToSlot(EntityEquipmentSlot.FEET, player.getItemStackFromSlot(EntityEquipmentSlot.FEET));
				
				z.setDropItemsWhenDead(true);
				z.setDropChance(EntityEquipmentSlot.MAINHAND, 100);
				z.setDropChance(EntityEquipmentSlot.HEAD, 100);
				z.setDropChance(EntityEquipmentSlot.CHEST, 100);
				z.setDropChance(EntityEquipmentSlot.LEGS, 100);
				z.setDropChance(EntityEquipmentSlot.FEET, 100);
				
				ent.world.spawnEntity(z);
			}
		}
	}
	
}
