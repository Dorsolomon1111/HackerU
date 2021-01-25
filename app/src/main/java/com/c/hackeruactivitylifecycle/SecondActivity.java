package com.c.hackeruactivitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;

public class SecondActivity extends AppCompatActivity {

    public static final String VALUE = "VALUE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        EditText etReturnNum = findViewById(R.id.etReturnNum);
        findViewById(R.id.btnReturn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = etReturnNum.getText().toString().trim();
                if (!value.isEmpty()){
                    int returnValue = Integer.parseInt(value);
                    if (returnValue != 0 && returnValue < 100) {
                        Intent intent = new Intent();
                        intent.putExtra(VALUE, returnValue);
                        setResult(RESULT_CANCELED, intent);
                        finish();
                    }
                }
            }
        });
    }
}