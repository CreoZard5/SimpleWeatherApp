package com.creolin.weather_application_using_api;

import static android.content.ContentValues.TAG;
import static java.lang.System.in;

import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtil
{
    private static final String BASE_URL = "https://dataservice.accuweather.com/forecasts/v1/daily/5day/305605";
    private static final String API_KEY = "VHqMYHvicM0OK4VIv9pAgpa9OaGUT0cD";
    private static final String PARAM_API_KEY = "apikey";
    private static final String METRIC = "metric";
    private static final String METRIC_PARAM = "True";

    public static URL buildURL()
    {
        Uri uri = Uri.parse(BASE_URL).buildUpon().
                appendQueryParameter(PARAM_API_KEY,API_KEY).
                appendQueryParameter(METRIC,METRIC_PARAM).build();

        URL url = null;

        try {
            url = new URL(uri.toString());

        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String GetResponsetohttpUrl(URL url) throws IOException {

        HttpURLConnection httpURLConnection = (HttpURLConnection) (url.openConnection());


        try
        {
            //input from Http Get response
            InputStream in = httpURLConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("//A");
            Boolean hasinput = scanner.hasNext();

            if (hasinput)
            {
              return scanner.next();
            }
            else
            {
                //Toast.makeText(, "", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "GetResponsetohttpUrl: " + scanner.next());
                return null;
            }

        }
        finally
        {
         httpURLConnection.disconnect();
        }

    }




}
