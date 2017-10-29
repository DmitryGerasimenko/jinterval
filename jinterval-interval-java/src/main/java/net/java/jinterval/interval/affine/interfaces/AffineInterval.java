package net.java.jinterval.interval.affine.interfaces;

import net.java.jinterval.interval.set.SetInterval;
import net.java.jinterval.rational.ExtendedRational;

import java.util.Set;

public interface AffineInterval extends SetInterval {
    SetInterval toSetInterval();

    Set<NoiseSymbol> getNoiseSymbolSet();

    ExtendedRational getPartialDeviationForNoiseSymbol(NoiseSymbol noiseSymbol);

    void putNoiseSymbolPartialDeviation(NoiseSymbol noiseSymbol, ExtendedRational partialDeviation);
}
