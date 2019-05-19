package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NoteForm {
    private JFrame jFrame;
    private Notebook notebook;
    private JPanel panel;
    private JButton buttonSave;
    private JTextField textTitle;
    private JTextArea textText;
    private JTextField textDate;
    private JLabel Text;

    NoteForm() {
        jFrame = new JFrame();
        jFrame.setContentPane(panel);
        jFrame.setVisible(true);
        jFrame.setSize(600, 400);
        buttonSave.addActionListener(new SaveListener());
    }

    NoteForm(Notebook notebook) {
        this();
        this.notebook = notebook;
        this.textTitle.setText(notebook.getTitle());
        this.textText.setText(notebook.getText());
        this.textDate.setText(notebook.getDate());
    }

    class SaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (notebook == null) {
                if (textTitle.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Write Title");
                    return;
                }
                if (textDate.getText().length() == 0) {
                    textDate.setText(LocalDate.now().toString());
                } else {
                    try {
                        LocalDate.parse(textDate.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    } catch (DateTimeException f) {
                        JOptionPane.showMessageDialog(null, "Write Date In Format YYYY-MM-DD");
                        return;
                    }
                }
                MainForm.getInstance().notebooksList.add(0, new Notebook(textTitle.getText(), textText.getText(), textDate.getText()));
                MainForm.getInstance().getDefaultListModel().add(0, textTitle.getText());
            } else {
                if (textDate.getText().length() == 0) {
                    textDate.setText(LocalDate.now().toString());
                } else {
                    try {
                        LocalDate.parse(textDate.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    } catch (DateTimeException f) {
                        JOptionPane.showMessageDialog(null, "Write Date In Format YYYY-MM-DD");
                        return;
                    }
                }
                MainForm.getInstance().getDefaultListModel().set(MainForm.getInstance().notebooksList.indexOf(notebook), textTitle.getText());
                notebook.setTitle(textTitle.getText());
                notebook.setText(textText.getText());
                notebook.setDate(textDate.getText());
            }
            jFrame.dispose();
        }
    }
}
