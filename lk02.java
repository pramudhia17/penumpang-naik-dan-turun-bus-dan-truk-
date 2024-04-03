package tugasoemlan;

import java.util.Scanner;

class penumpang {
    private String nama;

    public penumpang(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return this.nama;
    }
}

class driver {
    private boolean noSimBus;
    private boolean noSimTruk;
    private String noSim;

    public driver(boolean noSimBus, boolean noSimTruk, String noSim) {
        this.noSimBus = noSimBus;
        this.noSimTruk = noSimTruk;
        this.noSim = noSim;
    }

    public boolean getNoSimBus() {
        return this.noSimBus;
    }

    public boolean getNoSimTruk() {
        return this.noSimTruk;
    }

    public String getNoSim() {
        return this.noSim;
    }
}

class kendaraan {
    public String merk;
    public String warna;
    public String platNomor;
    public int jumlahPenumpang;
    public int maxPenumpang;
    private penumpang[] daftarPenumpang;
    public driver supir;

    public kendaraan(String merk, String platNomor, int maxPenumpang, driver supir) {
        this.merk = merk;
        this.platNomor = platNomor;
        this.jumlahPenumpang = 0;
        this.maxPenumpang = maxPenumpang;
        this.daftarPenumpang = new penumpang[maxPenumpang];
        this.supir = supir;

        System.out.println("Halo saya objek dari kelas Kendaraan dengan plat nomor : " + this.platNomor);
        cekPenumpang();
    }

    public void cekPenumpang() {
        System.out.println("Penumpang saat ini: " + this.jumlahPenumpang);
    }

    public void penumpangNaik(int naik) {
        System.out.println("ada penumpang mau naik: " + naik);
        int current = this.jumlahPenumpang;
        if (current + naik > this.maxPenumpang) {
            System.out.println("maaf penumpang melebihi kapasitas");
        } else {
            this.jumlahPenumpang += naik;
            System.out.println("penumpang berhasil naik");
        }
        cekPenumpang();
    }

    public void penumpangTurun(int turun) {
        System.out.println("ada penumpang mau turun: " + turun);
        int current = this.jumlahPenumpang;
        if (current - turun < 0) {
            System.out.println("tidak ada penumpang saat ini");
        } else {
            this.jumlahPenumpang -= turun;
            System.out.println("penumpang berhasil turun");
        }
        cekPenumpang();
    }

    public void infoPenumpang() {
        System.out.println("Daftar Penumpang:");
        for (penumpang penumpang : daftarPenumpang) {
            if (penumpang != null) {
                System.out.println(penumpang.getNama());
            }
        }
    }

    public void maju() {
        System.out.println(this.merk + " " + this.platNomor + " Maju");
    }

    public void mundur() {
        System.out.println(this.merk + " " + this.platNomor + " Mundur");
    }

    public void belok() {
        System.out.println(this.merk + " " + this.platNomor + " Belok");
    }

    public void berhenti() {
        System.out.println(this.merk + " " + this.platNomor + " Berhenti");
    }
}

class Bus extends kendaraan {
    private boolean adaBasuri;

    public Bus(String merk, String platNomor, int maxPenumpang, boolean adaBasuri, driver supir) {
        super(merk, platNomor, maxPenumpang, supir);
        this.adaBasuri = adaBasuri;
    }

    public void penumpangNaik(int naik) {
        System.out.println("ada penumpang mau naik: " + naik);
        int current = this.jumlahPenumpang;
        if (current + naik > this.maxPenumpang) {
            System.out.println("maaf penumpang melebihi kapasitas");
        } else {
            this.jumlahPenumpang += naik;
            System.out.println("penumpang berhasil naik");

            if (adaBasuri) {
                System.out.println("basuri dibunyikan.");
            }
        }
        cekPenumpang();
    }

    public void infoDriver() {
        if (this.supir != null) {
            if (this.supir.getNoSimBus()) {
                System.out.println("Driver memiliki SIM Bus.");
            } else {
                System.out.println("Driver tidak memiliki SIM Bus.");
            }
        } else {
            System.out.println("Supir tidak diinisialisasi.");
        }
    }
}

class Truk extends kendaraan {
    private double muatanMaksimal;

    public Truk(String merk, String platNomor, int maxPenumpang, double muatanMaksimal, driver supir) {
        super(merk, platNomor, maxPenumpang, supir);
        this.muatanMaksimal = muatanMaksimal;
    }

    public void penumpangNaik(int naik) {
        System.out.println("ada penumpang mau naik: " + naik);
        int current = this.jumlahPenumpang;
        if (current + naik > this.maxPenumpang) {
            System.out.println("maaf penumpang melebihi kapasitas");
        } else {
            this.jumlahPenumpang += naik;
            System.out.println("penumpang berhasil naik");
        }
        cekPenumpang();
    }

    public void infoDriver() {
        if (this.supir != null) {
            if (this.supir.getNoSimTruk()) {
                System.out.println("Driver memiliki SIM Truk.");
            } else {
                System.out.println("Driver tidak memiliki SIM Truk.");
            }
        } else {
            System.out.println("Supir tidak diinisialisasi.");
        }
    }
}

public class lk02 {
    public static void main(String[] args) {
        int pilihan = 0;
        driver supir = new driver(true, false, "12345"); 
        Bus bus = new Bus("Mercedes", "N 1 GGA", 10, true, supir);
        Truk truk = new Truk("Hino", "T 08 RUT", 5, 2.0, supir);

        Scanner input = new Scanner(System.in);
        while (pilihan != 11) {

            System.out.println("Menu:");
            System.out.println("1. Naik");
            System.out.println("2. Turun");
            System.out.println("3. Cek Penumpang");
            System.out.println("4. Keluar");
            
           
            System.out.print("Pilih menu (masukkan angka): ");
            pilihan = input.nextInt();
            
          
            switch (pilihan) {
                case 1:
                    System.out.println("Berapa jumlah penumpang naik?");
                    System.out.print("(masukkan angka): ");
                    int naik = input.nextInt();
                    bus.penumpangNaik(naik);
                    break;
                case 2:
                    System.out.println("Berapa jumlah penumpang turun?");
                    System.out.print("(masukkan angka): ");
                    int turun = input.nextInt();
                    bus.penumpangTurun(turun);
                    break;
                case 3:
                    bus.cekPenumpang();
                    break;
                case 4:
                    System.out.println("Terima kasih. Program berhenti.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.");
            }
        }
    }
}
