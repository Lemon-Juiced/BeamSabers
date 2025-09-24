package site.scalarstudios.beam_sabers.item.custom.sword;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import site.scalarstudios.beam_sabers.item.custom.tier.BeamSabersTiers;

/**
 * Traditional sword item, but allows the player to fling themselves forward when right-clicked.
 * The fling ability has a cooldown to prevent spamming.
 */
public class GreatSaberItem extends SwordItem {

    public GreatSaberItem(Properties properties) {
        super(BeamSabersTiers.GREAT_TIER, properties.attributes(SwordItem.createAttributes(BeamSabersTiers.GREAT_TIER, 3, -2.4F)));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        // Only fling if not on cooldown
        if (!level.isClientSide && !player.getCooldowns().isOnCooldown(this)) {
            double flingStrength = 1.0;
            Vec3 look = player.getLookAngle();
            Vec3 forward = new Vec3(look.x, 0.1, look.z).normalize().scale(flingStrength);
            player.setDeltaMovement(forward);
            player.hurtMarked = true;
            player.fallDistance = 0.0F;
            player.getCooldowns().addCooldown(this, 20); // 1 second cooldown
            return InteractionResultHolder.success(player.getItemInHand(hand));
        }
        return InteractionResultHolder.fail(player.getItemInHand(hand));
    }
}