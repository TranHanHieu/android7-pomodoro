// Generated code from Butter Knife. Do not modify!
package com.example.hieuit.android7_pomodoro.fragrment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.hieuit.android7_pomodoro.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TaskDetailFragment_ViewBinding implements Unbinder {
  private TaskDetailFragment target;

  @UiThread
  public TaskDetailFragment_ViewBinding(TaskDetailFragment target, View source) {
    this.target = target;

    target.rv_color = Utils.findRequiredViewAsType(source, R.id.rv_color, "field 'rv_color'", RecyclerView.class);
    target.etName = Utils.findRequiredViewAsType(source, R.id.et_name, "field 'etName'", EditText.class);
    target.etPayment = Utils.findRequiredViewAsType(source, R.id.et_payment, "field 'etPayment'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TaskDetailFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rv_color = null;
    target.etName = null;
    target.etPayment = null;
  }
}
