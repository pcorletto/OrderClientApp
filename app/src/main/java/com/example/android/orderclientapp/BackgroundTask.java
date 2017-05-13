package com.example.android.orderclientapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class BackgroundTask extends AsyncTask<String,Void,String> {
    AlertDialog alertDialog;
    Context ctx;
    BackgroundTask(Context ctx)
    {
        this.ctx =ctx;
    }

    public static String[] dbFields;

    String method;

    String testString;


    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information....");
    }
    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://corlettostore.000webhostapp.com/register.php";
        String login_url = "http://corlettostore.000webhostapp.com/login.php";
        String update_url = "http://corlettostore.000webhostapp.com/update.php";
        String catalog_url = "http://corlettostore.000webhostapp.com/catalog.php";

        method = params[0];
        if (method.equals("register")) {
            String username = params[1];
            String password = params[2];
            String firstname = params[3];
            String lastname = params[4];
            String email = params[5];
            String address = params[6];
            String city = params[7];
            String state = params[8];
            String zipcode = params[9];
            String telephone = params[10];
            String mobile = params[11];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);//
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data =URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&" +
                        URLEncoder.encode("firstname", "UTF-8") + "=" + URLEncoder.encode(firstname, "UTF-8") + "&" +
                        URLEncoder.encode("lastname", "UTF-8") + "=" + URLEncoder.encode(lastname, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(address, "UTF-8") + "&" +
                        URLEncoder.encode("city", "UTF-8") + "=" + URLEncoder.encode(city, "UTF-8") + "&" +
                        URLEncoder.encode("state", "UTF-8") + "=" + URLEncoder.encode(state, "UTF-8") + "&" +
                        URLEncoder.encode("zipcode", "UTF-8") + "=" + URLEncoder.encode(zipcode, "UTF-8") + "&" +
                        URLEncoder.encode("telephone", "UTF-8") + "=" + URLEncoder.encode(telephone, "UTF-8") + "&" +
                        URLEncoder.encode("mobile", "UTF-8") + "=" + URLEncoder.encode(mobile, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();

                //***
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS,"iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null)
                {
                    response += line;
                }

                bufferedReader.close();
                //***

                IS.close();
                //httpURLConnection.connect();
                httpURLConnection.disconnect();
                //return "Registration Success..";
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if (method.equals("update")) {
            String username = params[1];
            String firstname = params[2];
            String lastname = params[3];
            String email = params[4];
            String address = params[5];
            String city = params[6];
            String state = params[7];
            String zipcode = params[8];
            String telephone = params[9];
            String mobile = params[10];

            try {
                URL url = new URL(update_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);//
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                        URLEncoder.encode("firstname", "UTF-8") + "=" + URLEncoder.encode(firstname, "UTF-8") + "&" +
                        URLEncoder.encode("lastname", "UTF-8") + "=" + URLEncoder.encode(lastname, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(address, "UTF-8") + "&" +
                        URLEncoder.encode("city", "UTF-8") + "=" + URLEncoder.encode(city, "UTF-8") + "&" +
                        URLEncoder.encode("state", "UTF-8") + "=" + URLEncoder.encode(state, "UTF-8") + "&" +
                        URLEncoder.encode("zipcode", "UTF-8") + "=" + URLEncoder.encode(zipcode, "UTF-8") + "&" +
                        URLEncoder.encode("telephone", "UTF-8") + "=" + URLEncoder.encode(telephone, "UTF-8") + "&" +
                        URLEncoder.encode("mobile", "UTF-8") + "=" + URLEncoder.encode(mobile, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                //httpURLConnection.connect();
                httpURLConnection.disconnect();
                return "Update Success...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(method.equals("login"))
        {
            String username = params[1];
            String password = params[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null)
                {
                    response += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(method.equals("catalog"))
        {
            //String username = params[1];
            //String password = params[2];
            try {
                URL url = new URL(catalog_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                //OutputStream outputStream = httpURLConnection.getOutputStream();
                //BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                //String data = URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                  //      URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                //bufferedWriter.write(data);
                //bufferedWriter.flush();
                //bufferedWriter.close();
                //outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null)
                {
                    response += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return null;
    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
    @Override
    protected void onPostExecute(String result) {

        dbFields = new String[12];


        Log.v("TAG", result);

        if(result.equals("That username already exists"))
        {
            // If the username you are trying to register is already
            // taken, alert the user
            Log.e("TAG", ctx.getString(R.string.username_taken));
            Toast.makeText(ctx, ctx.getString(R.string.username_taken), Toast.LENGTH_LONG).show();

        }

        if(result.equals("That email address is already taken"))
        {
            // If the email address you are trying to use is already
            // taken, alert the user
            Log.e("TAG", ctx.getString(R.string.email_taken));
            Toast.makeText(ctx, ctx.getString(R.string.email_taken), Toast.LENGTH_LONG).show();

        }

        if(result.equals("Incorrect username"))
        {
            // If the user name is incorrect, display a message
            // like, incorrect username ...
            Log.e("TAG", ctx.getString(R.string.incorrect_un));

            Toast.makeText(ctx, ctx.getString(R.string.incorrect_un), Toast.LENGTH_LONG).show();

            LoginActivity.mUsernameEdTxt.setText(ctx.getString(R.string.incorrect_un));

            LoginActivity.spinner.setVisibility(View.GONE);

            return;


        }

        else if(result.equals("Incorrect password"))
        {
            // If the password is incorrect, display a message
            // like, incorrect password ...
            Log.e("TAG", ctx.getString(R.string.incorrect_pw));

            Toast.makeText(ctx, ctx.getString(R.string.incorrect_pw), Toast.LENGTH_LONG).show();

            LoginActivity.mUsernameEdTxt.setText(ctx.getString(R.string.incorrect_pw));

            LoginActivity.spinner.setVisibility(View.GONE);

            return;
        }

        else // If we get a result row from the PhP array...
        {
            int i= 0;
            int q = 0;
            // Scan the result string and extract the fields. Look at every 3 adjacent characters
            while(i<result.length()-3)
            {
                String substring = result.substring(i, i+3);

                if(substring.equals(") \""))
                {
                    String newsubstring = result.substring(i+3, result.length()-1);
                    String newString = "";
                    int p=0;

                    while(newsubstring.charAt(p)!='\"')
                    {

                        newString += newsubstring.charAt(p);
                        p++;
                    }

                    dbFields[q] = newString;
                    q++;
                    Log.e("TAG" + i, newString);

                    testString += newString + "\n";
                }

                i++;

            }

            /* dbField indexes are: 0: Client ID, 1: username
            2: password, 3: First name, 4: Last name, 5: email address
            6: address, 7: Town, 8: State, 9: Zip code
            10: Home phone, 11: Cell phone
             */

            if(method.equals("login")) {

                Intent intent = new Intent(ctx, DashboardActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(intent);

            }

            if(method.equals("catalog")) {

                Toast.makeText(ctx, testString, Toast.LENGTH_LONG).show();

            }

        }
    }
}