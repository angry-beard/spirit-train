package org.angrybeard.designmode.command;

import org.angrybeard.designmode.command.impl.GarageDoorOpenCommand;
import org.angrybeard.designmode.command.impl.LightOffCommand;
import org.angrybeard.designmode.command.impl.LightOnCommand;
import org.angrybeard.designmode.command.impl.StereoOnWithCDCommand;
import org.angrybeard.designmode.command.tasks.Stereo;
import org.angrybeard.designmode.command.workers.GarageDoor;
import org.angrybeard.designmode.command.workers.Light;

/**
 * Created by angry_beary on 2019/9/15.
 */
public class ExecuteCommand {

    public static void main(String[] args) {

        SimpleRemoteControl control = new SimpleRemoteControl();
        control.setCommand(new GarageDoorOpenCommand(new GarageDoor()));
        control.buttonWasPressed();

        System.out.println("------------------------------------");

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, new StereoOnWithCDCommand(new Stereo()), null);
        remoteControl.setCommand(1, new LightOnCommand(new Light()), new LightOffCommand(new Light()));

        remoteControl.onButtonWasPushed(1);
        System.out.println(remoteControl);
        remoteControl.offButtonWasPushed(1);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
        System.out.println(remoteControl);
    }
}
