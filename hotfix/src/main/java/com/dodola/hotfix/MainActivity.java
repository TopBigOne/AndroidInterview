package com.dodola.hotfix;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

public class MainActivity extends AppCompatActivity {
    TextView titleTv;
    Button   showTitleBt;
    Button   hotfixBt;
    Button   removeHotfixBt;
    Button   killSelfBt;
    File     apk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTv = findViewById(R.id.titleTv);
        showTitleBt = findViewById(R.id.showTitleBt);
        hotfixBt = findViewById(R.id.hotfixBt);
        removeHotfixBt = findViewById(R.id.removeHotfixBt);
        killSelfBt = findViewById(R.id.killSelfBt);

        apk = new File(getCacheDir() + "/hotfix.dex");
        test();

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                switch (v.getId()) {
                    case R.id.showTitleBt:
                        Title title = new Title();
                        titleTv.setText(title.getTitle());
                        break;
                    case R.id.hotfixBt:

                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder()
                                .url("https://api.hencoder.com/patch/upload/hotfix.dex")
                                .get()
                                .build();
                        client.newCall(request)
                                .enqueue(new Callback() {
                                    @Override
                                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                                    }

                                    @Override
                                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                                        try {
                                            FileOutputStream fos = new FileOutputStream(apk);
                                            fos.write(response.body().bytes());
                                            fos.close();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        v.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(MainActivity.this, "??????????????????", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                });
                        break;
                    case R.id.removeHotfixBt:
                        if (apk.exists()) {
                            apk.delete();
                        }
                        break;
                    case R.id.killSelfBt:
                        android.os.Process.killProcess(android.os.Process.myPid());
                        break;

                    default:
                }
            }
        };

        showTitleBt.setOnClickListener(onClickListener);
        hotfixBt.setOnClickListener(onClickListener);
        removeHotfixBt.setOnClickListener(onClickListener);
        killSelfBt.setOnClickListener(onClickListener);
    }

    private void test() {
        try (Source source = Okio.source(getAssets().open("apk/hotfix.dex"));
             BufferedSink sink = Okio.buffer(Okio.sink(apk))) {
            sink.writeAll(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
