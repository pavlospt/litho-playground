package com.pavlospt.lithoplayground;

import android.view.View;
import android.widget.Toast;
import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.SolidColor;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaAlign;

@LayoutSpec
class StickyComponentSpec {

  @OnCreateLayout
  static ComponentLayout onCreateLayout(ComponentContext c,
      @Prop final String name) {
    return Column.create(c)
        .flexGrow(1)
        .alignContent(YogaAlign.STRETCH)
        .backgroundRes(R.color.colorPrimaryDark)
        .child(Text.create(c).text(name).textSizeDip(18).textColorRes(android.R.color.white).build())
        .clickHandler(StickyComponent.onClick(c))
        .build();
  }

  @OnEvent(ClickEvent.class)
  static void onClick(ComponentContext c, @FromEvent View view, @Prop final String name) {
    Toast.makeText(c, name, Toast.LENGTH_LONG).show();
  }
}