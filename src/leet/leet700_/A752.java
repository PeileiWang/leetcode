package leet.leet700_;

import java.util.*;

/**
 * @author: wangpeilei
 * @date: 2021/04/18 10:52
 **/
public class A752 {
    public static void main(String[] args) {
        String[] deadends = new String[]{"8888"};
        String target = "0009";

        Solution solution = new Solution();
        int i = solution.openLock(deadends, target);
        System.out.println(i);

        System.out.println(solution.openLockPerf(deadends, target));

        int j = solution.openLockV2(deadends, target);
        System.out.println(j);
    }

    private static class Solution {
        public int openLock(String[] deadends, String target) {
            Queue<String> queue = new LinkedList<>();
            Set<String> visitedSet = new HashSet<>();

            Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));

            String start = "0000";

            queue.offer(start);
            visitedSet.add(start);

            int step = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    String s = queue.poll();

                    // 在死亡数字里
                    if (deadSet.contains(s)) {
                        continue;
                    }

                    // 找到目标
                    if (Objects.equals(s, target)) {
                        return step;
                    }

                    // 节点的相邻节点
                    for (int i1 = 0; i1 < 4; i1++) {
                        String closeUp = up(s, i1);
                        // 已经走过的路
                        if (visitedSet.add(closeUp)) {
                            queue.offer(closeUp);
                        }

                        String closeDown = down(s, i1);
                        if (visitedSet.add(closeDown)) {
                            queue.offer(closeDown);
                        }
                    }
                }

                step++;
            }

            return -1;
        }


        public int openLockPerf(String[] deadends, String target) {
            Set<String> queue = new HashSet<>();
            Set<String> visitedSet = new HashSet<>();

            Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));

            String start = "0000";

            queue.add(start);
            visitedSet.add(start);

            int step = 0;

            while (!queue.isEmpty()) {
                Set<String> temp = new HashSet<>();
                for (String s : queue) {
                    // 在死亡数字里
                    if (deadSet.contains(s)) {
                        continue;
                    }

                    // 找到目标
                    if (Objects.equals(s, target)) {
                        return step;
                    }

//                    visitedSet.add(s);

                    // 节点的相邻节点
                    for (int i1 = 0; i1 < 4; i1++) {
                        String closeUp = up(s, i1);
                        // 已经走过的路
                        if (!visitedSet.contains(closeUp)) {
                            visitedSet.add(closeUp);
                            temp.add(closeUp);
                        }

                        String closeDown = down(s, i1);
                        if (!visitedSet.contains(closeDown)) {
                            visitedSet.add(closeDown);
                            temp.add(closeDown);
                        }
                    }
                }

                step++;

                queue = temp;
            }

            return -1;
        }

        private String up(String str, int pos) {
            char[] chars = str.toCharArray();
            char c = chars[pos];
            if (c == '9') {
                c = '0';
            } else {
                c += 1;
            }

            chars[pos] = c;

            return new String(chars);
        }

        private String down(String str, int pos) {
            char[] chars = str.toCharArray();
            char c = chars[pos];
            if (c == '0') {
                c = '9';
            } else {
                c -= 1;
            }

            chars[pos] = c;

            return new String(chars);
        }


        public int openLockV2(String[] deadends, String target) {
            Set<String> visitedSet = new HashSet<>();

            Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));

            String start = "0000";

            Set<String> q1 = new HashSet<>();
            q1.add(start);

            Set<String> q2 = new HashSet<>();
            q2.add(target);

            int step = 0;

            while (!q1.isEmpty() && !q2.isEmpty()) {
                if (q1.size() > q2.size()) {
                    Set<String> t = q1;
                    q1 = q2;
                    q2 = t;
                }
                Set<String> temp = new HashSet<>();

                // q1扩散
                for (String s : q1) {
                    // 在死亡数字里
                    if (deadSet.contains(s)) {
                        continue;
                    }

                    // 找到目标
                    if (q2.contains(s)) {
                        return step;
                    }

                    visitedSet.add(s);

                    // 节点的相邻节点
                    for (int i1 = 0; i1 < 4; i1++) {
                        String closeUp = up(s, i1);
                        // 已经走过的路
                        if (!visitedSet.contains(closeUp)) {
                            temp.add(closeUp);
                        }

                        String closeDown = down(s, i1);
                        if (!visitedSet.contains(closeDown)) {
                            temp.add(closeDown);
                        }
                    }
                }

                step++;

                q1 = q2;
                q2 = temp;
            }

            return -1;
        }
    }
}
