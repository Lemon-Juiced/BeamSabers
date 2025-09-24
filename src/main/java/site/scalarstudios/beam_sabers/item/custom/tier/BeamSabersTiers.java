package site.scalarstudios.beam_sabers.item.custom.tier;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import site.scalarstudios.beam_sabers.tag.BeamSabersTags;

public class BeamSabersTiers {
    public static final Tier CURVED_HILT_TIER = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0F, 2.0F, 20, () -> Ingredient.of(BeamSabersTags.Items.AWAKENED_STELLAR_SHARDS));
    public static final Tier GREAT_TIER = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0F, 3.0F, 20, () -> Ingredient.of(BeamSabersTags.Items.AWAKENED_STELLAR_SHARDS));
    public static final Tier STANDARD_TIER = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0F, 4.0F, 20, () -> Ingredient.of(BeamSabersTags.Items.AWAKENED_STELLAR_SHARDS));

    // Vanilla Reference:
    // WOOD      = new SimpleTier(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 59, 2.0F, 0.0F, 15, () -> Ingredient.of(ItemTags.PLANKS));
    // STONE     = new SimpleTier(BlockTags.INCORRECT_FOR_STONE_TOOL, 131, 4.0F, 1.0F, 5, () -> Ingredient.of(ItemTags.STONE_TOOL_MATERIALS));
    // IRON      = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 2.0F, 14, () -> Ingredient.of(Items.IRON_INGOT));
    // GOLD      = new SimpleTier(BlockTags.INCORRECT_FOR_GOLD_TOOL, 32, 12.0F, 0.0F, 22, () -> Ingredient.of(Items.GOLD_INGOT));
    // DIAMOND   = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1561, 8.0F, 3.0F, 10, () -> Ingredient.of(Items.DIAMOND));
    // NETHERITE = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0F, 4.0F, 15, () -> Ingredient.of(Items.NETHERITE_INGOT));
}
