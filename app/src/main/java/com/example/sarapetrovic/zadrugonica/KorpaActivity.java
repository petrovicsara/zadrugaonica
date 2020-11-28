package com.example.sarapetrovic.zadrugonica;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class KorpaActivity extends AppCompatActivity {

    public static final String SHARED_PREFERENCES = "sharedPreferences";
    public int cena = 0;

    ListView lvItems;
    ArrayList<String> displayNames;
    ArrayList<String> displayDescriptions;
    ArrayList<String> dispPrices;
    TextView tvCena;
    TextView tvPraznaKorpa;

    Button btnZavrsi;
    Button btnNazad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korpa);

        lvItems = findViewById(R.id.lvItems);
        btnZavrsi = findViewById(R.id.btnZavrsi);
        btnNazad = findViewById(R.id.btnNazad);
        tvCena = findViewById(R.id.tvCena);
        tvPraznaKorpa = findViewById(R.id.tvPraznaKorpa);

        displayNames = new ArrayList<>();
        displayDescriptions = new ArrayList<>();
        dispPrices = new ArrayList<>();

        displayData();
        if (!displayNames.isEmpty()){
            tvPraznaKorpa.setVisibility(View.INVISIBLE);
        }

        MyAdapter myAdapter = new MyAdapter(this, displayNames, displayDescriptions, dispPrices);
        lvItems.setAdapter(myAdapter);
        tvCena.setText(cena+" poena/RSD");

        btnZavrsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE).edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(KorpaActivity.this, OcenaZadovoljstvaActivity.class));
            }
        });

        btnNazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KorpaActivity.this, PriborOpremaActivity.class));
            }
        });

    }

    public void displayData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        if (sharedPreferences.contains("kalkulator")){
            displayNames.add("Kalkulator");
            displayDescriptions.add("Tehnicki kalkulator Citizen");
            dispPrices.add("1.394");
            cena+=1394;
        }
        if (sharedPreferences.contains("flomaster")){
            displayNames.add("Flomaster");
            displayDescriptions.add("0.3mm Edding");
            dispPrices.add("70");
            cena+=70;
        }
        if (sharedPreferences.contains("sveska")){
            displayNames.add("Sveska");
            displayDescriptions.add("A4 60 listova Top2000");
            dispPrices.add("163");
            cena+= 163;
        }
        if (sharedPreferences.contains("tempera")){
            displayNames.add("Tempere");
            displayDescriptions.add("WMZ 12l 1/12");
            dispPrices.add("302");
            cena+= 302;
        }
        if (sharedPreferences.contains("gel")){
            displayNames.add("Gel olovka");
            displayDescriptions.add("0.7mm A Plus");
            dispPrices.add("63");
            cena+=63;
        }
        if (sharedPreferences.contains("vezbanka")){
            displayNames.add("Vezbanka");
            displayDescriptions.add("12l Lux dikto");
            dispPrices.add("19");
            cena+=19;
        }
    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        ArrayList<String> name;
        ArrayList<String> desc;
        ArrayList<String> prices;

        MyAdapter(Context c, ArrayList name, ArrayList desc, ArrayList prices){
            super(c, R.layout.korpa_item, R.id.tvName, name);
            this.context = c;
            this.name = name;
            this.desc = desc;
            this.prices = prices;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View item = layoutInflater.inflate(R.layout.korpa_item, parent, false);
            TextView tvName = item.findViewById(R.id.tvName);
            TextView tvDesc = item.findViewById(R.id.tvDescription);
            TextView tvPrices = item.findViewById(R.id.tvCena);
            tvName.setText(name.get(position));
            tvDesc.setText(desc.get(position));
            tvPrices.setText(prices.get(position));

            return item;
        }
    }
}
