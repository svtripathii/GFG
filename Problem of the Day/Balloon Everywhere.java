class Solution {
    public int maxInstance(String s) {
        // Code here
        int[] fre = new int[26];
        for(int i=0;i<s.length();i++) {
            fre[s.charAt(i)-'a']++;
        }
        int m1=s.length(),m2=s.length();
        for(int i=0;i<26;i++) {
            if(i==0 || i==1 || i==13) {
                m1=Math.min(m1,fre[i]);
            } else if(i==14 || i==11) {
                m2=Math.min(m2,fre[i]);
            }
        }
        return Math.min(m1,m2/2);
    }
}