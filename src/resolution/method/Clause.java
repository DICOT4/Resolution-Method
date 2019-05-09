package resolution.method;

/**
 *
 * @author fasih
 */
public class Clause {
    private String clause;
    private boolean done;

    public Clause(String clause, boolean done) {
        this.clause = clause;
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    
    public String getClause() {
        return clause;
    }

    public void setClause(String clause) {
        this.clause = clause;
    }
    
    public String evaluate (String clause) {
        String op_one[] = getOperands(this.clause);
        String op_two[] = getOperands(clause);
        
        String n_str = "";
        
        switch (op_one.length) {
            case 1:
                switch (op_two.length) {
                    case 1:
                        if (op_one[0].equals(negationOf(op_two[0]))) {
                            // ¬p and p

                        }
                        break;
                    case 2:
                        if (op_one[0].equals(negationOf(op_two[0]))) {
                            // ¬p and (p ∨ r)

                        } else if (op_one[0].equals(negationOf(op_two[1]))) {
                            // ¬p and (r ∨ p)

                        }
                        break;
                }
                break;
            case 2:
                switch (op_two.length) {
                    case 1:
                        if (op_one[0].equals(negationOf(op_two[0]))) {
                            // (¬p ∨ q) and p

                        } else if (op_one[1].equals(negationOf(op_two[0]))) {
                            // (p ∨ q) and ¬q

                        }
                        break;
                    case 2:
                        if (op_one[0].equals(negationOf(op_two[0]))) {
                            // (¬p ∨ q) and (p ∨ r)

                        } else if (op_one[0].equals(negationOf(op_two[1]))) {
                            // (¬p ∨ q) and (r ∨ p)

                        } else if (op_one[1].equals(negationOf(op_two[0]))) {
                            // (p ∨ q) and (¬q ∨ r)

                        } else if (op_one[1].equals(negationOf(op_two[1]))) {
                            // (p ∨ q) and (r ∨ ¬q)

                        }
                        break;
                }
                break;
        }
        
        return "";
    }
    
    private String[] getOperands (String clause) {
        return clause.split("∨");
    }
    
    private String negationOf (String value) {
        if (value.length() == 1)
            return "¬" + value;
        else
            return value.charAt(1)+"";
    }
    
}
