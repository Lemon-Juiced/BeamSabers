package site.scalarstudios.beam_sabers.creativetab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import site.scalarstudios.beam_sabers.BeamSabers;
import site.scalarstudios.beam_sabers.item.BeamSabersItems;

public class BeamSabersCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BeamSabers.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BEAM_SABERS_ITEMS_TAB = CREATIVE_MODE_TABS.register("beam_sabers_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.beam_sabers.items"))
            .icon(() -> new ItemStack(BeamSabersItems.GREEN_STELLAR_SHARD.get()))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == BEAM_SABERS_ITEMS_TAB.get()) {
            event.accept(BeamSabersItems.GREEN_STELLAR_SHARD.get());
        }
    }

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
