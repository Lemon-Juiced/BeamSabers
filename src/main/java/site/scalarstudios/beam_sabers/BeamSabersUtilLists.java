package site.scalarstudios.beam_sabers;

import java.util.ArrayList;

public class BeamSabersUtilLists {
    public static ArrayList<String> colors = new ArrayList<>(java.util.Arrays.asList(
        "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray",
        "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black"
    ));

    public static ArrayList<String> blades = new ArrayList<>(java.util.Arrays.asList(
        "broadsword", "longsword", "rapier", "cutlass"
    ));

    public static ArrayList<String> getColors() {
        return colors;
    }
    public static ArrayList<String> getBlades() {
        return blades;
    }
}
