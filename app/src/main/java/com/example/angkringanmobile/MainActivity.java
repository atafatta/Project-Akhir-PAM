package com.example.angkringanmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username,password,repassword;
    Button btnDaftar,btnLogin;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username =(EditText) findViewById(R.id.username);
        password =(EditText) findViewById(R.id.password);
        repassword =(EditText) findViewById(R.id.repassword);

        btnDaftar = (Button) findViewById(R.id.btnDaftar);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        myDB = new DBHelper(this);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("") || pass.equals("") || repass.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Harus Diisi !", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(pass.equals(repass))
                    {
                        Boolean usercheckResult = myDB.checkusername(user);
                        if(usercheckResult == false)
                        {
                            Boolean regResult = myDB.insertData(user,pass);
                            if(regResult == true){
                                Toast.makeText(MainActivity.this, "Berhasil Daftar", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Login.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(MainActivity.this, "Gagal Daftar", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "User sudah ada, Silahkan Login", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Password Salah !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });
    }
}