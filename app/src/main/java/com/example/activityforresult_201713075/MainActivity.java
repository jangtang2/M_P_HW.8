package com.example.activityforresult_201713075;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final int GET_STRING = 1;
    TextView text1; //첫번째 텍스트
    TextView text2; //두번째 텍스트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button); //button activity_main 의 button 과 연결
        text1 = (TextView) findViewById(R.id.s1text);
        text2 = (TextView) findViewById(R.id.s2text);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { //클릭시 Activity1로 intent, 결과 받는 이벤트 생성
                Intent intent = new Intent(MainActivity.this, Activity1.class); //intent 생성
                startActivityForResult(intent, GET_STRING); //결과
            }
        });
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_STRING) {
            if (resultCode == RESULT_OK) { // Activity1의 결과가 ok면
                text1.setText(data.getStringExtra("INPUT_TEXT1")); //text1 입력 받음
                text2.setText(data.getStringExtra("INPUT_TEXT2")); //text2 입력 받음
            }
        }
    }
}