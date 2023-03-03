package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class CppQuiz extends AppCompatActivity {
    RadioGroup cq1,cq2;
    Button cppQuiz;
    boolean flag1,flag2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpp_quiz);
        cq1=findViewById(R.id.cq1);
        cq2=findViewById(R.id.cq2);
        UserDetail ud=(UserDetail) getIntent().getSerializableExtra("key");
        ud.cAttempt=true;
        cppQuiz=findViewById(R.id.cppQuiz);
        cq1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.cq1op1) {
                    flag1 =true;
                }
                else
                    flag1=false;
            }
        });
        cq2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.cq2o4) {
                    flag2 =true;
                }
                else
                    flag2=false;
            }
        });
        cppQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag1) ud.cppScore+=5;
                if(flag2) ud.cppScore+=5;
                Intent i=new Intent(getApplicationContext(),SelectQuiz.class);
                i.putExtra("key",ud);
                startActivity(i);
            }
        });
    }
}