package site.scalarstudios.beam_sabers.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import site.scalarstudios.beam_sabers.BeamSabers;
import site.scalarstudios.beam_sabers.item.BeamSabersItems;

import java.util.function.Supplier;

public class BeamSabersBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BeamSabers.MODID);

    public static final DeferredBlock<Block> BLANK_STELLAR_ORE = registerBlock("blank_stellar_ore", () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
            .strength(3.0F, 3.0F)
            .requiresCorrectToolForDrops()
            .sound(SoundType.STONE)
            .mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_BLANK_STELLAR_ORE = registerBlock("deepslate_blank_stellar_ore", () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
            .strength(4.5F, 3.0F)
            .requiresCorrectToolForDrops()
            .sound(SoundType.DEEPSLATE)
            .mapColor(MapColor.DEEPSLATE)));
    public static final DeferredBlock<Block> NETHER_BLANK_STELLAR_ORE = registerBlock("nether_blank_stellar_ore", () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
            .strength(3.0F, 3.0F)
            .requiresCorrectToolForDrops()
            .sound(SoundType.NETHER_ORE)
            .mapColor(MapColor.NETHER)));
    public static final DeferredBlock<Block> END_BLANK_STELLAR_ORE = registerBlock("end_blank_stellar_ore", () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
            .strength(3.0F, 3.0F)
            .requiresCorrectToolForDrops()
            .mapColor(MapColor.SAND)));

    public static final DeferredBlock<Block> GREEN_STELLAR_ORE = registerBlock("green_stellar_ore", () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
            .strength(3.0F, 3.0F)
            .requiresCorrectToolForDrops()
            .sound(SoundType.STONE)
            .mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_BLUE_STELLAR_ORE = registerBlock("deepslate_blue_stellar_ore", () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
            .strength(4.5F, 3.0F)
            .requiresCorrectToolForDrops()
            .sound(SoundType.DEEPSLATE)
            .mapColor(MapColor.DEEPSLATE)));
    public static final DeferredBlock<Block> NETHER_RED_STELLAR_ORE = registerBlock("nether_red_stellar_ore", () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
            .strength(3.0F, 3.0F)
            .requiresCorrectToolForDrops()
            .sound(SoundType.NETHER_ORE)
            .mapColor(MapColor.NETHER)));
    public static final DeferredBlock<Block> END_PURPLE_STELLAR_ORE = registerBlock("end_purple_stellar_ore", () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
            .strength(3.0F, 3.0F)
            .requiresCorrectToolForDrops()
            .mapColor(MapColor.SAND)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        BeamSabersItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
