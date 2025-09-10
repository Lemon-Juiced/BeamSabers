package site.scalarstudios.beam_sabers;

import java.util.ArrayList;

public class BeamSabersUtilLists {
    public static ArrayList<String> colors = new ArrayList<>(java.util.Arrays.asList("white", "light_gray", "gray", "black", "brown", "red", "orange", "yellow", "lime", "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink"));

    public static ArrayList<String> blades = new ArrayList<>(java.util.Arrays.asList("broadsword", "longsword", "rapier", "cutlass"));

    public static ArrayList<String> getColors() {
        return colors;
    }
    public static ArrayList<String> getBlades() {
        return blades;
    }
}
