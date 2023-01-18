import hu.ltk.sabianfanni.ui.Ui;
import ltk.sabianfanni.store.domain.SlimStoreRegister;


import java.util.Scanner;

public class UiMain {
    public static void main(String[] args) {
        Ui ui = new Ui(new Scanner(System.in), new SlimStoreRegister());
        ui.run();
    }
}
