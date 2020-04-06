package com.maykon.calc.views.imc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.maykon.calc.R;

public class ImcActivity extends AppCompatActivity {
    ViewHolder _holder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        setTitle("Calculadora de IMC");
        _holder = new ViewHolder();
        _holder.btnCalcular.setOnClickListener(v -> displayImc());
    }

    private void displayImc(){
        if (isFildsEmpty()) {
            Toast.makeText(this, "Por favor preencha os campos.", Toast.LENGTH_SHORT).show();
            return;
        }
        float altura = Float.parseFloat(_holder.altura.getText().toString().replace(",","."));
        float peso = Float.parseFloat(_holder.peso.getText().toString().replace(",","."));
        float result = peso / (altura * altura);
        _holder.txtResult.setText(String.valueOf(result));
        showImageImc(result);
    }

    private boolean isFildsEmpty(){
        return _holder.altura.getText().length() == 0 || _holder.peso.getText().length() == 0;
    }

    private void showImageImc(float valor){
        _holder.imgImc.setVisibility(View.VISIBLE);
        if (valor<18.5)
            _holder.imgImc.setImageResource(R.mipmap.result_abaixo_peso);
        else if (valor>=18.5 && valor<=25){
            //normal
            _holder.imgImc.setImageResource(R.mipmap.result_normal);
        } else if (valor>=25 && valor <= 30) {
            //acima do peso
            _holder.imgImc.setImageResource(R.mipmap.result_acima_peso);
        } else if (valor >=30 && valor <= 35) {
            //obs nv 1
            _holder.imgImc.setImageResource(R.mipmap.result_obs_nv1);
        } else if (valor >=35 && valor <=40) {
            //obs nv 2
            _holder.imgImc.setImageResource(R.mipmap.result_obs_nv2);
        } else {
            //obs nv3
            _holder.imgImc.setImageResource(R.mipmap.result_obs_nv3);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private class ViewHolder {
        EditText altura, peso;
        Button btnCalcular;
        TextView txtResult;
        ImageView imgImc;

        ViewHolder(){
            altura = findViewById(R.id.txtViewAlturaImc);
            peso = findViewById(R.id.txtViewPesoImc);
            btnCalcular = findViewById(R.id.btnCalcImc);
            txtResult = findViewById(R.id.txtResultImc);
            imgImc = findViewById(R.id.imgImc);
        }
    }
}
