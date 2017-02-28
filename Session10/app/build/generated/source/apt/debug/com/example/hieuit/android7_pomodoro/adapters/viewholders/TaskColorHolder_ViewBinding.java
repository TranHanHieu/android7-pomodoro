// Generated code from Butter Knife. Do not modify!
package com.example.hieuit.android7_pomodoro.adapters.viewholders;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.hieuit.android7_pomodoro.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TaskColorHolder_ViewBinding implements Unbinder {
  private TaskColorHolder target;

  @UiThread
  public TaskColorHolder_ViewBinding(TaskColorHolder target, View source) {
    this.target = target;

    target.vTaskColor = Utils.findRequiredView(source, R.id.v_color_task, "field 'vTaskColor'");
    target.ivCheck = Utils.findRequiredViewAsType(source, R.id.iv_check, "field 'ivCheck'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TaskColorHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.vTaskColor = null;
    target.ivCheck = null;
  }
}
