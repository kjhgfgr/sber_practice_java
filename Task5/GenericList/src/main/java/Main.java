public class Main {
    public static void main(String[] args) {

        GenericCollection<Person> personCollection = new GenericCollection<>();

        personCollection.add(new Person("Софья", 123456));
        personCollection.add(new Person("Егор", 654321));
        personCollection.add(new Person("Сергей", 135791));
        System.out.println("Добавляем элементы");
        personCollection.printAll();

        personCollection.remove(1);
        System.out.println("\nУдаляем элемент с индексом 1");
        personCollection.printAll();

        System.out.println("\nПолучаем эелемент с индексом 0");
        Person personAtIndex0 = personCollection.get(0);
        System.out.println(personAtIndex0);

        System.out.println("\nРазмер коллекции: " + personCollection.size());
    }
}
