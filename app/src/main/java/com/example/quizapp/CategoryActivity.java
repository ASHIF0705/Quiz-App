package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        String playerName = getIntent().getStringExtra("playerName");

        Button btnSports = findViewById(R.id.btnSports);
        Button btnGK = findViewById(R.id.btnGK);
        Button btnProgramming = findViewById(R.id.btnProgramming);

        btnSports.setOnClickListener(v -> startQuiz("sports", playerName));
        btnGK.setOnClickListener(v -> startQuiz("gk", playerName));
        btnProgramming.setOnClickListener(v -> startQuiz("programming", playerName));
    }

    private void startQuiz(String category, String playerName) {
        Intent intent = new Intent(CategoryActivity.this, LevelActivity.class);
        intent.putExtra("category", category);
        intent.putExtra("playerName", playerName);
        startActivity(intent);
    }
}