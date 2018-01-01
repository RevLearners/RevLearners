package io.revlearners.model.bo;

public class MPair<K, V> {
    K first;
    V second;

    public MPair() {}

    public MPair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public void setFirst(K first) {
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "MPair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
