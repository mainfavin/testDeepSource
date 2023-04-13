package Source;

import java.util.ArrayList;
import java.util.List;

public class Constant extends Expression {
    private Integer con;

    public Constant(Integer nomVar) {
        this.con = nomVar;
    }
    //PRE:
    //POS: Creates a new constant with the given parameters

    public Expression rename(String s1, String s2) {
        return new Constant(con);
    }
    //PRE:
    //POS: Renames the constant with the given values

    public List varList() {
        return new ArrayList<>();
    }
    //PRE:
    //POS: Returns a list with the variables contained in the expression

    public Expression copy() {
        return new Constant(this.con);
    }
    //PRE:
    //POS: Returns a copy of the casting object

    public Expression substitute(String s, Integer i) {
        return new Constant(con);
    }
    //PRE:
    //POS: Switches the constant with the one given (s,i)

    public int calculate(Valoration val) {
        return this.con;
    }
    //PRE:
    //POS: Calculates the value of the given valoration

    public String toString() {
        return con.toString();
    }
}
