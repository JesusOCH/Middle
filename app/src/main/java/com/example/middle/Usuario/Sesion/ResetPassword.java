package com.example.middle.Usuario.Sesion;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.middle.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {
    private EditText emailResetPasswordUsuario;
    private Button buttonResetPasswordUsuario;

    private String email = "";

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        firebaseAuth = FirebaseAuth.getInstance();

        emailResetPasswordUsuario = (EditText) findViewById(R.id.emailUsuarioResetPassword);
        buttonResetPasswordUsuario = (Button) findViewById(R.id.buttonResetPasswordUsuario);

        buttonResetPasswordUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailResetPasswordUsuario.getText().toString();
                if (!email.isEmpty()) {
                    resetPassword();
                } else {
                    Toast.makeText(ResetPassword.this, "Debe Ingresar su Email", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.imageBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void resetPassword() {
        firebaseAuth.setLanguageCode("es");
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ResetPassword.this, "Se envio el correo para reestablecer su contraseña", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ResetPassword.this, "No se pudo enviar el correo de reestablecer contraseña", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}