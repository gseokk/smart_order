package com.example.testapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    DatabaseReference conditionRef=mDatabase.child("result");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=(Button)findViewById(R.id.btn_next_page);
        // 다음 페이지 넘어가기
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

        Button send_btn=(Button)findViewById(R.id.send);
        //final EditText content=(EditText)findViewById(R.id.editText);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("AAA", "asdfasqw");
                EditText content=(EditText)findViewById(R.id.editText);
                String get_content = content.getText().toString();
                HashMap result = new HashMap<>();
                result.put("value", get_content);


                //mDatabase.setValue(content.getText().toString());
                //mDatabase.setValue("Hello");

                conditionRef.push().setValue(content.getText().toString());


            }
        });


    }

    // 버튼 클릭
    public void btn_Click(View view)
    {

        TextView textView = (TextView)findViewById(R.id.textView);
        EditText editText = (EditText)findViewById(R.id.editText);

        textView.setText(editText.getText());
    }

}