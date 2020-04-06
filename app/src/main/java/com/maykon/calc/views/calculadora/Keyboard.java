package com.maykon.calc.views.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.maykon.calc.R;

public abstract class Keyboard extends AppCompatActivity implements View.OnClickListener {
    private Activity activity;
    public KeyboardListener listener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
    }


    @Override
    public void onClick(View v) {
        Button btnPressed = findViewById(v.getId());
        String key = btnPressed.getText().toString();
        Log.d("Keyboard", "Button text is "+key);
        listener.onPressed(key);
    }
}
