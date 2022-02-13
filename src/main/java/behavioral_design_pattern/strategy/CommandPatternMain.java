package behavioral_design_pattern.strategy;

/**
 * @author a1101381
 */
public class CommandPatternMain {

    public static void main(String[] args) {
        Command lambCommand = new LambOnCommand(new Lamb());
        Command alarmCommand = new AlarmOnCommand(new Alarm());


        Button button = new Button(lambCommand);
        button.pressed();

        Button button2 = new Button(alarmCommand); // 알람 울리는 Command 설정
        button2.pressed(); // 알람 울리는 기능 수행
        button2.setCommand(lambCommand); // 다시 램프 켜는 Command로 설정
        button2.pressed(); // 램프 켜는 기능 수행
    }
}

final class Button {
    Command command;

    public Button(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressed() {
        command.execute();
    }
}


interface Command {
    void execute();
}

class Lamb {
    public void turnOn(){
        System.out.println("lamb turnOn");
    }
}

record LambOnCommand(Lamb lamb) implements Command {
    @Override
    public void execute() {
        lamb.turnOn();
        System.out.println("* lambOnCommandCommand to command ");
    }
}

/**
 * class AlarmOnCommand implements Command {
 *     private final Alarm alarm;
 *
 *     public AlarmOnCommand(Alarm alarm) {
 *         this.alarm = alarm;
 *     }
 *     @Override
 *     public void execute() {}
 * }
 */
record AlarmOnCommand(Alarm alarm) implements Command {
    @Override
    public void execute() {
        alarm.start();
        System.out.println("* AlarmOnCommand to command ");
    }
}

class Alarm {
    public void start() {
        System.out.println("Alarm wawawa ! ");
    }
}

