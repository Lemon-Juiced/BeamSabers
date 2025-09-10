package site.scalarstudios.beam_sabers;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import site.scalarstudios.beam_sabers.creativetab.BeamSabersCreativeTabs;
import site.scalarstudios.beam_sabers.item.BeamSabersItems;

@Mod(BeamSabers.MODID)
public class BeamSabers {
    public static final String MODID = "beam_sabers";

    public BeamSabers(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        // Register Items
        BeamSabersItems.register(modEventBus);

        // Register Creative Tab
        BeamSabersCreativeTabs.register(modEventBus);
        modEventBus.addListener(BeamSabersCreativeTabs::registerTabs);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}
}
