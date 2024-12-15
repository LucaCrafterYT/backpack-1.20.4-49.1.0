package net.lucacrafter.crafterbackpack.world.inventory;

import net.lucacrafter.crafterbackpack.registry.ModContainers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public abstract class BackpackContainer extends AbstractContainerMenu {
    private final SimpleContainer backpackInventory;

    public BackpackContainer(int id, Inventory playerInventory, SimpleContainer inventory) {
        super(ModContainers.BACKPACK_CONTAINER.get(), id);
        this.backpackInventory = inventory;

        // Add backpack slots (3 rows of 9 slots)
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(backpackInventory, col + row * 9, 8 + col * 18, 18 + row * 18));
            }
        }

        // Add player inventory slots
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        // Add player hotbar slots
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }
    }

    @Override
    public boolean stillValid(Inventory playerInventory) {
        return true; // Keep the container valid as long as it's open.
    }

    @Override
    public ItemStack quickMoveStack(Inventory playerInventory, int index) {
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack stack = slot.getItem();
            ItemStack copy = stack.copy();

            if (index < this.backpackInventory.getContainerSize()) {
                // Move from backpack to player inventory
                if (!this.moveItemStackTo(stack, this.backpackInventory.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                // Move from player inventory to backpack
                if (!this.moveItemStackTo(stack, 0, this.backpackInventory.getContainerSize(), false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (stack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            return copy;
        }

        return ItemStack.EMPTY;
    }
}
