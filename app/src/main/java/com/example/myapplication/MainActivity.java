package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        signin=findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr= String.valueOf(username.getText());
                String pass= String.valueOf(password.getText());
                Toast.makeText(MainActivity.this,"Welcome "+usr,Toast.LENGTH_SHORT).show();
                UserDetail ud=new UserDetail(usr);
                Intent i=new Intent(getApplicationContext(),SelectQuiz.class);
                i.putExtra("key",ud);
                startActivity(i);
            }
        });

    }
}