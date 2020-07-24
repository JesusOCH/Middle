package com.example.middle.Proveedor.Sesion;

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

public class ResetPassword_Proveedor extends AppCompatActivity {
    private EditText emailResetPasswordProveedor;
    private Button buttonResetPasswordProveedor;

    private String email = "";

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password__proveedor);

        firebaseAuth = FirebaseAuth.getInstance();

        emailResetPasswordProveedor = (EditText) findViewById(R.id.emailResetPasswordProveedor);
        buttonResetPasswordProveedor = (Button) findViewById(R.id.buttonResetPasswordProveedor);

        buttonResetPasswordProveedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailResetPasswordProveedor.getText().toString();
                if (!email.isEmpty()) {
                    resetPassword();
                } else {
                    Toast.makeText(ResetPassword_Proveedor.this, "Debe Ingresar su Email", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(ResetPassword_Proveedor.this, "Se envio el correo para reestablecer su contraseña", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ResetPassword_Proveedor.this, "No se pudo enviar el correo de reestablecer contraseña", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
