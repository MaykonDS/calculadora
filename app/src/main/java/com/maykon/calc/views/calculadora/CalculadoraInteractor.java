package com.maykon.calc.views.calculadora;

import android.util.Log;

public class CalculadoraInteractor implements KeyboardListener.IKeyboardListener {
    CalculadoraContract.View view;
    private String[] numbers = {"0","0"};
    private boolean isOperation = false;
    private String operator = "";

    CalculadoraInteractor(CalculadoraContract.View view, KeyboardListener listener) {
        this.view = view;
        listener.setListener(this);
        updateNumber(numbers[0]);
    }

    private void updateNumber(String newNumber) {
        numbers[(isOperation) ? 1 : 0] = newNumber;
        if (newNumber.isEmpty())
            clear();
        view.setDisplayResult((isOperation) ? numbers[1] : numbers[0]);
    }

    private void keyTreatment(String key) {
        String number = numbers[(isOperation) ? 1 : 0];
        switch (key) {
            case "/":
            case "*":
            case "-":
            case "+":
                operator = key;
                isOperation = true;
                break;
            case ".":
                if (!number.contains(".")){
                    number = number.concat(key);
                    updateNumber(number);
                }
                break;
            case "=":
                doOperation();
                break;
            case "<":
                remove(number);
                break;
            case "X":
                clear();
                updateNumber("0");
                break;
            default:
                if (number.equals("0"))
                    number = "";
                number = number.concat(key);
                updateNumber(number);
                break;
        }
    }

    private void doOperation(){
        boolean numbersOk = (!numbers[0].equals("0") && !numbers[1].equals("0"));
        if (numbersOk && isOperation){
            float number1 = Float.parseFloat(numbers[0]);
            float number2 = Float.parseFloat(numbers[1]);
            float result = 0;
            switch(operator){
                case "/":
                    result = number1/number2;
                    break;
                case "*":
                    result = number1*number2;
                    break;
                case "-":
                    result = number1-number2;
                    break;
                case "+":
                    result = number1+number2;
                    break;
            }
            isOperation = false;
            numbers[1] = "0";
            operator = "";
            String res = String.valueOf(result);
            if (res.endsWith(".0")){
                res = res.substring(0, res.length()-2);
            }
            updateNumber(res);
        }
    }

    private void clear(){
        numbers[(isOperation)? 1 : 0] = "0";
    }

    private void remove(String number){
        if (!number.isEmpty()) {
            number = number.substring(0, number.length()-1);
            if (number.endsWith(".")) {
                remove(number);
                return;
            }
            updateNumber(number);
        }

    }

    @Override
    public void onPressed(String key) {
        Log.d("CalculadoraInteractor", "Pressed key -> " + key);
        keyTreatment(key);
    }
}
