package mock.mock.tourist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mock.mock.Hotels.Hotel;
import mock.mock.Hotels.HotelRepo;

@RestController
@RequestMapping("/exotourista")
public class TouristCon {
    @Autowired
    private TouristRepo touristRepo;
    @Autowired
    private HotelRepo hotelRepo;

    @GetMapping("/tourist/get")
    public List<Tourist> getAllTourists(){
        return touristRepo.findAll();
    }

    @PostMapping("/tourist/post")
    public void addTourist(@RequestBody Tourist tourist){
        touristRepo.save(tourist);
    }

    // @DeleteMapping("/{id}")
    // public void deleteTourist(@RequestPath)

    @GetMapping("/hotel/get")
    public List<Hotel> getTax(){
        return hotelRepo.findAll();
    }
    
    @PostMapping("/hotel/post")
    public void addTax(@RequestBody Hotel hotel){
        hotelRepo.save(hotel);
    }

}
