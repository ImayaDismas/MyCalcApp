package com.imaya.dismas.mycalcapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.imaya.dismas.mycalcapp.databinding.HomeBinding;

import java.util.regex.Pattern;

public class Home extends AppCompatActivity implements View.OnClickListener {
    private static String TAG = Home.class.getSimpleName();
    private HomeBinding binding;
    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

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

        onTextChangedListener();

        binding.teResult.setEnabled(false);
        binding.teResult.setCursorVisible(false);
        binding.teResult.setKeyListener(null);

        binding.tlResult.setEnabled(false);
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

    private void onTextChangedListener() {
        binding.teValue1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = binding.teValue1.getText().toString().trim();
                validateValue1(input);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.teValue2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = binding.teValue2.getText().toString().trim();
                validateValue2(input);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private boolean validateValue1(String input){
        if (TextUtils.isEmpty(input)) {
            binding.tlValue1.setError("Please input value 1");
            binding.teValue1.setBackground(ContextCompat.getDrawable(Home.this, R.drawable.error_input_background));
            return false;
        } else if (!isNumeric(input)) {
            binding.tlValue1.setError("Please input valid value 1");
            binding.teValue1.setBackground(ContextCompat.getDrawable(Home.this, R.drawable.error_input_background));
            return false;
        } else {
            binding.tlValue1.setError(null);
            binding.tlValue1.setErrorEnabled(false);
            binding.teValue1.setBackground(ContextCompat.getDrawable(Home.this, R.drawable.input_background));
            return true;
        }
    }

    private boolean validateValue2(String input){
        if (TextUtils.isEmpty(input)) {
            binding.tlValue2.setError("Please input value 2");
            binding.teValue2.setBackground(ContextCompat.getDrawable(Home.this, R.drawable.error_input_background));
            return false;
        } else if (!isNumeric(input)) {
            binding.tlValue2.setError("Please input valid value 2");
            binding.teValue2.setBackground(ContextCompat.getDrawable(Home.this, R.drawable.error_input_background));
            return false;
        } else {
            binding.tlValue2.setError(null);
            binding.tlValue2.setErrorEnabled(false);
            binding.teValue2.setBackground(ContextCompat.getDrawable(Home.this, R.drawable.input_background));
            return true;
        }
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    private void hideKeyboard(){
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (this.getCurrentFocus() != null && inputManager != null) {
            inputManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
            inputManager.hideSoftInputFromInputMethod(this.getCurrentFocus().getWindowToken(), 0);
        }
    }
}