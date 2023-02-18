import java.util.Scanner;
public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static Board board= new Board();
    public static int counter=0;
    public static void main(String[] args) {

        // Se pide el nombre al jugador
        System.out.println("Enter your name");
        String name= sc.nextLine();
        Player player= new Player(name);

        // Se pide el numero de preguntas
        System.out.println("Enter the number of questions");
        int num= sc.nextInt();

        //Se crea el tablero
        board.createdBoard(num);
        // Se inicia el jugador en la cabeza
        board.getHead().setPlayer(player);

        //Empieza el juego
        sc.nextLine();
        startGame(board.getHead());

        //Resumen
        System.out.println("\n your summary");
        showSummary(board.getHead());
        showPuntaje(player);

    }

    public static void startGame(Node current){
        board.print();
        if(current == null){
            return;
        }else{
            System.out.println(board.showQuestion(current));
            System.out.println("write your answer");
            String answerUser= sc.nextLine();
            if(answerUser.equals(current.getAnswer())){
                current.setState(State.CORRECT);
                current.getPlayer().setPuntaje(current.getPlayer().getPuntaje()+1);
            }else {
                if (answerUser.equals("PASO")){
                    current.setState(State.UNRESOLVED);
                    board.delete(current);
                    current.getPlayer().setPuntaje(current.getPlayer().getPuntaje()-3);
                }
                else{
                    if (!answerUser.equals(current.getAnswer())){
                        current.setState(State.INCORRECT);
                    }
                }
            }
            if (current == board.getTail()){
                current.setPlayer(null);
            }else {
                current.getNext().setPlayer(current.getPlayer());
                current.setPlayer(null);
            }
            startGame(current.getNext());
        }
    }

    public static void showSummary(Node current ){

        if (current == null){
            return;
        }
        else {
            System.out.println("\n" + current.getQuestion() + " " + current.getState());
            counter++;
            showSummary(current.getNext());
        }

    }

    public static void showPuntaje(Player player){
        int preguntasPasadas= board.getTail().getNum() - counter;
        if (preguntasPasadas > 0) {
            System.out.println("Pasó " + preguntasPasadas  +  " problema" );
        }

        System.out.println(player.getName() + ", tu puntaje fue: " + player.getPuntaje());
    }
}