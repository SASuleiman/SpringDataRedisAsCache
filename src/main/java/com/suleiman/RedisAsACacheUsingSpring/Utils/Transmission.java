package com.suleiman.RedisAsACacheUsingSpring.Utils;

public enum Transmission {
    MANUAL("Manual"),
    AUTOMATIC("Automatic");

    public final String transmission;
    Transmission(String transmission) {
        this.transmission = transmission;
    }


}
