public class  ThreadExample{

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            Thread t = new Thread(new Worker(i));
            t.start();
        }
    }

    private static class Worker implements Runnable {
        private int num;

        public Worker(int num) {
            this.num = num;
        }

        public void run() {
            System.out.println("Thread " + num + " is running");
        }
    }
}
