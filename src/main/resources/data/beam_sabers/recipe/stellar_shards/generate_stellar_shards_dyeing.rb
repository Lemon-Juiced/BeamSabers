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
      { "tag" => "beam_sabers:stellar_shards" },
      { "item" => "minecraft:#{color}_dye" }
    ],
    "result" => {
      "id" => "beam_sabers:#{color}_stellar_shard",
      "count" => 1
    }
  }

  filename = File.join(OUTPUT_DIR, "#{color}_stellar_shard_dyeing.json")
  File.write(filename, JSON.pretty_generate(recipe))
end

