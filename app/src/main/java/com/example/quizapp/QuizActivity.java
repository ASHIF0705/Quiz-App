package com.example.quizapp;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView tvQuestion, tvTimer, tvScore;
    private RadioGroup radioGroup;
    private RadioButton option1, option2, option3, option4;
    private Button btnNext;

    private List<Question> questions;
    private int currentQuestion = 0;
    private int score = 0;
    private String playerName;
    private CountDownTimer timer;
    private boolean answerSelected = false;

    private static final int TIME_PER_QUESTION = 15000; // 15 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        String category = getIntent().getStringExtra("category");
        playerName = getIntent().getStringExtra("playerName");

        tvQuestion = findViewById(R.id.tvQuestion);
        tvTimer = findViewById(R.id.tvTimer);
        tvScore = findViewById(R.id.tvScore);
        radioGroup = findViewById(R.id.radioGroup);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        btnNext = findViewById(R.id.btnNext);

        questions = QuestionsBank.getQuestions(category);

        loadQuestion();

        // Jab user koi option select karega → Next button enable
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != -1) {
                answerSelected = true;
                btnNext.setEnabled(true);
            }
        });

        // Next/Submit button ka common click listener
        btnNext.setOnClickListener(v -> {
            if (!answerSelected) {
                Toast.makeText(this, "Pehle koi option select kar!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Check answer
            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton selected = findViewById(selectedId);
            int selectedIndex = radioGroup.indexOfChild(selected);

            if (selectedIndex == questions.get(currentQuestion).correctAnswer) {
                selected.setBackgroundColor(Color.GREEN);
                score++;
                tvScore.setText("Score: " + score);
            } else {
                selected.setBackgroundColor(Color.RED);
                getCorrectOption().setBackgroundColor(Color.GREEN);
            }

            disableOptions();

            if (timer != null) timer.cancel();

            // Agla question ya result
            if (currentQuestion == questions.size() - 1) {
                // Last question tha → result dikhao
                showResult();
            } else {
                currentQuestion++;
                loadQuestion();
            }
        });
    }

    private void loadQuestion() {
        if (currentQuestion >= questions.size()) {
            showResult();
            return;
        }

        Question q = questions.get(currentQuestion);
        tvQuestion.setText((currentQuestion + 1) + ". " + q.questionText);
        option1.setText(q.options[0]);
        option2.setText(q.options[1]);
        option3.setText(q.options[2]);
        option4.setText(q.options[3]);

        resetOptions();

        answerSelected = false;
        btnNext.setEnabled(false);

        // Yahan main change: sirf last question pe "Submit", baaki sab pe "Next"
        if (currentQuestion == questions.size() - 1) {
            btnNext.setText("Submit");
        } else {
            btnNext.setText("Next");
        }

        startTimer();
    }

    private void startTimer() {
        timer = new CountDownTimer(TIME_PER_QUESTION, 1000) {
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("Time: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                tvTimer.setText("Time Up!");
                disableOptions();
                getCorrectOption().setBackgroundColor(Color.GREEN);

                // Time up pe automatic next ya result
                if (currentQuestion == questions.size() - 1) {
                    showResult();
                } else {
                    currentQuestion++;
                    loadQuestion();
                }
            }
        }.start();
    }

    private void showResult() {
        if (timer != null) timer.cancel();
        Toast.makeText(this, playerName + ", Quiz Complete!\nFinal Score: " + score + "/" + questions.size(), Toast.LENGTH_LONG).show();
        tvQuestion.setText("🎉Quiz Over! 🎉\n" + playerName + "\nFinal Score: " + score + "/" + questions.size() + "\nCongratulations !");
        radioGroup.setVisibility(android.view.View.GONE);
        btnNext.setVisibility(android.view.View.GONE);
        tvTimer.setVisibility(android.view.View.GONE);
    }

    private void resetOptions() {
        option1.setBackgroundColor(Color.TRANSPARENT);
        option2.setBackgroundColor(Color.TRANSPARENT);
        option3.setBackgroundColor(Color.TRANSPARENT);
        option4.setBackgroundColor(Color.TRANSPARENT);

        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);

        radioGroup.clearCheck();
    }

    private void disableOptions() {
        option1.setEnabled(false);
        option2.setEnabled(false);
        option3.setEnabled(false);
        option4.setEnabled(false);
    }

    private RadioButton getCorrectOption() {
        int correct = questions.get(currentQuestion).correctAnswer;
        switch (correct) {
            case 0: return option1;
            case 1: return option2;
            case 2: return option3;
            case 3: return option4;
            default: return option1;
        }
    }

    @Override
    protected void onDestroy() {
        if (timer != null) timer.cancel();
        super.onDestroy();
    }
}