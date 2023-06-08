import com.swpu.springcloud.entities.Payment;
import com.swpu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
public class test {
    @Autowired
    private PaymentService paymentService;

    @Test
    public void contextLoads() {
        Payment payment=paymentService.getPaymentById(1L);
        log.info(payment.toString());
    }
}
