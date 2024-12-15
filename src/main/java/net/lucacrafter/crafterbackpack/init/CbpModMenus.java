package net.lucacrafter.crafterbackpack.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.lucacrafter.crafterbackpack.world.inventory.ContainerScreenMenu;
import net.lucacrafter.crafterbackpack.BackpackMod;

public class CbpModMenus {
    public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, BackpackMod.MOD_ID);
    public static final RegistryObject<MenuType<ContainerScreenMenu>> CONTAINER_SCREEN = REGISTRY.register("container_screen", () -> IForgeMenuType.create(ContainerScreenMenu::new));
}
