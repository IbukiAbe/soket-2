public class DinnerFullCourse {
    private Dish[] list = new Dish[5]; // [0]-[4]の計5個
    private int sum;

    public DinnerFullCourse() {
        list[0] = new Dish();
        list[0].setName("前菜");
        list[0].setValue(500);

        list[1] = new Dish();
        list[1].setName("スープ");
        list[1].setValue(300);

        list[2] = new Dish();
        list[2].setName("メインディッシュ");
        list[2].setValue(1200);

        list[3] = new Dish();
        list[3].setName("サラダ");
        list[3].setValue(400);

        list[4] = new Dish();
        list[4].setName("デザート");
        list[4].setValue(600);


    }

    public void eatAll() {
        for (Dish dish : list) {
            System.out.println(dish.getName() + "は" + dish.getValue()+"円です");
            sum+=dish.getValue();
        }
        System.out.println("合計"+sum+"円です");
    }

    public static void main(String[] args) {
        DinnerFullCourse fullcourse = new DinnerFullCourse();
        fullcourse.eatAll();
    }

    
}
