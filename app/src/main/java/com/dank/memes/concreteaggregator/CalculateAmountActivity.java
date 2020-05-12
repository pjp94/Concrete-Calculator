package com.dank.memes.concreteaggregator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class CalculateAmountActivity extends AppCompatActivity {

  TextView results;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_calculate_amount);

    results = (TextView)findViewById(R.id.final_results);

    Bundle extras = getIntent().getExtras();

    String type = (String)extras.get("TYPE");
    String ratio = (String)extras.get("VOLUMETRIC_RATIO");
    float water = (float)extras.get("WATER_AMOUNT");
    float material = (float)extras.get("MATERIAL_AMOUNT");

    boolean isConcrete = type.equals("concrete");

    String[] ratios = ratio.split(":");

    float length = Float.parseFloat(ratios[0]);
    float width = Float.parseFloat(ratios[1]);
    float height = 0.0f;

    if (isConcrete) {
      height = Float.parseFloat(ratios[2]);
    }

    double realVolume = (length * 0.5) + (width * 0.6) + (height * (isConcrete ? 0.6 : 0));
    float realWater = (length + width + height) * (water / 100);

    String waterPercentage = water + "%";
    StringBuilder finalResults = new StringBuilder();

    finalResults.append(String.format(getString(R.string.final_values), material, type, ratio, waterPercentage) + "\n\n");
    finalResults.append(getString(R.string.cement) + " " +
            String.format(Locale.getDefault(), "%.2f", (((material * length) / realVolume) * 35.7)) + " " + getString(R.string.bags) + "\n");
    finalResults.append(getString(R.string.sand) + " " +
            String.format(Locale.getDefault(), "%.2f", ((material * width) / realVolume)) + " m3\n");

    if (isConcrete) {
      finalResults.append(getString(R.string.gravel) + " " +
              String.format(Locale.getDefault(), "%.2f", ((material * height) / realVolume)) + " m3\n");
    }

    finalResults.append(getString(R.string.water) + " " +
            String.format(Locale.getDefault(), "%.2f", ((((material * water) / realVolume) * 1000) / 15)) + " " + getString(R.string.barrels));

    results.setText(finalResults.toString());
  }
}
