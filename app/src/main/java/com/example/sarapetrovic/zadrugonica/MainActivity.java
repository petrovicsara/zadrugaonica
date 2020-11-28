package com.example.sarapetrovic.zadrugonica;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button pokreni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokreni = findViewById(R.id.btnPokreni);

        SharedPreferences.Editor editor = getSharedPreferences("sharedPreferences", MODE_PRIVATE).edit();
        editor.clear();
        editor.apply();

        pokreni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OpcijeActivity.class));
            }
        });
    }
}
