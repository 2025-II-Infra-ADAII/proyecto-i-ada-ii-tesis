package edu.univalle.riegooptimo.modelo;

public class Tablon 
{

    private final int ts_i;
    private final int rReg;
    private final int prio;

    /*
    @Param ts_i : Dias maximos sin riego
    @Param rReg : Dias necesarios para regar
    @Param prio : Prioridad del tablon (1-4)
    */
    public Tablon(int ts_i, int rReg, int prio) {
        this.ts_i = ts_i;
        this.rReg = rReg;
        this.prio = prio;
    }

    public int getTs_i() {
        return ts_i;
    }

    public int getrReg() {
        return rReg;
    }

    public int getPrio() {
        return prio;
    }

    public double ratioPrio()
    {
        return (double) prio / rReg;

    }

    public double urgencia()
    {
        return (double) ts_i / rReg;
    }

    @Override
    public String toString() {
        return String.format("Tablon{ts_i=%d, rReg=%d, prio=%d}", ts_i, rReg, prio);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tablon tablon = (Tablon) obj;
        return ts_i == tablon.ts_i && 
        rReg == tablon.rReg && 
        prio == tablon.prio;
    }
}