package author;

public class LinkedListAuthor {
    private NodeAuthor head = null;
    private NodeAuthor tail = null;
    private int size = 0;

    public int getSize() {
        System.out.println("Banyak Penulis " + size);
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public NodeAuthor head() {
        if (isEmpty()) return null;
        return head;
    }

    public NodeAuthor tail() {
        if (isEmpty()) return null;
        return tail;
    }

    //author paling baru akan ditambah paling depan
    public void addAuhtor(Author author){
        NodeAuthor newAuthor = new NodeAuthor();

        newAuthor.setPrev(null);
        newAuthor.setAuthor(author);
        newAuthor.setNext(head);

        if(size == 0){
            head = newAuthor;
            tail = head;
        }
        else{
            head.setPrev(newAuthor);
            head = newAuthor;
        }

        size++;
    }

    //remove Author
    public Author removeAuthor(String name){
        if(isEmpty() || head == null){
            System.out.println("Maaf Data Kosong");
            return null;
        }

        else{
            NodeAuthor data = head;
            int i = 0;

            //looping if category didnt found
            while (!data.getAuthor().name.toLowerCase().equals(name.toLowerCase())) {
                data = data.getNext();
                i++;
                if(i + 1 > size)
                    break;
            }

            //ketika data tidak ditemukan
            if( i + 1 > size){
                System.out.println("Maaf Data Tidak Ditemukan");
                return null;
            }

            //ditemukan
            else{
                Author removeAuthor = data.getAuthor();
                NodeAuthor nextData = data.getNext();
                NodeAuthor beforeData = data.getPrev();

                //if remove account in head
                if(beforeData == null){

                    if(nextData != null)
                        nextData.setPrev(null);

                    size--;

                    //if size 1
                    if(size == 1){
                        head = nextData;
                        tail = nextData;
                    }

                    //else
                    else{
                        head = nextData;
                    }
                }

                //if remove tail data
                else if(nextData == null){

                    if (beforeData != null)
                        beforeData.setNext(null);

                    size--;

                    //if size 1
                    if(size == 1){
                        head = beforeData;
                        tail = beforeData;
                    }

                    //else
                    else{
                        tail = beforeData;
                    }
                }

                //else
                else{
                    beforeData.setNext(nextData);
                    nextData.setPrev(beforeData);

                    size--;

                    if(size == 1){
                        head = nextData;
                        tail = nextData;
                    }
                }

                System.out.println("Berhasil Remove " + removeAuthor.name + " dari Author");
                return removeAuthor;
            }
        }
    }

    //print content in linked list
    public void printlist(){
        NodeAuthor data = head;

        if(isEmpty()){
            System.out.println("List Penulis Kosong");
        }
        else if(data.getNext() == null){
            System.out.println(data.getAuthor().name + " ");
        }
        else{
            while (data.getNext() != null){
                System.out.print(data.getAuthor().name + ", ");
                data = data.getNext();
            }
            System.out.print(data.getAuthor().name + ", ");
            System.out.println(" ");
        }
    }

    //search Author
    public void searchAuthor(String name){
        if(isEmpty() || head == null){
            System.out.println("Maaf Data Kosong");
        }
        else{
            NodeAuthor data = head;
            int i = 0;

            //looping if category didnt found
            while (!data.getAuthor().name.toLowerCase().equals(name.toLowerCase())) {
                data = data.getNext();
                i++;
                if(i + 1 > size)
                    break;
            }

            if( i + 1 > size){
                System.out.println("Maaf Data Tidak Ditemukan");
            }
            else{
                Author found = data.getAuthor();
                System.out.println("Penulis " + found.name + " Ditemukan");
            }
        }
    }

    //search Author with data
    public Author searchAuthorWithData(String name){
        if(isEmpty() || head == null){
            return null;
        }
        else{
            NodeAuthor data = head;
            int i = 0;

            //looping if category didnt found
            while (!data.getAuthor().name.toLowerCase().equals(name.toLowerCase())) {
                data = data.getNext();
                i++;
                if(i + 1 > size)
                    break;
            }

            if( i + 1 > size){
                return null;
            }
            else{
                return data.getAuthor();
            }
        }
    }

    //search detail Author
    public Author authorDetail(String name){
        if(isEmpty() || head == null){
            System.out.println("Maaf Data Kosong");
            return null;
        }
        else{
            NodeAuthor data = head;
            int i = 0;

            //looping if category didnt found
            while (!data.getAuthor().name.toLowerCase().equals(name.toLowerCase())) {
                data = data.getNext();
                i++;
                if(i + 1 > size)
                    break;
            }

            if( i + 1 > size){
                System.out.println("Maaf Data Tidak Ditemukan");
                return null;
            }
            else{
                Author found = data.getAuthor();
                System.out.println("Penulis : " + found.name);
                System.out.println("Umur    : " + found.age);
                System.out.println("Bio     : " + found.bio);
                return found;
            }
        }
    }
}
