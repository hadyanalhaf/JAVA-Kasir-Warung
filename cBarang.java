package pakcahyo2022;

public class cBarang {
    String nama;
    int harga;

    public cBarang(String n, int h) {
        nama = n;
        harga = h;
    }
    public String getNama(){
        return nama;
    }
    public int getHarga(){
        return harga;
    }


    public void setHarga(int x) {
        harga = x;
    }
}
