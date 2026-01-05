package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        EditText nameInput = findViewById(R.id.nameInput);
        Button nextBtn = findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            if (name.isEmpty()) {
                Toast.makeText(this, "Name daal bhai!", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(NameActivity.this, CategoryActivity.class);
                intent.putExtra("playerName", name);
                startActivity(intent);
                finish();
            }
        });
    }
}