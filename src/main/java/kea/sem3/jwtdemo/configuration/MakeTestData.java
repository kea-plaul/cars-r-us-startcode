package kea.sem3.jwtdemo.configuration;

import kea.sem3.jwtdemo.entity.*;
import kea.sem3.jwtdemo.repositories.CarRepository;
import kea.sem3.jwtdemo.repositories.MemberRepository;
import kea.sem3.jwtdemo.repositories.ReservationRepository;
import kea.sem3.jwtdemo.security.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
@Profile("!test")
public class MakeTestData implements ApplicationRunner {


    UserRepository userRepository;
    MemberRepository memberRespository;
    CarRepository carRepository;
    ReservationRepository reservationRepository;

    public MakeTestData(UserRepository userRepository, MemberRepository memberRespository, CarRepository carRepository, ReservationRepository reservationRepository) {
        this.userRepository = userRepository;
        this.memberRespository = memberRespository;
        this.carRepository = carRepository;
        this.reservationRepository = reservationRepository;
    }

    public  void makePlainUsers(){
        BaseUser user = new BaseUser("user", "user@a.dk", "test12");
        user.addRole(Role.USER);
        BaseUser admin = new BaseUser("admin", "admin@a.dk", "test12");
        admin.addRole(Role.ADMIN);
        BaseUser both = new BaseUser("user_admin", "both@a.dk", "test12");
        both.addRole(Role.USER);
        both.addRole(Role.ADMIN);

        userRepository.save(user);
        userRepository.save(admin);
        userRepository.save(both);


        memberRespository.save(new Member("KW","kw@a.dk","test12","Kurt","Wonnegut","Lyngbyvje 34","Lyngby","2800"));
        memberRespository.save(new Member("HW","hw@a.dk","test12","Hanne","Wonnegut","Lyngbyvje 34","Lyngby","2800"));

        carRepository.save(new Car("Volvo", "C40", 560,10));
        carRepository.save(new Car("Volvo", "V70", 500,10));
        carRepository.save(new Car("Volvo", "V49", 400,10));
        carRepository.save(new Car("Suzuki", "Vitara", 500,14));
        carRepository.save(new Car("Suzuki", "Vitara", 500,14));
        carRepository.save(new Car("Suzuki", "S-Cross", 500,14));

        System.out.println("########################################################################################");
        System.out.println("########################################################################################");
        System.out.println("#################################### WARNING ! #########################################");
        System.out.println("## This part breaks a fundamental security rule -> NEVER ship code with default users ##");
        System.out.println("########################################################################################");
        System.out.println("########################  REMOVE BEFORE DEPLOYMENT  ####################################");
        System.out.println("########################################################################################");
        System.out.println("########################################################################################");
        System.out.println("Created TEST Users");

    }
    public void makeReservationTest () {
        Reservation testReservation1 = new Reservation(2-15-2022);
        Reservation testReservation2 = new Reservation(9-15-2022);
        Reservation testReservation3 = new Reservation(10-15-2022);
        Reservation testReservation4 = new Reservation(11-15-2022);
        Reservation testReservation5 = new Reservation(12-15-2022);


        reservationRepository.save(testReservation1);
        reservationRepository.save(testReservation2);
        reservationRepository.save(testReservation3);
        reservationRepository.save(testReservation4);
        reservationRepository.save(testReservation5);

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        userRepository.deleteAll();

        makePlainUsers();


    }
}
