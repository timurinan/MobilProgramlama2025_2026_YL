package com.example.uygulama1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout fl;
    Button buton1,buton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fl=findViewById(R.id.frame_layout);

        buton1=findViewById(R.id.button);
        buton2=findViewById(R.id.button2);

        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.frame_layout,new Fragment1(),null)
                .commit();

        buton1.setOnClickListener(v -> değiştir(new Fragment1()));
        buton2.setOnClickListener(v -> değiştir(new Fragment2()));
    }

    public void değiştir(Fragment fr){
        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.frame_layout,fr,null)
                .commit();
    }

}