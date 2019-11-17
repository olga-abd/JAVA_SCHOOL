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

    }
}
