public class Person {
    private String name;
    private int phone;

    public Person(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Телефон: " + phone;
    }
}
