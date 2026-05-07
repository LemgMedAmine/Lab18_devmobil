package com.example.viewmodellivedatademoenrichi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

// Auteur: Lemghili Mohammed Amine
// Activity principale: relie l'interface utilisateur au ViewModel et observe le LiveData.
public class MainActivity extends AppCompatActivity {

    private CounterViewModel viewModel;
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

        // Lemghili Mohammed Amine: recuperation ou creation du ViewModel.
        // ViewModelProvider lie le ViewModel au Lifecycle de cette Activity.
        viewModel = new ViewModelProvider(this).get(CounterViewModel.class);

        // Lemghili Mohammed Amine: observation du LiveData, en respectant le cycle de vie.
        // L'observer n'est appele que si l'Activity est en STARTED ou RESUMED.
        viewModel.getCount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer newCount) {
                tvCount.setText(String.valueOf(newCount));
            }
        });

        // Lemghili Mohammed Amine: les boutons appellent uniquement le ViewModel.
        btnIncrement.setOnClickListener(v -> viewModel.increment());
        btnDecrement.setOnClickListener(v -> viewModel.decrement());
        btnReset.setOnClickListener(v -> viewModel.reset());
    }
}
