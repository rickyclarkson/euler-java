import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Primes {
  static Iterable<Integer> primes = new Iterable<Integer>() {
    public Iterator<Integer> iterator() {
      return new Iterator<Integer>() {
        int i = 0;
        public Integer next() {
          outer:
          while (true) {
            i++;
            for (int a = 2; a < Math.min(i, Math.sqrt(i) + 1); a++)
	      if (i % a == 0)
	        continue outer;
	    
	    return i;
	  }	        
        }

        public boolean hasNext() {
          return true;
        }

	public void remove() {
	  throw new UnsupportedOperationException();
	}
      };
    }
  };

  static <T> Iterable<T> primes(final Num<T> num) {
    return new Iterable<T>() {
      public Iterator<T> iterator() {
        return new Iterator<T>() {
          T i = num.zero();
  	  public T next() {
	    outer:
	    while (true) {
	      i = num.increment(i);
	      for (T a = num.fromInt(2); num.lessThan(a, num.min(i, num.add(num.sqrt(i), num.fromInt(1)))); a = num.increment(a))
	        if (num.eq(num.modulo(i, a), num.zero()))
	          continue outer;

	      return i;
	    }
	  }

	  public boolean hasNext() {
	    return true;
	  }

	  public void remove() {
	    throw new UnsupportedOperationException();
	  }
        };
      }
    };
  }

  static List<Integer> factors(int x) {
    TreeSet<Integer> result = new TreeSet<Integer>();
    int sqrt = (int)Math.sqrt(x) + 1;
    for (int a = 1; a <= sqrt; a++)
      if (x % a == 0) {
        result.add(a);
	result.add(x / a);
      }
    return new ArrayList<Integer>(result);
  }

  static List<Integer> properDivisors(int x) {
    List<Integer> result = factors(x);
    return result.subList(0, result.size() - 1);
  }

  static Iterable<Integer> perfectNumbers() {
    return new Iterable<Integer>() {
      public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
          int i = 1;
          public boolean hasNext() {
            return true;
          }

          public Integer next() {
            for (;;) {
	      int sum = Iterables.sum(Monoid.intPlus, properDivisors(i));
              if (sum == i)
	        return i++;
	      i++;
	    }
          }

          public void remove() {
            throw new UnsupportedOperationException();
          }
	};
      }
    };
  }

  static final Iterable<Integer> positiveIntegers = new Iterable<Integer>() {
    public Iterator<Integer> iterator() {
      return new Iterator<Integer>() {
        int x = 1;
        public boolean hasNext() {
          return x < Integer.MAX_VALUE - 1;
        }

        public Integer next() {
          return x++;
        }

        public void remove() {
          throw new UnsupportedOperationException();
        }
      };
    }
  };
  
  static final Iterable<Integer> abundantNumbers(Iterable<Integer> numbers) {
    return Iterables.filter(numbers, new F<Integer, Boolean>() {
      public Boolean f(Integer x) {
        return Iterables.sum(Monoid.intPlus, properDivisors(x)) > x;
      }
    });
  }

  static final Iterable<Integer> range(final int from, final int toExclusive) {
    return new Iterable<Integer>() {
      public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
	  int i = from - 1;
	  public boolean hasNext() {
	    return i < toExclusive - 1;
	  }

	  public Integer next() {
	    return i++;
	  }

	  public void remove() {
	    throw new UnsupportedOperationException();
	  }
	};
      }
    };
  }
}
