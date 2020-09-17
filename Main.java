import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        //Welcome dialog
        System.out.println("Welcome to Halcyon's MCS Calculator\n");

        while(true) {
            //Variable Declaration
            Scanner scan = new Scanner(System.in);
            String no = "n";
            String yes = "y";
            String ssConst = "ss";
            String agsConst = "ags";
            String primeConst = "prime";
            String scrollType = ""; 
            Integer scrollStatValue = 0;
            Integer scrollAttValue = 0;
            boolean mcsFound = false;
            boolean isGlove = false;
            boolean isTyrant = false;
            boolean isGhostShip = false;

            //Get Item Level for Starforce Value Check
            System.out.println("Please enter the Item's Level: ");
            int itemLevel = scan.nextInt();
            scan.nextLine();

            //Check if the item is a Glove
            System.out.println("Is this item a Glove? Please enter y/n: ");
            String yesOrNo = scan.nextLine();
            if (yesOrNo.equals(yes)) {
            isGlove = true;
            }

            if (itemLevel == 150) {
                //Check if the item is a Tyrant
                System.out.println("Is this item a Tyrant? Please enter y/n: ");
                yesOrNo = scan.nextLine();
                if (yesOrNo.equals(yes)) {
                    isTyrant = true;
                }

                if (!isTyrant) {
                    //Check if the item is a Ghost Ship Badge
                    System.out.println("Is this item a Ghost Ship Badge? Please enter y/n: ");
                    yesOrNo = scan.nextLine();
                    if (yesOrNo.equals(yes)) {
                        isGhostShip = true;
                    }
                }
            }
                   
            //Get Type of Scroll Used
            if (!isGhostShip) {
                System.out.println("How is your item scrolled? Please enter ags, ss, or prime.");
                scrollType = scan.nextLine().trim().toLowerCase();

                //Calculate added stats from scrolls
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

            //Get Total # of Scrolls used
            System.out.println("Please enter the number of Scrolls used on the item: ");
            int totalScrollCount = scan.nextInt();

            //Get Current Starforce Value
            System.out.println("Please enter the current Star Force of the item: ");
            int currentStars = scan.nextInt();

            //Get Total Added Stat
            System.out.println("Please enter the amount of added desired STAT that you would like to check e.g. if your item has LUK: (10+30), enter 30, not 40: ");
            int addedStatValue = scan.nextInt();

            //Get Total Added ATT
            System.out.println("Please enter the amount of added desired ATT that you would like to check e.g. if your item has ATT: (10+55), enter 55, not 65: ");
            int addedAttValue = scan.nextInt();
        
            //Get Pre-StarForce Values on clean item
            if (itemLevel >= 130 && itemLevel <= 139) {
                switch(currentStars) {
                    case 15:
                        addedStatValue = addedStatValue-40;
                        break;
                    case 16:
                        addedStatValue = addedStatValue-47;
                        addedAttValue = addedAttValue-8;
                        break;   
                    case 17:
                        addedStatValue = addedStatValue-54;
                        addedAttValue = addedAttValue-17;
                        break; 
                    case 18:
                        addedStatValue = addedStatValue-61;
                        addedAttValue = addedAttValue-27;
                        break;
                    case 19:
                        addedStatValue = addedStatValue-68;
                        addedAttValue = addedAttValue-38;
                        break;   
                    case 20:
                        addedStatValue = addedStatValue-75;
                        addedAttValue = addedAttValue-50;
                        break;   
                }
            }

            if (itemLevel >= 140 && itemLevel <= 149) {
                switch(currentStars) {
                    case 15:
                        addedStatValue = addedStatValue-40;
                        break;
                    case 16:
                        addedStatValue = addedStatValue-49;
                        addedAttValue = addedAttValue-9;
                        break;   
                    case 17:
                        addedStatValue = addedStatValue-58;
                        addedAttValue = addedAttValue-19;
                        break; 
                    case 18:
                        addedStatValue = addedStatValue-67;
                        addedAttValue = addedAttValue-30;
                        break;
                    case 19:
                        addedStatValue = addedStatValue-76;
                        addedAttValue = addedAttValue-42;
                        break;   
                    case 20:
                        addedStatValue = addedStatValue-85;
                        addedAttValue = addedAttValue-55;
                        break;  
                    case 21:
                        addedStatValue = addedStatValue-94;
                        addedAttValue = addedAttValue-69;
                        break;      
                }
            }

            if (itemLevel >= 150 && itemLevel <= 159 && !isTyrant && !isGhostShip) {
                switch(currentStars) {
                    case 15:
                        addedStatValue = addedStatValue-40;
                        break;
                    case 16:
                        addedStatValue = addedStatValue-51;
                        addedAttValue = addedAttValue-10;
                        break;   
                    case 17:
                        addedStatValue = addedStatValue-62;
                        addedAttValue = addedAttValue-21;
                        break; 
                    case 18:
                        addedStatValue = addedStatValue-73;
                        addedAttValue = addedAttValue-33;
                        break;
                    case 19:
                        addedStatValue = addedStatValue-84;
                        addedAttValue = addedAttValue-46;
                        break;   
                    case 20:
                        addedStatValue = addedStatValue-95;
                        addedAttValue = addedAttValue-60;
                        break;   
                    case 21:
                        addedStatValue = addedStatValue-106;
                        addedAttValue = addedAttValue-75;
                        break;    
                }
            }

            //Special Checker for Tyrants
            if (itemLevel == 150 && isTyrant) {
                addedStatValue = addedStatValue-110;
                switch(currentStars) {
                    case 12:
                        addedAttValue = addedAttValue-77;
                        break;
                    case 13:
                        addedAttValue = addedAttValue-92;
                        break;   
                    case 14:
                        addedAttValue = addedAttValue-108;
                        break;  
                    case 15:
                        addedAttValue = addedAttValue-125;
                        break;    
                }
            }

            //Special Checker for Ghost Ship Badge
            if (itemLevel == 150 && isGhostShip) {
                switch(currentStars) {
                case 15:
                    addedStatValue = addedStatValue-40;
                    break;
                case 16:
                    addedStatValue = addedStatValue-51;
                    break;   
                case 17:
                    addedStatValue = addedStatValue-62;
                    break; 
                case 18:
                    addedStatValue = addedStatValue-73;
                    break;
                case 19:
                    addedStatValue = addedStatValue-84;
                    break;   
                case 20:
                    addedStatValue = addedStatValue-95;
                    break;   
                case 21:
                    addedStatValue = addedStatValue-106;
                    break;      
                }
            }

            //Sweetwater Items
            if (itemLevel >= 160 && itemLevel <= 199) {
                switch(currentStars) {
                    case 15:
                        addedStatValue = addedStatValue-40;
                        break;
                    case 16:
                        addedStatValue = addedStatValue-53;
                        addedAttValue = addedAttValue-11;
                        break;   
                    case 17:
                        addedStatValue = addedStatValue-66;
                        addedAttValue = addedAttValue-23;
                        break; 
                    case 18:
                        addedStatValue = addedStatValue-79;
                        addedAttValue = addedAttValue-36;
                        break;
                    case 19:
                        addedStatValue = addedStatValue-92;
                        addedAttValue = addedAttValue-50;
                        break;   
                    case 20:
                        addedStatValue = addedStatValue-105;
                        addedAttValue = addedAttValue-65;
                        break;  
                    case 21:
                        addedStatValue = addedStatValue-118;
                        addedAttValue = addedAttValue-81;
                        break;   
                }
            }

            //Arcane Umbra Items
            if (itemLevel == 200) {
                switch(currentStars) {
                    case 15:
                        addedStatValue = addedStatValue-40;
                        break;
                    case 16:
                        addedStatValue = addedStatValue-55;
                        addedAttValue = addedAttValue-14;
                        break;   
                    case 17:
                        addedStatValue = addedStatValue-70;
                        addedAttValue = addedAttValue-29;
                        break; 
                    case 18:
                        addedStatValue = addedStatValue-85;
                        addedAttValue = addedAttValue-45;
                        break;
                    case 19:
                        addedStatValue = addedStatValue-100;
                        addedAttValue = addedAttValue-62;
                        break;   
                    case 20:
                        addedStatValue = addedStatValue-115;
                        addedAttValue = addedAttValue-80;
                        break;  
                    case 21:
                        addedStatValue = addedStatValue-130;
                        addedAttValue = addedAttValue-99;
                        break;      
                }
            }

            //In AriesMS, Gloves gain 7 ATT when SF'd from 1-15
            if (isGlove == true)
            addedAttValue = addedAttValue-7;

            int oneSlotScenario = totalScrollCount-1;
            int twoSlotScenario = totalScrollCount-2;
            int threeSlotScenario = totalScrollCount-3;
            int fourSlotScenario = totalScrollCount-4;
            int fiveSlotScenario = totalScrollCount-5;
            int sixSlotScenario = totalScrollCount-6;
            int sevenSlotScenario = totalScrollCount-7;
            int eightSlotScenario = totalScrollCount-8;
            int nineSlotScenario = totalScrollCount-9;
            int tenSlotScenario = totalScrollCount;
            
            int oneSlotStat = addedStatValue - (oneSlotScenario*scrollStatValue);
            int oneSlotAtt = addedAttValue - (oneSlotScenario*scrollAttValue);

            int twoSlotStat = addedStatValue - (twoSlotScenario*scrollStatValue);
            int twoSlotAtt = addedAttValue - (twoSlotScenario*scrollAttValue);

            int threeSlotStat = addedStatValue - (threeSlotScenario*scrollStatValue);
            int threeSlotAtt = addedAttValue - (threeSlotScenario*scrollAttValue);

            int fourSlotStat = addedStatValue - (fourSlotScenario*scrollStatValue);
            int fourSlotAtt = addedAttValue - (fourSlotScenario*scrollAttValue);

            int fiveSlotStat = addedStatValue - (fiveSlotScenario*scrollStatValue);
            int fiveSlotAtt = addedAttValue - (fiveSlotScenario*scrollAttValue);

            int sixSlotStat = addedStatValue - (sixSlotScenario*scrollStatValue);
            int sixSlotAtt = addedAttValue - (sixSlotScenario*scrollAttValue);

            int sevenSlotStat = addedStatValue - (sevenSlotScenario*scrollStatValue);
            int sevenSlotAtt = addedAttValue - (sevenSlotScenario*scrollAttValue);

            int eightSlotStat = addedStatValue - (eightSlotScenario*scrollStatValue);
            int eightSlotAtt = addedAttValue - (eightSlotScenario*scrollAttValue);

            int nineSlotStat = addedStatValue - (nineSlotScenario*scrollStatValue);
            int nineSlotAtt = addedAttValue - (nineSlotScenario*scrollAttValue);
            
            int tenSlotStat = addedStatValue - (tenSlotScenario*scrollStatValue);
            int tenSlotAtt = addedAttValue - (tenSlotScenario*scrollAttValue);

            System.out.println("\nCalculating MCS..");

            System.out.println("Minimum MCS Combination found: ");
            if (isGhostShip) {
                System.out.println(totalScrollCount + " Slot MCS Found: STAT: " + addedStatValue + ", WA: +" + addedAttValue);
            }

            if (!isGhostShip) {
                if (oneSlotStat <= 9 && oneSlotAtt <= 9) {
                    System.out.println("1 Slot MCS Found: STAT: " + oneSlotStat + ", WA: +" + oneSlotAtt);
                    mcsFound = true;
                }
                if (twoSlotStat <= 18 && twoSlotAtt <= 18 && !mcsFound) {
                    System.out.println("2 Slot MCS Found: STAT: " + twoSlotStat + ", WA: +" + twoSlotAtt);
                    mcsFound = true;
                }
                if (threeSlotStat <= 27 && threeSlotAtt <= 27 && !mcsFound) {
                    System.out.println("3 Slot MCS Found: STAT: " + threeSlotStat + ", WA: +" + threeSlotAtt);
                    mcsFound = true;
                }
                if (fourSlotStat <= 36 && fourSlotAtt <= 36 && !mcsFound) {
                    System.out.println("4 Slot MCS Found! STAT: " + fourSlotStat + ", WA: +" + fourSlotAtt);        
                    mcsFound = true;
                }
                if (fiveSlotStat <= 45 && fiveSlotAtt <= 45 && !mcsFound) {
                    System.out.println("5 Slot MCS Found: STAT: " + fiveSlotStat + ", WA: +" + fiveSlotAtt);
                    mcsFound = true;
                }
                if (sixSlotStat <= 54 && sixSlotAtt <= 54 && !mcsFound) {
                    System.out.println("6 Slot MCS Found: STAT: " + sixSlotStat + ", WA: +" + sixSlotAtt);
                    mcsFound = true;
                }
                if (sevenSlotStat <= 63 && sevenSlotAtt <= 63 && !mcsFound) {
                    System.out.println("7 Slot MCS Found: STAT: " + sevenSlotStat + ", WA: +" + sevenSlotAtt);
                    mcsFound = true;
                }
                if (eightSlotStat <= 72 && eightSlotAtt <= 72 && !mcsFound) {
                    System.out.println("8 Slot MCS Found: STAT: " + eightSlotStat + ", WA: +" + eightSlotAtt);
                    mcsFound = true;
                }
                if (nineSlotStat <= 81 && nineSlotAtt <= 81 && !mcsFound) {
                    System.out.println("9 Slot MCS Found: STAT: " + nineSlotStat + ", WA: +" + nineSlotAtt);
                    mcsFound = true;
                }
                if (tenSlotStat <= 90 && tenSlotAtt <= 90 && !mcsFound) {
                    System.out.println("10 Slot MCS Found: STAT: " + tenSlotStat + ", WA: +" + tenSlotAtt);
                    mcsFound = true;
                }
            }

            System.out.println("\nThanks for using the MCS Calculator! Hope you found it useful.\n\n");
            System.out.println("Want to check another item's MCS?");

        }
    }
}
