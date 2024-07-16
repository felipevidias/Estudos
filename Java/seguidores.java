import java.util.Scanner;

public class seguidores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int seguidores = sc.nextInt(); int meta = sc.nextInt(); int seguidoresNoMes = 0;
        for(int i = 0; i < 30; i++){
            seguidoresNoMes += sc.nextInt();
        }
        int dias = 0; 
        if(seguidoresNoMes % 30 == 0){
            int media = seguidoresNoMes/30;
        } else{
            media = seguidoresNoMes/30 + 1;
        }

        int segRest = meta - seguidores;
        if(segRest % media == 0){
            dias = segRest/media;
        } else{
            dias = (segRest/media) + 1;
        }
        System.out.println(dias);
        
        sc.close();
    }
}
