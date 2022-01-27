package timingtest;
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

    public static void timeAListConstructionAList() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        int N = 1000;
        for (int i = 0; i < 8; i++) {
            Ns.addLast(N);
            opCounts.addLast(N);
            AList<Integer> t = new AList<>();
            long startTime = System.nanoTime();
            for (int j = 0; j < N; j++) {
                t.addLast(j);
            }
            long endTime = System.nanoTime();
            times.addLast((endTime - startTime) / 1e9);

            N *= 2;
        }
        printTimingTable(Ns, times, opCounts);
    }

    public static void timeAListConstruction() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        int N = 1000;
        int M = 10000;
        for (int i = 0; i < 8; i++) {
            Ns.addLast(N);
            opCounts.addLast(M);
            SLList<Integer> t = new SLList<>();
            for (int j = 0; j < N; j++) {
                t.addLast(j);
            }

            long startTime = System.nanoTime();
            for (int j = 0; j < M; j++) {
                t.getLast();
            }
            long endTime = System.nanoTime();
            times.addLast((endTime - startTime) / 1e9);

            N *= 2;
        }
        printTimingTable(Ns, times, opCounts);
    }

}