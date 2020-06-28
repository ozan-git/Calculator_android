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
    Button buttonDot, buttonEquals, buttonPercent, buttonClear, buttonDelete, buttonSign;
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
        buttonSign = findViewById(R.id.sign_operator);
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
        buttonSign.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn0) {
            TextViewInputNumbers.append("0");
        } else if (id == R.id.btn1) {
            TextViewInputNumbers.append("1");
        } else if (id == R.id.btn2) {
            TextViewInputNumbers.append("2");
        } else if (id == R.id.btn3) {
            TextViewInputNumbers.append("3");
        } else if (id == R.id.btn4) {
            TextViewInputNumbers.append("4");
        } else if (id == R.id.btn5) {
            TextViewInputNumbers.append("5");
        } else if (id == R.id.btn6) {
            TextViewInputNumbers.append("6");
        } else if (id == R.id.btn7) {
            TextViewInputNumbers.append("7");
        } else if (id == R.id.btn8) {
            TextViewInputNumbers.append("8");
        } else if (id == R.id.btn9) {
            TextViewInputNumbers.append("9");
        } else if (id == R.id.addition) {
            calculate('+');
        } else if (id == R.id.subtraction) {
            calculate('-');
        } else if (id == R.id.mul) {
            calculate('×');
        } else if (id == R.id.division) {
            calculate('÷');
        } else if (id == R.id.equals) {
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
        } else if (id == R.id.dot) {
            if (TextViewInputNumbers.getText().length() == 0) {
                TextViewInputNumbers.append("0.");
                dotUsed = true;
            } else if (dotUsed) {
            } else if (defineLastCharacter(TextViewInputNumbers.getText().charAt(TextViewInputNumbers.getText().length() - 1) + "") == IS_OPERAND) {
                TextViewInputNumbers.setText(TextViewInputNumbers.getText() + "0.");
                dotUsed = true;
            } else if (defineLastCharacter(TextViewInputNumbers.getText().charAt(TextViewInputNumbers.getText().length() - 1) + "") == IS_NUMBER) {
                TextViewInputNumbers.setText(TextViewInputNumbers.getText() + ".");
                dotUsed = true;
            }
        } else if (id == R.id.clean) {
            TextViewInputNumbers.setText("");
            TextViewResultNumbers.setText("");
            isOpPressed = false;
        } else if (id == R.id.del) {
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
        } else if (id == R.id.sign_operator) {
            boolean operationFlag = false;
            String stringInput = TextViewInputNumbers.getText().toString();
            StringBuilder sb = new StringBuilder();
            sb.append(stringInput);
            for (int i = (stringInput.length() - 1); i >= 0; i--) {
                if (stringInput.charAt(i) == '+' || stringInput.charAt(i) == '-' || stringInput.charAt(i) == '×' || stringInput.charAt(i) == '÷') {
                    operationFlag = true;
                    if (stringInput.charAt(i) == '+') {
                        sb.setCharAt(i, '-');
                        currentOP = '-';
                    } else if (stringInput.charAt(i) == '-') {
                        sb.setCharAt(i, '+');
                        currentOP = '+';
                    } else if (stringInput.charAt(i) == '×' || stringInput.charAt(i) == '÷') {
                        sb.insert(i + 1, '-');
                    }
                    break;
                }
            }
            if (!operationFlag) {
                sb.insert(0, '-');
            }
            TextViewInputNumbers.setText(sb.toString());
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