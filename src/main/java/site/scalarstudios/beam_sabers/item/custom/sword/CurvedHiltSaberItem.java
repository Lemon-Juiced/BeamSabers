package site.scalarstudios.beam_sabers.item.custom.sword;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.phys.Vec3;
import site.scalarstudios.beam_sabers.item.custom.tier.BeamSabersTiers;

import java.util.List;

/**
 * Traditional sword item, but allows the player backpedal when right-clicked.
 * Additionally, the sword can be used to break shields (much like an axe).
 */
public class CurvedHiltSaberItem extends StandardSaberItem {
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

    @Override
    public InteractionResultHolder<ItemStack> use(net.minecraft.world.level.Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            Vec3 look = player.getLookAngle();
            double backpedalStrength = 0.5;
            double upwardBoost = 0.0;
            Vec3 backward = new Vec3(-look.x, upwardBoost, -look.z).normalize().scale(backpedalStrength);
            player.setDeltaMovement(backward);
            player.hurtMarked = true;
            player.fallDistance = 0.0F;
        }
        return InteractionResultHolder.success(player.getItemInHand(hand)); // No cooldown
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.beam_sabers.curved_hilt_saber"));
    }
}
