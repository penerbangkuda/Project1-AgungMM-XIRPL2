/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author laptop
 */
public class MainAplikasiKasir {
    
    public DaftarMenu daftarMenu;
    //Tambahkan
    public static double PAJAK_PPN = 0.10;
    public static double BIAYA_SERVICE = 0.05;
    //End Of Tambahkan
    
    public static void main(String [] args) { 
        //init
        Scanner input = new Scanner(System.in);
        //Tambahkan
        String no_transaksi, nama_pemesanan, tanggal, no_meja = "";
        String transaksi_lagi = "", pesan_lagi = "", keterangan = "", makan_ditempat;
        int jumlah_pesanan, no_menu;
        //End of Tambahkan    
        
        app.generateDaftarMenu();
        
        //mulai transaksi
        System.out.println("========== TRANSAKSI ==========");
        
        //ambil data transaksi
         System.out.print("No Transaksi : ");
            no_transaksi = input.next();
            System.out.print("Pemesan : ");
            nama_pemesanan = input.next();
            System.out.print("Tanggal : [dd-mm-yyyy] ");
            tanggal = input.next();
            System.out.print("Makan ditempat? [Y?N] ");
            makan_ditempat = input.next();

            if (makan_ditempat.equalsIgnoreCase("Y")) {
                System.out.print("Nomor Meja : ");
                no_meja = input.next();
    }
             //tambah
    private double biayaService=0;

    public Transaksi(String no_transaksi, String nm_pemesan, String tanggal, String no_meja) {
        this.noTransaksi = no_transaksi;
        this.namaPemesanan = nm_pemesan;
        this.tanggal= tanggal;
        this.noMeja = no_meja;

        pesanan = new ArrayList<>();
    }
    public void tambahPesanan(Pesanan pesanan) {
        this.pesanan.add(pesanan);
    }

    public ArrayList<Pesanan> getSemuaPesanan(){
        return pesanan;
    }
    // cek jika meja kosong berarti take away
    public void cetakStruk(){
        System.out.println("\n======== ICHIRAKU RAMEN ========");
        System.out.println("No Transaksi : "+noTransaksi);
        System.out.println("Pemesan : "+namaPemesanan);
        System.out.println("Tanggal :"+tanggal);

        //cek jika nomor meja kosong, berarti take away
        if (noMeja.equals("")){
            noMeja = "Take Away";
        }

        System.out.println("Meja : "+noMeja);
        System.out.println("==============================");
        for (int i = 0; i < pesanan.size(); i++) {
            Pesanan psn = pesanan.get(i);
            Menu m = psn.getMenu();
            String pesanan = psn.getJumlah() + " " + m.getNama_menu() + "\t" + (m.getHarga()*psn.getJumlah());

            //jika pesanan kuah, tambah spasi di awal 2
            if (m.getKategori().equals("Kuah")) {
                pesanan = " "+pesanan;
            }
            //tampilkan pesanan
            System.out.println(pesanan);
        }
    }
    public void setBiayaService(double service){
        this.biayaService = service;
    }
    public void setPajak(double pajak){
        this.pajak = pajak;
    }
    public double hitungTotalPesanan(){

        for (int i = 0; i < pesanan.size(); i++){
            Pesanan psn = pesanan.get(i);
            double harga = psn.getMenu().getHarga();
            totalBayar += (harga * psn.getJumlah());
        }
        return totalBayar;

    }

    public double hitungPajak(){
        return totalBayar * pajak;
    }

    public double hitungBiayaService(){
        return totalBayar * biayaService;
    }

    public double hitungTotalBayar(double pajak, double service){
        totalBayar = totalBayar + pajak + service;
        return totalBayar;
    }

    public double hitungKembalian(double uang_bayar){
        return uang_bayar - totalBayar;//bisa dibuat validator
    }
    public void generateDaftarMenu() {
     daftarMenu = new DaftarMenu();
        daftarMenu.tambahMenu(new Ramen("Ramen Seafood", 25000));
        daftarMenu.tambahMenu(new Ramen("Ramen Original", 18000));
        daftarMenu.tambahMenu(new Ramen("Ramen Vegetarian", 22000));
        daftarMenu.tambahMenu(new Ramen("Ramen Karnivor", 28000));
        daftarMenu.tambahMenu(new Kuah("Kuah Original "));
        daftarMenu.tambahMenu(new Kuah("Kuah Internasional"));
        daftarMenu.tambahMenu(new Kuah("Kuah Spicy Lada"));
        daftarMenu.tambahMenu(new Kuah("Kuah Soto Padang"));
        daftarMenu.tambahMenu(new Toping("Crab Stick Bakar", 6000));
        daftarMenu.tambahMenu(new Toping("Chicken Katsu", 8000));
        daftarMenu.tambahMenu(new Toping("Gyoza Goreng", 4000));
        daftarMenu.tambahMenu(new Toping("Bakso Goreng", 7000));
        daftarMenu.tambahMenu(new Toping("Enoki Goreng", 5000));
        daftarMenu.tambahMenu(new Minuman("Jus Alpukat SPC", 10000));
        daftarMenu.tambahMenu(new Minuman("Jus Stroberi", 11000));
        daftarMenu.tambahMenu(new Minuman("Capucino Coffee", 15000));
        daftarMenu.tambahMenu(new Minuman("Vietnam Dripp", 14000));

        daftarMenu.tampilDaftarMenu();
    }
}
