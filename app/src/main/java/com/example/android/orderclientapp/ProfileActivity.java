package com.example.android.orderclientapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class ProfileActivity extends ActionBarActivity {

    public static EditText mFirstnameEdTxt, mLastnameEdTxt, mAddressEdTxt,
    mCityEdTxt, mZipCodeEdTxt, mTelephoneEdTxt, mMobileEdTxt, mEmailEdTxt;

    private String mUsername, mEmail, mFirstname, mLastname, mAddress,
            mCity, mState, mZipcode, mTelephone, mMobile;

    Spinner states_spinner;

    private Button mLogoutButton, update_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mFirstnameEdTxt = (EditText) findViewById(R.id.firstnameEdTxt);
        mLastnameEdTxt = (EditText) findViewById(R.id.lastnameEdTxt);
        mAddressEdTxt = (EditText) findViewById(R.id.addressEdTxt);
        mCityEdTxt = (EditText) findViewById(R.id.cityEdTxt);
        mZipCodeEdTxt = (EditText) findViewById(R.id.zipcodeEdTxt);
        mTelephoneEdTxt = (EditText) findViewById(R.id.telephoneEdTxt);
        mMobileEdTxt = (EditText) findViewById(R.id.mobileEdTxt);
        mEmailEdTxt = (EditText) findViewById(R.id.emailEdTxt);
        mLogoutButton = (Button) findViewById(R.id.logout_btn);
        update_btn = (Button) findViewById(R.id.update_btn);

        states_spinner = (Spinner) findViewById(R.id.states_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.states, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        states_spinner.setAdapter(adapter);

        states_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                mState = states_spinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /* dbField indexes are: 0: Client ID, 1: username
            2: password, 3: First name, 4: Last name, 5: email address
            6: address, 7: Town, 8: State, 9: Zip code
            10: Home phone, 11: Cell phone
             */

        // Hide the keyboard upon launching the activity
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        mFirstnameEdTxt.setText(BackgroundTask.dbFields[3]);
        mLastnameEdTxt.setText(BackgroundTask.dbFields[4]);
        mAddressEdTxt.setText(BackgroundTask.dbFields[6]);
        mCityEdTxt.setText(BackgroundTask.dbFields[7]);

        int position = adapter.getPosition(BackgroundTask.dbFields[8]);
        states_spinner.setSelection(position);
        
        mZipCodeEdTxt.setText(BackgroundTask.dbFields[9]);
        mTelephoneEdTxt.setText(BackgroundTask.dbFields[10]);
        mMobileEdTxt.setText(BackgroundTask.dbFields[11]);
        mEmailEdTxt.setText(BackgroundTask.dbFields[5]);

        mFirstnameEdTxt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mFirstnameEdTxt.requestFocus();
                InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                if(imm != null) {
                    imm.showSoftInput(mFirstnameEdTxt, 0);
                }
                mFirstnameEdTxt.setText("");

                return true;
            }
        });

        mLastnameEdTxt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mLastnameEdTxt.requestFocus();
                InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                if(imm != null) {
                    imm.showSoftInput(mLastnameEdTxt, 0);
                }
                mLastnameEdTxt.setText("");

                return true;
            }
        });

        mFirstnameEdTxt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mFirstnameEdTxt.requestFocus();
                InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                if(imm != null) {
                    imm.showSoftInput(mFirstnameEdTxt, 0);
                }
                mFirstnameEdTxt.setText("");

                return true;
            }
        });

        mAddressEdTxt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mAddressEdTxt.requestFocus();
                InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                if(imm != null) {
                    imm.showSoftInput(mAddressEdTxt, 0);
                }
                mAddressEdTxt.setText("");

                return true;
            }
        });

        mCityEdTxt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mCityEdTxt.requestFocus();
                InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                if(imm != null) {
                    imm.showSoftInput(mCityEdTxt, 0);
                }
                mCityEdTxt.setText("");

                return true;
            }
        });



        mZipCodeEdTxt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mZipCodeEdTxt.requestFocus();
                InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                if(imm != null) {
                    imm.showSoftInput(mZipCodeEdTxt, 0);
                }
                mZipCodeEdTxt.setText("");

                return true;
            }
        });

        mTelephoneEdTxt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mTelephoneEdTxt.requestFocus();
                InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                if(imm != null) {
                    imm.showSoftInput(mTelephoneEdTxt, 0);
                }
                mTelephoneEdTxt.setText("");

                return true;
            }
        });

        mMobileEdTxt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mMobileEdTxt.requestFocus();
                InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                if(imm != null) {
                    imm.showSoftInput(mMobileEdTxt, 0);
                }
                mMobileEdTxt.setText("");

                return true;
            }
        });

        mEmailEdTxt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mEmailEdTxt.requestFocus();
                InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                if(imm != null) {
                    imm.showSoftInput(mEmailEdTxt, 0);
                }
                mEmailEdTxt.setText("");

                return true;
            }
        });

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mUsername = BackgroundTask.dbFields[1];
                mFirstname = mFirstnameEdTxt.getText().toString();
                mLastname = mLastnameEdTxt.getText().toString();
                mEmail = mEmailEdTxt.getText().toString();
                mAddress = mAddressEdTxt.getText().toString();
                mCity = mCityEdTxt.getText().toString();

                mZipcode = mZipCodeEdTxt.getText().toString();
                mTelephone = mTelephoneEdTxt.getText().toString();
                mMobile = mMobileEdTxt.getText().toString();

                // Validate user's input. If the user skips one of the entries,
                // then alert them to enter it.

                if(TextUtils.isEmpty(mEmail)){
                    mEmailEdTxt.setError(getString(R.string.empty_edittext_alert));
                    ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                    toneG.startTone(ToneGenerator.TONE_SUP_CONGESTION, 200);
                    return;
                }

                if(TextUtils.isEmpty(mFirstname)){
                    mFirstnameEdTxt.setError(getString(R.string.empty_edittext_alert));
                    ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                    toneG.startTone(ToneGenerator.TONE_SUP_CONGESTION, 200);
                    return;
                }

                if(TextUtils.isEmpty(mLastname)){
                    mLastnameEdTxt.setError(getString(R.string.empty_edittext_alert));
                    ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                    toneG.startTone(ToneGenerator.TONE_SUP_CONGESTION, 200);
                    return;
                }

                if(TextUtils.isEmpty(mAddress)){
                    mAddressEdTxt.setError(getString(R.string.empty_edittext_alert));
                    ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                    toneG.startTone(ToneGenerator.TONE_SUP_CONGESTION, 200);
                    return;
                }

                if(TextUtils.isEmpty(mCity)){
                    mCityEdTxt.setError(getString(R.string.empty_edittext_alert));
                    ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                    toneG.startTone(ToneGenerator.TONE_SUP_CONGESTION, 200);
                    return;
                }

                if(TextUtils.isEmpty(mZipcode)){
                    mZipCodeEdTxt.setError(getString(R.string.empty_edittext_alert));
                    ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                    toneG.startTone(ToneGenerator.TONE_SUP_CONGESTION, 200);
                    return;
                }

                if(TextUtils.isEmpty(mTelephone)){
                    mTelephoneEdTxt.setError(getString(R.string.empty_edittext_alert));
                    ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                    toneG.startTone(ToneGenerator.TONE_SUP_CONGESTION, 200);
                    return;
                }

                if(TextUtils.isEmpty(mMobile)){
                    mMobileEdTxt.setError(getString(R.string.empty_edittext_alert));
                    ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                    toneG.startTone(ToneGenerator.TONE_SUP_CONGESTION, 200);
                    return;
                }

                String method = "update";
                BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext());
                backgroundTask.execute(method, mUsername, mFirstname, mLastname, mEmail,
                        mAddress, mCity, mState, mZipcode, mTelephone, mMobile);

                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences SM = getSharedPreferences(getString(R.string.login_tracker), 0);
                SharedPreferences.Editor edit = SM.edit();
                edit.putBoolean(getString(R.string.userlogin), false);
                edit.commit();

                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
        //super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
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
