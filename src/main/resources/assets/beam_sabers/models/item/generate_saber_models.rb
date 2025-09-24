colors = %w[
  white orange magenta light_blue yellow lime pink gray
  light_gray cyan purple blue brown green red black
]

saber_types = [
  {
    type: 'standard',
    hilt: 'standard_hilt',
    blade: '%{color}_standard_blade',
    name: '%{color}_beam_saber'
  },
  {
    type: 'great',
    hilt: 'great_hilt',
    blade: '%{color}_great_blade',
    name: '%{color}_great_beam_saber'
  },
  {
    type: 'curved_hilt',
    hilt: 'curved_hilt_hilt',
    blade: '%{color}_curved_hilt_blade',
    name: '%{color}_curved_hilt_beam_saber'
  }
]

curved_hilt_display = <<~JSON.chomp
  "display": {
    "thirdperson_righthand": {
      "rotation": [0, 90, -35],
      "translation": [0, 4.0, 2.0],
      "scale": [0.85, 0.85, 0.85]
    },
    "thirdperson_lefthand": {
      "rotation": [0, 90, -35],
      "translation": [0, 4.0, 2.0],
      "scale": [0.85, 0.85, 0.85]
    }
  }
JSON

colors.each do |color|
  saber_types.each do |type|
    name = type[:name] % { color: color }
    hilt_texture = "beam_sabers:item/#{type[:hilt]}"
    blade_texture = "beam_sabers:item/#{type[:blade] % { color: color }}"
    if type[:type] == 'curved_hilt'
      json_content = <<~JSON
      {
        "parent": "item/handheld",
        "textures": {
          "layer0": "#{hilt_texture}",
          "layer1": "#{blade_texture}"
        },
        #{curved_hilt_display}
      }
      JSON
    else
      json_content = <<~JSON
      {
        "parent": "item/handheld",
        "textures": {
          "layer0": "#{hilt_texture}",
          "layer1": "#{blade_texture}"
        }
      }
      JSON
    end
    File.write("#{name}.json", json_content)
  end
end