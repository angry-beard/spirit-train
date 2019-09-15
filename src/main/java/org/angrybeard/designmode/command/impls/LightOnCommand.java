package java.org.angrybeard.designmode.command.impls;

import java.org.angrybeard.designmode.command.Command;
import java.org.angrybeard.designmode.command.tasks.Light;

public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
