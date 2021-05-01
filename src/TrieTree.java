import java.util.*;

/**
 * @author: wangpeilei
 * @date: 2021/05/01 17:21
 **/
public class TrieTree {

    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        trieTree.addWord("hello");
        trieTree.addWord("hi");
        trieTree.addWord("hell");
        trieTree.addWord("helll");

        boolean hi = trieTree.hasWord("hi");

        boolean hello = trieTree.hasWord("hello");

        List<String> list = trieTree.allList();

        List<String> match = trieTree.getMatchStr("he");

        System.out.println(list);

        System.out.println(match);

        boolean hel = trieTree.deleteWord("hel");

        boolean hell = trieTree.deleteWord("helll");

        List<String> list1 = trieTree.allList();
        System.out.println(1);
    }

    private TrieNode rootNode = new TrieNode();

    private static class TrieNode {

        private TrieNode preNode;

        private boolean end;

        private char content;

        private Set<TrieNode> childSet = new HashSet<>();

        TrieNode() {
        }

        TrieNode(char content) {
            this.content = content;
        }

        public void setPreNode(TrieNode preNode) {
            this.preNode = preNode;
        }

        public TrieNode getPreNode() {
            return preNode;
        }

        void removeChild(TrieNode trieNode) {
            childSet.remove(trieNode);
        }

        TrieNode getChild(TrieNode trieNode) {
            for (TrieNode node : childSet) {
                if (node.content == trieNode.content) {
                    return node;
                }
            }

            return null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TrieNode trieNode = (TrieNode) o;
            return content == trieNode.content;
        }

        @Override
        public int hashCode() {
            return Objects.hash(content);
        }
    }

    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        char[] chars = word.toCharArray();

        TrieNode curNode = rootNode;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            TrieNode trieNode = new TrieNode(c);
            if (curNode.childSet.contains(trieNode)) {
                curNode = curNode.getChild(trieNode);
            } else {
                curNode.childSet.add(trieNode);
                trieNode.setPreNode(curNode);
                curNode = trieNode;
            }

            if (i == chars.length - 1) {
                curNode.end = true;
            }
        }
    }

    public boolean hasWord(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        char[] chars = word.toCharArray();

        TrieNode curNode = rootNode;

        for (int i = 0; i < chars.length; i++) {
            TrieNode trieNode = new TrieNode(chars[i]);

            if (curNode.childSet.contains(trieNode)) {
                curNode = curNode.getChild(trieNode);
            } else {
                return false;
            }

            if (i == chars.length - 1) {
                return curNode.end;
            }
        }

        return true;
    }

    public boolean deleteWord(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        char[] chars = word.toCharArray();

        TrieNode curNode = rootNode;
        for (int i = 0; i < chars.length; i++) {
            TrieNode trieNode = new TrieNode(chars[i]);

            if (curNode.childSet.contains(trieNode)) {
                curNode = curNode.getChild(trieNode);
            } else {
                return false;
            }

            if (i == chars.length - 1) {
                if (!curNode.end) { // 不是结尾字符，表示当前字符串不存在
                    return false;
                }

                if (curNode.childSet.size() != 0) { // 后面还有
                    curNode.end = false;
                    return true;
                }

                // 需要将当前字符以及之前不是结尾字符的字符都清掉。
                TrieNode preNode = curNode.getPreNode();
                while (preNode != null && !preNode.end) {
                    preNode.removeChild(curNode);
                    curNode = preNode;
                    preNode = preNode.preNode;
                }
                if (preNode != null) {
                    preNode.removeChild(curNode);
                }
                return true;
            }
        }

        return false;

    }

    public List<String> allList() {
        List<String> resultList = new ArrayList<>();

        dfs(resultList, rootNode, new StringBuilder(), "");

        return resultList;
    }

    private void dfs(List<String> resultList, TrieNode trieNode, StringBuilder sb, String prefix) {
        if (trieNode.end) {
            resultList.add(prefix + sb.toString());
        }

        if (trieNode.childSet.size() == 0) {
            return;
        }

        for (TrieNode node : trieNode.childSet) {
            sb.append(node.content);
            dfs(resultList, node, sb, prefix);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> getMatchStr(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        List<String> resultList = new ArrayList<>();
        char[] chars = str.toCharArray();

        TrieNode curNode = rootNode;

        for (int i = 0; i < chars.length; i++) {
            TrieNode node = new TrieNode(chars[i]);

            if (curNode.childSet.contains(node)) {
                curNode = curNode.getChild(node);
            } else {
                return null;
            }
        }

        dfs(resultList, curNode, new StringBuilder(), str);

        return resultList;
    }
}
