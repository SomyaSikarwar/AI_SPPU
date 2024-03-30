public class hanoihanoi {
    public static void towerOfHanoi(int n, Tower source, Tower destination, Tower auxiliary) {
        if (n == 1) {
            int disk = source.popDisk();
            destination.pushDisk(disk);
            System.out.println("Move disk " + disk + " from " + source.getName() + " to " + destination.getName());
            printTowers(source, destination, auxiliary);
            return;
        }
        // Move top n-1 disks from source to auxiliary using destination as auxiliary
        towerOfHanoi(n-1, source, auxiliary, destination);
        // Move the remaining disk from source to destination
        int disk = source.popDisk();
        destination.pushDisk(disk);
        System.out.println("Move disk " + disk + " from " + source.getName() + " to " + destination.getName());
        printTowers(source, destination, auxiliary);
        // Move n-1 disks from auxiliary to destination using source as auxiliary
        towerOfHanoi(n-1, auxiliary, destination, source);
    }

    public static void printTowers(Tower source, Tower destination, Tower auxiliary) {
        source.print();
        destination.print();
        auxiliary.print();
        System.out.println("------");
    }
}
