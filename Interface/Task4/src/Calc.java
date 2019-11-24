public class Calc extends CalcCommon{

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


}
