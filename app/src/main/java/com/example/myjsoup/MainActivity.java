package com.example.myjsoup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class MainActivity extends AppCompatActivity {

    Elements contents;
    Document doc = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pastLottery();
    }



    private void pastLottery(){
            final String Url_id ="https://asfirstalways.tistory.com/360" ;
            new AsyncTask() {//AsyncTask객체 생성
                @Override
                protected Object doInBackground(Object[] params) {
                    try {
                        doc = Jsoup.connect(Url_id).get(); //naver페이지를 불러옴
                        Elements  contents = doc.select("body");//셀렉터로 span태그중 class값이 ah_k인 내용을 가져옴
                        String words = contents.toString();

                        for(Element  element: contents) { // -- 3. Elemntes 길이만큼 반복한다.
                            Log.d("TAG",  contents.text());
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

            }.execute();

        }

}
