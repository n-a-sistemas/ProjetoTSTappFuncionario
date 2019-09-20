package com.example.tstfuncionario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;


import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private EditText editTextUsuario;
    private EditText editTextSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUsuario = findViewById(R.id.edit_text_usuario);
        editTextSenha = findViewById(R.id.edit_text_senha);

        conectaBanco();
    }

    private void conectaBanco(){
        FirebaseApp.initializeApp(MainActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void salvarDado(View view){
        String uuid = UUID.randomUUID().toString();
        databaseReference
                .child("projetotst")
                .child(uuid)
                .child("usuario")
                .setValue(editTextUsuario.getText().toString());

        databaseReference
                .child("projetotst")
                .child(uuid)
                .child("senha")
                .setValue(editTextSenha.getText().toString());

    }
}
