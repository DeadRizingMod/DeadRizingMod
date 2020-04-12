package com.deadrising.mod.init;

import java.util.ArrayList;
import java.util.List;

import com.deadrising.mod.deadrising;

import com.deadrising.mod.item.FoodBase;
import com.deadrising.mod.item.ItemBase;
import com.deadrising.mod.item.ItemHeal;
import com.deadrising.mod.item.ItemMelee;

import net.minecraft.block.BlockBed;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "deadrising")
public class ModItems
{
	
	public static final List<Item> ITEMS = new ArrayList<Item>();

	
	//Materials
	public static final ToolMaterial MATERIAL_bowie = EnumHelper.addToolMaterial("MATERIAL_bowie", 3, 250, 6.0F, 3.0F, 14);
	public static final ToolMaterial MATERIAL_combat_knife = EnumHelper.addToolMaterial("MATERIAL_combat_knife", 3, 1561, 8.0F, 4.0F, 14);
	public static final ToolMaterial MATERIAL_KATANA = EnumHelper.addToolMaterial("MATERIAL_KATANA", 2, 1530, 4.0F, 5.0F, 14);
	public static final ToolMaterial MATERIAL_wrench = EnumHelper.addToolMaterial("MATERIAL_wrench", 2, 1530, 4.0F, 2.0F, 14);
	public static final ToolMaterial MATERIAL_cleaver = EnumHelper.addToolMaterial("MATERIAL_cleaver", 2, 1530, 4.0F, 1.0F, 14);


	//Medical
	public static final Item MEDKIT = new ItemHeal("medkit", 2, 7, 1, deadrising.TabMedical);
	public static final Item BANDAGE = new ItemHeal("bandage", 3, 4, 6, deadrising.TabMedical);
	public static final Item BANDAID = new ItemHeal("bandaid", 3, 4, 6, deadrising.TabMedical);
	public static final Item PAINKILLERS = new ItemHeal("painkillers", 3, 3, 6, deadrising.TabMedical);
	
	

	//Melee
	public static final Item BOWIE = new ItemMelee(MATERIAL_bowie, "bowie", 1, deadrising.TabMelee);
	public static final Item COMBAT_KNIFE = new ItemMelee(MATERIAL_combat_knife, "combat_knife", 1, deadrising.TabMelee);
	public static final Item KATANA = new ItemMelee(MATERIAL_KATANA, "KATANA", 1, deadrising.TabMelee);
	public static final Item WRENCH = new ItemMelee(MATERIAL_wrench, "wrench", 1, deadrising.TabMelee);
	public static final Item CLEAVER = new ItemMelee(MATERIAL_cleaver, "cleaver", 1, deadrising.TabMelee);
	
	//Food
	public static final Item Item_Beans = new FoodBase("item_beans", 5, 2.4f, false, 1, deadrising.TabFood);
	public static final Item Item_Fish = new FoodBase("item_fish", 3, 2.4f, false, 1, deadrising.TabFood);
	public static final Item Item_Fruit = new FoodBase("item_fruit", 2, 2.4f, false, 1, deadrising.TabFood);
	public static final Item Item_Pasta = new FoodBase("item_pasta", 4, 2.4f, false, 1, deadrising.TabFood);
	public static final Item Item_Pickles = new FoodBase("item_pickles", 3, 2.4f, false, 1, deadrising.TabFood);
	public static final Item Item_Soup = new FoodBase("item_soup", 3, 2.4f, false, 1, deadrising.TabFood);
	public static final Item Item_spag = new FoodBase("item_spag", 4, 2.6f, false, 1, deadrising.TabFood);
	public static final Item Item_sardines = new FoodBase("item_sardines", 5, 3.4f, false, 1, deadrising.TabFood);
	public static final Item Item_canned_sardines = new FoodBase("item_canned_sardines", 5, 3.4f, false, 1, deadrising.TabFood);
	public static final Item Item_canned_tuna = new FoodBase("item_canned_tuna", 5, 3.4f, false, 1, deadrising.TabFood);	
	public static final Item Item_canned_spaghetti = new FoodBase("item_canned_spaghetti", 5, 3.4f, false, 1, deadrising.TabFood);	
	
	

	public static void register() 
	{
		
	}


	/*public static final Item MEDKIT;
	public static final Item FIRST_AID;
	public static final Item BANDAGE;
	public static final Item BANDAID;
	public static final Item PAINKILLERS;
	public static final Item BOWIE;
	public static final Item COMBAT_KNIFE;
	public static final Item KATANA;
	public static ToolMaterial melee;


	static
	{
		MEDKIT = new ItemHeal("medkit", 64, 20);
		FIRST_AID = new ItemHeal("first_aid_kit", 32, 10);
		BANDAGE = new ItemHeal("bandage", 24, 4);
		BANDAID = new ItemHeal("bandaid", 1, 1);
		PAINKILLERS = new ItemRegen("painkillers",16);
		BOWIE = new ItemSharp("bowie");
		COMBAT_KNIFE = new ItemSharp("combat_knife");
		KATANA = new ItemSharp("KATANA");
		
	}

	public static void register()
	{
		register(MEDKIT);
		register(FIRST_AID);
		register(BANDAGE);
		register(BANDAID);
		register(PAINKILLERS);
		register(BOWIE);
		register(COMBAT_KNIFE);
		register(KATANA);
	}

	private static void register(Item item)
	{
		RegistrationHandler.Items.add(item);
	}*/
}