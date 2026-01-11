package com.example.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private String playerName;
    private int score;
    private int totalQuestions;
    private String category;
    private String level;
    private List<Question> questions;
    private ArrayList<Integer> playerAnswers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tvPlayerName = findViewById(R.id.tvPlayerName);
        TextView tvFinalScore = findViewById(R.id.tvFinalScore);
        TextView tvPercentage = findViewById(R.id.tvPercentage);
        TextView tvMessage = findViewById(R.id.tvMessage);
        Button btnPlayAgain = findViewById(R.id.btnPlayAgain);
        ImageButton btnDownloadReport = findViewById(R.id.btnDownloadReport);

        playerName = getIntent().getStringExtra("playerName");
        score = getIntent().getIntExtra("score", 0);
        totalQuestions = getIntent().getIntExtra("totalQuestions", 15);
        category = getIntent().getStringExtra("category");
        level = getIntent().getStringExtra("level");

        questions = getIntent().getParcelableArrayListExtra("questions");
        playerAnswers = getIntent().getIntegerArrayListExtra("playerAnswers");

        if (playerName == null) playerName = "Player";

        tvPlayerName.setText(playerName);
        tvFinalScore.setText(score + "/" + totalQuestions);

        int percentage = (score * 100) / totalQuestions;
        tvPercentage.setText(percentage + "%");

        if (percentage >= 80) {
            tvMessage.setText("Excellent!");
        } else if (percentage >= 60) {
            tvMessage.setText("Good Job!");
        } else if (percentage >= 40) {
            tvMessage.setText("Not Bad! Keep Trying...");
        } else {
            tvMessage.setText("Better Luck Next Time!");
        }

        btnPlayAgain.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, NameActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        btnDownloadReport.setOnClickListener(v -> {
            generatePdfReport();
        });
    }

    private void generatePdfReport() {
        if (questions == null || playerAnswers == null || questions.size() != playerAnswers.size()) {
            Toast.makeText(this, "No data available for report", Toast.LENGTH_SHORT).show();
            return;
        }

        PdfDocument pdfDocument = new PdfDocument();
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(595, 842, 1).create();
        PdfDocument.Page page = pdfDocument.startPage(pageInfo);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(12);

        int y = 40;

        // Header
        paint.setTextSize(18);
        paint.setFakeBoldText(true);
        page.getCanvas().drawText("Quiz Report", 40, y, paint);
        y += 30;

        paint.setTextSize(12);
        paint.setFakeBoldText(false);
        page.getCanvas().drawText("Player: " + playerName, 40, y, paint);
        y += 20;
        page.getCanvas().drawText("Category: " + category, 40, y, paint);
        y += 20;
        page.getCanvas().drawText("Level: " + level, 40, y, paint);
        y += 20;
        page.getCanvas().drawText("Score: " + score + " / " + totalQuestions, 40, y, paint);
        y += 40;

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            int playerChoice = playerAnswers.get(i);
            int correct = q.correctAnswer;

            page.getCanvas().drawText("Q" + (i + 1) + ": " + q.questionText, 40, y, paint);
            y += 20;

            for (int j = 0; j < q.options.length; j++) {
                String option = (j + 1) + ". " + q.options[j];
                String mark = "";


                if (j == correct) {
                    mark = " ✅ (Correct)";
                }

                if (j == playerChoice) {
                    if (j == correct) {
                        mark += " ✅ (Your choice)";
                    } else {
                        mark += " ❌ (Your choice)";
                    }
                }

                page.getCanvas().drawText(option + mark, 50, y, paint);
                y += 18;
            }

            y += 25;

            if (y > 780) {
                pdfDocument.finishPage(page);
                page = pdfDocument.startPage(pageInfo);
                y = 40;
            }
        }

        pdfDocument.finishPage(page);

        // Save PDF
        File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(downloadsDir, "QuizReport_" + playerName.replace(" ", "_") + ".pdf");

        try {
            pdfDocument.writeTo(new FileOutputStream(file));
            pdfDocument.close();
            Toast.makeText(this, "Report downloaded to Downloads!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}