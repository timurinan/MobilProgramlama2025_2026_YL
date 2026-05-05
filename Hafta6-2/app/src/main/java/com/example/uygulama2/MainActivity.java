package com.example.uygulama2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

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

    BenimAdapter ba;

    SearchView sv;
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
        sv=findViewById(R.id.searchview);
        RecyclerView rv=findViewById(R.id.recycler);
        FloatingActionButton fab=findViewById(R.id.floatingActionButton);

        müşteriler.add(new Müşteri("Timur İNan","timurinan@hotmail.com","454545454545400"));
        müşteriler.add(new Müşteri("Ahmet Toprak","atoprak@hotmail.com","454785441574754"));
        müşteriler.add(new Müşteri("Berna Sayın","bernsayin@gmail.com","11111111111111"));
        müşteriler.add(new Müşteri("Hüseyin Çalışkan","hcaliskan@outlook.com","222222222222"));


        ba=new BenimAdapter(müşteriler,getLayoutInflater());

        LinearLayoutManager llm=new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);

        rv.setAdapter(ba);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, EklemeActivity.class);
                onStop();
                startActivity(intent);
            }
        });

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String s) {
                if(s.isEmpty())
                    ba.setFiltreMüşteriler(müşteriler);
                return true;
            }

            @Override
            public boolean onQueryTextSubmit(String s) {

                ArrayList<Müşteri> filtreMüşteriler=new ArrayList<Müşteri>();
                for (Müşteri müşteri :müşteriler) {
                    if(müşteri.getAdsoyad().toLowerCase().contains(s.toLowerCase())){
                        filtreMüşteriler.add(müşteri);
                    }
                }
                if(filtreMüşteriler.isEmpty()){

                    Toast.makeText(MainActivity.this, "Uygun Veri Bulunamadı...", Toast.LENGTH_SHORT).show();
                    ba.setFiltreMüşteriler(filtreMüşteriler);
                }else {
                    ba.setFiltreMüşteriler(filtreMüşteriler);
                }
                return false;
            }
        });

        if(getIntent().getIntExtra("id",0)==1){
            Müşteri yenimüşteri= (Müşteri) getIntent().getSerializableExtra("yenimüşteri");
            müşteriler.add(yenimüşteri);
            ba.setFiltreMüşteriler(müşteriler);
        }
    }



}