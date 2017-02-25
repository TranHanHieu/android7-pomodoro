// Generated code from Butter Knife. Do not modify!
package com.example.hieuit.android7_pomodoro.fragrment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.hieuit.android7_pomodoro.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TaskFragment_ViewBinding implements Unbinder {
  private TaskFragment target;

  private View view2131558540;

  @UiThread
  public TaskFragment_ViewBinding(final TaskFragment target, View source) {
    this.target = target;

    View view;
    target.rvTask = Utils.findRequiredViewAsType(source, R.id.rv_task, "field 'rvTask'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.fab, "method 'onFabClick'");
    view2131558540 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onFabClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    TaskFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvTask = null;

    view2131558540.setOnClickListener(null);
    view2131558540 = null;
  }
}
