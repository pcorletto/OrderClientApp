package com.example.android.orderclientapp;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class RegistrationActivity extends ActionBarActivity {

    // Private member variables
    private EditText mUsernameEdTxt, mPasswordEdTxt, mEmailEdTxt, mFirstnameEdTxt,
    mLastnameEdTxt, mAddressEdTxt, mCityEdTxt, mStateEdTxt, mZipcodeEdTxt, mTelephoneEdTxt,
    mMobileEdTxt;

    private String mUsername, mPassword, mEmail, mFirstname, mLastname, mAddress,
            mCity, mState, mZipcode, mTelephone, mMobile;

    private Button mRegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mUsernameEdTxt = (EditText) findViewById(R.id.usernameEdTxt);
        mPasswordEdTxt = (EditText) findViewById(R.id.passwordEdTxt);
        mEmailEdTxt = (EditText) findViewById(R.id.emailEdTxt);
        mFirstnameEdTxt = (EditText) findViewById(R.id.firstnameEdTxt);
        mLastnameEdTxt = (EditText) findViewById(R.id.lastnameEdTxt);
        mAddressEdTxt = (EditText) findViewById(R.id.addressEdTxt);
        mCityEdTxt = (EditText) findViewById(R.id.cityEdTxt);
        mStateEdTxt = (EditText) findViewById(R.id.stateEdTxt);
        mZipcodeEdTxt = (EditText) findViewById(R.id.zipcodeEdTxt);
        mTelephoneEdTxt = (EditText) findViewById(R.id.telephoneEdTxt);
        mMobileEdTxt = (EditText) findViewById(R.id.mobileEdTxt);

        mRegisterBtn = (Button) findViewById(R.id.register_btn);

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mUsername = mUsernameEdTxt.getText().toString();
                mPassword = mPasswordEdTxt.getText().toString();
                mEmail = mEmailEdTxt.getText().toString();
                mFirstname = mFirstnameEdTxt.getText().toString();
                mLastname = mLastnameEdTxt.getText().toString();
                mAddress = mAddressEdTxt.getText().toString();
                mCity = mCityEdTxt.getText().toString();
                mState = mStateEdTxt.getText().toString();
                mZipcode = mZipcodeEdTxt.getText().toString();
                mTelephone = mTelephoneEdTxt.getText().toString();
                mMobile = mMobileEdTxt.getText().toString();

                // Validate user's input. If the user skips one of the entries,
                // then alert them to enter it.

                if(TextUtils.isEmpty(mUsername)){
                    mUsernameEdTxt.setError(getString(R.string.empty_edittext_alert));
                    ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                    toneG.startTone(ToneGenerator.TONE_SUP_CONGESTION, 200);
                    return;
                }

                if(TextUtils.isEmpty(mPassword)){
                    mPasswordEdTxt.setError(getString(R.string.empty_edittext_alert));
                    ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                    toneG.startTone(ToneGenerator.TONE_SUP_CONGESTION, 200);
                    return;
                }

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

                if(TextUtils.isEmpty(mState)){
                    mStateEdTxt.setError(getString(R.string.empty_edittext_alert));
                    ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                    toneG.startTone(ToneGenerator.TONE_SUP_CONGESTION, 200);
                    return;
                }

                if(TextUtils.isEmpty(mZipcode)){
                    mZipcodeEdTxt.setError(getString(R.string.empty_edittext_alert));
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

                String method = "register";
                BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext());
                backgroundTask.execute(method, mUsername, mPassword, mFirstname, mLastname, mEmail,
                        mAddress, mCity, mState, mZipcode, mTelephone, mMobile);
                finish();

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
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
