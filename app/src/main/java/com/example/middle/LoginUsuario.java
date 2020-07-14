package com.example.middle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginUsuario extends AppCompatActivity {
    TextView registroUsuario;
    TextView loginProveedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_usuario);
        registroUsuario = (TextView) findViewById(R.id.textview_registroUsuario);
        registroUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginUsuario.this, RegisterUsuario.class);
                startActivity(intent);
            }
        });
        loginProveedor = (TextView) findViewById(R.id.textView_loginProveedor);
        loginProveedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginUsuario.this, LoginProveedor.class);
                startActivity(intent);
            }
        });
    }
}