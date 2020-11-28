package com.example.sarapetrovic.zadrugonica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class OpcijeActivity extends AppCompatActivity {
    ImageButton ibPribor;
    Button btnNazad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcije);

        ibPribor = findViewById(R.id.ibPribor);
        btnNazad = findViewById(R.id.btnNazad);

        ibPribor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OpcijeActivity.this, PriborOpremaActivity.class));
            }
        });

        btnNazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OpcijeActivity.this, MainActivity.class));
            }
        });
    }
}
