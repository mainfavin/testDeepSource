package Source;

import java.util.ArrayList;
import java.util.List;

public class Variable extends Expression {

    private String var;

    public Variable(String s) {
        this.var = s;
    }
    //PRE:
    //POS: creates a new variable from the given values

    public Expression rename(String s1, String s2) {
        if (s1.equals(var)) {
            return new Variable(s2);
        } else {
            return this;
        }
    }
    //PRE:
    //POS: Renames the variable with the given string

    List varList() {
        List l = new ArrayList();
        l.add(var);
        return l;
    }
    //PRE:
    //POS: Returns a list with the variables contained in the expression

    Expression copy() {
        return new Variable(this.var);
    }
    //PRE:
    //POS: Returns a copy of the casting variable


    Expression substitute(String s, Integer i) {
        if (s.equals(var)) {
            return new Constant(i);
        } else {
            return new Variable(this.var);
        }
    }
    //PRE:
    //POS: Switches the casting variable with the new values given


    int calculate(Valoration val) {
        return val.varValue(var);
    }
    //PRE:
    //POS: Returns the numeric value of variable

    public String toString() {
        return var.toString();
    }

}
