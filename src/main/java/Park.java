// Задание 3
public class Park {

    public class Attraction {
        private String nameAttraction;
        private String workingTime;
        private double price;

        public Attraction(String nameAttraction, String workingTime, double price) {
            this.nameAttraction = nameAttraction;
            this.workingTime = workingTime;
            this.price = price;
        }


        public String getName() {
            return nameAttraction;
        }

        public void setName(String nameAttraction) {
            this.nameAttraction = nameAttraction;
        }

        public String getWorkingTime() {
            return workingTime;
        }

        public void setWorkingTime(String workingTime) {
            this.workingTime = workingTime;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
