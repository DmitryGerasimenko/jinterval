package net.java.jinterval.interval.affine.impl;

import net.java.jinterval.interval.Decoration;
import net.java.jinterval.interval.affine.interfaces.AffineInterval;
import net.java.jinterval.interval.affine.interfaces.NoiseSymbol;
import net.java.jinterval.interval.set.EmptyInterval;
import net.java.jinterval.interval.set.SetInterval;
import net.java.jinterval.rational.ExtendedRational;
import net.java.jinterval.rational.Rational;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EmptyAffineInterval extends EmptyInterval implements AffineInterval {
    private static final Map<NoiseSymbol, ExtendedRational> emptyPartialDeviations = new HashMap<>();
    public static final EmptyAffineInterval EMPTY_AFFINE_INTERVAL = new EmptyAffineInterval();

    private EmptyAffineInterval() {
        super(Decoration.TRV);
    }

    @Override
    public void putNoiseSymbolPartialDeviation(NoiseSymbol noiseSymbol, ExtendedRational partialDeviation) {

    }

    @Override
    public Set<NoiseSymbol> getNoiseSymbolSet() {
        return emptyPartialDeviations.keySet();
    }

    @Override
    public ExtendedRational getPartialDeviationForNoiseSymbol(NoiseSymbol noiseSymbol) {
        return Rational.zero();
    }

    @Override
    public SetInterval toSetInterval() {
        return null;
    }

    public static AffineInterval empty() {
        return EMPTY_AFFINE_INTERVAL;
    }

}
