package com.example.android.orderclientapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;


public class ProfileActivity extends ActionBarActivity {

    public static EditText mFirstnameEdTxt, mLastnameEdTxt, mAddressEdTxt,
    mCityEdTxt, mStateEdTxt, mZipCodeEdTxt, mTelephoneEdTxt, mMobileEdTxt, mEmailEdTxt;

    private Button mLogoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mFirstnameEdTxt = (EditText) findViewById(R.id.firstnameEdTxt);
        mLastnameEdTxt = (EditText) findViewById(R.id.lastnameEdTxt);
        mAddressEdTxt = (EditText) findViewById(R.id.addressEdTxt);
        mCityEdTxt = (EditText) findViewById(R.id.cityEdTxt);
        mStateEdTxt = (EditText) findViewById(R.id.stateEdTxt);
        mZipCodeEdTxt = (EditText) findViewById(R.id.zipcodeEdTxt);
        mTelephoneEdTxt = (EditText) findViewById(R.id.telephoneEdTxt);
        mMobileEdTxt = (EditText) findViewById(R.id.mobileEdTxt);
        mEmailEdTxt = (EditText) findViewById(R.id.emailEdTxt);
        mLogoutButton = (Button) findViewById(R.id.logout_btn);

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
        mStateEdTxt.setText(BackgroundTask.dbFields[8]);
        mZipCodeEdTxt.setText(BackgroundTask.dbFields[9]);
        mTelephoneEdTxt.setText(BackgroundTask.dbFields[10]);
        mMobileEdTxt.setText(BackgroundTask.dbFields[11]);
        mEmailEdTxt.setText(BackgroundTask.dbFields[5]);

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
