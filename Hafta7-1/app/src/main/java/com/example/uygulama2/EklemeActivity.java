package com.example.uygulama2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.PersistableBundle;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.uygulama2.databinding.ActivityEklemeBinding;

import java.util.ArrayList;

public class EklemeActivity extends AppCompatActivity {

    TextView txt_adsoyad_ekleme,txt_mail_ekleme,txt_telefon_ekleme;
    Button btnkaydet;

    ArrayList<Müşteri> müşteriler=new ArrayList<Müşteri>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekleme);

        txt_adsoyad_ekleme=findViewById(R.id.txt_adsoyad_ekleme);
        txt_mail_ekleme=findViewById(R.id.txt_mail_ekleme);
        txt_telefon_ekleme=findViewById(R.id.txt_telefon_ekleme);
        btnkaydet=findViewById(R.id.btn_kaydet);

        müşteriler= (ArrayList<Müşteri>) getIntent().getSerializableExtra("müşteriler");

        btnkaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(txt_adsoyad_ekleme.getText())){
                    Toast.makeText(EklemeActivity.this, "Ad Soyad Boş Bırakılamaz", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(txt_mail_ekleme.getText())){
                    Toast.makeText(EklemeActivity.this, "Mail Boş Bırakılamaz", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(txt_telefon_ekleme.getText())){
                    Toast.makeText(EklemeActivity.this, "Telefon Boş Bırakılamaz", Toast.LENGTH_SHORT).show();
                }else{
                    if(!Patterns.EMAIL_ADDRESS.matcher(txt_mail_ekleme.getText()).matches()){
                        Toast.makeText(EklemeActivity.this, "Email adresi uygun formatta değil...", Toast.LENGTH_SHORT).show();
                    }else if(!PhoneNumberUtils.isGlobalPhoneNumber(txt_telefon_ekleme.getText().toString())){
                        Toast.makeText(EklemeActivity.this, "Telefon numarası uygun formatta değil", Toast.LENGTH_SHORT).show();
                    }else{
                        Müşteri yeniMüşteri=new Müşteri(txt_adsoyad_ekleme.getText().toString(),txt_mail_ekleme.getText().toString(),txt_telefon_ekleme.getText().toString());
                        Toast.makeText(EklemeActivity.this, "Müşteri başarıyla oluşturuldu...", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(EklemeActivity.this, MainActivity.class);
                        müşteriler.add(yeniMüşteri);
                        intent.putExtra("değer",1);
                        intent.putExtra("müşteriler",müşteriler);
                        startActivity(intent);
                    }
                }

            }
        });
    }


}