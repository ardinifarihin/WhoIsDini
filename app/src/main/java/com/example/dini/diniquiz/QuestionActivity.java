package com.example.dini.diniquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {
    TextView tv;
    Button submit_button, quit_button;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "What is her full name?",
            "What is her birth date?",
            "Where is her hometown?",
            "What type of food does she like?",
            "Which is her favorite colour?",
            "How do we first meet?",
            "When is our first anniversary?",
            "How many sibling(s) do/does she has and what is the name?",
            "What makes her happy the most?",
            "What makes her mad the most?"
    };
    String answers[] = {"Ardini Farihin Binti Saprudin","17th October 1995","Alor Setar, Kedah","Thai Cuisine","All of the mentioned","At UMSA event","3rd March 2020","1, Amirul Syafi","food","no food"};
    String opt[] = {
            "Ardini Farihin Binti Saprudin","Ardini Farihan Binti Saparudin","Ardini Binti Saprudin","Ardini Farahin Binti Saprudin",
            "11th November 1995","7th October 1995","17th October 1995","10th July 1995",
            "Perlis, Kedah","Sungai Petani, Kedah","Alor Mengkudu, Kedah","Alor Setar, Kedah",
            "Malay Cuisine","Western Cuisine","Thai Cuisine","Korean Cuisine",
            "Pastel","Black","White","All of the mentioned",
            "At UMSA event","At university","At EDENZ house","In engineering lab",
            "28th February 2020","2nd March 2020","3rd March 2020","None of the mentioned",
            "1, Amirul Syarif","1, Amirul Syafi","2, Afiq Shazrin dan Amirul Syafiq","2, Amirul Shazrin dan Afiq Shazwan",
            "food","wifi","duit","game",
            "no game","no wifi","no food","no duit"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
            textView.setText("Hello " + name);

        submit_button=(Button)findViewById(R.id.buttonNext);
        quit_button=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }


}