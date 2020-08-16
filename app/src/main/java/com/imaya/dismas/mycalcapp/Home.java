package com.imaya.dismas.mycalcapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.imaya.dismas.mycalcapp.databinding.HomeBinding;

public class Home extends AppCompatActivity implements View.OnClickListener {
    private static String TAG = Home.class.getSimpleName();
    private HomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnAdd.setOnClickListener(this);
        binding.btnSubtract.setOnClickListener(this);
        binding.btnDivide.setOnClickListener(this);
        binding.btnMultiply.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        hideKeyboard();
        switch (v.getId()){
            case R.id.btnAdd:

                break;
            case R.id.btnSubtract:

                break;
            case R.id.btnDivide:

                break;
            case R.id.btnMultiply:

                break;
            default:
                break;
        }
    }

    private void hideKeyboard(){
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (this.getCurrentFocus() != null && inputManager != null) {
            inputManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
            inputManager.hideSoftInputFromInputMethod(this.getCurrentFocus().getWindowToken(), 0);
        }
    }
}