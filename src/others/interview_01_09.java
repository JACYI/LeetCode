package others;

public class interview_01_09 {
    public boolean isFlipedString(String s1, String s2) {
        return s1 != s2 && (s1 + s1).contains(s2);
    }
}
