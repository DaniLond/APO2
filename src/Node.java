import java.util.Random;
public class Node {
    private int num;
    private Player player;
    private String Question;
    private String answer;
    private State state;
    private Node previus;
    private Node next;

    static Random random= new Random();

    private String userAnswer;

    public Node(int num) {
        this.num = num;
        this.state= State.UNRESOLVED;
        this.generateQuestionAndAnswer();
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getNum() {
        return num;
    }

    public Player getPlayer() {
        return player;
    }

    public String getQuestion() {
        return Question;
    }

    public String getAnswer() {
        return answer;
    }

    public State getState() {
        return state;
    }

    public Node getPrevius() {
        return previus;
    }

    public Node getNext() {
        return next;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setPrevius(Node previus) {
        this.previus = previus;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void generateQuestionAndAnswer(){
        int a= random.nextInt(100);
        int b= random.nextInt(100);
        int op= random.nextInt(2);

        String opStr= (op == 0)? "+" : "x";

        this.Question= "Cuanto es " + a + opStr + b;

        int res= (op == 0)? a + b: a * b;

        this.answer= "" + res;

    }
}
