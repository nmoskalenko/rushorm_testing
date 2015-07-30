package rushtest.test.com.rushtest.objects;

import java.util.ArrayList;
import java.util.List;

import co.uk.rushorm.core.RushObject;
import co.uk.rushorm.core.annotations.RushList;

/**
 * Created by Nickolay Moskalenko on 7/29/15.
 */
public class E extends RushObject {

    public String name;

    @RushList(classType = C.class)
    public List<C> list = new ArrayList<>();

    public E() {
    }

    public E(String name, List<C> list) {
        this.name = name;
        this.list = list;
    }
}
