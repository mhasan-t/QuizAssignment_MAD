package com.example.quizrecycler;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<QuestionDataModel> questionList = new ArrayList<>();
    int insertIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.quesView);


//        questionList.add(new QuestionDataModel("Why are you?", new ArrayList<String>(Arrays.asList("yes", "no", "maybe", "good"))));
//        questionList.add(new QuestionDataModel("Why are you2?", new ArrayList<String>(Arrays.asList("yes", "no", "maybe", "good"))));
//        questionList.add(new QuestionDataModel("Why are you3?", new ArrayList<String>(Arrays.asList("yes", "no", "maybe", "good"))));
//        questionList.add(new QuestionDataModel("Why are you4?", new ArrayList<String>(Arrays.asList("yes", "no", "maybe", "good"))));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        QuestionAdapter adapter = new QuestionAdapter(this, questionList);

        TextView noQuesMsg = findViewById(R.id.noQuesMsg);
        if(questionList.size()==0){
            noQuesMsg.setVisibility(View.VISIBLE);
        }
        else {
            noQuesMsg.setVisibility(View.INVISIBLE);
        }

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

//      Navigation
        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // There are no request codes
                            Intent data = result.getData();
                            QuestionDataModel newQ = (QuestionDataModel) data.getSerializableExtra("newQ");
                            questionList.add(newQ);
                            adapter.notifyItemInserted(insertIndex);
                            noQuesMsg.setVisibility(View.INVISIBLE);
                            insertIndex += 1;
                        }
                    }
                });

        Button goToCreateQuesBtn = findViewById(R.id.goToCreateQues);
        goToCreateQuesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                someActivityResultLauncher.launch(new Intent(MainActivity.this, CreateQuestionView.class));
//                finish();
            }
        });



    }
}