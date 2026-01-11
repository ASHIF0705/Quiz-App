package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class LevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        String playerName = getIntent().getStringExtra("playerName");
        String category = getIntent().getStringExtra("category");

        Button btnEasy = findViewById(R.id.btnEasy);
        Button btnMedium = findViewById(R.id.btnMedium);
        Button btnChallenge = findViewById(R.id.btnChallenge);

        btnEasy.setOnClickListener(v -> startQuiz(playerName, category, "easy"));
        btnMedium.setOnClickListener(v -> startQuiz(playerName, category, "medium"));
        btnChallenge.setOnClickListener(v -> startQuiz(playerName, category, "challenge"));
    }

    private void startQuiz(String playerName, String category, String level) {
        Intent intent = new Intent(LevelActivity.this, QuizActivity.class);
        intent.putExtra("playerName", playerName);
        intent.putExtra("category", category);
        intent.putExtra("level", level);
        startActivity(intent);
        finish();
    }
}