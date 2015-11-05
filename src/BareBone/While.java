package BareBone;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class While implements Statement
{
	public static final String name         = "while";
	public static final String regexPattern = "while\\s*([a-zA-z]*)\\s*not\\s*0\\s*do";

	private Variable variable;

	public void execute(String code, Scope scope, boolean skip)
	{
		Matcher matcher = Pattern.compile(regexPattern).matcher(code);

		while (matcher.find())
		{
			variable = scope.getVariable(matcher.group(1));

			if (variable == null)
			{
				scope.updateVariable(matcher.group(1), BigInteger.ZERO);
				variable = scope.getVariable(matcher.group(1));
			}

			try
			{
				scope.index++;

				int startLine = scope.index, endLine;
				Scope childScope = new Scope(scope);

				if (skip || variable.getValue().equals(BigInteger.ZERO))
				{
					endLine = childScope.execute(true);
				}
				else
				{
					endLine = childScope.execute();

					while (!variable.getValue().equals(BigInteger.ZERO))
					{
						childScope.index = startLine;
						endLine = childScope.execute();

						if (endLine == startLine)
							break;
					}
				}

				scope.index = endLine;
			}
			catch (Exception e) {}
		}
	}
}
