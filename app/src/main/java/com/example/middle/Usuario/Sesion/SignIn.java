package com.example.middle.Usuario.Sesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.middle.MainActivity;
import com.example.middle.R;
import com.example.middle.Proveedor.Sesion.SignIn_Proveedor;
import com.example.middle.Usuario.UsuarioActivity;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        findViewById(R.id.textCrearCuenta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUp.class));

            }
        });
        findViewById(R.id.buttonIngresarUsuario).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), UsuarioActivity.class
                ));
            }
        });
        findViewById(R.id.textLoginProveedor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignIn_Proveedor.class));
            }
        });
    }
}