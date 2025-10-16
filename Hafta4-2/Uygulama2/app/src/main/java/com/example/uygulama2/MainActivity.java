package com.example.uygulama2;

import android.os.Bundle;
import android.os.PatternMatcher;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtMail, txtPassword;
    Button btn_giris;
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
        txtMail=findViewById(R.id.txtEmail);
        txtPassword=findViewById(R.id.txtPassword);
        btn_giris=findViewById(R.id.button);
//        btn_giris.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        btn_giris.setOnClickListener(view -> girisYap());
    }

    private void girisYap() {
        if(TextUtils.isEmpty(txtMail.getText().toString())|| !Patterns.EMAIL_ADDRESS.matcher(txtMail.getText()).matches()){
            Toast.makeText(this, "Mail Alanı Boş bırakılamaz ya da Mail Patterni Bozuk", Toast.LENGTH_LONG).show();
        }else{
            if(TextUtils.isEmpty(txtPassword.getText())){
                Toast.makeText(this, "Şifre Boş Bırakılamaz", Toast.LENGTH_SHORT).show();
            }else{
                CharSequence sifre="1234";
                if(txtPassword.getText().toString().equals(sifre)){
                    Toast.makeText(this, "Başarıyla Gİriş Yaptınız...", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Şifre Yanlıştır...", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}