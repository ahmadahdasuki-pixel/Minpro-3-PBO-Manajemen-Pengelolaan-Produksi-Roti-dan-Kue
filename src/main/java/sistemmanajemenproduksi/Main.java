package sistemmanajemenproduksi;

import java.util.ArrayList;
import java.util.Scanner;
import sistemmanajemenproduksi.model.Produk;
import sistemmanajemenproduksi.controller.ManajemenSistem;
import sistemmanajemenproduksi.model.Roti;
import sistemmanajemenproduksi.model.Kue;
import sistemmanajemenproduksi.view.View;

public class Main {

    public static void main(String[] args) {
        View view = new View();
        ManajemenSistem controller = new ManajemenSistem(view);
        view.jalankanMenu(controller);
        view.tutupScanner();
    }
}
