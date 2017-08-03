package com.bingerdranch.android.readingbooks;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends Activity {


    String textOnFile;
    ArrayList <ArrayList<String>> listInList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //readBook();
        listInList = new ArrayList<>();
        doInBackground();
        write();

    }

    void readBook(){
        Resources res = this.getResources();
        InputStream in_s = null;
        in_s = res.openRawResource(R.raw.a_book_one);
        byte[] b = new byte[0];
        try {
            b = new byte[in_s.available()];
            in_s.read(b);
            textOnFile = new String(b);// тут весь текст
            Log.d(LOG_TAG,textOnFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void write() {

        final String LOG_TAG = "MyLogs";
        final String FILE_NAME = "content.txt";
        FileOutputStream fos = null;
        Log.d(LOG_TAG, "Метод сработал");
        Log.d(LOG_TAG, "listSize = " + listInList.size());
        try {
            for (int i = 0; i<listInList.size();i++){
                for(int j = 0; j<listInList.get(i).size();j++){
                    String text = listInList.get(i).get(j);
                    fos = openFileOutput(FILE_NAME, MODE_APPEND);
                    fos.write(text.getBytes());
                }
            }
            /*fos = openFileOutput(FILE_NAME, MODE_APPEND);
            fos.write(textOnFile.getBytes());
            Log.d(LOG_TAG, "Save");*/
        }
        catch(IOException ex) {
            Log.d(LOG_TAG, "Error");
        }
        finally{
            try{
                if(fos!=null)
                    fos.close();
            }
            catch(IOException ex){
                Log.d(LOG_TAG, "Error 2");
            }
        }



    }



    private static final String LOG_TAG = "MyLogs";

    protected String doInBackground() {

        String textOnFile;
        String arabTexts;

        Resources res = getResources();
        InputStream in_s = null;
        InputStream in_arab = null;

        in_s = res.openRawResource(R.raw.test_en);
        in_arab = res.openRawResource(R.raw.test_ar);

        byte[] b = new byte[0];
        byte[] arab = new byte[0];
        try {
            b = new byte[in_s.available()];
            arab = new byte[in_arab.available()];

            in_s.read(b);
            in_arab.read(arab);
        } catch (IOException e) {
            e.printStackTrace();
        }
        textOnFile = new String(b);// тут весь текст с выбранной книги
        arabTexts = new String(arab); // тут весь текст на арабском

        ArrayList<String> listHad = new ArrayList<>();
        ArrayList <String> listArab = new ArrayList<>();

        textOnFile = textOnFile.replaceAll("<item","@");
        arabTexts = arabTexts.replaceAll("<item","@");

        textOnFile = textOnFile.replaceAll("</item>","№");
        arabTexts = arabTexts.replaceAll("</item>","№");

        //Log.d(LOG_TAG,arabTexts);

        char[]arr = textOnFile.toCharArray();
        char[]arrArab = arabTexts.toCharArray();

        int k = 0;
        for (int i = 0; i<arr.length;i++){
            if (arr[i]=='@'){
                k++;
                String s = textOnFile.substring(i, textOnFile.indexOf('№',i));
                s = s.substring(2,s.length());
                s = k + " " + s;
                listHad.add(s);
            }
        }

        for (int i = 0; i<arrArab.length;i++){
            if (arrArab[i]=='@'){
                String s1 = arabTexts.substring(i, arabTexts.indexOf('№',i));
                listArab.add(s1);
            }
        }

        ArrayList<String> tom1 = new ArrayList<>();
        //ArrayList<String> tom2 = new ArrayList<>();
        ArrayList<String> tom3 = new ArrayList<>();
        ArrayList<String> tom4 = new ArrayList<>();
        ArrayList<String> tom5 = new ArrayList<>();
        ArrayList<String> tom6 = new ArrayList<>();
        //ArrayList<String> tom7 = new ArrayList<>();
        //ArrayList<String> tom8 = new ArrayList<>();
        ArrayList<String> tom9 = new ArrayList<>();
        ArrayList<String> tom10 = new ArrayList<>();
        ArrayList<String> tom11= new ArrayList<>();
        ArrayList<String> tom12 = new ArrayList<>();
        ArrayList<String> tom13 = new ArrayList<>();
        ArrayList<String> tom14 = new ArrayList<>();
        ArrayList<String> tom15 = new ArrayList<>();
        ArrayList<String> tom16 = new ArrayList<>();

        listInList = new ArrayList<>();

        int num = 1;
        tom1.add("Title_1_1 <ts>Tom one<te><ars>صحیح بخاری ۔ جلد اول ۔ وحی کا بیان ۔ حدیث<are>");
        for (int i = 0; i<=180;i++){
            tom1.add("<hads>"+num+"<ents>"+listHad.get(i)+"<ente>"+"<arts>"+listArab.get(i)+"<arte>"+"<urduts>"+listArab.get(i)+"<urdute>"+"<hade>");
            num++;
        }
        tom1.add("End_title");
        tom3.add("Title_1_3 <ts>Tom three<te><ars>صحیح بخاری ۔ جلد اول ۔ وحی کا بیان ۔ حدیث<are>");
        num = 1;
        for (int i = 181;i<=246;i++){
            tom3.add("<hads>"+num+"<ents>"+listHad.get(i)+"<ente>"+"<arts>"+listArab.get(i)+"<arte>"+"<urduts>"+listArab.get(i)+"<urdute>"+"<hade>");
            num++;
        }
        tom3.add("End_title");
        tom4.add("Title_1_4 <ts>Tom four<te><ars>صحیح بخاری ۔ جلد اول ۔ وحی کا بیان ۔ حدیث<are>");
        num = 598;
        for (int i = 247;i<=297;i++){
            tom4.add("<hads>"+num+"<ents>"+listHad.get(i)+"<ente>"+"<arts>"+listArab.get(i)+"<arte>"+"<urduts>"+listArab.get(i)+"<urdute>"+"<hade>");
            num++;
        }
        tom4.add("End_title");
        tom5.add("Title_1_5 <ts>Tom five<te><ars>صحیح بخاری ۔ جلد اول ۔ وحی کا بیان ۔ حدیث<are>");
        num = 650;
        for (int i = 298;i<=355;i++){
            tom5.add("<hads>"+num+"<ents>"+listHad.get(i)+"<ente>"+"<arts>"+listArab.get(i)+"<arte>"+"<urduts>"+listArab.get(i)+"<urdute>"+"<hade>");
            num++;
        }
        tom5.add("End_title");
        tom6.add("Title_1_6 <ts>Tom six<te><ars>صحیح بخاری ۔ جلد اول ۔ وحی کا بیان ۔ حدیث<are>");
        num = 1;
        for (int i = 356;i<=429;i++){
            tom6.add("<hads>"+num+"<ents>"+listHad.get(i)+"<ente>"+"<arts>"+listArab.get(i)+"<arte>"+"<urduts>"+listArab.get(i)+"<urdute>"+"<hade>");
            num++;
        }
        tom6.add("End_title");
        tom9.add("Title_1_9 <ts>Tom nine<te><ars>صحیح بخاری ۔ جلد اول ۔ وحی کا بیان ۔ حدیث<are>");
        num = 1169;
        for (int i = 430;i<=476;i++){
            tom9.add("<hads>"+num+"<ents>"+listHad.get(i)+"<ente>"+"<arts>"+listArab.get(i)+"<arte>"+"<urduts>"+listArab.get(i)+"<urdute>"+"<hade>");
            num++;
        }
        tom9.add("End_title");
        tom10.add("Title_1_10 <ts>Tom ten<te><ars>صحیح بخاری ۔ جلد اول ۔ وحی کا بیان ۔ حدیث<are>");
        num = 1205;
        for (int i = 477;i<=534;i++){
            tom10.add("<hads>"+num+"<ents>"+listHad.get(i)+"<ente>"+"<arts>"+listArab.get(i)+"<arte>"+"<urduts>"+listArab.get(i)+"<urdute>"+"<hade>");
            num++;
        }
        tom10.add("End_title");
        tom11.add("Title_1_11 <ts>Tom odinadzat<te><ars>صحیح بخاری ۔ جلد اول ۔ وحی کا بیان ۔ حدیث<are>");
        num = 1271;
        for (int i = 535;i<=597;i++){
            tom11.add("<hads>"+num+"<ents>"+listHad.get(i)+"<ente>"+"<arts>"+listArab.get(i)+"<arte>"+"<urduts>"+listArab.get(i)+"<urdute>"+"<hade>");
            num++;
        }
        tom11.add("End_title");
        tom12.add("Title_1_12 <ts>Tom dvenadzat<te><ars>صحیح بخاری ۔ جلد اول ۔ وحی کا بیان ۔ حدیث<are>");
        num = 1319;
        for (int i = 598;i<=642;i++){
            tom12.add("<hads>"+num+"<ents>"+listHad.get(i)+"<ente>"+"<arts>"+listArab.get(i)+"<arte>"+"<urduts>"+listArab.get(i)+"<urdute>"+"<hade>");
            num++;
        }
        tom12.add("End_title");
        tom13.add("Title_1_13 <ts>Tom threeteen<te><ars>صحیح بخاری ۔ جلد اول ۔ وحی کا بیان ۔ حدیث<are>");
        num = 1;
        for (int i = 643;i<=665;i++){
            tom13.add("<hads>"+num+"<ents>"+listHad.get(i)+"<ente>"+"<arts>"+listArab.get(i)+"<arte>"+"<urduts>"+listArab.get(i)+"<urdute>"+"<hade>");
            num++;
        }
        tom13.add("End_title");
        tom14.add("Title_1_14 <ts>Tom fourteen<te><ars>صحیح بخاری ۔ جلد اول ۔ وحی کا بیان ۔ حدیث<are>");
        num = 1;
        for (int i = 666;i<=701;i++){
            tom14.add("<hads>"+num+"<ents>"+listHad.get(i)+"<ente>"+"<arts>"+listArab.get(i)+"<arte>"+"<urduts>"+listArab.get(i)+"<urdute>"+"<hade>");
            num++;
        }
        tom14.add("End_title");
        tom15.add("Title_1_15 <ts>Tom fiveteen<te><ars>صحیح بخاری ۔ جلد اول ۔ وحی کا بیان ۔ حدیث<are>");
        num = 1418;
        for (int i = 702;i<=721;i++){
            tom15.add("<hads>"+num+"<ents>"+listHad.get(i)+"<ente>"+"<arts>"+listArab.get(i)+"<arte>"+"<urduts>"+listArab.get(i)+"<urdute>"+"<hade>");
            num++;
        }
        tom15.add("End_title");
        tom16.add("Title_1_16 <ts>Tom sixteen<te><ars>صحیح بخاری ۔ جلد اول ۔ وحی کا بیان ۔ حدیث<are>");
        num = 1437;
        for (int i = 722;i<listHad.size();i++){
            tom16.add("<hads>"+num+"<ents>"+listHad.get(i)+"<ente>"+"<arts>"+listArab.get(i)+"<arte>"+"<urduts>"+listArab.get(i)+"<urdute>"+"<hade>");
            num++;
        }
        tom16.add("End_title");

        listInList.add(tom1);
        listInList.add(tom3);
        listInList.add(tom4);
        listInList.add(tom5);
        listInList.add(tom6);
        listInList.add(tom9);
        listInList.add(tom10);
        listInList.add(tom11);
        listInList.add(tom12);
        listInList.add(tom13);
        listInList.add(tom14);
        listInList.add(tom15);
        listInList.add(tom16);

        return null;
    }

    ArrayList returnListInList(){
        Log.d(LOG_TAG,"doInBackground = " + listInList.size());
        return listInList;
    }
}
