package entelect.training.incubator.spring.booking.service;

import entelect.training.incubator.spring.booking.model.Booking;
import entelect.training.incubator.spring.booking.repository.BookingsRepository;
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
