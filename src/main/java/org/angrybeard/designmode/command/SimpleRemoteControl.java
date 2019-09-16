package org.angrybeard.designmode.command;

/**
 * Created by angry_beary on 2019/9/15.
 */
public class SimpleRemoteControl {

    Command slot;

    public SimpleRemoteControl() {
    }

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
