

public class CalcSqrt extends CalcCommon{


    public void calculate (String expression){
        this.expression = expression;

        String[] str_arr = expression.split(" ");

        double tmp = 0;
        StringBuffer sgn = new StringBuffer();

        for (String s : str_arr) {
            //System.out.println(s);
            //System.out.println(s.contains("корень"));
            if (s.contains("корень")){
                String str_tmp = s.replaceAll("корень\\(","").replaceAll("\\)","");
                s = String.valueOf(Math.sqrt(Double.valueOf(str_tmp)));
                // System.out.print(s);
            }
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
