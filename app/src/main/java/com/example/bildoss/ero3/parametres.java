package com.example.bildoss.ero3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class parametres extends AppCompatActivity {

    Button notifpush, modifname, modifmail, modifpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        notifpush= (Button) findViewById(R.id.notifpush);
        modifname= (Button) findViewById(R.id.modifname);
        modifmail= (Button) findViewById(R.id.modifmail);
        modifpassword= (Button) findViewById(R.id.modifpassword);
    }


}
