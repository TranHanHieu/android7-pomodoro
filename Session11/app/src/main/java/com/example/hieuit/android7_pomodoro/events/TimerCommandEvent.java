package com.example.hieuit.android7_pomodoro.events;

/**
 * Created by Hieu It on 3/4/2017.
 */

public class TimerCommandEvent {
    private TimerCommand command;

    public TimerCommandEvent(TimerCommand command) {
        this.command = command;
    }

    public TimerCommand getCommand() {
        return command;
    }
}
