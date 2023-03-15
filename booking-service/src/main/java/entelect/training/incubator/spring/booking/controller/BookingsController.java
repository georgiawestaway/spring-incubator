package entelect.training.incubator.spring.booking.controller;

import entelect.training.incubator.spring.booking.model.Booking;
import entelect.training.incubator.spring.booking.service.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bookings")
public class BookingsController {
    private final BookingsService bookingsService;
    @Autowired
    private RestTemplate restTemplate;

    public BookingsController(BookingsService bookingsService) {
        this.bookingsService = bookingsService;

    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {

        // Check if customer exists
        ResponseEntity<?> customerResponse = restTemplate.getForEntity(
                "http://localhost:8202/customers/" + booking.getCustomerId(), Object.class);
        if (customerResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.notFound().build();
        }

        // Check if flight exists
        ResponseEntity<?> flightResponse = restTemplate.getForEntity(
                "http://localhost:8202/flights/" + booking.getFlightId(), Object.class);
        if (flightResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.notFound().build();
        }

        // Save booking
        final Booking savedBooking = bookingsService.createBooking(booking);

        // Return created booking
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBooking);
    }


}
