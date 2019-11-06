public class Task1 {
	
	public static void main (String[] args){
		
		String[] cars = {"Z11-100","Z12-150","Z13-120","Z11-80","Z12-50",
		"Z13-40","Z11-200","Z12-0","Z13-10","Z11-170"};
		
		double[] gsm = new double[3];
		
		gsm = countGSM(cars, 1);
		
		System.out.println("Total cost:");
		for(double i : gsm) {
			System.out.println(i);
		}
		
		String min_gsm = min(gsm);
		System.out.println("Car " + min_gsm + " has minimum gsm cost");
		
		String max_gsm = max(gsm);
		System.out.println("Car " + max_gsm + " has maximum gsm cost");
		
		
	}
	
	
	public static double[] countGSM (String[] cars, int fuel_type) {
		
		// fuel_type = 1 - расход топлива одинаковый по 15л/100км
		// fuel_type = 2 - расход топлива разный
		
		double[] gsm = new double[3];
		
		// расход для fuel_type = 1
		double FUEL_CONSUMPTION = 0.15;
		
		// стоимость бензина
		double FUEL_Z11 = 46.1;
		double FUEL_Z12 = 47.5;
		double FUEL_Z13 = 48.9;		
		
		// расход для fuel_type = 2
		double FUEL_CONS_Z11 = 0.125;
		double FUEL_CONS_Z12 = 0.12;
		double FUEL_CONS_Z13 = 0.115;
		
		// для расчета дистанции
		int distanceZ11 = 0;
		int distanceZ12 = 0;
		int distanceZ13 = 0;

		int t = 0;
		
		for (String car : cars) {
			// получаем дистанцию
			t = Integer.valueOf(car.substring(4));
			
			// при дистанции > 0 производим расчет
			if (t > 0) {
				switch (car.substring(0,3)){
					case "Z11":
					{
						distanceZ11 += t;
						break;
					}
					case "Z12":
					{
						distanceZ12 += t;
						break;
					}
					case "Z13":
					{
						distanceZ13 += t;
						break;
					}
				}
			}
			
		}
		
		
		gsm[0] = distanceZ11 * FUEL_Z11 * (fuel_type == 1 ? FUEL_CONSUMPTION : FUEL_CONS_Z11);
		gsm[1] = distanceZ12 * FUEL_Z12 * (fuel_type == 1 ? FUEL_CONSUMPTION : FUEL_CONS_Z12);
		gsm[2] = distanceZ13 * FUEL_Z13 * (fuel_type == 1 ? FUEL_CONSUMPTION : FUEL_CONS_Z13);
		
		return gsm;
		
	}
	
	
	public static String min (double[] arr){
		double a = arr[0];
		int ind = 0;
		String str;
		for (int i = 1; i < arr.length; i++) {
			if (a > arr[i]) {
				a = arr[i];
				ind = i;
			}
		}
		str = "Z1" + (ind+1);
		
		return str;
	}
	
	public static String max (double[] arr){
		double a = arr[0];
		int ind = 0;
		String str;
		for (int i = 1; i < arr.length; i++) {
			if (a < arr[i]) {
				a = arr[i];
				ind = i;
			}
		}
		str = "Z1" + (ind+1);
		
		return str;
	}
	
}