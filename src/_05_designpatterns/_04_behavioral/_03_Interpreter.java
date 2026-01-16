/*
 * Interpreter Design Pattern
 * - This section explains the "Interpreter" design pattern, which defines a representation for a language’s grammar
 *   and provides an interpreter to evaluate sentences in that language.
 *
 * Overview
 * - The Interpreter pattern is a behavioral design pattern.
 * - It is used to define a grammar for a simple language and interpret expressions written in that language.
 * - Each rule of the grammar is represented by a class.
 * - Commonly used for domain-specific languages (DSLs), expression evaluation, and rule engines.
 *
 * Key Elements
 * - AbstractExpression: declares an interface for interpreting expressions.
 * - TerminalExpression: implements interpretation for terminal symbols in the grammar.
 * - NonTerminalExpression: implements interpretation for non-terminal grammar rules and composes other expressions.
 * - Context: contains global information needed during interpretation.
 * - Client: builds the abstract syntax tree (AST) and triggers interpretation.
 *
 * Key Characteristics
 * - Represents grammar rules as class hierarchies.
 * - Uses composition to model complex expressions.
 * - Interpretation is done recursively by traversing the expression tree.
 * - Easy to extend the grammar by adding new expression classes.
 * - Can become complex and inefficient for large or complex grammars.
 *
 * Usage
 * - Use Interpreter when you need to evaluate expressions in a simple, well-defined grammar.
 * - Suitable for implementing small DSLs, filters, validation rules, or expression parsers.
 * - Avoid for complex languages where parser generators or other tools are more appropriate.
 * - Common in configuration rules, search filters, and mathematical expression evaluation.
 */

/*
 * AbstractExpression
 * - Declares an interface for interpreting expressions.
 */
public interface Expression {
    int evaluate(Context context);
}

/*
 * TerminalExpression
 * - Implements interpretation for terminal symbols in the grammar.
 */
public static class NumberExpression implements Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int evaluate(Context context) {
        return number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
public static class VariableExpression implements Expression {
    private String name;

    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public int evaluate(Context context) {
        return context.getVariable(this.name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}

/*
 * NonTerminalExpression
 * - Implements interpretation for non-terminal grammar rules and composes other expressions.
 */
public static class AddExpression implements Expression {
    private Expression x;
    private Expression y;

    public AddExpression(Expression x, Expression y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int evaluate(Context context) {
        return x.evaluate(context) + y.evaluate(context);
    }

    @Override
    public String toString() {
        return String.format("(%s + %s)", x, y);
    }
}
public static class SubExpression implements Expression {
    private Expression x;
    private Expression y;

    public SubExpression(Expression x, Expression y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int evaluate(Context context) {
        return x.evaluate(context) - y.evaluate(context);
    }

    @Override
    public String toString() {
        return String.format("(%s - %s)", x, y);
    }
}

/*
 * Context
 * - Contains global information needed during interpretation.
 */
public class Context {
    private Map<String, Integer> variables = new HashMap<>();

    public void setVariable(String name, int value) {
        variables.put(name, value);
    }

    public int getVariable(String name) {
        return variables.get(name);
    }
}

/*
 * Client
 * - Builds the abstract syntax tree (AST) and triggers interpretation.
 */
public class ExpressionEvaluator {
    private Expression expression;

    public ExpressionEvaluator(int number) {
        this.expression = new NumberExpression(number);
    }

    public ExpressionEvaluator plus(Expression expression) {
        this.expression = new AddExpression(this.expression, expression);
        return this;
    }

    public ExpressionEvaluator plus(int number) {
        expression = new AddExpression(expression, new NumberExpression(number));
        return this;
    }

    public ExpressionEvaluator plusVar(String name) {
        expression = new AddExpression(expression, new VariableExpression(name));
        return this;
    }

    public ExpressionEvaluator minus(Expression expression) {
        this.expression = new SubExpression(this.expression, expression);
        return this;
    }

    public ExpressionEvaluator minus(int number) {
        expression = new SubExpression(expression, new NumberExpression(number));
        return this;
    }

    public ExpressionEvaluator minusVar(String name) {
        expression = new SubExpression(expression, new VariableExpression(name));
        return this;
    }

    public Expression expression() {
        return expression;
    }

    public int evaluate(Context context) {
        return this.expression.evaluate(context);
    }

    @Override
    public String toString() {
        return expression.toString();
    }
}

/*
 * Example
 * - The example below shows the usage of the Interpreter design pattern.
 */
void main() {
    ExpressionEvaluator expression = new ExpressionEvaluator(5)
            .plus(3)
            .plusVar("x")
            .plus(new ExpressionEvaluator(4)
                    .plus(7)
                    .minusVar("y")
                    .plus(new ExpressionEvaluator(2)
                            .plus(3)
                            .minus(4)
                            .plusVar("x")
                            .expression()
                    )
                    .plus(12)
                    .expression()
            );

    Context context = new Context();
    context.setVariable("x", 3);
    context.setVariable("y", 6);

    IO.println(expression); // Output: (((5 + 3) + x) + ((((4 + 7) - y) + (((2 + 3) - 4) + x)) + 12))
    IO.println(expression.evaluate(context)); // Result: 32
}