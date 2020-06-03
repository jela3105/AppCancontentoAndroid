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
    String u,p;
    Button submit;
    RequestParams params;
    AsyncHttpClient client;
    public static final String MYURL = "http://192.168.1.68:8084/Preciso/Cliente";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.username_login);
        password = (EditText)findViewById(R.id.password_login);
        submit = (Button)findViewById(R.id.Loginbtn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                u = username.getText().toString();
                p = password.getText().toString();

                params = new RequestParams();
                params.put("correo",u);
                params.put("contra",p);
                params.put("action","login");
                params.put("place","app");

                client = new AsyncHttpClient();
                client.post(MYURL, params, new JsonHttpResponseHandler(){
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        try {
                            String respuesta = (String)response.get("Login");
                            if(respuesta.equals("camposVacios")){
                                Toast.makeText(LoginActivity.this,"Por favor, llena todos los campos",Toast.LENGTH_SHORT).show();
                            }else if(respuesta.equals("Cliente")){
                                Toast.makeText(LoginActivity.this,"Inicio sesion correcto",Toast.LENGTH_SHORT).show();
                            }else if(respuesta.equals("usuarioNoEncontrado")){
                            Toast.makeText(LoginActivity.this,"Usuario no encontrado",Toast.LENGTH_SHORT).show();
                            }else if(respuesta.equals("contraseñaIncorrecta")){
                            Toast.makeText(LoginActivity.this,"Contraseña incorrecta",Toast.LENGTH_SHORT).show();
                            }
                        }catch(Exception e){

                        }
                    }


                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        super.onFailure(statusCode, headers, responseString, throwable);
                        Toast.makeText(LoginActivity.this,"Something Went Wrong f "+ statusCode + responseString ,Toast.LENGTH_SHORT).show();
                    }
                    //Toast.makeText(MainActivity.this,"Something Went Wrong" ,Toast.LENGTH_SHORT).show();


                });
            }
        });
    }
}
