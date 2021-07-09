package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {



    // Declare widgets
    android.widget.Button recalculatebmibutton;

    TextView mbmidisplay,mbmicategory,mgender;
    Intent intent;
    ImageView moutputimage;
    String bmi;
    float floatbmi;

    // Intialize variable for bmi calculation

    String height;
    String weight;
    float floatheightcm,floatweight ,floatheightm;
    RelativeLayout mbackground;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);

        // Set background and title for action bar
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font color"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);


        // Intialize widgets
        mbmidisplay = findViewById(R.id.bmidisplay);
        mbmicategory = findViewById(R.id.bmicategory);
        mgender = findViewById(R.id.genderdisplay);
        mbackground = findViewById(R.id.contentlayout);
        moutputimage = findViewById(R.id.bmioutputimage);




        // Get data filled in MainActivity
        intent = getIntent();


        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        // Convert values to floats for bmi calculation
        floatheightcm = Float.parseFloat(height);
        floatweight = Float.parseFloat(weight);

        // Convert the cm into m
        floatheightm = floatheightcm/100;

        // Calculation for BMI
        floatbmi = floatweight/(floatheightm* floatheightm);

        bmi = String.format("%.02f", floatbmi);

        if(floatbmi < 16) {
            mbmicategory.setText("Severe Thinness");
            mbackground.setBackgroundColor(Color.RED);
            moutputimage.setImageResource(R.drawable.crosss);
        } else if (floatbmi >= 16 && floatbmi < 17 ) {
            mbmicategory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(getResources().getColor(R.color.orange));
            moutputimage.setImageResource(R.drawable.warning);
        } else if (floatbmi >= 17 && floatbmi < 18.5) {
            mbmicategory.setText("Mild Thinness");
            mbackground.setBackgroundColor(Color.YELLOW);
            moutputimage.setImageResource(R.drawable.warning);
        } else if (floatbmi >= 18.50 && floatbmi < 25) {
            mbmicategory.setText("Normal");
            mbackground.setBackgroundColor(Color.GREEN);
            moutputimage.setImageResource(R.drawable.ok);
        } else if (floatbmi >= 25 && floatbmi < 30) {
            mbmicategory.setText("Pre-obese");
            mbackground.setBackgroundColor(Color.YELLOW);
            moutputimage.setImageResource(R.drawable.warning);
        } else if (floatbmi >= 30 && floatbmi < 35) {
            mbmicategory.setText("Obese Class I");
            mbackground.setBackgroundColor(getResources().getColor(R.color.orange));
            moutputimage.setImageResource(R.drawable.crosss);
        } else if (floatbmi >= 35 && floatbmi < 40) {
            mbmicategory.setText("Obese Class II");
            mbackground.setBackgroundColor(Color.RED);
            moutputimage.setImageResource(R.drawable.crosss);
        } else if (floatbmi >= 40) {
            mbmicategory.setText("Obese Class III");
            mbackground.setBackgroundColor(Color.RED);
            moutputimage.setImageResource(R.drawable.crosss);
        }

        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(bmi);



        recalculatebmibutton = findViewById(R.id.recalculatebmi);

        recalculatebmibutton.setOnClickListener(v -> {
            Intent intent = new Intent(BMIActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

    }
}