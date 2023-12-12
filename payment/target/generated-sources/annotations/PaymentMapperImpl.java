
import com.servicepayment.dto.PaymentDTO;
import com.servicepayment.entity.Payment;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-10T02:33:07-0500",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
*/
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public Payment toEntity(PaymentDTO paymentDTO) {
        if ( paymentDTO == null ) {
            return null;
        }

        Payment payment = new Payment();

        return payment;
    }

    @Override
    public PaymentDTO toDTO(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentDTO paymentDTO = new PaymentDTO();

        return paymentDTO;
    }

    @Override
    public List<PaymentDTO> toDtoList(List<Payment> payments) {
        if ( payments == null ) {
            return null;
        }

        List<PaymentDTO> list = new ArrayList<PaymentDTO>( payments.size() );
        for ( Payment payment : payments ) {
            list.add( toDTO( payment ) );
        }

        return list;
    }
}
