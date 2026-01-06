package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView welcomeText = findViewById(R.id.welcomeText);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        welcomeText.startAnimation(anim);

        welcomeText.postDelayed(() -> {
            startActivity(new Intent(WelcomeActivity.this, NameActivity.class));
            finish();
        }, 3000);
    }
}