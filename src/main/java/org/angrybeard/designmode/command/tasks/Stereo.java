package org.angrybeard.designmode.command.tasks;

public class Stereo {

    public void on() {
        System.out.println("打开音响！");
    }

    public void setCD() {
        System.out.println("放入CD盘！");
    }

    public void setVolume(int volume) {
        System.out.println("声音设置为" + volume);
    }

    public void off() {
        System.out.println("关闭音响！");
    }
}
