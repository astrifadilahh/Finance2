package com.example.finance2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    Sqlitehelper helper = new Sqlitehelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onButtonClick(View view){
        if(view.getId()==R.id.bLogin){
            EditText email = (EditText) findViewById(R.id.etEmail);
            EditText password = (EditText) findViewById(R.id.etPassword);
            String strE = email.getText().toString();
            String strP = password.getText().toString();
            String strPass = helper.searchPass(strE);

            if (email.length()==0 && password.length()==0){
                email.setError("Mohon mengisi email");
                password.setError("Mohon mengisi password");
            }
            else if (email.length()==0){
                email.setError("Mohon mengisi email");
            }
            else if(password.length()==0){
                password.setError("Mohon mengisi password");
            }
            else if (strP.equals(strPass))
            {
                Intent i = new Intent(Login.this, HalamanUtama.class);
                startActivity(i);
            }
            else{
                Toast.makeText(Login.this, "Password doesn't match", Toast.LENGTH_SHORT).show();
            }
        }
        if (view.getId()==R.id.bRegis)
        {
            Intent i = new Intent(Login.this, Register.class);
            startActivity(i);
        }
    }

    public void regis(View view) {
        Intent i = new Intent(Login.this, Register.class);
        startActivity(i);
    }
}