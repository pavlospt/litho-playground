package com.pavlospt.lithoplayground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(
        LithoView
            .create(this, ButtonContainer
                .create(new ComponentContext(this))
                .listener(new ButtonContainerSpec.OnButtonClickListener() {
                    @Override
                    public void onButtonClick() {
                      Toast.makeText(MainActivity.this, "Button clicked", Toast.LENGTH_LONG).show();
                    }
                })
        .build())
    );
  }
}
