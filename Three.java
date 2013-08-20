/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
*/

import java.util.Iterator;
import java.util.NoSuchElementException;

class Three {
  public static void main(String[] args) {
    System.out.println(last(primeFactors(600851475143L)));
  }

  static Iterable<Long> primeFactors(final long number) {
    return filter(Primes.takeWhile(Primes.primes, new F<Long, Boolean>() {
      public Boolean f(Long x) {
        return x <= Math.sqrt(number) + 1;
      }
    }), new F<Long, Boolean>() {
      public Boolean f(Long x) {
        return number % x == 0;
      }
    });
  }

  static <T> Iterable<T> filter(final Iterable<T> iterable, final F<T, Boolean> predicate) {
    return new Iterable<T>() {
      public Iterator<T> iterator() {
        return new Iterator<T>() {
	  Iterator<T> wrapped = iterable.iterator();
	  T next;
	  {
	    while (wrapped.hasNext()) {
	      T t = wrapped.next();
	      if (predicate.f(t)) {
	        next = t;
		break;
	      }
	    }
	  }

	  public T next() {
	    if (next == null)
	      throw new NoSuchElementException();
	    try {
	      return next;
	    } finally {
	      next = null;
	      while (wrapped.hasNext()) {
	        T t = wrapped.next();
	        if (predicate.f(t)) {
		  next = t;
		  break;
		}
              }
            }
	  }

	  public boolean hasNext() {
	    return next != null;
	  }

	  public void remove() {
	    throw new UnsupportedOperationException();
	  }
	};
      }
    };
  }

  static <T> T last(Iterable<T> iterable) {
    T last = null;
    for (T t: iterable)
      last = t;
    if (last == null)
      throw new IllegalArgumentException("0-length iterable.");
    return last;
  }
}
