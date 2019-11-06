public class Task3 {
	public static void main (String[] args) {
		String str = "asdffgfds";
		char srch = 'f';
		
		System.out.println(search1(str,srch));
		System.out.println(search2(str,srch));
		System.out.println("Count: " + search3_without_positions(str,srch));
	}
	
	public static String search1(String str, char srch){
		char[] chrs = str.toCharArray();
		StringBuffer positions = new StringBuffer();
		int count = 0;
		String str_out = new String();
		
		if (str.indexOf(srch) > -1) {
			for(int i = 0; i < str.length(); i++) {
				if(chrs[i] == srch) {
					count ++;
					positions.append(", " + i);
				}
			}
			
			str_out = ("Count: " + count + "; positions: " + positions.substring(2));
		}
		else {
			str_out = ("Not found");
		}
		
		return str_out;
	}
	
	public static String search2(String str, char srch){
		StringBuffer positions = new StringBuffer();
		int count = 0;
		int ind = 0;
		String str_out = new String();
		
		while (str.substring(ind).indexOf(srch) > -1){
			int i = str.substring(ind).indexOf(srch);
			ind += i;
			positions.append(", " + ind);
			ind++;
			count++;
		}
		
		if (count > 0) {
			str_out = ("Count: " + count + "; positions: " + positions.substring(2));
		}
		else
		{
			str_out = ("Not found");
		}
		return str_out;
	}

	public static int search3_without_positions(String str, char srch) {
		String str_replaced = str.replaceAll(String.valueOf(srch),"");
		return str.length() - str_replaced.length();
	}

}