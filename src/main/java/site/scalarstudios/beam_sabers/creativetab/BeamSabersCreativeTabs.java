package site.scalarstudios.beam_sabers.creativetab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import site.scalarstudios.beam_sabers.BeamSabers;
import site.scalarstudios.beam_sabers.block.BeamSabersBlocks;
import site.scalarstudios.beam_sabers.item.BeamSabersItems;
import site.scalarstudios.beam_sabers.item.custom.AwakenedStellarShardItem;
import site.scalarstudios.beam_sabers.item.custom.StellarShardItem;
import site.scalarstudios.beam_sabers.item.custom.sword.StandardSaberItem;

public class BeamSabersCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BeamSabers.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BEAM_SABERS_ITEMS_TAB = CREATIVE_MODE_TABS.register("beam_sabers_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.beam_sabers.items"))
            .icon(() -> new ItemStack(BeamSabersItems.BLANK_STELLAR_SHARD.get()))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == BEAM_SABERS_ITEMS_TAB.get()) {
            event.accept(BeamSabersItems.BLANK_STELLAR_SHARD.get());
            event.accept(BeamSabersItems.HILT.get());
            event.accept(BeamSabersItems.STANDARD_SWORD_SMITHING_TEMPLATE.get());
            event.accept(BeamSabersItems.GREAT_SWORD_SMITHING_TEMPLATE.get());
            event.accept(BeamSabersItems.CURVED_HILT_SWORD_SMITHING_TEMPLATE.get());
            event.accept(BeamSabersItems.SHOTO_SWORD_SMITHING_TEMPLATE.get());
            for (DeferredHolder<Item, ? extends Item> item : BeamSabersItems.ITEMS.getEntries())
                if (item.get() instanceof StellarShardItem && item.get() != BeamSabersItems.BLANK_STELLAR_SHARD.get())
                    event.accept(item.get());
            for (DeferredHolder<Item, ? extends Item> item : BeamSabersItems.ITEMS.getEntries())
                if (item.get() instanceof AwakenedStellarShardItem) event.accept(item.get());
            for (DeferredHolder<Item, ? extends Item> item : BeamSabersItems.ITEMS.getEntries())
                if (item.get() instanceof StandardSaberItem) event.accept(item.get());
            event.accept(BeamSabersBlocks.BLANK_STELLAR_ORE.get());
            event.accept(BeamSabersBlocks.DEEPSLATE_BLANK_STELLAR_ORE.get());
            event.accept(BeamSabersBlocks.NETHER_BLANK_STELLAR_ORE.get());
            event.accept(BeamSabersBlocks.END_BLANK_STELLAR_ORE.get());
            event.accept(BeamSabersBlocks.GREEN_STELLAR_ORE.get());
            event.accept(BeamSabersBlocks.DEEPSLATE_BLUE_STELLAR_ORE.get());
            event.accept(BeamSabersBlocks.NETHER_RED_STELLAR_ORE.get());
            event.accept(BeamSabersBlocks.END_PURPLE_STELLAR_ORE.get());
        }
    }

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
