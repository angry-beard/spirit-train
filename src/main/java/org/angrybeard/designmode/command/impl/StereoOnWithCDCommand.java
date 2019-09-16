package org.angrybeard.designmode.command.impl;

import org.angrybeard.designmode.command.Command;
import org.angrybeard.designmode.command.tasks.Stereo;

public class StereoOnWithCDCommand implements Command {

    private Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(13);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
