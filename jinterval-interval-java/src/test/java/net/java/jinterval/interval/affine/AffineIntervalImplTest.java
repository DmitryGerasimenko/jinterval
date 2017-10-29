package net.java.jinterval.interval.affine;

import net.java.jinterval.interval.affine.impl.AffineIntervalContexts;
import net.java.jinterval.interval.affine.interfaces.AffineInterval;
import net.java.jinterval.interval.affine.interfaces.AffineIntervalContext;
import net.java.jinterval.rational.Rational;
import org.junit.Test;

public class AffineIntervalImplTest {
    private AffineIntervalContext affineIntervalContext = AffineIntervalContexts.getAccur64();

    @Test
    public void createTest() {
        Rational a = Rational.valueOf(0);
        Rational b = Rational.valueOf(1);
        Rational c = Rational.valueOf(2);
        Rational d = Rational.valueOf(3);
        AffineInterval affineInterval1 = affineIntervalContext.numsToInterval(a, b);
        AffineInterval affineInterval2 = affineIntervalContext.numsToInterval(b, c);
        AffineInterval affineInterval3 = affineIntervalContext.numsToInterval(d, d);

        AffineInterval result =
                affineIntervalContext.affine(affineInterval1, affineInterval2, a, b, c, Rational.zero());
        System.out.println(affineInterval3);
    }
}
