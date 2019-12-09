public class Task3 {
	public static void main (String[] args) {
		String str = "asdffgfds";
		char srch = 'f';
		
		System.out.println(search1(str,srch));
		System.out.println(search2(str,srch));
		System.out.println(search5(str,srch));
		System.out.println("Count: " + search3_without_positions(str,srch));
		System.out.println("Count: " + search4_without_positions(str,srch));
	}
	
	// перебор подряд по всем символам
	public static String search1(String str, char srch){ 
		char[] chrs = str.toCharArray();
		StringBuffer positions = new StringBuffer();
		int count = 0;
		String str_out = new String();
		
		if (str.indexOf(srch) > -1) {
			// проходим по каждому символу
			for(int i = 0; i < str.length(); i++) {
				if(chrs[i] == srch) { // если он соответствует шаблону - считаем его и записываем позицию
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
	
	// поиск через indexOf
	public static String search2(String str, char srch){
		StringBuffer positions = new StringBuffer();
		int count = 0;
		int ind = 0;
		String str_out = new String();
		
		// ищем символ через indexOf. со следующей позиции после найденного символа
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
	
	// подсчет через replaceAll
	public static int search3_without_positions(String str, char srch) {
		// из длины строки вычитаем длину строки без шаблонных символов. разница - количество этих символов в строке
		String str_replaced = str.replaceAll(String.valueOf(srch),"");
		return str.length() - str_replaced.length();
	}
	
	// подсчет через replaceAll 2
	public static int search4_without_positions(String str, char srch) {
		// удаляем все символы, кроме шаблонного. считаем
		return str.replaceAll("[^" + srch + "]","").length();
	}
	
	// поиск через indexOf 2. обрезаем строку, когда нашли шаблон
	public static String search5(String str, char srch){
		StringBuffer positions = new StringBuffer();
		int count = 0;
		int ind = 0;
		StringBuffer str_out = new StringBuffer(str);
		
		// ищем символ через indexOf 
		while (str_out.indexOf(String.valueOf(srch)) > -1){
			int i = str_out.indexOf(String.valueOf(srch));
			ind += i; 
			positions.append(", " + ind);
			ind++;
			count++;
			
			str_out.delete(0,i+1); //обрезаем строку
		}
		
		if (count > 0) {
			return ("Count: " + count + "; positions: " + positions.substring(2));
		}
		else
		{
			return ("Not found");
		}
		
	}

}