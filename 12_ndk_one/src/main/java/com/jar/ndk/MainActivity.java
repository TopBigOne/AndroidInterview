package com.jar.ndk;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }

    private Button btnMmapWrite;
    private Button btnMmapRead;
    private EditText etUserEnter;
    private TextView tvLogContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logdog.getInstance().i("MainActivity.onCreate invoked");
        initView();
        initEvent();
    }

    private void initView() {
        btnMmapWrite = (Button) findViewById(R.id.btn_write_mmap);
        btnMmapRead = (Button) findViewById(R.id.btn_read);
        etUserEnter = (EditText) findViewById(R.id.et);
        tvLogContent = (TextView) findViewById(R.id.tv);
    }

    private void initEvent() {
        btnMmapWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                writeInputWithMMAP();
            }
        });


        btnMmapRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFile();

            }
        });
    }

    public void writeInputWithMMAP() {
        Logdog.getInstance().w(etUserEnter.getText().toString().trim());
        etUserEnter.setText("");

    }

    public void readFile() {
        String read = Logdog.getInstance().read();
        tvLogContent.setText(read);


    }


}
