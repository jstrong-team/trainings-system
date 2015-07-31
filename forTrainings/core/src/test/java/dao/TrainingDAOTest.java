package dao;

import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TrainingDAOTest extends BaseDAOTest {

    public static final String INITIAL_DATA_LOCATION = "/testdata/initial/training";
    public static final String EXPECTED_DATA_LOCATION = "/testdata/expected/training";

    @Autowired
    private TrainingDAO trainingDAO;

    @Test
    @DatabaseSetup(INITIAL_DATA_LOCATION + "/edit.xml")
    @ExpectedDatabase(value = EXPECTED_DATA_LOCATION + "/edit.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testEditTraining() {
        Training training = new Training();
        training.setId(1);
        training.setTrainer_id(1);
        training.setName("trName");
        training.setAnnotation("trAnnotation");
        training.setDescription("trDescription");
        training.setTarget("trTarget");
        training.setPaid(true);
        training.setInternal(true);
        training.setApprove(true);
        training.setMax_participants(30);

        //trainingDAO.editTraining(training);
    }
}