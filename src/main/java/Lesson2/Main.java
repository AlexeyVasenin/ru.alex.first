package Lesson2;

public class Main {
    public static void main(String[] args) {
        Dog haske = new Dog("Bolto", "black", "Perm", "Alpha", "Omega", "Husky");
        String haskeName = haske.getName();
        String haskeColor = haske.getColor();
        String haskeAddress = haske.getAddress();
        String haskeMom = haske.getMom();
        String haskeDad = haske.getDad();
        String haskeBreed = haske.getBreed();

        System.out.println("Имя песы " + haskeName);
        System.out.println("Цвет песы " + haskeColor);
        System.out.println("Адрес " + haskeAddress);
        System.out.println("Мама родная " + haskeMom);
        System.out.println("Отец " + haskeDad);
        System.out.println("Порода " + haskeBreed);
    }


}
