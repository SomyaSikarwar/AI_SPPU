public class Main {
    public static void main(String[] args){
        int n = 3; // Number of disks

        hanoihanoi hanoi = new hanoihanoi();

        Tower source = new Tower('A'); // Source tower
        Tower destination = new Tower('C'); // Destination tower
        Tower auxiliary = new Tower('B'); // Auxiliary tower

        // Initialize source tower with disks
        for (int i = n; i >= 1; i--) {
            source.pushDisk(i);
        }

        System.out.println("Initial State:");
        hanoi.printTowers(source, destination, auxiliary);

        System.out.println("Steps to solve Tower of Hanoi problem with " + n + " disks:");
        hanoi.towerOfHanoi(n, source, destination, auxiliary);
    }
}
