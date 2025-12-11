package com.example.loginsgninapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class SifremiUnuttumActivity extends AppCompatActivity {


    TextView txt_mail;
    Button btn_resetle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sifremiunuttum);

        txt_mail=findViewById(R.id.txt_mail_su);
        btn_resetle=findViewById(R.id.btn_resetle_su);

        btn_resetle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(txt_mail.getText())){
                    Toast.makeText(SifremiUnuttumActivity.this, "Mail alanı boş geçilemez", Toast.LENGTH_SHORT).show();
                }else{
                    if(!Patterns.EMAIL_ADDRESS.matcher(txt_mail.getText()).matches()){
                        Toast.makeText(SifremiUnuttumActivity.this, "Mail formatı hatalıdır...", Toast.LENGTH_SHORT).show();
                    }else{
                        FirebaseAuth fba=FirebaseAuth.getInstance();
                        fba.sendPasswordResetEmail(txt_mail.getText().toString())
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                       if(task.isSuccessful()){
                                           Toast.makeText(SifremiUnuttumActivity.this, "Şifre resetleme linki gönderildi", Toast.LENGTH_SHORT).show();
                                           Intent loginIntent=new Intent(SifremiUnuttumActivity.this, LogInActivity.class);
                                           startActivity(loginIntent);
                                       }
                                    }
                                });
                    }
                }
            }
        });
    }
}