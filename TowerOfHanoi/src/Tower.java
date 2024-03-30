import java.util.Stack;

public class Tower {
    private char name;
    private Stack<Integer> disks;

    public Tower(char name) {
        this.name = name;
        this.disks = new Stack<>();
    }

    public void pushDisk(int disk) {
        disks.push(disk);
    }

    public int popDisk() {
        return disks.pop();
    }

    public boolean isEmpty() {
        return disks.isEmpty();
    }

    public char getName() {
        return name;
    }

    public void print() {
        System.out.print(name + ": ");
        for (int i = disks.size() - 1; i >= 0; i--) {
            System.out.print(disks.get(i) + " ");
        }
        System.out.println();
    }
}


