package com.example.a20240425;//A1112210145

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener {

    private TextView output;
    private EditText txt;
    private RadioGroup rg, rg2;
    public String str;
    public int x;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.txvOutput);
        rg = (RadioGroup) findViewById(R.id.rgGender);
        rg.setOnCheckedChangeListener(this);
        rg2 = (RadioGroup) findViewById(R.id.rg2);
        rg2.setOnCheckedChangeListener(this);
        txt = (EditText) findViewById(R.id.editTextText);
        btn = (Button) findViewById(R.id.button);

        txt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                show(rg.getCheckedRadioButtonId());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //建立Intent
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MainActivity2.class);

                //傳送字串到"MainActivity2"
                String string2Send = str;
                intent.putExtra("sendStr", string2Send);

                startActivity(intent);
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        show(i);
    }


    public void show(int i){

        //取得RadioGroup
        RadioGroup rgGender = (RadioGroup) findViewById(R.id.rgGender);
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.rg2);

        //字串str用來儲存輸出內容
        str = "";

        if (txt.getText().toString().equals("")){
            x = 0;
        }
        else{
            //整數x用來計算金額
            x = Integer.parseInt(txt.getText().toString());
        }



        //性別
        if(rgGender.getCheckedRadioButtonId() == R.id.rdbboy){
            str += "男生\n";
        }
        else if (rgGender.getCheckedRadioButtonId() == R.id.rdbgirl){
            str += "女生\n";
        }

        //票種
        if(rg2.getCheckedRadioButtonId() == R.id.rdbAldult){
            str += "全票\n";
            x = x * 500;
        }
        else if (rg2.getCheckedRadioButtonId() == R.id.rdbChildren) {
            str += "兒童票\n";
            x = x * 250;
        }
        else if (rg2.getCheckedRadioButtonId() == R.id.rdbStudent){
            str += "學生票\n";
            x = x * 400;
        }

        //張數
        if (x==0) {
            str += txt.getText().toString() + "0張\n";
        }
        else {
            str += txt.getText().toString() + "張\n";
        }
        //金額
        str += "金額：" + x;

        //輸出結果
        output.setText(str);
    }
}