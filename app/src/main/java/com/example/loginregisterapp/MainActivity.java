package com.example.loginregisterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    String u,p;
    Button submit;
    RequestParams params;
    AsyncHttpClient client;
    public static final String MYURL = "http://192.168.1.67:8084/Preciso/Cliente";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        submit = (Button)findViewById(R.id.submit_btn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                u = username.getText().toString();
                p = password.getText().toString();

                params = new RequestParams();
                params.put("corr_compara",u);
                params.put("contra_compara",p);
                params.put("accion","login");
                params.put("place","app");

                client = new AsyncHttpClient();
                client.post(MYURL, params, new JsonHttpResponseHandler(){
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        Toast.makeText(MainActivity.this,"Submit Success f" + response,Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        super.onFailure(statusCode, headers, responseString, throwable);
                        Toast.makeText(MainActivity.this,"Something Went Wrong f "+ statusCode + responseString ,Toast.LENGTH_SHORT).show();
                        if(statusCode == 405){
                            Intent i = new Intent(MainActivity.this, LoginActivity.class);
                            startActivity(i);
                        }
                    }
                    //Toast.makeText(MainActivity.this,"Something Went Wrong" ,Toast.LENGTH_SHORT).show();


                });
            }
        });

    }
}
//14:15