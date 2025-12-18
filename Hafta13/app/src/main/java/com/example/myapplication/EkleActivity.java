package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EkleActivity extends AppCompatActivity {

    TextView txt_adsoyad_ekle,txt_mail_ekle,txt_telefon_ekle;

    Button btn_ekle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekle);

        txt_adsoyad_ekle=findViewById(R.id.txt_adsoyad_ekle);
        txt_mail_ekle=findViewById(R.id.txt_mail_ekle);
        txt_telefon_ekle=findViewById(R.id.txt_telefon_ekle);

        btn_ekle=findViewById(R.id.button);

        btn_ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(txt_adsoyad_ekle.getText())){
                    Toast.makeText(EkleActivity.this, "Ad-soyad alanı boş geçilemez", Toast.LENGTH_SHORT).show();
                }else{
                    if(TextUtils.isEmpty(txt_mail_ekle.getText())){
                        Toast.makeText(EkleActivity.this, "Mail alanı boş geçilemez", Toast.LENGTH_SHORT).show();
                    }else {
                        if(TextUtils.isEmpty(txt_telefon_ekle.getText())){
                            Toast.makeText(EkleActivity.this, "Telefon alanı boş geçilemez", Toast.LENGTH_SHORT).show();
                        }else{
                            if(!Patterns.EMAIL_ADDRESS.matcher(txt_mail_ekle.getText()).matches()){
                                Toast.makeText(EkleActivity.this, "Mail formatı uygun değil...", Toast.LENGTH_SHORT).show();
                            }else{
                                FirebaseDatabase veritabanı=FirebaseDatabase.getInstance();
                                DatabaseReference referans=veritabanı.getReference("müşteriler");
                                String anahtar=referans.push().getKey();
                                DatabaseReference müşterireferansı=veritabanı.getReference("müşteriler/"+anahtar);
                                Müşteri yenimüşteri=new Müşteri(txt_adsoyad_ekle.getText().toString(),
                                        txt_mail_ekle.getText().toString(),
                                        txt_telefon_ekle.getText().toString());
                                yenimüşteri.setAnahtar(anahtar);
                                müşterireferansı.setValue(yenimüşteri);
                                Toast.makeText(EkleActivity.this, "Kayıt başarıyla eklendi...", Toast.LENGTH_SHORT).show();
                                Intent main_intent=new Intent(EkleActivity.this, MainActivity.class);
                                startActivity(main_intent);
                            }
                        }
                    }
                }
            }
        });
    }
}
