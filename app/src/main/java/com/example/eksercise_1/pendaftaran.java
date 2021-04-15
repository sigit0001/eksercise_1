package com.example.eksercise_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PendaftaranActivity extends AppCompatActivity {

    EditText Nuser,Auser,Euser,Puser,REuser;
    Button btnBatal,btnDaftar;
    CheckBox checklaki,checkperempuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pendaftaran);

        Nuser  = findViewById(R.id.editTextTextPersonName5);
        Auser  = findViewById(R.id.editTextTextPersonName);
        Euser  = findViewById(R.id.editTextTextPersonName2);
        Puser  = findViewById(R.id.editTextTextPersonName3);
        REuser = findViewById(R.id.editTextTextPersonName4);

        btnBatal  = findViewById(R.id.button);
        btnDaftar = findViewById(R.id.button2);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Nuser.getText().toString().length()==0){
                    //jika nama belum di isi / masih kosong
                    Nuser.setError("Nama diperlukan!");
                }

                if(Auser.getText().toString().length()==0){
                    //jika alamat belum di isi / masih kosong
                    Auser.setError("Alamat diperlukan!");
                }

                if(Euser.getText().toString().length()==0){
                    //jika email belum di isi / masih kosong
                    Euser.setError("Email diperlukan!");
                }

                if(Puser.getText().toString().length()==0){
                    //jika Passwrod belum di isi / masih kosong
                    Puser.setError("Password diperlukan!");
                }else if(Puser.getText().toString().length()!=6){
                    Puser.setError("Panjang Password kurang dari 6 huruf");
                }

                if(REuser.getText().toString().length()==0 || REuser.equals(Puser)){
                    //jika ulang Passwrod belum di isi / masih kosong
                    REuser.setError("Ulangi Password diperlukan!");

                }

                if(Nuser.length() != 0 && Auser.length() != 0 && Euser.length() != 0 && Puser.length() !=0 && Puser.length() == 6 && Puser.getText() == REuser.getText()){
                    Toast.makeText(getApplicationContext(), "Registrasi Berhasil!",
                            Toast.LENGTH_SHORT).show();
                    //ke layout Main activity
                    Intent i =  new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }

            }
        });


    }
}