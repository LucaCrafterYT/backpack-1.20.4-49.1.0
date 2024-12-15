package net.lucacrafter.crafterbackpack.registry;

import net.lucacrafter.crafterbackpack.BackpackMod;
import net.lucacrafter.crafterbackpack.world.inventory.BackpackContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModContainers {
    // Register containers
    public static final DeferredRegister<MenuType<?>> CONTAINERS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, BackpackMod.MOD_ID);

    // Register the Backpack Container
    public static final RegistryObject<MenuType<BackpackContainer>> BACKPACK_CONTAINER =
            CONTAINERS.register("backpack_container",
                    () -> IForgeMenuType.create((windowId, playerInventory, data) ->
                            new BackpackContainer(windowId, playerInventory) {
                                public ItemStack quickMoveStack(Player player, int i) {
                                    return null;
                                }

                                public boolean stillValid(Player player) {
                                    return false;
                                }
                            }));

    // Register method to bind the event bus
    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
