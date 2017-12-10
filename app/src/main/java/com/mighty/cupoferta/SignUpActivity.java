package com.mighty.cupoferta;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.mighty.cupoferta.model.Usuario;
import com.mighty.cupoferta.remote.APIService;
import com.mighty.cupoferta.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    private CheckBox acepto;
    private EditText nombreset, apellidoset, emailet, dniet, passwordet;
    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle(R.string.registrate);

        CheckBox acepto = (CheckBox) findViewById(R.id.chbAcepto);
        nombreset = (EditText) findViewById(R.id.input_nombre);
        apellidoset = (EditText) findViewById(R.id.input_apellido);
        emailet = (EditText) findViewById(R.id.input_email);
        dniet = (EditText) findViewById(R.id.input_dni);
        passwordet = (EditText) findViewById(R.id.input_contrasenia);

        mAPIService = ApiUtils.getAPIService();
        Button createUserButton = (Button) findViewById(R.id.btnRegistrate);

        createUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombres = nombreset.getText().toString().trim();
                String apellidos = apellidoset.getText().toString().trim();
                String dni = dniet.getText().toString().trim();
                String email = emailet.getText().toString().trim();
                String password = passwordet.getText().toString().trim();
                if (!TextUtils.isEmpty(nombres) && !TextUtils.isEmpty(apellidos) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(dni) && !TextUtils.isEmpty(password)) {
                    sendUser(nombres, apellidos, email, dni, password);
                    limpiarCasillas();
                    Snackbar.make(v, "Usuario Registrado", Snackbar.LENGTH_LONG)
                            .setAction("Iniciar Sesión", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(SignUpActivity.this, NavigationActivity.class);
                                    startActivity(intent);
                                }
                            })
                            .show();
                }
            }

        });
    }

    private void limpiarCasillas() {
        nombreset.setText("");
        apellidoset.setText("");
        emailet.setText("");
        dniet.setText("");
        passwordet.setText("");
    }

    private void sendUser(String nombres, String apellidos, String email, String dni, String password) {
        mAPIService.saveUser(nombres, apellidos, email, dni, password).enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful()) {
                    Log.i("Error", "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e("Error", "Unable to submit post to API.");
            }
        });
    }

}
