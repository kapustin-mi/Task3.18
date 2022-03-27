package cs.vsu.ru.kapustin;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class FrameMain extends JFrame{
    private JSpinner spinnerInputLength;
    private JButton buttonEnter;
    private JButton buttonSave;
    private JPanel panelMain;
    private JTextField textField;

    private final JFileChooser fileChooserSave;

    public FrameMain() {
        this.setTitle("Task 3");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(600, 250, 0, 0);
        this.setResizable(false);
        this.pack();

        spinnerInputLength.setModel(new SpinnerNumberModel(5, 1, 100, 1));

        fileChooserSave = new JFileChooser();
        fileChooserSave.setCurrentDirectory(new File("."));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");


        buttonEnter.addActionListener(actionEvent -> {
            QueueOfQueues queueOfQueues = new QueueOfQueues();

            int length = (int) spinnerInputLength.getValue();
            Queue<Queue<Integer>> queue = queueOfQueues.create(length);

            textField.setText(String.valueOf(queue));
        });

        buttonSave.addActionListener(actionEvent -> {
            try {
                if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    String queue = textField.getText();

                    String file = fileChooserSave.getSelectedFile().getPath();
                    if (!file.toLowerCase().endsWith(".txt")) {
                        file += ".txt";
                    }
                    Utils.writeAnswerToFile(file, queue);
                }
            } catch (Exception e) {
                String message = "Unable to save data to this file.";
                JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
