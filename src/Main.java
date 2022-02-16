import java.util.HashSet;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = kb.nextInt();
        }

        int answer = 0;
        HashSet<Integer> set = new HashSet<>();

        if (n == 1) {
            for (int i = 1; i < m; i++) {
                if (arr[i] != arr[i - 1]) {
                    answer++;
                }
            }
        } else {
            for (int i = 0; i < m; i++) {
                int num = arr[i];

                if (set.contains(num)) {
                    continue;
                }

                if (set.size() < n) {
                    set.add(num);
                    continue;
                }

                HashSet<Integer> tmp = new HashSet<>(set);
                for (int j = i + 1; j < m; j++) {
                    tmp.remove(arr[j]);

                    if (tmp.size() < 2) { // 지워야할 값 하나
                        break;
                    }
                }

                set.remove(tmp.iterator().next());
                set.add(num);
                answer++;
            }
        }

        System.out.println(answer);

    }

}
