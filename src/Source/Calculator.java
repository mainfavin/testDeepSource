package Source;

public class Calculator {

    private Expression exp;
    private Valoration val;

    public Calculator(Expression expA, Valoration valA) {
        this.exp = expA;
        this.val = valA;
    }
    //PRE:
    //POS: Creates a new Calculator from the given values

    public Expression getExp() {
        return this.exp;
    }
    //PRE: The calculator must´ve been previously initialised
    //POS: Returns the expression part of the calculator

    public Valoration getVal() {
        return this.val;
    }
    //PRE: The calculator must´ve been previously initialised
    //POS: Returns the valoration part of the calculator

    public void modifyExpression(Expression ex1) {
        this.exp = ex1;
    }
    //PRE: The calculator must´ve been previously initialised
    //POS: Modifies the expression part of the calculator

    public void modifyValoration(Valoration val1) {
        this.val = val1;
    }
    //PRE: The calculator must´ve been previously initialised
    //POS: Modifies the valoration part of the calculator

    public boolean canBeCalculated() {
        return this.exp.calculable(this.val);
    }
    //PRE:
    //POS: Returns whether if something can be calculated or not

    public Expression substitute() {
        Expression expe = this.exp.copy();
        for (String s : this.val.varList()) {
            expe = expe.substitute(s, this.val.varValue(s));
        }
        return expe;
    }
    //PRE:
    //POS: Substitutes the expression with its valuation if possible

    public int calculate() {
        if (canBeCalculated()) {
            return this.exp.calculate(this.val);
        } else return 0;
    }
    //PRE: The calculator must´ve been previously initialised
    //POS: Calculates the value of the casting object

}
