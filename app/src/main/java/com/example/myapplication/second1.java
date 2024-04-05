package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class second1 extends AppCompatActivity {
    String location;
    String nme;
    String type;
    String fatt;
    String satt;

    Button buttonOrder;
    CheckBox idlichetney,dosesaagu, baaji,poori,ricesamber,pongal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second1);
        addListenerOnButtonClick();
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
             location = extras.getString("Location");
             nme = extras.getString("Name");
             type = extras.getString("Type");
             fatt = extras.getString("Attendies lower");
             satt = extras.getString("Attendies upper");

        }
    }
    public void addListenerOnButtonClick(){
        //Getting instance of CheckBoxes and Button from the activty_main.xml file
        idlichetney=(CheckBox)findViewById(R.id.checkBox);
        dosesaagu=(CheckBox)findViewById(R.id.checkBox2);
        baaji=(CheckBox)findViewById(R.id.checkBox3);

        poori=(CheckBox)findViewById(R.id.checkBox4);
        ricesamber=(CheckBox)findViewById(R.id.checkBox6);
        pongal =(CheckBox)findViewById(R.id.checkBox7);
        buttonOrder=(Button)findViewById(R.id.button);

        //Applying the Listener on the Button click
        buttonOrder.setOnClickListener(new View.OnClickListener(){
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            Map<String, Object> Items = new HashMap<>();


//                    city.put("Attendies", "India");
//                    db.collection("Orders").add(city);
            @Override
            public void onClick(View view) {
                int totalamount=0;

                StringBuilder result=new StringBuilder();
                result.append("Selected Items:");
                Items.put("Name" , nme);
                Items.put("Location" , location);
                Items.put("Type" , type);
                Items.put("Attendies lower" , fatt);
                Items.put("Attendies upper"  ,satt);

                EditText phno = (EditText)findViewById(R.id.phoneno);
                String nos = phno.getText().toString();

                Items.put("num"  ,nos);

                if(idlichetney.isChecked()){
                    Items.put("Idlichetney" , "yes");

                }
                if(dosesaagu.isChecked()){
                    Items.put("Dosesaagu" , "yes");

                }
                if(baaji.isChecked()){
                    Items.put("Baaji" , "yes");

                }

                if(poori.isChecked()){
                    Items.put("Poori" , "yes");

                }
                if(ricesamber.isChecked()){
                    Items.put("Ricesamber" , "yes");

                }
                if(pongal.isChecked()){
                    Items.put("Pongal" , "yes");

                }


                db.collection("Orders").add(Items);
                //Displaying the message on the toast
                Toast.makeText(getApplicationContext(), "Retailer will call you back", Toast.LENGTH_LONG).show();
                finish();
            }

        });
    }
}
