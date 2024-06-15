package com.example.guiaejerdia11;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.example.guiaejerdia11.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private static final int MIN_CHARACTERS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        registerListener();

    }

    private void registerListener() {

        binding.passwordEditText.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence cs, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() > MIN_CHARACTERS) {
                    binding.showButton.setEnabled(true);
                }else{
                    binding.showButton.setEnabled(false);
                    hideMessage();
                }

            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        binding.showButton.setOnClickListener(view -> showMessage());
    }

    private void showMessage() {
        String message = getString(R.string.password_message, MIN_CHARACTERS);
        binding.hiddenText.setText(message);
        binding.hiddenText.setVisibility(View.VISIBLE);
    }
    private void hideMessage() {
        binding.hiddenText.setVisibility(View.INVISIBLE);
    }



}