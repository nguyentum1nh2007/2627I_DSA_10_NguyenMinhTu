public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    if (!scanner.hasNextInt()) return;

    int Q = scanner.nextInt();
    StringBuilder S = new StringBuilder();
    Stack<String> history = new Stack<>();

    for (int i = 0; i < Q; i++) {
        int type = scanner.nextInt();

        switch (type) {
            case 1:
                String W = scanner.next();
                history.push(S.toString());
                S.append(W);
                break;

            case 2:
                int kDelete = scanner.nextInt();
                history.push(S.toString());
                S.delete(S.length() - kDelete, S.length());
                break;

            case 3:
                int kPrint = scanner.nextInt();
                System.out.println(S.charAt(kPrint - 1));
                break;

            case 4:
                if (!history.isEmpty()) {
                    S = new StringBuilder(history.pop());
                }
                break;
        }
    }
    scanner.close();
}