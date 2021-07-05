import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	
	public JFrame window;
	public Container container;
	public JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel,imagePanel;
	public JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, imageLabel;
	public Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	public Font normalFont = new Font ("Candara", Font.PLAIN, 24);
	public Font normalFont2 = new Font ("Candara", Font.PLAIN, 23);
	public Font shortFont = new Font ("Times New Roman", Font.PLAIN, 10);
	public JButton startButton, continueButton, choice1, choice2, choice3, choice4;
	public JTextArea mainTextArea;
	static Font pixelMplus,pixelMplus2;
	String clickSound,introSound,musicOnOff,fightSound,excalibur,city2,forest,kingGoblin,iaycha,roar,goodEnding,musicName;
	ImageIcon excaliburImage,pulledImage,iaychaFireCutscene,kingGoblinCutscene,iaychaDeadCutscene;
	ImageIcon creditsCutscene,tuboDeLuz;	
	Color blue = new Color(1,15,28);
	Color gray = new Color(100,100,133);
	Color yellow = new Color(233,212,33);	
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();	
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	SoundEffect se = new SoundEffect();
	Music mu = new Music();
	
	ImageIcon logo = new ImageIcon(".//res//iaychaIcon.jpg");
	
	
	
//	Timer timer = new Timer();
//	TimerTask task = new TimerTask(){
//
//		@Override
//		public void run() {			
//			timer.schedule(task, 3000);
//		}
//		
//	};
	
	
	int playerHP;
	String playerName, position;
	String playerWeapon;
	String specialPower;
	String enemyName;
	String bag;
	int choice;
	int monsterHP;
	int barbaroHP;
	int enemyHP;
	int playerPotions;	
	int bagSlots;
	int powerUse;
	int kingGoblinHP;
	int dragonRing;
	int escape;
	
	boolean goblinIsDead = false;
	boolean guardIsDead = false;
	boolean enteredCityAlready = false;
	boolean oldManFinished = false;
	boolean mageFinished = false;
	boolean badKidFinished = false;
	boolean isPlayerGuilty = false;
	boolean callHappened = false;
	boolean talkIaycha = false;
	boolean lightFire = false;
	boolean searchPotions = false;
	boolean hugIaycha = false;
	boolean enteredForest = false;
	boolean promiseIaycha = false;
	boolean goodByeIaycha = false;
	boolean iaychaIsDead = false;
	boolean iaychaDeclared = false;
	boolean miracle = false;
	boolean dS1, dS2, dS3 = false;
	boolean lC1, lC2, lC3 = false;
	boolean goblinKingIsDead = false;
	

	public static void main(String[] args) {		
		
		new Game(); 
		
		
		
		
	}
		
	
	public Game() {
		
		try{
	        // load a custom font in your project folder
			pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File(".//res//dragonwarrior2.ttf")).deriveFont(18f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(".//res//dragonwarrior2.ttf")));	
			
			pixelMplus2 = Font.createFont(Font.TRUETYPE_FONT, new File(".//res//Bernadette.ttf")).deriveFont(160f);	
			GraphicsEnvironment ge1 = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge1.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(".//res//Bernadette.ttf")));		
		}
		catch(IOException | FontFormatException e){
			
		}
		
		
		
		clickSound = ".//res//buttonClick.wav";
		introSound = ".//res//intro.wav";
		fightSound = ".//res//fight.wav";
		excalibur = ".//res//excalibur.wav";
		city2 = ".//res//city2.wav";
		forest = ".//res//forest.wav";
		roar = ".//res//roar.wav";
		iaycha = ".//res//iaycha.wav";
		kingGoblin = ".//res//kingGoblin.wav";
		goodEnding = ".//res//goodEnding.wav";		
		
		musicOnOff = "off";	
		
		
		if(musicOnOff.equals("off")) {
			mu.setFile(introSound);
			mu.play();
			musicOnOff = "on";
			musicName = "introSound";			
		}		
		
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(blue);
		window.setLayout(null);		
		window.setResizable(false);
		window.setIconImage(logo.getImage());
		window.setTitle("Iaycha");
		
		container = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 250);
		titleNamePanel.setBackground(blue);
		titleNameLabel = new JLabel("Iaycha");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(pixelMplus2);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(blue);
		startButtonPanel.setLayout(new GridLayout(3,1));
		
		startButton = new JButton("START");
		startButton.setBackground(blue);
		startButton.setForeground(Color.white);
		startButton.setFont(pixelMplus);
		startButton.setFocusPainted(false);
		startButton.addActionListener(tsHandler);
		startButton.setActionCommand("start");
		
		continueButton = new JButton("CONTINUE");
		continueButton.setBackground(blue);
		continueButton.setForeground(Color.white);
		continueButton.setFont(pixelMplus);
		continueButton.setFocusPainted(false);
		continueButton.addActionListener(tsHandler);
		continueButton.setActionCommand("continue");
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		startButtonPanel.add(continueButton);
		
		container.add(titleNamePanel);
		container.add(startButtonPanel);
		window.setVisible(true);
	}

	public void createGameScreen(String titleChoice) {
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		
		imagePanel = new JPanel();
		imagePanel.setBounds(100, 100, 600, 230);
		imagePanel.setBackground(blue);		
		
		imageLabel = new JLabel();
		
		excaliburImage = new ImageIcon(".//res//excalibur.png");
		pulledImage = new ImageIcon(".//res//pulledImage.png");
		iaychaFireCutscene = new ImageIcon(".//res//iaychaFire.jpg");
		kingGoblinCutscene = new ImageIcon(".//res//kingGoblin.jpg");
		iaychaDeadCutscene = new ImageIcon(".//res//iaychaDeadCutscene.jpg");
		creditsCutscene = new ImageIcon(".//res//creditsCutscene.jpg");
		tuboDeLuz = new ImageIcon(".//res//tuboDeLuz.jpg");
		
		//imageLabel.setIcon(excaliburImage);
		imagePanel.add(imageLabel);		
		container.add(imagePanel);
		imagePanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(blue);
		container.add(mainTextPanel);				
		
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(100, 100, 600, 400);
		mainTextArea.setBackground(blue);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		mainTextPanel.setVisible(true);		
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(gray);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		container.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(pixelMplus);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(pixelMplus);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(pixelMplus);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(pixelMplus);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);		
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100,15,600,50);
		playerPanel.setBackground(blue);
	    playerPanel.setLayout(new GridLayout(1,4));
		container.add(playerPanel);
		
		hpLabel = new JLabel("Vida:");
		hpLabel.setFont(pixelMplus);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(pixelMplus);
		hpLabelNumber.setForeground(yellow);
		playerPanel.add(hpLabelNumber);
		
		weaponLabel = new JLabel("Arma:");
		weaponLabel.setFont(pixelMplus);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(pixelMplus);
		weaponLabelName.setForeground(yellow);
		playerPanel.add(weaponLabelName);		
		
		
		if (titleChoice.equals("start")) {
			playerSetUp();
		} else {
			loadData();
		}
		

	}
	
	public void loadData() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/save.txt"));
			
			playerHP = Integer.parseInt(br.readLine());
			position = br.readLine();
			playerWeapon = br.readLine();
			specialPower = br.readLine();
			bag = br.readLine();
			monsterHP = Integer.parseInt(br.readLine());
			barbaroHP = Integer.parseInt(br.readLine());
			playerPotions = Integer.parseInt(br.readLine());
			bagSlots = Integer.parseInt(br.readLine());
			kingGoblinHP = Integer.parseInt(br.readLine());	
			powerUse = Integer.parseInt(br.readLine());		
			dragonRing = Integer.parseInt(br.readLine());
			escape = Integer.parseInt(br.readLine());			
			guardIsDead = Boolean.parseBoolean(br.readLine());
			enteredCityAlready = Boolean.parseBoolean(br.readLine());
			oldManFinished = Boolean.parseBoolean(br.readLine());
			badKidFinished = Boolean.parseBoolean(br.readLine());
			mageFinished = Boolean.parseBoolean(br.readLine());			
			goblinIsDead = Boolean.parseBoolean(br.readLine());		
			isPlayerGuilty = Boolean.parseBoolean(br.readLine());
			callHappened = Boolean.parseBoolean(br.readLine());
			talkIaycha = Boolean.parseBoolean(br.readLine());
			lightFire = Boolean.parseBoolean(br.readLine());
			searchPotions = Boolean.parseBoolean(br.readLine());
			hugIaycha = Boolean.parseBoolean(br.readLine());
			enteredForest = Boolean.parseBoolean(br.readLine());
			promiseIaycha = Boolean.parseBoolean(br.readLine());
			goodByeIaycha = Boolean.parseBoolean(br.readLine());
			iaychaIsDead = Boolean.parseBoolean(br.readLine());
			iaychaDeclared = Boolean.parseBoolean(br.readLine());
			dS1 = Boolean.parseBoolean(br.readLine());
			dS2 = Boolean.parseBoolean(br.readLine());
			dS3 = Boolean.parseBoolean(br.readLine());
			lC1 = Boolean.parseBoolean(br.readLine());
			lC2 = Boolean.parseBoolean(br.readLine());
			lC3 = Boolean.parseBoolean(br.readLine());	
			goblinKingIsDead = Boolean.parseBoolean(br.readLine());
			miracle = Boolean.parseBoolean(br.readLine());
			
			br.close();
		}
		catch(Exception e) {
			
		}
		
		weaponLabelName.setText(playerWeapon);
		hpLabelNumber.setText(""+playerHP);
		
		switch (position) {
		case "city2": city2(); break;
		case "newJourney5": newJourney5(); break;
		case "lastDay6": lastDay6(); break;
		}
	
	}
	
	
	
	public void saveGame() {
		try {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/save.txt"));
			
			bw.write(""+playerHP);
			bw.newLine();
			bw.write(""+position);
			bw.newLine();
			bw.write(playerWeapon);
			bw.newLine();
			bw.write(specialPower);
			bw.newLine();
			bw.write(bag);
			bw.newLine();
			bw.write(""+monsterHP);
			bw.newLine();
			bw.write(""+barbaroHP);
			bw.newLine();
			bw.write(""+playerPotions);
			bw.newLine();
			bw.write(""+bagSlots);
			bw.newLine();
			bw.write(""+kingGoblinHP);
			bw.newLine();
			bw.write(""+powerUse);
			bw.newLine();
			bw.write(""+dragonRing);
			bw.newLine();
			bw.write(""+escape);
			bw.newLine();			
			bw.write(""+guardIsDead);
			bw.newLine();
			bw.write(""+enteredCityAlready);
			bw.newLine();
			bw.write(""+oldManFinished);
			bw.newLine();
			bw.write(""+badKidFinished);
			bw.newLine();
			bw.write(""+mageFinished);
			bw.newLine();
			bw.write(""+goblinIsDead);
			bw.newLine();
			bw.write(""+isPlayerGuilty);
			bw.newLine();
			bw.write(""+callHappened);
			bw.newLine();
			bw.write(""+talkIaycha);
			bw.newLine();
			bw.write(""+lightFire);
			bw.newLine();
			bw.write(""+searchPotions);
			bw.newLine();
			bw.write(""+hugIaycha);
			bw.newLine();
			bw.write(""+enteredForest);
			bw.newLine();
			bw.write(""+promiseIaycha);
			bw.newLine();
			bw.write(""+goodByeIaycha);
			bw.newLine();
			bw.write(""+iaychaIsDead);
			bw.newLine();
			bw.write(""+iaychaDeclared);
			bw.newLine();
			bw.write(""+dS1);
			bw.newLine();
			bw.write(""+dS2);
			bw.newLine();
			bw.write(""+dS3);
			bw.newLine();
			bw.write(""+lC1);
			bw.newLine();
			bw.write(""+lC2);
			bw.newLine();
			bw.write(""+lC3);
			bw.newLine();
			bw.write(""+goblinKingIsDead);
			bw.newLine();
			bw.write(""+miracle);
			bw.newLine();
			
			bw.close();
		}
		catch(Exception e) {
			
		}
	}

	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			String titleChoice = event.getActionCommand();
			
			se.setFile(clickSound);
			se.play();
			switch(titleChoice) {
			case "start":
				createGameScreen("start");
				break;
			case "continue":
				createGameScreen("continue");
				break;
			}
		}
		
	}
	
	public class ChoiceHandler implements ActionListener{
		/*	
		 * 
		 * Button Handler	  
		 * 
		 * 
		 * */
		public void actionPerformed(ActionEvent event) {
			String userChoice = event.getActionCommand();
			
			se.setFile(clickSound);
			se.play();
			
			if (position.equals("townGate") && userChoice.equals("c1")) {
				talkGuard();
				
				
				}
			else if (position.equals("talkGuard") && userChoice.equals("c1")) {
				talkGuard2();		
				}		
			else if  (position.equals("townGate") && userChoice.equals("c2")) {						
				attackGuard();		
			}
			else if (position.equals("townGate") && userChoice.equals("c3")) {						
				crossRoad();		
			}
			else if (position.equals("talkGuard2") && userChoice.equals("c1") 
					|| position.equals("attackGuard") && userChoice.equals("c1") 
					|| position.equals("crossRoad") && userChoice.equals("c3") ) {						
				townGate();				
			}
			else if (position.equals("crossRoad") && userChoice.equals("c1")) {
				north();
			}
			
			else if (position.equals("north") && userChoice.equals("c1")) {
				north2();
			}
			else if (position.equals("crossRoad") && userChoice.equals("c2")) {
				east();
			}
			else if (position.equals("east") && userChoice.equals("c1")) {
				eastCutscene();
			}
			
			else if (position.equals("eastCutscene") && userChoice.equals("c1")) {
				east2();
			}
			else if (position.equals("killedGuard") && userChoice.equals("c1")) {
				city1();
			}
			else if (position.equals("city1") && userChoice.equals("c1")) {
				city2();
			}
			
			else if (position.equals("!pulled") && userChoice.equals("c2")
					|| position.equals("pulledCutscene") && userChoice.equals("c4")) {
				crossRoad();
			}
			
			else if (position.equals("pulled") && userChoice.equals("c4")) {
				pulledCutscene();
			}
			else if (position.equals("!pulled") && userChoice.equals("c1")) {
				east2();
			}
			
			else if (position.equals("crossRoad") && userChoice.equals("c4")) {
				west();
			}
			
			else if (position.equals("east3") && userChoice.equals("c1")) {
				east4();
			}
			else if (position.equals("east4") && userChoice.equals("c1")) {
				attackEnemy("Bárbaro");
			}
			else if (position.equals("east4") && userChoice.equals("c2")) {
				cantRun();
			}
			else if (position.equals("cantRun") && userChoice.equals("c1")) {
				east4();
			}			
			else if (position.equals("attackingEnemy") && userChoice.equals("c1")) {
				attackEnemy("Bárbaro");
			}
			else if (position.equals("attackingEnemy") && userChoice.equals("c3")){
				usePotion2();
				}
			else if (position.equals("usingPower") && userChoice.equals("c1")){
				attackEnemy("Bárbaro");
				}
			else if (position.equals("usingPower") && userChoice.equals("c3")){
				usePotion2();
				}
			
			else if (position.equals("attackingEnemy") && userChoice.equals("c4")
					|| position.equals("usingPotion2") && userChoice.equals("c4")
					|| position.equals("usingPower") && userChoice.equals("c4")){
				usePower();
				}
			
			else if (position.equals("ending") && userChoice.equals("c4")){
				city1();
				}
			
			
			else if (position.equals("north2") && userChoice.equals("c1") 
					|| position.equals("east2") && userChoice.equals("c2")
					|| position.equals("east3") && userChoice.equals("c2")					
					|| position.equals("east") && userChoice.equals("c2")
					|| position.equals("staringGoblin") && userChoice.equals("c2")
					|| position.equals("fightGoblin") && userChoice.equals("c2")
					|| position.equals("attackingGoblin") && userChoice.equals("c2")
					|| position.equals("win") && userChoice.equals("c1")
					|| position.equals("afterDestruction") && userChoice.equals("c1")
					|| position.equals("usingPotion") && userChoice.equals("c2")
					|| position.equals("townGate2") && userChoice.equals("c2")
					|| position.equals("townGate3") && userChoice.equals("c3")
					|| position.equals("east3_1") && userChoice.equals("c2")) {
				crossRoad();
			}	
			
			else if (position.equals("staringGoblin") && userChoice.equals("c1")){
				fightGoblin();				
			}
			
			else if (position.equals("fightGoblin") && userChoice.equals("c1")){
				attack();				
			}
			
			else if (position.equals("attackingGoblin") && userChoice.equals("c1") 
					|| position.equals("usingPotion") && userChoice.equals("c1")){
				attack();				
			}
			
			
			
			
			else if (position.equals("attackingGoblin") && userChoice.equals("c3")
					|| position.equals("usingPotion") && userChoice.equals("c3")					
					|| position.equals("fightGoblin") && userChoice.equals("c3")
					){
				usePotion();			
			}			
			
			else if (position.equals("usingPotion2") && userChoice.equals("c3")) {
				usePotion2();
			}
			else if (position.equals("usingPotion2") && userChoice.equals("c4")) {
				usePower();
			}
			
			else if (position.equals("usingPotion2") && userChoice.equals("c1")) {
				attackEnemy("Bárbaro");
			}
			
			else if (position.equals("dead") && userChoice.equals("c1")){
				loadData();				
			}
			
			// ----------------------INSIDE CITY INTERATIONS -----------------		
			
			else if (position.equals("oldMan1") && userChoice.equals("c2")
					|| position.equals("oldMan3") && userChoice.equals("c2")
					|| position.equals("townGate2") && userChoice.equals("c1")
					|| position.equals("oldManFinished") && userChoice.equals("c1")
					|| position.equals("badKid1") && userChoice.equals("c2")
					|| position.equals("badKid3") && userChoice.equals("c2")
					|| position.equals("badKidFinished") && userChoice.equals("c1")
					|| position.equals("mage1") && userChoice.equals("c2")
					|| position.equals("mageFinished") && userChoice.equals("c2")
					|| position.equals("call4") && userChoice.equals("c1")
					){
				city2();				
			}
			else if (position.equals("enteredCityAlready") && userChoice.equals("c1")) {
				townGate();
			}
			else if (position.equals("townGate3") && userChoice.equals("c1")) {
				talkGuard();
			}
			else if (position.equals("townGate3") && userChoice.equals("c2")) {
				city1();
			}
			else if (position.equals("talkGuard2") && userChoice.equals("c1")) {
				townGate();
			}
			
			// ----------------------CITY2 DIRECTIONS -----------------			
			else if (position.equals("city2") && userChoice.equals("c1")){
				oldMan1();				
			}			
			else if (position.equals("city2") && userChoice.equals("c2")){
				badKid1();			
			}			
			else if (position.equals("city2") && userChoice.equals("c3")){
				mage1();				
			}			
			else if (position.equals("city2") && userChoice.equals("c4")){
				townGate();				
			}
			
			// ----------------------OLDMAN INTERATIONS -----------------	
			else if (position.equals("oldMan1") && userChoice.equals("c1")){
				oldMan2();				
			}
			else if (position.equals("oldMan2") && userChoice.equals("c1")){
				oldMan3();				
			}
			else if (position.equals("oldMan3") && userChoice.equals("c1")){
				oldMan4();				
			}
			else if (position.equals("oldMan4") && userChoice.equals("c1")){
				oldMan5();				
			}
			else if (position.equals("oldMan5") && userChoice.equals("c1")){
				city2();				
			}
			
			// ----------------------BAD KID INTERATIONS -----------------	
			else if (position.equals("badKid1") && userChoice.equals("c1")){
							badKid2();				
						}
			else if (position.equals("badKid2") && userChoice.equals("c1")){
							badKid3();				
						}
			else if (position.equals("badKid3") && userChoice.equals("c1")){
							badKid4();				
						}
			else if (position.equals("badKid4") && userChoice.equals("c1")){
							city2();				
						}
			
			// ----------------------MAGO INTERATIONS -----------------	
			else if (position.equals("mage1") && userChoice.equals("c1")){
							mage2();
						}
			else if (position.equals("mage2") && userChoice.equals("c1")){
				mage3();
			}
			else if (position.equals("mage3") && userChoice.equals("c1")){
				mage4();
			}
			else if (position.equals("mage4") && userChoice.equals("c1")){
				mage4_1();
			}
			else if (position.equals("mage4_1") && userChoice.equals("c1")){
				mage4_2();
			}
			else if (position.equals("mageGuardKilled") && userChoice.equals("c1")) {
				mage4_2();
			}
			else if (position.equals("mage4_2") && userChoice.equals("c1")){
				mage4_3();
			}
			else if (position.equals("mage4_3") && userChoice.equals("c1")){
				mage5();
			}
			else if (position.equals("mage5") && userChoice.equals("c1")){
				city2();
			}
			else if (position.equals("mageFinished") && userChoice.equals("c1")){
				mageFutureRead();
			}
			else if (position.equals("mageFutureRead") && userChoice.equals("c1")
					|| position.equals("mage3") && userChoice.equals("c2")
					){
				city2();
			}
							
			
			// THE KING CALLING			
			else if (position.equals("call") && userChoice.equals("c1")){
				call2();				
			}
			
			else if (position.equals("call2") && userChoice.equals("c1")){
				call3();				
			}
			else if (position.equals("call3") && userChoice.equals("c1")){
				call4();				
			}
			else if (position.equals("captured") && userChoice.equals("c1")){
				captured2();				
			}
			else if (position.equals("captured2") && userChoice.equals("c1")){
				dead();				
			}			
			else if (position.equals("east3_1") && userChoice.equals("c1")){
				newJourney();
			}
			
			// NEW JOURNEY!!!
			else if (position.equals("newJourney") && userChoice.equals("c1")){
				newJourney2();
			}
			else if (position.equals("newJourney2") && userChoice.equals("c1")){
				newJourney3();
			}
			else if (position.equals("newJourney3") && userChoice.equals("c1")){
				newJourney4();
			}
			
			// TALK FIRECAMP FIRST NIGHT!
			
			else if (position.equals("newJourney4") && userChoice.equals("c1")
					|| position.equals("shiva3") && userChoice.equals("c1")
					|| position.equals("iaycha3") && userChoice.equals("c1")
					|| position.equals("ravi") && userChoice.equals("c1")){
				newJourney5();
			}
			
			else if (position.equals("newJourney5") && userChoice.equals("c1")){
				shiva();
			}
			else if (position.equals("shiva") && userChoice.equals("c1")){
				shiva2();
			}
			else if (position.equals("shiva2") && userChoice.equals("c1")){
				shiva3();
			}
			else if (position.equals("newJourney5") && userChoice.equals("c2")){
				iaycha();
			}
			else if (position.equals("iaycha") && userChoice.equals("c1")){
				iaychaFireCutscene();
			}
			else if (position.equals("iaychaFireCutscene") && userChoice.equals("c1")){
				iaycha2();
			}
			else if (position.equals("iaycha") && userChoice.equals("c1")){
				iaycha2();
			}
			else if (position.equals("iaycha2") && userChoice.equals("c1")){
				iaycha3();
			}
			else if (position.equals("newJourney5") && userChoice.equals("c3")){
				ravi();
			}
			else if (position.equals("newJourney5") && userChoice.equals("c4")){
				sleep();
			}
			
			// ENTERING FOREST
			else if (position.equals("sleep") && userChoice.equals("c1")){
				forest();
			}
			else if (position.equals("forest") && userChoice.equals("c1")){
				forest2();
			}
			else if (position.equals("forest2") && userChoice.equals("c1")){
				forest3();
			}
			else if (position.equals("forest3") && userChoice.equals("c1")){
				attackEnemy("Bárbaro");
			}
			else if (position.equals("attackingEnemy") && userChoice.equals("c2")){
				cantRunForest();
			}
			else if (position.equals("cantRunForest") && userChoice.equals("c1")){
				attackEnemy("Bárbaro");
			}
			else if (position.equals("winBarbaro") && userChoice.equals("c1")){
				forest4();
			}
			else if (position.equals("forest4") && userChoice.equals("c1")){
				forest5();
			}
			else if (position.equals("forest5") && userChoice.equals("c1")){
				forest6();
			}
			else if (position.equals("forest6") && userChoice.equals("c1")){
				forest7();
			}
			else if (position.equals("forest7") && userChoice.equals("c1")){
				sleepIaycha();
			}
			else if (position.equals("forest7") && userChoice.equals("c2")){
				sleepAlone();
			}
			else if (position.equals("sleepIaycha") && userChoice.equals("c1")
					|| position.equals("sleepAlone") && userChoice.equals("c1")){
				lastDay();
			}
			
			else if (position.equals("lastDay") && userChoice.equals("c1")){
				lastDay1();
			}
			else if (position.equals("lastDay1") && userChoice.equals("c1")){
				lastDay2();
			}
			else if (position.equals("lastDay2") && userChoice.equals("c1")){
				lastDay3();
			}
			else if (position.equals("lastDay3") && userChoice.equals("c1")){
				lastDay4();
			}
			else if (position.equals("lastDay4") && userChoice.equals("c1")){
				lastDay5();
			}
			else if (position.equals("lastDay5") && userChoice.equals("c1")
					|| position.equals("talkIaycha") && userChoice.equals("c1")
					|| position.equals("lightFire") && userChoice.equals("c1")
					|| position.equals("searchPotions") && userChoice.equals("c1")
					|| position.equals("hugIaycha") && userChoice.equals("c1")){
				lastDay6();
			}
			
			else if (position.equals("lastDay6") && userChoice.equals("c1")){
				talkIaycha();
			}
			else if (position.equals("lastDay6") && userChoice.equals("c2")){
				lightFire();
			}
			else if (position.equals("lastDay6") && userChoice.equals("c3")){
				searchPotions();
			}
			else if (position.equals("lastDay6") && userChoice.equals("c4")){
				hugIaycha();
			}
			else if (position.equals("endLastDay") && userChoice.equals("c1")){
				endLastDay2();
			}
			else if (position.equals("endLastDay2") && userChoice.equals("c1")){
				dDay();
			}
			else if (position.equals("dDay") && userChoice.equals("c1")){
				dDay2();
			}
			else if (position.equals("dDay2") && userChoice.equals("c1")){
				dDay3();
			}
			else if (position.equals("dDay3") && userChoice.equals("c1")){
				dDayAttack();
			}
			else if (position.equals("dDayAttack") && userChoice.equals("c1")
					|| position.equals("dDayHide") && userChoice.equals("c1")){
				dDayAttack2();
			}
			else if (position.equals("dDay3") && userChoice.equals("c2")){
				dDayHide();		
				}
			else if (position.equals("dDayAttack2") && userChoice.equals("c1")){
				kingGoblinCutscene();
			}
			else if (position.equals("kingGoblinCutscene") && userChoice.equals("c1")){
				fightKingGoblin();
			}
			
			else if (position.equals("kGless50") && userChoice.equals("c3")){
				promiseIaycha();
			}
			else if (position.equals("kGless50") && userChoice.equals("c4")){
				goodByeIaycha();
			}
			else if (position.equals("tuboDeLuz") && userChoice.equals("c1")){
				tuboDeLuzCutscene();
			}
			else if (position.equals("promiseIaycha") && userChoice.equals("c1")
					||position.equals("goodByeIaycha") && userChoice.equals("c1")
					||position.equals("kGless20") && userChoice.equals("c1")
					||position.equals("tuboDeLuzCutscene") && userChoice.equals("c1")){
				fightKingGoblin();
			}
			else if (position.equals("fightKingGoblin") && userChoice.equals("c1")
					|| position.equals("attackKingGoblin") && userChoice.equals("c1")
					|| position.equals("cantRun2") && userChoice.equals("c1")
					|| position.equals("usingPotion3") && userChoice.equals("c1")
					|| position.equals("usingPower3") && userChoice.equals("c1")){
				attackKingGoblin();
			}
			else if (position.equals("fightKingGoblin") && userChoice.equals("c2")
					||position.equals("attackKingGoblin") && userChoice.equals("c2")
					|| position.equals("usingPotion3") && userChoice.equals("c1")
					|| position.equals("usingPower3") && userChoice.equals("c2")){
				cantRun2();
			}			
			else if (position.equals("fightKingGoblin") && userChoice.equals("c3")
					||position.equals("attackKingGoblin") && userChoice.equals("c3")
					|| position.equals("usingPotion3") && userChoice.equals("c3")
					|| position.equals("usingPower3") && userChoice.equals("c3")){
				usePotion3();
			}
			else if (position.equals("fightKingGoblin") && userChoice.equals("c4")
					||position.equals("attackKingGoblin") && userChoice.equals("c4")
					|| position.equals("usingPotion3") && userChoice.equals("c4")
					|| position.equals("usingPower3") && userChoice.equals("c4")){
				usePower3();
			}
			
			else if (position.equals("lastChapter") && userChoice.equals("c1")){
				lastChapter2();
			}
			else if (position.equals("lastChapter") && userChoice.equals("c2")){
				lastChapter2_0();
			}
			else if (position.equals("lastChapter2") && userChoice.equals("c1")
					|| position.equals("lastChapter2_0") && userChoice.equals("c1")
					|| position.equals("talkGuardian") && userChoice.equals("c1")
					|| position.equals("searchIaycha") && userChoice.equals("c1")
					|| position.equals("escape") && userChoice.equals("c1")){
				dreamSequence();
			}
			else if (position.equals("dreamSequence") && userChoice.equals("c1")){
				talkGuardian();
			}
			else if (position.equals("dreamSequence") && userChoice.equals("c2")){
				searchIaycha();
			}
			else if (position.equals("dreamSequence") && userChoice.equals("c3")){
				escape();
			}
			else if (position.equals("mirror") && userChoice.equals("c1")){
				mirror2();
			}
			else if (position.equals("mirror2") && userChoice.equals("c1")){
				tryingEscape();
			}
			else if (position.equals("tryingEscape") && userChoice.equals("c1")){
				mirror2();
			}
			else if (position.equals("lastChapter2_1") && userChoice.equals("c4")){
				lastChapter3();
			}
			else if (position.equals("lastChapter3") && userChoice.equals("c1")){
				lastChapter3_1();
			}
			else if (position.equals("lastChapter3_1") && userChoice.equals("c1")){
				iaychaDeadCutscene();
			}
			else if (position.equals("iaychaDeadCutscene") && userChoice.equals("c1")){
				lastChapter3_2();			
			}			
			else if (position.equals("lastChapter3_2") && userChoice.equals("c1")){
				lastChapter4();
			}
			else if (position.equals("lastChapter4") && userChoice.equals("c1")){
				lastChapter4_1();
			}
			else if (position.equals("lastChapter4_1") && userChoice.equals("c1")){
				lastChapter4_2();
			}
			else if (position.equals("lastChapter4_2") && userChoice.equals("c1")){
				lastChapter4_3();
			}
			else if (position.equals("lastChapter4_3") && userChoice.equals("c1")){
				lastChapter5();
			}
			else if (position.equals("lastChapter5") && userChoice.equals("c1")){
				lastChapter6();
			}
			else if (position.equals("lastChapter6") && userChoice.equals("c1")){
				lastChapter6_1();
			}
			else if (position.equals("lastChapter6_1") && userChoice.equals("c1")){
				lastChapter6_2();
			}
			else if (position.equals("lastChapter6_2") && userChoice.equals("c1")){
				crossRoad();
			}			
			else if (position.equals("lastChapter7") && userChoice.equals("c1")){
				lastChapter8();
			}
			else if (position.equals("lastChapter8") && userChoice.equals("c1")
					|| position.equals("lastMago2") && userChoice.equals("c1")
					|| position.equals("lastOldMan") && userChoice.equals("c1")
					|| position.equals("partyTime") && userChoice.equals("c1")){
				lastChapter9();
			}
			else if (position.equals("lastChapter9") && userChoice.equals("c3")){
				partyTime();
			}
			else if (position.equals("lastChapter9") && userChoice.equals("c2")){
				lastMago();
			}
			else if (position.equals("lastMago") && userChoice.equals("c1")){
				lastMago2();
			}
			
			else if (position.equals("lastChapter9") && userChoice.equals("c1")){
				lastOldMan();
			}
			else if (position.equals("goodEnding") && userChoice.equals("c1")){
				creditsCutscene();
			}
			else if (position.equals("eastLast") && userChoice.equals("c1")){
				crossRoad();
			}
			
		}
	}
	
	
	
	public void playerSetUp() {

		playerHP = 20;
		position = "playerSetUp";
		playerWeapon = "Nenhuma";
		specialPower = "";
		bag = "Bolso";
		monsterHP = 30;
		barbaroHP = 40;
		playerPotions = 0;
		bagSlots = 4;
		kingGoblinHP = 300;	
		powerUse = 0;		
		dragonRing = 0;
		escape = 0;		
		callHappened = false;
		guardIsDead = false;
		enteredCityAlready = false;
		oldManFinished = false;
		badKidFinished = false;
		mageFinished = false;
		escape = 0;	
		goblinIsDead = false;		
		isPlayerGuilty = false;
		callHappened = false;
		talkIaycha = false;
		lightFire = false;
		searchPotions = false;
		hugIaycha = false;
		enteredForest = false;
		promiseIaycha = false;
		goodByeIaycha = false;
		iaychaIsDead = false;
		iaychaDeclared = false;
		dS1 = false;
		dS2 = false;
		dS3 = false;
		lC1 = false;
		lC2 = false;
		lC3 = false;
		goblinKingIsDead = false;
		miracle = false;
					
		weaponLabelName.setText(playerWeapon);
		hpLabelNumber.setText(""+playerHP);
		
		townGate();
		
	} 
	


	public void townGate() {
		
		if(musicOnOff.equals("on") && !musicName.equals("introSound") && !musicName.equals("iaycha") ){
			mu.stop();				
			mu.setFile(introSound);
			mu.play();
			musicOnOff = "on";
			musicName = "introSound";
		}
		
		if (guardIsDead) {
		position = "townGate2";
			
		mainTextArea.setText("Você está no portão da cidade.\n");
			
		choice1.setText("Entrar na cidade");
		choice2.setText("Ir embora");
		choice3.setText("");
		choice4.setText("");
		}
		
		else if (enteredCityAlready) {
			
			position = "townGate3";					
			mainTextArea.setText("Você está no portão da cidade.\nUm guarda está parado na sua frente.\n\nO que você irá fazer?");
			choice1.setText("Falar com o guarda");
			choice2.setText("Entrar na cidade");
			choice3.setText("Ir embora");
			choice4.setText("");
		
		}
		
		else {
		position = "townGate";
		
		mainTextArea.setText("Você está no portão de uma cidade.\nUm guarda está parado na sua frente.\n\nO que você irá fazer?");
		
		choice1.setText("Falar com o guarda");
		choice2.setText("Atacar o guarda");
		choice3.setText("Ir embora");
		choice4.setText("");
		}
		
		
		
	}
	
	public void talkGuard() {
		position = "talkGuard";
		if (dragonRing == 1) {
			ending();
		}
		else if (goblinKingIsDead) {
			position = "talkGuard2";
			mainTextArea.setText("Guarda: ''Nobre Guerreiro! Você completou sua missão!''");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		else if (enteredCityAlready) {
			position = "talkGuard2";
			mainTextArea.setText("Guarda: ''Olá Nobre Guerreiro. Obrigado pelos seus \nserviços prestados para nossa comunidade.''");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
				
		
		else {
			
			position = "talkGuard";
			mainTextArea.setText("Guarda: ''Olá estrangeiro. Desculpe...'' \n\n''Não te conheço, não posso permitir que \nestranhos entrem na cidade.''\n");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");	
			
			
		}	
			
	}
	
	public void talkGuard2() {		
				
		position = "talkGuard2";		
		mainTextArea.setText("Guarda: ''Mas ouça... Existe um monstro solto por aí. \n\nMate-o e retorne para cá. Prove seu valor! \n\nEntão, o deixarei entrar na cidade...''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
		}	
			
	
	
	public void attackGuard() {
		saveGame();
		
		if (playerWeapon.equals("Excalibur")) {
			position = "killedGuard";
			guardIsDead = true;
			isPlayerGuilty = true;
			mainTextArea.setText("Guarda: ''Argh... Essa áurea azul na sua espada. \nÉ a Excalibur! Não pode ser... Minha morte será \nvingada!''\n\nO Guarda morreu. \n\nO caminho para entrar na cidade está livre agora.");
			choice1.setText("Entrar");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");		}
		
		else {
		position = "attackGuard";
		mainTextArea.setText("Guarda: ''Ei, não seja estúpido.''\n\nO guarda te acertou tão forte que você decidiu \nnão atacar mais.\n\n(Você recebeu 3 pontos de dano)");
		playerHP -= 3;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		if (playerHP <= 0) {
			dead();	}}
				
	}
	

	public void crossRoad() {
		
		mainTextPanel.setVisible(true);		
		imagePanel.setVisible(false);	
		
		position = "east2";			
		position = "crossRoad";
		mainTextArea.setText("Agora você está em uma encruzilhada. \n\nSe você for para o SUL, retornará para \no portão da cidade.\n\n");
		choice1.setText("Ir para o NORTE.");
		choice2.setText("Ir para o LESTE.");
		choice3.setText("Ir para o SUL.");
		choice4.setText("Ir para o OESTE.");
		
		if(musicOnOff.equals("on") && !musicName.equals("introSound") && !musicName.equals("iaycha")){
			mu.stop();				
			mu.setFile(introSound);
			mu.play();
			musicOnOff = "on";
			musicName = "introSound";
		}
	}
	
	public void north() {
		position = "north";
		if (bag.equals("Bolso") && playerPotions == 4 || bag.equals("Cinto") && playerPotions == 10) {
			playerPotions--;		
			}	
		
		playerPotions++;
		mainTextArea.setText("Você encontrou um lindo rio. Aproveitou para \nbeber água e descansar um pouco. \n\nTambém colheu algumas folhas mágicas e criou uma \npoção de vida.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
		
	}
	
	public void north2() {
		position = "north2";		
		mainTextArea.setText("Você guardou a Poção de Vida em seu "+bag+"\n\nVocê poderá beber Poções de Vida em momentos de \ndesespero. \n\nPoções de vida equipadas: "+playerPotions+"\n"+bag+" ("+bagSlots+" Slots)");
		choice1.setText("Voltar");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}	
	
	public void eastCutscene() {
		mainTextPanel.setVisible(false);
		imageLabel.setIcon(excaliburImage);
		imagePanel.setVisible(true);		
		position = "eastCutscene";	
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void east() {	
		
		if (goblinKingIsDead) {
			position = "eastLast";
			mainTextArea.setText("Você acabou de voltar da Floresta.");
			choice1.setText("Sair");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		else if (playerWeapon.equals("Excalibur") || playerWeapon.equals("DragonRing")) {
			east3();
		} 
		
		
		else{
			if(musicOnOff.equals("on") && !musicName.equals("excalibur")){
				mu.stop();				
				mu.setFile(excalibur);
				mu.play();
				musicOnOff = "on";
				musicName = "excalibur";
			}
		position = "east";
		mainTextArea.setText("Você andou um pouco pela floresta e encontrou \numa gigante pedra, com uma espada atravessada \ndentro dela. \n\nA espada está enferrujada, parece que esteve ali por \nMUITO tempo. Na pedra está escrito: ''Excalibur''");
		choice1.setText("Pegar");
		choice2.setText("Voltar");
		choice3.setText("");
		choice4.setText("");}
		
		
	}
	
	
	
	public void east2() {
		mainTextPanel.setVisible(true);
		imageLabel.setIcon(excaliburImage);
		imagePanel.setVisible(false);	
		position = "east2";
			
		double pull = new java.util.Random().nextDouble()*5;
		System.out.println(pull);
		
		if (pull > 4.90) {	
			position = "pulled";
			mainTextArea.setText("Sua alma se uniu com seus braços, você juntou \nforças e...CONSEGUIU! \n\nVocê retira a espada e aponta para o alto, em sinal de \nvitória. Uma áurea azul clara rodeia o metal da espada.\n\n(Excalibur equipada - Inflige 0-8 Pontos de Dano)");
			playerWeapon = "Excalibur";
			weaponLabelName.setText(playerWeapon);
			choice1.setText("");
			choice2.setText("");
			choice3.setText("");
			choice4.setText(">");}	
		
		else if (pull > 2.0){
		position = "!pulled";	
		mainTextArea.setText("Você firmou os pés no chão colocando toda sua força \nem seus braços, e... \nNão conseguiu. \n\nMas a espada se moveu minimamente, o suficiente \npara lhe dar esperanças de tentar novamente.");
		choice1.setText("Tentar");
		choice2.setText("Desistir");
		choice3.setText("");
		choice4.setText("");}	
		else {
			position = "!pulled";	
			mainTextArea.setText("Você se apoiou na pedra, puxou a espada para trás e...Não conseguiu. \n\nA espada nem se moveu.\n\n''Talvez eu devesse tentar várias vezes seguidas \nsem parar, sem desistir, uma hora ela sai!''");
			choice1.setText("Tentar");
			choice2.setText("Desistir");
			choice3.setText("");
			choice4.setText("");
		}
		
		}
	
	public void pulledCutscene() {
		mainTextPanel.setVisible(false);
		imageLabel.setIcon(pulledImage);
		imagePanel.setVisible(true);		
		position = "pulledCutscene";	
		
	/*	mainTextPanel.setVisible(true);
		imageLabel.setIcon(excaliburImage);
		imagePanel.setVisible(false);	
		position = "east2";*/
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText(">");
	}	
	
	
	public void east3() {
		if (callHappened) {
			position = "east3_1";	
			mainTextArea.setText("Você observa a densa floresta na sua frente. \n\nNota também que tem 1 rapaz e 2 garotas em volta de \numa fogueira.");
			choice1.setText("Falar");		
			choice2.setText("Voltar");
			choice3.setText("");
			choice4.setText("");
		}
		else {
		position = "east3";	
		mainTextArea.setText("Você observa a densa floresta na sua frente. \n\nSeria EXTREMAMENTE perigoso adentrar nela sem uma \ngrande quantidade de mantimentos para semanas. \n\nOu sem uma equipe para lhe ajudar nas \npossíveis ameaças.");
		choice1.setText("Entrar");		
		choice2.setText("Voltar");
		choice3.setText("");
		choice4.setText("");
		}
		
		
	}
	
	public void east4() {
		position = "east4";	
		if(musicOnOff.equals("on") && !musicName.equals("fight")){
			mu.stop();				
			mu.setFile(fightSound);
			mu.play();
			musicOnOff = "on";
			musicName = "fight";
		}
		mainTextArea.setText("Você encontrou um Bárbaro!");
		choice1.setText("Atacar");		
		choice2.setText("Fugir");
		choice3.setText("");
		choice4.setText("");		
	}
	
	public void cantRun() {
		position = "cantRun";	
		mainTextArea.setText("Seu inimigo é muito mais rápido que você. \n\nTentar fugir agora é suicidio!");
		choice1.setText("Atacar");		
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	public void cantRun2() {
		position = "cantRun2";	
		mainTextArea.setText("Não tem para onde fugir agora. Esta é a batalha final.");
		choice1.setText("Atacar");		
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	
	public void cantRunForest() {
		position = "cantRunForest";	
		mainTextArea.setText("Seu inimigo é muito mais rápido que você. \n\nTentar fugir agora é suicidio!");
		choice1.setText("Atacar");		
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}

	public void west() {
		
		position = "west";
		
		if (!goblinIsDead) {
			
			if(musicOnOff.equals("on") && !musicName.equals("fightSound")){
				mu.stop();				
				mu.setFile(fightSound);
				mu.play();
				musicOnOff = "on";
				musicName = "fightSound";
			}	
			
			position = "staringGoblin";
			
			mainTextArea.setText("Você encontrou um Goblin Assustador!\n\nVocê olha para sua arma ("+ playerWeapon +") e pensa no \nque fazer.");
			choice1.setText("Lutar");
			choice2.setText("Fugir");
			choice3.setText("");
			choice4.setText("");
			
			
			
		}		
		else {
			position = "afterDestruction";
			mainTextArea.setText("Você olha ao redor e vê apenas destruição, \ncausada pela tua feroz batalha com o Goblin.");
			choice1.setText("Voltar");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			
			}
		
		
	}

	public void fightGoblin() {
		
	position = "fightGoblin";		
		
		mainTextArea.setText("O Goblin está na sua frente. Ele é gigantesco e \naterrorizante.\n\n''Será que tenho ferramentas para vencê-lo?''\n\nPontos de Vida do Goblin: " + monsterHP + "\nSua arma: "+playerWeapon);
		choice1.setText("Lutar!");
		choice2.setText("Correr");
		choice3.setText("Poção de Vida "+"("+playerPotions+")");
		choice4.setText("");		
		
	}

	public void attack() {
		position = "attackingGoblin";
		int playerDamage = 0;

		if (playerWeapon.equals("Nenhuma")) {
			playerDamage = new java.util.Random().nextInt(3);
		} else if (playerWeapon.equals("Excalibur")) {
			playerDamage = new java.util.Random().nextInt(8);
		}
		
		monsterHP -= playerDamage;		

		if (monsterHP < 1) {
			win();
			
		} else if (monsterHP > 0) {
			
			int monsterDamage = 0;
			monsterDamage = new java.util.Random().nextInt(4);			
			
			playerHP -= monsterDamage;
			hpLabelNumber.setText(""+playerHP);
			
			if (playerHP < 1) {
				dead();
			} else if (playerHP > 0) {
				mainTextArea.setText("Você o atacou e infligiu " + playerDamage + " pontos de dano!\n\n" + "Seus Pontos de Vida: " + playerHP+""+ "\nPontos de Vida do Goblin: " + monsterHP+""+"\n\nO monstro lhe atacou e infligiu " + monsterDamage + " pontos de dano!");
				choice1.setText("Atacar!");
				choice2.setText("Correr");
				choice3.setText("Poção de Vida "+"("+playerPotions+")");
				choice4.setText("");
			}
		}

	}
	
	public void attackEnemy(String enemyName) {
		
		if(musicOnOff.equals("on") && !musicName.equals("fight")){
			mu.stop();				
			mu.setFile(fightSound);
			mu.play();
			musicOnOff = "on";
			musicName = "fight";
		}
		
		position = "attackingEnemy";
		int playerDamage = 0;

		if (playerWeapon.equals("Nenhuma")) {
			playerDamage = new java.util.Random().nextInt(3);
		} else if (playerWeapon.equals("Excalibur")) {
			playerDamage = new java.util.Random().nextInt(8);
		}
		
		barbaroHP -= playerDamage;		

		if (barbaroHP < 1) {
			win2(enemyName, enemyHP);
			
		} else if (barbaroHP > 0) {
			
			int monsterDamage = 0;
			monsterDamage = new java.util.Random().nextInt(4);			
			
			playerHP -= monsterDamage;
			hpLabelNumber.setText(""+playerHP);
			
			if (playerHP < 1) {
				dead();
			} else if (playerHP > 0) {
				mainTextArea.setText("Você o atacou e infligiu " + playerDamage + " pontos de dano!\n\n" + "Seus Pontos de Vida: " + playerHP+""+ "\nPontos de Vida do "+enemyName+":"+ barbaroHP+""+"\n\nO inimigo lhe atacou e infligiu " + monsterDamage + " pontos de dano!");
				choice1.setText("Atacar!");
				choice2.setText("Correr");
				choice3.setText("Poção de Vida "+"("+playerPotions+")");
				choice4.setText(""+specialPower+" ("+powerUse+")");
			}
		}

	}
	
	public void usePotion() {
		position = "usingPotion";
		
		int monsterDamage = 0;
		monsterDamage = new java.util.Random().nextInt(2);
		
		if (playerPotions > 0) {
			
			playerHP +=3;
			playerHP -= monsterDamage;
			playerPotions--;
			hpLabelNumber.setText(""+playerHP);
			
			mainTextArea.setText("Você desesperadamente bebeu uma Poção de Vida.\n(Você recuperou 3 pontos de vida)\n\nO monstro ficou furioso e lhe atacou, porém o dano \nfoi minimo. (Você tomou "+monsterDamage+" de dano)");
			choice1.setText("Atacar");
			choice2.setText("Correr");
			choice3.setText("Poção de Vida "+"("+playerPotions+")");
			choice4.setText(""+specialPower);
		}
		else {
			playerHP -= monsterDamage;
			hpLabelNumber.setText(""+playerHP);
			mainTextArea.setText("Você tentou beber uma Poção de Vida, mas não tem \nnenhuma.\n\nO monstro ficou furioso e lhe atacou, porém o dano \nfoi minimo. (Você tomou "+monsterDamage+" de dano)");
			choice1.setText("Atacar");
			choice2.setText("Correr");
			choice3.setText("Poção de Vida "+"("+playerPotions+")");
			choice4.setText(""+specialPower);
		}
	}
	
	public void usePotion2() {
		position = "usingPotion2";
		
		int monsterDamage = 0;
		monsterDamage = new java.util.Random().nextInt(2);
		
		if (playerPotions > 0) {
			
			playerHP +=3;
			playerHP -= monsterDamage;
			playerPotions--;
			hpLabelNumber.setText(""+playerHP);
			
			mainTextArea.setText("Você desesperadamente bebeu uma Poção de Vida.\n(Você recuperou 3 pontos de vida)\n\nO monstro ficou furioso e lhe atacou, porém o dano \nfoi minimo. (Você tomou "+monsterDamage+" de dano)");
			choice1.setText("Atacar");
			choice2.setText("Correr");
			choice3.setText("Poção de Vida "+"("+playerPotions+")");
			choice4.setText(""+specialPower);
		}
		else {
			playerHP -= monsterDamage;
			hpLabelNumber.setText(""+playerHP);
			mainTextArea.setText("Você tentou beber uma Poção de Vida, mas não tem \nnenhuma.\n\nO monstro ficou furioso e lhe atacou, porém o dano \nfoi minimo. (Você tomou "+monsterDamage+" de dano)");
			choice1.setText("Atacar");
			choice2.setText("Correr");
			choice3.setText("Poção de Vida "+"("+playerPotions+")");
			choice4.setText(""+specialPower);
		}
	}
	
	public void usePower() {
		position = "usingPower";		
		
		if (specialPower.equals("Tubo de Luz") && powerUse >=1) {
			
			playerHP +=50;			
			powerUse--;
			hpLabelNumber.setText(""+playerHP);
			
			mainTextArea.setText("Você realizou uma oração para o Deus-Luz, pedindo triunfo nesta batalha. \n\nVocê foi revestido por um Tubo de Luz Branca.\n\n(Você recuperou 50 pontos de vida)");
			choice1.setText("Atacar");
			choice2.setText("Correr");
			choice3.setText("Poção de Vida "+"("+playerPotions+")");
			choice4.setText(""+specialPower+" ("+powerUse+")");
		}
		else {			
			hpLabelNumber.setText(""+playerHP);
			mainTextArea.setText("Você tentou usar um Poder, mas não tem nenhum \nno momento");
			choice1.setText("Atacar");
			choice2.setText("Correr");
			choice3.setText("Poção de Vida "+"("+playerPotions+")");
			choice4.setText(""+specialPower+" ("+powerUse+")");
		}
	}
	public void usePower3() {
		position = "usingPower3";		
		
		if (specialPower.equals("Tubo de Luz") && powerUse >=1) {
			
			playerHP +=50;			
			powerUse--;
			hpLabelNumber.setText(""+playerHP);
			
			mainTextArea.setText("Você realizou uma oração para o Deus-Luz, pedindo triunfo nesta batalha. \n\nVocê foi revestido por um Tubo de Luz Branca.\n\n(Você recuperou 50 pontos de vida)");
			choice1.setText("Atacar");
			choice2.setText("Correr");
			choice3.setText("Poção de Vida "+"("+playerPotions+")");
			choice4.setText(""+specialPower+" ("+powerUse+")");
		}
		else {			
			hpLabelNumber.setText(""+playerHP);
			mainTextArea.setText("Você tentou usar um Poder, mas não tem nenhum \nno momento");
			choice1.setText("Atacar");
			choice2.setText("Correr");
			choice3.setText("Poção de Vida "+"("+playerPotions+")");
			choice4.setText(""+specialPower+" ("+powerUse+")");
		}
	}

	public void dead() {
		position = "dead";
		playerHP = 0;
		hpLabelNumber.setText(""+playerHP);
		mainTextArea.setText("Você Morreu...");
		choice1.setText("Recomeçar");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");

	}

	public void win() {
		
		position = "win";
		if (guardIsDead) {
		mainTextArea.setText("Você matou o monstro! Ele virou cinzas. \n\nAgora só restou um anel dourado caído no chão, \ncom a face de um dragão. Você pega e guarda ele.\n\n");
		choice1.setText("Voltar");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
		dragonRing = 0;
		playerWeapon = "Excalibur";
		weaponLabelName.setText(playerWeapon);		
		goblinIsDead = true;	
		}
		else {
			
		mainTextArea.setText("Você matou o monstro! Ele virou cinzas. \n\nAgora só restou um anel dourado caído no chão, \ncom a face de um dragão. Você pega e guarda ele.\n\n''Talvez agora o guarda enxergue o meu valor!''");
		choice1.setText("Voltar");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");	
		dragonRing = 1;
		playerWeapon = "DragonRing";
		weaponLabelName.setText(playerWeapon);
		
		goblinIsDead = true;	
		}		
		
		
				

	}
	
		public void win2(String enemyName, int enemyHP) {
		
		if (enteredForest) {
			position = "winBarbaro";
			mainTextArea.setText("Você matou o "+enemyName+"!");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		} else {
		position = "win";
		mainTextArea.setText("Você matou o "+enemyName+"!");
		choice1.setText("Voltar");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		}

	}

	public void ending() {
		
		position = "ending";
		mainTextArea.setText("Guarda: Duvido. Você matou o Goblin que tanto \nnos atormentava? Prove.\n\n...Esse é o lendário Anel do Dragão!!! \n\nVocê matou ele mesmo! Você realmente é alguém que \npodemos confiar. Seja bem-vindo à cidade! ");
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("Entrar");
		playerWeapon = "Excalibur";
		weaponLabelName.setText(playerWeapon);
		enteredCityAlready = true;
		dragonRing--;
		
		} 
	
	/*
	 * 
	 * CITY EVENTS
	 * 
	 * */
	
	public void city1() {
		if (goblinKingIsDead) {
			lastChapter7();
		}
		else {
		position = "city1";
		mainTextArea.setText("É quase um vilarejo, com ruas bem estreitas, cheio \nde casinhas e pequenos comércios. \n\nAs pessoas andam para todos os lados decidindo o \nque comprar. \n\nBarulho por todo lado, parece uma grande feira.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
		if(musicOnOff.equals("on") && !musicName.equals("city2")){
			mu.stop();				
			mu.setFile(city2);
			mu.play();
			musicOnOff = "on";
			musicName = "city2";
		}
		}
				
	}
	
	
	public void city2() {		
		
		if (oldManFinished == true && mageFinished == true && !callHappened) {
			call();
		}
		
		else if (oldManFinished == true && badKidFinished == true && guardIsDead == true && !mageFinished) {
			captured();
		}		
		
		else {
			position = "city2";
		mainTextArea.setText("Você está agora no centro da cidade. \n\nPara onde você irá? Se você for para o SUL, retornará \npara o portão da cidade.\n\n(Seu progresso foi salvo!)");
		choice1.setText("Ir para o NORTE");
		choice2.setText("Ir para o LESTE");
		choice3.setText("Ir para o OESTE");
		choice4.setText("Ir para o SUL");
			if(musicOnOff.equals("on") && !musicName.equals("city2")){
			mu.stop();				
			mu.setFile(city2);
			mu.play();
			musicOnOff = "on";
			musicName = "city2";
			}
		}
		saveGame();
	}
	
	public void oldMan1() {
		
		if (oldManFinished && !callHappened) {
			position = "oldManFinished";
			mainTextArea.setText("Senhorzinho: ''Filho, tendo sua ajuda, meu comércio \nprosperou.'' \n\n''Vá e viva um pouco! Te dou uma folga de 1 mês.''");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			}
		
		else if (callHappened) {
			position = "oldManFinished";
			mainTextArea.setText("Senhorzinho: ''Filho, muito orgulho de ti. Vá e mude o \nfuturo de todos nós!''");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			}
		
		else {
			position = "oldMan1";
		mainTextArea.setText("Enquanto caminhava, algo chamou sua atenção. \nUm cheiro de sushi muito bom. \n\nVocê dá uma espiada e observa um senhorzinho lá \ndentro preparando as comidas.");
		choice1.setText("Entrar");
		choice2.setText("Voltar");
		choice3.setText("");
		choice4.setText("");}		
		
	}
	
	public void oldMan2() {
		
		position = "oldMan2";
		mainTextArea.setText("Senhorzinho: ''Olá filho! Você é novo na cidade?'' \n''Nunca te vi antes.'' \n\n''Hmm... Entendi. Não tem onde ficar certo?''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void oldMan3() {
		
		position = "oldMan3";
		mainTextArea.setText("Senhorzinho: ''Bom, você me lembra muito meu \nfalecido filho. Gostei muito de você.'' \n\n''Quer me ajudar no trabalho em troca de moradia \ne um lar?''");
		choice1.setText("Aceitar");
		choice2.setText("Declinar");
		choice3.setText("");
		choice4.setText("");
	}
	public void oldMan4() {
		
		position = "oldMan4";
		mainTextArea.setText("O senhorzinho ficou muito feliz com tua escolha. \nImediatamente te colocou para trabalhar com ele. \nComo rotina, depois do longo dia de trabalho, vocês \nconversavam sobre a vida durante a noite. \n\nO senhorzinho lhe contava histórias de sua juventude \ne como ele costumava sair em missões pelas florestas.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void oldMan5() {
		
		position = "oldMan5";			
		mainTextArea.setText("Depois de algumas semanas vivendo neste estilo de \nvida, você adquiriu dinheiro. \n\nComprou um cinto que será muito útil para levar \nmais Poções de Vida em batalhas. \n\nCinto Equipado (10 Slots)");
		bag = "Cinto";
		bagSlots = 10;
		oldManFinished = true;
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void call() {
		
		position = "call";
		mainTextArea.setText("...! ...! ...! \n\nBarulhos de trombetas na rua! O que será que está \nacontecendo? \n\nVocê vai para o centro da cidade descobrir.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void call2() {			
		
		position = "call2";
		mainTextArea.setText("Rei: ''Este é um grande evento para celebrar a morte \ndo terrível Goblin!'' \n\n''Poucas pessoas sabem, mas foi este rapaz ali que \nmatou ele!!!'' - diz o rei, enquanto aponta para você.\n\nAs pessoas correm em sua direção para lhe agradecer.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	public void call3() {			
		
		position = "call3";
		mainTextArea.setText("Rei: ''Guerreiro! Não aguentamos mais viver nesta guerra \ncom os Goblins.'' \n\n''Sua Excalibur é a chave para acabarmos com isso. Criei \numa equipe com nossos melhores guerreiros.'' \n\n''Encontre eles na Floresta, fora da Cidade, ao LESTE.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	public void call4() {			
		
		position = "call4";
		mainTextArea.setText("Todas as pessoas lhe abraçavam e gritavam seu nome, \npedindo para que você finalmente colocasse um FIM \nnesta guerra com os Goblins.\n\nVocê pensa em se despedir de seus amigos na cidade antes de ir para a Floresta.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		callHappened = true;		
	}
	
	public void captured() {
			position = "captured";
			mainTextArea.setText("...! ...! ...! \n\nBarulhos de trombetas na rua! O que será que está \nacontecendo? \n\nVocê vai para o centro da cidade descobrir.");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
	public void captured2() {
		position = "captured2";
		mainTextArea.setText("Você cai no chão, após tomar um flechada na perna.\n\nGuerreiro: ''Finalmente te pegamos, assassino! Você \npagará com sua vida pela morte do nosso Guarda!''\n\nVocê ouve estas palavras enquanto recebe outra \nflechada no coração.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
/* MOBILE CREATION */
	
	public void mage1() {
		if (mageFinished) {
			
			position = "mageFinished";
			mainTextArea.setText("Mago: ''Voce já está pronto para cumprir seu destino, faça bom uso de tudo que aprendeu por aqui.''\n\n''Deseja uma leitura de mãos?''");
			choice1.setText("Aceitar");
			choice2.setText("Voltar");
			choice3.setText("");
			choice4.setText("");
			}
			else {
		position = "mage1";
		mainTextArea.setText("Enquanto caminhava, algo chamou sua atenção. \n\nEra uma casa bem grande, azul clara, com uma cor \nparecida com a luz emitida pela tua Excalibur.");
		choice1.setText("Entrar");
		choice2.setText("Voltar");
		choice3.setText("");
		choice4.setText("");}
	}
	public void mage2() {
		
		position = "mage2";
		mainTextArea.setText("???: ''Olá querido! Você é novo na cidade?'' \n''Nunca te vi antes.'' \n\n''Hmm... Entendi. Não tem onde ficar certo?''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void mage3() {
		
		position = "mage3";
		mainTextArea.setText("Mago: ''Bom, pelas muitas encarnações, eu sou chamado \nde Mago. Se eu solto magia? HAHAHA... O que é magia para ti?'' \n''Não... Magia pode ser um olhar, um pensamento, uma \nenergia, uma oração. Uma poção de cura. Você ja é um ser mágico. Qualquer um pode se tornar um Mago.'' \n\n''Deseja aprender?''");
		choice1.setText("Aceitar");
		choice2.setText("Declinar");
		choice3.setText("");
		choice4.setText("");
	}
	public void mage3_1() {
		
		position = "mage3_1";
		mainTextArea.setText("Mago: ''Olhe para a luz da tua espada, para sua tecnica em poções. Estes seus dons vem de muitas vidas passadas. Posso lhe mostrar o caminho para que você tenha todas as respostas que precise. Já estão todas aí dentro. Fique tranquilo, eu só trabalho com magia branca.");
		choice1.setText("Aceitar");
		choice2.setText("Declinar");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void mage4() {
		if (isPlayerGuilty || guardIsDead) {
			position = "mage4";
			mainTextArea.setText("Mago: ''Você já andou aprontando por aí né? Coisa feia. Mas fico feliz pelo teu aceite. Vamos começar sua iniciação.'' \n\n''Que o Deus-Luz esteja com você e lhe mostre tudo que \nprecise ser revelado.''");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		else {
		position = "mage4";
		mainTextArea.setText("Mago: ''Fico feliz! Vamos começar sua iniciação.'' \n\n''Que o Deus-Luz esteja com você e lhe mostre tudo que \nprecise ser revelado.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		}
	    
	}
	
	public void mage4_1() {
	    
		position = "mage4_1";
		mainTextArea.setText("Você entrou na iniciação e tomou uma bebida mágica. \n\nDurante horas você visitou diversas vidas passadas e \nentrou em contato intimo contigo mesmo. \n\nTodas as respostas que você precisava, foram aparecendo.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void mageGuardKilled() {
		if (guardIsDead) {
		position = "mageGuardKilled";
		mainTextArea.setText("Um ser mágico apareceu na tua frente, com uma forte luz branca para cobrar a morte do pobre Guarda. \n\nVocê se assustou e se arrependeu do fundo de sua alma \npelo ocorrido. Foi perdoado... (O guarda foi revivido)");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		guardIsDead = false;
		isPlayerGuilty = false;
		enteredCityAlready = true;
		}
		else {
			position = "mageGuardKilled";
			mainTextArea.setText("Um ser mágico apareceu na tua frente, com uma forte luz branca para cobrar as coisas erradas que você fez. \n\nVocê se assustou e se arrependeu do fundo de sua alma \npelo ocorrido. Foi perdoado...");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			guardIsDead = false;
			isPlayerGuilty = false;
			enteredCityAlready = true;
		}		
	    
	}
	
	public void mage4_2() {
		
		if (guardIsDead || isPlayerGuilty) {
			mageGuardKilled();
		}
		else {
		position = "mage4_2";
		mainTextArea.setText("Em tua ultima vida passada, você foi um Goblin Feiticeiro, \nque causou muita destruição e sofrimento por inúmeras \ncidades. \n\nAgora é sua chance de fazer o bem. Encerrar a guerra de \nHumanos e Goblins, pois tu ja vivenciou os dois lados...");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		}
	    
	}
	
	public void mage4_3() {
		
	    position = "mage4_3";
		mainTextArea.setText("Depois destas visões, você ficou semanas vivendo com o \nMago, aprendendo sobre o universo, sobre magia, sobre \nti mesmo. \n\nDescobriu também que tua espada é fortalecida por um \nAnjo Guerreiro de Luz Azul.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void mage5() {
		
		position = "mage5";
		specialPower = "Tubo de Luz";
		powerUse++;
		mageFinished = true;
		mainTextArea.setText("Depois de algumas semanas vivendo neste estilo de \nvida, você adquiriu um novo poder. \n\nTubo de Luz branca. Uma rapida oração trazendo a \nproteção do Deus-Luz. \n\nTubo de Luz Branca (+50 pontos de vida quando usado)");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void mageFutureRead() {
		if (callHappened) {
			position = "mageFutureRead";		
			mainTextArea.setText("Mago: ''Hmm...Interessante...''\n\n''Se prepare bem, recolha o máximo de Poções que puder \nao NORTE fora da cidade, para esta sua nova missão. \nEncontrará também uma linda garota. Bem brava, \nespinhenta.''\n''Um grande esforço teu no futuro irá decidir o futuro \ndela e de todos nós.''");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		else {		
		position = "mageFutureRead";		
		mainTextArea.setText("Mago: ''Hmm...Interessante...''\n\n''Logo você será convocado para uma grande missão. Se \nprepare bem, recolha o máximo de Poções que puder. \n''Encontrará também uma linda garota. Bem brava, \nespinhenta.''\n''Uma grande decisão sua no futuro irá decidir o futuro \ndela e de todos nós.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");}
	}
	
	public void badKid1() {
		if (badKidFinished && isPlayerGuilty) {
			position = "badKidFinished";
			mainTextArea.setText("Jovem: ''Haha, veja se não é meu ladrão favorito, tudo bem?'' \n\n''Pronto para outro grande roubo?'' \n\n''Quando eu tiver algo, te aviso.''");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		else if(badKidFinished && !isPlayerGuilty) {
			position = "badKidFinished";
			mainTextArea.setText("Jovem: ''Haha, veja se não é meu ladrão favorito, tudo bem?'' \n\n''Pronto para outro grande roubo?'' \n\n''Não? Agora você é o SR. Certinho? Não ouse mais \ndirigir a palavra para mim.''");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		else {
		position = "badKid1";
		mainTextArea.setText("Enquanto caminhava, algo chamou sua atenção. \nEra uma casinha muito pequena, com uma àrvore \ndo lado.");
		choice1.setText("Entrar");
		choice2.setText("Voltar");
		choice3.setText("");
		choice4.setText(""); }
	}
	public void badKid2() {
		
		position = "badKid2";
		mainTextArea.setText("Jovem: ''Você é o rapaz novo na cidade! Já ouvi \nfalarem mal de você. Tenho meus contatos hehe.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
		
	}
	
	public void badKid3() {
		
		position = "badKid3";
		mainTextArea.setText("Jovem: ''Cara, essa cidade é podre. Não se deixe \nenganar. Todos aqui irão tentar se aproveitar de você, \numa hora ou outra.'' \n\n''Por isso eu devolvo na mesma moeda.'' \n''Vou roubar uma casa rica hoje, vem comigo?''");
		choice1.setText("Ir");
		choice2.setText("Declinar");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void badKid4() {
		
		position = "badKid4";
		mainTextArea.setText("...\n\nDe noite, vocês sorrateiramente roubaram uma casa \nde um Conde. \n\nCom o dinheiro roubado, você se alimentou por \nalgumas semanas. Mas você se sente culpado...");
		badKidFinished = true;
		isPlayerGuilty = true;
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	
	/*NEWWWWWWWWWWWWWWWWWW JOURNEEEEEEEEEEEEEY*/
	
	public void newJourney() {
		
		if(musicOnOff.equals("on") && !musicName.equals("forest")){
			mu.stop();				
			mu.setFile(forest);
			mu.play();
			musicOnOff = "on";
			musicName = "forest";
		}
		
		position = "newJourney";
		mainTextArea.setText("Você chega perto deles e se apresenta. Lê em suas \narmaduras que o nome das garotas são: Iaycha e Shiva. \nDo rapaz: Ravi. ");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	
	
	
	public void newJourney2() {
		
		position = "newJourney2";
		mainTextArea.setText("Shiva: ''Então você é o escolhido pelo Rei, certo? \nEstavamos te esperando!!! Me dá um abraço!!! O Goblin que você matou, tinha matado meus pais.''\n\nShiva sai correndo e te derruba no chão com um abraço \ncarinhoso.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	public void newJourney3() {
		
		position = "newJourney3";
		mainTextArea.setText("Ravi continua focado na fogueira. Iaycha apenas olha de \nlonge, quieta, enquanto fuma seu cachimbo.\n\nShiva: ''Vem! Vou te apresentar o pessoal.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void newJourney4() {
		
		position = "newJourney4";
		mainTextArea.setText("Shiva te explica que o Rei juntou vocês para invadirem o \ncastelo dos Goblins. \n\nLá dentro, existe um Cristal, que se destruído, todos os \nGlobins morrerão instantâneamente.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void newJourney5() {
		
		if(musicOnOff.equals("on") && !musicName.equals("forest")){
			mu.stop();				
			mu.setFile(forest);
			mu.play();
			musicOnOff = "on";
			musicName = "forest";
		}
		position = "newJourney5";
		mainTextArea.setText("Vocês se apresentam e decidem assar peixes, dormir e \namanhã cedo adentrar a densa foresta.\n\nÀ luz da fogueira vocês ficam, enquanto Ravi canta uma \nmúsica com seu violão. \n\n(Seu progresso foi salvo!)");
		choice1.setText("Falar com Shiva");
		choice2.setText("Falar com Iaycha");
		choice3.setText("Falar com Ravi");
		choice4.setText("Dormir");
		saveGame();
	}

	public void iaycha() {
		
		position = "iaycha";
		mainTextArea.setText("Iaycha: ''Iae. Tudo bem? Gosta de cachimbo? Experimenta.''\n\n''...''\n\n''Bom né?''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	
	public void iaychaFireCutscene() {
		mainTextPanel.setVisible(false);
		imageLabel.setIcon(iaychaFireCutscene);
		imagePanel.setVisible(true);		
		position = "iaychaFireCutscene";	
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void iaycha2() {
		
		mainTextPanel.setVisible(true);		
		imagePanel.setVisible(false);	
		
		position = "iaycha2";
		mainTextArea.setText("Iaycha: ''De onde eu vim? Eu era de um grupo rebelde na \ncidade. Costumava fazer muita rebelião para derrubar o \nRei do trono...Até que me prenderam.'' \n\n''Só que pelas minhas habilidades, me mandaram nessa \nmissão.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void iaycha3() {
		
		position = "iaycha3";
		mainTextArea.setText("Iaycha: ''...''\n\nVocês estavam com vergonha um do outro, mas \ncontinuaram conversando mesmo assim.\n\nIaycha: ''Haha, esse fogo alto da fogueira me lembra \nquando eu botei fogo no carro do Rei.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void shiva() {
		
		position = "shiva";
		mainTextArea.setText("Shiva: ''Iae!!! Mais uma  vez, obrigado por tudo que fez pela cidade. Você é nosso Herói!");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void shiva2() {
		
		position = "shiva2";
		mainTextArea.setText("Shiva: ''Curte Dragões? Meu sonho é ter um filho com um \nDragão. Imagina como ele seria!!!''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	public void shiva3() {
		
		position = "shiva3";
		mainTextArea.setText("Shiva: ''Você me lembra bastante meu irmão mais novo.'' \n\n''Meu sonho é retornar viva desta missão e ganhar uma \ngrana necessária para que ele tenha uma boa vida.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	public void ravi() {
		
		position = "ravi";
		mainTextArea.setText("Ravi está tocando músicas, melhor não perturbá-lo. \n\nVocê também notou que ele olha feio quando as meninas \nestão alegres perto de você.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void sleep() {
		
		position = "sleep";
		mainTextArea.setText("Depois de comerem, bailarem e se divertirem à luz da \nfogueira, todos foram dormir em suas respectivas \ncabanas.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	
	public void forest() {
		
		position = "forest";
		mainTextArea.setText("Vocês acordam, se arrumam e adentram a Floresta. \n\nDecidem ir em Duplas. \n\nEm olhares tímidos, você faz a dupla com Iaycha.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void forest2() {
		
		position = "forest2";
		mainTextArea.setText("De repente, uma grande neblina começa a tomar conta. \n\nVocês perdem Shiva e Ravi de vista, começam a ficar \npreocupados. \n\nAté que avistam de longe duas pessoas vindo em sua \ndireção...");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void forest3() {
		
		position = "forest3";
		mainTextArea.setText("São dois Bárbaros! Eles correm para cima de vocês. \n\nIaycha: ''Cada um pega um. Não se preocupe, eu sei cuidar \nde mim mesma.''");
		choice1.setText("Atacar!");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		enteredForest = true;
	
	}

	// attackEnemy(String enemyName);


	public void forest4() {
		if(musicOnOff.equals("on") && !musicName.equals("forest")){
			mu.stop();				
			mu.setFile(forest);
			mu.play();
			musicOnOff = "on";
			musicName = "forest";
		}
		position = "forest4";
		mainTextArea.setText("Iaycha: ''Ah, você conseguiu também. Nossa, essa luta foi \nmais dificil do que aquela vez que eu enfrentei 3 guardas do Rei por ter destruido uma loja dele.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void forest5() {
		
		position = "forest5";
		mainTextArea.setText("Vocês continuam o trajeto dentro da floresta, um grudado no outro para não se perderem. Até que encontram um rio, onde a névoa não alcança.\n\nIaycha: ''Vamos esperar aqui pelo Ravi e Shiva, tenho \ncerteza que eles irão chegar aqui também.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	public void forest6() {
		
		position = "forest6";
		mainTextArea.setText("Pela tarde, vocês armam uma fogueira e ficam lá \nesperando até o anoitecer, enquanto conversam para \ndisfarçar a preocupação com seus amigos.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	public void forest7() {
		
		position = "forest7";
		mainTextArea.setText("O tempo se passou, Iaycha lhe contou tudo sobre a vida \ndela até aqui, sobre seus sonhos... O tempo passou \nmuito rápido. \n\nChegou a hora de dormir. Cada um arma sua barraca.");
		choice1.setText("Dormir com a Iaycha");
		choice2.setText("Dormir Sozinho");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void sleepIaycha() {
		
		position = "sleepIaycha";
		mainTextArea.setText("Iaycha: ''Se eu quero que você durma comigo? Claro que eu quero.''\n\nVocê: ''Iaycha, nunca irei abandoná-la.''\n\nCom poucas palavras ditas, vocês se entregam um para \no outro, até o amanhecer.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void sleepAlone() {
		
		position = "sleepAlone";
		mainTextArea.setText("Iaycha: ''Não durma sozinho, vem para a minha cabana...''\nVocê aceita o convite.\n\nVocê: ''Iaycha, nunca irei abandoná-la.''\n\nCom poucas palavras ditas, vocês se entregam \num para o outro, até o amanhecer.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void lastDay() {
		
		position = "lastDay";
		mainTextArea.setText("Iaycha: ''Nossa, dormimos muito! Perdemos a hora. \nAcorda!''\n\nVocês saem da cabana e se assustam ao ver outras duas \ncabanas montadas.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void lastDay1() {
		
		position = "lastDay1";
		mainTextArea.setText("Shiva e Ravi aparecem. \n\nShiva: ''Bom dia pombinhos!!! Chegamos ontem de \nmadrugada, não quisemos atrapalhar. Hihi, relaxem, \nnão fiquem envergonhados. Quando chegamos, já \ntinham terminado.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void lastDay2() {
		
		position = "lastDay2";
		mainTextArea.setText("Iaycha disfarça acendendo seu cachimbo. Você disfarça sua vergonha perguntando o que aconteceu com eles. \n\nShiva responde que encontraram muitos Goblins, lutaram \npraticamente a noite inteira, mas conseguiram escapar.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void lastDay3() {
		
		position = "lastDay3";
		mainTextArea.setText("Ravi não diz nada, mas continua te olhando muito feio.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void lastDay4() {
		
		position = "lastDay4";
		mainTextArea.setText("Shiva diz que na correria, descobriram onde fica o quarto \ndo Goblin Rei. Lá com certeza fica o Cristal. \n\nO plano será matar o Goblin Rei e destruir o Cristal.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void lastDay5() {
		
		position = "lastDay5";
		mainTextArea.setText("Ravi: ''O problema será passar pelo Globin Rei. Deixa que o Sushiman aí consegue sozinho.''\n\nVocês dois se estranham e as meninas correm para \nsepará-los.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void lastDay6() {
		if(musicOnOff.equals("on") && !musicName.equals("forest")){
			mu.stop();				
			mu.setFile(forest);
			mu.play();
			musicOnOff = "on";
			musicName = "forest";
		}
		if (talkIaycha && lightFire && searchPotions && hugIaycha){
			position = "endLastDay";
			mainTextArea.setText("Shiva: ''Chegamos!!! Vamos comer agora, juntar forças e \namanhã invadir o quarto do Goblin. Sei um atalho que \nnão encontraremos nenhum Goblin no caminho.''");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		else {
			position = "lastDay6";
		mainTextArea.setText("Shiva leva Ravi para pescar, enquanto que você e Iaycha \nficam responsáveis por acenderem a fogueira.\n\n(Seu progresso foi salvo!)");
		choice1.setText("Falar com Iaycha");
		choice2.setText("Acender a Fogueira");
		choice3.setText("Buscar Poçoes");
		choice4.setText("Abraçar Iaycha");
		saveGame();
		}		
	
	}
	
	public void talkIaycha() {
		
		position = "talkIaycha";
		mainTextArea.setText("Iaycha: ''Ignore o Ravi. Tivemos um caso no passado, mas \njá está no passado.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		talkIaycha = true;
	
	}

	public void lightFire() {
		
		position = "lightFire";
		mainTextArea.setText("Vocês trabalham em equipe e acendem a fogueira. \n\nAproveitam o fogo para fumarem cachimbo juntos.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		lightFire = true;
	}

	public void searchPotions() {
		
		position = "searchPotions";
		if (bag.equals("Bolso") && playerPotions == 4 || bag.equals("Cinto") && playerPotions == 10) {
			playerPotions--;		
			}
		
		playerPotions++;		
		mainTextArea.setText("Você se arrisca um pouco na floresta para coletar folhas \nmágicas. Você cria 1 poção mágica.\n\n"+bag+": "+playerPotions+" / Slots: "+bagSlots);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		searchPotions = true;
	
	}

	public void hugIaycha() {
		
		position = "hugIaycha";
		mainTextArea.setText("Iaycha: ''...''\n\n''É melhor a gente parar com isso. Não quero nada sério \nentre nós. Não me toque mais.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		hugIaycha = true;
	}

	public void endLastDay2() {
		
		position = "endLastDay2";
		playerHP += 10;
		hpLabelNumber.setText(""+playerHP);
		mainTextArea.setText("Vocês comem e passam a noite rindo, cantando músicas e \ndançando. Aproveitando o que pode ser o último dia \nde vocês. \n\nDepois, cada um vai para sua cabana. \n\nVocê e Iaycha dormem juntos novamente.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void dDay() {
		if(musicOnOff.equals("on") && !musicName.equals("silence")){
			mu.stop();			
			musicOnOff = "off";
			musicName = "silence";
		}
		position = "dDay";
		mainTextArea.setText("8 horas depois, vocês acordam. Todos quietos, focados. \n\nTodos se arrumam, pegam suas espadas e começam a \nseguir Shiva, que sabe o caminho.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void dDay2() {
		
		if(musicOnOff.equals("off") && !musicName.equals("roar")){
			mu.stop();				
			mu.setFile(roar);
			mu.play();
			musicOnOff = "on";
			musicName = "roar";
		}
		
		position = "dDay2";
		mainTextArea.setText("Vocês seguem uma trilha especial, dentro de uma caverna. \n\nAos trancos e barrancos, vocês alcançam uma parede. \nUm som vindo lá de dentro, derruba vocês.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void dDay3() {		
		
		position = "dDay3";
		mainTextArea.setText("Ravi: ''Isso é suicidio!!! Apenas o som dele nos derrubou!!!''\n\nVocês se encaram, todos paralizados pelo medo.");
		choice1.setText("Atacar");
		choice2.setText("Voltar");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void dDayAttack() {
		
		if(musicOnOff.equals("on") && !musicName.equals("kingGoblin")){
			mu.stop();
			mu.setFile(kingGoblin);
			mu.play();
			musicOnOff = "on";
			musicName = "kingGoblin";
		}
		
		playerHP -= 10;
		hpLabelNumber.setText(""+playerHP);
		position = "dDayAttack";
		mainTextArea.setText("Você dá um enorme pulo pela janela, saca sua espada e \naponta para o Rei Goblin. Ele furioso, parte para cima de \nvocê. \n\nRavi, Iaycha e Shiva entram na briga.\n\n(Você toma 10 pontos de Dano.)");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	
	public void dDayHide() {
		if(musicOnOff.equals("on") && !musicName.equals("kingGoblin")){
			mu.stop();
			mu.setFile(kingGoblin);
			mu.play();
			musicOnOff = "on";
			musicName = "kingGoblin";
		}
		position = "dDayHide";
		mainTextArea.setText("Iaycha dá um enorme pulo pela janela, saca a espada e \naponta para o Rei Goblin. Ele furioso, parte para cima dela. \n\nVocê, Ravi e Shiva entram na briga.\n\n(Iaycha toma 10 pontos de Dano.)");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void dDayAttack2() {
		
		position = "dDayAttack2";
		mainTextArea.setText("Muitos Goblins começam a correr para dentro do Castelo. \n\nIaycha ordena que Ravi e Shiva vão até a porta, para \nimpedir que outros Goblins entrem.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	// attackKingGoblin(String enemyName);
	// if king goblin is 40 or less LP, iaycha goes to hold other Goblins. Finish this! Você: eu te amo. Ela: eu também.
	// Less than 20 LP, Goblins start breaking. Iaycha is Dead. Você vence a luta.
	
	public void kingGoblinCutscene() {
		mainTextPanel.setVisible(false);		
		imageLabel.setIcon(kingGoblinCutscene);
		imagePanel.setVisible(true);		
		position = "kingGoblinCutscene";	
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void fightKingGoblin() {
		
		mainTextPanel.setVisible(true);	
		imagePanel.setVisible(false);		
		
		position = "fightKingGoblin";		
			
			mainTextArea.setText("O Rei Goblin está na sua frente. Ele é muito forte \nfisicamente, com um corpo cheio de armaduras. \nMede quase 2 metros e meio de altura.\n\nPontos de Vida do Rei Goblin: " + kingGoblinHP + "\nSua arma: "+playerWeapon);
			choice1.setText("Lutar!");
			choice2.setText("Correr");
			choice3.setText("Poção de Vida "+"("+playerPotions+")");
			choice4.setText(""+specialPower+" ("+powerUse+")");		
			
		}

		public void attackKingGoblin() {
			position = "attackKingGoblin";
			int playerDamage = 0;
			
			if (playerWeapon.equals("Nenhuma")) {
				playerDamage = new java.util.Random().nextInt(0);
			} else if (playerWeapon.equals("Excalibur")) {
				playerDamage = new java.util.Random().nextInt(8);
			}
			
			kingGoblinHP -= playerDamage;		

			if (kingGoblinHP < 1) {
				lastChapter();				
			}
			
			else if (playerHP <= 10 && !miracle) {
				tuboDeLuz();				
			} 
			
			else if (kingGoblinHP >= 51 && kingGoblinHP <= 300) {
				position = "attackKingGoblin";
				int monsterDamage = 0;
				monsterDamage = new java.util.Random().nextInt(4);			
				
				playerHP -= monsterDamage;
				hpLabelNumber.setText(""+playerHP);
				
				if (playerHP < 1) {
					dead();
				} else if (playerHP > 0) {
					mainTextArea.setText("Você o atacou e infligiu " + playerDamage + " pontos de dano!\n\n" + "Seus Pontos de Vida: " + playerHP+""+ "\nPontos de Vida do Goblin: " + kingGoblinHP+""+"\n\nO monstro lhe atacou e infligiu " + monsterDamage + " pontos de dano!");
					choice1.setText("Atacar!");
					choice2.setText("Correr");
					choice3.setText("Poção de Vida "+"("+playerPotions+")");
					choice4.setText(""+specialPower+" ("+powerUse+")");
				}
			}
			else if (kingGoblinHP < 51 && !iaychaDeclared) {
				position = "kGless50";
				iaychaDeclared = true;
				{
					mainTextArea.setText("Iaycha: ''Os goblins tão entrando na sala, isso quer dizer...\nque a Shiva e o Ravi...''\n\n''Vou para a porta! Confio em você!!!'' \n\n...''Desculpa pelo meu surto, eu te amo.''");
					choice1.setText("");
					choice2.setText("");
					choice3.setText("Eu também te amo.");
					choice4.setText("Vá!");
					
				}
			}
			
			else if (kingGoblinHP < 20 && !iaychaIsDead) {
				position = "kGless20";
				iaychaIsDead = true;
				{
					mainTextArea.setText("Os goblins começaram a invadir a sala...Isso significa que...\n\nVocê: ''Iaycha...''\n\n");
					choice1.setText("Atacar");
					choice2.setText("");
					choice3.setText("");
					choice4.setText("");
					
				}
			}
			
			else if (kingGoblinHP <= 51 && iaychaDeclared) {
				position = "attackKingGoblin";
				int monsterDamage = 0;
				monsterDamage = new java.util.Random().nextInt(4);			
				
				playerHP -= monsterDamage;
				hpLabelNumber.setText(""+playerHP);
				
				if (playerHP < 1) {
					dead();
				} else if (playerHP > 0) {
					mainTextArea.setText("Você o atacou e infligiu " + playerDamage + " pontos de dano!\n\n" + "Seus Pontos de Vida: " + playerHP+""+ "\nPontos de Vida do Goblin: " + kingGoblinHP+""+"\n\nO monstro lhe atacou e infligiu " + monsterDamage + " pontos de dano!");
					choice1.setText("Atacar!");
					choice2.setText("Correr");
					choice3.setText("Poção de Vida "+"("+playerPotions+")");
					choice4.setText(""+specialPower+" ("+powerUse+")");
				}
			}
			
			else if (kingGoblinHP < 20 && iaychaIsDead) {
				position = "attackingKingGoblin";
				
				int monsterDamage = 0;
				monsterDamage = new java.util.Random().nextInt(4);			
				
				playerHP -= monsterDamage;
				hpLabelNumber.setText(""+playerHP);
				
				if (playerHP < 1) {
					dead();
				} else if (playerHP > 0) {
					mainTextArea.setText("Você o atacou e infligiu " + playerDamage + " pontos de dano!\n\n" + "Seus Pontos de Vida: " + playerHP+""+ "\nPontos de Vida do Goblin: " + kingGoblinHP+""+"\n\nO monstro lhe atacou e infligiu " + monsterDamage + " pontos de dano!");
					choice1.setText("Atacar!");
					choice2.setText("Correr");
					choice3.setText("Poção de Vida "+"("+playerPotions+")");
					choice4.setText(""+specialPower+" ("+powerUse+")");
				}
			}

		}
		
		private void tuboDeLuz() {
			position = "tuboDeLuz";		
			mainTextArea.setText("Você toma um golpe e fica de joelhos. \nMas você se lembra de que não está sozinho. \n\nSua espada começa a brilhar azul mais do que nunca antes. \n\n(Você recebeu um Tubo de Luz.)");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			powerUse++;
			miracle = true;
		}
		private void tuboDeLuzCutscene() {
			
			mainTextPanel.setVisible(false);		
			imageLabel.setIcon(tuboDeLuz);
			imagePanel.setVisible(true);				
			position = "tuboDeLuzCutscene";
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");			
		}


		public void usePotion3() {
			position = "usingPotion3";
			
			int monsterDamage = 0;
			monsterDamage = new java.util.Random().nextInt(2);
			
			if (playerPotions > 0) {
				
				playerHP +=3;
				playerHP -= monsterDamage;
				playerPotions--;
				hpLabelNumber.setText(""+playerHP);
				
				mainTextArea.setText("Você desesperadamente bebeu uma Poção de Vida.\n(Você recuperou 3 pontos de vida)\n\nO monstro ficou furioso e lhe atacou, porém o dano \nfoi minimo. (Você tomou "+monsterDamage+" de dano)");
				choice1.setText("Atacar");
				choice2.setText("Correr");
				choice3.setText("Poção de Vida "+"("+playerPotions+")");
				choice4.setText(""+specialPower+" ("+powerUse+")");
			}
			else {
				playerHP -= monsterDamage;
				hpLabelNumber.setText(""+playerHP);
				mainTextArea.setText("Você tentou beber uma Poção de Vida, mas não tem \nnenhuma.\n\nO monstro ficou furioso e lhe atacou, porém o dano \nfoi minimo. (Você tomou "+monsterDamage+" de dano)");
				choice1.setText("Atacar");
				choice2.setText("Correr");
				choice3.setText("Poção de Vida "+"("+playerPotions+")");
				choice4.setText(""+specialPower+" ("+powerUse+")");
			}
		}	
		
	public void promiseIaycha() {
			
			position = "promiseIaycha";
			mainTextArea.setText("Você: ''Eu também te amo, Iaycha. E prometo que sairemos vivos dessa. Nunca irei te abandonar.''\n\nIaycha sorri e corre para a porta.");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			promiseIaycha = true;
		}
	public void goodByeIaycha() {
		
			position = "goodByeIaycha";
			mainTextArea.setText("Você: ''Vá Iaycha.''\n\nIaycha se entristece mas corre para a porta.");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			goodByeIaycha = true;
	
	}

	public void lastChapter() {
		
		position = "lastChapter";
		mainTextArea.setText("Você matou o monstro. O monstro virou cinzas, tudo que \nrestou foi um Cristal flutuando, rodeado por uma luz muito quente. \n\nEm sua ultima espadada no Goblin Rei, um goblin lhe \nacertou com uma espadada no Peito. \n\nVocê cai no chão, estirado.");
		choice1.setText("Destruir");
		choice2.setText("Descansar");
		choice3.setText("");
		choice4.setText("");
		goblinKingIsDead = true;
	
	}

	public void lastChapter2() {
		
		position = "lastChapter2";
		mainTextArea.setText("Você se levanta, estanca seu sangramento e junta todo o \nresto de energia que tem. Se atira no Cristal. \n\nNo meio da ação, você cai no chão desmaiado.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	
	public void lastChapter2_0() {
		
		position = "lastChapter2_0";
		mainTextArea.setText("Você tenta descansar um pouco, enquanto estanca \no sangramento. Então desmaia.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	
	public void dreamSequence() {
	if(musicOnOff.equals("on") && !musicName.equals("iaycha")){
		mu.stop();				
		mu.setFile(iaycha);
		mu.play();
		musicOnOff = "on";
		musicName = "iaycha";
	}	
	
	if (dS1 && dS2 && dS3){
			mirror();	
		} 
		
		else {
		position = "dreamSequence";
		mainTextArea.setText("Muito tempo se passou. \n\nVocê acorda. Está em uma sala gigante, cheia de pessoas. \nPelas janelas, espia apenas gigantes montanhas. \n\nTem um Guardião na sua frente.");
		choice1.setText("Falar com o Guardião");
		choice2.setText("Procurar Iaycha");
		choice3.setText("Escapar");
		choice4.setText("");}
	
	}

	public void talkGuardian() {
		if (goodByeIaycha) {
			position = "talkGuardian";
			mainTextArea.setText("Guardião: ''Você está morto. Este é o lugar onde as almas \nchegam quando partem da Terra. Vocês ficam aqui até \nserem direcionadas para algum outro lugar.\n\nNa sua ficha diz que você decidiu percorrer o caminho do \norgulho, ao invés de dizer que amava.");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");			
		} else {
		position = "talkGuardian";
		mainTextArea.setText("Guardião: ''Você está morto. Este é o lugar onde as almas \nchegam quando partem da Terra. Vocês ficam aqui até \nserem direcionadas para algum outro lugar.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");}
		
		dS1 = true;
	}

	public void searchIaycha() {
		
		position = "searchIaycha";
		mainTextArea.setText("Guardião:''Iaycha? Não tem ninguém aqui com este nome.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		dS2 = true;
	}

	public void escape() {
		
		position = "escape";
		mainTextArea.setText("Guardião: ''Não adianta, este lugar tem infinitas montanhas ao redor. Não existe como escapar.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		dS3 = true;
	}

	public void mirror() {
		
		position = "mirror";
		mainTextArea.setText("Você decide ir no banheiro. Se olha no espelho. Vê um \nser puro de energia. Acha aquilo incrivel. \n\nAqui você pode voar, pode fazer o que quiser. \n\n''Talvez eu devesse ficar por aqui...''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void mirror2() {
		if (escape >30) {
			lastChapter2_1();
		} else {
		position = "mirror2";
		mainTextArea.setText("Você: ''NÃO! Iaycha ainda está lá embaixo, eu prometi que \nnunca iria abandoná-la. EU PRECISO VOLTAR. PRECISO \nVOLTAR AGORA!''");
		choice1.setText("Voltar!!!");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");}	
	
	
	}
	public void tryingEscape() {
		escape++;
		position = "tryingEscape";
		mainTextArea.setText("Você começa a fazer um enorme esforço mental, \ntentando quebrar a realidade ao seu redor.");
		choice1.setText("Voltar!!!");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void lastChapter2_1() {
		
		position = "lastChapter2_1";
		mainTextArea.setText("...! Você pula do chão e abre os olhos. Olha ao redor e se vê \nno quarto do Goblin Rei, com o Cristal Flutuante.");
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("Atacar");
	
	}

	public void lastChapter3() {
		
		position = "lastChapter3";
		mainTextArea.setText("Mesmo ferido, você junta forças, pega sua Excalibur e atira ela no Cristal. A Excalibur quebra o Cristal e acontece uma grande explosão. \n\nVocê olha pela janela e vê todos os Goblins virando cinzas. \n\nÉ o fim.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void lastChapter3_1() {
		
		position = "lastChapter3_1";
		mainTextArea.setText("Você: ''Iaycha!''\n\nVocê sai do quarto em busca. Lá está ela, no chão. \nVocê checa o pulso, se dá conta que ela está morta...\n\nEla lutou até o fim acreditando que você sairia vitorioso.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	
	public void iaychaDeadCutscene() {
		mainTextPanel.setVisible(false);
		imageLabel.setIcon(iaychaDeadCutscene);
		imagePanel.setVisible(true);		
		position = "iaychaDeadCutscene";	
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void lastChapter3_2() {
		
		mainTextPanel.setVisible(true);
		imagePanel.setVisible(false);	
		
		position = "lastChapter3_2";
		mainTextArea.setText("Enquanto chora com ela em seus braços, você se lembra de uma frase. Que qualquer um pode ser um Mago. \n\nNeste momento, você focaliza todo seu pensamento na \nIaycha acordando. ");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void lastChapter4() {
		
		position = "lastChapter4";
		mainTextArea.setText("Você esquece o mundo ao redor. Lembra apenas do sorriso dela. Imagina o sorriso dela em volta de uma luz azul e \nverde. \n\nLembra de todos os bons momentos que tiveram. \n\nSeu corpo e o dela começam a irradiar Luz...");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void lastChapter4_1() {
		
		position = "lastChapter4_1";
		mainTextArea.setText("...");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	public void lastChapter4_2() {
		
		position = "lastChapter4_2";
		mainTextArea.setText("...\n\n...");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	public void lastChapter4_3() {
	
	position = "lastChapter4_3";
	mainTextArea.setText("...\n\n...\n\n...\n\n");
	choice1.setText(">");
	choice2.setText("");
	choice3.setText("");
	choice4.setText("");

	}

	public void lastChapter5() {
		
		position = "lastChapter5";
		mainTextArea.setText("Iaycha: ''Será que depois disso tudo, poderemos matar o \nRei sem sermos condenados? Agora somos heróis!''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void lastChapter6() {
		
		position = "lastChapter6";
		mainTextArea.setText("Vocês dois se abraçam. Riem de felicidade um com o outro. Comemoram o fim da guerra.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	public void lastChapter6_1() {
		
		position = "lastChapter6_1";
		mainTextArea.setText("Vocês carregam os corpos de seus amigos para fora do \nCastelo do Goblin Rei, e os enterram. \n\nÉ uma mistura de emoções.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	public void lastChapter6_2() {
	
	position = "lastChapter6_2";
	mainTextArea.setText("Depois de horas ali...\n\nIaycha: ''Vamos voltar pra cidade, eles estarão lá em \nespirito comemorando conosco.''\n\nVocês retornam à cidade.");
	choice1.setText(">");
	choice2.setText("");
	choice3.setText("");
	choice4.setText("");

}

	public void lastChapter7() {
		if(musicOnOff.equals("on") && !musicName.equals("goodEnding")){
			mu.stop();				
			mu.setFile(goodEnding);
			mu.play();
			musicOnOff = "on";
			musicName = "goodEnding";
		}
		position = "lastChapter7";
		mainTextArea.setText("No portão da cidade, uma enorme festa!!! Uma multidão no aguardo de vocês.\n\nRei: ''Nobre Guerreiro, se prepare! Você será o próximo REI! Escolha bem sua Rainha!'' \n\nO povo corre para lhe abraçar.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void lastChapter8() {
		
		position = "lastChapter8";
		mainTextArea.setText("Iaycha: ''tsk tsk. O Rei me odeia tanto que nunca irá me dar créditos. Quando eu virar Rainha, irei mudar muita coisa \nnessa cidade.''\n\nVocês dois se olham e se abraçam.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}

	public void lastChapter9() {
			
		if (lC1 && lC2 && lC3) {			
			goodEnding();
		} else {
		position = "lastChapter9";
		mainTextArea.setText("Você está na Festa da Cidade, para onde quer ir?");
		choice1.setText("Senhorzinho");
		choice2.setText("Mago");
		choice3.setText("Festa");
		choice4.setText("");
		}
		
	
	}

	public void partyTime() {
		
		position = "partyTime";
		mainTextArea.setText("Você entra no meio da festa e se diverte. Todos da festa \nlevantam você e a Iaycha e os jogam para o alto.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		lC1 = true;
	
	}

	public void lastMago() {
		
		position = "lastMago";
		mainTextArea.setText("Mago: ''Eu sabia!!! Sempre soube. Desde a hora que pisou \naqui.''\n\n''E você, bela moça, já escolheu um nome para o bebê?''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}

	public void lastMago2() {
		
		position = "lastMago2";
		mainTextArea.setText("Iaycha: ''Qual bebê???''\n\nMago: ''HAHAHA.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		lC2 = true;
	}

	public void lastOldMan() {
		
		position = "lastOldMan";
		mainTextArea.setText("Senhorzinho: ''Filho! Estou feliz que esteja vivo. Estou \nganhando uma fortuna com esta festa na cidade! Agora \nque os Goblins se foram, irei realizar meu sonho de viajar \no mundo. Partirei amanhã. More nessa casa com a Iaycha \naté que vocês assumam o trono.''\n\nVocês se despedem e agradecem.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		lC3 = true;
	}

	public void goodEnding() {
		
		position = "goodEnding";
		mainTextArea.setText("11 meses depois, o Rei, que já sofria por muito tempo de \numa terrível doença, morre. Você assume o trono junto \ncom Iaycha e sua filha recém-nascida: Shiva. \n\nA paz reina na cidade e no mundo para todo o sempre.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	
	public void creditsCutscene() {
		
		mainTextPanel.setVisible(false);
		imageLabel.setIcon(creditsCutscene);
		imagePanel.setVisible(true);	
		position = "creditsCutscene";			
			
		choice1.setText("FIM!");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}