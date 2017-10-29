package net.java.jinterval.interval.set;

import net.java.jinterval.interval.Decoration;
import net.java.jinterval.interval.Interval;
import net.java.jinterval.interval.MidRad;
import net.java.jinterval.rational.BinaryValueSet;
import net.java.jinterval.rational.ExtendedRational;
import net.java.jinterval.rational.Rational;

public class EntireInterval implements SetInterval {
    public static final EntireInterval ENTIRE_INTERVAL = new EntireInterval();

    protected EntireInterval() {
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isEntire() {
        return true;
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
        return true;
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

    @Override
    public ExtendedRational inf() {
        return null;
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
        return null;
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
        return null;
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
        return null;
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
    public String toString() {
        return null;
    }

    @Override
    public String toStringDecorated() {
        return null;
    }
}
