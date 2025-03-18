public class HelpCommand implements Command {

    @Override
    public void execute() {
        System.out.println(" date - выводит текущую дату\n" +
                " exit - завершает работу приложения\n" +
                " time - выводит текущее время\n" +
                " pwd - выводит текущий рабочий каталог \n" +
                " help - выводит список доступных команд");
    }
}
