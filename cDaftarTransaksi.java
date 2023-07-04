package pakcahyo2022;

public class cDaftarTransaksi {
    cTransaksi front, rear;
    int jumlah;
    int blmProses;
    double nominal;
    cDaftarTransaksi (){
        front = rear = null;
        jumlah = 0;
    }
    public cTransaksi getFront(){
        return front;
    }
    public cTransaksi getRear(){
        return rear;
    }
    public void tambahTransaksi (cTransaksi baru){
        if (rear == null){
            front = rear = baru;
        }
        else {
            rear.next = baru;
            rear=baru;
        }
        System.out.println("Penambahan Sukses...");
    }
    public void lihatTransaksi (){
        int i=1;
        System.out.println("Daftar Transaksi:");
        System.out.println("No\tKode\tNama\tBarang\t\tJumlah\tStatus");
        System.out.println("---------------------------------------------");
        for (cTransaksi t=front; t!=null; t=t.next){
            System.out.print(i+".\t");
            System.out.print("0"+t.getKode()+"\t\t");
            System.out.print(t.getPembeli()+"\t");
            System.out.print(t.getBarang().getNama()+"\t\t");
            System.out.print(t.getJumlah()+"\t\t");
            System.out.println(t.getStatus()+"");
            i++;
        }
    }
    public void lihatTransaksiMember (){
        int i=1;
        double total = 0;
        System.out.println("\n Daftar Transaksi Member: ");
        for (cTransaksi t=front; t!=null; t=t.next){
            System.out.print(i+".");
            System.out.print(t.getKode()+"-");
            System.out.print(t.getPembeli()+"-");
            System.out.print(t.getBarang().getNama()+"-");
            System.out.print(t.getJumlah()+"-");
            System.out.println(t.getStatus()+"");
            i++;
            total = total + (t.getBarang().getHarga()*t.getJumlah());
        }
        System.out.println("Total Belanja: "+total);
        System.out.println("Diskon       : "+(0.05 * total));
        System.out.println("Biaya        : "+(total - (0.05*total)));
    }
    public void hapusTransaksi (int nomor){
        cTransaksi t = front;
        cTransaksi prev = null;
        int i = 1;
        if (nomor ==1){ // Dihapus nomer 1
            if (t.next == null){
                front = rear = null;
            }
            else {
                front = front.next;
                t.next = null;
            }
            System.out.println("["+t.getBarang().getNama()+"] dihapus");
        }
        if (nomor > 1 && t.next != null) {
            for (;t != null;t=t.next){
                if (i == nomor){
                    break;
                }
                i++;
                prev = t;
            }
            if (t.next == null){
                rear = prev;
                rear.next = null;
            } else {
                prev.next = t.next;
                t.next = null;
            }
            System.out.println("["+t.getBarang().getNama()+"] dihapus");
        }

    }
    public void sambungTransaksi (cTransaksi depan, cTransaksi belakang){
        if (rear == null){
            front = depan;
            rear  = belakang;
        }
        else {
            rear.next = depan;
            rear = belakang;
        }



    }
    public void prosesTransaksi (cTransaksi t){
        t.setStatus(1);
    }

    public int lihatDiproses () {
        cTransaksi t = front;
        int proses = 0; blmProses=0;
        for (;t!=null; t=t.next){
            if (t.getStatus() == 1){
                proses++;
            }
            else if (t.getStatus()==0){
                blmProses++;
            }
        } return proses;
    }
    public double lihatPemasukan (){
        cTransaksi t = front;
        nominal=0;
        for (;t!=null; t=t.next){
            if (t.getStatus() == 1) {
                nominal = nominal + t.getBarang().getHarga() * t.getJumlah();
                if (t.getPembeli().compareToIgnoreCase("10") == 0 || t.getPembeli().compareToIgnoreCase("11") == 0 || t.getPembeli().compareToIgnoreCase("12")== 0 ) {
                    nominal = nominal - (0.1*nominal);
                }
                ;

            }

        } return nominal;
    }

    public int getblmProses(){
        return blmProses;
    }
}
