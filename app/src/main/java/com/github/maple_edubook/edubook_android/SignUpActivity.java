package com.github.maple_edubook.edubook_android;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    Button email_btn;
    Button username_btn;
    Button password_btn;
    Button confirmpassword_btn;
    Button signup_btn;

    EditText EmailText;
    EditText UsernameText;
    EditText PasswordText;
    EditText Confirm_PasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setNavigationBarColor(Color.TRANSPARENT);

        email_btn=findViewById(R.id.email_btn);
        username_btn=findViewById(R.id.username_btn);
        password_btn=findViewById(R.id.password_btn);
        confirmpassword_btn=findViewById(R.id.confirmpassword_btn);
        signup_btn = findViewById(R.id.signUp_button);

        EmailText=findViewById(R.id.EmailText);
        UsernameText=findViewById(R.id.UsernameText);
        PasswordText=findViewById(R.id.PasswordText);
        Confirm_PasswordText=findViewById(R.id.Confirm_PasswordText);

        email_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmailText.setText("");
            }
        });
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
        confirmpassword_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Confirm_PasswordText.setText("");
            }
        });
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}