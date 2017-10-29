package net.java.jinterval.interval.affine.impl;

import net.java.jinterval.interval.Decoration;
import net.java.jinterval.interval.Interval;
import net.java.jinterval.interval.MidRad;
import net.java.jinterval.interval.affine.interfaces.AffineInterval;
import net.java.jinterval.interval.affine.interfaces.NoiseSymbol;
import net.java.jinterval.interval.set.OverlapState;
import net.java.jinterval.interval.set.SetInterval;
import net.java.jinterval.rational.BinaryValueSet;
import net.java.jinterval.rational.ExtendedRational;
import net.java.jinterval.rational.ExtendedRationalOps;
import net.java.jinterval.rational.Rational;

import java.util.HashMap;
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
        return null;
    }

    @Override
    public double doubleInf() {
        return 0;
    }

    @Override
    public float floatInf() {
        return 0;
    }

    @Override
    public ExtendedRational sup() {
        return ExtendedRationalOps.add(centralValue, rad());
    }

    @Override
    public ExtendedRational sup(BinaryValueSet numberFormat) {
        return null;
    }

    @Override
    public double doubleSup() {
        return 0;
    }

    @Override
    public float floatSup() {
        return 0;
    }

    @Override
    public Rational mid() {
        return (Rational) centralValue;
    }

    @Override
    public Rational mid(BinaryValueSet numberFormat) {
        return null;
    }

    @Override
    public double doubleMid() {
        return 0;
    }

    @Override
    public float floatMid() {
        return 0;
    }

    @Override
    public ExtendedRational wid() {
        return null;
    }

    @Override
    public ExtendedRational wid(BinaryValueSet numberFormat) {
        return null;
    }

    @Override
    public double doubleWid() {
        return 0;
    }

    @Override
    public float floatWid() {
        return 0;
    }

    @Override
    public ExtendedRational rad() {
        ExtendedRational rad = Rational.zero();
        for (NoiseSymbol noiseSymbol : getNoiseSymbolSet()) {
            rad = ExtendedRationalOps.add(rad, ExtendedRationalOps.abs(getPartialDeviationForNoiseSymbol(noiseSymbol)));
        }
        return rad;
    }

    @Override
    public ExtendedRational rad(BinaryValueSet numberFormat) {
        return null;
    }

    @Override
    public double doubleRad() {
        return 0;
    }

    @Override
    public float floatRad() {
        return 0;
    }

    @Override
    public MidRad midRad() {
        return null;
    }

    @Override
    public MidRad midRad(BinaryValueSet midNumberFormat, BinaryValueSet radNumberFormar) {
        return null;
    }

    @Override
    public ExtendedRational mag() {
        return null;
    }

    @Override
    public ExtendedRational mag(BinaryValueSet numberFormat) {
        return null;
    }

    @Override
    public double doubleMag() {
        return 0;
    }

    @Override
    public float floatMag() {
        return 0;
    }

    @Override
    public ExtendedRational mig() {
        return null;
    }

    @Override
    public ExtendedRational mig(BinaryValueSet numberFormat) {
        return null;
    }

    @Override
    public double doubleMig() {
        return 0;
    }

    @Override
    public float floatMig() {
        return 0;
    }

    @Override
    public boolean equal(Interval that) {
        return false;
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
        return null;
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
        return null;
    }
}
