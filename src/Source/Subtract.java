package Source;

public class Subtract extends BinaryExpression {

    public Subtract(Expression x1, Expression x2) {
        super(x1, x2);
    }
    //PRE:
    //POS: Creates a new subtraction of two numbers

    Expression rename(String s1, String s2) {
        return new Subtract(getExp1().rename(s1, s2), getExp2().rename(s1, s2));
    }
    //PRE:
    //POS: Renames s1 as s2

    Expression copy() {
        return new Subtract(this.getExp1().copy(), this.getExp2().copy());
    }
    //PRE:
    //POS: Returns a copy of the casting object

    Expression substitute(String s, Integer i) {
        return new Subtract(getExp1().substitute(s, i), getExp2().substitute(s, i));
    }
    //PRE:
    //POS: Switches the expressions with the one given (s,i)


    int calculate(Valoration val) {
        return (this.getExp1().calculate(val) - this.getExp2().calculate(val));
    }
    //PRE:
    //POS: Calculates the subtraction of the given valoration

    public String toString() {
        return ("(" + super.getExp1().toString() + ")-(" + super.getExp2().toString() + ")");
    }
}
