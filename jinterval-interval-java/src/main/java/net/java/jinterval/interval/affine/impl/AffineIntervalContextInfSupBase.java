package net.java.jinterval.interval.affine.impl;

import net.java.jinterval.interval.Utils;
import net.java.jinterval.interval.affine.interfaces.AffineInterval;
import net.java.jinterval.interval.affine.interfaces.AffineIntervalContext;
import net.java.jinterval.interval.affine.interfaces.NoiseSymbol;
import net.java.jinterval.rational.ExtendedRational;
import net.java.jinterval.rational.ExtendedRationalContext;
import net.java.jinterval.rational.ExtendedRationalOps;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class AffineIntervalContextInfSupBase implements AffineIntervalContext {
    private static final String DEFAULT_SYMBOL_NAME = "eps_";
    private final ExtendedRationalContext mcInf;
    private final ExtendedRationalContext mcSup;
    private final ExtendedRationalContext mcMid;
    private Set<NoiseSymbol> noiseSymbolSet;
    private int defaultSymbolNumber;

    public AffineIntervalContextInfSupBase(ExtendedRationalContext mcInf, ExtendedRationalContext mcMid,
                                           ExtendedRationalContext mcSup) {
        this.mcInf = mcInf;
        this.mcMid = mcMid;
        this.mcSup = mcSup;
        noiseSymbolSet = new HashSet<>();
        defaultSymbolNumber = 0;
    }

    @Override
    public Set<NoiseSymbol> getNoiseSymbolsSet() {
        return noiseSymbolSet;
    }

    @Override
    public AffineInterval affine(AffineInterval x, AffineInterval y, ExtendedRational alpha, ExtendedRational beta,
                              ExtendedRational zeta, ExtendedRational delta) {
        if (x.isEmpty() || y.isEmpty()) {
            return EmptyAffineInterval.empty();
        }

        if (x.isEntire() || y.isEntire() || delta.eq(ExtendedRational.POSITIVE_INFINITY)) {
            return EntireAffineInterval.entire();
        }

        ExtendedRational z0 = mcMid.add(mcMid.mul(alpha, x.mid()),
                mcMid.add(mcMid.mul(beta, y.mid()), zeta));
        if (z0.eq(ExtendedRational.POSITIVE_INFINITY)) {
            return EntireAffineInterval.entire();
        }

        AffineInterval z = new AffineIntervalImpl(z0);

        ExtendedRational a = mcInf.add(mcInf.mul(alpha, x.mid()), mcInf.add(mcInf.mul(beta, y.mid()), zeta));
        ExtendedRational b = mcSup.add(mcSup.mul(alpha, x.mid()), mcSup.add(mcSup.mul(beta, y.mid()), zeta));
        delta = mcSup.add(mcSup.max(mcSup.sub(b, z0), mcSup.sub(z0, a)), delta);

        Set<NoiseSymbol> unionNoiseSymbolSet = new HashSet<>();
        unionNoiseSymbolSet.addAll(x.getNoiseSymbolSet());
        unionNoiseSymbolSet.addAll(y.getNoiseSymbolSet());

        for (NoiseSymbol noiseSymbol : unionNoiseSymbolSet) {
            ExtendedRational zi = mcMid.add(
                    mcMid.mul(alpha, x.getPartialDeviationForNoiseSymbol(noiseSymbol)),
                    mcMid.mul(beta, y.getPartialDeviationForNoiseSymbol(noiseSymbol)));
            z.putNoiseSymbolPartialDeviation(noiseSymbol, zi);

            a = mcInf.add(mcInf.mul(alpha, x.getPartialDeviationForNoiseSymbol(noiseSymbol)),
                    mcInf.mul(beta, y.getPartialDeviationForNoiseSymbol(noiseSymbol)));
            b = mcSup.add(mcSup.mul(alpha, x.getPartialDeviationForNoiseSymbol(noiseSymbol)),
                    mcSup.mul(beta, y.getPartialDeviationForNoiseSymbol(noiseSymbol)));
            delta = mcSup.add(delta, mcSup.max(mcSup.sub(b, zi), mcSup.sub(zi, a)));
        }

        if (delta.eq(ExtendedRational.POSITIVE_INFINITY)) {
            return EntireAffineInterval.entire();
        }
        NoiseSymbol noiseSymbol = addNoiseSymbol();
        z.putNoiseSymbolPartialDeviation(noiseSymbol, delta);

        return z;
    }

    @Override
    public boolean containsNoiseSymbol(NoiseSymbol noiseSymbol) {
        return noiseSymbolSet.contains(noiseSymbol);
    }

    @Override
    public boolean addNoiseSymbol(NoiseSymbol noiseSymbol) {
        return noiseSymbolSet.add(noiseSymbol);
    }

    @Override
    public void createNoiseSymbolSet(String ...noiseSymbols) {
        for (String noiseSymbolName: noiseSymbols) {
            NoiseSymbol noiseSymbol = new NoiseSymbolImpl(noiseSymbolName);
            addNoiseSymbol(noiseSymbol);
        }
    }

    @Override
    public NoiseSymbol addNoiseSymbol() {
        defaultSymbolNumber++;
        NoiseSymbol noiseSymbol = new NoiseSymbolImpl(DEFAULT_SYMBOL_NAME + defaultSymbolNumber);
        while (containsNoiseSymbol(noiseSymbol)) {
            defaultSymbolNumber++;
            noiseSymbol = new NoiseSymbolImpl(DEFAULT_SYMBOL_NAME + defaultSymbolNumber);
        }
        addNoiseSymbol(noiseSymbol);
        return noiseSymbol;
    }

    @Override
    public AffineInterval hull(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval newDec(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval numsToInterval(ExtendedRational l, ExtendedRational u) {
        ExtendedRational centralValue = mcMid.mul(
                mcMid.add(l, u), Utils.RAT_HALF);
        ExtendedRational radius = mcMid.mul(mcMid.sub(u, l), Utils.RAT_HALF);
        NoiseSymbol noiseSymbol = addNoiseSymbol();
        return new AffineIntervalImpl(centralValue, radius, noiseSymbol);
    }

    @Override
    public AffineInterval numsToInterval(double l, double u) {
        return null;
    }

    @Override
    public AffineInterval numsToInterval(float l, float u) {
        return null;
    }

    @Override
    public AffineInterval textToInterval(String s) {
        return null;
    }

    @Override
    public AffineInterval textToDecoratedInterval(String s) {
        return null;
    }

    @Override
    public AffineInterval pi() {
        return null;
    }

    @Override
    public AffineInterval euler() {
        return null;
    }

    @Override
    public AffineInterval neg(AffineInterval x) {
        if (x.isEmpty() || x.isEntire()) {
            return x;
        }

        AffineInterval negated = new AffineIntervalImpl(ExtendedRationalOps.neg(x.mid()));
        for (NoiseSymbol noiseSymbol : x.getNoiseSymbolSet()) {
            negated.putNoiseSymbolPartialDeviation(noiseSymbol,
                    ExtendedRationalOps.neg(x.getPartialDeviationForNoiseSymbol(noiseSymbol)));
        }
        return negated;
    }

    @Override
    public AffineInterval add(AffineInterval x, AffineInterval y) {
        return affine(x, y, ExtendedRational.one(), ExtendedRational.one(), ExtendedRational.zero(),
                ExtendedRational.zero());
    }

    @Override
    public AffineInterval sub(AffineInterval x, AffineInterval y) {
        return add(x, neg(y));
    }

    @Override
    public AffineInterval mul(AffineInterval x, AffineInterval y) {
        if (x.isEmpty() || y.isEmpty()) {
            return EmptyAffineInterval.empty();
        }

        if (x.isEntire() || y.isEntire()) {
            return EntireAffineInterval.entire();
        }

        ExtendedRational product = ExtendedRationalOps.neg(ExtendedRationalOps.mul(x.mid(), y.mid()));
        ExtendedRational delta = mcSup.mul(x.rad(), y.rad());

        return affine(x, y, y.mid(), x.mid(), product, delta);
    }

    @Override
    public AffineInterval div(AffineInterval x, AffineInterval y) {
        return null;
    }

    @Override
    public AffineInterval recip(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval sqr(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval sqrt(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval fma(AffineInterval x, AffineInterval y, AffineInterval z) {
        return null;
    }

    @Override
    public AffineInterval pown(AffineInterval x, BigInteger p) {
        return null;
    }

    @Override
    public AffineInterval pown(AffineInterval x, long p) {
        return null;
    }

    @Override
    public AffineInterval pown(AffineInterval x, int p) {
        return null;
    }

    @Override
    public AffineInterval pow(AffineInterval x, AffineInterval y) {
        return null;
    }

    @Override
    public AffineInterval exp(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval exp2(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval exp10(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval log(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval log2(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval log10(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval sin(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval cos(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval tan(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval asin(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval acos(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval atan(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval atan2(AffineInterval y, AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval sinh(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval cosh(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval tanh(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval asinh(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval acosh(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval atanh(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval sign(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval ceil(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval floor(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval trunc(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval roundTiesToEven(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval roundTiesToAway(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval abs(AffineInterval x) {
        return null;
    }

    @Override
    public AffineInterval min(AffineInterval x1, AffineInterval x2) {
        return null;
    }

    @Override
    public AffineInterval min(AffineInterval x1, AffineInterval x2, AffineInterval... xn) {
        return null;
    }

    @Override
    public AffineInterval max(AffineInterval x1, AffineInterval x2) {
        return null;
    }

    @Override
    public AffineInterval max(AffineInterval x1, AffineInterval x2, AffineInterval... xn) {
        return null;
    }

    @Override
    public AffineInterval cancelMinus(AffineInterval x, AffineInterval y) {
        return null;
    }

    @Override
    public AffineInterval cancelPlus(AffineInterval x, AffineInterval y) {
        return null;
    }

    @Override
    public AffineInterval intersection(AffineInterval x, AffineInterval y) {
        return null;
    }

    @Override
    public AffineInterval convexHull(AffineInterval x, AffineInterval y) {
        return null;
    }
}
