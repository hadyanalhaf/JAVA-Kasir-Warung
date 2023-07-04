package pakcahyo2022;
import java.util.Scanner;

public class appToko {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // Daftar data Barang
        cBarang brg1 = new cBarang ("Indomie",2500);
        cBarang brg2 = new cBarang ("Beras",15000);
        cBarang brg3 = new cBarang ("Gula",10000);
        cBarang brg4 = new cBarang ("Minyak",35000);
        cBarang brg5 = new cBarang ("Susu",11000);
        // Daftar Data member
        String user;
        String sandi;
        cMember mem1 = new cMember("fathur","mendingfwb");
        cMember mem2 = new cMember("hadyan","lagijomblo");
        cMember mem3 = new cMember("ismi","nyarijodoh");

        //penyimpanan
        int pbar1 = 0;
        int pbar2 = 0;
        int pbar3 = 0;
        int pbar4 = 0;
        int pbar5 = 0;


        int pmem1 = 0;
        int pmem2 = 0;
        int pmem3 = 0;

        cDaftarTransaksi jual = new cDaftarTransaksi();
        int pilih = 0,pilih2 = 0, pilih3 =0, pilih4 =0,pilih5=0;
        int jumlah;
        int kode=00;
        do{
            System.out.println("\n=== Aplikasi Warung Bu Sis ===");
            System.out.println("1. Pembeli");
            System.out.println("2. Member");
            System.out.println("3. Admin");
            System.out.println("4. Pemilik");
            System.out.println("5. Keluar");
            System.out.print("Pilih = ");
            pilih = sc.nextInt();
            switch(pilih) {
                case 1:
                    //Pembeli
                    kode++;
                    cDaftarTransaksi beli = new cDaftarTransaksi();
                    System.out.print("Masukkan Nama = ");
                    String nama = sc.next();
                    do {
                        System.out.println("\n== Menu Pembeli ==");
                        System.out.println("1. Tambah");
                        System.out.println("2. Hapus");
                        System.out.println("3. Lihat");
                        System.out.println("4. Kembali");
                        System.out.print("Pilih = ");
                        pilih2 = sc.nextInt();
                        switch (pilih2) {
                            case 1:
                                cTransaksi br = null;
                                System.out.println("\nDaftar Barang:");
                                System.out.println("Barang\t\t\tHarga");
                                System.out.println("-----------------------------");
                                System.out.println("1. Indomie\t\t" + brg1.getHarga());
                                System.out.println("2. Beras\t\t"+ brg2.getHarga()) ;
                                System.out.println("3. Gula\t\t\t"+ brg3.getHarga());
                                System.out.println("4. Minyak\t\t"+ brg4.getHarga());
                                System.out.println("5. Susu\t\t\t"+ brg5.getHarga());
                                System.out.print("Pilih = ");
                                pilih3 = sc.nextInt();
                                System.out.print("Jumlah = ");
                                jumlah = sc.nextInt();
                                if (pilih3 == 1) {
                                    br = new cTransaksi(String.valueOf(kode), nama, brg1, jumlah, 0);
                                    pbar1 = (brg1.getHarga()*jumlah);
                                } else if (pilih3 == 2) {
                                    br = new cTransaksi(String.valueOf(kode), nama, brg2, jumlah, 0);
                                     pbar2 = (brg2.getHarga()*jumlah);
                                } else if (pilih3 == 3) {
                                    br = new cTransaksi(String.valueOf(kode), nama, brg3, jumlah, 0);
                                     pbar3 = (brg3.getHarga()*jumlah);
                                } else if (pilih3 == 4) {
                                    br = new cTransaksi(String.valueOf(kode), nama, brg4, jumlah, 0);
                                     pbar4 = (brg4.getHarga()*jumlah);
                                } else if (pilih3 == 5) {
                                    br = new cTransaksi(String.valueOf(kode), nama, brg5, jumlah, 0);
                                     pbar5 = (brg5.getHarga()*jumlah);
                                }
                                beli.tambahTransaksi(br);
                                break;
                            case 2:
                                beli.lihatTransaksi();
                                System.out.println("Hapus Nomor = ");
                                int hapus = sc.nextInt();
                                beli.hapusTransaksi(hapus);
                                break;
                            case 3:
                                beli.lihatTransaksi();
                                break;
                            case 4:
                                jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                break;
                        }
                    } while (pilih2 != 4);
                    break;
                case 2:
                    //Member
                    boolean valid = false;
                    int identifier = 0;
                    do {
                        System.out.print("Masukan Username :");
                        user = sc.next();
                        System.out.print("Password :");
                        sandi = sc.next();
                        if (user.equals(mem1.getUsername()) && sandi.equals(mem1.getPass())) {
                            valid = true;
                            identifier = 1;
                        } else if (user.equals(mem2.getUsername()) && sandi.equals(mem2.getPass())) {
                            valid = true;
                            identifier = 2;
                        } else if (user.equals(mem3.getUsername()) && sandi.equals(mem3.getPass())) {
                            valid = true;
                            identifier = 3;
                        }
                        if (valid == false) {
                            System.out.println("Akun member tidak di temukan");
                        } else {
                            break;
                        }

                    } while (valid == false);

                    if (valid == true) {
                        System.out.println("\nMember Valid!\n");

                        kode++;
                        // Linked List memasukkan data dari Member
                        beli = new cDaftarTransaksi();
                        System.out.print("Masukkan Nama = ");
                        nama = sc.next();
                        do {
                            System.out.println("\n== Menu Member ==");
                            System.out.println("1. Pembelian");
                            System.out.println("2. Ganti Password");
                            System.out.println("3. Keluar");
                            System.out.print("Pilih Menu :");
                            pilih4 = sc.nextInt();
                            if (pilih4 == 1) {
                                do {
                                    System.out.println("\n== Akun Member ==");
                                    System.out.println("1. Tambah");
                                    System.out.println("2. Hapus");
                                    System.out.println("3. Lihat");
                                    System.out.println("4. Kembali");
                                    System.out.print("Pilih = ");
                                    pilih2 = sc.nextInt();
                                    switch (pilih2) {
                                        case 1:

                                            int tsm11 = 0;
                                            int tsm12 = 0;
                                            int tsm13 = 0;
                                            int tsm14 = 0;
                                            int tsm15 = 0;
                                            int tsm21 = 0;
                                            int tsm22 = 0;
                                            int tsm23 = 0;
                                            int tsm24 = 0;
                                            int tsm25 = 0;
                                            int tsm31 = 0;
                                            int tsm32 = 0;
                                            int tsm33 = 0;
                                            int tsm34 = 0;
                                            int tsm35 = 0;


                                            if (identifier == 1){
                                                cTransaksi br = null;
                                                System.out.println("\nDaftar Barang:");
                                                System.out.println("Barang\t\t\tHarga");
                                                System.out.println("-----------------------------");
                                                System.out.println("1. Indomie\t\t" + brg1.getHarga());
                                                System.out.println("2. Beras\t\t"+ brg2.getHarga()) ;
                                                System.out.println("3. Gula\t\t\t"+ brg3.getHarga());
                                                System.out.println("4. Minyak\t\t"+ brg4.getHarga());
                                                System.out.println("5. Susu\t\t\t"+ brg5.getHarga());
                                            System.out.print("Pilih = ");
                                            pilih3 = sc.nextInt();
                                            System.out.print("Jumlah = ");
                                            jumlah = sc.nextInt();
                                            if (pilih3 == 1) {
                                                br = new cTransaksi(String.valueOf(kode), String.valueOf(user),  brg1, jumlah, 0);
                                                 tsm11 = (brg1.getHarga()*jumlah);
                                                pbar1 = pbar1 + tsm11;
                                            } else if (pilih3 == 2) {
                                                br = new cTransaksi(String.valueOf(kode), String.valueOf(user), brg2, jumlah, 0);
                                                 tsm12 = (brg2.getHarga()*jumlah);
                                                pbar2 = pbar2 + tsm12;
                                            } else if (pilih3 == 3) {
                                                br = new cTransaksi(String.valueOf(kode), String.valueOf(user), brg3, jumlah, 0);
                                                 tsm13 = (brg3.getHarga()*jumlah);
                                                pbar3 = pbar3 + tsm13;
                                            } else if (pilih3 == 4) {
                                                br = new cTransaksi(String.valueOf(kode), String.valueOf(user), brg4, jumlah, 0);
                                                 tsm14 = (brg4.getHarga()*jumlah);
                                                pbar4 = pbar4 + tsm14;
                                            } else if (pilih3 == 5) {
                                                br = new cTransaksi(String.valueOf(kode), String.valueOf(user), brg5, jumlah, 0);
                                                 tsm15 = (brg5.getHarga()*jumlah);
                                                pbar5 = pbar5 + tsm15;
                                            }
                                            beli.tambahTransaksi(br);
                                            pmem1 = (tsm11 + tsm12 +tsm13 + tsm14 + tsm15);
                                            break;
                                            } 
                                            else if (identifier==2){
                                            cTransaksi br = null;
                                                System.out.println("\nDaftar Barang:");
                                                System.out.println("Barang\t\t\tHarga");
                                                System.out.println("-----------------------------");
                                                System.out.println("1. Indomie\t\t" + brg1.getHarga());
                                                System.out.println("2. Beras\t\t"+ brg2.getHarga()) ;
                                                System.out.println("3. Gula\t\t\t"+ brg3.getHarga());
                                                System.out.println("4. Minyak\t\t"+ brg4.getHarga());
                                                System.out.println("5. Susu\t\t\t"+ brg5.getHarga());
                                            System.out.print("Pilih = ");
                                            pilih3 = sc.nextInt();
                                            System.out.print("Jumlah = ");
                                            jumlah = sc.nextInt();
                                            if (pilih3 == 1) {
                                                br = new cTransaksi(String.valueOf(kode), String.valueOf(user),  brg1, jumlah, 0);
                                                 tsm21 = (brg1.getHarga()*jumlah);
                                                pbar1 = pbar1 + tsm21;
                                            } else if (pilih3 == 2) {
                                                br = new cTransaksi(String.valueOf(kode), String.valueOf(user), brg2, jumlah, 0);
                                                 tsm22 = (brg2.getHarga()*jumlah);
                                                pbar2 = pbar2 + tsm22;
                                            } else if (pilih3 == 3) {
                                                br = new cTransaksi(String.valueOf(kode), String.valueOf(user), brg3, jumlah, 0);
                                                 tsm23 = (brg3.getHarga()*jumlah);
                                                pbar3 = pbar3 + tsm23;
                                            } else if (pilih3 == 4) {
                                                br = new cTransaksi(String.valueOf(kode), String.valueOf(user), brg4, jumlah, 0);
                                                 tsm24 = (brg4.getHarga()*jumlah);
                                                pbar4 = pbar4 + tsm24;
                                            } else if (pilih3 == 5) {
                                                br = new cTransaksi(String.valueOf(kode), String.valueOf(user), brg5, jumlah, 0);
                                                 tsm25 = (brg5.getHarga()*jumlah);
                                                pbar5 = pbar5 + tsm25;
                                            }
                                            beli.tambahTransaksi(br);
                                            pmem2 = (tsm21 + tsm22 +tsm23 + tsm24 + tsm25);
                                            break;

                                            }
                                            else if (identifier == 3){
                                            cTransaksi br = null;
                                                System.out.println("\nDaftar Barang:");
                                                System.out.println("Barang\t\t\tHarga");
                                                System.out.println("-----------------------------");
                                                System.out.println("1. Indomie\t\t" + brg1.getHarga());
                                                System.out.println("2. Beras\t\t"+ brg2.getHarga()) ;
                                                System.out.println("3. Gula\t\t\t"+ brg3.getHarga());
                                                System.out.println("4. Minyak\t\t"+ brg4.getHarga());
                                                System.out.println("5. Susu\t\t\t"+ brg5.getHarga());
                                            System.out.print("Pilih = ");
                                            pilih3 = sc.nextInt();
                                            System.out.print("Jumlah = ");
                                            jumlah = sc.nextInt();
                                            if (pilih3 == 1) {
                                                br = new cTransaksi(String.valueOf(kode), String.valueOf(user),  brg1, jumlah, 0);
                                                 tsm31 = (brg1.getHarga()*jumlah);
                                                pbar1 = pbar1 + tsm31;
                                            } else if (pilih3 == 2) {
                                                br = new cTransaksi(String.valueOf(kode), String.valueOf(user), brg2, jumlah, 0);
                                                 tsm32 = (brg2.getHarga()*jumlah);
                                                pbar2 = pbar2 + tsm32;
                                            } else if (pilih3 == 3) {
                                                br = new cTransaksi(String.valueOf(kode), String.valueOf(user), brg3, jumlah, 0);
                                                 tsm33 = (brg3.getHarga()*jumlah);
                                                pbar3 = pbar3 + tsm33;
                                            } else if (pilih3 == 4) {
                                                br = new cTransaksi(String.valueOf(kode), String.valueOf(user), brg4, jumlah, 0);
                                                 tsm34 = (brg4.getHarga()*jumlah);
                                                pbar4 = pbar4 + tsm34;
                                            } else if (pilih3 == 5) {
                                                br = new cTransaksi(String.valueOf(kode), String.valueOf(user), brg5, jumlah, 0);
                                                 tsm35 = (brg5.getHarga()*jumlah);
                                                pbar5 = pbar5 + tsm35;
                                            }
                                            beli.tambahTransaksi(br);
                                            pmem3 = (tsm31 + tsm32 +tsm33 + tsm34 + tsm35);
                                            break;


                                            }
                                            
                                        case 2:
                                            beli.lihatTransaksi();
                                            System.out.println("Hapus Nomor = ");
                                            int hapus = sc.nextInt();
                                            beli.hapusTransaksi(hapus);
                                            break;
                                        case 3:
                                            beli.lihatTransaksiMember();
                                            break;
                                        case 4:
                                            jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                            break;
                                    }
                                } while (pilih2 != 4);
                            } else if (pilih4 == 2) {
                                System.out.println("\n== Menu Ganti Password ==");
                                System.out.print("Masukan Pass Baru :");
                                String sandibaru = sc.next();

                                if (identifier == 1) {
                                    mem1.setPass(sandibaru);
                                } else if (identifier == 2) {
                                    mem2.setPass(sandibaru);
                                } else if (identifier == 3) {
                                    mem3.setPass(sandibaru);
                                } else {
                                System.out.println("Password Tidak Cocok");
                                }
        
                            } else {

                            }
                        } while (pilih4 != 3);
                    } 
                    break;
                case 3:
                int pwadmin;
                String useradmin;
                    //Admin
                    do {
                        System.out.println("\n== Menu Admin ==");
                        System.out.print("Masukkan Username Admin :");
                        useradmin = sc.next();
                        System.out.print("Masukkan Password Admin :");
                        pwadmin = sc.nextInt();

                        if(pwadmin != 123 ){
                            System.out.println("Akun Admin salah!");
                        }
                        
                    }while (useradmin != "admin" && pwadmin !=123);


                    System.out.println("\n== Akun Admin ==");
                    jual.lihatTransaksi();
                    cTransaksi t = jual.getFront();
                    do{
                        if (t.getStatus()==0){
                            System.out.println("\n-Proses Transaksi-");
                            System.out.println("Kode :"+t.getKode());
                            System.out.println("Pembeli :"+t.getPembeli());
                            System.out.println("Barang : "+t.getBarang().getNama());
                            System.out.println("Jumlah : "+t.getJumlah());
                            System.out.println("Pilih Aksi :");
                            System.out.println("1. Diproses");
                            System.out.println("2. Selesai");
                            System.out.print("Pilih : ");
                            int aksi = sc.nextInt();
                            switch (aksi){
                                case 1 : 
                                jual.prosesTransaksi(t);
                                System.out.println("\n"+t.getBarang().getNama()+"Sudah Di Proses");
                                break;
                                case 2 : 
                                jual.lihatTransaksi();
                                case 3 :
                                break;
                            }
                        
                            if (aksi == 1){
                                jual.prosesTransaksi(t);
                                System.out.println("\nBerhasil Diproses...");
                            }
                            else {
                                break;
                            }
                        }
                        t = t.next;
                    }while (t!=null);
                    break;
                case 4:
                    String userpemilik;
                    int pwpemilik;
                    do {
                        System.out.println("\n== Menu Pemilik ==");
                        System.out.print("Masukkan Username Pemilik :");
                        userpemilik = sc.next();
                        System.out.print("Masukkan Password Pemilik :");
                        pwpemilik = sc.nextInt();

                        if(pwpemilik != 123 ){
                            System.out.println("Akun Admin salah!");
                        }

                    }while (userpemilik != "pemilik" && pwpemilik !=123);


                    System.out.println("\n== MENU PEMILIK ==");
                    System.out.println("1. Update Harga Barang");
                    System.out.println("2. Lihat Transaksi Belum Di Proses");
                    System.out.println("3. Lihat Transaksi Sudah di Proses");
                    System.out.println("4. Total Transaksi Seluruh");
                    System.out.println("5. Total Transaksi Member");
                    System.out.println("6. Grafik Penjualan ");
                    System.out.println("7. Tampilkan Daftar Menu");
                    System.out.println("8. Keluar");
                    System.out.print("Pilih : ");
                    pilih5 = sc.nextInt();
                    switch(pilih5){
                        case 1:
                            System.out.println("\n Update Harga Barang");
                            System.out.print("Nama Barang : ");
                            String cari = sc.next();
                        if (brg1.getNama().equalsIgnoreCase(cari)){
                                System.out.print("Masukkan Harga Baru = ");
                                int hrgbru = sc.nextInt();
                            brg1.setHarga(hrgbru);
                                                                        }
                        else if (brg2.getNama().equalsIgnoreCase(cari)){
                                System.out.print("Masukkan Harga Baru = ");
                                int hrgbru = sc.nextInt();
                            brg2.setHarga(hrgbru);
                                                                        }
                        else if (brg3.getNama().equalsIgnoreCase(cari)){
                            System.out.print("Masukkan Harga Baru = ");
                            int hrgbru = sc.nextInt();
                            brg3.setHarga(hrgbru);
                                                                        }
                        else if (brg4.getNama().equalsIgnoreCase(cari)){
                            System.out.print("Masukkan Harga Baru = ");
                            int hrgbru = sc.nextInt();
                            brg4.setHarga(hrgbru);
                                                                        }
                        else if (brg5.getNama().equalsIgnoreCase(cari)){
                            System.out.print("Masukkan Harga Baru = ");
                            int hrgbru = sc.nextInt();
                            brg5.setHarga(hrgbru);
                                                                        }
                            break;
                        case 2:
                            jual.lihatDiproses();
                            System.out.println("Transaksi Belum Di Proses :" + jual.getblmProses());
                            break;
                        case 3:
                            System.out.println("Transaksi Sudah Di Proses :"+jual.lihatDiproses());
                            System.out.println("Total Pemasukan :"+jual.lihatPemasukan());
                            break;
                        case 4:
                        System.out.println("\n== Menampilkan Total Barang ==");
                        System.out.println("Indomie = "+pbar1);
                        System.out.println("Beras   = "+pbar2);
                        System.out.println("Gula    = "+pbar3);
                        System.out.println("Minyak  = "+pbar4);
                        System.out.println("Susu    = "+pbar5);
                            break;
                        case 5:
                            System.out.println("\n== Total Belanja Member ==");
                        System.out.println("Fathur = " + pmem1);
                        System.out.println("Hadyan = " + pmem2);
                        System.out.println("Ismi   = " + pmem3);
                            break;
                        case 6:

                            System.out.println("\n== Grafik Penjualan ==");
                            System.out.print("Indomie = ");
                            for (int a = 10000; a <= pbar1 ;) {
                                System.out.print("X");
                                a= a + 10000;
                            }
                            System.out.print("-"+pbar1);
                            System.out.println("");

                            System.out.print("Beras   = ");
                            for (int a = 10000; a <= pbar2 ;) {
                                System.out.print("X");
                                a= a + 10000;
                            }
                            System.out.print("-"+pbar2);
                            System.out.println("");
                            System.out.print("Gula    = ");
                            for (int a = 10000; a <= pbar3 ;) {
                                System.out.print("X");
                                a= a + 10000;
                            }
                            System.out.print("-"+pbar3);
                            System.out.println("");
                            System.out.print("Minyak  = ");
                            for (int a = 10000; a <= pbar4 ;) {
                                System.out.print("X");
                                a= a + 10000;
                            }
                            System.out.print("-"+pbar4);
                            System.out.println("");
                            System.out.print("Susu    = ");
                            for (int a = 10000; a <= pbar5 ;) {
                                System.out.print("X");
                                a= a + 10000;
                            }
                            System.out.print("-"+pbar5);
                            System.out.println("");
                            break;
                        case 7:
                            int pilih9;
                            do {
                                System.out.println("\nDaftar Barang:");
                                System.out.println("Barang\t\t\tHarga");
                                System.out.println("-----------------------------");
                                System.out.println("1. Indomie\t\t" + brg1.getHarga());
                                System.out.println("2. Beras\t\t" + brg2.getHarga());
                                System.out.println("3. Gula\t\t\t" + brg3.getHarga());
                                System.out.println("4. Minyak\t\t" + brg4.getHarga());
                                System.out.println("5. Susu\t\t\t" + brg5.getHarga());
                                System.out.println("6. Keluar");
                                System.out.print("Pilih");
                                pilih9 = sc.nextInt();
                            }while(pilih9 != 6);

                            break;
                        case 8 :
                            System.out.println("\n ===Terima Kasih===");
                            break;
                    }
                case 5:
                    break;
            }
        }while (pilih!=5);
    }
}

