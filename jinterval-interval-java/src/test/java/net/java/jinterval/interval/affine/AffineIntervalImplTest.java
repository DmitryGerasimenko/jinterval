package net.java.jinterval.interval.affine;

import net.java.jinterval.interval.affine.impl.AffineIntervalContexts;
import net.java.jinterval.interval.affine.interfaces.AffineInterval;
import net.java.jinterval.interval.affine.interfaces.AffineIntervalContext;
import net.java.jinterval.rational.Rational;
import org.junit.Test;

public class AffineIntervalImplTest {
    private AffineIntervalContext context = AffineIntervalContexts.getAccur64();

    @Test
    public void createTest() {

        Rational a = Rational.valueOf(0);
        Rational b = Rational.valueOf(1);
        Rational c = Rational.valueOf(2);
        Rational d = Rational.valueOf(3);
        AffineInterval affine1 = context.numsToInterval(a, b);
        AffineInterval affine2 = context.numsToInterval(b, c);
        AffineInterval affine3 = context.numsToInterval(d, d);
        AffineInterval affine4 = context.numsToInterval(b, b);

        AffineInterval result = context.add(context.sub(
                context.mul(affine1, affine2), affine1), affine3);
        AffineInterval result2 = context.add(context.mul(affine1, context.sub(
                affine2, affine4)), affine3);
        System.out.println(result);
        System.out.println(result2);
    }
}
