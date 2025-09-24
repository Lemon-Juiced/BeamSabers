# Generates smithing recipes for all beam saber combinations
require 'json'

# Templates and their corresponding outcome suffixes
TEMPLATES = {
  'standard_sword_smithing_template' => '',
  'great_sword_smithing_template' => '_great',
  'curved_hilt_sword_smithing_template' => '_curved_hilt',
  'shoto_sword_smithing_template' => '_shoto'
}

# Colors and their awakened stellar shards
COLORS = [
  'white', 'light_gray', 'gray', 'black', 'brown', 'red', 'orange', 'yellow',
  'lime', 'green', 'cyan', 'light_blue', 'blue', 'purple', 'magenta', 'pink'
]

MODID = 'beam_sabers'

# Recipe output directory (change as needed)
output_dir = File.expand_path(File.dirname(__FILE__))

COLORS.each do |color|
  TEMPLATES.each do |template, suffix|
    recipe = {
      'type' => 'minecraft:smithing_transform',
      'addition' => { 'item' => "#{MODID}:awakened_#{color}_stellar_shard" },
      'base' => { 'item' => "#{MODID}:hilt" },
      'result' => { 'id' => "#{MODID}:#{color}#{suffix}_beam_saber", 'count' => 1 },
      'template' => { 'item' => "#{MODID}:#{template}" }
    }
    # Output file name
    file_name = "#{color}#{suffix}_beam_saber.json"
    file_path = File.join(output_dir, file_name)
    File.write(file_path, JSON.pretty_generate(recipe))
  end
end
puts "Beam saber smithing recipes generated in #{output_dir}"
