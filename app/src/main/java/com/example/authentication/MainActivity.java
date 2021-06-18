package com.example.authentication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText email1,pass1;
    Button signup1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email1=findViewById(R.id.email1);
        pass1=findViewById(R.id.pass1);
        signup1=findViewById(R.id.signup1);

        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email4 = email1.getText().toString();
                String pass = pass1.getText().toString();
//                if (!isValidPassword(pass)) {
//                    Toast.makeText(MainActivity.this, "Password doesn't match rules", Toast.LENGTH_SHORT).show();
//                    return;
//                }
                System.out.println(pass);
                if(pass1.getText().toString().length()<8 || !isValidPassword(pass1.getText().toString())){
                    for(int i=0;i<15;i++){
                        System.out.println("Not Valid");
                    }
                    System.out.println("Not Valid");
                    Toast.makeText(MainActivity.this, "Password doesn't match rules", Toast.LENGTH_SHORT).show();
//                   return;
                }else{
                    for(int i=0;i<15;i++){
                        System.out.println("Valid");
                    }
                    System.out.println("Valid");
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    intent.putExtra("email5", email4);
                    intent.putExtra("pass5", pass);
                    startActivity(intent);
                }


            }
        });
    }


    public Boolean isValidPassword(String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();
    }
}