import javax.swing.*;

public class FrameRoutine {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RoutineFrame routineFrame = new RoutineFrame();
            routineFrame.setVisible(true);
        });
    }
}

class RoutineFrame extends JFrame {
    private JLabel teaLabel;
    private JLabel phoneLabel;

    public RoutineFrame() {
        setTitle("Daily Routine");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center on screen

        teaLabel = new JLabel("Tea Task: Starting...", SwingConstants.CENTER);
        phoneLabel = new JLabel("Phone Task: Starting...", SwingConstants.CENTER);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(teaLabel);
        add(phoneLabel);

        // Start both tasks as threads
        new Thread(new TeaTask()).start();
        new Thread(new PhoneTask()).start();
    }

    class TeaTask implements Runnable {
        public void run() {
            try {
                updateLabel(teaLabel, "Tea Task: Boiling water...");
                Thread.sleep(3000);
                updateLabel(teaLabel, "Tea Task: Adding in ingredients...");
                Thread.sleep(2000);
                updateLabel(teaLabel, "Tea Task: Steeping the tea...");
                Thread.sleep(2000);
                updateLabel(teaLabel, "Tea Task: Tea is ready!");
            } catch (InterruptedException e) {
                updateLabel(teaLabel, "Tea Task: Interrupted.");
            }
        }
    }

    class PhoneTask implements Runnable {
        public void run() {
            try {
                updateLabel(phoneLabel, "Phone Task: Checking messages...");
                Thread.sleep(2000);
                updateLabel(phoneLabel, "Phone Task: Replying to messages...");
                Thread.sleep(2000);
                updateLabel(phoneLabel, "Phone Task: Done with phone.");
            } catch (InterruptedException e) {
                updateLabel(phoneLabel, "Phone Task: Interrupted.");
            }
        }
    }

    private void updateLabel(JLabel label, String text) {
        SwingUtilities.invokeLater(() -> label.setText(text));
    }
}
