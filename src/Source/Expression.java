package Source;

import java.util.List;

public abstract class Expression {

    public int numOfVariables() {
        int n = 0;
        for (Object sAux : varList()) {
            n++;
        }
        return n;
    }
    //PRE:
    //POS: Returns the number of variables contained in the expression

    public boolean containsVariable(String vc) {
        return this.varList().contains(vc);
    }
    //PRE:
    //POS: Returns true if the given variable is contained in the Expression and false otherwise

    abstract Expression rename(String s1, String s2);
    //PRE:
    //POS: Renames the casting object with the given Strings

    abstract List<String> varList();
    //PRE:
    //POS: Returns a list with the variables contained in the expression

    abstract Expression copy();
    //PRE:
    //POS: Returns a copy of the casting expression

    abstract Expression substitute(String s, Integer i);
    //PRE:
    //POS: Switches the casting expression with the new values given

    abstract int calculate(Valoration val);
    //PRE:
    //POS: Returns the numeric value of the casting expression

    public boolean calculable(Valoration var) {
        for (String o : this.varList()) {
            if (!var.varExists(o)) {
                return false;
            }
        }
        return true;
    }
    //PRE:
    //POS: Returns whether if the given valoration can be calculated or not
}
