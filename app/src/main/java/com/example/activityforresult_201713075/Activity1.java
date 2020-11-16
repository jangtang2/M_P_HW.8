package com.example.activityforresult_201713075;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {
    EditText edit; //EditText 선언
    TextView text2; //TextView 선언
    static final int GET_STRING2 = 2;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1); //layout1과 연결됨
        edit = (EditText) findViewById(R.id.edit);
        text2 = (TextView) findViewById(R.id.textView);
        Button button_ok = (Button) findViewById(R.id.button_ok);
        Button button = (Button) findViewById(R.id.second_button);
        Button button_cancel = (Button) findViewById(R.id.button_cancel); //각 버튼을 layout1의 버튼과 매칭
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(); //인텐트 생성
                intent.putExtra("INPUT_TEXT1", edit.getText().toString()); //인텐트에 첫번째 텍스트 담기
                if(flag)
                intent.putExtra("INPUT_TEXT2", text2.getText().toString()); //인텐트에 두번째 텍스트 담기
                setResult(RESULT_OK, intent);
                finish(); //이벤트 종료
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity1.this, Activity2.class);//인텐트 생성
                startActivityForResult(intent, GET_STRING2); //두번째 텍스트 받기
            }
        });
        button_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_CANCELED); //Canceled
                finish(); //종료
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { //Activity2 에게 텍스트 받음
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_STRING2) {
            if (resultCode == RESULT_OK) {
                text2.setText(data.getStringExtra("INPUT_TEXT2")); //받은 텍스트 삽입
                flag=true;
            }
        }
    }
}