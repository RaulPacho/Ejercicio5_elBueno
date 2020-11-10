package com.example.ejercicio5.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejercicio5.MainActivity;
import com.example.ejercicio5.R;
import com.example.ejercicio5.ui.login.LoginViewModel;
import com.example.ejercicio5.ui.login.LoginViewModelFactory;

public class Secundaria extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private float rt = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        Intent intent = getIntent();

        final RatingBar rb = findViewById(R.id.ratingBar2);
        rb.setRating(intent.getFloatExtra("rating",(float)0.5));
        rt = rb.getRating();
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            rt = rating;
        }
    });
        final Button boton = findViewById(R.id.button);
    boton.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    });

    }
    @Override
    public void onBackPressed(){
       /* Intent intent = new Intent(Secundaria.this, MainActivity.class);
        intent.putExtra("valor",rt);
        startActivity(intent);*/
       Intent intent= new Intent();
       intent.putExtra("valor",rt);
       setResult(RESULT_OK,intent);
       finish();
    }
}
