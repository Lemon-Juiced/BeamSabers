package site.scalarstudios.beam_sabers.item.custom.sword;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import site.scalarstudios.beam_sabers.item.custom.tier.BeamSabersTiers;

/**
 * Traditional sword item, but allows the player to do.
 * Additionally, the sword can be used to break shields (much like an axe).
 */
public class CurvedHiltSaberItem extends SwordItem {
    public CurvedHiltSaberItem(Properties properties) {
        super(BeamSabersTiers.CURVED_HILT_TIER, properties.attributes(SwordItem.createAttributes(BeamSabersTiers.CURVED_HILT_TIER, 3, -2.4F)));
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Axe-like shield breaking
        if (target instanceof Player player) {
            if (player.isUsingItem() && player.getUseItem().getItem().getDescriptionId().contains("shield")) {
                player.disableShield();
            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}
