package com.c.hackeruactivitylifecycle;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import static com.c.hackeruactivitylifecycle.SecondActivity.VALUE;

public class MainActivity extends AppCompatActivity {

    private static final String CLICK_COUNT = "CLICK_COUNT";

    private static final int COUNTER_REQUEST_CODE = 1;
    private static final String SAVED_VALUE = "SAVED_VALUE";

    private int clickCount, start, resume, pause, stop, value;

    private TextView tvNum;

    /**
     * onCreate() - Called only once in the activity lifecycle
     * Activity is not visible yet And not in the foreground
     * 1. Things that are heavy in resources (Networking, Database etc.)
     * 2. Things we want to only happen once (findViewById, inflate etc.)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log("onCreate()");

        if (savedInstanceState != null) {
            clickCount = savedInstanceState.getInt(CLICK_COUNT);
            value = savedInstanceState.getInt(SAVED_VALUE);

        }

        tvNum = findViewById(R.id.tvNum);
        tvNum.setText(String.valueOf(value));

        findViewById(R.id.btnMoveActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showDialog();
                //clickCount++;
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //startActivity(intent);
                startActivityForResult(intent, COUNTER_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == COUNTER_REQUEST_CODE) {
                int res = data.getIntExtra(VALUE, 0);
                value += res;
                tvNum.setText(String.valueOf(value));
            }
        } else if (resultCode == RESULT_CANCELED) {

        }
    }

    /**
     * After the onCreate() - Activity is visible but not in the foreground
     */
    @Override
    protected void onStart() {
        super.onStart();
        log("onStart()");
        start++;
        //Get location
    }

    /**
     * After the onStart() - Activity is visible AND in the foreground
     */
    @Override
    protected void onResume() {
        super.onResume();
        log("onResume()");
    }

    /**
     * The Activity is Visible but not in the foreground
     */
    @Override
    protected void onPause() {
        super.onPause();
        log("onPause()");
    }

    /**
     * After the onPause() Activity is NOT visible AND NOT in the foreground
     */
    @Override
    protected void onStop() {
        super.onStop();
        log("onStop()");
        //Stop getting Location
    }

    /**
     * The activity is no longer exists
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("onDestroy()");
    }

    /**
     * After onStop() - Navigating back to the onStart() and foreground
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        log("onRestart()");
    }

    /**
     * Called after onStop(), in here we can add, change etc. values to the bundle that will be provided
     * in the onCreate() method.
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CLICK_COUNT, clickCount);
        outState.putInt(SAVED_VALUE, value);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    /**
     * Called when the Back Key Was Clicked
     */
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setTitle("יציאה")
                .setMessage("האם את בטוחה שאת רוצה לצאת מהאפליקציה?")
                .setPositiveButton("כן", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("לא", null).show();
        log("onBackPressed()");
    }

    private void log(String msg) {
        Log.d("TAG", msg);
    }

    private void showDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder
                .setTitle("This is out first dialog")
                .setMessage("This dialog was created using AlertDialog")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "The Yes clicked!", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "The No clicked!", Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}

/*
 * Launching
 *
 * Activity Creation:
 * onCreate() -> onStart() -> onResume()
 *
 * Activity Running
 *
 * Activity Destruction:
 * onPause() -> onStop() -> onDestroy()
 *
 * Destroyed
 *
 *
 * The onPause() only is called when we display system dialog
 *
 * onPause() -> onResume()
 *
 *
 * The onPause() And onStop() are called when we move to a different activity
 * When we go back to the activity the flow is:
 *      onRestart() -> onStart() -> onResume()
 *
 * onBackPressed() is a method that is called the back key was pressed by the user
 *
 * Call this when your activity is done and should be closed.
 * finish()
 *
 *
 * 160
 * 1dp = 1px
 * 100dp = 100px
 *
 * 480
 * 1dp
 *
 * screenOrientation - Define the orientation of the activity
 *
 * */