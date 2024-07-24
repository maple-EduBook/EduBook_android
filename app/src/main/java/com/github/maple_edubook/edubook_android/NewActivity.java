package com.github.maple_edubook.edubook_android;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_new);

        EdgeToEdge.enable(this);

        super.onCreate(savedInstanceState);
    }
}
