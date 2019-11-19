public class Calc {
    protected String expression;
    protected double result;
    protected StringBuffer memory;// = new StringBuffer();
    // память реализована как StringBuffer с разделением выражений через ;


    /*public Calc (String expression){
        this.expression = expression;
    }*/

    public void calculate (String expression){
        this.expression = expression;

        String[] str_arr = expression.split(" ");

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
        result = tmp;

        saveToMemory();
        //memory.append(expression + " = " + result + ";");
    }


    private void saveToMemory(){
        // если записано 10 выражений, то удаляем первое до первой ;
        if (memory != null && memory.length() - String.valueOf(memory).replaceAll(";","").length() == 10){
            memory.delete(0,memory.indexOf(";") + 1);
        }

        if (memory == null){ // если объект пустой, то создаем новый
            memory = new StringBuffer(expression + " = " + result + ";");
        }
        else {
            memory.append(expression + " = " + result + ";");
        }
    }

    public void getPrevious () {
        String[] exp_arr = String.valueOf(memory).split(";");
        if(exp_arr.length > 1) {
            System.out.println(exp_arr[exp_arr.length - 2]);
        }
        else {
            System.out.println("Предыдущих вычислений не найдено");
        }
        System.out.println("-----");
    }

    public void getPrevious (int cnt) { // сколько последних выражений вывести
        String[] exp_arr = String.valueOf(memory).split(";");
        if (exp_arr.length > 1 ) {
            int i = exp_arr.length - 2;
            while (i >= exp_arr.length - cnt - 1 && i >= 0) {
                System.out.println(exp_arr[i]);
                i--;
            }
        }
        else {
            System.out.println("Предыдущих вычислений не найдено");
        }
        System.out.println("-----");
    }

    public void printResult(){
        if (memory == null){
            System.out.println("Выражений не найдено");
        }
        else {
            System.out.println(expression + " = " + result);
        }
    }

    public void clean(){
        memory = null;
        expression = null;
        result = 0;
        System.out.println("Память очищена");
    }

    public int getExperssionCount(){
        return memory.length() - String.valueOf(memory).replaceAll(";","").length();
    }

    public void printAll(){
        String[] exp_arr = String.valueOf(memory).split(";");
        for(String a : exp_arr){
            System.out.println(a);
        }
        System.out.println("-----");
    }

}
