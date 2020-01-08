package ru.android.polenova;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        final Intent intent = new Intent(Intent.ACTION_SYNC);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                DateFormat timeFormat = new SimpleDateFormat("HH.mm", Locale.getDefault());
                String timeText = timeFormat.format(new Date());
                double timeNumber = Double.parseDouble(timeText);
                if (timeNumber >= 6.00 && timeNumber <= 14.00) {
                    intent.setData(Uri.parse("http://morning"));
                } else if (timeNumber >= 14.00 && timeNumber <= 15.00) {
                    intent.setData(Uri.parse("http://afternoon"));
                } else {
                    intent.setData(Uri.parse("http://evening"));
                }
                startActivity(intent);
            }
        });
    }
}
