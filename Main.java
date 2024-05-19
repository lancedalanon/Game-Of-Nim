import java.util.*;

interface Gamer {

    void move(int marblesMax);
    int getDamage();
    void setName(String name);
    String getName();
}

class Student implements Gamer {

    private int damage; // Marbles that are about to be taken by this player.
    private String name; // Player's name.

    // Method where it checks whether the Player input is valid or illegal.
    @Override
    public void move(int marblesMax) {
        
        while (true) {
            
            int compareHealthRounded;
            double compareHealth = marblesMax/2;
            int deterDamage;
            /*If the marbles of the other player is divided and results into a decimal,
            it will round it off to the nearest tenth to form a rounded off whole number.*/
            if (compareHealth >= 0.5) {
                compareHealthRounded = (int) compareHealth + 1;
            } else if (compareHealth == 0) {
                compareHealthRounded = (int) compareHealth + 1;
            }
            else {
                compareHealthRounded = (int) compareHealth;
            }

            while (true) {
                System.out.print("\nEnter Amount to Remove" + " [max: " + compareHealthRounded + "]" + ": ");
                Scanner turn = new Scanner(System.in);
                boolean deterDamageBool = turn.hasNextInt();
                
                if (deterDamageBool == true) {
                    deterDamage = turn.nextInt();
                    break;
                } else {
                    System.out.println("\nThat's an Illegal Move!");
                    System.out.println("\nTry Again!");
                    continue;
                }
            }

            if (compareHealthRounded >= deterDamage) {
                if (deterDamage <= 0) {
                    System.out.println("\nThat's an Illegal Move!");
                    System.out.println("\nTry Again!");
                    continue;
                } else {
                    this.damage = deterDamage;
                    break;
                }
            } 
            else {
                System.out.println("\nThat's an Illegal Move!");
                System.out.println("\nTry Again!");
                continue;
            }
        }
    }

    // Gets the supposed amount of marbles taken from the other Player and the value can be shared.
    @Override
    public int getDamage() {
        return damage;
    }

    // Name setter method.
    @Override
    public void setName(String name) {
        this.name = name;
    }

    // Name getter method.
    @Override
    public String getName() {
        return name;
    }
}

class BelowAveragePC implements Gamer {

    private int damage; // Marbles that are about to be taken by this player.
    private String name; // Player's name.

    @Override
    public void move(int marblesMax) {
        
        int compareHealthRounded;
        double compareHealth = marblesMax/2;
        /*If the marbles of the other player is divided and results into a decimal,
        it will round it off to the nearest tenth to form a rounded off whole number.*/
        if (compareHealth >= 0.5) {
            compareHealthRounded = (int) compareHealth + 1;
        } else if (compareHealth == 0) {
            compareHealthRounded = (int) compareHealth + 1;
        } else {
            compareHealthRounded = (int) compareHealth;
        }
        int deterDamage;
        Random num = new Random();
        deterDamage = num.nextInt(compareHealthRounded);
        if (deterDamage <= 0) {
            deterDamage = deterDamage + 1;
            this.damage = deterDamage;
        } else {
            this.damage = deterDamage;
        }
    }

    // Gets the supposed amount of marbles taken from the other Player and the value can be shared.
    @Override
    public int getDamage() {
        return damage;
    }

    // Name setter method.
    @Override
    public void setName(String name) {
        this.name = name;
    }

    // Name getter method.
    @Override
    public String getName() {
        return name;
    }
}

class SmartPC implements Gamer {
    
    private int damage; // Marbles that are about to be taken by this player.
    private String name; // Player's name.
    int[] pileTarget = {1, 3, 7, 15, 31, 63}; 

    @Override
    public void move(int marblesMax) {

        Random num = new Random();        
        int compareHealthRounded;
        double compareHealth = marblesMax/2;
        /*If the marbles of the other player is divided and results into a decimal,
        it will round it off to the nearest tenth to form a rounded off whole number.*/
        if (compareHealth >= 0.5) {
            compareHealthRounded = (int) compareHealth + 1;
        } else if (compareHealth == 0) {
            compareHealthRounded = (int) compareHealth + 1;
        } else {
            compareHealthRounded = (int) compareHealth;
        }

        if (compareHealthRounded > 1) {
            if (compareHealthRounded == 3 || compareHealthRounded == 7|| compareHealthRounded == 15 || compareHealthRounded == 31 || compareHealthRounded == 63) {
                this.damage = num.nextInt(compareHealthRounded) + 1;
            } else {
                do {
                    this.damage = compareHealthRounded - pileTarget[num.nextInt(6)];
                } while ((this.damage > (compareHealthRounded) || this.damage <= 0));
            }
        } else {
            this.damage = 1;
        }
    }

    // Gets the supposed amount of marbles taken from the other Player and the value can be shared.
    @Override
    public int getDamage() {
        return damage;
    }

    // Name setter method.
    @Override
    public void setName(String name) {
        this.name = name;
    }

    // Name getter method.
    @Override
    public String getName() {
        return name;
    }
}

class Pile {

    int pilePlayer; // Player 1's pile that can be shared.
    int pileGen; // Player 1's pile that is generated randomly and can be shared.
    
    // Randomly Generates Player 1's pile.
    public void getPile() {
        Random r1 = new Random();
        pileGen = r1.nextInt((95 - 20) + 1) + 20;
        pilePlayer = pileGen;
    }

    // Manages the amount taken and holds the amount generated.
    public void pileManager(int damage) {
        if (pilePlayer <= 0) {
            pilePlayer = 0;
            getPile();
        }
        pilePlayer = pilePlayer - damage;
    }

    // Amount of marbles Player 1 being taken from them.
    public void pileInteract(int damage) {
        pileManager(damage);
    }
}

class SecondPile extends Pile {

    int pilePlayer; // Player 2's pile that can be shared.
    int pileGen; // Player 2's pile that is generated randomly and can be shared.
    
    // Randomly Generates Player 2's pile.
    public void getPile() {
        Random r1 = new Random();
        pileGen = r1.nextInt((95 - 20) + 1) + 20;
        pilePlayer = pileGen;
    }

    // Manages the amount taken and holds the amount generated.
    public void pileManager(int damage) {
        if (pilePlayer <= 0) {
            pilePlayer = 0;
            getPile();
        }
        pilePlayer = pilePlayer - damage;
    }

    // Amount of marbles Player 2 being taken from them.
    public void pileInteract(int damage) {
        pileManager(damage);
    }
}

class Nim {

    Pile p1 = new Pile(); // Polymorphically calls for Player 1's Pile.
    SecondPile p2 = new SecondPile(); // Polymorphically calls for Player 2's Pile.
    private boolean calculating = true; // Status of whether the class is active or not.
    int count; // Number of times this class instance has been used.
    private int currentMarbles1; // Number of current marbles Player1 has that can be used for other class.
    private int currentMarbles2; // Number of current marbles Player2 has that can be used for other class.

    // Sets 1 second delay for each code
    public void delay() {
        int timeToWait = 1; 
        System.out.print("\nLoading..");
        try {
            for (int i=0; i<timeToWait ; i++) {
                Thread.sleep(1000);
                System.out.print(".");
            }
        } catch (InterruptedException ie)
        {
            Thread.currentThread().interrupt();
        }
    }

    // Gets current status of the calculation
    public boolean getStatus() {
        return calculating;
    }

    // Sets to calculating which means there's calculation happening througout
    public void setStatus(boolean calculating) {
        this.calculating = calculating;
    }

    // Marble Getter for Player 1
    public int getMarbles1() {
        return currentMarbles1;
    }

    // Marble Getter for Player 1
    public void setMarbles1(int marbles) {
        this.currentMarbles1 = marbles;
    }

    // Marble Setter for Player 2
    public int getMarbles2() {
        return currentMarbles2;
    }

    // Marble Setter for Player 2
    public void setMarbles2(int marbles) {
        this.currentMarbles2 = marbles;
    }

    // The method where all of the variables interact and where the calculations are done are in this section.
    public void play(String playerName1, String playerName2, int firstTurn, int damage, int damage2) {
        
        int marblesTaken1 = 0;
        int marblesTaken2 = 0;
        int toDamage1 = 0;
        int toDamage2 = 0;

        // Announces who will go first
        if (count == 0) {
            if (firstTurn == 0) {
                System.out.println("\n" + playerName1 + " is going first!");
            } else {
                System.out.println("\n" + playerName2 + " is going first!");
            }
        }

        // Announces randomly generated marbles for each player.
        if (count == 1) {

            delay();
            System.out.println("\n\nMarbles Generated For Each: ");
            System.out.println(playerName1 + ": " + p1.pileGen);
            System.out.println(playerName2 + ": " + p2.pileGen);

        } 
        // Announces currennt marbles each player has after each turn.
        else if (count > 1) {

            delay();
            System.out.println("\n\nCurrent Marbles: ");
            System.out.println(playerName1 + ": " + p1.pilePlayer);
            System.out.println(playerName2 + ": " + p2.pilePlayer);
        }

        if (firstTurn == 0) { // If 1st Player goes first.

            // Player 1 Turn
            if (count == 0) {
                System.out.print("\nGenerating Marbles...\n");
                toDamage1 = 0;
            } else if (count >= 1) {
                toDamage1 = damage;
            }

            // Player 1 Amount of Marbles to Take
            p2.pileInteract(toDamage1);
            if (count >= 1) {
                delay();
                marblesTaken1 = toDamage1;
                System.out.println("\n\n" + playerName1 + " took " + marblesTaken1 + " marbles from " + playerName2);
            }
            delay();
            System.out.println("\n\n" + playerName2 + " has " + p2.pilePlayer + " marbles left.");

            // Check if Player 2 still has marbles
            if (p2.pilePlayer <= 0 && p1.pilePlayer > 0) {
                delay();
                System.out.println("\n\n" + playerName2 + "'s marbles: " + p2.pilePlayer);
                System.out.println("\n" + playerName2 + " wins!");
                count = 0;
                setMarbles1(0);
                setMarbles2(0);
                setStatus(false);
            }

            // Player 2 Turn
            if (count == 0) {
                toDamage2 = 0;
            } else if (count >= 1) {
                toDamage2 = damage2;
            }

            // Player 2 Amount of Marbles to Take
            p1.pileInteract(toDamage2);
            if (count >= 1) {
                delay();
                marblesTaken2 = toDamage2;
                System.out.println("\n\n" + playerName2 + " took " + marblesTaken2 + " marbles from " + playerName1);
            }
            delay();
            System.out.println("\n\n" + playerName1 + " has " + p1.pilePlayer + " marbles left.");

            // Check if Player 1 still has marbles
            if (p1.pilePlayer <= 0 && p2.pilePlayer > 0) {
                delay();
                System.out.println("\n\n" + playerName1 + "'s marbles: " + p1.pilePlayer);
                System.out.println("\n" + playerName1 + " wins!");
                count = 0;
                setMarbles1(0);
                setMarbles2(0);
                setStatus(false);
            }
        } 
        else { // If 2nd Player goes first.
            
            // Player 2 Turn
            if (count == 0) {
                System.out.print("\nGenerating Marbles...\n");
                toDamage2 = 0;
            } else if (count >= 1) {
                toDamage2 = damage2;
            }

            // Player 2 Amount of Marbles to Take
            p1.pileInteract(toDamage2);
            if (count >= 1) {
                delay();
                marblesTaken2 = toDamage2;
                System.out.println("\n\n" + playerName2 + " took " + marblesTaken2 + " marbles from " + playerName1);
            }
            delay();
            System.out.println("\n\n" + playerName1 + " has " + p1.pilePlayer + " marbles left.");

            // Check if Player 1 still has marbles
            if (p1.pilePlayer <= 0 && p2.pilePlayer > 0) {
                delay();
                System.out.println("\n\n" + playerName1 + "'s marbles: " + p1.pilePlayer);
                System.out.println("\n" + playerName1 + " wins!");
                count = 0;
                setMarbles1(0);
                setMarbles2(0);
                setStatus(false);
            }

            // Player 1 Turn
            if (count == 0) {
                toDamage1 = 0;
            } else if (count >= 1) {
                toDamage1 = damage;
            }

            // Player 1 Amount of Marbles to Take
            p2.pileInteract(toDamage1);
            if (count >= 1) {
                delay();
                marblesTaken1 = toDamage1;
                System.out.println("\n\n" + playerName1 + " took " + marblesTaken1 + " marbles from " + playerName2);
            }
            delay();
            System.out.println("\n\n" + playerName2 + " has " + p2.pilePlayer + " marbles left.");

            // Check if Player 2 still has marbles
            if (p2.pilePlayer <= 0 && p1.pilePlayer > 0) {
                delay();
                System.out.println("\n\n" + playerName2 + "'s marbles: " + p2.pilePlayer);
                System.out.println("\n" + playerName2 + " wins!");
                count = 0;
                setMarbles1(0);
                setMarbles2(0);
                setStatus(false);
            }
        }

        setMarbles1(p1.pilePlayer);
        setMarbles2(p2.pilePlayer);
        count++;
    }
}

public class Main {

    static int currentP1 = 0; // Player 1 current marbles.
    static int currentP2 = 0; // Player 2 current marbles.
    static Student myPlayer = new Student();
    static BelowAveragePC myPC1 = new BelowAveragePC();
    static SmartPC myPC2 = new SmartPC();

    public static void setPlayers(char difficulty, int currentP1, int currentP2) {
        // A = Easy, B = Hard
        if (difficulty == 'A' || difficulty == 'a') {
            myPlayer.move(currentP2);
            myPC1.move(currentP1);
        } else {
            myPlayer.move(currentP2);
            myPC2.move(currentP1);
        }
    }

    public static void main(String[] args) {

        int a = 0;
        boolean playing = true;
        char difficulty = '\0';
        char turnOpt = '\0';
        char turnOpt2 = '\0';
        String playerName1 = "";
        String playerName2 = "";
        
        while (true) {

            int firstTurn = 0;

            if (a >= 1) {
                Scanner choice = new Scanner(System.in);
                System.out.print("\nChange Name and Difficulty? (Y/N): ");
                char playerChoice = choice.next().charAt(0);

                if (playerChoice == 'Y' || playerChoice == 'y') {
                    Scanner myName = new Scanner(System.in);
                    System.out.print("\nEnter Your Name: ");
                    playerName1 = myName.nextLine();
                    Scanner myName2 = new Scanner(System.in);
                    System.out.print("\nEnter Your Opponent's Name: ");
                    playerName2 = myName2.nextLine();
                    Scanner myDiffculty = new Scanner(System.in);
                    System.out.print("\nA: Easy or B: Hard? (A/B): ");
                    difficulty = myDiffculty.next().charAt(0);
                    Scanner turn = new Scanner(System.in);
                    System.out.print("\nWho's going first? A - Randomize or B - Choose (A/B): ");
                    turnOpt = turn.next().charAt(0);
                    if (turnOpt == 'B' || turnOpt == 'b') {
                        System.out.print("\nWho's going first? " + "A: " + playerName1 + " or " + "B: " + playerName2 + "?" + " (A/B): ");
                        turnOpt2 = turn.next().charAt(0);
                        if (turnOpt2 == 'A' || turnOpt2 == 'a') {
                            firstTurn = 0;
                        } else {
                            firstTurn = 1;
                        }
                    } else {
                        Random rand = new Random();
                        firstTurn = 0 + rand.nextInt((1 - 0) + 1);
                    }
                    playing = true;

                } else {
                    Scanner quit = new Scanner(System.in);
                    System.out.print("\nQuit The Game? (Y/N): ");
                    char quitChoice = quit.next().charAt(0);
                    
                    if (quitChoice == 'Y' || quitChoice == 'y') {
                        System.out.println("\nSee You Again! ");
                        break;
                    }
                }

            } else {
                System.out.print("Game Start!\nWelcome to The Game of Nim!");
                Scanner myName = new Scanner(System.in);
                System.out.print("\n\nEnter Your Name: ");
                playerName1 = myName.nextLine();
                Scanner myName2 = new Scanner(System.in);
                System.out.print("\nEnter Your Opponent's Name: ");
                playerName2 = myName2.nextLine();
                Scanner myDiffculty = new Scanner(System.in);
                System.out.print("\nA: Easy or B: Hard? (A/B): ");
                difficulty = myDiffculty.next().charAt(0);
                System.out.print("\nWho's going first? A - Randomize or B - Choose (A/B): ");
                Scanner turn = new Scanner(System.in);
                turnOpt = turn.next().charAt(0);
                if (turnOpt == 'B' || turnOpt == 'b') {
                    System.out.print("\nWho's going first? " + "A: " + playerName1 + " or " + "B: " + playerName2 + "?" + " (A/B): ");
                    turnOpt2 = turn.next().charAt(0);
                    if (turnOpt2 == 'A' || turnOpt2 == 'a') {
                        firstTurn = 0;
                    } else {
                        firstTurn = 1;
                    }
                } else {
                    Random rand = new Random();
                    firstTurn = 0 + rand.nextInt((1 - 0) + 1);
                }
                playing = true;
            }
                
            int i = 0;

            while (playing) {

                Nim myGame = new Nim();

                // Askes the player whether the one who goes first is decided by random or by choice themselves.
                if (i >= 1) {

                    System.out.print("\nWho's going first? A - Randomize or B - Choose (A/B): ");
                    Scanner turn = new Scanner(System.in);
                    turnOpt = turn.next().charAt(0);
                    if (turnOpt == 'B' || turnOpt == 'b') {
                        System.out.print("\nWho's going first? " + "A: " + playerName1 + " or " + "B: " + playerName2 + "?" + " (A/B): ");
                        turnOpt2 = turn.next().charAt(0);
                        if (turnOpt2 == 'A' || turnOpt2 == 'a') {
                            firstTurn = 0;
                        } else {
                            firstTurn = 1;
                        }
                    } else {
                        Random rand = new Random();
                        firstTurn = 0 + rand.nextInt((1 - 0) + 1);
                    }
                }
                
                int sampleDamage1;
                int sampleDamage2;
                String name_P1 = "";
                String name_P2 = "";

                while (myGame.getStatus()) {

                    if (myGame.count > 0) {
                        currentP1 = (myGame.getMarbles1());
                        currentP2 = (myGame.getMarbles2());
                        setPlayers(difficulty, currentP1, currentP2);
                        myPlayer.setName(playerName1);
                        myPC1.setName(playerName2);
                        myPC2.setName(playerName2);
                        sampleDamage1 = (myPlayer.getDamage());
                        name_P1 = (myPlayer.getName());
                        // A = Easy, B = Hard
                        if (difficulty == 'A' || difficulty == 'a') {
                            name_P2 = (myPC1.getName());
                            sampleDamage2 = (myPC1.getDamage());
                        } else {
                            name_P2 = (myPC2.getName());
                            sampleDamage2 = (myPC2.getDamage());
                        }
                    } else {
                        sampleDamage1 = 0;
                        sampleDamage2 = 0;
                        myPlayer.setName(playerName1);
                        myPC1.setName(playerName2);
                        myPC2.setName(playerName2);
                        name_P1 = (myPlayer.getName());
                        // A = Easy, B = Hard
                        if (difficulty == 'A' || difficulty == 'a') {
                            name_P2 = (myPC1.getName());
                        } else {
                            name_P2 = (myPC2.getName());
                        }
                    }
                    
                    myGame.play(name_P1, name_P2, firstTurn, sampleDamage1, sampleDamage2);
                }

                /*When the game finishes, it askes whether the player wants to try again
                with the same names and difficulty or change both.*/
                Scanner reset = new Scanner(System.in);
                System.out.print("\nTry Again? (Y/N): ");
                char playerResp = reset.next().charAt(0);

                if (playerResp == 'N' || playerResp == 'n') {
                    playing = false;
                } else {
                    i++;
                    myGame.setStatus(true);
                    continue;
                }
            a++;
            }
        }
    }
}
