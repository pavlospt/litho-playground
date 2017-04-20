package com.pavlospt.lithoplayground;

import android.widget.Toast;
import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentInfo;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Recycler;
import com.facebook.litho.widget.RecyclerBinder;
import java.util.List;

/**
 * Created by PavlosPT13 on 19/04/2017.
 */

@LayoutSpec
public class RecyclerTestSpec {

  @OnCreateLayout
  static ComponentLayout onCreateLayout(final ComponentContext c, @Prop List<String> someItems) {
    RecyclerBinder recyclerBinder = new RecyclerBinder(c);

    for (int i = 0; i < someItems.size(); i++) {
      boolean stickyTurn = i % 2 == 0;

      ComponentInfo.Builder componentInfoBuilder = ComponentInfo.create();

      componentInfoBuilder.component(
          stickyTurn ? StickyComponent.create(c).name(someItems.get(i)).build()
              : DemoListItemComponent.create(c).name(someItems.get(i)).build());
      recyclerBinder.insertItemAtAsync(recyclerBinder.getItemCount(),
          componentInfoBuilder.isSticky(i % 2 == 0).build());
    }

    return Column.create(c)
        .child(
            ButtonContainer
                .create(c)
                .listener(new ButtonContainerSpec.OnButtonClickListener() {
                    @Override
                    public void onButtonClick() {
                      Toast.makeText(c, "Foo", Toast.LENGTH_LONG).show();
                    }
                  })
                .withLayout()
                .flexShrink(1)
        )
        .build();
  }
}
