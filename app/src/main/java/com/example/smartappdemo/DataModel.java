package com.example.smartappdemo;

import com.google.gson.annotations.SerializedName;

public class DataModel {

    @SerializedName("Brightness_10")
    private int brightness1;
    @SerializedName("Brightness_20")
    private int brightness2;
    @SerializedName("Brightness_30")
    private int brightness3;
    @SerializedName("Light_ON")
    private int lighton;
    @SerializedName("Light_OFF")
    private int lightoff;

    public int getBrightness1() {
        return brightness1;
    }

    public int getBrightness2() {
        return brightness2;
    }

    public int getBrightness3() {
        return brightness3;
    }

    public int getLighton() {
        return lighton;
    }

    public int getLightoff() {
        return lightoff;
    }
}
