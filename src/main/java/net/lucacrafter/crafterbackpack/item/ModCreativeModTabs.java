package net.lucacrafter.crafterbackpack.item;

import net.lucacrafter.crafterbackpack.BackpackMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BackpackMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CRAFTER_BACKPACK = CREATIVE_MODE_TABS.register("crafter_backpack",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BACKPACK.get()))
                .title(Component.translatable("creativetab.crafter_backpack"))
                .displayItems((pParameters, pOutput) -> {
                    pOutput.accept(ModItems.BACKPACK.get());
                    pOutput.accept(ModItems.LEATHER_STRAP.get());
                })
                .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
