package com.dank.memes.concreteaggregator;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  Button buttonConcrete;
  Button buttonMortar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    buttonConcrete = (Button)findViewById(R.id.main_concrete);
    buttonMortar = (Button)findViewById(R.id.main_mortar);

    buttonConcrete.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, ChooseConcreteActivity.class);
        startActivity(intent);
      }
    });

    buttonMortar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, ChooseMortarActivity.class);
        startActivity(intent);
      }
    });
  }
}
