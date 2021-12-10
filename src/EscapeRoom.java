import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscapeRoom {

    JPanel panel;
    JLabel creepyNarrator;
    JRadioButton choiceOne, choiceTwo, choiceThree;
    JButton endButton;
    JButton action;
    JButton sceneTwoAction;


    public static void main(String[] args) {

        new EscapeRoom();

    }




    public EscapeRoom() {

        JFrame frame = new JFrame("Escape Room");
        frame.setSize(300, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        panel = new JPanel();


        creepyNarrator = new JLabel("<html>You are in a dark room. You hear a menacing growl. You see a dimly lit candle, a flashlight, and what seems to be a a door (but it could be a trap). What do you do?");
        choiceOne = new JRadioButton("Grab the candle.");
        choiceTwo = new JRadioButton("Grab the flashlight.");
        choiceThree = new JRadioButton("Approach the door.");
        endButton = new JButton("Walk out");
        action = new JButton("GO!");
        sceneTwoAction = new JButton("GO!");

        ButtonGroup radios = new ButtonGroup();

        creepyNarrator.setBounds(20, 20, 250, 200);

        choiceOne.setBounds(20, 250, 150, 50);
        choiceTwo.setBounds(20, 300, 150, 50);
        choiceThree.setBounds(20, 350, 150, 50);

        action.setSize(100, 100);
        action.setBounds(200, 300, 80, 80);
        sceneTwoAction.setSize(100, 100);
        sceneTwoAction.setBounds(200, 300, 80, 80);
        endButton.setSize(100, 100);
        endButton.setBounds(100, 150, 100, 100);

        radios.add(choiceOne);
        radios.add(choiceTwo);
        radios.add(choiceThree);

        action.addActionListener(new actionButtonListener());
        endButton.addActionListener(new endButtonListener());
        sceneTwoAction.addActionListener(new actionSceneTwoListener());

        choiceOne.setSelected(true);

        panel.add(choiceOne);
        panel.add(choiceTwo);
        panel.add(choiceThree);
        panel.add(action);
        panel.add(creepyNarrator);

        frame.add(panel);

        panel.setLayout(null);
        frame.setVisible(true);

    }


    private class actionButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            if (choiceOne.isSelected()) {
                choiceA();
            }
            if (choiceTwo.isSelected()) {
                choiceB();
            }
            if (choiceThree.isSelected()) {
                choiceC();
            }


        }
    }


    private class endButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            creepyNarrator.setText("<html>The door was in fact a trap and you enter another room and see a flashlight, a katana, and 2 red glowing eyes. What do you do?");
            panel.remove(endButton);
            panel.add(choiceOne);
            panel.add(choiceTwo);
            panel.add(choiceThree);

            choiceOne.setText("Grab flashlight");
            choiceTwo.setText("Grab katana");
            choiceThree.setBounds(20,350,170,50);
            choiceThree.setText("Approach the red eyes");

            panel.add(sceneTwoAction);

            panel.updateUI();

        }
    }


    private class actionSceneTwoListener implements ActionListener{

        public void actionPerformed(ActionEvent actionEvent){
            if (choiceOne.isSelected()){
                choiceOneSceneTwo();
            }if (choiceTwo.isSelected()){
                choiceTwoSceneTwo();
            }if (choiceThree.isSelected()){
                choiceThreeSceneTwo();
            }
        }
    }


    public void choiceA() {
        creepyNarrator.setText("<html>When you grab the candle, it melts completely. A monster that was in the same room killed you. YOU LOSE!!!");
        panel.remove(choiceOne);
        panel.remove(choiceTwo);
        panel.remove(choiceThree);
        panel.remove(action);

        panel.updateUI();

    }


    public void choiceB() {
        creepyNarrator.setText("<html>When you try to turn on the flashlight you realize it has no batteries. The monster in the same room killed you. YOU LOSE!!!");
        panel.remove(choiceOne);
        panel.remove(choiceTwo);
        panel.remove(choiceThree);
        panel.remove(action);

        panel.updateUI();

    }


    public void choiceC() {
        creepyNarrator.setText("<html>Congrats!!! You have escaped. The door was unlocked the whole time! You have escaped and won!");
        panel.remove(choiceOne);
        panel.remove(choiceTwo);
        panel.remove(choiceThree);
        panel.remove(action);
        panel.add(endButton);

        panel.updateUI();

    }


    public void choiceOneSceneTwo(){
        creepyNarrator.setText("<html>You grab the flashlight and attempt to turn it on, only to see it has not batteries. The red eyes turn out to be a monster and it kills you. YOU LOSE!!!");
        panel.remove(choiceOne);
        panel.remove(choiceTwo);
        panel.remove(choiceThree);
        panel.remove(sceneTwoAction);

        panel.updateUI();

    }


    public void choiceTwoSceneTwo(){
        creepyNarrator.setText("<html> You intelligently grab the katana. Then, see the red eyes menacingly approach you and use your katana to slay the monster. You are safe now(for real) and are free to escape. YOU WIN!!!");
        panel.remove(choiceOne);
        panel.remove(choiceTwo);
        panel.remove(choiceThree);
        panel.remove(sceneTwoAction);

        panel.updateUI();

    }


    public void choiceThreeSceneTwo(){
        creepyNarrator.setText("<html> A foolish mistake! The red eyes were obviously a sign of danger but you still try to approach them. The eyes were the eyes of a monster and it has now killed you. YOU LOSE!!!");
        panel.remove(choiceOne);
        panel.remove(choiceTwo);
        panel.remove(choiceThree);
        panel.remove(sceneTwoAction);

        panel.updateUI();

    }

}


