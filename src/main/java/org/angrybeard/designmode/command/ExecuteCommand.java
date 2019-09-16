package org.angrybeard.designmode.command;

import org.angrybeard.designmode.command.impl.GarageDoorOpenCommand;
import org.angrybeard.designmode.command.workers.GarageDoor;

/**
 * Created by angry_beary on 2019/9/15.
 */
public class ExecuteCommand {

    public static void main(String[] args) {

        SimpleRemoteControl control = new SimpleRemoteControl();
        control.setCommand(new GarageDoorOpenCommand(new GarageDoor()));
        control.buttonWasPressed();
    }
}
