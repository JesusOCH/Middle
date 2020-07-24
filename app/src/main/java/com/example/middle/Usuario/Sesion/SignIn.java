package com.example.middle.Usuario.Sesion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.middle.Proveedor.Sesion.SignIn_Proveedor;
import com.example.middle.R;
import com.example.middle.Usuario.UsuarioActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {

    private EditText emailUsuario;
    private EditText passwordUsuario;
    private Button ingresarUsuario;

    private String email = "";
    private String password = "";

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        firebaseAuth = FirebaseAuth.getInstance();

        emailUsuario = (EditText) findViewById(R.id.emailUsuario_Ingreso);
        passwordUsuario = (EditText) findViewById(R.id.passwordUsuario_Ingreso);
        ingresarUsuario = (Button) findViewById(R.id.buttonIngresarUsuario);

        ingresarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailUsuario.getText().toString();
                password = passwordUsuario.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()) {
                    loginUsuario();
                } else {
                    Toast.makeText(SignIn.this, "Complete los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.textCrearCuenta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUp.class));

            }
        });
        findViewById(R.id.textLoginProveedor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignIn_Proveedor.class));
            }
        });
        findViewById(R.id.resetPasswordUsuario).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ResetPassword.class));
            }
        });
    }

    private void loginUsuario() {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(getApplicationContext(), UsuarioActivity.class));
                    finish();
                } else {
                    Toast.makeText(SignIn.this, "No se pudo iniciar sesion", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), UsuarioActivity.class));
            finish();
        }
    }
}