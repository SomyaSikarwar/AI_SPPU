public class Main {
    public static void main(String[] args) {

        logic obj =  new logic();


            int n;
            int[][] matt = {
                    { -1, 10, 15, 20 },
                    { 10, -1, 35, 25 },
                    { 15, 35, -1, 30 },
                    { 20, 25, 30, -1 }
            };



        obj.tsp(matt , 0);

    }
}