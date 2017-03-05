// Generated code from Butter Knife. Do not modify!
package com.example.hieuit.android7_pomodoro.fragrment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageButton;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.hieuit.android7_pomodoro.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TimerFragment_ViewBinding implements Unbinder {
  private TimerFragment target;

  @UiThread
  public TimerFragment_ViewBinding(TimerFragment target, View source) {
    this.target = target;

    target.btStartTimer = Utils.findRequiredViewAsType(source, R.id.bt_start, "field 'btStartTimer'", ImageButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TimerFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btStartTimer = null;
  }
}
