package com.example.calculatorx;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean dotUsed = false;
    private final static int IS_NUMBER = 0;
    private final static int IS_OPERAND = 1;
    private final static int IS_DOT = 4;
    private boolean isOpPressed = false;
    private double val1 = 0;
    private char currentOP;
    private int val2Index = 0;

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button buttonDivision, buttonMultiplication, buttonAddition, buttonSubtraction;
    Button buttonDot, buttonEquals, buttonPercent, buttonClear, buttonDelete, buttonParenthesis;
    TextView TextViewInputNumbers, TextViewResultNumbers;

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

    @SuppressLint("SetTextI18n")
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
                calculate('+');
                break;
            case R.id.subtraction:
                calculate('-');
                break;
            case R.id.mul:
                calculate('×');
                break;
            case R.id.division:
                calculate('÷');
                break;

            case R.id.equals:
                if (TextViewInputNumbers.getText().length() != 0 && defineLastCharacter(TextViewInputNumbers.getText().charAt(TextViewInputNumbers.getText().length() - 1) + "") == IS_NUMBER && isOpPressed) {
                    String screenContent = TextViewInputNumbers.getText().toString();
                    double val2 = Double.parseDouble(screenContent.substring(val2Index));
                    isOpPressed = false;
                    dotUsed = false;
                    if (currentOP == '+') {
                        val1 += val2;
                    } else if (currentOP == '-') {
                        val1 -= val2;
                    } else if (currentOP == '×') {
                        val1 *= val2;
                    } else if (currentOP == '÷') {
                        val1 /= val2;
                    }
                    TextViewResultNumbers.setText(String.valueOf(val1));
                    TextViewInputNumbers.setText("");
                }
                break;

            case R.id.dot:
                if (TextViewInputNumbers.getText().length() == 0) {
                    TextViewInputNumbers.append("0.");
                    dotUsed = true;
                } else if (dotUsed) {
                    break;
                } else if (defineLastCharacter(TextViewInputNumbers.getText().charAt(TextViewInputNumbers.getText().length() - 1) + "") == IS_OPERAND) {
                    TextViewInputNumbers.setText(TextViewInputNumbers.getText() + "0.");
                    dotUsed = true;
                } else if (defineLastCharacter(TextViewInputNumbers.getText().charAt(TextViewInputNumbers.getText().length() - 1) + "") == IS_NUMBER) {
                    TextViewInputNumbers.setText(TextViewInputNumbers.getText() + ".");
                    dotUsed = true;
                }
                break;

            case R.id.clean:
                TextViewInputNumbers.setText("");
                TextViewResultNumbers.setText("");
                break;

            case R.id.del:
                if (TextViewInputNumbers.getText().toString().length() > 0) {
                    String displayedElements = TextViewInputNumbers.getText().toString();
                    char cLastElement = displayedElements.charAt(displayedElements.length() - 1);
                    displayedElements = displayedElements.substring(0, displayedElements.length() - 1);
                    if (cLastElement == '.') {
                        dotUsed = false;
                    } else if (defineLastCharacter(String.valueOf(cLastElement)) == IS_OPERAND) {
                        isOpPressed = false;
                        dotUsed = !isObjectInteger(displayedElements);
                    }
                    TextViewInputNumbers.setText(displayedElements);
                }
                break;
        }
    }

    public boolean isObjectInteger(Object TextViewInputNumbers) {
        try {
            Integer.parseInt(String.valueOf(TextViewInputNumbers));
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private void calculate(char input) {
        if (TextViewInputNumbers.getText().length() != 0 && !isOpPressed) {
            val2Index = TextViewInputNumbers.length() + 1;
            val1 = Double.parseDouble(TextViewInputNumbers.getText().toString());
            if (input == '÷') {
                TextViewInputNumbers.append("÷");
            } else if (input == '×') {
                TextViewInputNumbers.append("×");
            } else if (input == '-') {
                TextViewInputNumbers.append("-");
            } else if (input == '+') {
                TextViewInputNumbers.append("+");
            }
            currentOP = input;
            isOpPressed = true;
            dotUsed = false;
        }
    }

    private int defineLastCharacter(String lastCharacter) {
        try {
            Integer.parseInt(lastCharacter);
            return IS_NUMBER;
        } catch (NumberFormatException ignored) {
        }
        if (lastCharacter.equals("+") || lastCharacter.equals("-") || lastCharacter.equals("×") || lastCharacter.equals("÷"))
            return IS_OPERAND;
        if (lastCharacter.equals("."))
            return IS_DOT;
        return -1;
    }
}