package BareBone;

/**
 * incr V;                  V = 1
 * incr S;                  S = 1
 *
 * func funcName(V, S);
 *     incr V;              V = 2
 *     incr V;              V = 3
 *     decr S;              S = 0
 * end;
 *                          V = 3, S = 0
 *
 *                          Variables are passed by reference
 *                          function cannot return
 */
public class Function implements Statement
{
	public static final String name         = "func";
	public static final String regexPattern = "func\\s*\\(([a-zA-z],\\s*)*)"; // \s*([a-zA-z]*)\s*not\s*0\s*do

	@Override
	public void execute(String code, Scope scope, boolean skip)
	{

	}
}
