package com.realxode.luxuryhologram;

import static com.realxode.luxuryhologram.Utils.color;
import static com.realxode.luxuryhologram.Utils.decolor;

public enum HologramType {

    TP_HOLOGRAM("&f[Ir] &6✈"),
    MSG_HOLOGRAM("&f[Ejecutar] &6✎")
    ;

    public String string;

    HologramType(String string){
        this.string = string;
    }

    public String getString(){
        return color(string);
    }

    public String getStripString(){
        return decolor(string);
    }

}
