public class Task4 {
	public static void main(String[] args){
		String str_in = "( 6 + 10 - 4 ) / ( 1 + 1 * 2 ) + 1"; // всё вводить через пробелы
		//System.out.println (simplecalc(str_in));
		
		System.out.println(prioritycalc(str_in));
	}
	
	public static double simplecalc (String str_in){
		
		String[] str_arr = str_in.split(" ");
		
		double tmp = 0;
		StringBuffer sgn = new StringBuffer();
		
		for (String s : str_arr) {
			if (s.matches("\\d+.?\\d*")) {
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

	public static double prioritycalc (String str_in){
		String str = shunting_yard(str_in); // сортируем операции по приоритету на основе алгоритма сортировочной станции
		
		return polskcalc(str); // делаем расчет в соотсветствии с обратной польской нотацией
	}

	public static String shunting_yard (String str_in){
		String[] str = str_in.split(" ");
		
		StringBuffer sout = new StringBuffer(); // стек вывода
		
		StringBuffer sop = new StringBuffer(); // стек операций
		
		for (String s : str) {
			// числа записываем в стек чисел через запятую
			if(s.matches("\\d+")) {
				sout.append("," + s.trim());
			}
			else {
				// операции - стек операций. Если приоритет новой операции больше приоритета последней операции, то последнюю переносим в стек вывода
				if (sop.length() > 0 && !s.trim().equals("(") && !s.trim().equals(")") && sop.charAt(sop.length()-1) != '('
						&& get_prior(sop.charAt(sop.length()-1)) <= get_prior(s.trim().charAt(0))){
					char a;
					a = sop.charAt(sop.length()-1);
					sop.deleteCharAt(sop.length()-1);
					sop.deleteCharAt(sop.length()-1);
					sout.append("," + a);
					}
				else if (s.trim().equals(")")) {
					char a; // все в пределах скобок переносим в стек вывода
					while(sop.charAt(sop.length()-1) != '('){
						a = sop.charAt(sop.length() - 1);
						sop.deleteCharAt(sop.length() - 1);
						sop.deleteCharAt(sop.length() - 1);
						sout.append("," + a);
					}
					sop.deleteCharAt(sop.length() - 1);
					sop.deleteCharAt(sop.length() - 1);
				}
				if(!s.trim().equals(")")) sop.append("," + s.trim());
				
			}
			
		}
		while (sop.length() > 1) {
			char a; // оставшиеся операции переносим в стек вывода
			a = sop.charAt(sop.length() - 1);
			sop.deleteCharAt(sop.length() - 1);
			sop.deleteCharAt(sop.length() - 1);
			sout.append("," + a);
		}
		sout.deleteCharAt(0); // удаляем начальную запятую
		return String.valueOf(sout);		
	}
	
	public static double polskcalc(String str_in){
		StringBuffer str = new StringBuffer(str_in);
		
		int arr_len = str_in.replaceAll("[^,]+","").length(); // длину массива определяем по количеству запятых в стеке
		String[] sout = new String[arr_len];
		int i = 0;
		
		while (str.length() > 0) {
			
			String a = new String();
			
			// получаем значение от начала до первой запятой. или до конца строки, если запятой больше нет
			if(str.indexOf(",") > -1){
				a = String.valueOf(str.substring(0,str.indexOf(",")));
			}
			else {
				a = String.valueOf(str);
			}
			
			if (a.matches("\\d+")) {
				sout[i++] = a;
				// если число - записываем в массив
			}
			else {
				i--;
				// если оператор - производим вычисление по последним записанным в массив числам
				double b = simplecalc(sout[i-1] + " " + a + " " + sout[i]);
				sout[i--] = null;
				sout[i++] = String.valueOf(b);
			}
			
			// убираем обработанные числа/операции
			if (str.indexOf(",") > -1) 
				str.delete(0,str.indexOf(",")+1);
			else str.setLength(0);
			
			/*for(String s : sout){
				System.out.print(s + " ");
			}*/
		}
		
		return Double.valueOf(sout[0]);
	}
	
	// определяем приоритет операторов
	public static int get_prior (char pr) { 
		int tmp;
		switch (pr) {
			case '*':
			case '/':
			{
				tmp = 1;
				break;
			}
			default:
			{
				tmp = 2;
				break;
			}
		}
		return tmp;
	}

}