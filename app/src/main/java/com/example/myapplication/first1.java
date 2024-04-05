package com.example.myapplication;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class first1 extends AppCompatActivity {
    private Button move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first1);
        Spinner spinnerLanguages=findViewById(R.id.spinner_languages);
        move=findViewById(R.id.proceed);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerLanguages.setAdapter(adapter);

        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tpye =spinnerLanguages.getSelectedItem().toString();
                EditText Nametext = (EditText)findViewById(R.id.EntName);
                String name = Nametext.getText().toString();

                EditText Urltext = (EditText)findViewById(R.id.URL);
                String url = Urltext.getText().toString();

                EditText fatt = (EditText)findViewById(R.id.range1);
                String fat = fatt.getText().toString();

                EditText satt = (EditText)findViewById(R.id.range2);
                String sat = satt.getText().toString();



                if (! name.isEmpty() && ! url.isEmpty()){
                    Intent intent= new Intent(first1.this,second1.class);
                    intent.putExtra("Location",url);
                    intent.putExtra("Name", name);
                    intent.putExtra("Attendies lower",fat);
                    intent.putExtra("Attendies upper",sat);
                    intent.putExtra("Type",tpye);
                    startActivity(intent);
//                    FirebaseFirestore db = FirebaseFirestore.getInstance();
//                    Map<String, Object> city = new HashMap<>();
//                    city.put("Name", name);
//                    city.put("URL", url);
//                    city.put("Attendies", "India");
//                    db.collection("Orders").add(city);
                    Nametext.setText("");
                    Urltext.setText("");
                    Toast.makeText(first1.this, "Your order has been placed", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(first1.this, "Please fill all field", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}