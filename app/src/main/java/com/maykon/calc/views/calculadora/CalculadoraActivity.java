package com.maykon.calc.views.calculadora;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.maykon.calc.R;

public class CalculadoraActivity extends Keyboard implements CalculadoraContract.View {
    private ViewHolder _holder;
    private CalculadoraInteractor interactor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_calculadora);
        setTitle("Calculadora");
        _holder = new ViewHolder();
        listener = new KeyboardListener();
        interactor = new CalculadoraInteractor(this, listener);
        _holder.imgBack.setOnClickListener(v -> onBackPressed());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void setDisplayResult(String text){
        _holder.txtResult.setText(text);
    }

    private class ViewHolder {
        TextView txtResult;
        ImageView imgBack;

        ViewHolder(){
            imgBack = findViewById(R.id.imgBackCalc);
            txtResult = findViewById(R.id.txtResultCalc);
        }
    }
}
