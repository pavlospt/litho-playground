package com.pavlospt.lithoplayground;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
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
import com.facebook.litho.widget.Image;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaAlign;

import static com.facebook.yoga.YogaEdge.BOTTOM;
import static com.facebook.yoga.YogaEdge.END;
import static com.facebook.yoga.YogaEdge.START;
import static com.facebook.yoga.YogaEdge.TOP;

/**
 * Created by PavlosPT13 on 19/04/2017.
 */

@LayoutSpec
class DemoListItemComponentSpec {

  @OnCreateLayout
  static ComponentLayout onCreateLayout(ComponentContext c, @Prop final String name) {
    return Column.create(c)
        .paddingDip(START, 16)
        .paddingDip(BOTTOM, 16)
        .paddingDip(TOP, 16)
        .paddingDip(END, 8)
        .child(Row.create(c)
            .alignItems(YogaAlign.FLEX_START)
            .child(Image.create(c)
                .drawableRes(R.mipmap.ic_launcher_round)
                .scaleType(ImageView.ScaleType.CENTER)
                .build())
            .child(Column.create(c)
                .flexGrow(1)
                .marginDip(START, 10)
                .child(Row.create(c)
                    .alignItems(YogaAlign.FLEX_START)
                    .child(Text.create(c)
                        .text(name)
                        .maxLines(2)
                        .ellipsize(TextUtils.TruncateAt.END)
                        .textSizeDip(18)
                        .withLayout()
                        .flexBasisPercent(80)
                        .build())
                    .child(Text.create(c)
                        .text(String.valueOf(System.currentTimeMillis() / 1000 / 1000))
                        .textSizeDip(14)
                        .textColor(c.getColor(R.color.colorPrimaryDark))
                        .withLayout()
                        .flexBasisPercent(20)
                        .marginDip(TOP, 2)
                        .build())
                    .build())
                .child(Text.create(c)
                    .text("Right below")
                    .maxLines(1)
                    .ellipsize(TextUtils.TruncateAt.END)
                    .textSizeDip(14)
                    .build()))
            .build())
        .clickHandler(DemoListItemComponent.onClick(c))
        .build();
  }

  @OnEvent(ClickEvent.class)
  static void onClick(ComponentContext c, @FromEvent View view, @Prop final String name) {
    Toast.makeText(c, name, Toast.LENGTH_LONG).show();
  }
}
