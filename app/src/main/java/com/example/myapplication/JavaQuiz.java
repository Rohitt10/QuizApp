package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class JavaQuiz extends AppCompatActivity {
    RadioGroup que1,que2;
    Button js;
    boolean flag1,flag2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_quiz);
        UserDetail ud=(UserDetail) getIntent().getSerializableExtra("key");
        ud.jAttempt=true;
        que1=findViewById(R.id.que1);
        que2=findViewById(R.id.que2);
        js=findViewById(R.id.javaScore);
        flag1=false;
        flag2=false;
        que1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.q1o1) {
                    flag1 =true;
                }
                else
                    flag1=false;

            }
        });
        que2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.q2o4) {
                    flag2 =true;
                }
                else
                    flag2=false;
            }
        });
        js.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag1) ud.javaScore+=5;
                if(flag2) ud.javaScore+=5;
                Toast.makeText(JavaQuiz.this,""+ud.javaScore,Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),SelectQuiz.class);
                i.putExtra("key",ud);
                startActivity(i);


//                Intent i=new Intent(getApplicationContext())
            }
        });
    }
}