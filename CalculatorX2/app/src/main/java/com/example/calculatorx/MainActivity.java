package com.example.calculatorx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int openParenthesis = 0;

    private boolean isOpen = false;
    private boolean dotUsed = false;
    private final static int IS_NUMBER = 0;
    private final static int IS_OPERAND = 1;
    private final static int IS_OPEN_PARENTHESIS = 2;
    private final static int IS_CLOSE_PARENTHESIS = 3;
    private final static int IS_DOT = 4;
    private boolean isOpPressed = false;
    private double val1 = 0;
    private double val2 = 0;
    private char currentOP;
    private int val2Index = 0;

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
                String screenContent = TextViewInputNumbers.getText().toString();
                val2Index = TextViewInputNumbers.length() + 1;
                val1 = Double.parseDouble(screenContent);
                TextViewInputNumbers.append("+");
                isOpPressed = true;
                currentOP = '+';

                break;

            case R.id.subtraction:
                screenContent = TextViewInputNumbers.getText().toString();
                val2Index = TextViewInputNumbers.length() + 1;
                val1 = Double.parseDouble(screenContent);
                TextViewInputNumbers.append("-");
                isOpPressed = true;
                currentOP = '-';
                break;

            case R.id.mul:
                screenContent = TextViewInputNumbers.getText().toString();
                val2Index = TextViewInputNumbers.length() + 1;
                val1 = Double.parseDouble(screenContent);
                TextViewInputNumbers.append("×");
                isOpPressed = true;
                currentOP = '×';
                break;

            case R.id.division:
                screenContent = TextViewInputNumbers.getText().toString();
                val2Index = TextViewInputNumbers.length() + 1;
                val1 = Double.parseDouble(screenContent);
                TextViewInputNumbers.append("÷");
                isOpPressed = true;
                currentOP = '÷';
                break;

            case R.id.equals:
                if (isOpPressed) {
                    if (currentOP == '+') {
                        screenContent = TextViewInputNumbers.getText().toString();
                        String val2String = screenContent.substring(val2Index, screenContent.length());
                        double val2 = Double.parseDouble(val2String);
                        val2 += val1;
                        TextViewInputNumbers.setText(String.valueOf(val2));

                    } else if (currentOP == '-') {
                        screenContent = TextViewInputNumbers.getText().toString();
                        String val2String = screenContent.substring(val2Index, screenContent.length());
                        double val2 = Double.parseDouble(val2String);
                        val1 -= val2;

                        TextViewInputNumbers.setText(String.valueOf(val1));
                    } else if (currentOP == '×' ) {
                        screenContent = TextViewInputNumbers.getText().toString();
                        String val2String = screenContent.substring(val2Index, screenContent.length());
                        double val2 = Double.parseDouble(val2String);
                        val1 = val1 * val2;
                        TextViewInputNumbers.setText(String.valueOf(val1));
                    } else if (currentOP == '÷') {
                        screenContent = TextViewInputNumbers.getText().toString();
                        String val2String = screenContent.substring(val2Index, screenContent.length());
                        double val2 = Double.parseDouble(val2String);
                        val1 = val1 / val2;
                        TextViewInputNumbers.setText(String.valueOf(val1));
                    }
                }
                break;

            case R.id.dot:
                if (TextViewInputNumbers.getText().length() == 0) {
                    TextViewInputNumbers.append("0.");
                    dotUsed = true;
                } else if (defineLastCharacter(TextViewInputNumbers.getText().charAt(TextViewInputNumbers.getText().length() - 1) + "") == IS_OPERAND) {
                    TextViewInputNumbers.setText(TextViewInputNumbers.getText() + "0.");
                    dotUsed = true;
                } else if (defineLastCharacter(TextViewInputNumbers.getText().charAt(TextViewInputNumbers.getText().length() - 1) + "") == IS_NUMBER) {
                    TextViewInputNumbers.setText(TextViewInputNumbers.getText() + ".");
                    dotUsed = true;
                } else if (dotUsed == true) {
                }

                break;

            case R.id.percent:
                TextViewInputNumbers.append("%");
                break;

            case R.id.parenthesis:
                int lengthOfText = TextViewInputNumbers.getText().length();

                if (lengthOfText == 0) {
                    TextViewInputNumbers.setText(TextViewInputNumbers.getText() + "(");
                    openParenthesis++;

                } else if (openParenthesis > 0 && lengthOfText > 0) {
                    String lastInput = TextViewInputNumbers.getText().charAt(lengthOfText - 1) + "";
                    switch (defineLastCharacter(lastInput)){
                        case IS_NUMBER:
                        case IS_CLOSE_PARENTHESIS:
                            TextViewInputNumbers.setText(TextViewInputNumbers.getText() + ")");
                            openParenthesis--;
                            break;
                        case IS_OPERAND:
                        case IS_OPEN_PARENTHESIS:
                            TextViewInputNumbers.setText(TextViewInputNumbers.getText() + "(");
                            openParenthesis++;
                            break;
                    }
                }else if (openParenthesis == 0 && lengthOfText >0){
                    String lastInput = TextViewInputNumbers.getText().charAt(lengthOfText - 1) + "";
                    if (defineLastCharacter(lastInput) == IS_OPERAND) {
                        TextViewInputNumbers.setText(TextViewInputNumbers.getText() + "(");
                    }else {
                        screenContent = TextViewInputNumbers.getText().toString();
                        val2Index = TextViewInputNumbers.length() + 1;
                        val1 = Double.parseDouble(screenContent);
                        isOpPressed = true;
                        currentOP = '×';
                        TextViewInputNumbers.setText(TextViewInputNumbers.getText() + "×(");
                    }
                openParenthesis++;
                }

                break;

            case R.id.clean:
                TextViewInputNumbers.setText("");
                TextViewResultNumbers.setText("");
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

    private int defineLastCharacter(String lastCharacter) {
        try {
            Integer.parseInt(lastCharacter);
            return IS_NUMBER;
        } catch (NumberFormatException e) {
        }

        if ((lastCharacter.equals("+") || lastCharacter.equals("-") || lastCharacter.equals("×") || lastCharacter.equals("÷") || lastCharacter.equals("%")))
            return IS_OPERAND;

        if (lastCharacter.equals("("))
            return IS_OPEN_PARENTHESIS;

        if (lastCharacter.equals(")"))
            return IS_CLOSE_PARENTHESIS;

        if (lastCharacter.equals("."))
            return IS_DOT;

        return -1;
    }
}
