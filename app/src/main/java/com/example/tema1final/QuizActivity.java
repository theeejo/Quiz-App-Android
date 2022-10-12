package com.example.tema1final;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuizActivity extends AppCompatActivity {

    private TextView question;
    private TextView questionNr;
    private Button option1Button;
    private Button option2Button;
    private Button option3Button;
    private Button option4Button;

    private ArrayList<Quiz> quizArrayList;
    int score = 0;
    int currentQuestion = 1;
    int position;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().hide();

        question = findViewById(R.id.smarandoiu_theodor_textview);
        questionNr = findViewById(R.id.smarandoiu_theodor_question);
        option1Button = findViewById(R.id.smarandoiu_theodor_option1);
        option2Button = findViewById(R.id.smarandoiu_theodor_option2);
        option3Button = findViewById(R.id.smarandoiu_theodor_option3);
        option4Button = findViewById(R.id.smarandoiu_theodor_option4);
        quizArrayList = new ArrayList<>();
        getQuizQuestion(quizArrayList);
        position = 0;

        setDataToView(position);

        option1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizArrayList.get(position).getCorrectAnswer().trim().toLowerCase().equals(option1Button.getText().toString().trim().toLowerCase())) {
                    score++;
                }
                currentQuestion++;
                position++;
                setDataToView(position);
            }
        });

        option2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizArrayList.get(position).getCorrectAnswer().trim().toLowerCase().equals(option2Button.getText().toString().trim().toLowerCase())) {
                    score++;
                }
                currentQuestion++;
                position++;
                setDataToView(position);
            }
        });

        option3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizArrayList.get(position).getCorrectAnswer().trim().toLowerCase().equals(option3Button.getText().toString().trim().toLowerCase())) {
                    score++;
                }
                currentQuestion++;
                position++;
                setDataToView(position);
            }
        });

        option4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizArrayList.get(position).getCorrectAnswer().trim().toLowerCase().equals(option4Button.getText().toString().trim().toLowerCase())) {
                    score++;
                }
                currentQuestion++;
                position++;

                setDataToView(position);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void showBottomSheet() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(QuizActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet, (LinearLayout) findViewById(R.id.smarandoiu_theodor_LLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.smarandoiu_theodor_textview);
        Button restartQuizButton = bottomSheetView.findViewById(R.id.smarandoiu_theodor_restart);
        Button exitQuizButton = bottomSheetView.findViewById(R.id.smarandoiu_theodor_exit);

        scoreTV.setText(getString(R.string.YourScoreis) + score + getString(R.string.out10));
        restartQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position = 0;
                setDataToView(position);
                currentQuestion = 1;
                score = 0;
                bottomSheetDialog.dismiss();
            }
        });

        exitQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }


    @SuppressLint("SetTextI18n")
    private void setDataToView(int position) {
        questionNr.setText(getString(R.string.question).toString() + getString(R.string.spatiu) + currentQuestion + getString(R.string.outof10).toString());
        if (currentQuestion > 10) {
            showBottomSheet();
            questionNr.setText(getString(R.string.question).toString() + getString(R.string.zece) + getString(R.string.outof10).toString());
        } else {
            question.setText(quizArrayList.get(position).getQuestion());
            option1Button.setText(quizArrayList.get(position).getOpt1());
            option2Button.setText(quizArrayList.get(position).getOpt2());
            option3Button.setText(quizArrayList.get(position).getOpt3());
            option4Button.setText(quizArrayList.get(position).getOpt4());
        }


    }


    private void getQuizQuestion(ArrayList<Quiz> quizArrayList) {

        quizArrayList.add(new Quiz(getString(R.string.q1),getString(R.string.c1),getString(R.string.q1a1),getString(R.string.q1a2),getString(R.string.q1a3),getString(R.string.q1a4)));
        quizArrayList.add(new Quiz(getString(R.string.q2),getString(R.string.c2),getString(R.string.q2a1),getString(R.string.q2a2),getString(R.string.q2a3),getString(R.string.q2a4)));
        quizArrayList.add(new Quiz(getString(R.string.q3),getString(R.string.c3),getString(R.string.q3a1),getString(R.string.q3a2),getString(R.string.q3a3),getString(R.string.q3a4)));
        quizArrayList.add(new Quiz(getString(R.string.q4),getString(R.string.c4),getString(R.string.q4a1),getString(R.string.q4a2),getString(R.string.q4a3),getString(R.string.q4a4)));
        quizArrayList.add(new Quiz(getString(R.string.q5),getString(R.string.c5),getString(R.string.q5a1),getString(R.string.q5a2),getString(R.string.q5a3),getString(R.string.q5a4)));
        quizArrayList.add(new Quiz(getString(R.string.q6),getString(R.string.c6),getString(R.string.q6a1),getString(R.string.q6a2),getString(R.string.q6a3),getString(R.string.q6a4)));
        quizArrayList.add(new Quiz(getString(R.string.q7),getString(R.string.c7),getString(R.string.q7a1),getString(R.string.q7a2),getString(R.string.q7a3),getString(R.string.q7a4)));
        quizArrayList.add(new Quiz(getString(R.string.q8),getString(R.string.c8),getString(R.string.q8a1),getString(R.string.q8a2),getString(R.string.q8a3),getString(R.string.q8a4)));
        quizArrayList.add(new Quiz(getString(R.string.q9),getString(R.string.c9),getString(R.string.q9a1),getString(R.string.q9a2),getString(R.string.q9a3),getString(R.string.q9a4)));
        quizArrayList.add(new Quiz(getString(R.string.q10),getString(R.string.c10),getString(R.string.q10a1),getString(R.string.q10a2),getString(R.string.q10a3),getString(R.string.q10a4)));

    }
}