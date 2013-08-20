import java.util.ArrayList;
import java.util.List;

class Lists {
  static <T, U> List<U> map(List<T> list, F<T, U> f) {
    List<U> result = new ArrayList<U>();
    for (T t: list)
      result.add(f.f(t));
    return result;
  }

  static <T> List<T> filter(List<T> list, F<T, Boolean> f) {
    List<T> result = new ArrayList<T>();
    for (T t: list)
      if (f.f(t))
        result.add(t);
    return result;
  }
}
