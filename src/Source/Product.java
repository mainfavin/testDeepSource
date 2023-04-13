package Source;

public class Product extends BinaryExpression {

    public Product(Expression x1, Expression x2) {
        super(x1, x2);
    }
    //PRE:
    //POS: Renames s1 as s2

    Expression rename(String s1, String s2) {
        return new Product(getExp1().rename(s1, s2), getExp2().rename(s1, s2));
    }
    //PRE:
    //POS: Renames the casting object with the given Strings


    Expression copy() {
        return new Product(this.getExp1().copy(), this.getExp2().copy());
    }
    //PRE:
    //POS: Returns a copy of the casting expression

    Expression substitute(String s, Integer i) {
        return new Product(getExp1().substitute(s, i), getExp2().substitute(s, i));
    }
    //PRE:
    //POS: Switches the casting expression with the new values given

    int calculate(Valoration val) {
        return (this.getExp1().calculate(val) * this.getExp2().calculate(val));
    }
    //PRE:
    //POS: Returns the product of the valoration

    public String toString() {
        return ("(" + super.getExp1().toString() + ")*(" + super.getExp2().toString() + ")");
    }
}
