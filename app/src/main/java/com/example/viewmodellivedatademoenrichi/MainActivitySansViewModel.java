package com.example.viewmodellivedatademoenrichi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

// Auteur: Lemghili Mohammed Amine
// Version classique gardee pour comparer avec la solution ViewModel + LiveData.
public class MainActivitySansViewModel extends AppCompatActivity {

    private int count = 0; // Variable d'instance classique: perdue a la rotation sans sauvegarde manuelle.
    private TextView tvCount;
    private Button btnIncrement;
    private Button btnDecrement;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = findViewById(R.id.tvCount);
        btnIncrement = findViewById(R.id.btnIncrement);
        btnDecrement = findViewById(R.id.btnDecrement);
        btnReset = findViewById(R.id.btnReset);

        // Lemghili Mohammed Amine: restauration manuelle avec l'ancienne methode.
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count_key", 0);
        }
        updateUI();

        btnIncrement.setOnClickListener(v -> {
            count++;
            updateUI();
        });
        btnDecrement.setOnClickListener(v -> {
            count--;
            updateUI();
        });
        btnReset.setOnClickListener(v -> {
            count = 0;
            updateUI();
        });
    }

    private void updateUI() {
        tvCount.setText(String.valueOf(count));
    }

    // Lemghili Mohammed Amine: methode obligatoire pour survivre a la rotation dans cette version.
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count_key", count); // Seulement un int, pas d'objet complexe.
        // Limitation : ne remplace pas ViewModel, LiveData, Room, threads, etc.
    }
}
