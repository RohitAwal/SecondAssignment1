package com.secondassignment1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btncal;
    EditText et1,et2,et3;
    double H,W,Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        btncal= findViewById(R.id.btncal);
        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                H = Integer.parseInt(et1.getText().toString());
                W = Integer.parseInt(et2.getText().toString());

                RohitBMI bmi = new RohitBMI(H,W);

                Result = bmi.calculate();
                et3.setText(Double.toString(Result));

                if (Result<18.5){
                    Toast.makeText(MainActivity.this,"BMI Categories is UnderWeight", Toast.LENGTH_SHORT).show();
                }
                else if (Result>18.5 && Result<24.9){
                    Toast.makeText(MainActivity.this, "BMI Categories is Normal Weight", Toast.LENGTH_SHORT).show();
                }
                else if (Result>25 && Result<29.9){
                    Toast.makeText(MainActivity.this,"BMI Categories is Over weight", Toast.LENGTH_SHORT).show();
                }
                else if (Result>30){
                    Toast.makeText(MainActivity.this,"BMI Categories isObesity", Toast.LENGTH_SHORT).show();
                }

                InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(btncal.getWindowToken(),InputMethodManager.RESULT_UNCHANGED_SHOWN);
            }
        });


    }
}
