package com.androidchatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class admin_login extends AppCompatActivity {
    Button btn;
    EditText usr,pas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);


        usr=(EditText)findViewById(R.id.Admin_user_name2);
        pas=(EditText)findViewById(R.id.Admin_password2);
        btn=(Button) findViewById(R.id.btn_admin_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usr.getText().toString().equals("abesit") && pas.getText().toString().equals("1234")){

                    Toast.makeText(getApplicationContext(),"Login successfull",Toast.LENGTH_LONG);
                    Intent myIntent = new Intent(admin_login.this,Users.class);
                    startActivity(myIntent);
                }
            }
        });

    }
}
