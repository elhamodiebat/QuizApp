package com.odiebat.elham.multiscreenapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class quiz extends AppCompatActivity {
    public String name;
    public int score = 0;
    public int one, two, three, four, five, six, seven;
    boolean checked;
    boolean result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        name = getIntent().getStringExtra("EXTRA_USER_NAME");
    }

    public int Result_one(View view) {
        checked = ((RadioButton) view).isChecked();
        result = false;
        if (view.getId() != 0) {
            result = ((view.getId() == R.id.qa11) ? true : false);
            one = ((result == true) ? 1 : 0);
        }
        return one;
    }

    public int Result_two(View view) {
        checked = ((RadioButton) view).isChecked();
        result = false;

        if (view.getId() != 0) {
            result = ((view.getId() == R.id.qa21) ? false : true);
            two = ((result == true) ? 1 : 0);
        }
        return two;
    }


    public int calculteScore(int one, int two, int three, int four, int five, int six, int seven) {
        score = one + two + three + four + five + six + seven;
        return score;
    }

    public int Result_three(View view) {

        checked = ((RadioButton) view).isChecked();
        result = false;
        if (view.getId() != 0) {
            result = ((view.getId() == R.id.qa31) ? true : false);
            three = ((result == true) ? 1 : 0);
        }
        return three;
    }

    public int Result_four(View view) {
        checked = ((RadioButton) view).isChecked();
        result = false;
        if (view.getId() != 0) {
            if (view.getId() == R.id.qa41) {
                result = false;
                four = 0;
            } else if (view.getId() == R.id.qa42) {
                result = false;
                four = 0;
            } else if (view.getId() == R.id.qa43) {
                result = true;
                four = 1;
            }
        }

        return four;
    }


    public int Result_five(View view) {
        checked = ((RadioButton) view).isChecked();
        result = false;

        if (view.getId() != 0) {
            if (view.getId() == R.id.qa51) {
                result = false;
                five = 0;
            } else if (view.getId() == R.id.qa52) {

                result = true;
                five = 1;
            } else if (view.getId() == R.id.qa53) {
                result = false;
                five = 0;
            }
        }
        return five;
    }

    public int Result_six() {
        EditText funder = findViewById(R.id.answarSix);
        String result = funder.getText().toString();
        if (result.equalsIgnoreCase("Andy Rubin")) {
            six = 1;
        } else {
            six = 0;
        }
        return six;
    }


    public int Result_seven() {
        CheckBox answerOne, answerTwo, answerThree;
        answerOne = findViewById(R.id.qa71);
        answerTwo = findViewById(R.id.qa72);
        answerThree = findViewById(R.id.qa73);
        boolean result = false;

        if (answerOne.isChecked() == true && answerTwo.isChecked() == true && answerThree.isChecked() == false) {
            seven = 1;
            result = true;
        } else {
            seven = 0;
            result = false;
        }
        return seven;
    }

    public void display_Result(View view) {
        int res = calculteScore(one, two, three, four, five, Result_six(), Result_seven());
        Toast.makeText(quiz.this, "Dear " + name + " your result is " + res, Toast.LENGTH_SHORT).show();
    }
}
