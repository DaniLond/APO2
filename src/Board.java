public class Board {
    private Node head;
    private Node tail;

    public void createdBoard(int num){
        int n=0;
       for (int i=0; i < num; i++){
           n++;
           Node node= new Node( n );
           if(head == null){
               head = node;
               tail= node;
               node.setNum(1);
           }else {
               tail.setNext(node);
               node.setPrevius(tail);
               tail= node;
               node.setNum(node.getPrevius().getNum() + 1);
           }
       }
    }

    public void print(){
        print(head);
    }

    // Recursivo
    private void print(Node current){
        if(current == null){
            return;
        }else {
            if(current.getState() == State.UNRESOLVED){
                if (current.getPlayer() == null){
                    System.out.print("[ " + current.getNum() + " ]");
                    print(current.getNext());
                }else {
                    System.out.print("[ " + current.getNum() + " * ]");
                    print(current.getNext());
                }
            }else{
                if (current.getState() == State.CORRECT){
                    System.out.print("[ + ]");
                    print(current.getNext());
                }else{
                    if (current.getState() == State.INCORRECT){
                        System.out.print("[ X ]");
                        print(current.getNext());
                    }
                }
            }
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public String showQuestion(Node current) {
        if (current.getPlayer() != null) {
            return "\n" + current.getQuestion();
        }
        return showQuestion(current.getNext());
    }

    public void delete(Node current){

        if (current == head){
            Node next= head.getNext();
            next.setPrevius(null);
            head= next;
            return;
        }else {
            if(current == tail){
                Node pre= tail.getPrevius();
                pre.setNext(null);
                tail= pre;
                return;
            }
        }
        Node prev= current.getPrevius();
        Node next= current.getNext();
        prev.setNext(next);
        next.setPrevius(prev);
        return;
    }
}
