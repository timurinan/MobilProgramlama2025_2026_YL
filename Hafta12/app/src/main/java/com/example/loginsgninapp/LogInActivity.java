package com.example.loginsgninapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {

    TextView txt_mail_login,txt_sifre_login,txt_signin, txt_sifremiunuttum;
    Button btn_girişyap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_mail_login=findViewById(R.id.txt_mail_login);
        txt_sifre_login=findViewById(R.id.txt_sifre_login);
        txt_signin=findViewById(R.id.textView);
        txt_sifremiunuttum=findViewById(R.id.textView2);
        btn_girişyap=findViewById(R.id.btn_girisyap_login);

        txt_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signinIntent=new Intent(LogInActivity.this, SignInActivity.class);
                startActivity(signinIntent);
            }
        });

        txt_sifremiunuttum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent suIntent=new Intent(LogInActivity.this, SifremiUnuttumActivity.class);
                startActivity(suIntent);
            }
        });

        btn_girişyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(txt_mail_login.getText().toString())){
                    Toast.makeText(LogInActivity.this, "Mail alanı boş bırakılamaz", Toast.LENGTH_SHORT).show();
                }else{
                    if(TextUtils.isEmpty(txt_sifre_login.getText().toString())){
                        Toast.makeText(LogInActivity.this, "Şifre alanı boş bırakılamaz", Toast.LENGTH_SHORT).show();
                    }else{
                        if(!Patterns.EMAIL_ADDRESS.matcher(txt_mail_login.getText()).matches()){
                            Toast.makeText(LogInActivity.this, "E-mail geçerli değildir", Toast.LENGTH_SHORT).show();
                        }else{
                            FirebaseAuth fba=FirebaseAuth.getInstance();
                            fba.signInWithEmailAndPassword(txt_mail_login.getText().toString(),txt_sifre_login.getText().toString())
                                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        if(fba.getCurrentUser().isEmailVerified())
                                            Toast.makeText(LogInActivity.this, "Başarıyla Giriş Yapıldı", Toast.LENGTH_SHORT).show();
                                        else
                                            Toast.makeText(LogInActivity.this, "E-Mail onayı tamamlanmamıştır...", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(LogInActivity.this, "Hatalı Giriş", Toast.LENGTH_SHORT).show();
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