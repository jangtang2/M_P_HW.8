package com.example.activityforresult_201713075;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    EditText edit;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2); //layout2와 연결
        edit = (EditText) findViewById(R.id.edit); // 텍스트 입력
        Button button_ok = (Button) findViewById(R.id.button_ok);
        Button button_cancel = (Button) findViewById(R.id.button_cancel);

        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(); //인텐트 생성
                intent.putExtra("INPUT_TEXT2", edit.getText().toString()); //인텐트에 텍스트 삽입
                setResult(RESULT_OK, intent); //성공적으로 수행했음을 알림
                finish(); //이벤트 종료
            }
        });
        button_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_CANCELED); //cancel 되었음을 알림
                finish(); //이벤트 종료
            }
        });
    }
}

