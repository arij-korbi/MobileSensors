package com.example.iotproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SensorManager sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors=sensorManager.getSensorList(Sensor.TYPE_ALL);
        ListView list= (ListView) findViewById(R.id.list);
        list.setAdapter(new MySensorsAdapter(this, R.layout.row_item, sensors));
    }
}