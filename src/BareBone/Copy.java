package BareBone;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Copy implements Statement
{
	public static final String name         = "copy";
	public static final String regexPattern = "copy\\s*([a-zA-z]*)\\s*to\\s*([a-zA-z]*)";

	@Override
	public void execute(String code, Scope scope, boolean skip)
	{
		Matcher matcher = Pattern.compile(regexPattern).matcher(code);

		while (matcher.find())
		{
			if (skip) break;

			Variable variable1 = scope.getVariable(matcher.group(1));

			if (variable1 == null)
			{
				scope.updateVariable(matcher.group(1), BigInteger.ZERO);
				scope.updateVariable(matcher.group(2), BigInteger.ZERO);
			}
			else
			{
				scope.updateVariable(matcher.group(2), variable1.getValue());
			}

			Debug.addMessage(matcher.group(1) + " (" + (variable1 == null ? 0 : variable1.getValue()) + ") copied to " + matcher.group(2));
		}
	}
}
