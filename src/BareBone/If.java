package BareBone;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class If implements Statement
{
	public static final String name         = "if";
	public static final String regexPattern = "if\\s*([a-zA-Z0-9]*)\\s(\\<|\\>|\\=\\>|\\<\\=])\\s([a-zA-Z0-9]*)\\s*";

	private Variable variable;
	private Scope scope;

	// it should probably be moved to constructor (or maybe not because execute is from interface ?)
	public void execute(String code, Scope scope, boolean skip)
	{
		this.scope = scope;

		Matcher matcher = Pattern.compile(regexPattern).matcher(code);

		while (matcher.find())
		{
			BigInteger variable1 = parseVariable(matcher.group(1));
			BigInteger variable2 = parseVariable(matcher.group(3));

			String comparator = matcher.group(2);

			int compare = variable1.compareTo(variable2);
			boolean satisfied = false;

			switch (comparator)
			{
				case "==":
					if (compare == 0) satisfied = true;
					break;
				case "!=":
					if (compare != 0) satisfied = true;
					break;
				case ">=":
					if (compare == 1 || compare == 0) satisfied = true;
					break;
				case "<=":
					if (compare == -1 || compare == 0) satisfied = true;
					break;
				case ">":
					if (compare == 1) satisfied = true;
					break;
				case "<":
					if (compare == -1) satisfied = true;
					break;
			}

			try
			{
				scope.index++;
				Scope childScope = new Scope(scope);
				scope.index = childScope.execute(!satisfied || skip);
			}
			catch (Exception e) {}

		}
	}

	private BigInteger parseVariable(String variable)
	{
		System.out.println(variable);
		try
		{
			return new BigInteger(variable);
		}
		catch(NumberFormatException e)
		{
			if (variable.matches("[a-zA-Z]"))
			{
				return scope.getVariable(variable).getValue();
			}
			else
			{
				return BigInteger.ZERO; // TODO
			}
		}
	}
}
