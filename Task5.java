import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
	public static void main(String[] args){
		String addr = convert("XFD398");
		System.out.println(addr);
	}
	
	public static String convert(String addr) {
		
		Pattern pattern_s = Pattern.compile("[A-Z]+"); // получаем название колонки
		Matcher matcher_s = pattern_s.matcher(addr.toUpperCase());
		String sCol = new String();
		
		while(matcher_s.find()){
			sCol = matcher_s.group();
			break;
		}
		
		Pattern pattern_i = Pattern.compile("[0-9]+"); // получаем номер строчки
		Matcher matcher_i = pattern_i.matcher(addr);
		String sRow = new String();
		
		while(matcher_i.find()){
			sRow = matcher_i.group();
			break;
		}
		
		char[] cCol = sCol.toCharArray(); // название колонки будем смотреть посимвольно		
		int col = 0; // для вычисления номера колонки		
		
		for (int i = 0; i < cCol.length; i++){
			for (char c = 'A'; c <= cCol[i]; c++){
				col++;
				//System.out.println(c + " " + col);
			}
			if (sCol.length()-1 != i) col *= 26;
			//System.out.println(col);
		}
		//System.out.println(col);
		
		return "row " + sRow + ", column " + col;
	}
}