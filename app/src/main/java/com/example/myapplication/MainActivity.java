package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private Button yesBtn;
    private Button noBtn;
    private Question[] questions = new Question[] {
            new Question(R.string.question1,true),
            new Question(R.string.question2,false),
            new Question(R.string.question3,false),
            new Question(R.string.question4,true),
            new Question(R.string.question5,true)
    };


private int questionIndex = 0; //номер вопроса, первый = 0
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView.setText(questions[questionIndex].getQuestionResId());
        yesBtn = (Button) findViewById(R.id.yesBtn);
        noBtn = (Button) findViewById(R.id.noBtn);

        yesBtn.setOnClickListener(new View.OnClickListener() { //запуск нажатия на кнопку Да
            @Override
            public void onClick(View view) {
                if (questions[questionIndex].isAnswerTrue()) //если ответ на вопрос правильный пишет Правильно
                Toast.makeText(MainActivity.this,R.string.correсt,Toast.LENGTH_SHORT).show();
            else //в противном случае пишет неправильно
                Toast.makeText(MainActivity.this,R.string.incorreсt,Toast.LENGTH_SHORT).show();
           questionIndex++;
            textView.setText(questions[questionIndex].getQuestionResId());
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
               if (questions[questionIndex].isAnswerTrue())
                Toast.makeText(MainActivity.this,R.string.incorreсt,Toast.LENGTH_SHORT).show();
               else
                   Toast.makeText(MainActivity.this,R.string.correсt,Toast.LENGTH_SHORT).show();
               questionIndex++; //перебор вопросов после нажатия кнопки
               textView.setText(questions[questionIndex].getQuestionResId());

            }
        });
    }
}