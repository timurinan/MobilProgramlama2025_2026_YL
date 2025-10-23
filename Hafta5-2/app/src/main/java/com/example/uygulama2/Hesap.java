package com.example.uygulama2;

public class Hesap {

    private String hesapsahibi,hesaptürü;
    private double hesapbakiyesi;

    public Hesap(String hesapsahibi, String hesaptürü, double hesapbakiyesi) {
        this.hesapsahibi = hesapsahibi;
        this.hesaptürü = hesaptürü;
        this.hesapbakiyesi = hesapbakiyesi;
    }

    public String getHesapsahibi() {
        return hesapsahibi;
    }

    public void setHesapsahibi(String hesapsahibi) {
        this.hesapsahibi = hesapsahibi;
    }

    public String getHesaptürü() {
        return hesaptürü;
    }

    public void setHesaptürü(String hesaptürü) {
        this.hesaptürü = hesaptürü;
    }

    public double getHesapbakiyesi() {
        return hesapbakiyesi;
    }

    public void setHesapbakiyesi(double hesapbakiyesi) {
        this.hesapbakiyesi = hesapbakiyesi;
    }
}
