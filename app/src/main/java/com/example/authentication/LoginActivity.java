package com.example.authentication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText pass11,email11;
    Button login1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email11=findViewById(R.id.email11);
        pass11=findViewById(R.id.pass11);
        login1=findViewById(R.id.login1);
        Intent intent=getIntent();
        String rmail=intent.getStringExtra("email5");
        String rpass=intent.getStringExtra("pass5");
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=email11.getText().toString();
                String password=pass11.getText().toString();

                if (rmail.equals(email) && rpass.equals(password))
                {
                    Intent intent = new Intent(LoginActivity.this,LoginSuccess.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
