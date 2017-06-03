package com.example.android.orderclientapp2;

import android.content.Intent;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class RegistrationActivity extends ActionBarActivity {

    // Private member variables...
    private EditText mUsernameEdTxt, mPasswordEdTxt, mConfPasswordEdTxt, mEmailEdTxt, mFirstnameEdTxt,
    mLastnameEdTxt, mAddressEdTxt, mCityEdTxt, mZipcodeEdTxt, mTelephoneEdTxt,
    mMobileEdTxt;

    private String mUsername, mPassword, mConfPassword, mEmail, mFirstname, mLastname, mAddress,
            mCity, mState, mZipcode, mTelephone, mMobile;

    Spinner states_spinner;

    private Button mRegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mUsernameEdTxt = (EditText) findViewById(R.id.usernameEdTxt);
        mPasswordEdTxt = (EditText) findViewById(R.id.passwordEdTxt);
        mConfPasswordEdTxt = (EditText) findViewById(R.id.confPasswordEdTxt);
        mEmailEdTxt = (EditText) findViewById(R.id.emailEdTxt);
        mFirstnameEdTxt = (EditText) findViewById(R.id.firstnameEdTxt);
        mLastnameEdTxt = (EditText) findViewById(R.id.lastnameEdTxt);
        mAddressEdTxt = (EditText) findViewById(R.id.addressEdTxt);
        mCityEdTxt = (EditText) findViewById(R.id.cityEdTxt);
        mZipcodeEdTxt = (EditText) findViewById(R.id.zipcodeEdTxt);
        mTelephoneEdTxt = (EditText) findViewById(R.id.telephoneEdTxt);
        mMobileEdTxt = (EditText) findViewById(R.id.mobileEdTxt);

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

        mRegisterBtn = (Button) findViewById(R.id.register_btn);

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mUsername = mUsernameEdTxt.getText().toString();
                mPassword = mPasswordEdTxt.getText().toString();
                mConfPassword = mConfPasswordEdTxt.getText().toString();
                mEmail = mEmailEdTxt.getText().toString();
                mFirstname = mFirstnameEdTxt.getText().toString();
                mLastname = mLastnameEdTxt.getText().toString();
                mAddress = mAddressEdTxt.getText().toString();
                mCity = mCityEdTxt.getText().toString();
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

                // If the password is less than eight characters long, alert the user
                if(mPassword.length()<8){

                    mPasswordEdTxt.setError(getString(R.string.short_pw));
                    ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                    toneG.startTone(ToneGenerator.TONE_SUP_CONGESTION, 200);

                    Toast.makeText(getApplicationContext(), getString(R.string.short_pw), Toast.LENGTH_LONG).show();

                    return;

                }

                // If the confirmation password is different from the first entered password,
                // issue an alert

                if(!mPassword.equals(mConfPassword)){
                    mConfPasswordEdTxt.setError(getString(R.string.pw_mismatch));
                    ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                    toneG.startTone(ToneGenerator.TONE_SUP_CONGESTION, 200);

                    Toast.makeText(getApplicationContext(), getString(R.string.pw_mismatch), Toast.LENGTH_LONG).show();

                    return;
                }

                String method = "register";
                BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext());
                backgroundTask.execute(method, mUsername, mConfPassword, mFirstname, mLastname, mEmail,
                        mAddress, mCity, mState, mZipcode, mTelephone, mMobile);

                Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(intent);
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
