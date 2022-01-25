import Hierarchy.Chordata.Chordata;
import Hierarchy.Chordata.Reptilia.Crocodiles.Alligator.Alligator;
import Hierarchy.Chordata.Reptilia.Crocodiles.Alligator.AlligatorSpecies.AlligatorMississippian;
import Hierarchy.Chordata.Reptilia.Crocodiles.Crocodile.Crocodile;
import Hierarchy.Chordata.Reptilia.Crocodiles.Crocodile.CrocodileSpeceis.CrocodylusNiloticus;
import Hierarchy.Chordata.Reptilia.Crocodiles.Crocodiles;
import Hierarchy.Chordata.Reptilia.Crocodiles.Gavial.Gavial;
import Hierarchy.Chordata.Reptilia.Reptilia;
import Hierarchy.Chordata.Reptilia.Squamata.Lizard.Lizard;
import Hierarchy.Chordata.Reptilia.Squamata.Snake.Snake;
import Hierarchy.Chordata.Reptilia.Squamata.Squamata;
import Hierarchy.Chordata.Reptilia.Turtles.Turtle;
import Queue.MyQueue;
import Queue.QueueEmptyException;
import Queue.QueueFullException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        try {
            MyQueue<? extends Chordata> chordata = produce(10);
            System.out.println("Upper bound queue:\n" + chordata);
            ArrayList<MyQueue<?>> queues = consume(chordata);
            System.out.println("Lower bound queue of Mississippi Alligator:\n" + queues.get(0));
            System.out.println("Lower bound queue of Nile Crocodile:\n" + queues.get(1));
        } catch (QueueFullException | QueueEmptyException e) {
            e.printStackTrace();
        }
    }

    public static MyQueue<? extends Chordata> produce(int n) throws QueueFullException {
        MyQueue<? extends Chordata> chordata = new MyQueue<>(new ArrayDeque<Chordata>(n));
        for (int i = 0; i < n; i++) {
            chordata.add(generate());
        }
        return chordata;
    }

    public static ArrayList<MyQueue<?>> consume(MyQueue<? extends Chordata> src) throws QueueEmptyException, QueueFullException {
        Queue<Chordata> alligatorQueue = new ArrayDeque<>();
        Queue<Chordata> crocodileQueue = new ArrayDeque<>();
        while (!src.empty()) {
            Chordata animal = src.get();
            if (animal.getClass().isAssignableFrom(AlligatorMississippian.class) && animal.getClass() != AlligatorMississippian.class) {
                alligatorQueue.add(animal);
            }
            if (animal.getClass().isAssignableFrom(CrocodylusNiloticus.class) && animal.getClass() != CrocodylusNiloticus.class) {
                crocodileQueue.add(animal);
            }
        }
        MyQueue<? super AlligatorMississippian> alligator = new MyQueue<>(alligatorQueue);
        MyQueue<? super CrocodylusNiloticus> crocodile = new MyQueue<>(crocodileQueue);
        ArrayList<MyQueue<?>> queues = new ArrayList<>(2);
        queues.add(alligator);
        queues.add(crocodile);
        return queues;
    }


    public static <T extends Chordata> T generate() {
        int arg = (int) (Math.random() * 10 + 1);
        return switch (arg) {
            case 1 -> (T) new Chordata();
            case 2 -> (T) new Reptilia();
            case 3 -> (T) new Crocodiles();
            case 4 -> (T) new Turtle();
            case 5 -> (T) new Squamata();
            case 6 -> (T) new Lizard();
            case 7 -> (T) new Snake();
            case 8 -> (T) new Alligator();
            case 9 -> (T) new Crocodile();
            case 10 -> (T) new Gavial();
            default -> null;
        };
    }

}
