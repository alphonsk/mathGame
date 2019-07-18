package com.westphillylabs.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView scoreTextView;
    TextView mathTextView;
    TextView countTextView;
    TextView answerTextView;
    Button startBttn;
    Button stopBttn;
    Button bttn0;
    Button bttn1;
    Button bttn2;
    Button bttn3;
    ArrayList<Integer> answerArr = new ArrayList<>();
//    int score, totalQuestions, correctAns, wrongAns;
    int a, b, c, d;
    int score = 0;
    int totalQuestions = 0;
    int correctAns = 0;
    int wrongAns = 0;
    Boolean started = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBttn = findViewById(R.id.startBttn);
        stopBttn = findViewById(R.id.stopBttn);
        mathTextView = findViewById(R.id.mathTextView);
        answerTextView = findViewById(R.id.answerTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        countTextView = findViewById(R.id.countTextView);
        bttn0 = findViewById(R.id.button0);
        bttn1 = findViewById(R.id.button1);
        bttn2 = findViewById(R.id.button2);
        bttn3 = findViewById(R.id.button3);

    }

    public void chooseAnswer(View view){


        Boolean ans = view.getTag().toString().equals(Integer.toString(c));

        if (started) {
            if (ans) {
                answerTextView.setText("Correct");
                answerTextView.setTextColor(Color.GREEN);
                score += 10;
                scoreTextView.setText(Integer.toString(score));
                correctAns += 1;
                countTextView.setText(Integer.toString(correctAns) + " / " + Integer.toString(wrongAns));
                answerArr.clear();
                playGame();
//                bttn0.setText(Integer.toString(answerArr.get(0)));
//                bttn1.setText(Integer.toString(answerArr.get(1)));
//                bttn2.setText(Integer.toString(answerArr.get(2)));
//                bttn3.setText(Integer.toString(answerArr.get(3)));
            } else {
                answerTextView.setText("Incorrect");
                answerTextView.setTextColor(Color.RED);
                score -= 10;
                scoreTextView.setText(Integer.toString(score));
                wrongAns += 1;
                countTextView.setText(Integer.toString(correctAns) + " / " + Integer.toString(wrongAns));
                answerArr.clear();
                playGame();
            }
        }


    }



    //
    public void playGame(){
        Random rand = new Random();
        a = rand.nextInt(20);
        b = rand.nextInt(20);
        c = rand.nextInt(4);

        mathTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        for (int i=0; i<4; i++){
            if (i == c) {
                answerArr.add(a+b);
            } else {
                d = a + rand.nextInt(20);
                if (d != (a+b)) {
                    answerArr.add(d);
                } else {
                    answerArr.add(d + 1);
                }
            }
        }

        //
        bttn0.setText(Integer.toString(answerArr.get(0)));
        bttn1.setText(Integer.toString(answerArr.get(1)));
        bttn2.setText(Integer.toString(answerArr.get(2)));
        bttn3.setText(Integer.toString(answerArr.get(3)));
    }


    //
    public void startGame(View view){
        started = true;
        answerArr.clear();
        playGame();
        startBttn.setVisibility(View.INVISIBLE);
        stopBttn.setVisibility(View.VISIBLE);
    }

    public void endGame(View view){
        started = false;
        answerArr.clear();
        startBttn.setVisibility(View.VISIBLE);
        stopBttn.setVisibility(View.INVISIBLE);

    }


}
