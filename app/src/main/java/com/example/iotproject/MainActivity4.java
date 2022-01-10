package com.example.iotproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity implements SensorEventListener {
    private static final String TAG ="Accelerometer";

    private SensorManager sensorManager;
    private Sensor accelerometer;
    TextView xValue, yValue, zValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
         xValue= (TextView) findViewById(R.id.tx1);
         yValue= (TextView) findViewById(R.id.tx2);
         zValue= (TextView) findViewById(R.id.tx3);
        Log.d(TAG,"OnCreate:Initializing Sensor services");
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
     if(accelerometer!=null){
        sensorManager.registerListener(MainActivity4.this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
         Log.d(TAG,"OnCreate: Registered accelerometer Listener");
     }
     else {
      xValue.setText("Accelerometer not supported");
      yValue.setText("Accelerometer not supported");
      zValue.setText("Accelerometer not supported");

     }

     }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
     Log.d(TAG, "OnSensorChanged:x"+sensorEvent.values[0]+"y:"+sensorEvent.values[1]+"z:"+sensorEvent.values[2]);
     xValue.setText("xValues"+sensorEvent.values[0]);
     yValue.setText("yValues"+sensorEvent.values[1]);
     zValue.setText("zValues"+sensorEvent.values[2]);


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}