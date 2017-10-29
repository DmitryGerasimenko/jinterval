package net.java.jinterval.interval.affine.impl;

import net.java.jinterval.interval.affine.interfaces.NoiseSymbol;

public class NoiseSymbolImpl implements NoiseSymbol {
    private final String symbolName;

    public NoiseSymbolImpl(String symbolName) {
        this.symbolName = symbolName;
    }

    @Override
    public String getSymbolName() {
        return this.symbolName;
    }

    @Override
    public int hashCode() {
        return this.symbolName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        NoiseSymbolImpl noiseSymbol = (NoiseSymbolImpl) obj;
        return (this.symbolName.equals(noiseSymbol.symbolName));
    }
}
