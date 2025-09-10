package site.scalarstudios.beam_sabers.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import site.scalarstudios.beam_sabers.BeamSabers;
import site.scalarstudios.beam_sabers.item.custom.StellarShardItem;

import java.util.function.Supplier;

public class BeamSabersItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(BeamSabers.MODID);

    // Stellar Shards
    public static final Supplier<Item> GREEN_STELLAR_SHARD = ITEMS.register("green_stellar_shard", () -> new StellarShardItem(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
