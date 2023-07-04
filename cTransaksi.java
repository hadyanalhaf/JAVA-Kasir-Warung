package pakcahyo2022;

public class cTransaksi {
    String kode;
    String pembeli;
    cBarang barang;
    int jumlahbrg;
    int status;
    cTransaksi next;
    cTransaksi (String k, String p, cBarang b, int jumlah, int s){
        kode = k; pembeli = p; barang = b; jumlahbrg = jumlah; status = s;
        next = null;
    }
    public void setStatus (int s){ // untuk melihat transaksi diproses atau tidak
        status = s;
    }
    public String getKode (){
        return kode;
    }
    public String getPembeli (){
        return pembeli;
    }
    public cBarang getBarang (){
        return barang;
    }
    public int getJumlah (){ //Diperlukan saat perhitungan jumlah total --> Jum x harga
        return jumlahbrg;
    }
    public int getStatus(){
        return status;
    }
}
