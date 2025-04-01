import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassAnalyzer {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: java ClassAnalyzer");
            return;
        }

        String className = args[0];

        try {
            Class<?> c = Class.forName(className);
            int classModifiers = c.getModifiers();

            System.out.println("Имя класса: " + c.getName());
            System.out.println("Модификатор класса: " + Modifier.toString(classModifiers));
            System.out.println();

            System.out.println("Поля");
            Field[] fields = c.getDeclaredFields();

            for (Field field : fields) {
                int fieldModifiers = field.getModifiers();
                System.out.println("Имя: " + field.getName() +
                                ", Тип: " +  field.getType().getSimpleName() +
                        ", Модификатор: " + Modifier.toString(fieldModifiers));
            }
            System.out.println();

            System.out.println("Методы");
            Method[] methods = c.getDeclaredMethods();

            for (Method method : methods) {
                int modifiers = method.getModifiers();
                StringBuilder param = new StringBuilder();
                Class<?>[] paramTypes = method.getParameterTypes();

                for (int i = 0; i < paramTypes.length; i++) {
                    param.append(paramTypes[i].getSimpleName());
                    if (i < paramTypes.length - 1) {
                        param.append(", ");
                    }
                }

                System.out.println("Имя: " + method.getName() +
                        ", Возвращаемый тип: " + method.getReturnType().getSimpleName() +
                        "(" + param + ")" +
                        ", Модификатор: " + Modifier.toString(modifiers));
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }
    }
}

