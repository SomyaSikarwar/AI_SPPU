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
/****************************output******************************
    Initial State:
A: 1 2 3 
C: 
B: 
------
Steps to solve Tower of Hanoi problem with 3 disks:
Move disk 1 from A to C
A: 2 3 
C: 1 
B: 
------
Move disk 2 from A to B
A: 3 
B: 2 
C: 1 
------
Move disk 1 from C to B
C: 
B: 1 2 
A: 3 
------
Move disk 3 from A to C
A: 
C: 3 
B: 1 2 
------
Move disk 1 from B to A
B: 2 
A: 1 
C: 3 
------
Move disk 2 from B to C
B: 
C: 2 3 
A: 1 
------
Move disk 1 from A to C
A: 
C: 1 2 3 
B: 
------*/
