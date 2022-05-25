import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Character character = null;
        Titan enemy = new Titan();

        System.out.println("Selamat datang di game Defend FILKOM");
        System.out.print("Silahkan masukkan nama player : ");
        String playerName = inp.nextLine();

        boolean lanjut = true;

        while (lanjut) {
            System.out.println("Silahkan pilih karakter yang anda inginkan");
            System.out.println("1. Magician\n2. Healer\n3. Warrior");
            try {
                int pilihan = inp.nextInt();
                switch (pilihan) {
                    case 1:
                        character = new Magician();
                        break;
                    case 2:
                        character = new Healer();
                        break;
                    case 3:
                        character = new Warrior();
                        break;
                    default:
                        throw new ClassNotFoundException();
                }

                System.out.println("Selamat Datang " + playerName);
                character.info();

                int turn = 1;

                // Selama karakter dan musuh masih punya nyawa, maka saling serang
                while (character.getHP() > 0 && enemy.getHP() > 0) {
                    System.out.println("======== TURN " + turn + " =========");
                    // setiap dua turn kalau healer, dia kena heal
                    if(turn % 2 == 0  && character instanceof Healer){
                        System.out.println("Menggunakan skill heal");
                        ((Healer)character).heal();
                    }
                    System.out.println("Enemy's HP : " + enemy.getHP());
                    System.out.println(playerName + "'s HP : " + character.getHP());
                    // Aksi saling attack
                    if (character.attack()) {
                        enemy.receiveDamage(character.getAttack());
                    }
                    if (enemy.attack()) {
                        character.receiveDamage(enemy.getAttack());
                    }
                    System.out.println("=========================");
                    turn++;
                }

                // Game Over
                System.out.println(character.getHP() > enemy.getHP() ? playerName + " Menang" : "Enemy Menang");
                System.out.println("\n====== PLAYER ======");
                character.info();
                System.out.println("\n====== MUSUH ======");
                enemy.info();
                lanjut = false;
            } catch (InputMismatchException err) {
                System.out.println("Tolong masukkan angka");
                inp.nextLine();
            } catch (ClassNotFoundException err) {
                System.out.println("Karakter tidak ditemukan");
            }
        }
    }
}
