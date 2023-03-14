package entelect.training.incubator.service;

import entelect.training.incubator.model.Booking;
import entelect.training.incubator.repository.BookingsRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingsService {
    private final BookingsRepository bookingsRepository;

    public BookingsService(BookingsRepository bookingsRepository) {
        this.bookingsRepository = bookingsRepository;
    }

    public Booking createBooking(Booking booking) {
        return bookingsRepository.save(booking);
    }
}
