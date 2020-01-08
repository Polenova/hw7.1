package ru.android.polenova;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;
import java.util.Locale;

public class MorningActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning);
        DateFormat timeFormat = new SimpleDateFormat("HH.mm", Locale.getDefault());
        String timeText = timeFormat.format(new Date());
        final TextView textView = findViewById(R.id.textViewMorning);
        textView.append(timeText.toString());
    }
}
