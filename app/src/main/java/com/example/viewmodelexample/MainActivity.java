package com.example.viewmodelexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    Button button;
    ButtonViewModel vModel;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            linearLayout = findViewById(R.id.linear);
            button = findViewById(R.id.toggleButton);

            vModel = new ViewModelProvider(this).get(ButtonViewModel.class);

        vModel.stateChecked.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isChecked) {
                if (isChecked == true){
                    linearLayout.setBackgroundColor(vModel.myColorGreen);
                    button.setText("POWER ON");
                }
                else {
                    linearLayout.setBackgroundColor(vModel.myColorRed);
                    button.setText("POWER OFF");
                }

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if(vModel.stateChecked.getValue() == null){
                  vModel.stateChecked.setValue(true);
              }
              else{
                  vModel.stateChecked.setValue(!vModel.stateChecked.getValue());
              }
          }
      });

        }
    }


