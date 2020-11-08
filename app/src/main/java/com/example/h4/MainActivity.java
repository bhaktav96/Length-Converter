package com.example.h4;

import android.os.Bundle;
import android.app.Activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.TextView;
import android.view.Gravity;


public class MainActivity extends Activity {

    int pos = 0;


    //Method used for Toast to set gravity and display
    void showToast(CharSequence msg) {
        Toast tos=Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        tos.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 300);
        tos.show();

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin = (Spinner)findViewById(R.id.unit_spinner);//spinner for selecting values in to operation
        Button btnConvert = (Button)findViewById(R.id.btnConvert);
        Button reset = (Button)findViewById(R.id.reset);
        final EditText txtEntry = (EditText)findViewById(R.id.txtEntry); //Edittext for entering miles

        //ArrayAdapter from CharSequence
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(
                this, R.array.unit_arrays, android.R.layout.simple_spinner_item);
        //set the view for drop down list
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //set ArrayAdapter to spinner
        spin.setAdapter(adapter);
        //attach listerner to spinner
        spin.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(
                    AdapterView<?> parent, View view, int position, long id) {
                //showToast("Spinner: position=" + position + " id=" + id);
                pos = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // Do Nothing...

            }
        });

        btnConvert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                TextView textView=(TextView)findViewById(R.id.textview);

                if (txtEntry.getText().toString().trim().length() > 0){
                    //Converting to double from string
                    double value = Double.valueOf(txtEntry.getText().toString());

                    double km, m, cm,mt,in,f,y;

                    if(pos==0){
                        km = value * 1.609344;
                        //Concatinating the string
                        String a=Double.toString(value)+" Miles ="+ Double.toString(km)+" Kilometer(s)";
                        textView.setText(a);
                        showToast(value + " Miles = " +  km + " Kilometer(s)");// Toast Message Display
                    }else if(pos==1){

                        m = value * 1609344;

                        String a=Double.toString(value)+" Miles ="+ Double.toString(m)+" Millimeter(m)";
                        textView.setText(a);
                        showToast(value + " Miles = " +  m + " Millimeter(s)");
                    }else if(pos==2){
                        cm = value * 160934.4;

                        String a=Double.toString(value)+" Miles ="+ Double.toString(cm)+" Centimeter(s)";
                        textView.setText(a);
                        showToast(value + " Miles = " +  cm + " Centimeter(s)");
                    }
                    else if(pos==3){
                        mt = value * 1609.344;

                        String a=Double.toString(value)+" Miles ="+ Double.toString(mt)+" Meter(s)";
                        textView.setText(a);
                        showToast(value + " Miles = " +  mt + " Meter(s)");
                    } else if(pos==4){
                        in = value * 63360;

                        String a=Double.toString(value)+" Miles ="+ Double.toString(in)+" Inche(s)";
                        textView.setText(a);
                        showToast(value + "Miles = " +  in + " Inche(s)");
                    }
                    else if(pos==5){
                        f = value * 5280;

                        String a=Double.toString(value)+" Miles ="+ Double.toString(f)+" Feet(s)";
                        textView.setText(a);
                        showToast(value + " Miles = " +  f + " Feet(s)");
                    }
                    else{
                        y = value * 1760;

                        String a=Double.toString(value) + " Miles ="+ Double.toString(y)+" Yards";
                        textView.setText(a);
                        showToast(value + " Miles = " +  y + " Yard(s)");
                    }
                }
                else{
                    showToast("Please Enter Value");
                    textView.setText("Please Enter Value");

                }

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView textView=(TextView)findViewById(R.id.textview);
                txtEntry.setText("");
                textView.setText("Result");//Resetting the Text on reset button.
            }
        });
    }



}