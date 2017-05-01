package com.example.scastro81.teamstec.Main.subFragmentTeam;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by scastro81 on 19/04/17.
 */

public class JSONRequest extends AsyncTask<String, Void, JSONArray> {

    private JSONRequestCallback listener;

    public JSONRequest(JSONRequestCallback listener){
        this.listener = listener;
    }

    @Override
    protected JSONArray doInBackground(String... params) {

        JSONArray result = null;

        try{
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            int code = connection.getResponseCode();

            if(code == HttpURLConnection.HTTP_OK) {
                InputStream is = connection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuilder sb = new StringBuilder();
                String curr = "";

                while((curr = br.readLine())!=null){
                    Log.d("JSON", curr);
                    sb.append(curr);
                }
                result = new JSONArray(sb.toString());
            }

        }catch (Exception jex){
            jex.printStackTrace();
        }

        return result;
    }


    protected void onPostExecute(JSONArray jsonArray){
        super.onPostExecute(jsonArray);
        listener.done(jsonArray);
    }


    public interface JSONRequestCallback{
        void done (JSONArray jsonArray);
    }
}
