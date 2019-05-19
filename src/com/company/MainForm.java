package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainForm{
    private static MainForm mainForm;
    private JPanel panel1;
    private JList list1;
    private DefaultListModel defaultListModel;
    private JButton buttonAdd;
    private JButton buttonRemove;
    private JButton buttonEdit;
    private int index = -1;
    ArrayList<Notebook> notebooksList;

    private MainForm(){
        notebooksList = new ArrayList<>();
        defaultListModel = new DefaultListModel();
        list1.setModel(defaultListModel);
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setContentPane(panel1);
        jFrame.setVisible(true);
        jFrame.setSize(500,500);
        buttonAdd.addActionListener(new AddListener());
        buttonRemove.addActionListener(new RemoveListener());
        buttonEdit.addActionListener(new EditListener());
        list1.addListSelectionListener(new ListListener());
    }
    static MainForm getInstance(){
        if (mainForm == null){
            mainForm = new MainForm();
        }
        return mainForm;
    }


    class AddListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new NoteForm();
        }
    }

    class RemoveListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (index != -1){
                notebooksList.remove(index);
                defaultListModel.remove(index);
                index = -1;
            }
        }

    }

    class EditListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (index != -1){
                new NoteForm(notebooksList.get(index));
            }
        }
    }

    class ListListener implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            index = ((JList<?>)e.getSource()).getSelectedIndex();
        }
    }

    DefaultListModel getDefaultListModel() {
        return defaultListModel;
    }
}
