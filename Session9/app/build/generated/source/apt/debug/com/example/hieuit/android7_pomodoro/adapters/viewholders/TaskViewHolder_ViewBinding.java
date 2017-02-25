// Generated code from Butter Knife. Do not modify!
package com.example.hieuit.android7_pomodoro.adapters.viewholders;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.hieuit.android7_pomodoro.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TaskViewHolder_ViewBinding implements Unbinder {
  private TaskViewHolder target;

  @UiThread
  public TaskViewHolder_ViewBinding(TaskViewHolder target, View source) {
    this.target = target;

    target.vTaskColor = Utils.findRequiredView(source, R.id.v_task_color, "field 'vTaskColor'");
    target.tvTaskName = Utils.findRequiredViewAsType(source, R.id.tv_task_name, "field 'tvTaskName'", TextView.class);
    target.ibStartTimer = Utils.findRequiredViewAsType(source, R.id.ib_startTimer, "field 'ibStartTimer'", ImageButton.class);
    target.ivCheck = Utils.findRequiredViewAsType(source, R.id.iv_check1, "field 'ivCheck'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TaskViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.vTaskColor = null;
    target.tvTaskName = null;
    target.ibStartTimer = null;
    target.ivCheck = null;
  }
}
