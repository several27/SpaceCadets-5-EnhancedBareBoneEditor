package Editor;

public class CodeSamples
{
	public static final String simpleLoop = "clear X;\n" +
	                                        "incr X;\n" +
	                                        "incr X;\n" +
	                                        "incr X;\n" +
	                                        "while X not 0 do;\n" +
	                                        "\tdecr X;\n" +
	                                        "end;";

	public static final String multiplyXTimesY = "clear X;\n" +
	                                            "incr X;\n" +
	                                            "incr X;\n" +
	                                            "clear Y;\n" +
	                                            "incr Y;\n" +
	                                            "incr Y;\n" +
	                                            "incr Y;\n" +
	                                            "clear Z;\n" +
	                                            "while X not 0 do;\n" +
	                                            "\tclear W;\n" +
	                                            "\twhile Y not 0 do;\n" +
	                                            "\t\tincr Z;\n" +
	                                            "\t\tincr W;\n" +
	                                            "\t\tdecr Y;\n" +
	                                            "\tend;\n" +
	                                            "\twhile W not 0 do;\n" +
	                                            "\t\tincr Y;\n" +
	                                            "\t\tdecr W;\n" +
	                                            "\tend;\n" +
	                                            "\tdecr X;\n" +
	                                            "end;";

	public static final String simpleIf = "incr X;\n" +
	                                      "incr X;\n" +
	                                      "incr X;\n" +
	                                      "if X > 10;\n" +
	                                      "\tclear X;\n" +
	                                      "\tend;";

	public static final String nthFibonacciNumber = "incr N;\n" +
	                                                "incr N;\n" +
	                                                "incr N;\n" +
	                                                "incr N;\n" +
	                                                "incr N;\n" +
	                                                "incr N;\n" +
	                                                "incr N;\n" +
	                                                "\n" +
	                                                "clear F;\n" +
	                                                "clear G;\n" +
	                                                "incr G;\n" +
	                                                "\n" +
	                                                "while N not 0 do;\n" +
	                                                "  copy G to H;\n" +
	                                                "  while F not 0 do;\n" +
	                                                "    incr H;\n" +
	                                                "    decr F;\n" +
	                                                "  end;\n" +
	                                                "\n" +
	                                                "  copy G to F;\n" +
	                                                "  copy H to G;\n" +
	                                                "\n" +
	                                                "  decr N;\n" +
	                                                "end;\n" +
	                                                "\n" +
	                                                "H is fibonacci number\n" +
	                                                "by default N = 7, H = 21";
}
