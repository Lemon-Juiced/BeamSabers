package site.scalarstudios.beam_sabers.item.custom.sword;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * Traditional sword item, but with a shorter range.
 * The tradeoff is that it has a higher chance to critically hit.
 */
public class ShotoSaberItem extends StandardSaberItem implements LimitedReachItem {
    private static final double CRIT_CHANCE = 0.1;
    private static final double CRIT_MULTIPLIER = 1.1;

    public ShotoSaberItem(Properties properties) {
        super(properties);
    }

    @Override
    public float getLimitedReach(Level level, LivingEntity attacker, ItemStack stack) {
        return 2.0F; // Shorter than vanilla sword reach
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean isCrit = false;
        if (attacker instanceof Player player) {
            if (player.getRandom().nextDouble() < CRIT_CHANCE) {
                isCrit = true;
            }
        }
        if (isCrit && attacker instanceof Player player) {
            var attr = player.getAttribute(Attributes.ATTACK_DAMAGE);
            float baseDamage = attr != null && attr.getValue() != 0 ? (float)attr.getValue() : 1.0F;
            target.hurt(target.damageSources().playerAttack(player), baseDamage * (float)CRIT_MULTIPLIER);
            return true;
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.beam_sabers.shoto_saber"));
    }
}
