public class Hamster {
    private String name;

    public Hamster(String name) {
        this.name = name;
    }

    @MyAnnotation(2)
    private void run() {
        System.out.println(name + " is running on wheels");
    }

    @MyAnnotation(1)
    private void drink() {
        System.out.println(name + " is drinking");
    }

    @MyAnnotation(4)
    private int hoursOfSleep() {
        return (int) (Math.random() * 10) + 3;
    }

    @MyAnnotation(5)
    private void eat(int grains) {
        System.out.println(name + " has eaten " + grains + " grains");
    }
}
