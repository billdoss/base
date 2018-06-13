package com.example.bildoss.ero3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class profile extends AppCompatActivity {

    private TextView commune, nomPnom, age;
    private static final String URL = "http://erotest.000webhostapp.com/profile.php?user_name=";
    private  User curUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        commune= (TextView) findViewById(R.id.commune);
        nomPnom= (TextView) findViewById(R.id.nomPnom);
        age= (TextView) findViewById(R.id.age);
        Button submit = findViewById(R.id.submit);
        final String getUserName= getIntent().getExtras().getString("user_name");

                AsyncTask task = new AsyncTask() {
                    @Override
                    protected Object doInBackground(Object[] objects) {


                        OkHttpClient client = new OkHttpClient();
                        Request request= new Request.Builder()
                                .url(URL.concat(getUserName))
                                .build();
                        try {
                            Response response = client.newCall(request).execute();

                            return response.body().string();

                            //return  curUser = new User(jsonObject.getString("NOM_USER"),jsonObject.getString("PRENOM_USER"));


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Object o) {
                        try {
                            JSONObject jsonObject = new JSONObject(o.toString());
                            curUser = new User(jsonObject.getString("NOM_USER"),jsonObject.getString("PRENOM_USER"));
                            nomPnom.append(curUser.getNom_user() + " " + curUser.getPrenom_user());
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }.execute();
            /*}



            /*String getUserName= getIntent().getExtras().getString("user_name");
            @Override
            public void onClick(View view) {
                request = new StringRequest(Request.Method.GET, URL.concat(getUserName), new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            curUser = new User(jsonObject.getString("NOM_USER"),jsonObject.getString("PRENOM_USER"));

                            commune.append(curUser.getCommune());
                            nomPnom.append(curUser.getNom_user()+" "+curUser.getPrenom_user());


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        }
        });*/
    }
}
