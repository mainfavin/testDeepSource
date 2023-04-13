package Source;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Valoration {
    private Map<String, Integer> variable;


    public Valoration() {
        variable = new Hashtable<>();
    }
    //PRE:
    //POS: Creates a new valoration from te given values

    public boolean coherent(Valoration v1) {
         List<String> listaV = v1.varList();
        for (String aux : listaV) {
            if (this.varExists(aux)) {
                if (!(v1.variable.get(aux).equals(variable.get(aux)))) {
                    return false;
                }
            }
        }
        return true;
    }
    //PRE: The valoration must´ve been previously initialised
    //POS: Returns whether if two valorations have the same number assigned to them or not

    public void joinValorations(Valoration v1) {
        List<String> listaV = v1.varList();
        if(this.coherent(v1)){
            for(String aux : listaV){
                this.addAssignation(aux,v1.varValue(aux));
            }
        }
    }
    //PRE: The valoration must´ve been previously initialised
    //POS: Joins the casting valoration with the  one given

    public void addAssignation(String s, Integer i) {
        variable.put(s, i);
    }
    //PRE: The valoration must´ve been previously initialised
    //POS: Adds a new assignation to the casting valoration

    public void deleteAssignation(String s) {
        variable.remove(s);
    }
    //PRE: The valoration must´ve been previously initialised
    //POS: Removes an assignation to the casting valoration

    public Integer varValue(String s) {
        return variable.get(s);
    }
    //PRE: The valoration must´ve been previously initialised
    //POS: Returns the numeric value of a variable contained in the valoration

    public boolean varExists(String s) {
        return (variable.containsKey(s));
    }
    //PRE: The valoration must´ve been previously initialised
    //POS: Returns whether if a variable is contained in the valoration

    public List<String> varList() {
        return new ArrayList<>(this.variable.keySet());
    }
    //PRE: The valoration must´ve been previously initialised
    //POS: Returns a  list of the variables contained in the casting valoration

}
