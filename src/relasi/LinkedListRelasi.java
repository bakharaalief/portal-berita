package relasi;
import news.News;
import news.NodeNews;

import javax.xml.soap.Node;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LinkedListRelasi {
    private NodeRelasi head = null;
    private NodeRelasi tail = null;
    private int size = 0;

    public int getSize() {
        System.out.println("Banyak Berita : " + size);
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public NodeRelasi head(){
        if (isEmpty()) return null;
        return head;
    }

    public NodeRelasi tail(){
        if (isEmpty()) return null;
        return tail;
    }

    //berita paling baru akan ditaruh paling depan
    public void addNewNews(Relasi relasi){
        NodeRelasi newNews = new NodeRelasi();

        newNews.setPrev(null);
        newNews.setRelasi(relasi);
        newNews.setNext(head);

        if(size == 0){
            head = newNews;
            tail = head;
        }
        else{
            head.setPrev(newNews);
            head = newNews;
        }

        size++;
    }

    private String dateFormat(LocalDateTime input){
        String date = input.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        return date;
    }

    public void printListAll(){
        int number = 1;
        NodeRelasi data = head;
        String title = "";
        String category = "";
        String author = "";
        String created = "";

        if(isEmpty()){
            System.out.println("Maaf Data Berita Kosong");
        }
        else if(data.getNext() == null){
            title = data.getRelasi().news.getTitle();
            category = data.getRelasi().category.getCategory();
            author = data.getRelasi().author.getName();
            created = dateFormat(data.getRelasi().news.getCreated());

            System.out.println( "("+ number + ") " + title + ", " + category + ", " + author + ", " +created);
        }
        else{

            while (data.getNext() != null){

                //print data
                title = data.getRelasi().news.getTitle();
                category = data.getRelasi().category.getCategory();
                author = data.getRelasi().author.getName();
                created = dateFormat(data.getRelasi().news.getCreated());

                System.out.println( "("+ number + ") "+ title + ", " + category + ", " + author + ", " + created);

                //get next data while data founded
                data = data.getNext();
                number++;
            }

            title = data.getRelasi().news.getTitle();
            category = data.getRelasi().category.getCategory();
            author = data.getRelasi().author.getName();
            created = dateFormat(data.getRelasi().news.getCreated());

            System.out.println( "("+ number + ") " + title + ", " + category + ", " + author + ", " + created);
        }
    }

    public void printListByCategory(String categoryInput){
        int number = 1;
        NodeRelasi data = head;
        String title = "";
        String category = "";
        String author = "";
        String created = "";

        System.out.println("------- LIST "+ categoryInput.toUpperCase() +"-------");

        if(isEmpty()){
            System.out.println("Maaf Data Kosong");
        }
        else if(data.getNext() == null){
            category = data.getRelasi().category.getCategory();

            //when data found
            if(categoryInput.toLowerCase().equals(category.toLowerCase())){

                title = data.getRelasi().news.getTitle();
                author = data.getRelasi().author.getName();
                created = dateFormat(data.getRelasi().news.getCreated());

                System.out.println( "("+ number + ") " + title + ", " + category + ", " + author + ", " + created);
            }

            //when data not found
            else{
                System.out.println("Maaf Data Kosong");
            }
        }
        else{
            boolean notSame = true;
            while (data.getNext() != null){

                //print data
                category = data.getRelasi().category.getCategory();

                //when data found
                if(categoryInput.toLowerCase().equals(category.toLowerCase())){

                    notSame = false;

                    title = data.getRelasi().news.getTitle();
                    author = data.getRelasi().author.getName();
                    created = dateFormat(data.getRelasi().news.getCreated());

                    System.out.println( "("+ number + ") " + title + ", " + category + ", " + author + ", " + created);
                }

                //get next data while data founded
                data = data.getNext();
                number++;
            }

            category = data.getRelasi().category.getCategory();

            //when data found
            if(categoryInput.toLowerCase().equals(category.toLowerCase())){

                notSame = false;

                title = data.getRelasi().news.getTitle();
                author = data.getRelasi().author.getName();
                created = dateFormat(data.getRelasi().news.getCreated());

                System.out.println( "("+ number + ") " + title + ", " + category + ", " + author + ", " + created);
            }

            if(notSame){
                System.out.println("Maaf Data Kosong");
            }
        }
    }

    public void printListByAuthor(String authorInput){
        int number = 1;
        NodeRelasi data = head;
        String title = "";
        String category = "";
        String author = "";
        String created = "";

        System.out.println("------- LIST BERITA OLEH "+ authorInput.toUpperCase() +"-------");

        if(isEmpty()){
            System.out.println("Maaf Data Kosong");
        }
        else if(data.getNext() == null){
            author = data.getRelasi().author.getName();

            //when data found
            if(authorInput.toLowerCase().equals(author.toLowerCase())){

                title = data.getRelasi().news.getTitle();
                category = data.getRelasi().category.getCategory();
                created = dateFormat(data.getRelasi().news.getCreated());

                System.out.println( "("+ number + ") " + title + ", " + category + ", " + author + ", " + created);
            }

            //when data not found
            else{
                System.out.println("Maaf Data Kosong");
            }
        }
        else{
            boolean notSame = true;
            while (data.getNext() != null){

                //print data
                author = data.getRelasi().author.getName();

                //when data found
                if(authorInput.toLowerCase().equals(author.toLowerCase())){

                    notSame = false;

                    title = data.getRelasi().news.getTitle();
                    category = data.getRelasi().category.getCategory();
                    created = dateFormat(data.getRelasi().news.getCreated());

                    System.out.println( "("+ number + ") " + title + ", " + category + ", " + author + ", " + created);
                }

                //get next data while data founded
                data = data.getNext();
                number++;
            }

            author = data.getRelasi().author.getName();

            //when data found
            if(authorInput.toLowerCase().equals(author.toLowerCase())){

                notSame = false;

                title = data.getRelasi().news.getTitle();
                category = data.getRelasi().category.getCategory();
                created = dateFormat(data.getRelasi().news.getCreated());

                System.out.println( title + ", " + category + ", " + author + ", " +created);
            }

            if(notSame){
                System.out.println("Maaf Data Kosong");
            }
        }
    }

    public boolean detectCategory(String categoryInput){
        int number = 1;
        boolean detect = false;
        NodeRelasi data = head;
        String category = "";

        if(isEmpty()){
            return false;
        }
        else if(data.getNext() == null){
            category = data.getRelasi().category.getCategory();

            //when data found
            if(categoryInput.toLowerCase().equals(category.toLowerCase())){
                detect = true;
                return detect;
            }

            return detect;
        }
        else{
            while (data.getNext() != null){

                //print data
                category = data.getRelasi().category.getCategory();

                //when data found
                if(categoryInput.toLowerCase().equals(category.toLowerCase())){
                    detect = true;
                }

                //get next data while data founded
                data = data.getNext();
                number++;
            }

            category = data.getRelasi().category.getCategory();

            //when data found
            if(categoryInput.toLowerCase().equals(category.toLowerCase())){
                detect = true;
            }

            return detect;
        }
    }

    public boolean detectAuthor(String authorInput){
        int number = 1;
        boolean detect = false;
        NodeRelasi data = head;
        String author = "";

        if(isEmpty()){
            return false;
        }
        else if(data.getNext() == null){
            author = data.getRelasi().author.getName();

            //when data found
            if(authorInput.toLowerCase().equals(author.toLowerCase())){
                detect = true;
                return detect;
            }

            return detect;
        }
        else{
            while (data.getNext() != null){

                //print data
                author = data.getRelasi().author.getName();

                //when data found
                if(authorInput.toLowerCase().equals(author.toLowerCase())){
                    detect = true;
                }

                //get next data while data founded
                data = data.getNext();
                number++;
            }

            author = data.getRelasi().category.getCategory();

            //when data found
            if(authorInput.toLowerCase().equals(author.toLowerCase())){
                detect = true;
            }

            return detect;
        }
    }

    public void searchNews(String news){

        System.out.println("------- CARI BERITA -------");

        if(isEmpty() || head == null){
            System.out.println("Maaf Data Kosong");
        }
        else{
            NodeRelasi data = head;
            int i = 1;

            //looping if category didnt found
            while (!data.getRelasi().news.getTitle().toLowerCase().equals(news.toLowerCase())) {
                data = data.getNext();
                i++;
                if(i > size)
                    break;
            }

            if( i > size){
                System.out.println("Maaf Berita Tidak Ditemukan");
            }
            else{
                Relasi found = data.getRelasi();
                System.out.println("Berita " + found.news.getTitle() + " Ditemukan");
                System.out.println("Nomor Berita : " + i);
            }
        }
    }

    public void newsDetail(int newsNumber){
        int index = 1;
        NodeRelasi data = head;

        if(newsNumber > size){
            System.out.println("Maaf Berita yang Anda Cari Tidak Ada");
        }

        else{
            while (newsNumber != index){
                data = data.getNext();
                index++;
            }

            System.out.println("Judul       : " + data.getRelasi().news.getTitle());
            System.out.println("Isi         : " + data.getRelasi().news.getContent());
            System.out.println("Penulis     : " + data.getRelasi().author.getName());
            System.out.println("Category    : " + data.getRelasi().category.getCategory());
            System.out.println("Dibuat      : " + dateFormat(data.getRelasi().news.getCreated()));
        }

    }

    public Relasi removeNews(int newsNumber){
        if(isEmpty() || head == null){
            System.out.println("Maaf Data Kosong");
            return null;
        }

        else{
            NodeRelasi data = head;
            int i = 1;

            //looping if category didnt found
            while (i != newsNumber) {
                data = data.getNext();
                i++;
                if(i > size)
                    break;
            }

            //ketika data tidak ditemukan
            if( i > size){
                return null;
            }

            //ditemukan
            else{
                Relasi removeNews = data.getRelasi();
                NodeRelasi nextData = data.getNext();
                NodeRelasi beforeData = data.getPrev();

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

                return removeNews;
            }
        }
    }
}
