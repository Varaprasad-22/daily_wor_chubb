package training;

public class CarVarient {
	public double car(String i) {
		switch(i) {
		case "delta":
			return 800000;
		case "alpha":
            return 1200000.00;
        case "beta":
            return 1000000.00;
        default:
            System.out.println("Enter proper Value");
            return 0.00;
		}
		
	}
}
