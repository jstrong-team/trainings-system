package merger;

import com.exadel.jstrong.fortrainings.core.util.Merger;
import org.junit.Test;


public class MergerTest {

    @Test
    public void mergeTest() {
        String source = "This training is for Java. Developers and Java Beginners in company";
        String updated = "blah blah blah Developers blah blah";
//        String updated = "This training is for Java Developers and Java Beginners in company";

        System.out.println(Merger.merge(source, updated));
        //System.out.println(Merger.merge(updated, source));
    }
}
