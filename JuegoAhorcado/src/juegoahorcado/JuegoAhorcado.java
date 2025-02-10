package JuegoAhorcado;
import java.util.Random;
import java.util.Scanner;
public class JuegoAhorcado{
    public static Scanner datos=new Scanner(System.in);
    public static void menu(){
        // el mensaje de bienvenida y el menu de opciones
        System.out.println("***************************************");
        System.out.println("El AHORCADO            DE         1*DAW");
        System.out.println("***************************************");
        System.out.println("Las palabras son del campo de la informatica y están en inglés.");
        System.out.println("Opción1: Jugar a solas");
        System.out.println("Opción2: Jugar a tres");
        System.out.println("Opción3: Salir");
    }
    public static void dibujo1(){
        //esto dibuja una horca 
        System.out.println("       _________");
        System.out.println("     //        |");
        System.out.println("    //          ");
        System.out.println("   //           ");
        System.out.println("  //            ");
    }  
    public static void dibujo2(){
        System.out.println("       _________");
        System.out.println("     //        |");
        System.out.println("    //         O");
        System.out.println("   //           ");
        System.out.println("  //            ");
    } 
    public static void dibujo3(){
        System.out.println("       _________");
        System.out.println("     //        |");
        System.out.println("    //         O");
        System.out.println("   //          |");
        System.out.println("  //            ");
    }
    public static void dibujo4(){  
        System.out.println("       _________");
        System.out.println("     //        |");
        System.out.println("    //         O");
        System.out.println("   //         -|");
        System.out.println("  //            ");
    }
    public static void dibujo5(){   
      System.out.println("       _________");
      System.out.println("     //        |");
      System.out.println("    //         O");
      System.out.println("   //         -|-");
      System.out.println("  //             ");
    }
     public static void dibujo6(){ 
        System.out.println("       _________");
        System.out.println("     //        |");
        System.out.println("    //         O");
        System.out.println("   //         -|-");
        System.out.println("  //          / ");
    }
    public static void dibujo7(){
        System.out.println("       _________");
        System.out.println("     //        |");
        System.out.println("    //         O");
        System.out.println("   //         -|-");
        System.out.println("  //          / \\");
    }  
    public static String dameUnaPalabra(){
        //esta función guarda las palabras en un String y devuelve una al azar
        String[] palabras={"developer","download","network","password","domain","software","wireless","scanner","browser","backup"};
        //la funcion Random saca una de las palabras 
        Random r=new Random();
        int n=r.nextInt(palabras.length);
        String palabraSecreta=palabras[n];
           return palabras[n];
    }
    public static char [] palabraSecretaTapada(String palabras){
        //cogemos el tamaño de la palabra random y le sacamos el tamaño
        //que sera igual que la longitud del String palabras
        int letrasPalabraSecreta=palabras.length();
        //pasamos el String a char 
        char [] palabraSecreta=new char[letrasPalabraSecreta]; 
        for(int i=0;i<palabraSecreta.length;i++){
            palabraSecreta[i]='?';
        }
        //retorno la palabra como char tapada con caracteres para ocultarla
        return palabraSecreta;
    }
    public static void jugar(){
        char[] intentos=new char[100];
        int letrasCorrectas=0;
        int letrasIncorrectas=0;
        dibujo1();
        //llamo los metodos y los guardo en variables
        String palabraSecreta=dameUnaPalabra(); 
        char [] palabraTapada=palabraSecretaTapada(palabraSecreta);
        System.out.println("Palabra a adivinar: "+new String(palabraTapada));
        while(letrasIncorrectas<6 && letrasCorrectas<palabraSecreta.length()){
            System.out.println("Dame una letra: ");
            char letra=datos.next().charAt(0);
            if (soloLetras(letra)==false){
                System.out.println("Debes introducir solo letras");
                continue;
            }
            if(letraLeida(intentos, letra)){
                System.out.println("Ya has puesto la letra");
                continue;
            }   
            boolean acierto=false;
            intentos[letrasCorrectas+letrasIncorrectas]=letra;     
            for(int i=0;i<palabraSecreta.length();i++){
              if(palabraSecreta.charAt(i)==letra){
                  palabraTapada[i]=letra;
                  letrasCorrectas++;
                  acierto=true;
              }
            }
            if(!acierto){
                letrasIncorrectas++;
                System.out.println("Has fallado. Te quedan " + (6-letrasIncorrectas) + " intentos." );
                imprimirDibujoError(letrasIncorrectas);
            }      
                System.out.println("Las Letras que has introducido: ");
                imprimirLetrasCaracteresArray(intentos);   
                System.out.println(palabraTapada); 
        }
        if(letrasIncorrectas<6){
            System.out.println("Has ganado");
        }
        else{
            System.out.println("Has perdido");
        }
    }   
    public static boolean letraLeida(char[] caracteres, char letra){
        for(int i=0;i<caracteres.length;i++){
            if(caracteres[i]==letra){
                    return true;
            }
        }
      return false;
    }
    public static void imprimirLetrasCaracteresArray(char[] caracteres){
        String aImprimir = "";
        for(int i=0;i<caracteres.length;i++){
            if(i==0){
                aImprimir+=caracteres[i];
            }
            else if(caracteres[i]!='\n'){
                aImprimir+=" "+caracteres[i];
            }   
        }
        System.out.println(aImprimir);
    } 
    public static void imprimirDibujoError(int nErrores){
    switch (nErrores) {
        case 1:
            dibujo2();
            break;
        case 2:
            dibujo3();
            break;
        case 3:
            dibujo4();
            break;
        case 4:
            dibujo5();
            break;
        case 5:
            dibujo6();
            break;
        case 6:
            dibujo7();
            break;
        default:
            System.out.println("Invalid number of errors");
            break;
        }
    }
    public static boolean soloLetras( char letra){   
        return (letra>='a' && letra<='z')||(letra>='A' && letra<='Z') ;
    }
    public static void main(String[] args) {
        menu();
        System.out.println("Elije una opción: ");
        int opcion=datos.nextInt();
        switch(opcion){
            case 1:
               System.out.println("Adivina esta palabra: ");
               jugar();
               main(args);                
               break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}

