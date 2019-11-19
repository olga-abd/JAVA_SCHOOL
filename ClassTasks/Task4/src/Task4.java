public class Task4 {
    public static void main (String[] args){
        Calc a = new Calc();
        a.calculate("5 + 2");
        a.printResult();
        System.out.print("Предыдущее вычисление: ");
        a.getPrevious();

        a.calculate("6 + 4");
        a.printResult();
        System.out.print("Предыдущее вычисление: ");
        a.getPrevious();

        a.calculate("10 * 3");
        a.printResult();
        System.out.print("Предыдущее вычисление: ");
        a.getPrevious();

        a.calculate("8 - 3");
        a.printResult();
        System.out.print("Предыдущее вычисление: ");
        a.getPrevious();
        System.out.println("2 предыдущих вычисления: ");
        a.getPrevious(2);
        System.out.println("3 предыдущих вычисления: ");
        a.getPrevious(4);
        System.out.println("Кол-во сохраненных выражений: " + a.getExperssionCount());
        System.out.println("Все сохраненные выражения:");
        a.printAll();


        a.clean();
        a.printResult();
        a.getPrevious();
        a.getPrevious(4);


        System.out.println("Записываем 10 выражений:");
        a.calculate("1 + 1");
        a.calculate("2 + 2");
        a.calculate("3 + 3");
        a.calculate("4 + 4");
        a.calculate("5 + 5");
        a.calculate("6 + 6");
        a.calculate("7 + 7");
        a.calculate("8 + 8");
        a.calculate("9 + 9");
        a.calculate("10 + 10");
        a.printAll();

        System.out.println("Записываем 2 новых выражения -> 2 первых удаляются");
        a.calculate("11 + 11");
        a.calculate("12 + 12");
        a.printAll();
    }
}
