package com.example.middle.Proveedor.Sesion;

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

import com.example.middle.Proveedor.Model.Proveedor;
import com.example.middle.Proveedor.ProveedorActivity;
import com.example.middle.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp_Proveedor extends AppCompatActivity {

    Proveedor proveedor = new Proveedor();
    private EditText nombreProveedor;
    private EditText emailProveedor;
    private EditText passwordProveedor;
    private EditText direccionProveedor;
    private EditText rubroProveedor;
    private RadioGroup ofreceProveedor;
    private RadioButton servicio;
    private RadioButton producto;
    private Button registrarProveedor;

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__proveedor);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        nombreProveedor = (EditText) findViewById(R.id.nombreProveedor);
        emailProveedor = (EditText) findViewById(R.id.emailProveedor);
        passwordProveedor = (EditText) findViewById(R.id.passwordProveedor);
        direccionProveedor = (EditText) findViewById(R.id.direccionProveedor);
        rubroProveedor = (EditText) findViewById(R.id.rubroProveedor);
        ofreceProveedor = (RadioGroup) findViewById(R.id.opciones_ofrece);
        servicio = (RadioButton) findViewById(R.id.radio_servicio);
        producto = (RadioButton) findViewById(R.id.radio_producto);
        registrarProveedor = (Button) findViewById(R.id.crearCuentaProveedor);

        registrarProveedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proveedor.setNombre(nombreProveedor.getText().toString());
                proveedor.setEmail(emailProveedor.getText().toString());
                proveedor.setPassword(passwordProveedor.getText().toString());
                proveedor.setDireccion(direccionProveedor.getText().toString());
                proveedor.setRubro(rubroProveedor.getText().toString());
                int ID = ofreceProveedor.getCheckedRadioButtonId();
                if (ID == servicio.getId()) {
                    proveedor.setOfrece(servicio.getText().toString());
                } else if (ID == producto.getId()) {
                    proveedor.setOfrece(producto.getText().toString());
                }
                if (proveedor != null) {
                    if (proveedor.getPassword().length() >= 6) {
                        registrarUsuario();
                    } else {
                        Toast.makeText(SignUp_Proveedor.this, "La contraseña debe ser de 6 o mas caracteres", Toast.LENGTH_SHORT).show();
                        passwordProveedor.setText("");
                    }

                } else {
                    Toast.makeText(SignUp_Proveedor.this, "Debe completar todos los campos", Toast.LENGTH_SHORT).show();

                }

            }
        });

        findViewById(R.id.imageBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        findViewById(R.id.textCrearCuentaProveedor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void registrarUsuario() {
        firebaseAuth.createUserWithEmailAndPassword(proveedor.getEmail(), proveedor.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String id = firebaseAuth.getCurrentUser().getUid();
                    databaseReference.child("Proveedores").child(id).setValue(proveedor).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()) {
                                startActivity(new Intent(getApplicationContext(), ProveedorActivity.class));
                                finish();
                            } else {
                                Toast.makeText(SignUp_Proveedor.this, "No se pudieron crear los datos de manera correcta", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                } else {
                    Toast.makeText(SignUp_Proveedor.this, "No se pudo registrar este usuario", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}