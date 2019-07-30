package com.example.finance2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    Button tambah;
    EditText etFirst;
    EditText etLast;
    EditText etEmail;
    EditText etPass;

    Sqlitehelper helper =  new Sqlitehelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tambah = (Button) findViewById(R.id.bCreate);
        etFirst = (EditText) findViewById(R.id.etFirst);
        etLast = (EditText) findViewById(R.id.etLast);
        etEmail  = (EditText) findViewById(R.id.etEm);
        etPass = (EditText) findViewById(R.id.etPassword);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sqlitehelper sql = new Sqlitehelper(getApplicationContext(), null, null, 1);
                /*String first = etFirst.getText().toString();
                String last = etLast.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPass.getText().toString();*/
            }
        });

    }



    public void onRegisterClick (View view){
        if (view.getId()==R.id.bCreate){
            EditText first = (EditText) findViewById(R.id.etFirst);
            EditText last = (EditText) findViewById(R.id.etLast);
            EditText email = (EditText) findViewById(R.id.etEm);
            EditText password = (EditText) findViewById(R.id.etPass);

            String strF = first.getText().toString();
            String strL = last.getText().toString();
            String strEm = email.getText().toString();
            String strPs = password.getText().toString();

            if (strF.length()==0){
                first.setError("Mohon isi firstname");
            }
            else if (strL.length()==0){
                last.setError("Mohon isi lastname");
            }
            else if (strEm.length()==0){
                email.setError("Mohon isi email");
            }
            else if(strPs.length()==0){
                password.setError("Mohon isi password");
            }
            else{
                Kontak k = new Kontak();
                k.setFirst(strF);
                k.setLast(strL);
                k.setEmail(strEm);
                k.setPassword(strPs);
                helper.insertKontak(k);
                finish();
                Toast.makeText(Register.this, "Username dan Password berhasil dibuat", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
