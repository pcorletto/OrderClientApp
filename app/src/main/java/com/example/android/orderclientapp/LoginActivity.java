package com.example.android.orderclientapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;


public class LoginActivity extends ActionBarActivity {

    // Private member variables
    public static EditText mUsernameEdTxt, mPasswordEdTxt;
    private String username, password;
    private Button login_btn;
    public static ProgressBar spinner;

    SharedPreferences SM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SM = getSharedPreferences(getString(R.string.login_tracker), 0);
        Boolean is_logged_in = SM.getBoolean(getString(R.string.userlogin), false);
        if(is_logged_in){
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
            return;

        }

        mUsernameEdTxt = (EditText) findViewById(R.id.usernameEdTxt);
        mPasswordEdTxt = (EditText) findViewById(R.id.passwordEdTxt);
        spinner = (ProgressBar) findViewById(R.id.progressBar);
        login_btn = (Button) findViewById(R.id.login_btn);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = mUsernameEdTxt.getText().toString();
                password = mPasswordEdTxt.getText().toString();

                // Check if the user did not enter anything. If no entry, then alert
                if (TextUtils.isEmpty(username)) {
                    mUsernameEdTxt.setError(getString(R.string.empty_edittext_alert));
                    ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                    toneG.startTone(ToneGenerator.TONE_SUP_CONGESTION, 200);
                    return;
                }

                // Check if the user did not enter anything. If no entry, then alert
                if (TextUtils.isEmpty(password)) {
                    mPasswordEdTxt.setError(getString(R.string.empty_edittext_alert));
                    ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                    toneG.startTone(ToneGenerator.TONE_SUP_CONGESTION, 200);
                    return;
                }

                String method = "login";
                SharedPreferences.Editor edit = SM.edit();
                edit.putBoolean(getString(R.string.userlogin), true);
                edit.commit();

                spinner.setVisibility(View.VISIBLE);
                
                BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext());
                backgroundTask.execute(method, username, password);

                mUsernameEdTxt.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        mUsernameEdTxt.requestFocus();
                        InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        if(imm != null) {
                            imm.showSoftInput(mUsernameEdTxt, 0);
                        }
                        mUsernameEdTxt.setText("");

                        return true;
                    }
                });


                mPasswordEdTxt.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        mPasswordEdTxt.requestFocus();
                        InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        if(imm != null) {
                            imm.showSoftInput(mPasswordEdTxt, 0);
                        }
                        mPasswordEdTxt.setText("");

                        // Hide the password field upon touch
                        if(mPasswordEdTxt.getTransformationMethod()==null)
                        {
                            mPasswordEdTxt.setTransformationMethod(new PasswordTransformationMethod());
                        }

                        return true;
                    }
                });

               }

        });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
