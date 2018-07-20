package com.example.user.simplecalculator.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.user.simplecalculator.R;
import com.example.user.simplecalculator.presenter.CalculatorPresenter;
import com.example.user.simplecalculator.view.CalculatorView;
import com.example.user.simplecalculator.model.CalculatorModel;

public class MainActivity extends AppCompatActivity implements CalculatorView, View.OnClickListener {
    TextView textView1;
    EditText editText1, editText2;
    Button addButton, subButton, mulButton,divButton;
    CalculatorPresenter calculatorPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1=(TextView) findViewById(R.id.TextView1);
        editText1=(EditText) findViewById(R.id.edit_text1);
        editText2=(EditText) findViewById(R.id.edit_text2);
        addButton=(Button) findViewById(R.id.AddButton);
        subButton=(Button) findViewById(R.id.SubButton);
        mulButton=(Button) findViewById(R.id.MulButton);
        divButton=(Button) findViewById(R.id.DivButton);
        calculatorPresenter=new CalculatorModel(this);

        addButton.setOnClickListener(this);
        subButton.setOnClickListener( this);
        mulButton.setOnClickListener(this);
        divButton.setOnClickListener( this);

    }



    @Override
    public void onClick(View v) {
        try {
            String source1 = editText1.getText().toString();
            String source2 = editText2.getText().toString();
            double num1 = Double.parseDouble(source1);
            double num2 = Double.parseDouble(source2);


            if (v.getId() == R.id.AddButton) {
                calculatorPresenter.PerformAddition(num1, num2);
            } else if (v.getId() == R.id.SubButton) {
                calculatorPresenter.PerformSubtraction(num1, num2);
            } else if (v.getId() == R.id.MulButton) {
                calculatorPresenter.PerformMultiplication(num1, num2);
            } else if (v.getId() == R.id.DivButton) {
                calculatorPresenter.PerformDivision(num1, num2);
            }
        }
        catch (Exception e) {
            Toast.makeText(this,"Give two inputs",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void ShowResult(double result) {

        textView1.setText("Added Result is :"+result);

    }

}
