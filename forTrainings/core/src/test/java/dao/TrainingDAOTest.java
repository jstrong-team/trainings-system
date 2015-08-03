package dao;

import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TrainingDAOTest extends BaseDAOTest {

    public static final String INITIAL_DATA_LOCATION = "/testdata/initial/training";
    public static final String EXPECTED_DATA_LOCATION = "/testdata/expected/training";

    @Autowired
    private TrainingDAO trainingDAO;

    @Test
    @Ignore
    @DatabaseSetup(INITIAL_DATA_LOCATION + "/edit.xml")
    @ExpectedDatabase(value = EXPECTED_DATA_LOCATION + "/edit.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testEditTraining() {
    }
}