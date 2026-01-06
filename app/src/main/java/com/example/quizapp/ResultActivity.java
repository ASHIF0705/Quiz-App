package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tvPlayerName = findViewById(R.id.tvPlayerName);
        TextView tvFinalScore = findViewById(R.id.tvFinalScore);
        TextView tvPercentage = findViewById(R.id.tvPercentage);
        TextView tvMessage = findViewById(R.id.tvMessage);
        Button btnPlayAgain = findViewById(R.id.btnPlayAgain);

        // Data receive from QuizActivity
        String playerName = getIntent().getStringExtra("playerName");
        int score = getIntent().getIntExtra("score", 0);
        int totalQuestions = getIntent().getIntExtra("totalQuestions", 15);

        tvPlayerName.setText(playerName);
        tvFinalScore.setText(score + "/" + totalQuestions);

        int percentage = (score * 100) / totalQuestions;
        tvPercentage.setText(percentage + "%");

        // Dynamic message
        if (percentage >= 80) {
            tvMessage.setText("Excellent! ");
        } else if (percentage >= 60) {
            tvMessage.setText("Good Job! ");
        } else if (percentage >= 40) {
            tvMessage.setText("Not Bad! Keep Trying ");
        } else {
            tvMessage.setText("Better Luck Next Time ");
        }

        btnPlayAgain.setOnClickListener(v -> {

            Intent intent = new Intent(ResultActivity.this, WelcomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}