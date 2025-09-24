package site.scalarstudios.beam_sabers.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import site.scalarstudios.beam_sabers.BeamSabers;
import site.scalarstudios.beam_sabers.BeamSabersUtilLists;
import site.scalarstudios.beam_sabers.item.custom.AwakenedStellarShardItem;
import site.scalarstudios.beam_sabers.item.custom.StellarShardItem;
import site.scalarstudios.beam_sabers.item.custom.sword.CurvedHiltSaberItem;
import site.scalarstudios.beam_sabers.item.custom.sword.GreatSaberItem;
import site.scalarstudios.beam_sabers.item.custom.sword.ShotoSaberItem;
import site.scalarstudios.beam_sabers.item.custom.sword.StandardSaberItem;

import java.util.ArrayList;
import java.util.function.Supplier;

public class BeamSabersItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(BeamSabers.MODID);

    // Manually Registered Items
    public static final Supplier<Item> BLANK_STELLAR_SHARD = ITEMS.register("blank_stellar_shard", () -> new StellarShardItem(new Item.Properties()));

    public static void register(IEventBus eventBus){
        generateStellarShards();
        generateBeamSabers();
        ITEMS.register(eventBus);
    }

    public static void generateStellarShards() {
        ArrayList<String> colors = BeamSabersUtilLists.getColors();
        for (int i = 0; i < colors.size(); i++) {
            ITEMS.register(colors.get(i) + "_stellar_shard", () -> new StellarShardItem(new Item.Properties()));
            ITEMS.register("awakened_" + colors.get(i) + "_stellar_shard", () -> new AwakenedStellarShardItem((new Item.Properties()).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));
        }
    }

    public static void generateBeamSabers() {
        ArrayList<String> colors = BeamSabersUtilLists.getColors();
        for (int i = 0; i < colors.size(); i++) {
            ITEMS.register(colors.get(i) + "_beam_saber", () -> new StandardSaberItem(new Item.Properties()));
            ITEMS.register(colors.get(i) + "_great_beam_saber", () -> new GreatSaberItem(new Item.Properties()));
            ITEMS.register(colors.get(i) + "_curved_hilt_beam_saber", () -> new CurvedHiltSaberItem(new Item.Properties()));
            ITEMS.register(colors.get(i) + "_shoto_beam_saber", () -> new ShotoSaberItem(new Item.Properties()));
        }
    }


}
