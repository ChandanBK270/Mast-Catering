package com.example.myapplication;

//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.myapplication.R;
//import com.google.android.material.button.MaterialButton;
//import com.google.firebase.FirebaseApp;
//
//public class MainActivity extends AppCompatActivity{
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//
//
//}















/*package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.FirebaseApp;


public class MainActivity extends AppCompatActivity {

    private MaterialButton existingacc;
    private MaterialButton move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        move=findViewById(R.id.existingacc);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.super.onCreate();
                FirebaseApp.initializeApp(this);
                FirebaseDatabase.getInstance().setPersistenceEnabled(true);
                Intent intent=new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        TextView ENTERMAILID = (TextView) findViewById(R.id.MailId);{
                String usermailid = ENTERMAILID.getText().toString();
                Toast.makeText(MainActivity.this, "User Mail Id"+usermailid, Toast.LENGTH_SHORT);
                move=findViewById(R.id.regbutton);
                move.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //FirebaseFirestore db = FirebaseFirestore.getInstance();
                        //Map<String, Object> city = new HashMap<>();
                        //city.put("name", "Bangalore");
                        //city.put("state", "Karnataka");
                        //city.put("country", "India");

                        //db.collection("cities").add(city);
                      /*FirebaseAuth mAuth = FirebaseAuth.getInstance();
                        PhoneAuthOptions options =
                                PhoneAuthOptions.newBuilder(mAuth)
                                        .setPhoneNumber("+91 9980643739")       // Phone number to verify
                                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                        //.setActivity(this)                 // (optional) Activity for callback binding
                                        // If no activity is passed, reCAPTCHA verification can not be used.
                                        //.setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                                        .build();
                        PhoneAuthProvider.verifyPhoneNumber(options);


                        Intent intent=new Intent(MinActivity.this,first1.class);a
                        startActivity(intent);*/
                    /*}
                });

            }


    }
}*/
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.auth.User;

public class MainActivity extends AppCompatActivity {
    private EditText phoneNumberEditText;
    private EditText passwordEditText;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        // Initialize EditText fields
        phoneNumberEditText = findViewById(R.id.EntEmail);
        passwordEditText = findViewById(R.id.EntPas);

        // Sign up button click listener
        MaterialButton signupButton = findViewById(R.id.regbutton);
        signupButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText emailtextedit = (EditText)findViewById(R.id.EntEmail);
                EditText password1textedit = (EditText)findViewById(R.id.EntPas);
                EditText password2textedit = (EditText)findViewById(R.id.ConfirmPas);

                String email = emailtextedit.getText().toString();
                String pass1 = password1textedit.getText().toString();
                String pass2 = password2textedit.getText().toString();

                if(! email.isEmpty() && ! pass1.isEmpty() && ! pass2.isEmpty()){
                    if(pass1.equals(pass2)){
                        FirebaseAuth logpg = FirebaseAuth.getInstance();

                        logpg.createUserWithEmailAndPassword(email, pass1).addOnCompleteListener( new OnCompleteListener<AuthResult>(){
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                ;
                                if(task.isSuccessful()){

//                                    logpg.sendSignInLinkToEmail(email, ActionCodeSettings.newBuilder().build())
//                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                                @Override
//                                                public void onComplete(@NonNull Task<Void> task) {
//                                                    if (task.isSuccessful()) {
//                                                        Intent intent= new Intent(MainActivity.this, verifyscreen.class);
//                                                        startActivity(intent);
//                                                    }
//                                                }
//                                            });
                                    Intent intent= new Intent(MainActivity.this, verifyscreen.class);
                                    startActivity(intent);
                                                        }

                                else{
                                    Toast.makeText(MainActivity.this, "Error " + task.getException().getMessage() , Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        Intent intent=new Intent(MainActivity.this,verifyscreen.class);
                        startActivity(intent);
                    }
                      else{
                        Toast.makeText(MainActivity.this, "Mismatch password", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Please fill all field", Toast.LENGTH_SHORT).show();
                }


//                logpg.signInWithEmailAndPassword("chandanbk864@gmail.com", "12345678")
//                createAccount(phoneNumber, password);
            }
        });
        MaterialButton alreadyac = findViewById(R.id.existingacc);
        alreadyac.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MainActivity.this, loginpg.class);
                                        startActivity(intent);
//                logpg.signInWithEmailAndPassword("chandanbk864@gmail.com", "12345678").addOnCompleteListener( new OnCompleteListener<AuthResult>(){
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//                FirebaseAuth logpg = FirebaseAuth.getInstance();
////                                    progressDialog.dismiss();
//                                    if(task.isSuccessful()){
//                                        finish();
//                                        Intent intent= new Intent(MainActivity.this, loginpg.class);
//                                        startActivity(intent);                         }
//                                }
//                            });









//                logpg.signInWithEmailAndPassword("chandanbk864@gmail.com", "12345678")
//                createAccount(phoneNumber, password);
            }
        });
    }


}
