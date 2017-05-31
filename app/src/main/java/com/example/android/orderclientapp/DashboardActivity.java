package com.example.android.orderclientapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class DashboardActivity extends ActionBarActivity {

    private EditText loginEditText;

    private Button profileButton, catalogButton, logout_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        loginEditText = (EditText) findViewById(R.id.loginEditText);

        profileButton = (Button) findViewById(R.id.profileButton);

        catalogButton = (Button) findViewById(R.id.catalogButton);

        logout_btn = (Button) findViewById(R.id.logout_btn);

        //Toast.makeText(this, BackgroundTask.dbFields[1], Toast.LENGTH_LONG).show();

        //loginEditText.setText(BackgroundTask.dbFields[1]);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);

                startActivity(intent);
            }
        });

        catalogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DashboardActivity.this, CatalogActivity.class);
                startActivity(intent);
                finish();

            }
        });

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences SM = getSharedPreferences(getString(R.string.login_tracker), 0);
                SharedPreferences.Editor edit = SM.edit();
                edit.putBoolean(getString(R.string.userlogin), false);
                edit.commit();

                Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
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
