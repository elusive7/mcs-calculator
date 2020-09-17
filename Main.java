import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        //Welcome dialog
        System.out.println("Welcome to Halcyon's MCS Calculator\n");

        while(true) {
            //Variable Declaration
            Scanner scan = new Scanner(System.in);
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
            boolean validInput = false;
            boolean quit = false;
            
            //Get Item Level for Starforce Value Check
            System.out.println("Please enter the Item's Level: ");
            int itemLevel = scan.nextInt();
            scan.nextLine();

            //Check if the item is a Glove
            System.out.println("Is this item a Glove? Please enter y/n: ");
            while (!quit) {
                String yesOrNo = scan.nextLine().trim().toLowerCase();
                switch(yesOrNo){
                    case "y":
                        quit = true;
                        break;
                    case "n":
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid Input Detected! Please enter y/n: ");
                        validInput = false;
                        quit = false;
                        break;
                }
                if (yesOrNo.equals(yes)) {
                    isGlove = true;
                }
            }
            quit = false;

            if (itemLevel == 150) {
                //Check if the item is a Tyrant
                System.out.println("Is this item a Tyrant? Please enter y/n: ");
                while (!quit) {
                    String yesOrNo = scan.nextLine().trim().toLowerCase();
                    switch(yesOrNo){
                        case "y":
                            quit = true;
                            break;
                        case "n":
                            quit = true;
                            break;
                        default:
                            System.out.println("Invalid Input Detected! Please enter y/n: ");
                            validInput = false;
                            quit = false;
                            break;
                    }
                    if (yesOrNo.equals(yes)) {
                        isTyrant = true;
                    }
                }
                quit = false;

                if (!isTyrant) {
                    //Check if the item is a Ghost Ship Badge
                    System.out.println("Is this item a Ghost Ship Badge? Please enter y/n: ");
                    while (!quit) {
                        String yesOrNo = scan.nextLine().trim().toLowerCase();
                        switch(yesOrNo){
                            case "y":
                                quit = true;
                                break;
                            case "n":
                                quit = true;
                                break;
                            default:
                                System.out.println("Invalid Input Detected! Please enter y/n: ");
                                validInput = false;
                                quit = false;
                                break;
                        }
                        if (yesOrNo.equals(yes)) {
                            isGhostShip = true;
                        }
                    }
                }
                quit = false;
            }
                   
            //Get Type of Scroll Used
            if (!isGhostShip) {
                System.out.println("How is your item scrolled? Please enter ags, ss, or prime.");
                while (!quit) {
                    scrollType = scan.nextLine().trim().toLowerCase();
                    switch(scrollType){
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
                            validInput = false;
                            quit = false;
                            break;
                    }
                }
                
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

            System.out.println("\nCalculating MCS..");
            System.out.println("Minimum MCS Combination found: ");

            if (isGhostShip) {
                System.out.println(totalScrollCount + " Slot MCS Found: STAT: " + addedStatValue + ", WA: +" + addedAttValue);
            }

            if (!isGhostShip) {
                int testSlotScenario = totalScrollCount;

                for (int i = 1; i <= 90; i++) {
                    testSlotScenario--;
                    int testSlotStat = addedStatValue - (testSlotScenario*scrollStatValue);
                    int testSlotAtt = addedAttValue - (testSlotScenario*scrollAttValue);
                    if (testSlotStat <= (9*i) && testSlotAtt <= (9*i)) {
                        System.out.println(i + " Slot MCS Found: STAT: " + testSlotStat + ", WA: +" + testSlotAtt);
                        mcsFound = true;
                    }
                    if (mcsFound) {
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
