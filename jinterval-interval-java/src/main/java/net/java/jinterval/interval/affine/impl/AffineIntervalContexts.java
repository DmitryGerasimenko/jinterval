package net.java.jinterval.interval.affine.impl;

import net.java.jinterval.interval.affine.interfaces.AffineIntervalContext;
import net.java.jinterval.rational.BinaryValueSet;
import net.java.jinterval.rational.ExtendedRationalContexts;

public class AffineIntervalContexts {
    public static AffineIntervalContext getAccur64() {
        return new AffineIntervalContextInfSupBase(ExtendedRationalContexts.mkFloor(BinaryValueSet.BINARY64),
                ExtendedRationalContexts.mkCeiling(BinaryValueSet.BINARY64));
    }
}
