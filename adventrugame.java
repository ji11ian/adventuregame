import java.util.Scanner;
public class AdventureGameLite {

    int s = 0, h = 100;
    String l = "entrance", a = "";
    boolean k = false, sw = false;

    public static void main(String[] args) {
        System.out.println("Welcome to Colossal Cave Adventure!\nYour objective is to find the treasure hidden in the cave. You will need to explore different rooms and solve puzzles to make your way through the cave. Be careful though, there are traps and monsters hiding in the shadows.");

        while (true) {
            System.out.println("You are currently in the " + l + ".\nWhat would you like to do? (Enter a command)");
            Scanner scanner = new Scanner(System.in);
            a = scanner.nextLine();

            if (a.equals("north")) moveNorth();
            else if (a.equals("south")) moveSouth();
            else if (a.equals("east")) moveEast();
            else if (a.equals("west")) moveWest();
            else if (a.equals("take key")) takeKey();
            else if (a.equals("take sword")) takeSword();
            else if (a.equals("open door")) openDoor();
            else if (a.equals("attack monster")) attackMonster();
            else if (a.equals("drink potion")) drinkPotion();
            else System.out.println("Sorry, I didn't understand that command.");

            if (h <= 0) {
                System.out.println("You have died. Game over.");
                break;
            } else if (l.equals("treasure room")) {
                System.out.println("Congratulations, you have found the treasure and won the game!\nYour score is " + s);
                break;
            }
        }
    }

    private static void moveNorth() {
        if (l.equals("entrance")) {
            l = "hallway";
            s += 10;
            System.out.println("You have entered the hallway.");
        } else System.out.println("You can't go that way.");
    }

    private static void moveSouth() {
        if (l.equals("hallway")) {
            l = "entrance";
            s -= 5;
            System.out.println("You have returned to the entrance.");
        } else if (l.equals("dungeon")) {
            l = "hallway";
            s += 5;
            System.out.println("You escaped the dungeon and returned to the hallway.");
        } else System.out.println("You can't go that way.");
    }

    private static void moveEast() {
        if (l.equals("hallway")) {
            l = "library";
            s += 10;
            System.out.println("You have entered the library.");
        } else System.out.println("You can't go that way.");
    }

    private static void moveWest() {
        if (l.equals("library")) {
            l = "hallway";
            s -= 5;
            System.out.println("You have returned to the hallway.");
        } else System.out.println("You can't go that way.");
    }

    private static void takeKey() {
        if (l.equals("library")) {
            k = true;
            s += 5;
            System.out.println("You have taken the key.");
        } else System.out.println("There is no key here to take.");
    }

    private static void takeSword() {
        if (l.equals("dungeon")) {
            sw = true;
            s += 10;
            System.out.println("You have taken the sword.");
        } else System.out.println("There is no sword here to take.");
    }

    private static void openDoor() {
        if (currentLocation.equals("hallway")) {
            if (hasKey) {
                currentLocation = "treasure room";
                score += 50;
                System.out.println("You have opened the door and entered the treasure room.");
            } else {
                System.out.println("The door is locked. You need a key to open it.");
            }
        } else {
            System.out.println("There is no door to open here.");
        }
    }

    private static void attackMonster() {
        if (currentLocation.equals("dungeon")) {
            if (hasSword) {
                score += 20;
                System.out.println("You have defeated the monster with your sword!");
            } else {
                health -= 20;
                System.out.println("You don't have a weapon to attack the monster with. It has injured you.");
            }
        } else {
            System.out.println("There is no monster to attack here.");
        }
    }

    private static void drinkPotion() {
        if (currentLocation.equals("library")) {
            health += 20;
            score += 5;
            System.out.println("You have regained some health by drinking the potion.");
        } else {
            System.out.println("There is no potion to drink here.");
        }
    }
