package algorithms.dynamic_programming.TowerOfHanoi;

public class TowersOfHanoi {
    public Tower[] MoveDisks(Tower[] towers, int n) {
        towers[0].moveDisks(n, towers[2], towers[1]);
        return towers;
    }

    public Tower[] GenerateTowers(int n) {
        Tower[] towers = new Tower[n];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }
        for (int i = (n-1); i >= 0; i--) {
            towers[0].add(i);
        }
        return towers;
    }
}