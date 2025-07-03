public class DailyRoutine {
    public static void main(String[] args) {
        MakeTea teaTask = new MakeTea();
        CheckPhone phoneTask = new CheckPhone();

        teaTask.start();     
        phoneTask.start();  

        System.out.println("Started both tasks.");
    }
}

class MakeTea extends Thread {
    public void run() {
        System.out.println("Boiling water...");
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        System.out.println("Steeping the tea...");
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        System.out.println("Tea is ready!");
    }
}

class CheckPhone extends Thread {
    public void run() {
        System.out.println("Checking messages...");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        System.out.println("Replying to messages...");
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        System.out.println("Done with phone.");
    }
}

