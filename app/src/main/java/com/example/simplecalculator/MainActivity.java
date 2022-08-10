package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    private TextView txtSolution,txtInput;

    private Button btn0, btn1, btn2, btn3, btn4, btn5,
            btn6, btn7, btn8, btn9, btnAllClear, btnOpenBrac,
            btnCloseBrac, btnDiv, btnMul, btnMinus, btnPlus, btnDot, btnClear, btnEqual;

    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initValue();

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = txtInput.getText().toString();
                txtInput.setText(data +"0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = txtInput.getText().toString();
                txtInput.setText(data +"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = txtInput.getText().toString();
                txtInput.setText(data +"2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = txtInput.getText().toString();
                txtInput.setText(data +"3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = txtInput.getText().toString();
                txtInput.setText(data +"4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = txtInput.getText().toString();
                txtInput.setText(data +"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = txtInput.getText().toString();
                txtInput.setText(data +"6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = txtInput.getText().toString();
                txtInput.setText(data +"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = txtInput.getText().toString();
                txtInput.setText(data +"8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = txtInput.getText().toString();
                txtInput.setText(data +"9");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = txtInput.getText().toString();
                txtInput.setText(data +".");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = txtInput.getText().toString();
                txtInput.setText(data +"+");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = txtInput.getText().toString();
                txtInput.setText(data + "-");
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtInput.getText().toString().equals("")){
                    data = txtInput.getText().toString();
                    txtInput.setText(data +"*");
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtInput.getText().toString().equals("")){
                    data = txtInput.getText().toString();
                    txtInput.setText(data +"/");
                }

            }
        });

        btnOpenBrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = txtInput.getText().toString();
                txtInput.setText(data +"(");
            }
        });

        btnCloseBrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtInput.getText().toString().equals("")){
                    if (txtInput.getText().toString().contains("(")){
                        data = txtInput.getText().toString();
                        txtInput.setText(data +")");
                    }

                }
            }
        });
        btnAllClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtInput.setText("");
                txtSolution.setText("");
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtInput.getText().toString().equals("")){
                    txtInput.setText(txtInput.getText().toString().substring(0,txtInput.getText().length()-1));
                }
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    //rhino library for the calculations
                try {
                    data = txtInput.getText().toString();

                    Context context = Context.enter();
                    context.setOptimizationLevel(-1);

                    String finalResult = "";

                    Scriptable scriptable = context.initStandardObjects();
                    finalResult= context.evaluateString(scriptable,data,"Javsscript",1,null).toString();

                    txtSolution.setText(finalResult);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Invalid input please try again", Toast.LENGTH_LONG).show();
                    txtInput.setText("");
                    txtSolution.setText("");
                }



            }
        });
    }
    //separate method to initiate buttons
    private void initValue(){

        txtInput = findViewById(R.id.txtInput);
        txtSolution = findViewById(R.id.txtSolution);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnAllClear = findViewById(R.id.btnAllClear);
        btnOpenBrac = findViewById(R.id.btnOpenBrac);
        btnCloseBrac = findViewById(R.id.btnCloseBrac);
        btnDiv = findViewById(R.id.btnDiv);
        btnMul = findViewById(R.id.btntMul);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnDot = findViewById(R.id.btnDot);
        btnClear = findViewById(R.id.btnClear);
        btnEqual = findViewById(R.id.btnEqual);

    }

}

