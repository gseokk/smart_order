package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    Button btn_school;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_school=(Button)findViewById(R.id.btn_school);
    }
    @Override
    protected void onStart() {
        super.onStart();
        btn_school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sogang.ac.kr/")));
            }
        });
    }
}