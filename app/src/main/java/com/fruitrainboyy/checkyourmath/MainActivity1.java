package com.fruitrainboyy.checkyourmath;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {
    private EditText editTextNumberAnswer;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        editTextNumberAnswer = findViewById(R.id.editTextNumberAnswer);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        firstStart();
    }
    private void firstStart(){
//        if (!preferences.getBoolean("isFirstStart", true)) {
            preferences.edit().putBoolean("isFirstStart", true).apply();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage( R.string.the_task);
            builder.setPositiveButton(R.string.got_it, new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
//        }
    }

    public void onClickAnswer(View view) {
        if (TextUtils.isEmpty(editTextNumberAnswer.getText().toString().trim())){
            editTextNumberAnswer.setError(getString(R.string.enter_answer));
        } else if (Integer.parseInt(editTextNumberAnswer.getText().toString().trim()) == 2) {
            Toast.makeText(this, R.string.yes, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.try_one_more_time, Toast.LENGTH_SHORT).show();
        }
    }
}