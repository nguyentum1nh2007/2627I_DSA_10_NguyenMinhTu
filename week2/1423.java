public class BinarySearchFraction {

    static class Oracle {
        private final int secretP;
        private final int secretQ;

        public Oracle(int p, int q) {
            this.secretP = p;
            this.secretQ = q;
        }

        public boolean isLessThan(double x) {
            return ((double) secretP / secretQ) < x;
        }
    }

    public static void findFraction(int N, Oracle oracle) {
        double L = 0.0;
        double R = 1.0;
        double targetLength = 1.0 / (2.0 * N * N);
        int queries = 0;

        while ((R - L) > targetLength) {
            double mid = L + (R - L) / 2.0;
            queries++;
            if (oracle.isLessThan(mid)) {
                R = mid;
            } else {
                L = mid;
            }
        }

        int[] result = reconstructFraction(L, R, N);

        System.out.println("Tim thay phan so: " + result[0] + "/" + result[1]);
        System.out.println(
                "So cau hoi da dung: " + queries + " (Tối đa " + (int) (2 * Math.log(N) / Math.log(2) + 2) + ")");
    }

    private static int[] reconstructFraction(double L, double R, int N) {
        int p0 = 0, q0 = 1;
        int p1 = 1, q1 = 1;

        while (true) {
            int pm = p0 + p1;
            int qm = q0 + q1;

            if (qm >= N)
                break;

            double val = (double) pm / qm;
            if (val < L) {
                p0 = pm;
                q0 = qm;
            } else if (val > R) {
                p1 = pm;
                q1 = qm;
            } else {
                return new int[] { pm, qm };
            }
        }
        return new int[] { p0, q0 };
    }

    public static void main(String[] args) {
        int N = 10000;
        int secretP = 355;
        int secretQ = 813;

        Oracle oracle = new Oracle(secretP, secretQ);
        findFraction(N, oracle);
    }
}