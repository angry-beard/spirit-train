package org.angrybeard.designmode.command.impl;

import org.angrybeard.designmode.command.Command;
import org.angrybeard.designmode.command.workers.GarageDoor;

/**
 * Created by angry_beary on 2019/9/15.
 */
public class GarageDoorOpenCommand implements Command {

    private GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.open();
    }
}
