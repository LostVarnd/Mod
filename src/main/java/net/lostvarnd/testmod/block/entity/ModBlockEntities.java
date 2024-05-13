package net.lostvarnd.testmod.block.entity;

import net.lostvarnd.testmod.TestMod;
import net.lostvarnd.testmod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TestMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<OreProcessorBlockEntity>> ORE_PROCESSOR =
            BLOCK_ENTITIES.register("ore_processor", () ->
                    BlockEntityType.Builder.of(OreProcessorBlockEntity::new, ModBlocks.ORE_PROCESSOR.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
