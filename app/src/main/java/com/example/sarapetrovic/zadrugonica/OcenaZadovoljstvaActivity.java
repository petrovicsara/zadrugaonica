package com.example.sarapetrovic.zadrugonica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OcenaZadovoljstvaActivity extends AppCompatActivity {

    Button btnZavrsiOcene;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocena_zadovoljstva);

        btnZavrsiOcene = findViewById(R.id.btnZavrsiOcene);

        btnZavrsiOcene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OcenaZadovoljstvaActivity.this, "Хвала на Вашем одговору!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(OcenaZadovoljstvaActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
