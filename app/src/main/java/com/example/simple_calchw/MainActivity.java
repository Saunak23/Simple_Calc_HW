package com.example.simple_calchw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CalculatorActivity";
    private Calculator mCalculator;
    private EditText mOperandOneEditText;
    private EditText mOperandTwoEditText;
    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       
        mCalculator = new Calculator();
        mResultTextView = findViewById(R.id.operation_result_text_view);
        mOperandOneEditText = findViewById(R.id.operand_one_edit_text);
        mOperandTwoEditText = findViewById(R.id.operand_two_edit_text);
    }

    public void onAdd(View view) {
        compute(Calculator.Operator.ADD);
    }

    public void onSub(View view) {
        compute(Calculator.Operator.SUB);
    }

    public void onDiv(View view) {
        try {
            compute(Calculator.Operator.DIV);
        } catch (IllegalArgumentException iae) {
            Log.e(TAG, "IllegalArgumentException", iae);
            mResultTextView.setText(getString(R.string.computationError));
        }
    }

    public void onMul(View view) {
        compute(Calculator.Operator.MUL);
    }


    private void compute(Calculator.Operator operator) {
        double operandOne;
        double operandTwo;
        try {
            operandOne = getOperand(mOperandOneEditText);
            operandTwo = getOperand(mOperandTwoEditText);
        } catch (NumberFormatException nfe) {
            Log.e(TAG, "NumberFormatException", nfe);
            mResultTextView.setText(getString(R.string.computationError));
            return;
        }

        String result;
        switch (operator) {
            case ADD:
                result = String.valueOf(mCalculator.addition(operandOne, operandTwo));
                break;
            case SUB:
                result = String.valueOf(mCalculator.subtraction(operandOne, operandTwo));
                break;
            case DIV:
                if (operandTwo == 0.0){
                    result = "Error: Division by 0";
                } else{
                    result = String.valueOf(mCalculator.division(operandOne, operandTwo));
                }
                break;
            case MUL:
                result = String.valueOf(mCalculator.multiplication(operandOne, operandTwo));
                break;
            case POW:
                result = String.valueOf(mCalculator.power(operandOne, operandTwo));
                break;
            default:
                result = getString(R.string.computationError);
                break;
        }
        mResultTextView.setText(result);
    }

    private Double getOperand(EditText operandEditText) {
        String operandText = getOperandText(operandEditText);
        if (! operandText.equals("")){
            return Double.valueOf(operandText);
        }
        else{
            Log.e(TAG, "Empty string");
            mResultTextView.setText(R.string.blank);
            return 0.0;
        }
    }

    private static String getOperandText(EditText operandEditText) {
        return operandEditText.getText().toString();
    }

    public void onPow(View view) {
        compute(Calculator.Operator.POW);
    }
}