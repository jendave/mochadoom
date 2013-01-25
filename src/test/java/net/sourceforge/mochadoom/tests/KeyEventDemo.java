package net.sourceforge.mochadoom.tests;

import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class KeyEventDemo extends JPanel 
                          implements KeyListener,
                                     ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    JTextArea displayArea;
    JTextField typingArea;
    static final String newline = "\n";

    public KeyEventDemo() {
        super(new BorderLayout());

        JButton button = new JButton("Clear");
        button.addActionListener(this);

        typingArea = new JTextField(20);
        typingArea.addKeyListener(this);

        //Uncomment this if you wish to turn off focus
        //traversal.  The focus subsystem consumes
        //focus traversal keys, such as Tab and Shift Tab.
        //If you uncomment the following line of code, this
        //disables focus traversal and the Tab events will
        //become available to the key event listener.
        //typingArea.setFocusTraversalKeysEnabled(false);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setPreferredSize(new Dimension(375, 125));

        add(typingArea, BorderLayout.PAGE_START);
        add(scrollPane, BorderLayout.CENTER);
        add(button, BorderLayout.PAGE_END);
    }

    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        displayInfo(e, "KEY TYPED: ");
    }

    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
        displayInfo(e, "KEY PRESSED: ");
    }

    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e) {
        displayInfo(e, "KEY RELEASED: ");
    }

    /** Handle the button click. */
    public void actionPerformed(ActionEvent e) {
        //Clear the text components.
        displayArea.setText("");
        typingArea.setText("");

        //Return the focus to the typing area.
        typingArea.requestFocusInWindow();
    }

    /*
     * We have to jump through some hoops to avoid
     * trying to print non-printing characters 
     * such as Shift.  (Not only do they not print, 
     * but if you put them in a String, the characters
     * afterward won't show up in the text area.)
     */
    protected void displayInfo(KeyEvent e, String s){
        String keyString, modString, tmpString,
               actionString, locationString;

        //You should only rely on the key char if the event
        //is a key typed event.
        int id = e.getID();
        if (id == KeyEvent.KEY_TYPED) {
            char c = e.getKeyChar();
            keyString = "key character = '" + c + "'";
        } else {
            int keyCode = e.getKeyCode();
            keyString = "key code = " + keyCode
                        + " ("
                        + KeyEvent.getKeyText(keyCode)
                        + ")";
        }

        int modifiers = e.getModifiersEx();
        modString = "modifiers = " + modifiers;
        tmpString = KeyEvent.getModifiersExText(modifiers);
        if (tmpString.length() > 0) {
            modString += " (" + tmpString + ")";
        } else {
            modString += " (no modifiers)";
        }

        actionString = "action key? ";
        if (e.isActionKey()) {
            actionString += "YES";
        } else {
            actionString += "NO";
        }

        locationString = "key location: ";
        int location = e.getKeyLocation();
        if (location == KeyEvent.KEY_LOCATION_STANDARD) {
            locationString += "standard";
        } else if (location == KeyEvent.KEY_LOCATION_LEFT) {
            locationString += "left";
        } else if (location == KeyEvent.KEY_LOCATION_RIGHT) {
            locationString += "right";
        } else if (location == KeyEvent.KEY_LOCATION_NUMPAD) {
            locationString += "numpad";
        } else { // (location == KeyEvent.KEY_LOCATION_UNKNOWN)
            locationString += "unknown";
        }

        displayArea.append(s + newline
                           + "    " + keyString + newline
                           + "    " + modString + newline
                           + "    " + actionString + newline
                           + "    " + locationString + newline);
        displayArea.setCaretPosition(displayArea.getDocument().getLength());
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("KeyEventDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new KeyEventDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
