package com.github.maple_edubook.edubook_android;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class OnBoardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_EduBook_android);
        setContentView(R.layout.activity_onboarding);

        EdgeToEdge.enable(this);


        // todo: NewActivity로 바로 이동함. 로그인 안되어있으면 회원가입 페이지로, 로그인 되어있으면 바로 홈 화면으로
        // startActivity(new Intent(this, NewActivity.class));
        super.onCreate(savedInstanceState);
    }
}