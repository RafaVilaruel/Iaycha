import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
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
	public Font normalFont = new Font ("Times New Roman", Font.PLAIN, 28);
	public Font shortFont = new Font ("Times New Roman", Font.PLAIN, 10);
	public JButton startButton, choice1, choice2, choice3, choice4;
	public JTextArea mainTextArea;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();	
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	Scanner myScanner = new Scanner(System.in);
	Scanner enterScanner = new Scanner(System.in);
	int playerHP;
	String playerName, position;
	String playerWeapon;
	int choice;
	int monsterHP;
	int playerPotions;

	int dragonRing;
	boolean goblinIsDead = false;

	public static void main(String[] args) {		
		
		new Game(); 
		
		
	}
	
	public Game() {
			
				
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
		startButton.setFont(normalFont);
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
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		container.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
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
			
			
			else if (position.equals("north2") && userChoice.equals("c1") 
					|| position.equals("east2") && userChoice.equals("c2")
					|| position.equals("east3") && userChoice.equals("c1")
					|| position.equals("east") && userChoice.equals("c2")
					|| position.equals("staringGoblin") && userChoice.equals("c2")
					|| position.equals("fightGoblin") && userChoice.equals("c2")
					|| position.equals("attackingGoblin") && userChoice.equals("c2")
					|| position.equals("win") && userChoice.equals("c1")
					|| position.equals("afterDestruction") && userChoice.equals("c1")
					|| position.equals("usingPotion") && userChoice.equals("c2")) {
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
					|| position.equals("fightGoblin") && userChoice.equals("c3")){
				usePotion();			
			}		
			
			else if (position.equals("dead") && userChoice.equals("c1")){
				playerSetUp();				
			}		
			
						
			
		}
	}
	
	
	
	public void playerSetUp() {

		playerHP = 10;
		monsterHP = 30;
		playerPotions = 0;

		position = "playerSetUp";
		playerWeapon = "Nenhuma";	
		weaponLabelName.setText(playerWeapon);
		hpLabelNumber.setText(""+playerHP);
		
		townGate();
	} 
	
	

	public void townGate() {

		position = "townGate";
		
		mainTextArea.setText("Você está no portão de uma cidade.\nUm guarda está parado na sua frente.\n\nO que você irá fazer?");
		
		choice1.setText("Falar com o guarda");
		choice2.setText("Atacar o guarda");
		choice3.setText("Ir embora");
		choice4.setText("");
		
	}
	
	public void talkGuard() {
		position = "talkGuard";
		if (dragonRing == 1) {
			ending();
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
		position = "attackGuard";
		mainTextArea.setText("Guarda: ''Ei, não seja estúpido.''\n\nO guarda te acertou tão forte que você decidiu \nnão atacar mais.\n\n(Você recebeu 3 pontos de dano)");
		playerHP -= 3;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
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
		if (playerPotions == 4) {
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
		mainTextArea.setText("Você guardou a Poção de Vida em seu bolso (4 slots)\n\nVocê poderá beber Poções de Vida em momentos de \ndesespero. \n\nPoções de vida equipadas: "+playerPotions);
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
			mainTextArea.setText("Sua alma se uniu com seus braços, você juntou \nforças e...CONSEGUIU! \n\nVocê retira a espada e aponta para o alto, em sinal de vitória. \n\n(Excalibur equipada - Inflige 0-8 Pontos de Dano)");
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
			mainTextArea.setText("Você se apoiou na pedra, puxou a espada para trás e...Não conseguiu. \n\nA espada nem se moveu.\n\n''Talvez eu devesse tentar várias vezes seguidas \nsem parar, sem desistir!''");
			choice1.setText("Tentar");
			choice2.setText("Desistir");
			choice3.setText("");
			choice4.setText("");
		}
		
		}		
	
	public void east3() {
		position = "east3";	
		mainTextArea.setText("Você observa a densa floresta na sua frente. \n\nSeria perigoso adentrar nela sem uma grande \nquantidade de mantimentos para semanas. \n\nOu uma equipe para lhe ajudar nas possíveis ameaças.");
		choice1.setText("Voltar");		
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
	
	public void usePotion() {
		position = "usingPotion";
		
		int monsterDamage = 0;
		monsterDamage = new java.util.Random().nextInt(3);
		
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

	public void ending() {
		
		position = "ending";
		mainTextArea.setText("Guarda: Duvido. Você matou o Goblin que tanto \nnos atormentava? Prove.\n\n...Esse é o lendário Anel do Dragão!!! \n\nVocê matou ele mesmo! Você realmente é alguém que podemos confiar. Seja bem-vindo à cidade! ");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setText("Entrar");
		
		} 
}