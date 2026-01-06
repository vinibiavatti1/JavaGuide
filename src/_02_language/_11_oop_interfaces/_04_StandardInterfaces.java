/*

*/
void main() {}

/*
Appendable
*/
public class A implements Appendable {
    @Override
    public Appendable append(CharSequence csq) throws IOException {
        return null;
    }

    @Override
    public Appendable append(CharSequence csq, int start, int end) throws IOException {
        return null;
    }

    @Override
    public Appendable append(char c) throws IOException {
        return null;
    }
}

/*
AutoCloseable
*/
public class B implements AutoCloseable {
    @Override
    public void close() throws Exception {

    }
}

/*
CharSequence
*/
public class C implements CharSequence {
    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}

/*
Comparable
*/
public class D implements Comparable<D> {
    @Override
    public int compareTo(D o) {
        return 0;
    }
}

/*
Iterable
*/
public class E implements Iterable<E> {
    @Override
    public Iterator<E> iterator() {
        return null;
    }
}

/*
Readable
*/
public class F implements Readable {
    @Override
    public int read(CharBuffer cb) throws IOException {
        return 0;
    }
}

/*
Runnable
*/
public class G implements Runnable {
    @Override
    public void run() {

    }
}