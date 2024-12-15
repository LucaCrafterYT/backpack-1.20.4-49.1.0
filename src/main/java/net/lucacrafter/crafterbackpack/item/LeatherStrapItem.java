
package net.lucacrafter.crafterbackpack.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class LeatherStrapItem extends Item {
    public LeatherStrapItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
