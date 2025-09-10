# Ruby script to generate model JSON files for stellar shards
colors = %w[
  white orange magenta light_blue yellow lime pink gray
  light_gray cyan purple blue brown green red black
]

colors.each do |color|
  # Standard stellar shard
  name = "#{color}_stellar_shard"
  json_content = <<~JSON
  {
    "parent": "item/generated",
    "textures": {
      "layer0": "beam_sabers:item/#{name}"
    }
  }
  JSON
  File.write("#{name}.json", json_content)

  # Awakened stellar shard uses the same texture as the standard one
  awakened_name = "awakened_#{color}_stellar_shard"
  awakened_json_content = <<~JSON
  {
    "parent": "item/generated",
    "textures": {
      "layer0": "beam_sabers:item/#{name}"
    }
  }
  JSON
  File.write("#{awakened_name}.json", awakened_json_content)
end
