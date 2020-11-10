package com.example.ejercicio5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.*;

import com.example.ejercicio5.ui.login.Secundaria;

public class MainActivity extends AppCompatActivity {
    boolean volvi = false;
    public int cont = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* Intent intentIni = getIntent();*/

        final TextView txtSwc =findViewById(R.id.textView6);
        final Switch swc = findViewById(R.id.switch1);

        final TextView txtSeek =findViewById(R.id.textView4);
        final SeekBar seek = findViewById(R.id.seekBar2);

        final ToggleButton tog = findViewById(R.id.toggleButton);
        final CheckBox check = findViewById(R.id.checkBox2);
        final CheckBox check1 = findViewById(R.id.checkBox);
        final CheckBox check3 = findViewById(R.id.checkBox3);
        final EditText et = findViewById(R.id.editText);
        final Button conimg = findViewById(R.id.button6);
        final TextView txtImg = findViewById(R.id.textView);
        final RatingBar rb = findViewById(R.id.ratingBar);
        final Button reinicio = findViewById(R.id.button3);
        final ImageButton imgBut = findViewById(R.id.imageButton2);
        final Button llamar = findViewById(R.id.button2);
        final RadioGroup rg = findViewById(R.id.radioGroup);
        /*final RadioButton rbut = findViewById(R.id.radioButton);
        final RadioButton rbut2 = findViewById(R.id.radioButton2);*/

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                Toast.makeText(getApplicationContext(),rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        llamar.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String number = "";
                try {
                    Integer.parseInt(et.getText().toString());
                     number = et.getText().toString();
                }catch(Exception e){
                    number = "0000000";
                }
                Uri call = Uri.parse("tel:" + number);
                Intent surf = new Intent(Intent.ACTION_DIAL, call);
                startActivity(surf);
            }
        });
       // float deVuelta = intentIni.getFloatExtra("valor",rb.getRating());

        imgBut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Secundaria.class);
                intent.putExtra("rating",rb.getRating());
                startActivityForResult(intent,1);

            }

        });
        reinicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tog.setChecked(false);
                check.setChecked(false);
                check1.setChecked(false);
                check3.setChecked(false);
                swc.setChecked(false);
                seek.setProgress(0);
                et.setText("");
                rb.setRating(0);
            }
        });
        conimg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //check.isChecked() ? cont-- : cont ++;
                if (check.isChecked()) {
                    cont--;
                } else {
                    cont++;
                }
                txtImg.setText("" + cont);
            }
        });
        tog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check.setEnabled(tog.isChecked());
            }
        });

        txtSeek.setText(seek.getProgress()+"");
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    txtSeek.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }


        } );

        swc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSwc.setText(swc.isChecked() ? swc.getTextOn() : swc.getTextOff());
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
        float deVuelta = data.getFloatExtra("valor",(float)0.5);

        final TextView txtImg = findViewById(R.id.textView);
        final RatingBar rb = findViewById(R.id.ratingBar);
        txtImg.setText(""+deVuelta);
        rb.setRating(deVuelta);
        Log.i("TAG",""+deVuelta);
        }
    }
}
