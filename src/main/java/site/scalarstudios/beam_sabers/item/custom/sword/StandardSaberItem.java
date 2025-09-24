package site.scalarstudios.beam_sabers.item.custom.sword;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import site.scalarstudios.beam_sabers.item.custom.tier.BeamSabersTiers;

public class StandardSaberItem extends SwordItem {

    public StandardSaberItem(Properties properties) {
        this(BeamSabersTiers.STANDARD_TIER, properties);
    }

    public StandardSaberItem(Tier tier, Properties properties) {
        super(tier, properties.attributes(SwordItem.createAttributes(tier, 3, -2.4F)));
    }
}
