public class InsertAtPos {
    public static void INsAtPos(int data,int pos){
        if(pos==1){
            //INsAtHead
            return;
        }

        Node nn = new Node(data);
        Node temp = head;
        for(int i=1;i<pos-1 && temp != null;i++){
            temp = temp.next;
        }
        if(temp == null){
            return;
        }
        nn.next = temp.next;
        temp.next = nn;
    }
}
