package com.example.angkringanmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username,password;
    Button btnLogin;

    DBHelper myDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username =(EditText) findViewById(R.id.username);
        password =(EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        myDB = new DBHelper(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(Login.this, "Tolong Masukkan Data", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean result = myDB.checkusernamePassword(user,pass);
                    if (result == true){
                        Intent intent = new Intent(getApplicationContext(),Dashboard.class);
                        startActivity(intent);

                    }
                    else
                    {
                        Toast.makeText(Login.this, "Data Salah", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}