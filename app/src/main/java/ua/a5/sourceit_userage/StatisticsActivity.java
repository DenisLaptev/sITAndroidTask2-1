package ua.a5.sourceit_userage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;


public class StatisticsActivity extends AppCompatActivity {
    TextView tvName;
    TextView tvAge;
    TextView tvNumberOfDays;
    TextView tvNumberOfSeconds;
    TextView tvZodiac;

    Date currentDate;
    int currentYear;


    String userName;
    long userAge;
    long userNumberOfDays;
    long userNumberOfSeconds;
    String userZodiac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        tvName = (TextView) findViewById(R.id.tv_name);
        userName = getIntent().getStringExtra("name");
        tvName.setText(userName);

        Calendar now = Calendar.getInstance();   // Gets the current date and time
        currentYear = now.get(Calendar.YEAR);    // The current year

        System.out.println("currentYear=" + currentYear);
        userAge = currentYear - Long.parseLong(getIntent().getStringExtra("yearOfBirth"));

        tvAge = (TextView) findViewById(R.id.tv_age);
        tvAge.setText(String.valueOf(userAge));

        tvNumberOfDays = (TextView) findViewById(R.id.tv_number_of_days);
        tvNumberOfDays.setText(String.valueOf(userAge * 365));

        tvNumberOfSeconds = (TextView) findViewById(R.id.tv_number_of_seconds);
        tvNumberOfSeconds.setText(String.valueOf(userAge * 365 * 24 * 3600));

        tvZodiac = (TextView) findViewById(R.id.tv_zodiac);
        userZodiac = getIntent().getStringExtra("zodiac");
        tvZodiac.setText(userZodiac);
    }
}
