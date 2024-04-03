
import java.util.Scanner;

class driver {
    public String NoSIM;
    public String nama;
    public String TanggalLahir;
}

class penumpang{
    public String nama;
    public penumpang(String nama){
        this.nama= nama;
    }
}

class kendaraan {
    public String MerkMobil;
    public String WarnaMobil;
    public String Platnomer;
    public int JumlahPenumpang;
    public int MaxPenumpang;

    public driver supir;
    public driver namaSupir;
    public driver TanggalLahir;
    public penumpang [] namaPenumpang;

     public kendaraan(String m, String w, String pn, int max){
        this.MerkMobil= m;
        this.WarnaMobil= w;
        this.Platnomer= pn;
        this.JumlahPenumpang= 0;
        this.MaxPenumpang= max;
        this.namaPenumpang= new penumpang[max];
        System.out.println("Merk: " + this.MerkMobil + "\nWarna: " + this.WarnaMobil + "\nPlat Nomor: " + this.Platnomer);
        
        System.out.println("Jumlah penumpang: " + this.JumlahPenumpang + "\nMaximal penumpang: " + this.MaxPenumpang);
    }

    public void cekPenumpang(){
        System.out.println("Penumpang saat ini adalah " + this.JumlahPenumpang);
    }
    public void penumpangNaik(String nama){
        if(this.JumlahPenumpang < MaxPenumpang){
            this.namaPenumpang [this.JumlahPenumpang] = new penumpang(nama);
            this.JumlahPenumpang++;
            System.out.println("Penumpang bernama " + nama + " berhasil naik");
        }else System.out.println("Maaf penumpang sudah penuh");

        cekPenumpang();
        
    }
    public void penumpangNaik(int naik){
        System.out.println("ada penumpang ingin naik: "+ naik);
        int current = this.JumlahPenumpang;
        if(current+ naik > MaxPenumpang){
            System.out.println("Maaf kendaraan penuh");
        }else{
            this.JumlahPenumpang+=naik;
            System.out.println("penumpang berhasil naik");
        }
        cekPenumpang();
    }
    public void penumpangTurun(int turun){
        System.out.println("ada penumpang ingin naik: "+ turun);
        int current = this.JumlahPenumpang;
        if(current-turun < 0){
            System.out.println("Maaf kendaraan kosong tidak ada yang turun");
        }else{
            this.JumlahPenumpang-=turun;
            System.out.println("penumpang berhasil turun");
        }
        cekPenumpang();
    }

    public void maju(){
        System.out.println(this.MerkMobil + this.WarnaMobil + this.Platnomer + " Sedang berjalan maju");
    }
    public void mundur(){
        System.out.println(this.MerkMobil + this.WarnaMobil + this.Platnomer + " Sedang berjalan mundur");
    }
    public void berhenti(){
        System.out.println(this.MerkMobil + this.WarnaMobil + this.Platnomer + " Sedang berhenti");
    }
    public void namaSupir(){
        System.out.println("Nama : " + this.supir.nama);
    }
    public void TanggalLahir(){
        System.out.println("Tanggal Lahir : " + this.supir.TanggalLahir);
    }
    public void showSIM(){
        System.out.println("No SIM : " + this.supir.NoSIM);
    }


   static class truck extends kendaraan{
    double kapasitasMuatan;
     public truck (String m, String w, String pn, int max){
        super(m, w, pn, max);
        this.kapasitasMuatan= kapasitasMuatan;
     }
     public void kapasitasMuatan(){
        System.out.println("Muatannya adalah " + this.kapasitasMuatan + "ton");
     }

   }
   static class bus extends kendaraan{
    int cekToilet;
     public bus (String m, String w, String pn, int max, int cekToilet){
        super(m, w, pn, max);
     }
     void cekToilet(){
        if(this.cekToilet == 1){
            System.out.println("di dalam masih ada orang, silahkan tunggu");
        }else System.out.println("di dalam tidak ada orang, silahkan masuk");
        }
     }
   


    public class LK02{
        public static void main(String[] args) {
            System.out.println("Jenis Kendaraan : Mobil");
            kendaraan m1 = new kendaraan("BMW "," Kuning ", " N 6493 KO", 5);
             //Membuat Relasi Driver
            driver s1 = new driver();
            System.out.println("Biodata Supir : ");
            s1.nama = "Dimas Rezananda";
            s1.TanggalLahir = "7 Maret 2005";
            s1.NoSIM = "98237";
            m1.supir = s1;
            m1.namaSupir();
            m1.TanggalLahir();
            m1.showSIM();
            System.out.println("");

            System.out.println("Jenis Kendaraan : Truck");
            kendaraan.truck t1 = new truck ("Hino", "Hijau", " B 1234 HG ", 3);
             //Membuat Relasi Driver
             driver s2 = new driver();
            System.out.println("Biodata Supir : ");
            s2.nama = "Joko Pitono";
            s2.TanggalLahir = "30 April 1970";
            s2.NoSIM = "12345";
            t1.supir = s2;
            t1.namaSupir();
            t1.TanggalLahir();
            t1.showSIM();
            System.out.println("");

            System.out.println("Jenis Kendaraan : Bus");
            kendaraan.bus b1 = new bus("Scania"," Biru ", " M 45 BRO", 40,1);
            //Membuat Relasi Driver
            driver s3 = new driver();
            System.out.println("Biodata Supir : ");
            s3.nama = "Rudi Pambudi";
            s3.TanggalLahir = "13 Desember 1985";
            s3.NoSIM = "09126";
            b1.supir = s3;
            b1.namaSupir();
            b1.TanggalLahir();
            b1.showSIM();
            System.out.println("");

            Scanner input = new Scanner(System.in);

            int pilihan=0;
            System.out.println("Silahkan piih kendaraan anda");
            while (pilihan!=4){
                System.out.println("Pilih Kendaraan : ");
                System.out.println("1. Truck ");
                System.out.println("2. Bus ");
                System.out.println("3. Mobil ");
                System.out.println("4. Cancel ");

                System.out.println("Pilih Kendaraan (masukkan angka): ");
                (pilihan)= input.nextInt();
                
                switch (pilihan) {
                    case 1:
                    System.out.println("Anda memilih Truck");
                    kendaraan.truck t2 = new truck ("Hino", "Hijau", " B 1234 HG ", 3);
                    menuTruck(t1, input);
                    break;
                case 2:
                   System.out.println("Anda memilih Bus");
                    kendaraan.bus b2 = new bus("Scania"," Biru ", " M 45 BRO", 40,1);
                    menuBus(b1, input);
                    break;
                case 3:
                System.out.println("Anda memilih Mobil");    
                kendaraan mobil2 = new kendaraan("BMW "," Kuning ", " N 6493 KO", 5);
                menuKendaraan(m1, input);
                    break;
                case 4:
                System.out.println("Terima kasih sudah memilih");
                System.exit(0);
                default:
                System.out.println("Pilihan tidak valid, masukkan pilihan anda kembali");
                continue;
            }
            }

            }
            public static void menuTruck(kendaraan.truck truck, Scanner input) {
                int menu = 0;
                do {
                    System.out.println("Menu Truck:");
                    System.out.println("1. Cek Kapasitas Muatan");
                    System.out.println("2. Penumpang Naik");
                    System.out.println("3. Kembali ke Menu Utama");
            
                    System.out.print("Pilih menu (masukkan angka): ");
                    menu = input.nextInt();
            
                    switch (menu) {
                        case 1:
                            truck.kapasitasMuatan();
                            break;
                        case 2:
                            
                            System.out.println("masukkan nama");
                            truck.penumpangNaik(input.next());
                            return;
                            
                        case 3:
                            System.out.println("Kembali ke Menu Utama");
                            break;
                        default:
                            System.out.println("Pilihan tidak valid. Silakan pilih antara 1-3.");
                    }
                }while (menu != 3);
                input.close();
                
            }
            public static void menuBus(kendaraan.bus bus, Scanner input) {
                int menu = 0;
                do{
                    System.out.println("Menu bus:");
                    System.out.println("1. Cek Toilet");
                    System.out.println("2. Penumpang Naik");
                    System.out.println("3. Kembali ke Menu Utama");
            
                    System.out.print("Pilih menu (masukkan angka): ");
                    menu = input.nextInt();
            
                    switch (menu) {
                        case 1:
                            bus.cekToilet();
                            break;
                        case 2:
                            
                            System.out.println("masukkan nama");
                            bus.penumpangNaik(input.next());
                           
                            break;
                        case 3:
                            System.out.println("Kembali ke Menu Utama");
                            break;
                        default:
                            System.out.println("Pilihan tidak valid. Silakan pilih antara 1-3.");
                    }
                }while (menu != 3) ;
                input.close();
            }
            
            public static void menuKendaraan(kendaraan kendaraan, Scanner input){
            int menu = 0;
            while (menu!= 4) {
                
                System.out.println("Menu:");
                System.out.println("1. Naik");
                System.out.println("2. Turun");
                System.out.println("3. Cek Penumpang");
                System.out.println("4. Keluar");
                
                System.out.print("Pilih menu (masukkan angka): ");
            (menu)= input.nextInt();
                
               
                switch (menu) {
                    case 1:
                    System.out.println("masukkan nama");
                    kendaraan.penumpangNaik(input.next());
                        break;
                    case 2:
                        System.out.println("Berapa jumlah penumpang turun?");
                        System.out.print("(masukkan angka): ");
                        int turun = input.nextInt();
                        kendaraan.penumpangTurun(turun);
                        break;
                    case 3:
                        kendaraan.cekPenumpang();
                        break;
                    case 4:
                        System.out.println("Terima kasih. Program berhenti.");
                        System.exit(0);
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.");
                }

                }    
                input.close();
            
        }    
    }
}
