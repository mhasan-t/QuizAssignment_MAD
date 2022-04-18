package com.example.quizrecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

public class CreateQuestionView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_question);


        Button backBtn = findViewById(R.id.backBtn);
        Button createBtn = findViewById(R.id.createBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateQuestionView.this, MainActivity.class));
                finish();
            }
        });
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String questionInput = ((EditText)findViewById(R.id.quesionInput)).getText().toString();
                String opsOneInput = ((EditText)findViewById(R.id.opsOneInput)).getText().toString();
                String opsTwoInput = ((EditText)findViewById(R.id.opsTwoInput)).getText().toString();
                String opsThreeInput = ((EditText)findViewById(R.id.opsThreeInput)).getText().toString();
                String opsFourInput = ((EditText)findViewById(R.id.opsFourInput)).getText().toString();
                String correctOptionInput = ((EditText)findViewById(R.id.correctOption)).getText().toString();

                QuestionDataModel newQ = new QuestionDataModel(questionInput,
                        new ArrayList<String>(Arrays.asList(opsOneInput, opsTwoInput, opsThreeInput, opsFourInput)), correctOptionInput);

                Intent i = new Intent(CreateQuestionView.this, MainActivity.class);
                i.putExtra("newQ", newQ);

                setResult(RESULT_OK , i);
                CreateQuestionView.super.onBackPressed();
            }
        });
    }
}