package org.example.threadSafety;

import java.math.BigInteger;

public class CachedFactorizer implements Servlet {
    // Encapsulate mutable state
    @Mutable @GuardedBy(guardBy = "this") private BigInteger lastNumber;
    @Mutable @GuardedBy(guardBy = "this") private BigInteger[] lastFactors;
    @Mutable @GuardedBy(guardBy = "this") private long hits;
    @Mutable @GuardedBy(guardBy = "this") private long cacheHits;


    public synchronized long getHits() { return hits; } //must synchronized any access
                                                        // to shared mutable state

    public synchronized double getCacheHitRatio() {
        return (double) cacheHits / (double) getHits();} //invariant


    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = req.extract();
        BigInteger[] factors = null;

        synchronized (this) {
            ++hits; //read -> change -> write operation must be atomic

            if (i.equals(lastNumber)) { //check-> then act operation must be atomic
                ++cacheHits; //moreover read -> change -> write operation
                factors = lastFactors.clone(); //moreover access to mutable state
            }
        }

        if (factors == null) { //a local variable check
            factors = factor(i); //supposed this is hard-calculating operation

            synchronized (this) {
                lastNumber = i;
                lastFactors = factors.clone();
            }
        }

        encode(resp, factors);
    }

    public void encode(ServletResponse resp, BigInteger[] factors) {
        // perform Response
    }


    public BigInteger[] factor(BigInteger i) {
        return null;
    }
}
