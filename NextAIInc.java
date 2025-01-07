public class NextAIInc {

  
    public static void calculatePay(double basePay, int hoursWorked) {
        
        if (basePay < 30000) {
            System.out.println("Error: Base pay must not be below UGX 30,000.");
            return;
        }

       
        if (hoursWorked > 72) {
            System.out.println("Error: Hours worked must not exceed 72 hours per week.");
            return;
        }

        double totalPay;

     
        if (hoursWorked <= 48) {
            totalPay = basePay * hoursWorked;
        } else {
            int overtimeHours = hoursWorked - 48;
            totalPay = (basePay * 48) + (basePay * 2 * overtimeHours);
        }

        System.out.println("Total weekly pay: UGX " + totalPay);
    }

    public static void main(String[] args) {
      
        System.out.println("Contractor A:");
        calculatePay(30000, 51);

        System.out.println("\nContractor B:");
        calculatePay(20000, 40); 
        System.out.println("\nContractor C:");
        calculatePay(35000, 96); 
    }
}
