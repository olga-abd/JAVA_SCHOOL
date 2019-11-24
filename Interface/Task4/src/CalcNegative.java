public class CalcNegative extends CalcCommon{

    public void calculate (String expression){
        this.expression = expression;

        String[] str_arr = expression.split(" ");

        double tmp = 0;
        StringBuffer sgn = new StringBuffer();

        for (String s : str_arr) {
            //System.out.println(s);
            if (s.matches("-{0,1}\\d+.?\\d*")) {
                //System.out.println("s: " + s + "; double = " + Double.valueOf(s));
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
            //System.out.println(tmp);
        }
        result = tmp;

        saveToMemory();
        //memory.append(expression + " = " + result + ";");
    }



}
