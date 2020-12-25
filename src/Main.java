import author.Author;
import author.LinkedListAuthor;
import category.Category;
import category.LinkedListCategory;
import category.NodeCategory;
import news.LinkedListNews;
import news.News;
import relasi.LinkedListRelasi;
import relasi.Relasi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static LinkedListCategory linkedListCategory = new LinkedListCategory();
    static LinkedListAuthor linkedListAuthor = new LinkedListAuthor();
    static LinkedListNews linkedListNews = new LinkedListNews();
    static LinkedListRelasi linkedListRelasi = new LinkedListRelasi();
    static Scanner input = new Scanner(System.in);

    //main
    public static void main(String[] args) {
        showMenu();
    }

    //show menu
    public static void showMenu(){
        int pilihan = 0;

        try{
            do{
                System.out.println("----- SELAMAT DATANG DI PORTAL BERITA ----");

                //menu
                System.out.println("---- BERITA ----");
                System.out.println("1. List Berita");
                System.out.println("2. List Berita Kategori");
                System.out.println("3. List Berita Penulis");
                System.out.println("4. Detail Berita");
                System.out.println("5. Tambah Berita");
                System.out.println("6. Hapus Berita");

                System.out.println("---- KATEGORI ----");
                System.out.println("7. Tambah Kategori");
                System.out.println("8. Hapus Kategori");
                System.out.println("9. List Kategori");

                System.out.println("---- PENULIS ----");
                System.out.println("10. Tambah Penulis");
                System.out.println("11. Hapus Penulis");
                System.out.println("12. List Penulis");
                System.out.println("13. Detail Penulis");

                System.out.println("---- Keluar ----");
                System.out.println("0. Keluar");

                System.out.println("-------------------");
                System.out.print("Silahkan Pilih Menu : ");

                pilihan = input.nextInt();

                switch (pilihan) {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        listBerita();
                        break;
                    case 2:
                        listBeritaKategori();
                        break;
                    case 3:
                        listBeritaPenulis();
                        break;
                    case 4:
                        detailBerita();
                        break;
                    case 5:
                        tambahBerita();
                        break;
                    case 6:
                        hapusBerita();
                        break;
                    case 7:
                        tambahKategori();
                        break;
                    case 8:
                        hapusKategori();
                        break;
                    case 9:
                        listKategori();
                        break;
                    case 10 :
                        tambahPenulis();
                        break;
                    case 11 :
                        hapusPenulis();
                        break;
                    case 12:
                        listPenulis();
                        break;
                    case 13:
                        detailPenulis();
                        break;

                    default:
                        System.out.println("Pilihan salah!");
                }

            }while (pilihan != 0);

        }

        catch (Exception e){
            System.out.println(e);
            System.out.println("Masukkan data yang benar");
        }
    }

    //list Berita
    public static void listBerita(){
        System.out.println("---- LIST BERITA ------");
        linkedListRelasi.printListAll();
    }

    //list Berita kategori
    public static void listBeritaKategori(){
        System.out.println("---- LIST BERITA KATEGORI ------");
        linkedListCategory.printlist();

        //masukkan kategori
        input = new Scanner(System.in);
        System.out.print("Kategori      : ");
        String kategori = input.nextLine();

        //list kategori
        linkedListRelasi.printListByCategory(kategori);
    }

    //list Berita Penulis
    public static void listBeritaPenulis(){
        System.out.println("---- LIST BERITA PENULIS ------");
        linkedListAuthor.printlist();

        //masukkan penulis
        input = new Scanner(System.in);
        System.out.print("Penulis      : ");
        String penulis = input.nextLine();

        //list kategori
        linkedListRelasi.printListByAuthor(penulis);
    }

    //detail berita
    public static void detailBerita(){
        System.out.println("---- DETAIL BERITA ------");

        //masukkan nomor
        System.out.print("Nomor Berita      : ");
        int number = input.nextInt();
        linkedListRelasi.newsDetail(number);
    }

    //tambah berita
    public static void tambahBerita(){
        System.out.println("---- TAMBAH BERITA ------");

        //penulis
        input = new Scanner(System.in);
        linkedListAuthor.printlist();
        System.out.print("Penulis       : ");
        String author = input.nextLine();

        //category
        input = new Scanner(System.in);
        linkedListCategory.printlist();
        System.out.print("Kategori      : ");
        String category = input.nextLine();

        //search author
        Author authorFound = linkedListAuthor.searchAuthorWithData(author);

        //search category
        Category categoryFound = linkedListCategory.searchCategoryWithData(category);

        if(authorFound != null && categoryFound != null){
            //judul
            System.out.print("Judul         : ");
            String title = input.nextLine();

            //content
            System.out.print("Isi           : ");
            String content = input.nextLine();

            //create new News and add to News linkedlist
            News news = new News(title, content, LocalDateTime.now());
            linkedListNews.addNews(news);

            //create new relation and add to relation linkedlist
            Relasi relasi = new Relasi(news, authorFound, categoryFound);
            linkedListRelasi.addNewNews(relasi);
        }

        else{
            if(authorFound == null){
                System.out.println("Maaf Penulis Tidak Ditemukan");
            }
            else if(categoryFound == null){
                System.out.println("Maaf Kategori Tidak Ditemukan");
            }
            else{
                System.out.println("Maaf Penulis dan Kategori Tidak Ditemukan");
            }
        }

    }

    //hapus berita
    public static void hapusBerita(){
        System.out.println("---- HAPUS BERITA ------");

        //masukkan nomor
        System.out.print("Nomor Berita      : ");
        int number = input.nextInt();

        //remove relasi linkedlist
        Relasi deleteRelasi = linkedListRelasi.removeNews(number);

        //when news didnt found
        if(deleteRelasi == null){
            System.out.println("Maaf Data Tidak ditemukan");
        }

        //news found
        else{
            //get title
            String newsTitle = deleteRelasi.getNews().getTitle();

            //remove from news linkedlist
            linkedListNews.removeNews(newsTitle);
            System.out.println("Berita " + newsTitle + " Berhasil di Hapus");
        }
    }

    //tambah kategori
    public static void tambahKategori(){
        System.out.println("---- TAMBAH KATEGORI ----");

        //show list category
        linkedListCategory.printlist();

        //kategori
        input = new Scanner(System.in);

        System.out.print("Kategori         : ");
        String kategori = input.nextLine();

        //create new variable
        Category category = new Category(kategori);

        //add categori to categori linked
        linkedListCategory.addCategory(category);
    }

    //hapus kategori
    public static void hapusKategori(){
        System.out.println("---- HAPUS KATEGORI ------");

        //show list category
        linkedListCategory.printlist();

        //kategori
        input = new Scanner(System.in);
        System.out.print("Kategori         : ");
        String kategori = input.nextLine();

        boolean detect = linkedListRelasi.detectCategory(kategori);

        //when kateogri have relation
        if(detect){
            System.out.println("Maaf Kategori Tidak Bisa Dihapus");
            System.out.println("Masih Terikat dengan Berita");
        }

        //when kategori not relation
        else{
            linkedListCategory.removeCategory(kategori);
        }
    }

    //list kategori
    public static void listKategori(){
        System.out.println("---- LIST KATEGORI ------");
        linkedListCategory.printlist();
    }

    //tambah penulis
    public static void tambahPenulis(){
        System.out.println("---- TAMBAH PENULIS ----");
        linkedListAuthor.printlist();

        //kategori
        input = new Scanner(System.in);

        //nama
        System.out.print("Nama      : ");
        String name = input.nextLine();

        //bio
        System.out.print("Bio       : ");
        String bio = input.nextLine();

        //age
        System.out.print("Umur      : ");
        int age = input.nextInt();

        Author author = new Author(name, age, bio);

        linkedListAuthor.addAuhtor(author);
    }

    //hapus penulis
    public static void hapusPenulis(){
        System.out.println("---- HAPUS PENULIS ----");

        //nama penulis
        input = new Scanner(System.in);
        System.out.print("Nama         : ");
        String name = input.nextLine();

        boolean detect = linkedListRelasi.detectAuthor(name);

        //when author have relation
        if(detect){
            System.out.println("Maaf Kategori Tidak Bisa Dihapus");
            System.out.println("Masih Terikat dengan Berita");
        }

        //when author not relation
        else{
            linkedListAuthor.removeAuthor(name);
        }
    }

    //list penulis
    public static void listPenulis(){
        System.out.println("----- LIST PENULIS ----");
        linkedListAuthor.printlist();
    }

    //detail penulis
    public static void detailPenulis(){
        System.out.println("----- DETAIL PENULIS ----");

        //kategori
        input = new Scanner(System.in);

        //nama
        System.out.print("Nama ( Masukkan Penulis)   : ");
        String name = input.nextLine();

        linkedListAuthor.authorDetail(name);
    }
}
