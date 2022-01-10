package com.example.iotproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Accelerometer accelerometer;
    private Gyroscope gyroscope;
    Button button1,button2,button3,button4,button5,button6,button7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accelerometer=new Accelerometer(this);
        gyroscope=new Gyroscope(this);
        accelerometer.setListener(new Accelerometer.Listener() {
            @Override
            public void onTranslation(float tx, float ty, float tz) {
                if (tx > 1.0f)
                {
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                }
                else if(tx < -1.0f) {
                getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                }

            }
        });
        gyroscope.setListener(new Gyroscope.Listener() {
            @Override
            public void onRotation(float rx, float ry, float rz) {
                if (rz > 1.0f)
                {
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                }
                else if(rz < -1.0f) {
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                }
            }
        });
        button1=(Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                openScreen1();
            }
        });
        button2=(Button) findViewById(R.id.button2);
        button2.setBackgroundColor(Color.GRAY);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                openScreen2();
            }
        });
        button3=(Button) findViewById(R.id.button3);
        button3.setBackgroundColor(Color.GRAY);

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                openScreen3();
            }
        });
        button4=(Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                openScreen4();
            }
        });
        button5=(Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                openScreen5();
            }
        });
        button6=(Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                openScreen6();
            }
        });
        button7=(Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                openScreen7();
            }
        });
        button1.setBackgroundColor(Color.BLUE);
        button7.setBackgroundColor(Color.GRAY);
        button4.setBackgroundColor(Color.GRAY);
        button5.setBackgroundColor(Color.GRAY);
        button6.setBackgroundColor(Color.GRAY);

    }
    //allSensors
    public void openScreen1(){
        Intent intent=new Intent(this , MainActivity2.class);
        startActivity(intent);
    }
    //AccelerometerSensor
    public void openScreen2(){
        Intent intent=new Intent(this , MainActivity4.class);
        startActivity(intent);
    }
    //GyroscopeSensor
    public void openScreen3(){
        Intent intent=new Intent(this , MainActivity5.class);
        startActivity(intent);
    }
    //LightSensor
    public void openScreen4(){
        Intent intent=new Intent(this , MainActivityLum6.class);
        startActivity(intent);
    }
    //proximitySensor
    public void openScreen5(){
        Intent intent=new Intent(this , MainActivityProx6.class);
        startActivity(intent);
    }
    //TemperatureSensor
    public void openScreen6(){
        Intent intent=new Intent(this , MainActivityTem6.class);
        startActivity(intent);
    }//HumiditySensor
    public void openScreen7(){
        Intent intent=new Intent(this , MainActivityHum6.class);
        startActivity(intent);
    }
    @Override
    protected void onResume() {
        super.onResume();
        accelerometer.register();
        gyroscope.register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        accelerometer.unregister();
        gyroscope.unregister();
    }
}