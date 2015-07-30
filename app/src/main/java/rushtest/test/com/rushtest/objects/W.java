package rushtest.test.com.rushtest.objects;

import java.util.ArrayList;
import java.util.List;

import co.uk.rushorm.core.RushObject;
import co.uk.rushorm.core.annotations.RushDisableAutodelete;
import co.uk.rushorm.core.annotations.RushList;

/**
 * Created by Nickolay Moskalenko on 7/29/15.
 */
public class W extends RushObject {

    @RushDisableAutodelete
    private P objP;

    private String name;

    @RushList(classType = WE.class)
    public List<WE> list = new ArrayList<>();

    public W(P objP) {
        this.objP = objP;
        for(E c : objP.list) {
            list.add(new WE(c));
        }
    }

    public void setName(String name) {
        this.name = name;
        objP.setName(name);
        objP.save();
    }
}
