public class Task2 {
	public static void main (String[] args) {
		String str = "Abc1 def2, lkj3, iop4, dfdf5 lll6";
		
		String str_rvr = revers(str);
		System.out.println(str_rvr);
	}
	
	public static String revers (String str) {
		String[] str_arr = str.split(" "); // разделяем строку по пробелу
		int flag = 0; // флаг для запятой
		/*
		flag = 0 - снятый флаг, запятую добавлять/убирать не нужно
		flag = 1 - возводим флаг, чтобы в следующем слове добавить запятую
		flag = 2 - запятая в слове добавлена
		*/
		
		// пробегаем по массиву, ищем запятую вконце, переставляем ее в конец следующего слова
		for (int i = 0; i < str_arr.length-1; i++) {
			// если флаг = 1, то добавляем запятую
			if(flag == 1) {
				// если запятая уже есть, то будем добавлять к следующему слову
				if (str_arr[i].charAt(str_arr[i].length()-1) != ',') {
					str_arr[i] += ",";
					flag = 2; // запятая добавлена. обнулим флаг в конце, чтобы не выполнился следующий блок
				}
			}
			
			// если в конце слова есть запятая и она не только что добавлена
			if(str_arr[i].charAt(str_arr[i].length()-1) == ',' && flag == 0) {
					
				flag = 1; // ставим флаг = 1, чтобы в следующем слове добавить запятую
				// в текущем слове убираем запятую
				str_arr[i] = str_arr[i].substring(0,str_arr[i].length()-1);
			}
			if(flag == 2) flag = 0; // обнуляем флаг
				
		}
		
		StringBuffer str_rvr = new StringBuffer();
		
		for (int i = str_arr.length-1; i >= 0; i--) {
			str_rvr.append(str_arr[i] + " ");
		}
		
		return str_rvr.toString();
		
	}
	
}