class Solution {
    public String FirstNonRepeating(String A) {
        int[] charCount = new int[26];
        Queue<Character> order = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (char c : A.toCharArray()) {
            int index = c - 'a';
            charCount[index]++;
            order.add(c);

            while (!order.isEmpty() && charCount[order.peek() - 'a'] > 1) {
                order.poll();
            }

            if (order.isEmpty()) {
                result.append('#');
            } else {
                result.append(order.peek());
            }
        }

        return result.toString();
    }
}
