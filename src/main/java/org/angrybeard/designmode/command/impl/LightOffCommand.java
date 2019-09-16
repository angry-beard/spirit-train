package org.angrybeard.designmode.command.impl;

import org.angrybeard.designmode.command.Command;
import org.angrybeard.designmode.command.workers.Light;

public class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
