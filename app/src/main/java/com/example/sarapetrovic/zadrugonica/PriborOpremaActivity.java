package com.example.sarapetrovic.zadrugonica;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PriborOpremaActivity extends AppCompatActivity {
    Button btnNazad;
    Button btnPotvrdi;

    Button btnKal;
    Button btnFlomaster;
    Button btnSveske;
    Button btnTempere;
    Button btnGel;
    Button btnVezbanka;

    int kal = 0;
    int flo = 0;
    int sve = 0;
    int temp = 0;
    int gel = 0;
    int vez = 0;

    public static final String SHARED_PREFERENCES = "sharedPreferences";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pribor_oprema);

        btnNazad = findViewById(R.id.btnNazad);
        btnPotvrdi = findViewById(R.id.btnPotvrdi);

        btnKal = findViewById(R.id.btnKal);
        btnFlomaster = findViewById(R.id.btnFlomas);
        btnSveske = findViewById(R.id.btnSveske);
        btnTempere = findViewById(R.id.btnTempere);
        btnGel = findViewById(R.id.btnGelRoler);
        btnVezbanka = findViewById(R.id.btnVezbanka);

        btnNazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PriborOpremaActivity.this, OpcijeActivity.class));
                finish();
            }
        });

        btnPotvrdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PriborOpremaActivity.this, KorpaActivity.class));
            }
        });

        btnKal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kal++;
                saveData("kalkulator", kal);
            }
        });

        btnFlomaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flo++;
                saveData("flomaster", flo);
            }
        });

        btnSveske.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sve++;
                saveData("sveska", sve);
            }
        });

        btnTempere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp++;
                saveData("tempera", temp);
            }
        });

        btnGel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gel++;
                saveData("gel", gel);
            }
        });

        btnVezbanka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vez++;
                saveData("vezbanka", vez);
            }
        });
    }

    public void saveData(String name, int data){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(name, data);
        editor.apply();

        Toast toast = Toast.makeText(PriborOpremaActivity.this, "Додато у корпу!", Toast.LENGTH_SHORT);
        toast.show();
    }
}

























