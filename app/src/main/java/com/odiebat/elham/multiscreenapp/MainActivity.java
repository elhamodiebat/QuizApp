package com.odiebat.elham.multiscreenapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    String uName;
    EditText userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void go(View view) {
        Intent intent = new Intent(MainActivity.this, quiz.class);
        userName = findViewById(R.id.username);
        uName = userName.getText().toString();
        intent.putExtra("EXTRA_USER_NAME", uName);
        startActivity(intent);
    }
}
