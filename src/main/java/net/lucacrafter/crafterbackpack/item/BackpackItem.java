package net.lucacrafter.crafterbackpack.item;

import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.SimpleMenuProvider;

import net.lucacrafter.crafterbackpack.world.inventory.BackpackContainer;

public class BackpackItem extends Item {
    public BackpackItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();

        if (!level.isClientSide && player != null) {
            ItemStack stack = context.getItemInHand();
            SimpleContainer inventory = loadInventory(stack);

            player.openMenu(new SimpleMenuProvider((id, playerInv, playerEntity) ->
                    new BackpackContainer(id, playerInv, inventory) {
                        @Override
                        public ItemStack quickMoveStack(Player player, int i) {
                            return null;
                        }

                        @Override
                        public boolean stillValid(Player player) {
                            return false;
                        }
                    }, Component.literal("Backpack")));

            return InteractionResult.SUCCESS;
        }

        return super.useOn(context);
    }

    /**
     * Loads the inventory from the ItemStack's NBT data.
     *
     * @param stack The ItemStack holding the backpack's data.
     * @return A SimpleContainer with the saved items.
     */
    private SimpleContainer loadInventory(ItemStack stack) {
        SimpleContainer inventory = new SimpleContainer(27); // Adjust size as needed

        if (stack.hasTag() && stack.getTag().contains("BackpackItems")) {
            ListTag tagList = stack.getTag().getList("BackpackItems", 10); // 10 = CompoundTag
            for (int i = 0; i < tagList.size(); i++) {
                CompoundTag itemTag = tagList.getCompound(i);
                int slot = itemTag.getInt("Slot");
                if (slot >= 0 && slot < inventory.getContainerSize()) {
                    inventory.setItem(slot, ItemStack.of(itemTag));
                }
            }
        }

        return inventory;
    }

    /**
     * Saves the inventory to the ItemStack's NBT data.
     *
     * @param stack     The ItemStack to save the inventory into.
     * @param inventory The SimpleContainer holding the items to save.
     */
    public static void saveInventory(ItemStack stack, SimpleContainer inventory) {
        ListTag tagList = new ListTag();

        for (int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack itemStack = inventory.getItem(i);
            if (!itemStack.isEmpty()) {
                CompoundTag itemTag = new CompoundTag();
                itemTag.putInt("Slot", i);
                itemStack.save(itemTag);
                tagList.add(itemTag);
            }
        }

        if (!stack.hasTag()) {
            stack.setTag(new CompoundTag());
        }
        stack.getTag().put("BackpackItems", tagList);
    }
}
