package com.example.emblockapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button sub;
    EditText name;
    EditText age;
    EditText height;
    EditText weight;
    RadioGroup radioG;
    RadioButton radioButton;
    TextView st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        st = findViewById(R.id.status);
        sub = findViewById(R.id.submit);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        radioG = (RadioGroup) findViewById(R.id.radio);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=0;
                float w =0.0f;
                float h = 0.0f;
                String g = "";
                try{
                    g = String.valueOf(name.getText());
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Enter Name", Toast.LENGTH_SHORT).show();
                }
                try{
                    a = Integer.parseInt(String.valueOf(age.getText()));
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Enter Age", Toast.LENGTH_SHORT).show();
                }
                try{
                    int selectedId = radioG.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedId);
                    g = String.valueOf(radioButton.getText());
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Enter Gender", Toast.LENGTH_SHORT).show();
                }
                try{
                    w = Float.parseFloat(String.valueOf(weight.getText()));
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Enter Weight", Toast.LENGTH_SHORT).show();
                }
                try{
                    h = Float.parseFloat(String.valueOf(height.getText()));
                    h = h / 100;
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Enter Height", Toast.LENGTH_SHORT).show();
                }
                float bmi = w / (h * h);
                char gender = g.equals("Male")?'M':'F';
                String status = "";
                if (gender == 'M') {
                    if (bmi < 18.5) {
                        status =  "Underweight";
                    } else if (bmi < 24.9) {
                        status =  "Normal weight";
                    } else if (bmi < 29.9) {
                        status =  "Overweight";
                    } else {
                        status =  "Obese";
                    }
                } else if (gender == 'F') {
                    if (bmi < 18.5) {
                        status =  "Underweight";
                    } else if (bmi < 23.9) {
                        status =  "Normal weight";
                    } else if (bmi < 28.9) {
                        status =  "Overweight";
                    } else {
                        status =  "Obese";
                    }
                }
                st.setText(status);
            }
        });
    }
}