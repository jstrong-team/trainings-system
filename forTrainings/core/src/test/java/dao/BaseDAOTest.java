package dao;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/persistence-config.xml")
@TransactionConfiguration(transactionManager = "transactionManager")
@Ignore()
public abstract class BaseDAOTest extends AbstractTransactionalJUnit4SpringContextTests {
}