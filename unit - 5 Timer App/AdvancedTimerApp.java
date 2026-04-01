import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AdvancedTimerApp {
    interface TimerService {
        void startStopwatch();
        void startCountdown(int seconds);
        void stop();
        void reset();
        String getTime();
    }
    static class TimerServiceImpl implements TimerService, Runnable {
        private volatile long time = 0;
        private volatile boolean running = false;
        private volatile boolean countdownMode = false;
        private Thread thread;
        public void startStopwatch() {
            countdownMode = false;
            startThread();
        }
        public void startCountdown(int seconds) {
            countdownMode = true;
            time = seconds * 1000L;
            startThread();
        }
        private void startThread() {
            if (!running) {
                running = true;
                thread = new Thread(this);
                thread.start();
            }
        }
        public void stop() {
            running = false;
        }
        public void reset() {
            running = false;
            time = 0;
        }
        public String getTime() {
            long ms = time % 1000;
            long sec = (time / 1000) % 60;
            long min = (time / 60000);
            return String.format("%02d:%02d:%03d", min, sec, ms);
        }
        public void run() {
            try {
                while (running) {
                    Thread.sleep(10);
                    if (countdownMode) {
                        time -= 10;
                        if (time <= 0) {
                            time = 0;
                            Toolkit.getDefaultToolkit().beep();
                            running = false;
                        }
                    } else {
                        time += 10;
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }

        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
    private static void createAndShowGUI() {
        TimerService timer = new TimerServiceImpl();

        JFrame frame = new JFrame("⏱️ Timer App");
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(43, 43, 43));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel display = new JLabel("00:00:000", SwingConstants.CENTER);
        display.setFont(new Font("Monospaced", Font.BOLD, 55));
        display.setForeground(new Color(0, 255, 170));

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.setOpaque(false);
        JLabel inputLabel = new JLabel("Countdown (sec):");
        inputLabel.setForeground(Color.WHITE);
        inputLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        JTextField input = new JTextField(8);
        input.setFont(new Font("Arial", Font.PLAIN, 16));
        input.setHorizontalAlignment(JTextField.CENTER);
        
        inputPanel.add(inputLabel);
        inputPanel.add(input);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setOpaque(false);

        JButton startSW = styleButton("▶ Stopwatch", new Color(41, 128, 185));
        JButton startCD = styleButton("⏳ Countdown", new Color(142, 68, 173));
        JButton stop = styleButton("⏸ Stop", new Color(192, 57, 43));
        JButton reset = styleButton("🔄 Reset", new Color(211, 84, 0));

        buttonPanel.add(startSW);
        buttonPanel.add(startCD);
        buttonPanel.add(stop);
        buttonPanel.add(reset);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(display, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(mainPanel);
        startSW.addActionListener(e -> timer.startStopwatch());
        startCD.addActionListener(e -> {
            try {
                int sec = Integer.parseInt(input.getText().trim());
                if (sec <= 0) throw new NumberFormatException();
                timer.startCountdown(sec);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid positive number for seconds!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        stop.addActionListener(e -> timer.stop());
        reset.addActionListener(e -> {
            timer.reset();
            display.setText("00:00:000");
        });
        Timer uiTimer = new Timer(30, e -> display.setText(timer.getTime()));
        uiTimer.start();
        frame.setVisible(true);
    }
    private static JButton styleButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(bgColor);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }
}