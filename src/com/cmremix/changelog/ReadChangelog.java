package com.cmremix.changelog;

import android.content.Context;
import android.os.AsyncTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.StringBuilder;
import java.util.Scanner;

import com.cmremix.ota.R;

interface ICMRemixChangelog {
    public void onResponseReceived(String result);
}

public abstract class ReadChangelog extends AsyncTask<Context, Integer, String> implements ICMRemixChangelog {

    public abstract void onResponseReceived(String result);

    @Override
    protected String doInBackground(Context... arg) {
        Context context = arg[0];
        String sChangelogPath = context.getString(R.string.changelog_path);
        File file = new File(sChangelogPath);
        StringBuilder sb = new StringBuilder();
        Scanner scanner = null;
        String changelog;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                sb.append(line);
                sb.append("\n");
            }
            changelog = sb.toString();
        } catch (FileNotFoundException ex) {
            changelog = ex.getMessage();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return changelog;
    }

    @Override
    protected void onPostExecute(String result) {
        onResponseReceived(result);
    }
}
