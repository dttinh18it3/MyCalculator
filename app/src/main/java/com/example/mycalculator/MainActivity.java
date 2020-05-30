package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnPercent, btnPlus, btnMinus, btnMultiply,
    btnDivision, btnPoint, btnEqual, btnBackspace, btnAllCancel, btnBracket;
    TextView tvInput;
    TextView tvOutput;
    String expression;
    Boolean checkBracket = false;
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
        tvInput.setText("");
        tvOutput = findViewById(R.id.tvOutput);
        tvOutput.setText("");

        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = tvInput.getText().toString();
                if (expression.length() > 0) {
                    expression = expression.substring(0, expression.length()-1);
                    tvInput.setText(expression);
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
        System.out.println("input: " + tvInput.getText().toString());
        System.out.println("Output: " + tvOutput.getText().toString());
        btnPlus.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (!tvOutput.getText().toString().equals("")) {
                    tvInput.setText(tvOutput.getText().toString());
                    tvOutput.setText("");
                }
                tvInput.append("+");
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (!tvOutput.getText().toString().equals("")) {
                    tvInput.setText(tvOutput.getText().toString());
                    tvOutput.setText("");
                }
                tvInput.append("-");
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (!tvOutput.getText().toString().equals("")) {
                    tvInput.setText(tvOutput.getText().toString());
                    tvOutput.setText("");
                }
                tvInput.append("×");
            }
        });
        btnDivision.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (!tvOutput.getText().toString().equals("")) {
                    tvInput.setText(tvOutput.getText().toString());
                    tvOutput.setText("");
                }
                tvInput.append("÷");
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
                if (expression.length() > 0){
                    Controller(expression);
                }
            }
        });
    }

    private void Controller(String expression) {
        if (expression.contains("(") && expression.indexOf("(") == 0 && expression.indexOf(")") == expression.length()-1) {
            expression = expression.substring(1, expression.length()-1);
        }
        if(IsNumber(expression)){
            tvOutput.setText(expression);
        } else if (expression.contains("(")) {
            Bracket(expression);
        } else Controller(expression, "EMPTY");
    }

    private void Controller(String process, String small_expression) {
         if (small_expression.equals("EMPTY")) {
            Controller(process, process);
        } else if (small_expression.contains("×")) {
            Multiply(process, small_expression);
        } else if (small_expression.contains("÷")) {
            Division(process, small_expression);
        } else if (small_expression.contains("%")) {
             Percent(process, small_expression);
        } else {
            PlusAndMinus(process, small_expression);
        }
    }

    private void Percent(String process, String small_expression) {
        NumberFormat number_format = new DecimalFormat("##.#####");
        int index = small_expression.indexOf("%");
        float before_number = BeforeNumber(index, small_expression);
        float percent_result = before_number/100;
        String percent_text = number_format.format(before_number) + "%";
        System.out.println(percent_result);
        small_expression = small_expression.replace(percent_text, number_format.format(percent_result));
        if (process.contains("TEMPORARY")) {
            process = process.replace("TEMPORARY", small_expression);
        } else process = small_expression;
        Controller(process);
    }

    private void PlusAndMinus(String process, String small_expression) {
        NumberFormat numberFormat = new DecimalFormat("###.#");
        small_expression = "0" + small_expression;
        String temp_smail_expression = small_expression;
        if (temp_smail_expression.contains("+")) {
            temp_smail_expression = temp_smail_expression.replaceAll("[+]", ",+");
        }
        if (temp_smail_expression.contains("-")) {
            temp_smail_expression = temp_smail_expression.replaceAll("-", ",-");
        }
        String[] operand = temp_smail_expression.split(",");
        float result;
        result = (float) 0;
        for (String item:operand) {
            result = result + Float.parseFloat(item);
        }
        small_expression = numberFormat.format(result);
        if (process.contains("(TEMPORARY)")) {
            process = process.replace("(TEMPORARY)", small_expression);
        } else process = small_expression;

        System.out.println("r "+result);
        System.out.println("p "+process);
        System.out.println("s "+small_expression);
        Controller(process);
    }


    private boolean IsNumber(String small_expression) {
        int count_minus_operator = 0;
        String[] character_array = small_expression.split("");
        for (String item:character_array) {
            if (item.equals("-")) {
                count_minus_operator = count_minus_operator+1;
            }
        }
        if (!small_expression.contains("+") && !small_expression.contains("×") && !small_expression.contains("÷") && !small_expression.contains("%")){
            return !small_expression.contains("-") || small_expression.contains("-") && small_expression.indexOf("-") == 0 && count_minus_operator == 1;
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
        int index = small_expression.indexOf("×");
        float before_number = BeforeNumber(index, small_expression);
        float after_number = AfterNumber(index, small_expression);
        float multiply_result = before_number*after_number;
        String multiply_text = numberFormat.format(before_number) + "×" + numberFormat.format(after_number);
        small_expression = small_expression.replace(multiply_text, numberFormat.format(multiply_result));
        if (process.contains("TEMPORARY")) {
            process = process.replace("TEMPORARY", small_expression);
        } else process = small_expression;
        Controller(process);
    }

    private float AfterNumber(int index, String small_expression) {
        int n = index+1;
        StringBuilder text_number = new StringBuilder();
        while(n > index && n < small_expression.length() && small_expression.codePointAt(n) > 47 && small_expression.codePointAt(n) < 58) {
            text_number.append(small_expression.charAt(n));
            n++;
        }
        return Float.parseFloat(text_number.toString());
    }

    private float BeforeNumber(int index, String small_expression) {
        int n = index-1;
        StringBuilder text_number = new StringBuilder();
        while(n >= 0 && small_expression.codePointAt(n) > 47 && small_expression.codePointAt(n) < 58) {
            text_number.append(small_expression.charAt(n));
            n--;
        }
        StringBuilder reverse = new StringBuilder(text_number.toString());
        return Float.parseFloat(reverse.reverse().toString());
    }

    private void Division(String process, String small_expression) {
        NumberFormat numberFormat = new DecimalFormat("#######.#####");
        int index = small_expression.indexOf("÷");
        float before_number = BeforeNumber(index, small_expression);
        float after_number = AfterNumber(index, small_expression);
        float division_result = before_number/after_number;
        String division_text = numberFormat.format(before_number) + "÷" + numberFormat.format(after_number);
        small_expression = small_expression.replace(division_text, numberFormat.format(division_result));
        if (process.contains("TEMPORARY")) {
            process = process.replace("TEMPORARY", small_expression);
        } else process = small_expression;
        Controller(process);
    }

}

