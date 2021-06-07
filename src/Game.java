import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	
	public JFrame window;
	public Container container;
	public JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	public JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	public Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	public Font normalFont = new Font ("Candara", Font.PLAIN, 24);
	public Font normalFont2 = new Font ("Candara", Font.PLAIN, 23);
	public Font shortFont = new Font ("Times New Roman", Font.PLAIN, 10);
	public JButton startButton, choice1, choice2, choice3, choice4;
	public JTextArea mainTextArea;
	static Font pixelMplus;
	
	Color blue = new Color(100,100,133);
	
	
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();	
	ChoiceHandler choiceHandler = new ChoiceHandler();	
	
	
	Timer timer = new Timer();
//	TimerTask task = new TimerTask(){
//
//		@Override
//		public void run() {			
//			timer.schedule(task, 3000);
//		}
//		
//	};
	
	Scanner myScanner = new Scanner(System.in);
	Scanner enterScanner = new Scanner(System.in);
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

	int dragonRing;
	boolean goblinIsDead = false;
	boolean guardIsDead = false;
	boolean enteredCityAlready = false;
	boolean oldManFinished = false;
	boolean mageFinished = false;
	boolean badKidFinished = false;
	boolean isPlayerGuilty = false;
	boolean callHappened = false;

	public static void main(String[] args) {		
		
		new Game(); 
		
		
		
		
	}
	
	public Game() {
		
		try{
	        // load a custom font in your project folder
			pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("dragonwarrior.ttf")).deriveFont(25f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("dragonwarrior.ttf")));			
		}
		catch(IOException | FontFormatException e){
			
		}	
				
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);		
		window.setResizable(false);
		
		container = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("ADVENTURE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont2);
		startButton.setFocusPainted(false);
		startButton.addActionListener(tsHandler);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		container.add(titleNamePanel);
		container.add(startButtonPanel);
		window.setVisible(true);
	}

	public void createGameScreen() {
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
				
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		container.add(mainTextPanel);
		
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(100, 100, 600, 400);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(blue);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		container.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(blue);
		choice1.setForeground(Color.white);
		choice1.setFont(pixelMplus);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(blue);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont2);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(blue);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont2);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(blue);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont2);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100,15,600,50);
		playerPanel.setBackground(Color.black);
	    playerPanel.setLayout(new GridLayout(1,4));
		container.add(playerPanel);
		
		hpLabel = new JLabel("Vida:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		
		weaponLabel = new JLabel("Arma:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
		
		playerSetUp();

	}
	
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			createGameScreen();
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
				east2();
			}
			else if (position.equals("killedGuard") && userChoice.equals("c1")) {
				city1();
			}
			else if (position.equals("city1") && userChoice.equals("c1")) {
				city2();
			}
			
			else if (position.equals("pulled") && userChoice.equals("c4")
					||position.equals("!pulled") && userChoice.equals("c2")) {
				crossRoad();
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
			else if (position.equals("usingPotion2") && userChoice.equals("c1")) {
				attackEnemy("Bárbaro");
			}
			
			else if (position.equals("dead") && userChoice.equals("c1")){
				playerSetUp();				
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
			else if (position.equals("mageFutureRead") && userChoice.equals("c1")){
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
			
		}
	}
	
	
	
	public void playerSetUp() {

		playerHP = 10;
		monsterHP = 30;
		barbaroHP = 40;
		playerPotions = 0;
		specialPower = "";	
		bag = "Bolso";	
		bagSlots = 4;
		guardIsDead = false;
		enteredCityAlready = false;
		oldManFinished = false;
		badKidFinished = false;	
		
		position = "playerSetUp";
		playerWeapon = "Nenhuma";	
		weaponLabelName.setText(playerWeapon);
		hpLabelNumber.setText(""+playerHP);
		
		townGate();
	} 
	
	

	public void townGate() {
		
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
		
		position = "crossRoad";
		mainTextArea.setText("Agora você está em uma encruzilhada. \n\nSe você for para o SUL, retornará para \no portão da cidade.\n\n");
		choice1.setText("Ir para o NORTE.");
		choice2.setText("Ir para o LESTE.");
		choice3.setText("Ir para o SUL.");
		choice4.setText("Ir para o OESTE.");

		
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
	
	public void waitt() {
		try {TimeUnit.SECONDS.sleep(3);} 
		catch (InterruptedException e1) {e1.printStackTrace();}
	}

	public void east() {		
		
		if (playerWeapon.equals("Excalibur")) {
			east3();
		} else {
		position = "east";
		mainTextArea.setText("Você andou um pouco pela floresta e encontrou \numa gigante pedra, com uma espada atravessada \ndentro dela. \n\nA espada está enferrujada, parece que esteve ali por \nMUITO tempo. Na pedra está escrito: ''Excalibur''");
		choice1.setText("Pegar");
		choice2.setText("Voltar");
		choice3.setText("");
		choice4.setText("");}	
	}
	
	public void east2() {		
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
			choice4.setText("Voltar");}	
		
		else if (pull > 2.0){
		position = "!pulled";	
		mainTextArea.setText("Você firmou os pés no chão colocando toda sua força em seus braços, e... \nNão conseguiu. \n\nMas a espada se moveu minimamente, o suficiente \npara lhe dar esperanças de tentar novamente.");
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
	
	
	
	public void east3() {
		if (callHappened) {
			position = "east3_1";	
			mainTextArea.setText("Você observa a densa floresta na sua frente. \n\nNota também que existem 1 rapaz e 2 garota em volta de uma fogueira.");
			choice1.setText("Falar");		
			choice2.setText("Voltar");
			choice3.setText("");
			choice4.setText("");
		}
		else {
			position = "east3";	
		mainTextArea.setText("Você observa a densa floresta na sua frente. \n\nSeria perigoso adentrar nela sem uma grande \nquantidade de mantimentos para semanas. \n\nOu sem uma equipe para lhe ajudar nas \npossíveis ameaças.");
		choice1.setText("Entrar");		
		choice2.setText("Voltar");
		choice3.setText("");
		choice4.setText("");
		}
		
		
	}
	
	public void east4() {
		position = "east4";	
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

	public void west() {
		
		position = "west";
		
		if (!goblinIsDead) {
			
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
		enemyHP = barbaroHP;
		position = "attackingEnemy";
		int playerDamage = 0;

		if (playerWeapon.equals("Nenhuma")) {
			playerDamage = new java.util.Random().nextInt(3);
		} else if (playerWeapon.equals("Excalibur")) {
			playerDamage = new java.util.Random().nextInt(8);
		}
		
		enemyHP -= playerDamage;		

		if (enemyHP < 1) {
			win2(enemyName, enemyHP);
			
		} else if (enemyHP > 0) {
			
			int monsterDamage = 0;
			monsterDamage = new java.util.Random().nextInt(4);			
			
			playerHP -= monsterDamage;
			hpLabelNumber.setText(""+playerHP);
			
			if (playerHP < 1) {
				dead();
			} else if (playerHP > 0) {
				mainTextArea.setText("Você o atacou e infligiu " + playerDamage + " pontos de dano!\n\n" + "Seus Pontos de Vida: " + playerHP+""+ "\nPontos de Vida do "+enemyName+":"+ monsterHP+""+"\n\nO inimigo lhe atacou e infligiu " + monsterDamage + " pontos de dano!");
				choice1.setText("Atacar!");
				choice2.setText("Correr");
				choice3.setText("Poção de Vida "+"("+playerPotions+")");
				choice4.setText(""+specialPower);
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
			choice4.setText("");
		}
		else {
			playerHP -= monsterDamage;
			hpLabelNumber.setText(""+playerHP);
			mainTextArea.setText("Você tentou beber uma Poção de Vida, mas não tem \nnenhuma.\n\nO monstro ficou furioso e lhe atacou, porém o dano \nfoi minimo. (Você tomou "+monsterDamage+" de dano)");
			choice1.setText("Atacar");
			choice2.setText("Correr");
			choice3.setText("Poção de Vida "+"("+playerPotions+")");
			choice4.setText("");
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
			choice4.setText("");
		}
		else {
			playerHP -= monsterDamage;
			hpLabelNumber.setText(""+playerHP);
			mainTextArea.setText("Você tentou beber uma Poção de Vida, mas não tem \nnenhuma.\n\nO monstro ficou furioso e lhe atacou, porém o dano \nfoi minimo. (Você tomou "+monsterDamage+" de dano)");
			choice1.setText("Atacar");
			choice2.setText("Correr");
			choice3.setText("Poção de Vida "+"("+playerPotions+")");
			choice4.setText("");
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
	
		public void win2(String enemyName, int enemyHP) {
		
		position = "win";
		mainTextArea.setText("Você matou o "+enemyName+"!");
		choice1.setText("Voltar");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		

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
					
		position = "city1";
		mainTextArea.setText("É quase um vilarejo, com ruas bem estreitas, cheio \nde casinhas e pequenos comércios. \n\nAs pessoas andam para todos os lados decidindo o \nque comprar. \n\nBarulho para todo lado, parece uma grande feira.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
				
	}
	
	public void city2() {
		
		if (oldManFinished == true && mageFinished == true && !callHappened) {
			call();
		}
		
		else if (oldManFinished == true && badKidFinished == true && guardIsDead == true) {
			captured();
		}		
		
		else {
			position = "city2";
		mainTextArea.setText("Você está agora no centro da cidade. \n\nPara onde você irá? Se você for para o SUL, retornará para o portão da cidade.");
		choice1.setText("Ir para o NORTE");
		choice2.setText("Ir para o LESTE");
		choice3.setText("Ir para o OESTE");
		choice4.setText("Ir para o SUL");
		}
		
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
		specialPower = "Arroz";		
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
		mainTextArea.setText("Todas as pessoas lhe abraçavam e gritavam seu nome, \npedindo para que você finalmente colocasse um FIM \nnesta guerra com os Goblins.");
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
			mainTextArea.setText("Mago: ''Voce já está pronto para cumprir seu destino, faça bom uso de tudo que aprendeu por aqui.''\n''Deseja uma leitura de mãos?''");
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
		mainTextArea.setText("Um ser mágico apareceu na tua frente, com uma forte luz branca para cobrar a morte do pobre Guarda. \n\nVocê se assustou e se arrependeu do fundo de sua alma \npelo ocorrido. Foi perdoado...");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		guardIsDead = false;
		isPlayerGuilty = false;
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
			mainTextArea.setText("Mago: ''Hmm...Interessante...''\n\n''Se prepare bem, recolha o máximo de Poções que puder ao NORTE fora da cidade, para esta sua nova missão. Encontrará também uma linda \ngarota. Bem brava, espinhenta.''\n\n''Uma grande decisão sua no futuro irá decidir o futuro \ndela e de todos nós.''");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		else {		
		position = "mageFutureRead";		
		mainTextArea.setText("Mago: ''Hmm...Interessante...''\n\n''Logo você será convocado para uma grande missão. Se \nprepare bem, recolha o máximo de Poções que puder. \n''Encontrará também uma linda garota. Bem brava, espinhenta.''\n''Uma grande decisão sua no futuro irá decidir o futuro \ndela e de todos nós.''");
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
		mainTextArea.setText("Jovem: ''Cara, essa cidade é podre. Não se deixe \nenganar. Todos aqui irão tentar se aproveitar de você, uma hora ou outra.'' \n\n''Por isso eu devolvo na mesma moeda.'' \n''Vou roubar uma casa rica hoje, vem comigo?''");
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
		
		position = "newJourney";
		mainTextArea.setText("Você chega perto deles e se apresenta. Lê em suas armaduras que o \nnome das garotas são: Iaycha e Shiva. Do rapaz: Ravi. ");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	
	
	
	public void newJourney2() {
		
		position = "newJourney2";
		mainTextArea.setText("Shiva: ''Então você é o escolhido pelo Rei, certo? \nEstavamos te esperando!!! Me dá um abraço!!! O Goblin que você matou, tinha matado meus pais.\n\nShiva sai correndo e te derruba no chão com um abraço \ncarinhoso.");
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
		mainTextArea.setText("Vocês se apresentam e decidem assar peixes, dormir e amanhã cedo adentrar a densa foresta.\n\nÀ luz da fogueira, vocês ficam, enquanto Ravi canta uma \nmúsica com seu violão.");
		choice1.setText("Falar com Shiva");
		choice2.setText("Falar com Iaycha");
		choice3.setText("Falar com Ravi");
		choice4.setText("Dormir");
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}