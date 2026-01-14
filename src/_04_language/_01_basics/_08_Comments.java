/*
 * Java Comments
 * - This document explains the types of comments in Java, their purpose, usage, and conventions.
 *
 * Inline Comments (Single-line)
 * - Syntax: // ...
 * - Used to add short explanations or notes next to a line of code.
 * - Useful for brief clarifications, disabling code temporarily, or marking TODOs.
 *
 * Multiline Comments (Block)
 * - Syntax: /* ...
 * - Can span multiple lines.
 * - Used for longer explanations, code documentation, or temporarily commenting out blocks of code.
 *
 Section Comments
 * - Syntax:
 *   - //===============================================================================================================
 *   - // Title
 *   - //===============================================================================================================
 * - Used to divide code in sections.
 *
 * Javadoc Comments
 * - Syntax: /** ...
 * - Special type of multiline comment used to generate API documentation.
 * - Placed above classes, methods, or fields.
 * - Supports tags like @param, @return, @throws for structured documentation.
 *
 * Markdown Comments
 * - Syntax: /// ...
 * - Special type of multiline comment used to generate API documentation using Markdown.
 * - Developers can write headings, bullet points, code blocks, and emphasis directly in Markdown.
 * - Supports tags like @param, @return, @throws for structured documentation.
 *
 * Best Practices
 * - Use inline comments for short clarifications.
 * - Use multiline comments for detailed explanations or temporarily disabling code.
 * - Use Javadoc or Markdown comments to document APIs and important classes/methods.
 * - Keep comments meaningful, concise, and up-to-date to avoid misleading information.
 * - Avoid over-commenting obvious code; focus on explaining "why" rather than "what".
 */
void main() {}
// Inline Comment

/*
 * Multiline Comment
 */

//======================================================================================================================
// Section Comment
//======================================================================================================================

/**
 * Javadoc Comment
 * Sum two numbers (x + y)
 * @param x The first number
 * @param y The second number
 * @return Sum of x and y
 */
public int sum(int x, int y) {
    return x + y;
}

/// # Markdown Comment
/// Subtract Two Numbers (x - y)
/// @param x the first number
/// @param y the second number
/// @return Sum of x and y
public int sub(int x, int y) {
    return x - y;
}