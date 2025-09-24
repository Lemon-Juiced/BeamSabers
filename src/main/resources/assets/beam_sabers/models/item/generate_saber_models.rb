colors = %w[
  white orange magenta light_blue yellow lime pink gray
  light_gray cyan purple blue brown green red black
]

saber_types = [
  {
    prefix: '', # standard
    hilt: 'standard_hilt',
    blade: 'standard_%{color}_blade',
    name: '%{color}_beam_saber'
  },
  {
    prefix: 'great_',
    hilt: 'great_hilt',
    blade: 'great_%{color}_blade',
    name: '%{color}_great_beam_saber'
  },
  {
    prefix: 'curved_hilt_',
    hilt: 'curved_hilt_hilt',
    blade: 'curved_hilt_%{color}_blade',
    name: '%{color}_curved_hilt_beam_saber'
  }
]

colors.each do |color|
  saber_types.each do |type|
    name = type[:name] % { color: color }
    hilt_texture = "beam_sabers:item/#{type[:hilt]}"
    blade_texture = "beam_sabers:item/#{type[:blade] % { color: color }}"
    json_content = <<~JSON
    {
      "parent": "item/handheld",
      "textures": {
        "layer0": "#{hilt_texture}",
        "layer1": "#{blade_texture}"
      }
    }
    JSON
    File.write("#{name}.json", json_content)
  end
end