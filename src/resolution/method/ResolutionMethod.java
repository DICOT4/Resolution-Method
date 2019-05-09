package resolution.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author fasih
 */
public class ResolutionMethod {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<String> list = new LinkedList<>();
        List<Clause> clauses = new ArrayList<>();        
        
        System.out.println("Alphabets\t:\tp - z");
        System.out.println("AND\t\t=\t∧");
        System.out.println("OR\t\t=\t∨");
        System.out.println("NOT\t\t=\t¬");
        System.out.println("IMPLICATION\t=\t→");
        System.out.println("D. IMPLICATION\t=\t⇔");
        System.out.print("\nEnter clause: ");
        
        list.add(stripSlashes(scanner.nextLine()));
        
        for (int i=0; i<list.size(); i++) {
            String hold = list.get(i);
            if (hold.contains("∧")) {
                list.addAll(Arrays.asList(hold.split("∧", 2)));
            } else {
                clauses.add(new Clause(hold, false));
            }
        }
        
        for (int i=0; i<clauses.size(); i++) {
            clauses.get(i).setDone(true);
            for (int j=i; j<clauses.size(); j++) {
                if (i != j) {
                    
                    clauses.get(j).setDone(true);
                    
                    System.out.println("Iteration #" + (i+j));
                    String holder = clauses.get(i).evaluate(clauses.get(j).getClause());
                    System.out.println("Clause1: " + clauses.get(i).getClause());
                    System.out.println("Clause2: " + clauses.get(j).getClause());
                    System.out.println("Result: " + holder);
                    
                    clauses.forEach((Clause clause) -> {
                        System.out.println(clause.getClause() + " " + clause.isDone());
                    });
                    
                    System.out.println();
                    
                    if (holder.equals("Empty")) {
                        System.out.println("Empty Found!");
                        System.exit(0);
                    } else if (!holder.equals("None")) {
                        clauses.add(new Clause(holder, false));
    //                    System.out.println(holder);
                    }
                }
            }
        }
        
        System.out.println("Empty Not Found!");
    }
    
    public static String stripSlashes (String s) {
        String n = "";
        for (int i=0; i<s.length(); i++)
            if (s.charAt(i) != '(' && s.charAt(i) != ')')
                n += s.charAt(i);
        
        return n;
    }
    
    public static String eliminate (String clause1, String clause2) {
        
        return "";
    }
    
}
