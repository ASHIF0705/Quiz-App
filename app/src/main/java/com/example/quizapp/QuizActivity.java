package com.example.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView tvQuestion, tvTimer, tvScore;
    private RadioGroup radioGroup;
    private RadioButton option1, option2, option3, option4;
    private Button btnNext;

    private List<Question> questions;
    private List<Integer> playerAnswers = new ArrayList<>();
    private int currentQuestion = 0;
    private int score = 0;
    private String playerName;
    private String category;
    private String level;
    private CountDownTimer timer;
    private boolean answerSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        playerName = getIntent().getStringExtra("playerName");
        category = getIntent().getStringExtra("category");
        level = getIntent().getStringExtra("level");

        tvQuestion = findViewById(R.id.tvQuestion);
        tvTimer = findViewById(R.id.tvTimer);
        tvScore = findViewById(R.id.tvScore);
        radioGroup = findViewById(R.id.radioGroup);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        btnNext = findViewById(R.id.btnNext);

        questions = QuestionsBank.getQuestions(category, level);

        int timePerQuestion = "challenge".equals(level) ? 30000 : 15000;

        loadQuestion();

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != -1) {
                answerSelected = true;
                btnNext.setEnabled(true);
            }
        });

        btnNext.setOnClickListener(v -> {
            if (!answerSelected) {
                Toast.makeText(this, "Choose any option!", Toast.LENGTH_SHORT).show();
                return;
            }

            int selectedId = radioGroup.getCheckedRadioButtonId();
            int selectedIndex = -1;
            if (selectedId != -1) {
                RadioButton selected = findViewById(selectedId);
                selectedIndex = radioGroup.indexOfChild(selected);
            }
            playerAnswers.add(selectedIndex);

            if (selectedIndex == questions.get(currentQuestion).correctAnswer) {
                if (selectedId != -1) {
                    RadioButton selected = findViewById(selectedId);
                    selected.setBackgroundColor(Color.GREEN);
                }
                score++;
                tvScore.setText("Score: " + score);
            } else {
                if (selectedId != -1) {
                    RadioButton selected = findViewById(selectedId);
                    selected.setBackgroundColor(Color.RED);
                }
                getCorrectOption().setBackgroundColor(Color.GREEN);
            }

            disableOptions();

            if (timer != null) timer.cancel();

            if (currentQuestion == questions.size() - 1) {
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

        if (currentQuestion == questions.size() - 1) {
            btnNext.setText("Submit");
        } else {
            btnNext.setText("Next");
        }

        startTimer();
    }

    private void startTimer() {
        int timePerQuestion = "challenge".equals(level) ? 30000 : 15000;

        timer = new CountDownTimer(timePerQuestion, 1000) {
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("⏱️: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                tvTimer.setText("Time Up!");
                disableOptions();
                getCorrectOption().setBackgroundColor(Color.GREEN);

                playerAnswers.add(-1);

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
        if (timer != null) {
            timer.cancel();
        }

        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        intent.putExtra("playerName", playerName);
        intent.putExtra("score", score);
        intent.putExtra("totalQuestions", questions.size());
        intent.putExtra("category", category);
        intent.putExtra("level", level);

        intent.putParcelableArrayListExtra("questions", new ArrayList<>(questions));
        intent.putIntegerArrayListExtra("playerAnswers", new ArrayList<>(playerAnswers));

        startActivity(intent);
        finish();
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