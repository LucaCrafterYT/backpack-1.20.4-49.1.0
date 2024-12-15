package net.lucacrafter.crafterbackpack.item;

import net.lucacrafter.crafterbackpack.BackpackMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BackpackMod.MOD_ID);

    public static final RegistryObject<Item> BACKPACK = ITEMS.register("backpack",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> LEATHER_STRAP = ITEMS.register("leather_strap",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
