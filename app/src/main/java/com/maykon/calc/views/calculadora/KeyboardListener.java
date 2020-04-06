package com.maykon.calc.views.calculadora;

public class KeyboardListener {
    private IKeyboardListener listener;

    public void setListener(IKeyboardListener listener) {
        this.listener = listener;
    }

    public void onPressed(String key){
        if (listener != null)
            listener.onPressed(key);
    }

    public interface IKeyboardListener {
        void onPressed(String key);
    }
}
