package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView user,jScore,pScore,cScore;
    Button goBack;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        user=findViewById(R.id.user);
        jScore=findViewById(R.id.jScore);
        pScore=findViewById(R.id.pScore);
        cScore=findViewById(R.id.cScore);
        goBack=findViewById(R.id.goBack);
        UserDetail ud=(UserDetail) getIntent().getSerializableExtra("key");
        user.setText(ud.name);
        if(ud.jAttempt)
            jScore.setText(String.valueOf(ud.javaScore));
        else
            jScore.setText("Not Attempted");
        if(ud.pAttempt)
            pScore.setText(String.valueOf(ud.pythonScore));
        else
            pScore.setText("Not Attempted");
        if(ud.cAttempt)
            cScore.setText(String.valueOf(ud.cppScore));
        else
            cScore.setText("Not Attempted");
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),SelectQuiz.class);
                i.putExtra("key",ud);
                startActivity(i);
            }
        });

    }
}