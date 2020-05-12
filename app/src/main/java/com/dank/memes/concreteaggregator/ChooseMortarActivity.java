package com.dank.memes.concreteaggregator;

import android.content.Intent;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class ChooseMortarActivity extends AppCompatActivity {

  RadioGroup volumetricRatio;

  Button continueButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_choose_mortar);

    volumetricRatio = (RadioGroup)findViewById(R.id.radio_volumetric_ratio_mortar);
    continueButton = (Button)findViewById(R.id.mortar_continue);

    volumetricRatio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        continueButton.setEnabled(true);
      }
    });

    continueButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(ChooseMortarActivity.this, AskWaterActivity.class);

        int id = volumetricRatio.getCheckedRadioButtonId();

        intent.putExtra("ID", id);
        intent.putExtra("TYPE", "Mortar");

        startActivity(intent);
      }
    });
  }
}
