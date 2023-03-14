package entelect.training.incubator.repository;
import entelect.training.incubator.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingsRepository extends CrudRepository<Booking, Integer> {
}
