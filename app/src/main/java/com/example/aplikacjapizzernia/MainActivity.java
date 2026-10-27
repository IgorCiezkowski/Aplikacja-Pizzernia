package com.example.aplikacjapizzernia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup grupa;
    EditText lszt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            grupa = findViewById(R.id.grupa);
            btn = findViewById(R.id.btn);
            lszt = findViewById(R.id.lszt);

            btn.setOnClickListener(v1 -> {
                int szt = Integer.parseInt(String.valueOf(lszt.getText()));
                String size;
                if(grupa.getCheckedRadioButtonId() == R.id.duza) size = "Duża";
                else if (grupa.getCheckedRadioButtonId() == R.id.mid) size = "Średnia";
                else size = "Mała";


                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("LSztuk", szt);
                intent.putExtra("Size", size);

                startActivity(intent);

            });
            return insets;
        });
    }
}