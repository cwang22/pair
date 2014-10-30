package me.seewang.util;

import java.io.Serializable;

/**
 * util pair class
 * @author C
 * @param <F>
 * @param <S>
 */
public class Pair<F, S> implements Serializable, Comparable<Pair<F, S>> {

  private static final long serialVersionUID = 1L;

  F first;
  S second;

  public F getFirst() {
    return first;
  }

  public void setFirst(F first) {
    this.first = first;
  }

  public S getSecond() {
    return second;
  }

  public void setSecond(S second) {
    this.second = second;
  }

  /**
   * private constructor. Should not be called outside of the class. Use
   * Pair.of() instead.
   * 
   * @param first
   *          first object of pair
   * @param second
   *          second object of pair
   */
  private Pair(F first, S second) {
    this.first = first;
    this.second = second;
  }

  /**
   * construct a Pair object
   * 
   * @param first
   *          first object of pair
   * @param second
   *          second object of pair
   * @return a Pair object
   */
  public static <F, S> Pair<F, S> of(F first, S second) {
    return new Pair<F, S>(first, second);
  }

  @Override
  public String toString() {
    return String.format("Pair[%s,%s]", first, second);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((first == null) ? 0 : first.hashCode());
    result = prime * result + ((second == null) ? 0 : second.hashCode());
    return result;
  }

  @SuppressWarnings("rawtypes")
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Pair other = (Pair) obj;
    if (first == null) {
      if (other.first != null)
        return false;
    } else if (!first.equals(other.first))
      return false;
    if (second == null) {
      if (other.second != null)
        return false;
    } else if (!second.equals(other.second))
      return false;
    return true;
  }

  @Override
  public int compareTo(Pair<F, S> o) {
    int c = compare(first, o.first);
    return c == 0 ? compare(second, o.second) : c;
  }

  @SuppressWarnings("unchecked")
  /***
   * compare function to implement <code>compareTo</code>
   * change between <code>compare(Object s, Object f)</code> and <code>compare(Object f, Object s)</code> to switch between  Ascending sort and Descending sort 
   * @param s second object
   * @param f first object
   * @return 0 if f==s or both f and s is null
   * @return 1 if f>s
   * @return -1 if f<s
   */
  private int compare(Object s, Object f) {
    return f == null ? s == null ? 0 : -1 : s == null ? +1
        : ((Comparable<Object>) f).compareTo(s);
  }

}
