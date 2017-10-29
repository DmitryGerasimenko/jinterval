package net.java.jinterval.interval.affine.impl;

import net.java.jinterval.interval.Decoration;
import net.java.jinterval.interval.Interval;
import net.java.jinterval.interval.MidRad;
import net.java.jinterval.interval.affine.interfaces.AffineInterval;
import net.java.jinterval.interval.affine.interfaces.NoiseSymbol;
import net.java.jinterval.interval.set.OverlapState;
import net.java.jinterval.interval.set.SetInterval;
import net.java.jinterval.rational.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AffineIntervalImpl implements AffineInterval {
    private ExtendedRational centralValue;
    private Map<NoiseSymbol, ExtendedRational> partialDeviations = new HashMap<>();

    /**
     * Zero affine interval
     * @param noiseSymbol the noise symbol
     */
    public AffineIntervalImpl(NoiseSymbol noiseSymbol) {
        centralValue = Rational.zero();
        partialDeviations.put(noiseSymbol, Rational.zero());
    }

    /**
     * Zero const in affine interval
     */
    public AffineIntervalImpl() {
        centralValue = Rational.zero();
    }

    /**
     * centralValue const in affine interval
     */
    public AffineIntervalImpl(ExtendedRational centralValue) {
        this.centralValue = centralValue;
    }

    /**
     * Affine Arithmetic simple interval
     * @param centralValue the central value
     * @param radius the radius
     * @param noiseSymbol the noise symbol
     */
    public AffineIntervalImpl(ExtendedRational centralValue, ExtendedRational radius,
                              NoiseSymbol noiseSymbol) {
        this.centralValue = centralValue;
        partialDeviations.put(noiseSymbol, radius);
    }

    @Override
    public SetInterval toSetInterval() {
        return null;
    }

    @Override
    public ExtendedRational getPartialDeviationForNoiseSymbol(NoiseSymbol noiseSymbol) {
        ExtendedRational partialDeviation = partialDeviations.get(noiseSymbol);
        if (partialDeviation == null) {
            partialDeviation = Rational.zero();
        }
        return partialDeviation;
    }

    @Override
    public void putNoiseSymbolPartialDeviation(NoiseSymbol noiseSymbol, ExtendedRational partialDeviation) {
        partialDeviations.put(noiseSymbol, partialDeviation);
    }

    @Override
    public Set<NoiseSymbol> getNoiseSymbolSet() {
        return partialDeviations.keySet();
    }

    @Override
    public ExtendedRational inf() {
        return ExtendedRationalOps.sub(centralValue, rad());
    }

    @Override
    public ExtendedRational inf(BinaryValueSet numberFormat) {
        return ExtendedRationalContexts.mkFloor(numberFormat).sub(centralValue, rad());
    }

    @Override
    public double doubleInf() {
        return inf().doubleValue();
    }

    @Override
    public float floatInf() {
        return inf().floatValue();
    }

    @Override
    public ExtendedRational sup() {
        return ExtendedRationalOps.add(centralValue, rad());
    }

    @Override
    public ExtendedRational sup(BinaryValueSet numberFormat) {
        return ExtendedRationalContexts.mkCeiling(numberFormat).add(centralValue, rad());
    }

    @Override
    public double doubleSup() {
        return sup().doubleValue();
    }

    @Override
    public float floatSup() {
        return sup().floatValue();
    }

    @Override
    public Rational mid() {
        return (Rational) centralValue;
    }

    @Override
    public Rational mid(BinaryValueSet numberFormat) {
        return (Rational) ExtendedRationalContexts.mkNearest(numberFormat);
    }

    @Override
    public double doubleMid() {
        return mid().doubleValue();
    }

    @Override
    public float floatMid() {
        return mid().floatValue();
    }

    @Override
    public ExtendedRational wid() {
        return ExtendedRationalOps.mul(rad(), ExtendedRational.valueOf(2));
    }

    @Override
    public ExtendedRational wid(BinaryValueSet numberFormat) {
        return ExtendedRationalContexts.mkCeiling(numberFormat).mul(rad(), ExtendedRational.valueOf(2));
    }

    @Override
    public double doubleWid() {
        return wid().doubleValue();
    }

    @Override
    public float floatWid() {
        return wid().floatValue();
    }

    @Override
    public ExtendedRational rad() {
        ExtendedRational rad = Rational.zero();
        for (ExtendedRational partialDeviation : partialDeviations.values()) {
            rad = ExtendedRationalOps.add(rad, ExtendedRationalOps.abs(partialDeviation));
        }

        return rad;
    }

    @Override
    public ExtendedRational rad(BinaryValueSet numberFormat) {
        ExtendedRational rad = Rational.zero();
        ExtendedRationalContext context = ExtendedRationalContexts.mkCeiling(numberFormat);

        for (ExtendedRational partialDeviation : partialDeviations.values()) {
            rad = context.add(rad, context.abs(partialDeviation));
        }

        return rad;
    }

    @Override
    public double doubleRad() {
        return rad().doubleValue();
    }

    @Override
    public float floatRad() {
        return rad().floatValue();
    }

    @Override
    public MidRad midRad() {
        return new MidRad(mid(), rad());
    }

    @Override
    public MidRad midRad(BinaryValueSet midNumberFormat, BinaryValueSet radNumberFormat) {
        return new MidRad(mid(midNumberFormat), rad(radNumberFormat));
    }

    @Override
    public ExtendedRational mag() {
        return ExtendedRationalOps.max(ExtendedRationalOps.abs(inf()), ExtendedRationalOps.abs(sup()));
    }

    @Override
    public ExtendedRational mag(BinaryValueSet numberFormat) {
        ExtendedRationalContext context = ExtendedRationalContexts.mkCeiling(numberFormat);
        return context.max(context.abs(inf()), context.abs(sup()));
    }

    @Override
    public double doubleMag() {
        return mag().doubleValue();
    }

    @Override
    public float floatMag() {
        return mag().floatValue();
    }

    @Override
    public ExtendedRational mig() {
        return ExtendedRationalOps.min(ExtendedRationalOps.abs(inf()), ExtendedRationalOps.abs(sup()));
    }

    @Override
    public ExtendedRational mig(BinaryValueSet numberFormat) {
        ExtendedRationalContext context = ExtendedRationalContexts.mkCeiling(numberFormat);
        return context.min(context.abs(inf()), context.abs(sup()));
    }

    @Override
    public double doubleMig() {
        return mig().doubleValue();
    }

    @Override
    public float floatMig() {
        return mig().floatValue();
    }

    @Override
    public boolean equal(Interval that) {
        if (that instanceof AffineIntervalImpl) {
            if (this.centralValue.eq(((AffineIntervalImpl) that).centralValue)) {
                Set<NoiseSymbol> thisSymbols = this.getNoiseSymbolSet();
                Set<NoiseSymbol> thatSymbols = ((AffineIntervalImpl) that).getNoiseSymbolSet();
                Set<NoiseSymbol> unionSymbols = new HashSet<>(thisSymbols);
                unionSymbols.addAll(thatSymbols);

                for (NoiseSymbol noiseSymbol : unionSymbols) {
                    if (thisSymbols.contains(noiseSymbol) && thisSymbols.contains(noiseSymbol)) {
                        if (!this.getPartialDeviationForNoiseSymbol(noiseSymbol)
                                .eq(((AffineIntervalImpl) that).getPartialDeviationForNoiseSymbol(noiseSymbol))) {
                            return false;
                        }
                    } else if (!thisSymbols.contains(noiseSymbol)) {
                        if (!((AffineIntervalImpl) that).getPartialDeviationForNoiseSymbol(noiseSymbol)
                                .eq(ExtendedRational.zero())) {
                            return false;
                        }
                    } else {
                        if (!this.getPartialDeviationForNoiseSymbol(noiseSymbol).eq(ExtendedRational.zero())) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return false;
        } else {
            return this.inf().equals(that.inf()) && this.sup().equals(that.sup());
        }
    }

    @Override
    public boolean subset(Interval that) {
        return false;
    }

    @Override
    public boolean interior(Interval that) {
        return false;
    }

    @Override
    public boolean disjoint(Interval that) {
        return false;
    }

    @Override
    public String intervalToExact(BinaryValueSet valueSet) {
        return null;
    }

    @Override
    public String intervalToExactDecorated(BinaryValueSet valueSet) {
        return null;
    }

    @Override
    public String toStringDecorated() {
        return toString() + "_" + getDecoration().toString().toLowerCase();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isEntire() {
        return false;
    }

    @Override
    public boolean isNaI() {
        return false;
    }

    @Override
    public boolean isCommonInterval() {
        return false;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public boolean isMember(ExtendedRational m) {
        return false;
    }

    @Override
    public boolean isMember(double m) {
        return false;
    }

    @Override
    public boolean isMember(float m) {
        return false;
    }

    @Override
    public boolean less(Interval that) {
        return false;
    }

    @Override
    public boolean precedes(Interval that) {
        return false;
    }

    @Override
    public boolean strictLess(Interval that) {
        return false;
    }

    @Override
    public boolean strictPrecedes(Interval that) {
        return false;
    }

    @Override
    public OverlapState overlap(Interval that) {
        return null;
    }

    @Override
    public Decoration getDecoration() {
        return Decoration.TRV;
    }

    @Override
    public String toString() {
        return "[" + inf() + "," + sup() + "]";
    }
}
