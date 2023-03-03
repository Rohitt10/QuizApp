package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class PythonQuiz extends AppCompatActivity {
    RadioGroup pq1,pq2;
    Button pythonQuiz;
    boolean flag1,flag2;7
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_quiz);
        pq1=findViewById(R.id.pq1);
        pq2=findViewById(R.id.pq2);
        UserDetail ud=(UserDetail) getIntent().getSerializableExtra("key");
        ud.pAttempt=true;
        pythonQuiz=findViewById(R.id.pythonQuiz);
        pq1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.pq1o2) {
                    flag1 =true;
                }
                else
                    flag1=false;
            }
        });
        pq2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.pq2o3) {
                    flag2 =true;
                }
                else
                    flag2=false;
            }
        });
        pythonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag1) ud.pythonScore+=5;
                if(flag2) ud.pythonScore+=5;
                Intent i=new Intent(getApplicationContext(),SelectQuiz.class);
                i.putExtra("key",ud);
                startActivity(i);
            }
        });
    }
}