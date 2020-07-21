package com.example.zuoyou;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //start 创建变量
    TextView display;
    Button b_left, b_right, b_ok;
    Switch sw;
    EditText editTextNumber;
    ProgressBar progressBar;
    RadioGroup radioGroup;
    ImageView imageView;
    SeekBar seekBar;
    CheckBox checkBox_yuwen, checkBox_shuxue, checkBox_yingyu;
    RatingBar ratingBar;
    //finish 创建变量
    String yuwen="";
    String shuxue="";
    String yingyu="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //start 将变量和控件的id绑定
        display = findViewById(R.id.display);
        b_left = findViewById(R.id.b_left);
        b_right = findViewById(R.id.b_right);
        b_ok = findViewById(R.id.b_ok);
        sw = findViewById(R.id.sw);
        editTextNumber = findViewById(R.id.editTextNumber);
        progressBar = findViewById(R.id.progressBar3);
        radioGroup = findViewById(R.id.radio);
        seekBar = findViewById(R.id.seekBar);
        imageView = findViewById(R.id.imageView);
        checkBox_yuwen = findViewById(R.id.checkBox_yuwen);
        checkBox_shuxue = findViewById(R.id.checkBox_shuxue);
        checkBox_yingyu = findViewById(R.id.checkBox_yingyu);
        ratingBar = findViewById(R.id.ratingBar);
        //finish 将变量和控件的id绑定

        b_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(R.string.button1);
            }
        });
        b_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(R.string.button2);
            }
        });
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    display.setText("开");
                } else {
                    display.setText("关");
                }
            }
        });
        b_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editTextNumber.getText().toString();
                if (TextUtils.isEmpty(s)) {
                    s = "0";
                }
                progressBar.setProgress(Integer.parseInt(s));
                display.setText(s);
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton5) {
                    imageView.setImageResource(R.drawable.and);
                }
                else {
                    imageView.setImageResource(R.drawable.apple);
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                display.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        checkBox_yuwen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    yuwen="语文";
                }else {
                    yuwen="";
                }
                display.setText(yuwen+shuxue+yingyu);
            }
        });
        checkBox_shuxue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    shuxue="数学";
                }else {
                    shuxue="";
                }
                display.setText(yuwen+shuxue+yingyu);
            }
        });
        checkBox_yingyu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    yingyu="英语";
                }else{
                    yingyu="";
                }
                display.setText(yuwen+shuxue+yingyu);
            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(),String.valueOf(rating)+"星评价！",Toast.LENGTH_SHORT).show();
            }
        });
    }
}