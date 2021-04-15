package com.example.eksercise_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edEmail,edPassword;
    Button btnLogin;
    TextView btnDaftar;
    String nama,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin  =findViewById(R.id.btSignin);
        edEmail   =findViewById(R.id.edEmail);
        edPassword=findViewById(R.id.edPassword);
        btnDaftar = findViewById(R.id.textView);


        btnLogin.setOnClickListener(new View.OnClickListener() {

            String email = "admin@mail.com";
            String pass = "123456";

            @Override
            public void onClick(View view) {
                nama     = edEmail.getText().toString();
                password = edPassword.getText().toString();

                // untuk menampilkan toast
                if (nama.isEmpty() || password.isEmpty()){
                    Toast t = Toast.makeText(getApplicationContext()
                            ,"Email dan Password wajib diisi",Toast.LENGTH_LONG);
                    t.show();

                }
                else{
                    if (nama.equals(email) || password.equals(pass)){
                        Toast t = Toast.makeText(getApplicationContext()
                                ,"login Berhasil",Toast.LENGTH_LONG);
                        t.show();

                        Bundle b = new Bundle();

                        b.putString("a",nama.trim());

                        b.putString("b",password.trim());

                        //ke layout home activity yang berisi list
                        Intent i =  new Intent(getApplicationContext(),HomeActivity.class);

                        i.putExtras(b);

                        startActivity(i);

                    }
                    else{
                        Toast t = Toast.makeText(getApplicationContext()
                                ,"login Gagal",Toast.LENGTH_LONG);

                        t.show();
                    }
                }

            }
        });


        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ke layout pendaftaran
                Intent i =  new Intent(getApplicationContext(),PendaftaranActivity.class);
                startActivity(i);
            }
        });


    }


}