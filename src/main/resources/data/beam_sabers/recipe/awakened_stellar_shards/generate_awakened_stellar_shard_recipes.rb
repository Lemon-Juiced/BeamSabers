require 'json'
require 'fileutils'

# List of Minecraft dye colors
COLORS = %w[
  white light_gray gray black brown red orange yellow lime green cyan light_blue blue purple magenta pink
]

# Output directory for recipes (relative to script location)
OUTPUT_DIR = File.expand_path("../", __FILE__)

COLORS.each do |color|
  recipe = {
    "type" => "minecraft:crafting_shapeless",
    "ingredients" => [
      { "item" => "beam_sabers:#{color}_stellar_shard" },
      { "item" => "minecraft:nether_star" }
    ],
    "result" => {
      "id" => "beam_sabers:awakened_#{color}_stellar_shard",
      "count" => 1
    }
  }

  filename = File.join(OUTPUT_DIR, "awakened_#{color}_stellar_shard.json")
  File.write(filename, JSON.pretty_generate(recipe))
end

