package rushtest.test.com.rushtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Arrays;

import co.uk.rushorm.core.RushSearch;
import rushtest.test.com.rushtest.objects.C;
import rushtest.test.com.rushtest.objects.E;
import rushtest.test.com.rushtest.objects.P;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Create 2 different C objects and save it
        C objC = new C("objC");
        objC.save();

        C objC2 = new C("objC2");
        objC2.save();

       // Create E object with the list of 2 C objects
        E objE = new E("objE", Arrays.asList(new RushSearch().whereEqual("name", "objC").findSingle(C.class),
                                             new RushSearch().whereEqual("name", "objC2").findSingle(C.class))
        );
        objE.save();

        // Create P object with the list of SAME E objects
        // If we load E object once, and add to list, everything works OK
        // But if we load exactly the same object twice, problem occurs.
        P objP = new P(Arrays.asList(new RushSearch().whereEqual("name", "objE").findSingle(E.class),
                new RushSearch().whereEqual("name", "objE").findSingle(E.class)));

        // It seems here 2 exactly the same E objects are saving
        objP.save();


        // we have 4 objects here, expected 2
        long count = new RushSearch().count(C.class);
        Log.e("RUSH_TEST", String.valueOf(count));

    }

}
