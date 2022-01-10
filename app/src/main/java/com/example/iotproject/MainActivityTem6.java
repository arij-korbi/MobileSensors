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

public class MainActivityTem6 extends AppCompatActivity implements SensorEventListener {

    private static final String TAG ="Temperature";
    private SensorManager sensorManager;
    private Sensor temperature;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tem6);
        t= (TextView) findViewById(R.id.t);
        Log.d(TAG,"OnCreate:Initializing Sensor services");
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        temperature=sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if(temperature!=null){
            sensorManager.registerListener(MainActivityTem6.this,temperature,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG,"OnCreate: Registered  AmbientTemperatureSensor Listener");
        }
        else {
            t.setText("AmbientTemperatureSensor not supported");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "OnSensorChanged:p"+sensorEvent.values[0]);
        t.setText("Ambient Temperature(C°): "+sensorEvent.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}