package com.example.konechanlog.common;

import static android.content.Context.MODE_APPEND;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/*
    このクラスはデータアクセス全般を支援する
    DataAccessHelper
 */

public class DataAccessHelper {

    /*
        context
     */
    private Context context;
    /*
        default constractor
     */

    public DataAccessHelper(Context ctx) {
        super();
        context = ctx;
    }

    /*
        file output
     */
    public void kakidashi(String outFileName, String outData) throws Exception {


        try {
            OutputStream out = context.openFileOutput(outFileName, MODE_APPEND);
            PrintWriter writer =
                    new PrintWriter(new OutputStreamWriter(out, "UTF-8"));

            String x = out.toString();

            writer.append(outData);
            writer.close();


        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (
                IOException e) {
            e.printStackTrace();
            throw e;
        }

    }

    /*
        file input

     */
    public List<String> yomikomi(String inFileName) throws Exception {

        List retList = new ArrayList<String>();
        try {
            InputStream in = context.openFileInput(inFileName);
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String s;
            while ((s = reader.readLine()) != null) {
                retList.add(s);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retList;
    }
}
