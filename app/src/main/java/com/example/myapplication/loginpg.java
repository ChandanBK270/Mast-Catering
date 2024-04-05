package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.core.Tag;

public class loginpg extends AppCompatActivity {
    private Button move;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpg);
        move=findViewById(R.id.logbutton);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth logpg = FirebaseAuth.getInstance();
                EditText emailtextedit = (EditText)findViewById(R.id.entmailid);
                EditText passwordtextedit = (EditText)findViewById(R.id.entpassword);



                String email = emailtextedit.getText().toString();
                String pass = passwordtextedit.getText().toString();
//                logpg.createUserWithEmailAndPassword("chandanbk864@gmail.com", "12345678");
                if ( ! email.isEmpty() && ! pass.isEmpty()){
                    logpg.signInWithEmailAndPassword(email, pass).addOnCompleteListener( new OnCompleteListener<AuthResult>(){
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            ;
                            if(task.isSuccessful()){
                                finish();
                                Intent intent= new Intent(loginpg.this, first1.class);
                                startActivity(intent);                         }
                            else{
                                Toast.makeText(loginpg.this, "Error " + task.getException().getMessage() , Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(loginpg.this, "Please fill all field", Toast.LENGTH_SHORT).show();
                }
            }
        });
        EditText entmailid =(EditText) findViewById(R.id. entmailid);
        EditText entpassword = (EditText) findViewById(R.id. entpassword);

        Button logbutton = (Button) findViewById(R.id. logbutton);



    }
}