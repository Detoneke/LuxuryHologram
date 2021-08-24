package com.realxode.luxuryhologram;

import static com.realxode.luxuryhologram.Utils.color;

public enum HologramType {


    TP_HOLOGRAM("&f[Ir] &6✨"),
    MSG_HOLOGRAM("&f[Ejecutar] &2✎");

    public String string;

    HologramType(String string) {
        this.string = string;
    }

    public String getString() {
        return color(string);
    }

}
