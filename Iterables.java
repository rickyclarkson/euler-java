import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Iterables {
  static <T> Iterable<T> takeWhile(final Iterable<T> iterable, final F<T, Boolean> f) {
    return new Iterable<T>() {
      public Iterator<T> iterator() {
	final Iterator<T> wrapped = iterable.iterator();
        return new Iterator<T>() {
	  T next;

	  {
            if (wrapped.hasNext()) {
              next = wrapped.next();
	      if (!f.f(next))
                next = null;
	    }
	  }

	  public T next() {
            if (next == null)
	      throw new NoSuchElementException();
	    try {
              return next;
	    } finally {
              next = null;
	      if (wrapped.hasNext()) {
                next = wrapped.next();
		if (!f.f(next))
                  next = null;
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

  static <T> T sum(Monoid<T> monoid, Iterable<T> iterable) {
    T result = monoid.zero;
    for (T t: iterable)
      result = monoid.sum.f(t).f(result);
    return result;
  }

  static <T> Iterable<T> drop(final int number, final Iterable<T> iterable) {
    return new Iterable<T>() {
      public Iterator<T> iterator() {
        Iterator<T> iterator = iterable.iterator();
	for (int a = 0; a < number; a++)
	  if (iterator.hasNext())
	    iterator.next();
	return iterator;
      }
    };
  }

  static <T, U> Iterable<U> map(final Iterable<T> iterable, final F<T, U> f) {
    return new Iterable<U>() {
      public Iterator<U> iterator() {
        return new Iterator<U>() {
	  final Iterator<T> original = iterable.iterator();
	  public boolean hasNext() {
	    return original.hasNext();
	  }

	  public U next() {
	    return f.f(original.next());
	  }

	  public void remove() {
	    original.remove();
	  }
	};
      }
    };
  }

  static <T> Iterable<T> filter(final Iterable<T> iterable, final F<T, Boolean> f) {
    return new Iterable<T>() {
      public Iterator<T> iterator() {
        return new Iterator<T>() {
	  Iterator<T> wrapped = iterable.iterator();
	  T next;
	  {
	    findNext();
	  }
          public boolean hasNext() {
	    return next != null;
	  }

	  public T next() {
	    if (next == null)
	      throw new NoSuchElementException();
	    try {
	      return next;
	    } finally {
	      findNext();
	    }
	  }

          public void remove() {
	    throw new UnsupportedOperationException();
	  }

	  void findNext() {
	    next = null;
	    while (wrapped.hasNext()) {
	      T wrappedNext = wrapped.next();
	      if (f.f(wrappedNext)) {
	        next = wrappedNext;
		return;
	      }
	    }
	  }
	};
      }
    };
  }

  static <T> List<T> toList(Iterable<T> iterable) {
    List<T> result = new ArrayList<T>();
    for (T t: iterable)
      result.add(t);
    return result;
  }
}
