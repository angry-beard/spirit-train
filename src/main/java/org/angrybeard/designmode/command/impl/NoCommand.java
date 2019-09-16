package org.angrybeard.designmode.command.impl;

import org.angrybeard.designmode.command.Command;

public class NoCommand implements Command {

    @Override
    public void execute() {
        System.out.println("没有指令！");
    }

    @Override
    public void undo() {
        System.out.println("没有指令需要撤回！");
    }
}
