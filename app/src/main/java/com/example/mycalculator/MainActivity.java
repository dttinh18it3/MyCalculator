package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnPercent, btnPlus, btnMinus, btnMultiply,
    btnDivision, btnPoint, btnEqual, btnBackspace, btnAllCancel, btnBracket;
    TextView tvInput, tvOutput;
    String expression;
    Boolean checkBracket = false;
    private boolean isOpPressed = false;
    private double firstNumber = 0;
    private double secondNumber = 0;
    private char currentOp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAllCancel = findViewById(R.id.btnAllCancel);
        btnBackspace = findViewById(R.id.btnBackspace);

        btnPercent = findViewById(R.id.btnPercent);
        btnPoint = findViewById(R.id.btnPoint);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivision = findViewById(R.id.btnDivision);
        btnBracket = findViewById(R.id.btnBracket);

        btnEqual = findViewById(R.id.btnEqual);

        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);

        tvInput = findViewById(R.id.tvInput);
        tvOutput = findViewById(R.id.tvOutput);

        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = tvInput.getText().toString();
                if (expression.length() > 0) {
                    expression = expression.substring(0, expression.length()-1);
                    tvInput.setText(expression);
                }
                else if (expression.length() < 0){
                    tvInput.setText("");
                }
            }
        });
        btnAllCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tvInput.setText("");
                tvOutput.setText("");
            }
        });
        btnZero.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tvInput.append("0");
            }
        });
        btnOne.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tvInput.append("1");
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tvInput.append("2");
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tvInput.append("3");
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tvInput.append("4");
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tvInput.append("5");
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tvInput.append("6");
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tvInput.append("7");
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tvInput.append("8");
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tvInput.append("9");
            }
        });
        btnPoint.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tvInput.append(".");
            }
        });
        btnPercent.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tvInput.append("%");
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
//                expression = tvInput.getText().toString();

                tvInput.append("+");
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tvInput.append("-");
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tvInput.append("*");
            }
        });
        btnDivision.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tvInput.append("/");
            }
        });
        btnBracket.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                expression = tvInput.getText().toString();
                if (checkBracket) {
                    tvInput.append(")");
                    checkBracket = false;
                } else {
                    tvInput.append("(");
                    checkBracket = true;
                }
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                expression = tvInput.getText().toString();
                float result = 56;
                if (expression.length() > 0){
//                    tvOutput.setText(String.valueOf(result));
                    Controller(expression);
                }
                else if (expression.length() < 0){
                    tvOutput.setText("");
                }
            }
        });
    }

    private void Controller(String expression) {
        if (expression.contains("(")) {
            Bracket(expression);
        } else if(!expression.contains("+") && !expression.contains("-") && !expression.contains("/") && !expression.contains("*")){
            tvOutput.setText(expression);
        } else Controller(expression, "EMPTY");
    }

    private void Controller(String process, String small_expression) {
        System.out.println(process);
        System.out.println(small_expression);
         if (small_expression.equals("EMPTY")) {
            Controller(process, process);
        } else if (small_expression.contains("*")) {
            Multiply(process, small_expression);
        } else if (small_expression.contains("/")) {
            Division(process, small_expression);
        } else {
            PlusAndMinus(process, small_expression);
        }
    }

    private void PlusAndMinus(String process, String small_expression) {
        NumberFormat numberFormat = new DecimalFormat("###.#");
        System.out.println(process);
        System.out.println(small_expression);
        String temp_smail_expression = small_expression;
        if (temp_smail_expression.contains("+")) {
            temp_smail_expression = temp_smail_expression.replaceAll("[+]", ",+");
        } else if (temp_smail_expression.contains("-")) {
            temp_smail_expression = temp_smail_expression.replaceAll("-", ",-");
        }
        String[] operand = temp_smail_expression.split(",");
        Float result = Float.valueOf(0);
        for (String item:operand) {
            result = result + Float.parseFloat(item);
        }
        small_expression = numberFormat.format(result);
        process = process.replace(process, small_expression);
        System.out.println("r "+result);
        System.out.println("p "+process);
        System.out.println("s "+small_expression);
        Controller(process);
    }

    private String ReplaceTemporaryVariable(String process, String small_expression) {
         if (process.contains("(TEMPORARY")) {
             process = process.replace("TEMPORARY", small_expression);
         } else process = small_expression;
        return process;
    }

    private boolean IsNumber(String small_expression) {
        if (!small_expression.contains("+") && !small_expression.contains("*") && !small_expression.contains("/")){
            return true;
        } else return false;
    }


    private void Bracket(String expression) {
        String process = expression;
        int start = process.indexOf("(");
        int end = process.indexOf(")");
        String small_expression = process.substring(start+1,end);
        process = process.replace(small_expression, "TEMPORARY");
        Controller(process, small_expression);
    }

    private void Multiply(String process, String small_expression) {
        NumberFormat numberFormat = new DecimalFormat("###.#");
        int index = small_expression.indexOf("*");
        float before_number = BeforeNumber(index, small_expression);
        float after_number = AfterNumber(index, small_expression);
        float multiply_result = before_number*after_number;
        String multiply_text = numberFormat.format(before_number) + "*" + numberFormat.format(after_number);
        small_expression = small_expression.replace(multiply_text, numberFormat.format(multiply_result));
        process = ReplaceTemporaryVariable(process, small_expression);
        Controller(process);
    }

    private float AfterNumber(int index, String small_expression) {
        int n = index+1;
        String text_number = "";
        while(n > index && n < small_expression.length() && small_expression.codePointAt(n) > 47 && small_expression.codePointAt(n) < 58) {
            text_number = text_number + small_expression.charAt(n);
            n++;
        }
        return Float.parseFloat(text_number);
    }

    private float BeforeNumber(int index, String small_expression) {
        int n = index-1;
        String text_number = "";
        while(n >= 0 && small_expression.codePointAt(n) > 47 && small_expression.codePointAt(n) < 58) {
            text_number = text_number + small_expression.charAt(n);
            n--;
        }
        StringBuilder reverse = new StringBuilder(text_number);
        return Float.parseFloat(reverse.reverse().toString());
    }

    private void Division(String process, String small_expression) {
        System.out.println(small_expression);
    }
}

