

/**
 *
 * @author phillip
 */
public class RC4 {
    private int[] s = new int[256];
    private int i = 0;
    private int j = 0;
    
    public static void main(String[] args) {
        int[] key = new int[40];
        for (int i = 0; i < key.length; i++) {
            key[i] = i;//+27 % key.length;
        }
        
        RC4 rc4 = new RC4(key);
        for (int i = 0; i < 100; i++) {
            System.out.println(rc4.next());
        }
    }
    public RC4(int[] key) {
        for (int i = 0; i < 256; i++) {
            s[i] = i;
        }
        for (int i = 0; i < 256; i++) {
            j = (j + s[i] + key[i % key.length]) % 256;
            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        i = 0;
        j = 0;
        
        
    }
    
    public int next() {
        i = (i + 1) % 256;
        j = (j + s[i]) % 256;
        int temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        int k = s[(s[i] + s[j]) % 256];
        return k;
    }
    
}
