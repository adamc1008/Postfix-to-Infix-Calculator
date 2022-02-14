# Postfix-to-Infix-Calculator
A java calculator that takes an infix expression e.g. 3*7 + (2+2) as string input and then outputs a postfix expression e.g 37*22++
The calculator also solves the expression and returns the answer as a double. 
4 classes are used.
ArrayStack and Stack create an array based stack.
infixToPostfix contains 3 methods. One for changing an infix expression to a postfox expression, another for solving the postfix expression and the last for calculating the precedence of an operator (Brackets.Indices.Multiplication.Division.Addition.Subtraction)
infixToPostfixTest is a test class that generates ouptut.
