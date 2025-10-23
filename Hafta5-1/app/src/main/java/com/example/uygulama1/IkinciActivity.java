package com.example.uygulama1;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IkinciActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("mesaj","başladı");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ikinci);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ikinci), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btn_geri=findViewById(R.id.button2);
        btn_geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_iki=new Intent(IkinciActivity.this, MainActivity.class);
                startActivity(intent_iki);
            }
        });
    }
}
