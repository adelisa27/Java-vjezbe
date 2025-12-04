package projekat5;

import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.util.ArrayList;

	public class GameGUI extends JFrame {

	    private JTextField nameField, healthField, xField, yField;
	    private JRadioButton rectOption, circleOption;
	    private JButton startButton;
	    private JTextArea outputArea;

	    public GameGUI() {
	        setTitle("Game Setup");
	        setSize(500, 600);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        setLayout(new BorderLayout());

	        JPanel inputPanel = new JPanel(new GridLayout(7, 2, 5, 5));

	        inputPanel.add(new JLabel("Ime igrača:"));
	        nameField = new JTextField();
	        inputPanel.add(nameField);

	        inputPanel.add(new JLabel("Health (0–100):"));
	        healthField = new JTextField();
	        inputPanel.add(healthField);

	        inputPanel.add(new JLabel("Pozicija X:"));
	        xField = new JTextField();
	        inputPanel.add(xField);

	        inputPanel.add(new JLabel("Pozicija Y:"));
	        yField = new JTextField();
	        inputPanel.add(yField);

	        inputPanel.add(new JLabel("Collider tip:"));

	        JPanel colliderPanel = new JPanel();
	        rectOption = new JRadioButton("Rectangle", true);
	        circleOption = new JRadioButton("Circle");

	        ButtonGroup group = new ButtonGroup();
	        group.add(rectOption);
	        group.add(circleOption);

	        colliderPanel.add(rectOption);
	        colliderPanel.add(circleOption);

	        inputPanel.add(colliderPanel);

	        startButton = new JButton("Pokreni igru");
	        startButton.addActionListener(this::startGame);

	        inputPanel.add(startButton);

	        add(inputPanel, BorderLayout.NORTH);

	        outputArea = new JTextArea();
	        outputArea.setEditable(false);
	        add(new JScrollPane(outputArea), BorderLayout.CENTER);
	    }

	    private void startGame(ActionEvent e) {
	        try {
	            String name = nameField.getText().trim();
	            int hp = Integer.parseInt(healthField.getText().trim());
	            int x = Integer.parseInt(xField.getText().trim());
	            int y = Integer.parseInt(yField.getText().trim());

	            Collidable collider;

	            if (rectOption.isSelected()) {
	                collider = new RectangleCollider(x, y, 32, 32);
	            } else {
	                collider = new CircleCollider(x, y, 16);
	            }

	            Player player = new Player(name, x, y, collider, hp);

	            Game game = new Game(player);

	            ArrayList<Enemy> loaded = Game.loadEnemiesFromCSV("enemies.csv");

	            for (Enemy enemy : loaded) {
	                game.addEnemy(enemy);
	            }

	            game.resolveCollisions();

	            outputArea.setText("");

	            outputArea.append("Igrač: " + game.getPlayer() + "\n\n");

	            outputArea.append("Neprijatelji:\n");
	            for (Enemy enemy : game.getEnemies())
	                outputArea.append(" - " + enemy + "\n");

	            outputArea.append("\nKolizije:\n");
	            for (Enemy col : game.collidingWithPlayer())
	                outputArea.append(" * " + col.getDisplayName() + "\n");

	            outputArea.append("\nLog:\n");
	            for (String logEntry : game.getLog())
	                outputArea.append(" - " + logEntry + "\n");

	            if (player.getHealth() <= 0) {
	                JOptionPane.showMessageDialog(this, "Igrač je poražen!", "Game Over",
	                        JOptionPane.ERROR_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(this, "Igrač je preživio!", "Victory",
	                        JOptionPane.INFORMATION_MESSAGE);
	            }

	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(this, "Greška: " + ex.getMessage(),
	                    "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}


