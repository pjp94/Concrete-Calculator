package com.dank.memes.concreteaggregator;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AskWaterActivity extends AppCompatActivity {

  EditText waterAmount;
  EditText materialAmount;

  TextView materialQuestion;

  Button continueButton;

  float water;
  float material;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ask_water);

    waterAmount = (EditText)findViewById(R.id.percentage_water);
    materialAmount = (EditText)findViewById(R.id.material_amount);

    materialQuestion = (TextView)findViewById(R.id.select_material_amount);

    Bundle extras = getIntent().getExtras();

    int id = (int)extras.get("ID");
    String type = (String)extras.get("TYPE");
    final String ratio;
    final String materialType;

    if (type.equals("Concrete")) {
      materialType = "concrete";
      ratio = getConcreteRatio(id);
    } else {
      materialType = "mortar";
      ratio = getMortarRatio(id);
    }

    String formattedString = String.format(getString(R.string.select_material), materialType, ratio);

    materialQuestion.setText(formattedString);

    continueButton = (Button)findViewById(R.id.water_button);

    TextWatcher watcher1 = new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override
      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        setValues();
      }

      @Override
      public void afterTextChanged(Editable editable) {

      }
    };

    TextWatcher watcher2 = new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override
      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        setValues();
      }

      @Override
      public void afterTextChanged(Editable editable) {

      }
    };

    waterAmount.addTextChangedListener(watcher1);
    materialAmount.addTextChangedListener(watcher2);

    continueButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(AskWaterActivity.this, CalculateAmountActivity.class);

        intent.putExtra("TYPE", materialType);
        intent.putExtra("VOLUMETRIC_RATIO", ratio);
        intent.putExtra("WATER_AMOUNT", water);
        intent.putExtra("MATERIAL_AMOUNT", material);

        startActivity(intent);
      }
    });
  }

  private String getConcreteRatio(int id) {
    String ratio;

    switch (id) {
      case R.id.volumetric_ratio_concrete_1:
        ratio = "1:1.5:1.5";
        break;
      case R.id.volumetric_ratio_concrete_2:
        ratio = "1:1.5:2";
        break;
      case R.id.volumetric_ratio_concrete_3:
        ratio = "1:1.5:2.5";
        break;
      case R.id.volumetric_ratio_concrete_4:
        ratio = "1:1.5:3";
        break;
      case R.id.volumetric_ratio_concrete_5:
        ratio = "1:2:2";
        break;
      case R.id.volumetric_ratio_concrete_6:
        ratio = "1:2:2.5";
        break;
      case R.id.volumetric_ratio_concrete_7:
        ratio = "1:2:3";
        break;
      case R.id.volumetric_ratio_concrete_8:
        ratio = "1:2:3.5";
        break;
      case R.id.volumetric_ratio_concrete_9:
        ratio = "1:2:4";
        break;
      case R.id.volumetric_ratio_concrete_10:
        ratio = "1:2.5:2.5";
        break;
      case R.id.volumetric_ratio_concrete_11:
        ratio = "1:2.5:3";
        break;
      case R.id.volumetric_ratio_concrete_12:
        ratio = "1:2.5:3.5";
        break;
      case R.id.volumetric_ratio_concrete_13:
        ratio = "1:2.5:4";
        break;
      default:
        ratio = "";
        break;
    }

    return ratio;
  }

  private String getMortarRatio(int id) {
    String ratio;

    switch (id) {
      case R.id.volumetric_ratio_mortar_1:
        ratio = "1:1";
        break;
      case R.id.volumetric_ratio_mortar_2:
        ratio = "1:2";
        break;
      case R.id.volumetric_ratio_mortar_3:
        ratio = "1:3";
        break;
      case R.id.volumetric_ratio_mortar_4:
        ratio = "1:4";
        break;
      case R.id.volumetric_ratio_mortar_5:
        ratio = "1:5";
        break;
      case R.id.volumetric_ratio_mortar_6:
        ratio = "1:6";
        break;
      case R.id.volumetric_ratio_mortar_7:
        ratio = "1:7";
        break;
      case R.id.volumetric_ratio_mortar_8:
        ratio = "1:8";
        break;
      default:
        ratio = "";
        break;
    }

    return ratio;
  }

  private void setValues() {
    String waterString = waterAmount.getText().toString();
    String materialString = materialAmount.getText().toString();

    if (!waterString.isEmpty() && !materialString.isEmpty()) {
      water = Float.parseFloat(waterString);
      material = Float.parseFloat(materialString);
      continueButton.setEnabled(true);
    } else {
      continueButton.setEnabled(false);
    }
  }
}
