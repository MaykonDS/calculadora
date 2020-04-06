package com.maykon.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.maykon.calc.views.calculadora.CalculadoraActivity;
import com.maykon.calc.views.imc.ImcActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Inicio");
        ViewHolder _holder = new ViewHolder();
        _holder.calculadora.setOnClickListener( v -> {
            startCalculadora();
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
        _holder.imc.setOnClickListener( v -> {
            startImc();
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

    }

    private void startCalculadora(){
        startActivity(new Intent(this, CalculadoraActivity.class));
    }

    private void startImc(){
        startActivity(new Intent(this, ImcActivity.class));
    }

    private class ViewHolder {
        LinearLayout calculadora, imc;

        ViewHolder() {
            calculadora = findViewById(R.id.lCalculadoraMain);
            imc = findViewById(R.id.lImcMain);
        }
    }
}
