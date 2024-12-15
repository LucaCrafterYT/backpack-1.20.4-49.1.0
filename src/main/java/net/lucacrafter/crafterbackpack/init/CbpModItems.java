package net.lucacrafter.crafterbackpack.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.lucacrafter.crafterbackpack.item.LeatherStrapItem;
import net.lucacrafter.crafterbackpack.item.BackpackItem;
import net.lucacrafter.crafterbackpack.BackpackMod;

public class CbpModItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BackpackMod.MOD_ID);
    public static final RegistryObject<Item> BACKPACK = REGISTRY.register("backpack", () -> new BackpackItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LEATHER_STRAP = REGISTRY.register("leather_strap", () -> new LeatherStrapItem());
}
