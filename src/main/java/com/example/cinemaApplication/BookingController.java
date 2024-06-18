package com.example.cinemaApplication;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {
    private final BookingRepository repository;
    BookingController(BookingRepository repository){
        this.repository = repository;
    }
    @GetMapping("/Bookings")
    List<Booking> all(){
        return repository.findAll();
    }
    @GetMapping("/Bookings/{id}")
    Optional<Booking> ticket_id(@PathVariable Long id){
         return repository.findById(id);
    }
    @PostMapping("/Bookings")
    String create(@RequestBody Booking booking) {
        repository.save(booking);
        return "Бронь готова";
    }
    @PatchMapping("/Bookings/{id}")
        String edit(@PathVariable Long id, @RequestBody Booking booking) {
        var bookingbid = repository.findById(id);
        if(bookingbid.isEmpty()){
            return "Заказчик не найден";
        }
        if((booking.getCustomer() == null)){
            return "Введите имя заказчика :<";
        }
        bookingbid.get().setCustomer(booking.getCustomer(), booking.getMovie(), booking.getHall(), booking.getLine(),booking.getPlace(), booking.getDate());
        repository.save(bookingbid.get());
        return "Customer обновлён";
    }
    @DeleteMapping("/Bookings/{id}")
    String delete(@PathVariable Long id){
        var booking = repository.findById(id);
        if(booking.isEmpty()){
            return "Броней нет";
        }
        repository.delete(booking.get());
        return "Бронь была низвергнута :<";
    }
}
