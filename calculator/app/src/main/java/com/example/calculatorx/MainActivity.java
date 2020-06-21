package com.example.calculatorx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '×';
    private final char DIVISION = '÷';
    private final char EQUAL = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char OPERATION;

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    Button buttonDivision;
    Button buttonMultiplication;
    Button buttonAddition;
    Button buttonSubtraction;

    Button buttonDot;
    Button buttonEquals;
    Button buttonPercent;
    Button buttonClear;
    Button buttonDelete;
    Button buttonParenthesis;

    TextView TextViewInputNumbers;
    TextView TextViewResultNumbers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViewVariables();
        setOnClickListeners();

    }

    private void initializeViewVariables() {
        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);

        buttonAddition = findViewById(R.id.addition);
        buttonSubtraction = findViewById(R.id.subtraction);
        buttonMultiplication = findViewById(R.id.mul);
        buttonDivision = findViewById(R.id.division);

        buttonDelete = findViewById(R.id.del);
        buttonClear = findViewById(R.id.clean);
        buttonPercent = findViewById(R.id.percent);
        buttonParenthesis = findViewById(R.id.parenthesis);
        buttonDot = findViewById(R.id.dot);
        buttonEquals = findViewById(R.id.equals);

        TextViewInputNumbers = findViewById(R.id.inputCalScreen);
        TextViewResultNumbers = findViewById(R.id.resultCalScreen);

    }

    private void setOnClickListeners() {
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        buttonDivision.setOnClickListener(this);
        buttonMultiplication.setOnClickListener(this);
        buttonAddition.setOnClickListener(this);
        buttonSubtraction.setOnClickListener(this);

        buttonEquals.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonPercent.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonParenthesis.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn0:
                TextViewInputNumbers.append("0");
                break;
            case R.id.btn1:
                TextViewInputNumbers.append("1");
                break;
            case R.id.btn2:
                TextViewInputNumbers.append("2");
                break;
            case R.id.btn3:
                TextViewInputNumbers.append("3");
                break;
            case R.id.btn4:
                TextViewInputNumbers.append("4");
                break;
            case R.id.btn5:
                TextViewInputNumbers.append("5");
                break;
            case R.id.btn6:
                TextViewInputNumbers.append("6");
                break;
            case R.id.btn7:
                TextViewInputNumbers.append("7");
                break;
            case R.id.btn8:
                TextViewInputNumbers.append("8");
                break;
            case R.id.btn9:
                TextViewInputNumbers.append("9");
                break;

            case R.id.addition:
                calculator();
                OPERATION = ADDITION;
                TextViewInputNumbers.append("+");
                TextViewResultNumbers.setText(String.valueOf(val1));

                break;
            case R.id.subtraction:
                calculator();
                OPERATION = SUBTRACTION;

                TextViewInputNumbers.append("-");
                TextViewResultNumbers.setText(String.valueOf(val1));
                break;
            case R.id.mul:
                calculator();
                OPERATION = MULTIPLICATION;
                TextViewResultNumbers.setText(String.valueOf(val1));
                TextViewInputNumbers.append("×");
                break;
            case R.id.division:
                calculator();
                OPERATION = DIVISION;
                TextViewResultNumbers.setText(String.valueOf(val1));
                TextViewInputNumbers.append("÷");
                break;

            case R.id.equals:
                TextViewResultNumbers.append(String.valueOf(val1));
                break;
            case R.id.dot:
                break;

            case R.id.percent:
                break;
            case R.id.parenthesis:
                break;

            case R.id.clean:
                TextViewInputNumbers.setText(null);
                TextViewResultNumbers.setText(null);


                break;
            case R.id.del:
                String displayedElements = TextViewInputNumbers.getText().toString();
                int length = displayedElements.length();
                if (length > 0) {
                    displayedElements = displayedElements.substring(0, length - 1);
                    TextViewInputNumbers.setText(displayedElements);
                }
                break;
        }
    }

    private void calculator() {
        if (!Double.isNaN(val1)) {
            val2 = Double.parseDouble(TextViewInputNumbers.getText().toString());

            switch (OPERATION) {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
            }
        } else
            val1 = Double.parseDouble(TextViewInputNumbers.getText().toString());
    }

}

































/*


        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalScreen.setText("");
            }
        });






* */