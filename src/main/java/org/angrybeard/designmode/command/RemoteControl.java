package org.angrybeard.designmode.command;

import org.angrybeard.designmode.command.impl.NoCommand;

import java.util.Objects;

public class RemoteControl {

    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        if (!Objects.isNull(onCommand)) {
            onCommands[slot] = onCommand;
            undoCommand = onCommands[slot];
        }
        if (!Objects.isNull(offCommand)) {
            offCommands[slot] = offCommand;
            undoCommand = offCommands[slot];
        }
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n---------------------- Remote Control -------------------\n");
        for (int i = 0; i < offCommands.length; i++) {
            sb.append("[slot" + i + "]" + onCommands[i].getClass().getName()
                    + "         " + offCommands[i].getClass().getName() + "\n"
                    + "         " + undoCommand.getClass().getName());
        }
        return sb.toString();
    }
}
