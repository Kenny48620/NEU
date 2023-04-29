/**
 *  This is a driver class for Conservatory that holds avaries and birds.
 *  @author Kaichun Lee
 */

public class ConservatoryDriver {

    private static boolean DEBUG = true;
    public static void main(String[] args){
        /* 
            create bird object    
        */
        // create Flightless 
        Flightless emus   = new Flightless("Emus", false);
        Flightless emus2  = new Flightless("Emus2", false);
        Flightless kiwis  = new Flightless("Kiwis", true);
        Flightless moas   = new Flightless("Moas", false);
        Flightless moas2  = new Flightless("Moas", false);

        // create Owl 
        Owl snowy         = new Owl("Snowy Owl", false);
        Owl esternScreech = new Owl("Eastern Screech Owl", false);
        Owl barn          = new Owl("Barn", false);

        // create Pigeons 
        Pigeon passenger     = new Pigeon("Passenger Pigeon", true);
        Pigeon mauritiusBlue = new Pigeon("Mauritius Blue Pigeon", true); 
        Pigeon runt          = new Pigeon("Runt", false);
        Pigeon runt2         = new Pigeon("Runt2", false);

        // create BirdsOfPrey birds
        BirdsOfPrey hawks   = new BirdsOfPrey("Hawks", false);
        BirdsOfPrey eagle  = new BirdsOfPrey("Eagles", false);
        BirdsOfPrey eagle2 = new BirdsOfPrey("Eagles2", false);
        BirdsOfPrey eagle3 = new BirdsOfPrey("Eagles3", false);
        BirdsOfPrey osprey  = new BirdsOfPrey("Osprey", false);
        BirdsOfPrey osprey2 = new BirdsOfPrey("Osprey2", false);
        BirdsOfPrey osprey3 = new BirdsOfPrey("Osprey3", false);


        // create Parrot 
        Parrot roseRingParakeet      = new Parrot("Rose-ring Parakeet", false);
        Parrot grayParrot            = new Parrot("Gray Parrot", false);
        Parrot sulfurCrestedCockatoo = new Parrot("Sulfur-crested Cockatoo", false);
        // set words and favorite word
        roseRingParakeet.addWord("Day");roseRingParakeet.addWord("Monday");roseRingParakeet.addWord("Friday");
        roseRingParakeet.setFavWord("Friday");
        grayParrot.addWord("Color");grayParrot.addWord("Red");grayParrot.addWord("Blue");
        grayParrot.setFavWord("Blue");
        sulfurCrestedCockatoo.addWord("List");sulfurCrestedCockatoo.addWord("ArrayList");sulfurCrestedCockatoo.addWord("LinkedList");
        sulfurCrestedCockatoo.setFavWord("List");


        // create Shorebird
        Shorebird auk           = new Shorebird("Auk", false);
        Shorebird hornedPuffin  = new Shorebird("Horned Puffin", false);
        Shorebird africanJacana = new Shorebird("African Jacana", false);
       
        // create Waterfowl
        Waterfowl duck   = new Waterfowl("Duck", false);
        Waterfowl duck2  = new Waterfowl("Duck2", false);
        Waterfowl swan   = new Waterfowl("Swan", false);
        Waterfowl swan2  = new Waterfowl("Swan2", false);
        Waterfowl geese  = new Waterfowl("Geese", false);
        Waterfowl geese2 = new Waterfowl("Geese", false);

        if (DEBUG){
            System.out.println("Create Bird Object Passed!");
        }
        

        /* 
            create an conservatory object
        */
        Conservatory conservatory = new Conservatory();
        if (DEBUG){
            System.out.println("Create Conservatory Object Passed!");
        }

        /*  
            put birds into conservatory 
        */

        // assign flightless, birds of prey, waterfowl, owl
        conservatory.sendToAviary(emus); conservatory.sendToAviary(hawks); conservatory.sendToAviary(duck); conservatory.sendToAviary(snowy);
        // assign flightless, pigeons, waterfowl, parrot
        conservatory.sendToAviary(moas); conservatory.sendToAviary(runt); conservatory.sendToAviary(swan); conservatory.sendToAviary(roseRingParakeet);
        // assign birds of prey, shorebird, shorebird, shorebird
        conservatory.sendToAviary(eagle); conservatory.sendToAviary(auk); conservatory.sendToAviary(hornedPuffin); conservatory.sendToAviary(africanJacana);
        // assign parrot, birds of prey, pigeon, waterfowl
        conservatory.sendToAviary(grayParrot); conservatory.sendToAviary(osprey); conservatory.sendToAviary(runt2); conservatory.sendToAviary(swan2);
        // assign owl, parrot, waterfowl, owl
        conservatory.sendToAviary(esternScreech); conservatory.sendToAviary(sulfurCrestedCockatoo);conservatory.sendToAviary(geese);conservatory.sendToAviary(barn);
        // assign birds of prey, birds of prey, waterfowl, flightless
        conservatory.sendToAviary(osprey2);conservatory.sendToAviary(osprey3);conservatory.sendToAviary(duck2);conservatory.sendToAviary(moas2);
        // assign waterfowl, flightless, birds of prey, birds of prey
        conservatory.sendToAviary(geese2);conservatory.sendToAviary(emus2);conservatory.sendToAviary(eagle2);conservatory.sendToAviary(eagle3);
        
        if (DEBUG){
            System.out.println("Put birds into conservatory Passed!");
        }
        /* 
            display required task 
        */
        
        // Have a guest Look at aviary 1, 2 and 3
        System.out.println("Strat to display aviary 1, 2 and 3...");
        conservatory.displayAviary(1);
        conservatory.displayAviary(2);
        conservatory.displayAviary(3);
        System.out.println();

        // display interesting information at aviary 0, 1, 2, 3, 4
        System.out.println("Strat to display aviary 0, 1, 2, 3, 4 in detail...");
        conservatory.displayAviaryInDetail(0);
        conservatory.displayAviaryInDetail(1);
        conservatory.displayAviaryInDetail(2);
        conservatory.displayAviaryInDetail(3);
        conservatory.displayAviaryInDetail(4);
        System.out.println();


        // list all the aviaries by location and the birds they house
        System.out.println("Strat to display all aviaries...");
        conservatory.displayAllAviaries();
        System.out.println();

        // lists all birds in the conservatory in alphabetical order and their location
        System.out.println("Strat to display birds in the conservatory in alphabetical order and their location...");
        conservatory.displayByAlphOrder();

        if (DEBUG){
            System.out.println("All tasks are done!");
        }

    }
}
