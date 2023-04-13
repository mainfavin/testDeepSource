package Source;

import java.util.List;

public abstract class BinaryExpression extends Expression {

    private Expression exp1;
    private Expression exp2;

    public BinaryExpression(Expression x1, Expression x2) {
        this.exp1 = x1;
        this.exp2 = x2;
    }
    //PRE:
    //POS:Creates a new Binary Expression from the given expressions (x1 and x2)

    abstract Expression rename(String s1, String s2);
    //PRE:
    //POS: Renames the casting object with the given Strings

    public List varList() {
        List l1, l2;
        {
            l1 = exp1.varList();
            l2 = exp2.varList();
            for (Object o : l1) {
                if (!l2.contains(o)) {
                    l2.add(o);
                }
            }
        }
        return l2;
    }
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

    protected Expression getExp1() {
        return this.exp1;
    }
    //PRE: The Binary Expression must´ve been previously created
    //POS: Returns the first component of the Binary Expression

    protected Expression getExp2() {
        return this.exp2;
    }
    //PRE: The Binary Expression must´ve been previously created
    //POS: Returns the second component of the Binary Expression
}
