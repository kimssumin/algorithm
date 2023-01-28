public class Main {
    
    static char board[][];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int tot = 1 + 4*(n-1);
        board = new char[tot][tot];
        
        for(int i=0; i<tot; i++) {
            for(int j=0; j<tot; j++) {
                board[i][j] = ' ';
            }
        }
        
        star(0, tot);
        
        for(int i=0; i<tot; i++) {
            for(int j=0; j<tot; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    
    private static void star(int s, int tot) {
        for(int i=s; i<tot; i++) {
            board[s][i] = '*'; 
            board[tot-1][i] = '*'; 
            board[i][s] = '*';
            board[i][tot-1] = '*';
        }
        
        if(tot == 1) return;
        
        star(s+2, tot-2);
    }
}