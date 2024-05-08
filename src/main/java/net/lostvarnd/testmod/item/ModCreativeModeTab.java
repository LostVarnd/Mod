package net.lostvarnd.testmod.item;

import net.lostvarnd.testmod.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab CUSTOM_ITEMS = new CreativeModeTab("custom_items") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ZIRCON.get());
        }
    };

    public static final CreativeModeTab CUSTOM_BLOCKS = new CreativeModeTab("custom_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.ZIRCON_BLOCK.get());
        }
    };
}
