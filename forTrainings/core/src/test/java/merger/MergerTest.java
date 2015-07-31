package merger;

import com.exadel.jstrong.fortrainings.core.util.Merger;
import org.junit.Test;

/**
 * Created by Sergey Nalivko.
 */
public class MergerTest {

    @Test
    public void mergeTest() {
        String source = "This training is for Java Developers and Java Beginners in company";
        String updated = "This special training course is for Java Developers and other employees in company Exadel";

        System.out.println(Merger.merge(source, updated));
        System.out.println(Merger.merge(updated, source));
    }
}
