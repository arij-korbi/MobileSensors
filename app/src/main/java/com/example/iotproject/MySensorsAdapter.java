package com.example.iotproject;

import android.content.Context;
import android.hardware.Sensor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MySensorsAdapter  extends ArrayAdapter<Sensor> {
    private int textViewRessourceId;
    private static  class ViewHolder {
        private TextView itemView;

    }
    public MySensorsAdapter(Context context, int textViewRessourceId , List<Sensor> items ){
        super(context,textViewRessourceId,items);
        this.textViewRessourceId=textViewRessourceId;

    }
    public View getView (int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView == null){
            convertView= LayoutInflater.from(this.getContext()).inflate(textViewRessourceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.itemView=(TextView) convertView.findViewById(R.id.content);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder =(ViewHolder) convertView.getTag();
        }
        Sensor item= getItem(position);
        if(item != null){
            viewHolder.itemView.setText("Name : " + item.getName());
        }
        return convertView;
    }
}
