package com.example.lesson7tasik3java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText userName;
    EditText password;
    Button loginButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.username_text);
        password = (EditText) findViewById(R.id.password_text);
        loginButton = (Button) findViewById(R.id.login_button);
        textView = findViewById(R.id.textView);

        userName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
               textView.setText(userName.getText().toString());
                return false;
            }
        });

        loginButton.setEnabled(false);

        TextWatcher textWatcher = new TextWatcher() {

                    public void afterTextChanged(Editable s) {
                        String userNameText = MainActivity.this.userName.getText().toString();
                        String passwordText = MainActivity.this.password.getText().toString();
                        loginButton.setEnabled(!userNameText.contentEquals("") && !passwordText.contentEquals(""));
                    }

                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                    public void onTextChanged(CharSequence s, int start, int before, int count) {}
                };
        userName.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
    }
}