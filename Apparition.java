import java.util.ArrayList;
import java.util.Scanner;

// import read file
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Apparition {
  public static void main(String[] args) {

    // read files
    String heroe = "heroe.txt";
    String villain = "villain.txt";
    String levelsFile = "levels.txt";
    readFile(heroe);
    readFile(villain);

    // pas to array
    String[] villainArray = readFile(villain).split(",");
    String[] heroeArray = readFile(heroe).split(",");
    String[] levels = readFile(levelsFile).split(",");

    // character data
    ArrayList<String> name = new ArrayList<String>();
    ArrayList<String> occupation = new ArrayList<String>();
    ArrayList<Double> strength = new ArrayList<Double>();
    ArrayList<Double> armor = new ArrayList<Double>();
    ArrayList<Double> speed = new ArrayList<Double>();

    // attacks data
    ArrayList<Double> attacks = new ArrayList<Double>();

    // add values to arrays
    for (int i = 0; i < heroeArray.length; i++) {
      switch (i) {
        case 0:
          name.add(heroeArray[i]);
          name.add(villainArray[i]);
          break;
        case 1:
          occupation.add(heroeArray[i]);
          occupation.add(villainArray[i]);
          break;
        case 2:
          strength.add(Double.parseDouble(heroeArray[i]));
          strength.add(Double.parseDouble(villainArray[i]));
          break;
        case 3:
          armor.add(Double.parseDouble(heroeArray[i]));
          armor.add(Double.parseDouble(villainArray[i]));
          break;
        case 4:
          speed.add(Double.parseDouble(heroeArray[i]));
          speed.add(Double.parseDouble(villainArray[i]));
          break;
      }
    }

    // add heroe attack to attacks array
    attacks.add(calculateAtack(strength.get(0), armor.get(0), speed.get(0)));
    attacks.add(calculateAtack(strength.get(1), armor.get(1), speed.get(1)));

    // starting game
    int scenario = random(levelsFile.length());
    System.out.println();
    System.out.println("Welcome to " + levels[scenario]);

    // introduction
    System.out.println();
    System.out.println("Let's introduce the fighters");
    System.out.println("----------------------------");

    // Show character
    showCharacter(name.get(0), occupation.get(0), strength.get(0), armor.get(0), speed.get(0), attacks.get(0));
    showCharacter(name.get(1), occupation.get(1), strength.get(1), armor.get(1), speed.get(1), attacks.get(1));

    System.out.println();

    startCombat();
  }

  // read file function
  public static String readFile(String file) {
    String text;
    String values = "";
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      while ((text = br.readLine()) != null) {
        // use coma to split
        values = text;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return values;
  }

  // calculate attack ATT = (STR - ARM + SPE*2) * 5
  public static double calculateAtack(double strength, double armor, double speed) {
    double attack = 0.0;
    attack = (strength - armor + speed * 2) * 5;
    if (attack <= 10) {
      attack = 10;
    } else if (attack >= 100) {
      attack = 100;
    }
    return attack;
  }

  // random number generator
  public static int random(int length) {

    // Math.floor(Math.random() * (MAX - MIN + 1)) + MIN;

    double r = Math.floor(Math.random() * (5 - 1)) + 0;
    int randomNumber = (int) r;

    return randomNumber;
  }

  // show character function
  public static void showCharacter(String name, String occupation, Double strength, Double armor, Double speed,
      Double attacks) {

    String strengthData = "";
    String armorData = "";
    String speedData = "";
    System.out.println();
    System.out.println("-----------------------");
    System.out.println(name + " " + occupation);

    // heart character
    int code = 0x2665;
    String code_str = Character.toString((char) code);

    // strength info
    int strengthInt = strength.intValue();
    for (int i = 0; i < strengthInt; i++) {
      strengthData += code_str;
    }
    System.out.println("Strength: " + strengthData);

    // armor info
    int armorInt = armor.intValue();
    for (int i = 0; i < armorInt; i++) {
      armorData += code_str;
    }
    System.out.println("Armor: " + armorData);

    // speed info
    int speedInt = speed.intValue();
    for (int i = 0; i < speedInt; i++) {
      speedData += code_str;
    }
    System.out.println("Speed: " + speedData);

    // attacks info
    System.out.println("Attacks: " + attacks.intValue());

    System.out.println("-----------------------");
  }

  // start the combat
  public static void startCombat() {
    System.out.println("Let the combat begin!!. Press s to Start");
    Scanner sc = new Scanner(System.in);

    // Órdenes
    String action = sc.next();

    switch (action) {
      case "s":
        System.out.println("Pues de forma muy lamentable, hasta aqui hemos llegado...");
        System.out.println("Seguiré con el resto en casa.");
        System.out.println();
        break;

      default:
        break;
    }
    sc.close();
  }

}
