/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resolution.method;

/**
 *
 * @author fasih
 */
public class PropositionalLogic {
    
    public static String ConvertToCNF (String s) {
        String holder = ConvertToNNF(s);
        holder = DistributeOrOverAnd(holder);
        return holder;
    }
    
    public static String ConvertToNNF (String s) {
        /**
        * Convert a Sentence into an equivalent Negation Normal Form (NNF) Sentence. A
        * Sentence is in NNF if negation is allowed only over atoms, and conjunction,
        * disjunction, and negation are the only allowed boolean connectives
        */
        String holder = EliminateBiConditional(s);
        holder = EliminateImplication(holder);
        holder = MoveNotsInward(holder);
        return holder;
    }
    
    public static String DistributeOrOverAnd (String s) {
        /**
        * Distributivity of | over &:
        * (α | (β & γ))
        * ((α | β) & (α | γ))
        */
        
        return "";
    }
    
    public static String EliminateBiConditional (String s) {
        /*
        * (p → q) ∧ (q → p)
        */
        
        return "";
    }
    
    public static String EliminateImplication (String s) {
        /*
        * (¬p ∨ q)
        */
        
        return "";
    }
    
    public static String MoveNotsInward (String s) {
        /*
        * Move ¬ inwards by repeated application of the following equivalences:
        * ¬(¬p) ≡ p (double-negation elimination)
        * ¬(p ∧ q) ≡ (¬p ∨ ¬q) (De Morgan)
        * ¬(p ∨ q) ≡ (¬p ∧ ¬q) (De Morgan)
        */
        
        return "";
    }
    
}
