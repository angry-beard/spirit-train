package org.angrybeard.designmode.command.impl;

import org.angrybeard.designmode.command.Command;
import org.angrybeard.designmode.command.workers.Light;

/**
 * Created by angry_beary on 2019/9/15.
 */
public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
