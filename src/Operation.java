import java.io.Serializable;

public class Operation implements Serializable {
    private static final long serialVersionUID = 1L;

    public int a;
    public int b;
    public char operator;

    public Operation(int a, int b, char operator) {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }
}