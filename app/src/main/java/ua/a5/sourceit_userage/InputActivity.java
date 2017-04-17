package ua.a5.sourceit_userage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    EditText etUserName;

    Button btnNext;

    DatePicker datePicker;
    int dayOfBirth;
    int monthOfBirth;
    int yearOfBirth;
    String stringYearOfBirth;

    String userName;
    String userZodiac;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        etUserName = (EditText) findViewById(R.id.et_user_name);
        //этот слушатель позволяет убирать клавиатуру EditText
        //при нажатии на пустое пространство.
        etUserName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });


        datePicker = (DatePicker) findViewById(R.id.date_picker);


        btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName = etUserName.getText().toString();
                getDateOfBirthFromDatePicker();
                defineZodiac();


                Intent intent = new Intent(getApplicationContext(), StatisticsActivity.class);
                intent.putExtra("name", userName);
                intent.putExtra("zodiac", userZodiac);
                intent.putExtra("yearOfBirth", stringYearOfBirth);
                startActivity(intent);
            }
        });


    }

    private void defineZodiac() {
        switch (monthOfBirth) {
            case 1:
                userZodiac = "Козерог или Водолей";
                break;
            case 2:
                userZodiac = "Водолей или Рыбы";
                break;
            case 3:
                userZodiac = "Рыбы или Овен";
                break;
            case 4:
                userZodiac = "Овен или Телец";
                break;
            case 5:
                userZodiac = "Телец или Близнецы";
                break;
            case 6:
                userZodiac = "Близнецы или Рак";
                break;
            case 7:
                userZodiac = "Рак или Лев";
                break;
            case 8:
                userZodiac = "Лев или Дева";
                break;
            case 9:
                userZodiac = "Дева или Весы";
                break;
            case 10:
                userZodiac = "Весы или Скорпион";
                break;
            case 11:
                userZodiac = "Скорпион или Стрелец";
                break;
            case 12:
                userZodiac = "Стрелец или Козерог";
                break;
        }
    }

    private void getDateOfBirthFromDatePicker() {
        datePicker = (DatePicker) findViewById(R.id.date_picker);
        dayOfBirth = datePicker.getDayOfMonth();
        monthOfBirth = datePicker.getMonth() + 1;
        yearOfBirth = datePicker.getYear();

        stringYearOfBirth = String.valueOf(yearOfBirth);
        System.out.println("stringYearOfBirth = " + stringYearOfBirth);
    }


    //метод, для убирания клавиатуры EditText при нажатии на пустое пространство.
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
