package com.example.abhishalsaini.gratuity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculateTip();


    }

    public void calculateTip(){

        /*To get the total amount
         */
        final EditText editText = (EditText)findViewById(R.id.editText);

        /*To get the number of people
         */
        final EditText editText1 = (EditText)findViewById(R.id.editText2);

       /*To get the tip amount
        */
        final EditText editText2 = (EditText)findViewById(R.id.editText3);
        final TextView textView = (TextView) findViewById(R.id.textView5);

        Button resetButton = (Button)findViewById(R.id.button2);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().clear();
                editText1.getText().clear();
                editText2.getText().clear();
                textView.setText("");

            }
        });
        final Button calculate = (Button)findViewById(R.id.button);
        calculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String value1 = editText.getText().toString();
                String value2 = editText1.getText().toString();
                String value3 = editText2.getText().toString();

                if (value1.length() == 0) {
                    Toast.makeText(getBaseContext(), "Please Enter Total Amount", Toast.LENGTH_LONG).show();
                } else if (value2.length() == 0) {
                    Toast.makeText(getBaseContext(), "Please Enter number Of People", Toast.LENGTH_LONG).show();
                } else if (value3.length() == 0) {
                    Toast.makeText(getBaseContext(), "Please Select Tip %", Toast.LENGTH_LONG).show();
                } else if (!value1.equals("")) {


                    Double v1 = Double.valueOf((value1));
                    Double v2 = Double.valueOf((value2));
                    Double v3 = Double.valueOf((value3));


                    Double value = ((v1 / v2) * v3) / 100;
                    final Double eachPay = (v1 / v2) + value;

                    double roundOff = Math.round(eachPay * 100) / 100;
                    String.format("%.3f", roundOff);
                    textView.setText(String.valueOf(roundOff));
                    hideSoftKeyboard();

                }

            }
            public void hideSoftKeyboard(){
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(calculate.getWindowToken(), 0);
            }

        });


    }


}
