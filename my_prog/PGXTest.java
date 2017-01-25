package oracle.pgx.demo;

import oracle.pgx.api.CompiledProgram;
import oracle.pgx.api.Pgx;
import oracle.pgx.api.PgxGraph;
import oracle.pgx.api.PgxSession;
import oracle.pgx.api.internal.AnalysisResult;
import java.io.*;

public class PGXTest{
	public static void main(String[] args) throws Exception{
		PgxSession session = Pgx.createSession("my-session");
		CompiledProgram hello = session.compileProgram("hello.gm");
		CompiledProgram max = session.compileProgram("adv.gm");
		PgxGraph G = session.readGraphWithProperties("graph.adj.json");
		AnalysisResult<Integer> result = max.run(G);
		AnalysisResult<Void> res = hello.run();
		System.out.println("hellores = "+res);
		System.out.println("Result = "+result.getReturnValue()+ " (took " + result.getExecutionTimeMs() + "ms)");
	}
}
