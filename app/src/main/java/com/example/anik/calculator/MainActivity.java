package com.example.anik.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView=(TextView) findViewById(R.id.textView1);
        final EditText weightInput=(EditText) findViewById(R.id.weightInput);
        final EditText heightInput=(EditText) findViewById(R.id.heightInput);
        final Button button=(Button) findViewById(R.id.submit);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(weightInput.getText().length()!=0 && heightInput.getText().length()!=0){
                    int weightCount=Integer.parseInt(weightInput.getText().toString());
                    float heightCount=Float.parseFloat(heightInput.getText().toString());
                    float bmiCount=weightCount/(heightCount*heightCount);

                    String bmi="Your BMI is:\n"+String.valueOf(bmiCount);
//                textView.setPadding(10,10,10,10);
//                textView.setBackgroundColor(android.graphics.Color.rgb(0,168,255));
                    if (bmiCount<=18.5){
                        bmi+="\nUnderweight" ;
                        textView.setPadding(10,10,10,10);
                        textView.setTextColor(android.graphics.Color.rgb(255,255,255));
                        textView.setBackgroundColor(android.graphics.Color.rgb(255,77,77));
                    }
                    else {
                        if (bmiCount>=25 && bmiCount<=29.9){
                            bmi+="\nOverweight";
                            textView.setPadding(10,10,10,10);
                            textView.setTextColor(android.graphics.Color.rgb(255,255,255));
                            textView.setBackgroundColor(android.graphics.Color.rgb(255,153,128));
                        }
                        else {
                            if (bmiCount>=30){
                                bmi+="\nObesity";
                                textView.setPadding(10,10,10,10);
                                textView.setBackgroundColor(android.graphics.Color.rgb(255,77,77));
                                textView.setTextColor(android.graphics.Color.rgb(255,255,255));
                            }
                            else {
                                bmi+="\nNormal";
                                textView.setPadding(10,10,10,10);
                                textView.setBackgroundColor(android.graphics.Color.rgb(51,204,51));
                                textView.setTextColor(android.graphics.Color.rgb(255,255,255));
                            }

                        }
                    }

                    textView.setText(bmi);
                }
                else {
                    textView.setPadding(10,10,10,10);
                    textView.setBackgroundColor(android.graphics.Color.rgb(247,255,137));
                    textView.setTextColor(android.graphics.Color.rgb(96,96,96));
                    textView.setText("Please Enter Height & Weight");
                }
            }
        });



    }

     String bmiof(Integer weight, Float height){
        Float bmi=weight/height;
        return Float.toString(bmi);
    }
}
