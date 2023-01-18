package hu.ltk.sabianfanni.ui;

import ltk.sabianfanni.store.domain.SlimStoreRegister;
import ltk.sabianfanni.store.domain.StorePersistenceType;

import java.util.Scanner;

public class Ui {
    private Scanner scanner = new Scanner(System.in);
    private SlimStoreRegister storeRegister;

    public Ui(Scanner scanner, SlimStoreRegister storeRegister) {
        this.scanner = scanner;
        this.storeRegister = storeRegister;
    }

    public void run() {
        boolean isRunning = true;
        chooseStoreMode();
        String chosenStorageMode = scanner.next();
        storeRegister.setPersistanceType(chosenStorageMode.equals("m")
                ? StorePersistenceType.INMEMORY
                : StorePersistenceType.FILE);
        while (isRunning) {
            writeMenu();

            String command = scanner.next();
            switch (command.toLowerCase()) {
                case "l":
                    System.out.println("Add meg a termék nevét:");
                    String newItemName = scanner.next();
                    storeRegister.createProduct(newItemName);
                    break;

                case "f":
                    System.out.println("Add meg a termék nevét:");
                    String boughtItemName = scanner.next();
                    System.out.println("Add meg a darabszámot:");
                    String boughtItemNameQuantity = scanner.next();
                    storeRegister.buyProductItem(boughtItemName, Integer.parseInt(boughtItemNameQuantity));
                    break;

                case "v":
                    System.out.println("Add meg a vásárolni kívánt termék nevét:");
                    String soldItemName = scanner.next();
                    System.out.println("Add meg a darabszámot:");
                    String soldItemQuantity = scanner.next();
                    storeRegister.sellProductItem(soldItemName, Integer.parseInt(soldItemQuantity));
                    break;

                case "k":
                    System.out.println("Viszlát!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Érvénytelen parancs");
            }
        }
    }

    private void chooseStoreMode() {
        System.out.println(
                "Add meg az adat tárolási módot!\n" +
                        "Fajl alapú(f) vagy memória alapú (m):");
    }

    private void writeMenu() {
        System.out.println("Válassz tevékenységet!\n" +
                "Létrehozás (l), árufeltöltés (f), vásárlás (v), kilépés (k):");
    }
}
