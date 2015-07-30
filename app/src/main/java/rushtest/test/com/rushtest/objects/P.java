package rushtest.test.com.rushtest.objects;

import java.util.ArrayList;
import java.util.List;

import co.uk.rushorm.core.RushObject;
import co.uk.rushorm.core.annotations.RushList;

/**
 * Created by Nickolay Moskalenko on 7/29/15.
 */
public class P extends RushObject {

    private String name;

    @RushList(classType = E.class)
    public List<E> list = new ArrayList<>();

    public P() {
    }

    public P(List<E> list) {
        this.list = list;
    }

    public void setName(String name) {
        this.name = name;
    }
}
