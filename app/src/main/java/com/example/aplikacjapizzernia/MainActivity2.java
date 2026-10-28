package com.example.aplikacjapizzernia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    TextView size, ciasto, ilosc, cena;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            Intent intent = getIntent();

            size = findViewById(R.id.size);
            size.setText("Rozmiar: " + intent.getStringExtra("Size"));

            ciasto = findViewById(R.id.ciasto);
            if (intent.getBooleanExtra("Ciasto", false)) ciasto.setText("Ciasto: Grube");
            else ciasto.setText("Ciasto: Cienkie");

            ilosc = findViewById(R.id.ilosc);
            ilosc.setText("Sztuki: "+ intent.getIntExtra("LSztuk", 1));

            cena = findViewById(R.id.cena);
            cena.setText("Razem: " + intent.getFloatExtra("Razem", 25)+"zł");

            btn = findViewById(R.id.btn);
            btn.setOnClickListener(v1 -> {
                Intent intent1 = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent1);
            });

            return insets;
        });
    }
}