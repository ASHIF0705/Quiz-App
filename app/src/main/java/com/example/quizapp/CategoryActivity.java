package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener {

    private String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        playerName = getIntent().getStringExtra("playerName");

        initButtons();
    }

    private void initButtons() {
        int[] buttonIds = {
                R.id.btnSports,
                R.id.btnGK,
                R.id.btnProgramming
        };

        for (int id : buttonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        String category = "";

        int id = view.getId();
        if (id == R.id.btnSports) {
            category = "sports";
        } else if (id == R.id.btnGK) {
            category = "gk";
        } else if (id == R.id.btnProgramming) {
            category = "programming";
        }

        startQuiz(category);
    }

    private void startQuiz(String category) {
        Intent intent = new Intent(this, LevelActivity.class);
        intent.putExtra("category", category);
        intent.putExtra("playerName", playerName);
        startActivity(intent);
    }
}
