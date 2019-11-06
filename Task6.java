public class Task6 {
	public static void main(String[] args){
		String s1 = "asds";
		String s2 = "dkes";
		// должно получиться asdke
		
		String str = conc(s1,s2);
		System.out.println(str);
	}
	
	public static String conc (String s1, String s2) {
		StringBuffer str = new StringBuffer(s1 + s2);
		
		int i = 0;
		
		while (i < str.length()) {
			char c = str.charAt(i);
			int j = i + 1;
			while (j < str.length()) {
				if (str.charAt(j) == c) {
					str.deleteCharAt(j);
				}
				j++;
			}
			i++;
		}
		
		return String.valueOf(str);
		
	}
}
	