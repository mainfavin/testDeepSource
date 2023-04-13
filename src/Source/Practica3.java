package Source;

public class Practica3 {
    public static void main(String[] args) {
//(x+z)*((11-(-y))+1)
        Expression x = new Variable("x");
        Expression y = new Variable("y");
        Expression z = new Variable("z");
        Expression c1 = new Constant(1);
        Expression c2 = new Constant(11);
        Expression c3 = new Constant(15);

        Expression e1 = new Add(x,z);
        Expression e2 = new Opposite(y);
        Expression e3 = new Subtract(c2,e2);
        Expression e4 = new Add(e3,c1);

        Expression e5 = new Product(e1,e4);

        Valoration val1 = new Valoration();
        val1.addAssignation("x", 3);
        val1.addAssignation("y", 9);
        val1.addAssignation("z", 15);

        Calculator calcu = new Calculator(e5,val1);

        System.out.println("Suma:\n" + calcu.getExp().toString());
        System.out.println("a");
    }
}
