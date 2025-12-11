package com.example.loginsgninapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    TextView txt_mail_signin, txt_sifre_signin1, txt_sifre_signin2;
    Button btn_signin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        txt_mail_signin=findViewById(R.id.txt_mail_signin);
        txt_sifre_signin1=findViewById(R.id.txt_sifre_signin1);
        txt_sifre_signin2=findViewById(R.id.txt_sifre_signin2);
        btn_signin=findViewById(R.id.btn_kayitol_signin);

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(txt_mail_signin.getText().toString())){
                    Toast.makeText(SignInActivity.this, "Mail alanı boş geçilemez", Toast.LENGTH_SHORT).show();
                }else{
                    if(TextUtils.isEmpty(txt_sifre_signin1.getText().toString())||TextUtils.isEmpty(txt_sifre_signin2.getText().toString())){
                        Toast.makeText(SignInActivity.this, "Şifre alanları boş geçilemez", Toast.LENGTH_SHORT).show();
                    }else{
                        if(!txt_sifre_signin1.getText().toString().equals(txt_sifre_signin2.getText().toString())){
                            Toast.makeText(SignInActivity.this, "Şifreler eşleşmemektedir...", Toast.LENGTH_SHORT).show();
                        }else{
                            FirebaseAuth fba=FirebaseAuth.getInstance();
                            fba.createUserWithEmailAndPassword(txt_mail_signin.getText().toString(),txt_sifre_signin1.getText().toString())
                                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if(task.isSuccessful()){
                                                fba.getCurrentUser().sendEmailVerification();
                                                Toast.makeText(SignInActivity.this, "Doğrulama maili adresinize gönderildi", Toast.LENGTH_SHORT).show();
                                                Intent loginIntent=new Intent(SignInActivity.this, LogInActivity.class);
                                                startActivity(loginIntent);
                                            }else{
                                                Toast.makeText(SignInActivity.this, "Kullanıcı oluşturulurken hata meydana geldi", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });

                        }
                    }
                }
            }
        });
    }
}
