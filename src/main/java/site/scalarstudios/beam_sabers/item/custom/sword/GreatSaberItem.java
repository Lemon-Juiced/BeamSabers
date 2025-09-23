package site.scalarstudios.beam_sabers.item.custom.sword;

import net.minecraft.world.item.*;

/**
 * Traditional sword item, but allows the player to fling themselves forward when right-clicked.
 * The distance of the fling is determined by how long the player holds right-click before releasing.
 * The fling ability has a cooldown to prevent spamming.
 */
public class GreatSaberItem extends SwordItem {

    public GreatSaberItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    // To Do (Could not get working properly)
}