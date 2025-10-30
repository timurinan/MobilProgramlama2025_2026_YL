package com.example.uygulama1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ViewPager2 vp2=findViewById(R.id.viewPager2);

        Hesap hesap1=new Hesap("Timur İnan","Türk Lirası",10000);
        Hesap hesap2=new Hesap("Ahmet Canlı","Dolar",5000);
        Hesap hesap3=new Hesap("Hüseyin Toprak","Euro",100000);
        Hesap hesap4=new Hesap("Berna Kurnaz","Altın(gr)",100);

        HesapFragment hesapFragment1=new HesapFragment(hesap1);
        HesapFragment hesapFragment2=new HesapFragment(hesap2);
        HesapFragment hesapFragment3=new HesapFragment(hesap3);
        HesapFragment hesapFragment4=new HesapFragment(hesap4);

        FragmentAdapter fa=new FragmentAdapter(getSupportFragmentManager(),getLifecycle());

        fa.addFragment(hesapFragment1);
        fa.addFragment(hesapFragment2);
        fa.addFragment(hesapFragment3);
        fa.addFragment(hesapFragment4);

        vp2.setAdapter(fa);

    }
}