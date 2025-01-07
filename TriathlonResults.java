class Participant {
  
    private String name;
    private String id;
    private int swimmingTime;
    private int cyclingTime;
    private int runningTime;

 
    public Participant(String name, String id, int swimmingTime, int cyclingTime, int runningTime) {
        if (swimmingTime < 0 || cyclingTime < 0 || runningTime < 0) {
            System.out.println("Times cannot be negative.");
        }
        this.name = name;
        this.id = id;
        this.swimmingTime = swimmingTime;
        this.cyclingTime = cyclingTime;
        this.runningTime = runningTime;
    }

 
    public String getName() {
        return name;
    }


    public String getId() {
        return id;
    }

   
    public int calculateTotalTime() {
        return swimmingTime + cyclingTime + runningTime;
    }

   
    public void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id + ", Total Time: " + calculateTotalTime() + " minutes");
    }
}


class EliteParticipant extends Participant {
    private String sponsorName; 

  
    public EliteParticipant(String name, String id, int swimmingTime, int cyclingTime, int runningTime, String sponsorName) {
        super(name, id, swimmingTime, cyclingTime, runningTime);
        this.sponsorName = sponsorName;
    }

   
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call base class method
        System.out.println("Sponsor: " + sponsorName);
    }
}


class BeginnerParticipant extends Participant {
   
    public BeginnerParticipant(String name, String id, int swimmingTime, int cyclingTime, int runningTime) {
        super(name, id, swimmingTime, cyclingTime, runningTime);
    }

    
}

public class TriathlonResults {
    public static void main(String[] args) {
      
        Participant[] participants = {
            new EliteParticipant("Alice", "P001", 25, 40, 20, "Victoria University"),
            new BeginnerParticipant("Bob", "P002", 20, 35, 25),
            new BeginnerParticipant("Charlie", "P003", 30, 50, 30),
            new EliteParticipant("Diana", "P004", 28, 42, 18, "KCCA")
        };

       
        System.out.println("Participant Details:");
        for (Participant participant : participants) {
            participant.displayDetails(); 
            System.out.println();
        }

        
        for (int i = 0; i < participants.length - 1; i++) {
            for (int j = 0; j < participants.length - 1 - i; j++) {
                if (participants[j].calculateTotalTime() > participants[j + 1].calculateTotalTime()) {
                  
                    Participant temp = participants[j];
                    participants[j] = participants[j + 1];
                    participants[j + 1] = temp;
                }
            }
        }

      
        System.out.println("\nSorted Results by Total Time:");
        for (Participant participant : participants) {
            participant.displayDetails(); // Display sorted participant details
            System.out.println();
        }

        // Display the fastest participant
        System.out.println("\nFastest Participant:");
        participants[0].displayDetails();

        
        System.out.println("\nSecond Fastest Participant:");
        participants[1].displayDetails();

        
        System.out.println("\nParticipants with the same total time:");
        for (int i = 0; i < participants.length - 1; i++) {
            if (participants[i].calculateTotalTime() == participants[i + 1].calculateTotalTime()) {
                participants[i].displayDetails(); // Display details of the tied participants
                participants[i + 1].displayDetails();
                System.out.println();
            }
        }
    }
}
