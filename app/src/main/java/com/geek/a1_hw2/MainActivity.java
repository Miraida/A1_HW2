package com.geek.a1_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView resultField;
    private TextView numberField;
    private TextView operationField;
    private Double operand = null;
    private String operation = "=";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultField = findViewById(R.id.resultField);
        numberField = findViewById(R.id.numberField);
        operationField = findViewById(R.id.operationField);
    }
    public void onClickNumber(View view){
        Button btn = (Button)view;
        numberField.append(btn.getText());
        if (operation.equals("=") && operand!=null)  operand = null;

    }
    public void onClickOperation(View view){
        Button btn = (Button)view;
        String op = btn.getText().toString();
        String num = numberField.getText().toString();
        numberField.setText(num);
        if (op.equals("C")){
            operation = "="; operand = null; operationField.setText(""); numberField.setText(""); resultField.setText("");
        }
           else {
            try {
                operation(Double.valueOf(num), op);
            } catch (NumberFormatException e) {
                numberField.setText("");
            }
            operation = op;
            operationField.setText(operation);

        }
    }

    public void operation(Double number, String str){
            if (operand == null) operand = number;
            else {
                if (operation.equals("=")) operation = str;
                switch (operation) {
                    case "=":
                        operand = number;
                        break;
                    case "+":
                        operand += number;
                        break;
                    case "-":
                        operand -= number;
                        break;
                    case "*":
                        operand *= number;
                        break;
                    case "%":
                        operand %= number;
                        break;
                    case "/":
                        if (number == 0) operand = 0.0;
                        else operand /= number;
                        break;
                }

            }
            resultField.setText(operand.toString());
            numberField.setText("");
    }
}