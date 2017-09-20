package fizz2d.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scott Davey on 20/09/2017.
 */
public class BarrierManager {
    private List<Barrier> barriers;

    public BarrierManager() {
        barriers = new ArrayList<Barrier>();
    }

    public void addBarrier(int x, int y) {

    }

    public void addBarrier(int x, int y, int e) {

    }

    public List<Barrier> getBarriers() {
        return barriers;
    }
}
