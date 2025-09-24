package site.scalarstudios.beam_sabers.item.custom.sword;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * Interface for items with reduced attack reach.
 */
public interface LimitedReachItem {
    float getLimitedReach(Level level, LivingEntity attacker, ItemStack stack);
}

