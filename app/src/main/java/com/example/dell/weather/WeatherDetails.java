package com.example.dell.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WeatherDetails extends AppCompatActivity {

    public static TextView name;
    public static  TextView icon;
    public static  TextView temp;
    public static  TextView des;
    public static  TextView wind;
    public static  TextView cloud;
    public static  TextView press;
    public static  TextView humidity;
    public static TextView sunrise;
    public static TextView sunset;
    public static TextView geo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_details);

        name = (TextView)findViewById(R.id.tvName);
        icon = (TextView) findViewById(R.id.tvIcon);
        temp = (TextView) findViewById(R.id.tvDegrees);
        des = (TextView) findViewById(R.id.tvDate);
        wind = (TextView)findViewById(R.id.tvWind);
        cloud = (TextView) findViewById(R.id.tvCloud);
        press = (TextView)findViewById(R.id.tvPressure);
        humidity = (TextView)findViewById(R.id.tvHumidity);
        sunrise = (TextView)findViewById(R.id.tvSunrise);
        sunset = (TextView)findViewById(R.id.tvSunset);
        geo = (TextView)findViewById(R.id.tvGeo);
    }
}


