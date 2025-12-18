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

public class GuncelleActivity extends AppCompatActivity {

    TextView txt_adsoyad_guncelle,txt_mail_guncelle,txt_telefon_guncelle;
    Button btn_guncelle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guncelle);

        txt_adsoyad_guncelle=findViewById(R.id.txt_adsoyad_guncelle);
        txt_mail_guncelle=findViewById(R.id.txt_mail_guncelle);
        txt_telefon_guncelle=findViewById(R.id.txt_telefon_guncelle);

        Müşteri gelenMüşteri= (Müşteri) getIntent().getSerializableExtra("seçilenmüşteri");
        txt_adsoyad_guncelle.setText(gelenMüşteri.getAdsoyad());
        txt_mail_guncelle.setText(gelenMüşteri.getMail());
        txt_telefon_guncelle.setText(gelenMüşteri.getTelefon());

        btn_guncelle=findViewById(R.id.button);

        btn_guncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(txt_adsoyad_guncelle.getText())){
                    Toast.makeText(GuncelleActivity.this, "Ad-soyad alanı boş geçilemez", Toast.LENGTH_SHORT).show();
                }else{
                    if(TextUtils.isEmpty(txt_mail_guncelle.getText())){
                        Toast.makeText(GuncelleActivity.this, "Mail alanı boş geçilemez", Toast.LENGTH_SHORT).show();
                    }else {
                        if(TextUtils.isEmpty(txt_telefon_guncelle.getText())){
                            Toast.makeText(GuncelleActivity.this, "Telefon alanı boş geçilemez", Toast.LENGTH_SHORT).show();
                        }else{
                            if(!Patterns.EMAIL_ADDRESS.matcher(txt_mail_guncelle.getText()).matches()){
                                Toast.makeText(GuncelleActivity.this, "Mail formatı uygun değil...", Toast.LENGTH_SHORT).show();
                            }else{
                                FirebaseDatabase veritabanı=FirebaseDatabase.getInstance();
                                DatabaseReference referans=veritabanı.getReference("müşteriler");
                                Müşteri güncelmüşteri=new Müşteri(txt_adsoyad_guncelle.getText().toString(),
                                        txt_mail_guncelle.getText().toString(),
                                        txt_telefon_guncelle.getText().toString());
                                güncelmüşteri.setAnahtar(gelenMüşteri.getAnahtar());
                                referans.child(güncelmüşteri.getAnahtar()).setValue(güncelmüşteri);
                                Toast.makeText(GuncelleActivity.this, "Kayıt Başarıyla Güncellendi...", Toast.LENGTH_SHORT).show();
                                Intent main_intent=new Intent(GuncelleActivity.this, MainActivity.class);
                                startActivity(main_intent);
                            }
                        }
                    }
                }
            }
        });

    }
}
