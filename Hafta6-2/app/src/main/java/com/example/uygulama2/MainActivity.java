package com.example.uygulama2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Müşteri> müşteriler=new ArrayList<Müşteri>();

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

        RecyclerView rv=findViewById(R.id.recycler);
        FloatingActionButton fab=findViewById(R.id.floatingActionButton);

        müşteriler.add(new Müşteri("Timur İNan","timurinan@hotmail.com","454545454545400"));
        müşteriler.add(new Müşteri("Ahmet Toprak","atoprak@hotmail.com","454785441574754"));
        müşteriler.add(new Müşteri("Berna Sayın","bernsayin@gmail.com","11111111111111"));
        müşteriler.add(new Müşteri("Hüseyin Çalışkan","hcaliskan@outlook.com","222222222222"));
        müşteriler.add(new Müşteri("Timur İNan","timurinan@hotmail.com","454545454545400"));
        müşteriler.add(new Müşteri("Ahmet Toprak","atoprak@hotmail.com","454785441574754"));
        müşteriler.add(new Müşteri("Berna Sayın","bernsayin@gmail.com","11111111111111"));
        müşteriler.add(new Müşteri("Hüseyin Çalışkan","hcaliskan@outlook.com","222222222222"));
        müşteriler.add(new Müşteri("Timur İNan","timurinan@hotmail.com","454545454545400"));
        müşteriler.add(new Müşteri("Ahmet Toprak","atoprak@hotmail.com","454785441574754"));
        müşteriler.add(new Müşteri("Berna Sayın","bernsayin@gmail.com","11111111111111"));
        müşteriler.add(new Müşteri("Hüseyin Çalışkan","hcaliskan@outlook.com","222222222222"));

        BenimAdapter ba=new BenimAdapter(müşteriler,getLayoutInflater());

        LinearLayoutManager llm=new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);

        rv.setAdapter(ba);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, EklemeActivity.class);
                startActivity(intent);
            }
        });
    }
}