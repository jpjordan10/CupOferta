package com.mighty.cupoferta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle(R.string.registrate);

        final EditText nombres = (EditText) findViewById(R.id.input_nombre);
        final EditText apellidos = (EditText) findViewById(R.id.input_apellido);
        final EditText dni = (EditText) findViewById(R.id.input_dni);
        final EditText email = (EditText) findViewById(R.id.input_email);
        final EditText password = (EditText) findViewById(R.id.input_contrasenia);

        Button createUserButton = (Button) findViewById(R.id.btnRegistrate);
        createUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        });
    }
}
/*
* User user = new User(
                    nombres.getText().toString(),
                    apellidos.getText().toString(),
                    Integer.parseInt(dni.getText().toString()),
                    email.getText().toString(),
                    password.getText().toString()
            );
            sendNetworkRequest(user);
*
* */
