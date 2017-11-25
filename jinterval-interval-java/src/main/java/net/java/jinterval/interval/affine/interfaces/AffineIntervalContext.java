package net.java.jinterval.interval.affine.interfaces;

import net.java.jinterval.interval.IntervalContext;
import net.java.jinterval.interval.set.SetInterval;
import net.java.jinterval.rational.ExtendedRational;

import java.util.Set;

public interface AffineIntervalContext extends IntervalContext<AffineInterval> {
    Set<NoiseSymbol> getNoiseSymbolsSet();

    AffineInterval affine(AffineInterval x, AffineInterval y, ExtendedRational alpha, ExtendedRational beta,
                       ExtendedRational zeta, ExtendedRational delta);

    AffineInterval affine(AffineInterval x, ExtendedRational alpha,
                          ExtendedRational zeta, ExtendedRational delta);

    boolean containsNoiseSymbol(NoiseSymbol noiseSymbol);

    boolean addNoiseSymbol(NoiseSymbol noiseSymbol);

    NoiseSymbol addNoiseSymbol();

    void createNoiseSymbolSet(String ...noiseSymbols);
}
