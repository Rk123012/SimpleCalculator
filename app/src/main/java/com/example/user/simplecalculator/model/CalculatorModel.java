package com.example.user.simplecalculator.model;

import com.example.user.simplecalculator.activities.MainActivity;
import com.example.user.simplecalculator.presenter.CalculatorPresenter;
import com.example.user.simplecalculator.view.CalculatorView;

/**
 * Created by User on 7/20/2018.
 */

public class CalculatorModel implements CalculatorPresenter {

    CalculatorView mcalculatorview;
    public CalculatorModel(CalculatorView calc) {
        mcalculatorview=calc;
    }

    @Override
    public void PerformAddition(double num1, double num2) {
        double addResult=num1+num2;
        mcalculatorview.ShowResult(addResult);

    }

    @Override
    public void PerformSubtraction(double num1, double num2) {
        double addResult=num1-num2;
        mcalculatorview.ShowResult(addResult);
    }

    @Override
    public void PerformMultiplication(double num1, double num2) {
        double addResult=num1*num2;
        mcalculatorview.ShowResult(addResult);
    }

    @Override
    public void PerformDivision(double num1, double num2) {
        double addResult=num1/num2;
        mcalculatorview.ShowResult(addResult);
    }
}
