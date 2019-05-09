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
        
        String n_str = "None";
        
        switch (op_one.length) {
            case 1:
                switch (op_two.length) {
                    case 1:
                        if (op_one[0].equals(negationOf(op_two[0]))) {
                            // ¬p and p
                            n_str = "Empty";
                        }
                        break;
                    case 2:
                        if (op_one[0].equals(negationOf(op_two[0]))) {
                            // ¬p and (p ∨ r)
                            n_str = op_two[1];
                        } else if (op_one[0].equals(negationOf(op_two[1]))) {
                            // ¬p and (r ∨ p)
                            n_str = op_two[0];
                        }
                        break;
                }
                break;
            case 2:
                switch (op_two.length) {
                    case 1:
                        if (op_one[0].equals(negationOf(op_two[0]))) {
                            // (¬p ∨ q) and p
                            n_str = op_one[1];
                        } else if (op_one[1].equals(negationOf(op_two[0]))) {
                            // (p ∨ q) and ¬q
                            n_str = op_one[0];
                        }
                        break;
                    case 2:
                        if (op_one[0].equals(negationOf(op_two[0])) && op_one[1].equals(negationOf(op_two[1]))) {
                            // (q∨s)∧(¬q∨¬s)
                            n_str = "Empty";
                        } else if (op_one[0].equals(negationOf(op_two[1])) && op_one[1].equals(negationOf(op_two[0]))) {
                            // (q∨s)∧(¬s∨¬q)
                            n_str = "Empty";
                        } else if (op_one[0].equals(negationOf(op_two[0]))) {
                            // (¬p ∨ q) and (p ∨ r)
                            n_str = op_one[1] + "∨" + op_two[1];
                        } else if (op_one[0].equals(negationOf(op_two[1]))) {
                            // (¬p ∨ q) and (r ∨ p)
                            n_str = op_one[1] + "∨" + op_two[0];
                        } else if (op_one[1].equals(negationOf(op_two[0]))) {
                            // (p ∨ q) and (¬q ∨ r)
                            n_str = op_one[0] + "∨" + op_two[1];
                        } else if (op_one[1].equals(negationOf(op_two[1]))) {
                            // (p ∨ q) and (r ∨ ¬q)
                            n_str = op_one[0] + "∨" + op_two[0];
                        }
                        break;
                }
                break;
        }
        
        return n_str;
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
