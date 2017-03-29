package com.example.android.orderclientapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    // Private member variables
    private Button mRegister_btn, mLogin_btn, mStore_catalog_btn, mMy_Orders_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRegister_btn = (Button) findViewById(R.id.register_btn);
        mLogin_btn = (Button) findViewById(R.id.login_btn);
        mStore_catalog_btn = (Button) findViewById(R.id.store_catalog_btn);
        mMy_Orders_btn = (Button) findViewById(R.id.my_orders_btn);

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
