package net.java.jinterval.interval.affine.impl;

import net.java.jinterval.interval.affine.interfaces.AffineInterval;
import net.java.jinterval.interval.affine.interfaces.NoiseSymbol;
import net.java.jinterval.interval.set.EntireInterval;
import net.java.jinterval.interval.set.SetInterval;
import net.java.jinterval.rational.ExtendedRational;

import java.util.Set;

public class EntireAffineInterval extends EntireInterval implements AffineInterval {
    public static final EntireAffineInterval ENTIRE_AFFINE_INTERVAL = new EntireAffineInterval();

    private EntireAffineInterval() {
    }

    /**
     * Should return Set of Context
     * @return
     */
    @Override
    public Set<NoiseSymbol> getNoiseSymbolSet() {
        return null;
    }

    @Override
    public void putNoiseSymbolPartialDeviation(NoiseSymbol noiseSymbol, ExtendedRational partialDeviation) {

    }

    @Override
    public ExtendedRational getPartialDeviationForNoiseSymbol(NoiseSymbol noiseSymbol) {
        return ExtendedRational.POSITIVE_INFINITY;
    }

    @Override
    public SetInterval toSetInterval() {
        return null;
    }

    public static EntireAffineInterval entire() {
        return ENTIRE_AFFINE_INTERVAL;
    }
}
