public class Task4 {
	public static void main(String[] args){
		String str_in = "5 * 2 - 3";
		System.out.println (simplecalc(str_in));
	}
	
	public static double simplecalc (String str_in){
		String[] str_arr = str_in.split(" ");
		
		double tmp = 0;
		StringBuffer sgn = new StringBuffer();
		
		for (String s : str_arr) {
			if (s.matches("\\d")) {
				switch (sgn.toString()) {
					case "+":
					{
						tmp += Double.valueOf(s);
						break;
					}
					case "-":
					{
						tmp -= Double.valueOf(s);
						break;
					}
					case "*":
					{
						tmp *= Double.valueOf(s);
						break;
					}
					case "/":
					{
						tmp /= Double.valueOf(s);
						break;
					}
					default:
					{
						tmp = Double.valueOf(s);
						break;
					}
				}
			}
			else
			{
				sgn = new StringBuffer(s.trim());
			}
		}
		return tmp;
	}
}