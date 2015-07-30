package rushtest.test.com.rushtest.objects;

import co.uk.rushorm.core.RushObject;
import co.uk.rushorm.core.annotations.RushDisableAutodelete;

/**
 * Created by Nickolay Moskalenko on 7/29/15.
 */
public class WE extends RushObject {

    @RushDisableAutodelete
    public E c;

    public WE(E c) {
        this.c = c;
    }
}
