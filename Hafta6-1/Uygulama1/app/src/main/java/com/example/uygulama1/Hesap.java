package com.example.uygulama1;

public class Hesap {

    private String hesapsahibi, hesaptürü;
    private double bakiye;

    public Hesap(String hesapsahibi, String hesaptürü, double bakiye) {
        this.hesapsahibi = hesapsahibi;
        this.hesaptürü = hesaptürü;
        this.bakiye = bakiye;
    }

    public String getHesaptürü() {
        return hesaptürü;
    }

    public void setHesaptürü(String hesaptürü) {
        this.hesaptürü = hesaptürü;
    }

    public String getHesapsahibi() {
        return hesapsahibi;
    }

    public void setHesapsahibi(String hesapsahibi) {
        this.hesapsahibi = hesapsahibi;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }
}
