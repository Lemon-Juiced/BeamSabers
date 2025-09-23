package site.scalarstudios.beam_sabers.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import site.scalarstudios.beam_sabers.BeamSabers;

public class BeamSabersTags {
    public static void init() {
        Items.init();
    }

    private BeamSabersTags() {}

    public static class Items {
        private static void init() {}
        private Items() {}

        public static final TagKey<Item> AWAKENED_STELLAR_SHARDS = tag("awakened_stellar_shards");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(BeamSabers.MODID, name));
        }
    }

}
