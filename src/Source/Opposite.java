package Source;

import java.util.List;

public class Opposite extends Expression {
    private Expression expr;

    public Opposite(Expression exx) {
        this.expr = exx;
    }
    //PRE:
    //POS: Creates the opposite version of the given values

    public int calculate(Valoration val) {
        return -expr.calculate(val);
    }
    //PRE:
    //POS: Returns the opposite value of the casting expression

    public Expression rename(String s1, String s2) {
        return new Opposite(expr.rename(s1, s2));
    }
    //PRE:
    //POS: Renames the casting object with the given Strings


    public List varList() {
        return expr.varList();
    }
    //PRE:
    //POS: Returns a list with the variables contained in the expression


    public Expression copy() {
        return new Opposite(expr.copy());
    }
    //PRE:
    //POS: Returns a copy of the casting expression


    Expression substitute(String s, Integer i) {
        return new Opposite(expr.substitute(s, -i));
    }
    //PRE:
    //POS: Switches the casting expression with the new values given

    public String toString() {
        return "-" + expr;
    }
}
