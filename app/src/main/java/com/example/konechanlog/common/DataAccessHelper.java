package com.example.konechanlog.common;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.content.ContextCompat;

import com.example.konechanlog.placeholder.PlaceholderContent;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    /* ************************ */
    /* 読みだすべきアプリの存在場所  */
    /* ************************ */
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

    public void kakidashiByObject(PlaceholderContent.PlaceholderItem placeholderItem) throws Exception {

        // オブジェクトとして書き出し
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // パーミッションがない場合、ユーザーにパーミッションを要求する処理を記述
        } else {
            // パーミッションがある場合、ファイルを保存する処理を記述
            //
            try {
                // オブジェクトをファイルに保存する
                FileOutputStream fileOut = new FileOutputStream("placeholderItem.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(placeholderItem);
                out.close();
                fileOut.close();
                System.out.println("オブジェクトをシリアライズしてファイルに保存しました。");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    // file output
    public void kakidashi(String outFileName, String outData) throws Exception {
        // 文字列として書き出す
        try {
            OutputStream out = context.openFileOutput(outFileName, Context.MODE_APPEND);
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
    public List<PlaceholderContent.PlaceholderItem> yomikomiByObject(String filein) throws Exception {


        // オブジェクトとして読み込む
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // パーミッションがない場合、ユーザーにパーミッションを要求する処理を記述
        } else {
            //パーミッションがある場合、ファイルを読み込む処理を記述
            //      シリアライズされたオブジェクトを復元する
            try {
                FileInputStream fileIn = new FileInputStream("placeholderItem.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                PlaceholderContent.PlaceholderItem deserializedplaceholderItem = (PlaceholderContent.PlaceholderItem) in.readObject();
                in.close();
                fileIn.close();
                System.out.println("ファイルからオブジェクトを復元しました。");
                System.out.println("Content: " + deserializedplaceholderItem.toString());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            //

        }
        return null;
    }

    /*
     file input
     */
    public List<String> yomikomi(String inFileName) throws Exception {
        // 文字に分解されたデータを読み込む

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
