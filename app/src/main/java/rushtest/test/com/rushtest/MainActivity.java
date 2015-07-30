package rushtest.test.com.rushtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import co.uk.rushorm.core.RushSearch;
import rushtest.test.com.rushtest.objects.W;
import rushtest.test.com.rushtest.objects.E;
import rushtest.test.com.rushtest.objects.C;
import rushtest.test.com.rushtest.objects.P;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        C objC = new C("objC");
        objC.save();

        C objC2 = new C("objC2");
        objC2.save();


        E objE = new E("objE", Arrays.asList(new RushSearch().whereEqual("name", "objC").findSingle(C.class),
                                             new RushSearch().whereEqual("name", "objC2").findSingle(C.class))
        );
        objE.save();

        P objP = new P(Arrays.asList(new RushSearch().whereEqual("name", "objE").findSingle(E.class),
                new RushSearch().whereEqual("name", "objE").findSingle(E.class),
                new RushSearch().whereEqual("name", "objE").findSingle(E.class)));
        objP.save();

        W objA = new W(new RushSearch().findSingle(P.class));
        objA.save();

        objA.setName("test1");
        objA.save();

        objA.setName("test2");
        objA.save();

        objA.setName("test2");
        objA.save();


        List<E> list = new RushSearch().find(E.class);
        for (E c : list) {

            // Actual 6, should be 3
            Log.e("Tag", String.valueOf(c.list.size()));
        }


    }

}
