package mock.mock.tourist;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mock.mock.Hotels.Hotel;
import mock.mock.Hotels.HotelRepo;

@CrossOrigin("*")
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
    public List<Hotel> getHotels(){
        return hotelRepo.findAll();
    }

    @GetMapping("/hotel/get/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id){
        Optional<Hotel> optionalHotel = hotelRepo.findById(id);
        if(optionalHotel.isPresent()){
            Hotel hotel = optionalHotel.get();
            return ResponseEntity.ok(hotel);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    

    
    @PostMapping("/hotel/post")
    public void addHotel(@RequestBody Hotel hotel){
        hotelRepo.save(hotel);
    }

}
