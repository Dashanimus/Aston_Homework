package animals;

public class Cat extends Animal {
    public final static int runRangeMax = 200;
    static int cnt = 0;
    public boolean satiety;
    public int gluttony;

    public static class Feeder {
        private int feed;

        public void fillFeeder(int n) {
            feed = feed + n;
        }

        public Feeder(int feed) {
            this.feed = feed;
        }
    }

    public Cat() {
        cnt++;
        this.satiety = false;
        this.gluttony = (int) ((Math.random() * 9) + 1);
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
            System.out.println("Кот пробежал " + range + " метров.");
        } else {
            System.out.println("Дистанция слишком большая. " + range + " > " + runRangeMax);
        }
    }

    public void feedCat(Feeder feeder){
        if (this.satiety) {
            System.out.println("Кот сыт, количество еды в миске не изменилось.");
        }

        if (feeder.feed >= this.gluttony) {
            feeder.feed -= this.gluttony;
            this.satiety = true;
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