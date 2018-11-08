package com.dsman.uaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPassword;
    private TextInputLayout mTilEmail, mTilPass;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmail = findViewById(R.id.etEmail);
        mPassword = findViewById(R.id.etPass);
        mTilEmail = findViewById(R.id.tilEmail);
        mTilPass = findViewById(R.id.tilPass);
        checkButon();

    }


    public void login() {
        login = findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkLogin();


            }
        });

    }

    public void checkButon() {

        mEmail.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // TODO Auto-generated method stub

                if (mEmail.getText().toString().isEmpty() && mPassword.getText().toString().isEmpty()) {
                    login.setEnabled(false);
                } else {
                    login.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });
        mPassword.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // TODO Auto-generated method stub

                if (mPassword.getText().toString().isEmpty() && mEmail.getText().toString().isEmpty()) {
                    login.setEnabled(false);
                } else {
                    login.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });
        login();
    }

    public void checkLogin() {
        //login ok
        /*
        Intent navigate = new Intent(MainActivity.this, FormDataActivity.class);
        String sEmail = mEmail.getText().toString();
        navigate.putExtra("username", sEmail);
            */

        if (checkEmail() && checkPass()) {

           // startActivity(navigate);
        }

        if (checkEmail() && !checkPass()) {
            //mTilEmail.setHelperText("Email OK");
            mTilEmail.setHelperText(" ");
            mTilPass.setError("Introduzca una contraseña mayor a 6");
        }else{
            //mTilPass.setHelperText("Password OK");
            mTilPass.setHelperText(" ");
        }


        //email incorrecto y pass iconrrecta
        int user = mEmail.getText().toString().trim().length();
        int pass = mPassword.getText().toString().trim().length();
        if (!checkEmail() || !checkPass() || user == 0) {

            if (!checkEmail()) {
                mTilEmail.setError("Email NO Válido");
            }

            if (user == 0) {
                mTilEmail.setError("Introduzca un Email");
            }

            if (pass == 0) {
                mTilPass.setError("Introduzca una contraseña");
            } else if (pass < 6 && pass > 0) {
                mTilPass.setError("Introduzca una contraseña mayor a 6");

            }


        }
    }

    private boolean checkPass() {
        int pass = mPassword.getText().toString().trim().length();
        if (pass >= 6 ) {
            return true;
        }
        return false;
    }


    private boolean checkEmail() {
        String emailAddress = mEmail.getText().toString().trim();
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
            return true;
        } else {

            return false;
        }
    }


}