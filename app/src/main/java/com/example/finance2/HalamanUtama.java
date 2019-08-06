package com.example.finance2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HalamanUtama extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button btnKeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);

        btnKeluar = (Button) findViewById(R.id.btnKeluar);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, Login.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        btnKeluar = findViewById(R.id.btnKeluar);
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(HalamanUtama.this, Login.class);
                startActivity(i);
            }
        });
    }

    public void beranda(View view) {
        Intent i = new Intent(HalamanUtama.this, BerandaAkun.class);
        startActivity(i);
    }

    public void catatan(View view) {
        Intent i = new Intent(HalamanUtama.this, Catatan.class);
        startActivity(i);
    }

    public void daftar(View view) {
        Intent i = new Intent(HalamanUtama.this, DaftarBelanja.class);
        startActivity(i);
    }

    public void anggaran(View view) {
        Intent i = new Intent(HalamanUtama.this, Anggaran.class);
        startActivity(i);
    }

    public void apk(View view) {
        Intent i = new Intent(HalamanUtama.this, TentangAplikasi.class);
        startActivity(i);
    }
}
