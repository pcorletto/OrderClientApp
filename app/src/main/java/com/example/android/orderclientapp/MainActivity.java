package com.example.android.orderclientapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    // Private member variables

    private String mLanguagePreference;

    private Button mRegister_btn, mLogin_btn, mStore_catalog_btn, mMy_Orders_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRegister_btn = (Button) findViewById(R.id.register_btn);
        mLogin_btn = (Button) findViewById(R.id.login_btn);
        mStore_catalog_btn = (Button) findViewById(R.id.store_catalog_btn);
        mMy_Orders_btn = (Button) findViewById(R.id.my_orders_btn);

        // Retrieve any previous reading stored on the SharedPreferences file

        SharedPreferences sharedPreferences = MainActivity.this
                .getSharedPreferences(getString(R.string.PREF_FILE), MODE_PRIVATE);

        mLanguagePreference = sharedPreferences.getString(getString(R.string.LANGUAGE_PREF), "en");

        // First of all, logout if previously logged in, upon launching MainActivity
        SharedPreferences SM = getSharedPreferences(getString(R.string.login_tracker), 0);
        SharedPreferences.Editor edit = SM.edit();
        edit.putBoolean(getString(R.string.userlogin), false);
        edit.commit();

        mRegister_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
            }
        });

        mLogin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.english:
                if (item.isChecked())
                    item.setChecked(false);
                else item.setChecked(true);
                mLanguagePreference="en";
                setLocal(mLanguagePreference);
                return true;
            case R.id.espanol:
                if (item.isChecked())
                    item.setChecked(false);
                else item.setChecked(true);
                mLanguagePreference="es";
                setLocal(mLanguagePreference);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setLocal(String lang){
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);

    }

}
