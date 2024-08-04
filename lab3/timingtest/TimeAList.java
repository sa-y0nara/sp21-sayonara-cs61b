package timingtest;

import jh61b.junit.In;
//import ucb.util.Stopwatch;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    private static double test(int j,AList<Integer> test) {
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < j; i++) {
            test.addLast(i);
        }
        return sw.elapsedTime();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> time = new AList<>();
        int a = 1000;
        for (int i = 0; i < 15; i++) {
            AList<Integer> test = new AList<>();
            time.addLast(test(a,test));
            Ns.addLast(a);
            a *= 2;
        }
        printTimingTable(Ns,time,Ns);
    }
}
