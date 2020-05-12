package com.dank.memes.concreteaggregator;

import android.content.Intent;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class ChooseConcreteActivity extends AppCompatActivity {

  RadioGroup volumetricRatio;

  Button continueButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_choose_concrete);

    volumetricRatio = (RadioGroup)findViewById(R.id.radio_volumetric_ratio_concrete);

    continueButton = (Button)findViewById(R.id.concrete_continue);

    volumetricRatio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        continueButton.setEnabled(true);
      }
    });

    continueButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(ChooseConcreteActivity.this, AskWaterActivity.class);

        int id = volumetricRatio.getCheckedRadioButtonId();

        intent.putExtra("ID", id);
        intent.putExtra("TYPE", "Concrete");

        startActivity(intent);
      }
    });
  }
}
