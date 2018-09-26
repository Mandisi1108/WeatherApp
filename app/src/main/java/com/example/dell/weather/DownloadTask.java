package com.example.dell.weather;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class DownloadTask extends AsyncTask<Void,Void,Void> {

    String data = "";
    String city = MainActivity.city.getText().toString();
    String name = "";
    String coord="";
    String description ="";
    String temp = "";
    String iconId ="";
    URL icon;
    String singledpa = "";
    String gg = "";
    String cty = "";
    String code = "";
    String wind = "";
    String presss = "";
    String hum = "";
    Date currentTime = Calendar.getInstance().getTime();
    @Override
    protected Void doInBackground(Void... voids) {



        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+ city +"&appid=c2e506d0ce81d37f542d0e2a0237e468&units=metric");
            icon = new URL("http://openweathermap.org/img/w/"+iconId+".png");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = " ";

            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONObject jsonObject = new JSONObject(data);

            cty = jsonObject.getString("name");
            temp = jsonObject.getJSONObject("main").getString("temp")+" °C";
            wind ="Wind:"+"\t\t\t\t\t\t\t"+"speed: "+ jsonObject.getJSONObject("wind").getString("speed")+"m/s ";
            code = jsonObject.getJSONObject("sys").getString("country");
            presss = "Pressure:"+"\t\t\t\t\t"+jsonObject.getJSONObject("main").getString("pressure")+"hpa" ;
            hum = "Humidity: \t\t\t\t\t\t"+jsonObject.getJSONObject("main").getString("humidity")+"%";


            ////   gg  = "Humidity: \t"+jsonObject.getJSONObject("main").getString("humidity")
////
            //ddparsd += "   \n" + coord;

            JSONArray weatherArray = jsonObject.getJSONArray("weather");
            for (int i = 0; i < weatherArray.length(); i++) {
                JSONObject jo = weatherArray.getJSONObject(i);
                description = jo.getString("description");
                iconId = jo.getString("icon");
                //icon = jo.getString("icon");
            }
            name += "  \n" +" \n"+gg;
            singledpa += " \n"+coord+"C";

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        WeatherDetails.temp.setText(temp);
        WeatherDetails.name.append(" "+cty+","+code);
        WeatherDetails.des.setText(description);
        WeatherDetails.cloud.setText("get at "+currentTime+"");
        WeatherDetails.wind.setText(wind);
        WeatherDetails.press.setText(presss);
        WeatherDetails.humidity.setText(hum);

        ;


    }

}
