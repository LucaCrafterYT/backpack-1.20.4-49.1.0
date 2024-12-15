package net.lucacrafter.crafterbackpack.registry;

import net.lucacrafter.crafterbackpack.BackpackMod;
import net.lucacrafter.crafterbackpack.container.BackpackContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModContainers {
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, BackpackMod.MOD_ID);

    public static final RegistryObject<MenuType<BackpackContainer>> BACKPACK_MENU = CONTAINERS.register("backpack_menu",
            () -> IForgeMenuType.create((id, inventory, data) -> new BackpackContainer(id, inventory)));
}
