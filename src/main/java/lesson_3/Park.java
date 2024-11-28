package lesson_3;

/*
3 ЗАДАНИЕ
Создать класс Park с внутренним классом, с помощью объектов которого можно хранить
информацию об аттракционах, времени их работы и стоимости.*/
class Park {
    public static class Schedule {
        String attraction;
        String runtime;
        int cost;
        Schedule(String _attraction, String _runtime, int _cost) {
            this.attraction = _attraction;
            this.runtime = _runtime;
            this.cost = _cost;
        }

        //Доп. конструкторы
        Schedule(String _attraction, String _runtime) {
            this.attraction = _attraction;
            this.runtime = _runtime;
            this.cost = 0;
        }
        Schedule(String _attraction, int _cost) {
            this.attraction = _attraction;
            this.runtime = "Уточняется";
            this.cost = _cost;
        }
        Schedule(String _attraction) {
            this.attraction = _attraction;
            this.runtime = "Уточняется";
            this.cost = 0;
        }

        //Метод отображения информации
        public void scheduleInfo() {
            System.out.println("Аттракцион: " + attraction);
            System.out.println("Время работы: " + runtime);
            if (cost == 0) {
                System.out.println("Стоимость: Бесплатно");
            } else {
                System.out.println("Стоимость: " + cost + " рублей");
            }
            System.out.println();
        }
    }
}