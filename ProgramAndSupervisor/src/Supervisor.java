public class Supervisor extends Thread {
    private Program program;
    private final Object mutex;

    public Supervisor() {
        mutex  = new Object();
        startProgram();
    }

    @Override
    public void run() {
        while (program.isAlive()) {
            synchronized (mutex) {
                while (!program.isChanged()) {
                    try {
                        mutex.wait();
                    } catch (InterruptedException e) {
                        System.out.println("supervisor was interrupted");
                    }
                }
                System.out.println("current program state: " + program.getProgramState());
                if (program.getProgramState() == MyState.FATAL_ERROR) {
                    stopProgram();
                    return;
                } else if (program.getProgramState() == MyState.UNKNOWN
                        || program.getProgramState() == MyState.STOPPING) {
                    try{
                        stopProgram();
                        mutex.wait(200);//для того, что бы поток программы успел перейти в состояние TERMINATED
                        startProgram();//для того, что бы поток программы успел перейти в состояние RUNNING
                        mutex.wait(200);
                        continue;
                    }catch (InterruptedException e) {
                      e.printStackTrace();
                    }
                }
                program.setChanged(false);
                mutex.notify();
            }
        }
    }

    private void startProgram() {
        program = new Program(mutex);
        program.start();
    }

    private void stopProgram() {
        program.getDaemon().interrupt();
        program.interrupt();
    }
}
