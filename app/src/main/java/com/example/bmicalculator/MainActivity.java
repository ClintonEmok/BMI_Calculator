package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button mcalculatebmi;

    TextView mcurrentheight;
    EditText mcurrentweight, mcurrentage;
    ImageView mincrementage, mdecrementage, mincrementweight, mdecrementweight;
    SeekBar mseekbarheight;
    RelativeLayout mmale, mfemale;

    int intweight = 55;
    int intage = 19;
    int currentprogress;
    String mprogress = "170";
    String typeofuser="0";
    String weight2 = "55";
    String age2 ="22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        mcalculatebmi = findViewById(R.id.calculatebmi);
        mcurrentage = findViewById(R.id.currentage);
        mcurrentheight = findViewById(R.id.currentheight);
        mcurrentweight = findViewById(R.id.currentweight);
        mincrementage = findViewById(R.id.incrementage);
        mdecrementage = findViewById(R.id.decrementage);
        mincrementweight = findViewById(R.id.incrementweight);
        mdecrementweight = findViewById(R.id.decrementweight);
        mseekbarheight = findViewById(R.id.seekbarforheight);
        mmale = findViewById(R.id.male);
        mfemale = findViewById(R.id.female);




        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.genderselectorfocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.genderselectornotfocus));
                typeofuser="Male";
            }
        });

        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.genderselectorfocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.genderselectornotfocus));
                typeofuser="Female";
            }
        });





        mseekbarheight.setMax(300);
        mseekbarheight.setProgress(170);
        mseekbarheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress = progress;
                mprogress = String.valueOf(currentprogress);
                mcurrentheight.setText(mprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mincrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = Integer.parseInt(mcurrentage.getText().toString());
                intage =intage+1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });

        mincrementage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                intage=intage+5;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);
                return true;
            }
        });



        mincrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = Integer.parseInt(mcurrentweight.getText().toString());
                intweight =intweight+1;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });

        mincrementweight.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                intweight=intweight+5;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);
                return true;
            }
        });



        mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = Integer.parseInt(mcurrentage.getText().toString());
                intage =intage-1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });

        mdecrementage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                intage=intage-5;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);
                return true;
            }
        });

        mdecrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = Integer.parseInt(mcurrentweight.getText().toString());
                intweight =intweight-1;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });

        mdecrementweight.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                intweight=intweight-5;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);
                return true;
            }
        });






        mcalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight2 = mcurrentweight.getText().toString();
                age2 = (mcurrentage.getText().toString());

                if(typeofuser.equals("0")){
                    Toast.makeText(getApplicationContext(),"Select your Gender", Toast.LENGTH_SHORT).show();
                }
                else if (mprogress.equals("0"))
                {
                    Toast.makeText(getApplicationContext(),"Select your Height", Toast.LENGTH_SHORT).show();
                } else if (intage <= 0) {
                    Toast.makeText(getApplicationContext(),"Select a Valid Age", Toast.LENGTH_SHORT).show();
                } else if (intweight <= 0 ){
                    Toast.makeText(getApplicationContext(),"Select a Valid Weight", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, BMIActivity.class);
                    intent.putExtra("gender", typeofuser);
                    intent.putExtra("height", mprogress);
                    intent.putExtra("weight", weight2);
                    intent.putExtra("age", age2);

                    startActivity(intent);
                }


            }
        });

    }
}