package com.kelompok10.animedxd10;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText usernameField, passwordField;
    TextView usernameWarning, passwordWarning;
    Button loginButton;

    protected String getString(EditText textField)
    {
        return textField.getText().toString();
    }

    protected boolean checkUsername(String username, TextView usernameWarning)
    {

        if(username.isEmpty())
        {
            usernameWarning.setText("Username must be filled in!");
            return false;
        }

        int usernameLength = username.length();
        if(!(usernameLength >= 5 && usernameLength <= 10))
        {
            usernameWarning.setText("Username must be 5 - 10 characters!");
            return false;
        }

        usernameWarning.setText("");
        return true;
    }

    protected boolean checkPassword(String password, TextView passwordWarning)
    {
        if(password.isEmpty())
        {
            passwordWarning.setText("Password must be filled in!");
            return false;
        }

        passwordWarning.setText("");
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameField = findViewById(R.id.usernameField);
        usernameWarning = findViewById(R.id.usernameWarning);
        passwordField = findViewById(R.id.passwordField);
        passwordWarning = findViewById(R.id.passwordWarning);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(view -> {

            String username = getString(usernameField);
            String password = getString(passwordField);

            boolean usernameSuccess = checkUsername(username, usernameWarning);
            boolean passwordSuccess = checkPassword(password, passwordWarning);

            if(usernameSuccess && passwordSuccess)
            {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }
}

