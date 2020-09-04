package com.fruitrainboyy.checkyourmath;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private EditText editTextNumberAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editTextNumberAnswer = findViewById(R.id.editTextNumberAnswer2);
    }

    public void onClickAnswer2(View view) {
        if (TextUtils.isEmpty(editTextNumberAnswer.getText().toString().trim())){
            editTextNumberAnswer.setError(getString(R.string.enter_answer));
        } else if (Integer.parseInt(editTextNumberAnswer.getText().toString().trim()) == 1) {
            Toast.makeText(this, R.string.yes, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.try_one_more_time, Toast.LENGTH_SHORT).show();
        }
    }
}