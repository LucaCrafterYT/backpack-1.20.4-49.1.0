package net.lucacrafter.crafterbackpack.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.lucacrafter.crafterbackpack.BackpackMod;

public class CbpModTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BackpackMod.MOD_ID);
    public static final RegistryObject<CreativeModeTab> CRAFTER_BACKPACK = REGISTRY.register("crafter_backpack",
            () -> CreativeModeTab.builder().title(Component.translatable("creativetab.crafter_backpack")).icon(() -> new ItemStack(CbpModItems.BACKPACK.get())).displayItems((parameters, tabData) -> {
                        tabData.accept(CbpModItems.BACKPACK.get());
                        tabData.accept(CbpModItems.LEATHER_STRAP.get());
                    })

                    .build());
}
