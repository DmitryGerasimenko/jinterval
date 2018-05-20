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
    public AffineInterval affine(AffineInterval x, ExtendedRational alpha, ExtendedRational zeta, ExtendedRational delta) {
        if (x.isEmpty() || x.isEntire()) {
            return x;
        }

        ExtendedRational z0 = mcMid.add(mcMid.mul(alpha, x.mid()), zeta);
        if (z0.eq(ExtendedRational.POSITIVE_INFINITY)) {
            return EntireAffineInterval.entire();
        }

        AffineInterval z = new AffineIntervalImpl(z0);

        ExtendedRational a = mcInf.add(mcInf.mul(alpha, x.mid()), zeta);
        ExtendedRational b = mcSup.add(mcSup.mul(alpha, x.mid()), zeta);
        delta = mcSup.add(mcSup.max(mcSup.sub(b, z0), mcSup.sub(z0, a)), delta);

        for (NoiseSymbol noiseSymbol : x.getNoiseSymbolSet()) {
            ExtendedRational zi =
                    mcMid.mul(alpha, x.getPartialDeviationForNoiseSymbol(noiseSymbol));
            z.putNoiseSymbolPartialDeviation(noiseSymbol, zi);

            a = mcInf.mul(alpha, x.getPartialDeviationForNoiseSymbol(noiseSymbol));
            b = mcSup.mul(alpha, x.getPartialDeviationForNoiseSymbol(noiseSymbol));
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
        ExtendedRational centralValue = centralValue(l, u);
        ExtendedRational radius = radiusValue(l, u);
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
        return mul(x, recip(y));
    }

    @Override
    public AffineInterval recip(AffineInterval x) {
        if (x.isEmpty() || x.isEntire()) {
            return x;
        }

        if (x.inf().le(ExtendedRational.zero()) && x.sup().ge(ExtendedRational.zero())) {
            return EntireAffineInterval.entire();
        }

        ExtendedRational a = x.mig();
        ExtendedRational b = x.mag();
        ExtendedRational alpha = ExtendedRationalOps.neg(ExtendedRationalOps.recip(
                ExtendedRationalOps.sqr(b)));
        ExtendedRational dMax = ExtendedRationalOps.sub(ExtendedRationalOps.recip(a),
                ExtendedRationalOps.mul(alpha, a));
        ExtendedRational dMin = ExtendedRationalOps.sub(ExtendedRationalOps.recip(b),
                ExtendedRationalOps.mul(alpha, b));
        ExtendedRational zeta = centralValue(dMin, dMax);
        if (x.inf().lt(ExtendedRational.zero())) {
            zeta = ExtendedRationalOps.neg(zeta);
        }

        ExtendedRational delta = radiusValue(dMin, dMax);

        return affine(x, alpha, zeta, delta);
    }

    @Override
    public AffineInterval sqr(AffineInterval x) {
        if (x.isEmpty() || x.isEntire()) {
            return x;
        }

        ExtendedRational delta = ExtendedRationalOps.mul(ExtendedRationalOps.sqr(x.rad()),
                Utils.RAT_HALF);

        ExtendedRational sqrCentralValue = ExtendedRationalOps.add(ExtendedRationalOps.sqr(x.mid()),
                delta);
        AffineInterval sqr = new AffineIntervalImpl(sqrCentralValue);
        for (NoiseSymbol noiseSymbol : x.getNoiseSymbolSet()) {
            ExtendedRational partialDeviation = ExtendedRationalOps.mul(Utils.TWO,
                    ExtendedRationalOps.mul(x.mid(), x.getPartialDeviationForNoiseSymbol(noiseSymbol)));
            sqr.putNoiseSymbolPartialDeviation(noiseSymbol, partialDeviation);
        }

        NoiseSymbol noiseSymbol = addNoiseSymbol();
        sqr.putNoiseSymbolPartialDeviation(noiseSymbol, delta);

        return sqr;
    }

    @Override
    public AffineInterval sqrt(AffineInterval x) {
        if (x.isEmpty() || x.isEntire()) {
            return x;
        }

        ExtendedRational xSup = x.sup();
        if (xSup.lt(ExtendedRational.zero())) {
            return EmptyAffineInterval.empty();
        }

        if (!xSup.lt(ExtendedRational.POSITIVE_INFINITY)) {
            return EntireAffineInterval.entire();
        }
        ExtendedRational xInf = ExtendedRationalOps.max(x.inf(), ExtendedRational.zero());

        ExtendedRational sqrtInf = ExtendedRationalOps.sqrt(xInf);
        ExtendedRational sqrtSup = ExtendedRationalOps.sqrt(xSup);
        ExtendedRational gamma = ExtendedRationalOps.add(sqrtInf, sqrtSup);
        ExtendedRational dInf = ExtendedRationalOps.mul(sqrtInf, ExtendedRationalOps.sub(ExtendedRational.one(),
                ExtendedRationalOps.div(sqrtInf, gamma)));
        ExtendedRational dSup = ExtendedRationalOps.mul(sqrtSup, ExtendedRationalOps.sub(ExtendedRational.one(),
                ExtendedRationalOps.div(sqrtSup, gamma)));

        ExtendedRational dMin = ExtendedRationalOps.min(dInf, dSup);
        ExtendedRational dMax = ExtendedRationalOps.div(gamma, ExtendedRational.valueOf(4));

        ExtendedRational zeta = centralValue(dMin, dMax);
        ExtendedRational delta = radiusValue(dMin, dMax);
        return affine(x, ExtendedRationalOps.recip(gamma), zeta, delta);

//        Min-range approx
//        ExtendedRational alpha = ExtendedRationalOps.recip(ExtendedRationalOps.mul(Utils.TWO,
//                sqrtSup));
//        ExtendedRational zeta = ExtendedRationalOps.div(sqrtSup, Utils.TWO);
//        ExtendedRational delta = ExtendedRationalOps.div(ExtendedRationalOps.sqr(
//                ExtendedRationalOps.sub(sqrtSup, sqrtInf)),
//                ExtendedRationalOps.mul(Utils.TWO, sqrtSup));
//        return affine(x, alpha, zeta, delta);
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
        if (x.isEntire() || x.isEmpty()) {
            return x;
        }

        ExtendedRational xInf = x.inf();
        ExtendedRational xSup = x.sup();

        if (xInf.ge(ExtendedRational.zero())) {
            return x;
        }

        if (xSup.le(ExtendedRational.zero())) {
            return neg(x);
        }

        ExtendedRational radius = x.rad();
        ExtendedRational alpha = ExtendedRationalOps.div(x.mid(), radius);
        ExtendedRational gamma = ExtendedRationalOps.mul(ExtendedRationalOps.sub(ExtendedRational.one(),
                alpha), );
        return null;
    }

    @Override
    public AffineInterval min(AffineInterval x1, AffineInterval x2) {
        if (x1.isEmpty() || x2.isEmpty()) {
            return EmptyAffineInterval.empty();
        }

        ExtendedRational inf = ExtendedRationalOps.min(x1.inf(), x2.inf());
        ExtendedRational sup = ExtendedRationalOps.min(x1.sup(), x2.sup());
        ExtendedRational centralValue = centralValue(inf, sup);
        ExtendedRational radiusValue = radiusValue(inf, sup);

        return new AffineIntervalImpl(centralValue, radiusValue, addNoiseSymbol());
    }

    @Override
    public AffineInterval min(AffineInterval x1, AffineInterval x2, AffineInterval... xn) {
        return null;
    }

    @Override
    public AffineInterval max(AffineInterval x1, AffineInterval x2) {
        if (x1.isEmpty() || x2.isEmpty()) {
            return EmptyAffineInterval.empty();
        }

        ExtendedRational inf = ExtendedRationalOps.max(x1.inf(), x2.inf());
        ExtendedRational sup = ExtendedRationalOps.max(x1.sup(), x2.sup());
        ExtendedRational centralValue = centralValue(inf, sup);
        ExtendedRational radiusValue = radiusValue(inf, sup);

        return new AffineIntervalImpl(centralValue, radiusValue, addNoiseSymbol());
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

    private static ExtendedRational centralValue(ExtendedRational inf, ExtendedRational sup) {
        return ExtendedRationalOps.mul(ExtendedRationalOps.add(inf, sup), Utils.RAT_HALF);
    }

    private static ExtendedRational radiusValue(ExtendedRational inf, ExtendedRational sup) {
        return ExtendedRationalOps.mul(ExtendedRationalOps.sub(sup, inf), Utils.RAT_HALF);
    }
}
