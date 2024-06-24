package animals;

public class Cat extends Animal {
    public final static int runRangeMax = 200; // Ограничение на бег для кота
    static int cnt = 0; // Счетчик для подсчета котов
    public boolean satiety; // Сытость кота
    public int gluttony; // Количество еды, необходимое коту, чтобы стать сытым

    // Класс миски с едой вложенный, т. к. кормим только котов
    public static class Feeder {
        private int feed; // Количество еды в миске

        // Метод для пополнения миски на n еды
        public void fillFeeder(int n) {
            feed = feed + n;
        }

        // Конструктор для создания уже наполненной едой миски
        public Feeder(int feed) {
            this.feed = feed;
        }
    }

    public Cat() {
        cnt++; // Увел. значение на счётчике созданных котов
        this.satiety = false; // Коты создаются голодными
        this.gluttony = (int) ((Math.random() * 9) + 1); // Рандомно устанавливаем прожорливость кота от 1 до 10
    }

    @Override
    public void swim(int range) {
        super.swim(range);
        System.out.println("Кот не умеет плавать");
    }

    @Override
    public void run(int range) {
        super.run(range);
        if (range <= runRangeMax) {
            // Если дистанция <= максимальной, то всё успешно
            System.out.println("Кот пробежал " + range + " метров.");
        } else {
            // Иначе - превышение ограничения
            System.out.println("Дистанция слишком большая. " + range + " > " + runRangeMax);
        }
    }

    public void feedCat(Feeder feeder){
        // Проверка на сытость кота
        if (this.satiety) {
            System.out.println("Кот сыт, количество еды в миске не изменилось.");
        }

        // Если для кота в миске достаточно еды
        if (feeder.feed >= this.gluttony) {
            feeder.feed -= this.gluttony; // Уменьшаем количество еды в миске
            this.satiety = true; // Кот теперь сыт
            System.out.print("Кот теперь сыт. ");
        } else {
            System.out.print("Коту не хватило еды. ");
        }
        System.out.println("В миске осталось " + feeder.feed + " еды.");
    }

    @Override
    public String toString() {
        return "Кот [" +
                "сыт: " + satiety +
                ", прожорливость: " + gluttony +
                ']';
    }
}