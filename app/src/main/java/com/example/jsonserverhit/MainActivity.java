package com.example.jsonserverhit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
Button showData;
static String JSON_STRING;
String json_string;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showData = findViewById(R.id.showData);
        textView = findViewById(R.id.showjson);



        new BackgroundTask().execute();
        showData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new BackgroundTask().execute();

                Intent intent= new Intent(MainActivity.this,displayListView.class);
                intent.putExtra("json_data",JSON_STRING);
                startActivity(intent);
                    //textView.setText(JSON_STRING);
            }
        });
    }

    class BackgroundTask extends AsyncTask <Void,Void,String>{

        String json_url = "http://api.piyasbiswas.com/apptesting/V1/catslist.php?fbclid=IwAR03vVIbRjhJy5nQxyalwgC0RKmX6PPm-c6ZIZG0jcpMRCYrONGOcDIhVvI";


        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url= new URL(json_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
                InputStream inputStream= httpURLConnection.getInputStream();
                BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder= new StringBuilder();

                while ((json_string=bufferedReader.readLine())!=null){

                    stringBuilder.append(json_string+"\n");

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }



        public BackgroundTask() {
            super();
        }

        @Override
        protected void onPostExecute(String result) {
//            showData.setText(result);

//            Log.e("server response",result);


            JSON_STRING = result;

//            Toast.makeText(getApplicationContext(),JSON_STRING,Toast.LENGTH_SHORT).show();

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
    }




