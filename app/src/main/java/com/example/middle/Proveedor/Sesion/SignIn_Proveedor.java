package com.example.middle.Proveedor.Sesion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.middle.Proveedor.ProveedorActivity;
import com.example.middle.R;
import com.example.middle.Usuario.Sesion.SignIn;

public class SignIn_Proveedor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in__proveedor);

        findViewById(R.id.textCrearCuentaProveedor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUp_Proveedor.class));
            }
        });
        findViewById(R.id.textLoginUsuario).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignIn.class));
            }
        });
        findViewById(R.id.buttonIngresarProveedor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ProveedorActivity.class));
            }
        });
    }
}