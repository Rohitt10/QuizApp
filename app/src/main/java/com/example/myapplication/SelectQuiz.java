package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectQuiz extends AppCompatActivity {
    Button pythonTest,cppTest,javaTest,display,share;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_quiz);
        pythonTest=findViewById(R.id.pythonTest);
        javaTest=findViewById(R.id.javaTest);
        display=findViewById(R.id.display);
        share=findViewById(R.id.share);
        cppTest=findViewById(R.id.cppTest);

        UserDetail ud=(UserDetail) getIntent().getSerializableExtra("key");
        if(ud.jAttempt||ud.cAttempt||ud.pAttempt)
        {
            display.setVisibility(View.VISIBLE);
            share.setVisibility(View.VISIBLE);
            if(ud.pAttempt)
                pythonTest.setEnabled(false);
            if(ud.cAttempt)
                cppTest.setEnabled(false);
            if(ud.jAttempt)
                javaTest.setEnabled(false);
        }
        else
        {
            display.setVisibility(View.INVISIBLE);
            share.setVisibility(View.INVISIBLE);
        }


        pythonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),PythonQuiz.class);
                i.putExtra("key",ud);
                startActivity(i);
            }
        });
        javaTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),JavaQuiz.class);
                i.putExtra("key",ud);
                startActivity(i);
            }
        });
        cppTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),CppQuiz.class);
                i.putExtra("key",ud);
                startActivity(i);
            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Result.class);
                i.putExtra("key",ud);
                startActivity(i);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT,ud.name+" Quiz Score");
                i.putExtra(Intent.EXTRA_TEXT,ud.name+"Quiz score is "+ud.totalScore());
                startActivity(Intent.createChooser(
                        i,"Choose a platform"
                ));
            }
        });
    }
}