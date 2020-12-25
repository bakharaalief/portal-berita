package news;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LinkedListNews {
    private NodeNews head = null;
    private NodeNews tail = null;
    private int size = 0;

    public int getSize() {
        System.out.println("Banyak Berita " + size);
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public NodeNews head(){
        if (isEmpty()) return null;
        return head;
    }

    public NodeNews tail(){
        if (isEmpty()) return null;
        return tail;
    }

    //berita paling baru akan ditambah paling depan
    public void addNews(News news){
        NodeNews newNews = new NodeNews();

        newNews.setPrev(null);
        newNews.setNews(news);
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

    //remove news
    public News removeNews(String news){
        if(isEmpty() || head == null){
            return null;
        }

        else{
            NodeNews data = head;
            int i = 0;

            //looping if category didnt found
            while (!data.getNews().title.toLowerCase().equals(news.toLowerCase())) {
                data = data.getNext();
                i++;
                if(i + 1 > size)
                    break;
            }

            //ketika data tidak ditemukan
            if( i + 1 > size){
                return null;
            }

            //ditemukan
            else{
                News removeNews = data.getNews();
                NodeNews nextData = data.getNext();
                NodeNews beforeData = data.getPrev();

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

    public void printlist(){
        NodeNews data = head;

        if(isEmpty()){
            System.out.println("kosong");
        }
        else if(data.getNext() == null){
            System.out.println(data.getNews().title + " ");
        }
        else{

            while (data.getNext() != null){
                System.out.print(data.getNews().title + " ");
                data = data.getNext();
            }
            System.out.print(data.getNews().title + " ");
            System.out.println(" ");
        }
    }

    //search Author
    public News searchNews(String news){
        if(isEmpty() || head == null){
            System.out.println("Maaf Data Kosong");
            return null;
        }
        else{
            NodeNews data = head;
            int i = 0;

            //looping if category didnt found
            while (!data.getNews().title.toLowerCase().equals(news.toLowerCase())) {
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
                News found = data.getNews();
                System.out.println("Berita " + found.title + " Ditemukan");
                return found;
            }
        }
    }

    //search detail News
    public News newsDetail(String news){
        if(isEmpty() || head == null){
            System.out.println("Maaf Data Kosong");
            return null;
        }
        else{
            NodeNews data = head;
            int i = 0;

            //looping if category didnt found
            while (!data.getNews().title.toLowerCase().equals(news.toLowerCase())) {
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
                News found = data.getNews();
                System.out.println("Judul   : " + found.title);
                System.out.println("Konten  : " + found.content);
                System.out.println("Dibuat  : " + dateFormat(found.created));
                return found;
            }
        }
    }

    private String dateFormat(LocalDateTime  input){
        String date = input.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        return date;
    }
}
