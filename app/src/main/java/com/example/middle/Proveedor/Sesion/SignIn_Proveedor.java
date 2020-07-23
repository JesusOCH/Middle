package com.example.middle.Proveedor.Sesion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.middle.Proveedor.ProveedorActivity;
import com.example.middle.R;
import com.example.middle.Usuario.Sesion.SignIn;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn_Proveedor extends AppCompatActivity {

    private EditText emailProveedor;
    private EditText passwordProveedor;
    private Button ingresarProveedor;

    private String email = "";
    private String password = "";

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in__proveedor);

        firebaseAuth = FirebaseAuth.getInstance();

        emailProveedor = (EditText) findViewById(R.id.emailProveedor_Ingreso);
        passwordProveedor = (EditText) findViewById(R.id.passwordProveedor_Ingreso);
        ingresarProveedor = (Button) findViewById(R.id.buttonIngresarProveedor);

        ingresarProveedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailProveedor.getText().toString();
                password = passwordProveedor.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()) {
                    loginUsuario();
                } else {
                    Toast.makeText(SignIn_Proveedor.this, "Complete los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

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

    }

    private void loginUsuario() {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(getApplicationContext(), ProveedorActivity.class));
                    finish();
                } else {
                    Toast.makeText(SignIn_Proveedor.this, "No se pudo iniciar sesion", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), ProveedorActivity.class));
            finish();
        }
    }


}