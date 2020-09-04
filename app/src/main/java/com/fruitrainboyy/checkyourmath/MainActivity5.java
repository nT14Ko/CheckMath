package com.fruitrainboyy.checkyourmath;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {
    private EditText editTextNumberAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        editTextNumberAnswer = findViewById(R.id.editTextNumberAnswer5);
    }

    public void onClickAnswer5(View view) {
        if (TextUtils.isEmpty(editTextNumberAnswer.getText().toString().trim())){
            editTextNumberAnswer.setError(getString(R.string.enter_answer));
        } else if (Integer.parseInt(editTextNumberAnswer.getText().toString().trim()) == 5) {
            thatsAll();
        } else {
            Toast.makeText(this, R.string.try_one_more_time, Toast.LENGTH_SHORT).show();
        }
    }

    private void thatsAll() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.thats_all);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(getApplicationContext(), MainActivity1.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}