package com.example.loginregisterapp;

import androidx.appcompat.app.AppCompatActivity;

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

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button submit, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.username_login);
        password = (EditText)findViewById(R.id.password_login);
        submit = (Button)findViewById(R.id.Loginbtn);
        register = (Button)findViewById(R.id.register_login_btn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.Loginbtn:
                        break;
                    case R.id.register_login_btn:
                        break;
                }

            }
        });
    }
}
