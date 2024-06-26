package com.example.bible;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextInputEditText regUsernameInput = findViewById(R.id.usernameReg);
        TextInputEditText regPassInput = findViewById(R.id.passwordReg);
        Button buttonReg = findViewById(R.id.btnRegister);
        TextView tvReg = findViewById(R.id.login);

        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);

        tvReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonReg.setOnClickListener(v ->{
            String username = regUsernameInput.getText().toString();
            String password = regPassInput.getText().toString();

            if (username.isEmpty()) {
                regUsernameInput.setError("Please fill this field");
            } else if (password.isEmpty()) {
                regPassInput.setError("Please fill this field");
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", username);
                editor.putString("password", password);
                editor.apply();

                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

                Toast.makeText(RegisterActivity.this, "Berhasil membuat akun.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}