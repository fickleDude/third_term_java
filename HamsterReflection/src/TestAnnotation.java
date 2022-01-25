import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Scanner;

public class TestAnnotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter hamster name");
        if (scanner.hasNext()) {
            String name = scanner.next();
            Hamster hamster = new Hamster(name);
            try {
                runMethods(hamster);
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Wrong input!");
        }
    }

    static void runMethods(Object object) throws InvocationTargetException, IllegalAccessException {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException();
        }
        Class<?> objectClass = object.getClass();
        for (Method method : objectClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                method.setAccessible(true);
                if (method.getReturnType().isAssignableFrom(Void.TYPE)) {
                    for (int i = 0; i < method.getAnnotation(MyAnnotation.class).value(); i++) {
                        if (method.getParameterCount() == 0)
                            method.invoke(object);
                        else if (method.getParameterTypes()[0].isAssignableFrom(Integer.TYPE)) {
                            System.out.println("Enter integer number ");
                            int arg = (new Scanner(System.in).nextInt());
                            method.invoke(object, arg);
                        }
                    }
                } else if (method.getReturnType().isAssignableFrom(Integer.TYPE)) {
                    for (int i = 0; i < method.getAnnotation(MyAnnotation.class).value(); i++) {
                        System.out.println("Hamster has slept for " + method.invoke(object) + " hours");
                    }
                }
            }
        }
    }
}
