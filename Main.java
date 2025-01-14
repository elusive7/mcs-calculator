import java.util.Scanner;

class Main {
  private static boolean getAnswer(Scanner scan) {
    while (true) {
      switch (scan.nextLine().trim().toLowerCase()) {
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

  private static String getScrollType(Scanner scan) {
    while (true) {
      String scrollType = scan.nextLine().trim().toLowerCase();
      switch (scrollType) {
        case "ags":
        case "ss":
        case "prime":
          return scrollType;
        default:
          System.out.println("Invalid Input Detected! Please enter ags, ss or prime: ");
          break;
      }
    }
  }

  public static void main(String[] args) {
    // sf stat table
    Integer[] sfTyrantStat = { 0, 18, 38, 60, 84, 110, 110, 110, 110, 110, 110, 110, 110, 110, 110, 110 };
    Integer[] sfTyrantAtt = { 0, 0, 0, 0, 0, 0, 8, 17, 27, 38, 50, 63, 77, 92, 108, 125, 143 };
    Integer[] sfArcaneStat = { 0, 2, 4, 6, 8, 10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 55, 70, 85, 100, 115, 130, 145, 145, 145, 145 };
    Integer[] sfArcaneAtt = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 29, 45, 62, 80, 99, 119, 142, 166, 191 };
    Integer[] sfSweetWaterStat = { 0, 2, 4, 6, 8, 10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 53, 66, 79, 92, 105, 118, 131, 131, 131, 131 };
    Integer[] sfSweetWaterAtt = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 23, 36, 50, 65, 81, 98, 116, 135, 155 };
    Integer[] sfSuperiorStat = { 0, 2, 4, 6, 8, 10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 51, 62, 73, 84, 95, 106, 117, 117, 117, 117 };
    Integer[] sfSuperiorAtt = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 21, 33, 46, 60, 75, 91, 108, 126, 145 };
    Integer[] sfReinforcedStat = { 0, 2, 4, 6, 8, 10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 49, 58, 67, 76, 85, 94, 103, 103, 103, 103 };
    Integer[] sfReinforcedAtt = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 19, 30, 42, 55, 69, 84, 100, 117, 135 };
    Integer[] sfSolidStat = { 0, 2, 4, 6, 8, 10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 47, 54, 61, 68, 76, 85, 94, 94, 94, 94 };
    Integer[] sfSolidAtt = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 17, 27, 38, 50, 63, 77, 92, 108, 125 };

    // Welcome dialog
    System.out.println("\nWelcome to Divine's AriesMS MCS Calculator! Flames are not supported yet.\n");

    while (true) {
      // Variable Declaration
      Scanner scan = new Scanner(System.in);
      Integer scrollStatValue = 0;
      Integer scrollAttValue = 0;
      boolean isGlove = false;
      boolean isTyrant = false;
      boolean isGhostShip = false;

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
        if (!isTyrant && !isGlove) {
          // Check if the item is a Ghost Ship Badge
          System.out.println("Is this item a Ghost Ship Badge? Please enter y/n: ");
          isGhostShip = getAnswer(scan);
        }
      }

      // Get Type of Scroll Used
      if (!isGhostShip) {
        System.out.println("How is this item scrolled? Please enter ags, ss, or prime.");
        // Calculate added stats from scrolls
        switch (getScrollType(scan)) {
          case "ags":
            scrollStatValue = 3;
            scrollAttValue = 4;
            break;
          case "ss":
            if (isGlove) {
              scrollStatValue = 0;
              scrollAttValue = 4;
            } else {
              scrollStatValue = 9;
              scrollAttValue = 0;
            }
            break;
          case "prime":
            scrollStatValue = 10;
            break;
          default:
        }
      }

      // Get Total # of Scrolls used
      System.out.println("Please enter the total number of Scrolls used on the item: ");
      int totalScrollCount = scan.nextInt();

      // Get Current Starforce Value
      System.out.println("Please enter the current Star Force of the item: ");
      int currentStars = scan.nextInt();

      // Validate Current Stars for 25 Star Support
      if (currentStars < 0 || currentStars > 25) {
        System.out.println("Invalid Star Force value: " + currentStars + ". Please enter a value between 0 and 25.");
        continue; // Restart the loop if invalid input
      }

      // Get Total Added Stat
      System.out.println(
          "Please enter the amount of added desired STAT that you would like to check e.g. if this item has LUK: (10+30), enter 30, not 40: ");
      int addedStatValue = scan.nextInt();

      // Get Total Added ATT
      System.out.println(
          "Please enter the amount of added desired ATT that you would like to check e.g. if this item has ATT: (10+55), enter 55, not 65: ");
      int addedAttValue = scan.nextInt();

      // Get Pre-StarForce Values on clean item
      if (itemLevel >= 130 && itemLevel <= 139) {
        addedStatValue -= sfSolidStat[currentStars];
        addedAttValue -= sfSolidAtt[currentStars];
      }

      if (itemLevel >= 140 && itemLevel <= 149) {
        addedStatValue -= sfReinforcedStat[currentStars];
        addedAttValue -= sfReinforcedAtt[currentStars];
      }

      if (itemLevel >= 150 && itemLevel <= 159 && !isTyrant) {
        addedStatValue -= sfSuperiorStat[currentStars];
        if (!isGhostShip) {
          addedAttValue -= sfSuperiorAtt[currentStars];
        }
      }

      // Special Checker for Tyrants
      if (itemLevel == 150 && isTyrant) {
        addedStatValue -= sfTyrantStat[currentStars];
        addedAttValue -= sfTyrantAtt[currentStars];
      }

      // Sweetwater Items
      if (itemLevel >= 160 && itemLevel <= 199) {
        addedStatValue -= sfSweetWaterStat[currentStars];
        addedAttValue -= sfSweetWaterAtt[currentStars];
      }

      // Arcane Umbra Items
      if (itemLevel == 200) {
        addedStatValue -= sfArcaneStat[currentStars];
        addedAttValue -= sfArcaneAtt[currentStars];
      }

      // In AriesMS, Gloves gain 7 ATT when SF'd from 1-15,
      // gaining att at 1,3,5,7,11,13.
      if (isGlove == true) {
        int extraGloveAtt = (Math.min(currentStars, 13) + 1) / 2;
        addedAttValue = addedAttValue - extraGloveAtt;
      }

      System.out.println("\nCalculating MCS...");
      System.out.println("Minimum MCS Combination found: ");

      if (isGhostShip) {
        System.out.println(totalScrollCount + " Slot MCS Found: STAT: " + addedStatValue + ", WA: " + addedAttValue);
      } else {
        int testSlotScenario = totalScrollCount;

        for (int i = 1; i <= 90; i++) {
          testSlotScenario--;
          int testSlotStat = addedStatValue - (testSlotScenario * scrollStatValue);
          int testSlotAtt = addedAttValue - (testSlotScenario * scrollAttValue);
          if (testSlotStat <= (9 * i) && testSlotAtt <= (9 * i)) {
            System.out.println(i + " Slot MCS Found: STAT: " + testSlotStat + ", WA: " + testSlotAtt);
            break;
          }
        }
      }
      System.out.println("\nThanks for using Divine's MCS Calculator!\n");
      System.out.println("------------------------------------------\n");
      System.out.println("Want to check another item's MCS?");
    }
  }
}