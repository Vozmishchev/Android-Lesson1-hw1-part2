package ru.gb.android_lesson1_hw1_part2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggleButtonSedan;
    private ToggleButton toggleButtonMinivan;
    private ToggleButton toggleButtonPickup;
    private CheckBox checkBoxKey;
    private Button rentButton;
    private EditText userNameEditText;
    private EditText userPhoneEditText;
    private TextView resultTextView;
    private EditText userBirthdayEditText;
    private Switch switchKey;
    private CalendarView calendarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

        toggleButtonSedan.setOnClickListener(v -> Toast.makeText(MainActivity.this,
                "RENT Sedan Car", Toast.LENGTH_SHORT).show());
        toggleButtonMinivan.setOnClickListener(v -> Toast.makeText(MainActivity.this,
                "RENT Minivan Car", Toast.LENGTH_SHORT).show());
        toggleButtonPickup.setOnClickListener(v -> Toast.makeText(MainActivity.this,
                "RENT Pickup Car", Toast.LENGTH_SHORT).show());

        checkBoxKey.setOnCheckedChangeListener((buttonView, isChecked) ->
                Snackbar.make(buttonView, "User agreement" + (isChecked ? " has been accepted" : " is not accepted"),
                        Snackbar.LENGTH_SHORT).show()
        );

        /*Проверка , что поля ввода данных не пусты и CaseBox проставлен*/

        rentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userNameEditText.getText().toString().trim().equals(""))
                    Toast.makeText(MainActivity.this, "No name enter",
                            Toast.LENGTH_SHORT).show();
                if (userPhoneEditText.getText().toString().trim().equals(""))
                    Toast.makeText(MainActivity.this, "No phone number enter",
                            Toast.LENGTH_SHORT).show();
                if (userPhoneEditText.getText().toString().trim().equals(""))
                    Toast.makeText(MainActivity.this, "No birthday enter",
                            Toast.LENGTH_SHORT).show();
                if (!checkBoxKey.isChecked()) Toast.makeText(MainActivity.this,
                        "the user agreement has not been confirmed", Toast.LENGTH_SHORT).show();

                else {
                    resultTextView.setText("Thank you for renting a car ");
                }
            }

        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                Toast.makeText(getApplicationContext(), "Your data rent:" + "\n" + "Year: "
                        + year + "\n" + "Month: " + (month + 1) + "\n" + "Day: "
                        + dayOfMonth, Toast.LENGTH_LONG).show();
            }
        });

    }

    private void initView() {

        toggleButtonSedan = findViewById(R.id.toggleButton_sedan);
        toggleButtonMinivan = findViewById(R.id.toggleButton_minivan);
        toggleButtonPickup = findViewById(R.id.toggleButton_pickup);
        checkBoxKey = findViewById(R.id.key_checkBox);
        rentButton = findViewById(R.id.rent_button);
        userNameEditText = findViewById(R.id.user_name_edit_text);
        userPhoneEditText = findViewById(R.id.user_phone_edit_text);
        resultTextView = findViewById(R.id.result_text_view);
        userBirthdayEditText = findViewById(R.id.user_birthday_edit_text);
        switchKey = findViewById(R.id.switch_key);
        calendarView = findViewById(R.id.calendar_view);
    }
}
