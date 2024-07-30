package com.github.maple_edubook.edubook_android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    Button username_btn;
    Button password_btn;
    Button login_btn;

    EditText UsernameText;
    EditText PasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setNavigationBarColor(Color.TRANSPARENT);

        username_btn = findViewById(R.id.username_btn);
        password_btn = findViewById(R.id.password_btn);
        login_btn = findViewById(R.id.Loginbutton);

        UsernameText = findViewById(R.id.UsernameText);
        PasswordText = findViewById(R.id.PasswordText);

        username_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsernameText.setText("");
            }
        });
        password_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PasswordText.setText("");
            }
        });
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}