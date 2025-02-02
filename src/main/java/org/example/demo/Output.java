package org.example.demo;

public class Output {
    private int s1;
    private int s2;
    private int p2;

    public int getS1() {
        return s1;
    }

    public int getS2() {
        return s2;
    }

    public int getP2() {
        return p2;
    }

    public void setS1(int s1) {
        this.s1 = s1;
    }

    public void setS2(int s2) {
        this.s2 = s2;
    }

    public void setP2(int p2) {
        this.p2 = p2;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Output output = (Output) obj;
        return s1 == output.s1 && s2 == output.s2 && p2 == output.p2;
    }
}
