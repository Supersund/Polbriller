package com.example.fugla.polbriller;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String LINK = "https://www.vinmonopolet.no/medias/sys_master/products/products/hbc/hb0/8834253127710/produkter.csv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DownloadFilesTask downloadFilesTask = new DownloadFilesTask();
        downloadFilesTask.execute();

    }

    private class DownloadFilesTask extends AsyncTask<URL, Void, List<String[]>> {
        @Override
        protected List<String[]> doInBackground(URL... urls) {
            return downloadRemoteTextFileContent();
        }
        protected void onPostExecute(List<String[]> result) {
            if(result != null) {
                printCSVContent(result);
            }
        }
    }

    private void printCSVContent(List<String[]> result) {
        String csvColumn = "";
        for (int i = 0; i < result.size(); i++) {
            String [] rows = result.get(i);
            Log.e("First row", rows[2]);
            csvColumn += rows[0] + " " + rows[1] + "\n";
        }
        //TODO show the text
    }

    private List<String[]> downloadRemoteTextFileContent() {
        URL _url = null;
        List<String[]> csvLine = new ArrayList<>();
        String[] content = null;
        try {
            _url = new URL(LINK);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            assert _url != null;
            URLConnection connection = _url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            while ((line = br.readLine()) != null) {
                content = line.split(";");
                csvLine.add(content);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvLine;
    }
}
