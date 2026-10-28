package com.example.aplikacjapizzernia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup grupa;
    EditText lszt;
    CheckBox ciasto;
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

                String size;
                if(grupa.getCheckedRadioButtonId() == R.id.duza) size = "Duża";
                else if (grupa.getCheckedRadioButtonId() == R.id.mid) size = "Średnia";
                else size = "Mała";

                ciasto = findViewById(R.id.ciasto);

                float razem = 0;
                if (size.equals("Duża")) razem+=45;
                if (size.equals("Średnia")) razem+=35;
                if (size.equals("Mała")) razem+=25;
                if (ciasto.isChecked()) razem+=5;
                razem = razem * Integer.parseInt(String.valueOf(lszt.getText()));


                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("LSztuk", Integer.parseInt(String.valueOf(lszt.getText())));
                intent.putExtra("Size", size);
                intent.putExtra("Ciasto", ciasto.isChecked());
                intent.putExtra("Razem", razem);

                startActivity(intent);

            });
            return insets;
        });
    }
}