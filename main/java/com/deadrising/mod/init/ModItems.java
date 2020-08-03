 package com.deadrising.mod.init;

import java.util.ArrayList;
import java.util.List;

import com.deadrising.mod.deadrising;

import com.deadrising.mod.item.FoodBase;
import com.deadrising.mod.item.ItemBase;
import com.deadrising.mod.item.ItemCure;
import com.deadrising.mod.item.ItemExplodeable;
import com.deadrising.mod.item.ItemGears;
import com.deadrising.mod.item.ItemHeal;
import com.deadrising.mod.item.ItemHealCure;
import com.deadrising.mod.item.ItemMedical;
import com.deadrising.mod.item.ItemMelee;

import net.minecraft.block.BlockBed;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.text.TextFormatting;
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
	public static final ToolMaterial MATERIAL_cleaver = EnumHelper.addToolMaterial("MATERIAL_cleaver", 2, 1530, 4.0F, 1.5F, 14);
	public static final ToolMaterial MATERIAL_BaseballBat = EnumHelper.addToolMaterial("MATERIAL_BaseballBat", 2, 1530, 4.0F, 1.0F, 14);
	public static final ToolMaterial MATERIAL_BaseballBatNailed = EnumHelper.addToolMaterial("MATERIAL_BaseballBatNailed", 2, 1530, 4.0F, 1.2F, 14);
	public static final ToolMaterial MATERIAL_Fireaxe = EnumHelper.addToolMaterial("MATERIAL_Fireaxe", 2, 1530, 4.0F, 1.2F, 14);
	

	//Medical
	public static final Item MEDKIT = new ItemHealCure("medkit", 8, 10, 1, deadrising.TabMedical);
	public static final Item BANDAGE = new ItemHeal("bandage", 4, 4, 6, deadrising.TabMedical);
	public static final Item BANDAID = new ItemHeal("bandaid", 2, 4, 6, deadrising.TabMedical);
	public static final Item PAINKILLERS = new ItemHeal("painkillers", 3, 3, 6, deadrising.TabMedical);
	public static final Item CURE = new ItemCure("cure", 7, 6);
	public static final Item EMPTYCURE = new ItemMedical("emptycure");

	//Melee
	public static final Item BOWIE = new ItemMelee(MATERIAL_bowie, "bowie", 1, deadrising.TabMelee);
	public static final Item COMBAT_KNIFE = new ItemMelee(MATERIAL_combat_knife, "combat_knife", 1, deadrising.TabMelee);
	public static final Item KATANA = new ItemMelee(MATERIAL_KATANA, "KATANA", 1, deadrising.TabMelee);
	public static final Item WRENCH = new ItemMelee(MATERIAL_wrench, "wrench", 1, deadrising.TabMelee);
	public static final Item CLEAVER = new ItemMelee(MATERIAL_cleaver, "cleaver", 1, deadrising.TabMelee);
	public static final Item BASEBALLBATNAILED = new ItemMelee(MATERIAL_BaseballBatNailed, "item_bat_nailed", 1, deadrising.TabMelee);
	public static final Item BASEBALLBAT = new ItemMelee(MATERIAL_BaseballBat, "item_bat", 1, deadrising.TabMelee);
	public static final Item FIREAXE = new ItemMelee(MATERIAL_Fireaxe, "item_fire_axe", 1, deadrising.TabMelee);
	
	
	//Throwables
	public static final ItemExplodeable GRENADE = new ItemExplodeable("grenade", 80, ItemExplodeable.Helper::onFragRemoved);
	public static final ItemExplodeable SMOKE = (new ItemExplodeable("smoke", 80, ItemExplodeable.Helper::onSmokeRemoved)).addAditionalDescription(new String[] { "Effect duration: 20s", TextFormatting.RED + "Water will cancel the effect!" });
	public static final ItemExplodeable MOLOTOV = (new ItemExplodeable("molotov", -1, ItemExplodeable.Helper::onMolotovRemoved)).addAditionalDescription(new String[] { "Effect duration: 10s", TextFormatting.RED + "Water will cancel the effect!" });
	  
	//Items
	public static final Item BREIFCASE = new ItemBase("briefcase");
	public static final Item GEARS = new ItemGears("gears");
	
	//Food
	public static final Item Item_Beans = (new FoodBase("item_beans", 5, 2.4f, false, 1, deadrising.TabFood)).addAditionalDescription(new String[] {TextFormatting.GRAY + "Feeds: 5"});
	public static final Item Item_Fish = (new FoodBase("item_fish", 3, 4.4f, false, 1, deadrising.TabFood)).addAditionalDescription(new String[] {TextFormatting.GRAY + "Feeds: 3"});
	public static final Item Item_Fruit = (new FoodBase("item_fruit", 2, 2.4f, false, 1, deadrising.TabFood)).addAditionalDescription(new String[] {TextFormatting.GRAY + "Feeds: 2"});
	public static final Item Item_Pasta = (new FoodBase("item_pasta", 4, 2.4f, false, 1, deadrising.TabFood)).addAditionalDescription(new String[] {TextFormatting.GRAY + "Feeds: 4"});
	public static final Item Item_Pickles = (new FoodBase("item_pickles", 3, 2.4f, false, 1, deadrising.TabFood)).addAditionalDescription(new String[] {TextFormatting.GRAY + "Feeds: 4"});
	public static final Item Item_Soup = (new FoodBase("item_soup", 3, 2.4f, false, 1, deadrising.TabFood)).addAditionalDescription(new String[] {TextFormatting.GRAY + "Feeds: 3"});
	public static final Item Item_spag = (new FoodBase("item_spag", 4, 2.6f, false, 1, deadrising.TabFood)).addAditionalDescription(new String[] {TextFormatting.GRAY + "Feeds: 4"});
	public static final Item Item_sardines = (new FoodBase("item_sardines", 5, 3.4f, false, 1, deadrising.TabFood)).addAditionalDescription(new String[] {TextFormatting.GRAY + "Feeds: 5"});
	public static final Item Item_canned_tuna = (new FoodBase("item_canned_tuna", 5, 3.4f, false, 1, deadrising.TabFood)).addAditionalDescription(new String[] {TextFormatting.GRAY + "Feeds: 5"});	
	public static final Item Item_Noodles = (new FoodBase("item_noodles", 5, 2.4f, false, 1, deadrising.TabFood)).addAditionalDescription(new String[] {TextFormatting.GRAY + "Feeds: 5"});
	
	

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