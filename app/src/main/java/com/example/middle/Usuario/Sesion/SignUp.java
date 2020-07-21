package com.example.middle.Usuario.Sesion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.middle.Proveedor.ProveedorActivity;
import com.example.middle.R;
import com.example.middle.Usuario.Model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    Usuario usuario = new Usuario();
    private EditText nombreUsuario;
    private EditText emailUsuario;
    private EditText passwordUsuario;
    private EditText direccionUsuario;
    private EditText edadUsuario;
    private RadioGroup sexoUsuario;
    private RadioButton masculino;
    private RadioButton femenino;
    private Button registrarUsuario;

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        nombreUsuario = (EditText) findViewById(R.id.nombreUsuario);
        emailUsuario = (EditText) findViewById(R.id.emailUsuario);
        passwordUsuario = (EditText) findViewById(R.id.passwordUsuario);
        direccionUsuario = (EditText) findViewById(R.id.direccionUsuario);
        edadUsuario = (EditText) findViewById(R.id.edadUsuario);
        sexoUsuario = (RadioGroup) findViewById(R.id.opciones_sexo);
        masculino = (RadioButton) findViewById(R.id.radio_masculino);
        femenino = (RadioButton) findViewById(R.id.radio_femenino);
        registrarUsuario = (Button) findViewById(R.id.crearCuentaUsuario);

        registrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.setNombre(nombreUsuario.getText().toString());
                usuario.setEmail(emailUsuario.getText().toString());
                usuario.setPassword(passwordUsuario.getText().toString());
                usuario.setDireccion(direccionUsuario.getText().toString());
                usuario.setEdad(edadUsuario.getText().toString());
                int ID = sexoUsuario.getCheckedRadioButtonId();
                if (ID == masculino.getId()) {
                    usuario.setSexo(masculino.getText().toString());
                } else if (ID == femenino.getId()) {
                    usuario.setSexo(femenino.getText().toString());
                }
                if (usuario != null) {
                    if (usuario.getPassword().length() >= 6) {
                        registrarUsuario();
                    } else {
                        Toast.makeText(SignUp.this, "La contraseña debe ser de 6 o mas caracteres", Toast.LENGTH_SHORT).show();
                        passwordUsuario.setText("");
                    }

                } else {
                    Toast.makeText(SignUp.this, "Debe completar todos los campos", Toast.LENGTH_SHORT).show();

                }

            }
        });

        findViewById(R.id.imageBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        findViewById(R.id.textCrearCuenta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void registrarUsuario() {
        firebaseAuth.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String id = firebaseAuth.getCurrentUser().getUid();
                    databaseReference.child("Usuarios").child(id).setValue(usuario).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()) {
                                startActivity(new Intent(getApplicationContext(), ProveedorActivity.class));
                                finish();
                            } else {
                                Toast.makeText(SignUp.this, "No se pudieron crear los datos de manera correcta", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                } else {
                    Toast.makeText(SignUp.this, "No se pudo registrar este usuario", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}