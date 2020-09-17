import java.util.Scanner;

class Main {
  private static boolean getAnswer(Scanner scan) {
       while (true) {
        String yesOrNo = scan.nextLine().trim().toLowerCase();
        switch (yesOrNo) {
        case "y":
          return true;
        case "n":
          return false;
        default:
          System.out.println("Invalid Input Detected! Please enter y/n: ");
          break;
        }
       }
  }

  public static void main(String[] args) {

    Integer[] sfTyrantStat = new Integer[] { 0, 18, 38, 60, 84, 110, 110, 110, 110, 110, 110, 110, 110, 110, 110, 110};

    Integer[] sfTyrantAtk = new Integer[] { 0, 0, 0, 0, 0, 0, 8, 17, 27, 38, 50, 63, 77, 92, 108, 125 };

    // Add 21*
    Integer[] sfArcaneStat = new Integer[] { 0, 2, 4, 6, 8, 10, 13, 16, 19, 22, 25, 28,31,34,37,40, 55,70,85,100,115,130};
    Integer[] sfArcaneAtk = new Integer[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14,29,45,62,80, 99};
    Integer[] sfSuperiorStat = new Integer[] { 0, 2, 4, 6, 8, 10, 13, 16, 19, 22, 25, 28,31,34,37,40,51, 62, 73, 84, 95, 106};
    Integer[] sfSuperiorAtk = new Integer[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10,21,33,46,60,75};
    Integer[] sfReinforcedStat = new Integer[] { 0, 2, 4, 6, 8, 10, 13, 16, 19, 22, 25, 28,31,34,37,40, 49, 58, 67, 76, 85, 94};
    Integer[] sfReinforcedAtk = new Integer[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 19, 30, 42, 55, 69};
    Integer[] sfSolidStat = new Integer[] { 0, 2, 4, 6, 8, 10, 13, 16, 19, 22, 25, 28,31,34,37,40,47,54,61,68,75};
    Integer[] sfSolidAtk = new Integer[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,8,17,27,38,50};
    // Welcome dialog
    System.out.println("Welcome to Halcyon's MCS Calculator\n");

    while (true) {
      // Variable Declaration
      Scanner scan = new Scanner(System.in);
      String yes = "y";
      String ssConst = "ss";
      String agsConst = "ags";
      String primeConst = "prime";
      String scrollType = "";
      Integer scrollStatValue = 0;
      Integer scrollAttValue = 0;
      boolean isGlove = false;
      boolean isTyrant = false;
      boolean isGhostShip = false;
      boolean quit = false;

      // Get Item Level for Starforce Value Check
      System.out.println("Please enter the Item's Level: ");
      int itemLevel = scan.nextInt();
      scan.nextLine();

      // Check if the item is a Glove
      System.out.println("Is this item a Glove? Please enter y/n: ");
      isGlove = getAnswer(scan);

      if (itemLevel == 150) {
        // Check if the item is a Tyrant
        System.out.println("Is this item a Tyrant? Please enter y/n: ");
        isTyrant = getAnswer(scan);
        if (!isTyrant) {
          // Check if the item is a Ghost Ship Badge
          System.out.println("Is this item a Ghost Ship Badge? Please enter y/n: ");
          isGhostShip = getAnswer(scan);
        }
      }

      // Get Type of Scroll Used
      if (!isGhostShip) {
        System.out.println("How is your item scrolled? Please enter ags, ss, or prime.");
        // This lives for another day cuz I'm lazy
        while (!quit) {
          scrollType = scan.nextLine().trim().toLowerCase();
          switch (scrollType) {
          case "ags":
            quit = true;
            break;
          case "ss":
            quit = true;
            break;
          case "prime":
            quit = true;
            break;
          default:
            System.out.println("Invalid Input Detected! Please enter ags, ss or prime: ");
            quit = false;
            break;
          }
        }

        // Calculate added stats from scrolls
        if (scrollType.equals(agsConst)) {
          scrollStatValue = 3;
          scrollAttValue = 4;
        }

        else if (scrollType.equals(ssConst) && isGlove == true) {
          scrollStatValue = 0;
          scrollAttValue = 4;
        }

        else if (isGhostShip) {
          scrollStatValue = 0;
          scrollAttValue = 0;
        }

        else if (scrollType.equals(primeConst)) {
          scrollStatValue = 10;
        }

        else {
          scrollStatValue = 9;
          scrollAttValue = 0;
        }
      }

      // Get Total # of Scrolls used
      System.out.println("Please enter the number of Scrolls used on the item: ");
      int totalScrollCount = scan.nextInt();

      // Get Current Starforce Value
      System.out.println("Please enter the current Star Force of the item: ");
      int currentStars = scan.nextInt();

      // Get Total Added Stat
      System.out.println(
          "Please enter the amount of added desired STAT that you would like to check e.g. if your item has LUK: (10+30), enter 30, not 40: ");
      int addedStatValue = scan.nextInt();

      // Get Total Added ATT
      System.out.println(
          "Please enter the amount of added desired ATT that you would like to check e.g. if your item has ATT: (10+55), enter 55, not 65: ");
      int addedAttValue = scan.nextInt();

      // Get Pre-StarForce Values on clean item
      if (itemLevel >= 130 && itemLevel <= 139) {
        addedStatValue -= sfSolidStat[currentStars];
        addedAttValue -= sfSolidAtk[currentStars];
      }

      if (itemLevel >= 140 && itemLevel <= 149) {
        addedStatValue -= sfReinforcedStat[currentStars];
        addedAttValue -= sfReinforcedAtk[currentStars];
      }

      if (itemLevel >= 150 && itemLevel <= 159 && !isTyrant && !isGhostShip) {
        addedStatValue -= sfSuperiorStat[currentStars];
        addedAttValue -= sfSuperiorAtk[currentStars];
      }

      // Special Checker for Tyrants
      if (itemLevel == 150 && isTyrant) {
        addedStatValue -= sfTyrantStat[currentStars];
        addedAttValue -= sfTyrantAtk[currentStars];
      }

      // Special Checker for Ghost Ship Badge
      if (itemLevel == 150 && isGhostShip) {
        switch (currentStars) {
        case 15:
          addedStatValue = addedStatValue - 40;
          break;
        case 16:
          addedStatValue = addedStatValue - 51;
          break;
        case 17:
          addedStatValue = addedStatValue - 62;
          break;
        case 18:
          addedStatValue = addedStatValue - 73;
          break;
        case 19:
          addedStatValue = addedStatValue - 84;
          break;
        case 20:
          addedStatValue = addedStatValue - 95;
          break;
        case 21:
          addedStatValue = addedStatValue - 106;
          break;
        }
      }

      // Sweetwater Items
      if (itemLevel >= 160 && itemLevel <= 199) {
        switch (currentStars) {
        case 15:
          addedStatValue = addedStatValue - 40;
          break;
        case 16:
          addedStatValue = addedStatValue - 53;
          addedAttValue = addedAttValue - 11;
          break;
        case 17:
          addedStatValue = addedStatValue - 66;
          addedAttValue = addedAttValue - 23;
          break;
        case 18:
          addedStatValue = addedStatValue - 79;
          addedAttValue = addedAttValue - 36;
          break;
        case 19:
          addedStatValue = addedStatValue - 92;
          addedAttValue = addedAttValue - 50;
          break;
        case 20:
          addedStatValue = addedStatValue - 105;
          addedAttValue = addedAttValue - 65;
          break;
        case 21:
          addedStatValue = addedStatValue - 118;
          addedAttValue = addedAttValue - 81;
          break;
        }
      }

      // Arcane Umbra Items
      if (itemLevel == 200) {
        addedStatValue -= sfArcaneStat[currentStars];
        addedAttValue -= sfArcaneAtk[currentStars];
      }

      // In AriesMS, Gloves gain 7 ATT when SF'd from 1-15
      if (isGlove == true)
        addedAttValue = addedAttValue - 7;

      System.out.println("\nCalculating MCS..");
      System.out.println("Minimum MCS Combination found: ");

      if (isGhostShip) {
        System.out.println(totalScrollCount + " Slot MCS Found: STAT: " + addedStatValue + ", WA: +" + addedAttValue);
      }

      if (!isGhostShip) {
        int testSlotScenario = totalScrollCount;

        for (int i = 1; i <= 90; i++) {
          testSlotScenario--;
          int testSlotStat = addedStatValue - (testSlotScenario * scrollStatValue);
          int testSlotAtt = addedAttValue - (testSlotScenario * scrollAttValue);
          if (testSlotStat <= (9 * i) && testSlotAtt <= (9 * i)) {
            System.out.println(i + " Slot MCS Found: STAT: " + testSlotStat + ", WA: +" + testSlotAtt);
            break;
          }

        }
      }
      System.out.println("\nThanks for using Halcyon's MCS Calculator!\n");
      System.out.println("------------------------------------------\n");
      System.out.println("Want to check another item's MCS?");
    }
  }
}
