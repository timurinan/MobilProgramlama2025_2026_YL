package com.example.uygulama2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager2 vp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp2=findViewById(R.id.view_pager);

        Hesap hesap1=new Hesap("Timur İnan","TL",10000);
        Hesap hesap2=new Hesap("Ahmet Yalnız","Euro",500);
        Hesap hesap3=new Hesap("Sevgi Köroğlu","Dolar",1000);
        Hesap hesap4=new Hesap("Hande Müftüoğlu","Altın",20);
        Hesap hesap5=new Hesap("Görkem Kaynar","Fon",200000);

        Fragment_Hesap fragment_hesap1=new Fragment_Hesap();
        fragment_hesap1.setHesap(hesap1);

        Fragment_Hesap fragment_hesap2=new Fragment_Hesap();
        fragment_hesap2.setHesap(hesap2);

        Fragment_Hesap fragment_hesap3=new Fragment_Hesap();
        fragment_hesap3.setHesap(hesap3);

        Fragment_Hesap fragment_hesap4=new Fragment_Hesap();
        fragment_hesap4.setHesap(hesap4);

        Fragment_Hesap fragment_hesap5=new Fragment_Hesap();
        fragment_hesap5.setHesap(hesap5);

        Fragment_Adapter fa=new Fragment_Adapter(getSupportFragmentManager(),getLifecycle());

        fa.addHesap(fragment_hesap1);
        fa.addHesap(fragment_hesap2);
        fa.addHesap(fragment_hesap3);
        fa.addHesap(fragment_hesap4);
        fa.addHesap(fragment_hesap5);

        vp2.setAdapter(fa);

    }
}