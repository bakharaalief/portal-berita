package category;

public class LinkedListCategory {
    private NodeCategory head = null;
    private NodeCategory tail = null;
    private int size = 0;

    public int getSize() {
        System.out.println("Banyak Kategori " + size);
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public NodeCategory head() {
        if (isEmpty()) return null;
        return head;
    }

    public NodeCategory tail() {
        if (isEmpty()) return null;
        return tail;
    }

    //kategori paling baru akan ditambah paling depan
    public void addCategory(Category category){
        NodeCategory newCategory = new NodeCategory();

        newCategory.setPrev(null);
        newCategory.setCategory(category);
        newCategory.setNext(head);

        if(size == 0){
            head = newCategory;
            tail = head;
        }
        else{
            head.setPrev(newCategory);
            head = newCategory;
        }

        size++;
    }

    //remove category
    public Category removeCategory(String category){
        if(isEmpty() || head == null){
            System.out.println("Maaf Data Kosong");
            return null;
        }

        else{
            NodeCategory data = head;
            int i = 0;

            //looping if category didnt found
            while (!data.getCategory().category.toLowerCase().equals(category.toLowerCase())) {
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
                Category removeCategory = data.getCategory();
                NodeCategory nextData = data.getNext();
                NodeCategory beforeData = data.getPrev();

                //if remove account in head
                if(beforeData == null){

                    //when next data didnt null
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

                    if(beforeData != null)
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

                System.out.println("Berhasil Remove " + removeCategory.category + " dari Kategori");
                return removeCategory;
            }
        }
    }

    //print category in linked list
    public void printlist(){
        NodeCategory data = head;

        if(isEmpty()){
            System.out.println("List kategori kosong");
        }
        else if(data.getNext() == null){
            System.out.println(data.getCategory().category + " ");
        }
        else{
            while (data.getNext() != null){
                System.out.print(data.getCategory().category + ", ");
                data = data.getNext();
            }
            System.out.print(data.getCategory().category + ", ");
            System.out.println("");
        }
    }

    //search category
    public void searchCategory(String category){
        if(isEmpty() || head == null){
            System.out.println("Maaf Data Kosong");
        }
        else{
            NodeCategory data = head;
            int i = 0;

            //looping if category didnt found
            while (!data.getCategory().category.toLowerCase().equals(category.toLowerCase())) {
                data = data.getNext();
                i++;
                if(i + 1 > size)
                    break;
            }

            if( i + 1 > size){
                System.out.println("Maaf Data Tidak Ditemukan");
            }
            else{
                Category found = data.getCategory();
                System.out.println("Kategori " + found.category + "Ditemukan");
            }
        }
    }

    //search category with data
    public Category searchCategoryWithData(String category){
        if(isEmpty() || head == null){
            return null;
        }
        else{
            NodeCategory data = head;
            int i = 0;

            //looping if category didnt found
            while (!data.getCategory().category.toLowerCase().equals(category.toLowerCase())) {
                data = data.getNext();
                i++;
                if(i + 1 > size)
                    break;
            }

            if( i + 1 > size){
                return null;
            }
            else{
                return data.getCategory();
            }
        }
    }
}
