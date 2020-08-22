package com.example.mycalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText display;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            display = findViewById(R.id.textView);
            display.setShowSoftInputOnFocus(false);

            display.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if ("Enter in a Value".equals(display.getText().toString())) {
                        display.setText("");
                    }
                }
            });
    }
    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        String newStr = oldStr + strToAdd;
        display.setText(newStr);

    }
    private void clearText() {
        display.setText("");
    }

    private void eval() {
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");

        try {

            Expression exp = new Expression(userExp);

            String result = String.valueOf(exp.calculate());

            display.setText(result);
        }
        catch (Exception e) {
            e.printStackTrace();
            display.setText("e");
        }
    }

    private void delOne() {
        String oldStr = display.getText().toString();
        String newStr = "";
        if (oldStr.length() > 0) {
            newStr = oldStr.substring(0, oldStr.length()-1);
        }
        display.setText(newStr);
    }


    //buttons
    public void equalsBT(View view) {
        eval();
    }

    public void addminusBT(View view) {
        String oldStr = display.getText().toString();
        String first = "";
        if (oldStr.length() < 1) {
            display.setText("-");
        }
        else if (!oldStr.substring(0, 1).equals("-")) {

            String newStr = "-" + oldStr;
            display.setText(newStr);
        }
        else {
            String cut = oldStr.substring(1);
            display.setText(cut);
        }

    }

    public void clearBT(View view) {
        clearText();
    }

    public void backBT(View view) {
        delOne();
    }

    public void zeroBT(View view) {
        updateText("0");
    }
    public void oneBT(View view) {
        updateText("1");
    }
    public void twoBT(View view) {
        updateText("2");
    }
    public void threeBT(View view) {
        updateText("3");
    }
    public void fourBT(View view) {
        updateText("4");
    }
    public void fiveBT(View view) {
        updateText("5");
    }
    public void sixBT(View view) {
        updateText("6");
    }
    public void sevenBT(View view) {
        updateText("7");
    }
    public void eightBT(View view) {
        updateText("8");
    }
    public void nineBT(View view) {
        updateText("9");
    }
    public void piBT(View view) {
        updateText("3.14");
    }
    public void divideBT(View view) {
        updateText("÷");
    }
    public void multiplyBT(View view) {
        updateText("×");
    }
    public void subtractBT(View view) {
        updateText("-");
    }
    public void addBT(View view) {
        updateText("+");
    }
    public void pointBT(View view) {
        updateText(".");
    }


}