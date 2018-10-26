package com.example.fabrikam.HotelCoupon.init;

import com.example.fabrikam.HotelCoupon.dao.GuestRepository;
import com.example.fabrikam.HotelCoupon.dao.RoomTypeRepository;
import com.example.fabrikam.HotelCoupon.data.Guest;
import com.example.fabrikam.HotelCoupon.data.RoomType;
import com.example.fabrikam.HotelCoupon.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;


/**
 * init db data
 */
@Component
@Order(value=3)
public class InitGuests implements CommandLineRunner{

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private GuestRepository guestRepository;

    private List<RoomType> roomTypes;

    private Map<String,String> guestNames;

    private RoomType getRandomRoomType(){
        if(roomTypes==null || roomTypes.isEmpty()){
            roomTypes = roomTypeRepository.findAll();
        }
        if(roomTypes.isEmpty())
            return null;
        Random rand =new Random();
        int i;
        i=rand.nextInt(roomTypes.size());
        return roomTypes.get(i);
    }


    private Map<String,String> getGuestNames(){
        if(guestNames==null || guestNames.isEmpty()){
            String[] guestNameArray = new String[]{
                    "Sophie Stevenson",
                    "Louisa Lane",
                    "Jim McKenzie",
                    "Micheal Estrada",
                    "Bessie Swanson",
                    "Ray Garner",
                    "Lydia Obrien",
                    "Jacob Powers",
                    "Ryan Dunn",
                    "Alexander Harrington",
                    "Nathaniel Fitzgerald",
                    "Olivia Cohen",
                    "Martin Todd",
                    "Darrell Russell",
                    "Russell Stevenson",
                    "Jason McCoy",
                    "Elijah Rodriquez",
                    "Augusta Meyer",
                    "Hattie Baker",
                    "Joe Fitzgerald",
                    "Christina Gregory",
                    "Elizabeth Lowe",
                    "Tillie Hopkins",
                    "Barry Hawkins",
                    "Dorothy Roberts",
                    "Bradley Ross",
                    "Florence Collins",
                    "Olive Buchanan",
                    "Viola Graham",
                    "Gary Murray",
                    "Mike Porter",
                    "Vera Gilbert",
                    "Harold Roy",
                    "Marcus Watson",
                    "Adelaide Sparks",
                    "Steven Martin",
                    "Pauline Wallace",
                    "Devin Stone",
                    "Roy Marshall",
                    "Curtis Wilkerson",
                    "Callie Gonzalez",
                    "Emma Bryant",
                    "Bertie Russell",
                    "Glenn Manning",
                    "Barbara Reid",
                    "Millie Strickland",
                    "Estella Hammond",
                    "Tommy Nguyen",
                    "Billy Moss",
                    "Nelle Greene",
                    "Helena Hernandez",
                    "Louis Cooper",
                    "Mathilda Yates",
                    "Marcus Hodges",
                    "Lou Bishop",
                    "Randall Dawson",
                    "Edgar Snyder",
                    "Estelle Leonard",
                    "Lizzie Keller",
                    "Elizabeth Guerrero",
                    "Ida Banks",
                    "Herman Tyler",
                    "Mollie Spencer",
                    "Mollie Patterson",
                    "Clifford Munoz",
                    "Edwin Phelps",
                    "Rhoda Powers",
                    "Maurice Munoz",
                    "Marc Lee",
                    "Corey Cobb",
                    "Sally McBride",
                    "Lena Stevens",
                    "Susie Franklin",
                    "Gordon Rhodes",
                    "Elizabeth Douglas",
                    "Sarah Rogers",
                    "Elizabeth Greer",
                    "Jeffrey Diaz",
                    "Mason Fuller",
                    "Ollie Cook",
                    "Lester Grant",
                    "Jeremy Norris",
                    "Alejandro Fowler",
                    "Johanna Castillo",
                    "Isaac Burke",
                    "Lucile Kelley",
                    "Ethel Armstrong",
                    "Curtis Watts",
                    "Olivia Chapman",
                    "Ora Casey",
                    "Iva Rhodes",
                    "Vincent Wilkerson",
                    "Johanna Dunn",
                    "Eleanor Hammond",
                    "Arthur Townsend",
                    "Lettie Sandoval",
                    "Susan Gomez",
                    "Trevor Adkins",
                    "Annie Dean",
                    "Eric McGuire",
                    "Dominic Brock",
                    "Gary Hammond",
                    "Bernice Stewart",
                    "Maria Gordon",
                    "Rosa Gonzalez",
                    "Lettie Griffin",
                    "Jessie Burton",
                    "Susie Rodgers",
                    "Jorge Powers",
                    "Charlie Foster",
                    "Owen Gray",
                    "Lettie Dunn",
                    "Dorothy Martinez",
                    "Grace Lane",
                    "Kate Erickson",
                    "Nathaniel Reyes",
                    "Fanny Morton",
                    "Edith Hernandez",
                    "Anne Fowler",
                    "Francis Fox",
                    "Rhoda Schwartz",
                    "Stella Schultz",
                    "Shawn Strickland",
                    "Louis Mullins",
                    "Adeline Collier",
                    "Jim Turner",
                    "Peter Bowers",
                    "Eugene Frank",
                    "Sylvia Wright",
                    "Martha Gregory",
                    "Nettie Morton",
                    "Dorothy Douglas",
                    "Ralph Harvey",
                    "Josephine Collins",
                    "Logan Moreno",
                    "Albert Lindsey",
                    "Jared Cobb",
                    "Christine Oliver",
                    "Troy Osborne",
                    "Loretta Carpenter",
                    "Sue Holmes",
                    "Caroline Allen",
                    "Della Day",
                    "Delia Keller",
                    "Adelaide Yates",
                    "Jorge Schwartz",
                    "Ina Dennis",
                    "Rena Welch",
                    "Marcus Palmer",
                    "Cole Henderson",
                    "Annie Blair",
                    "Don Strickland",
                    "Alfred Tucker",
                    "Ernest Thomas",
                    "Jay Buchanan",
                    "Donald Brock",
                    "Owen Gonzalez",
                    "Ola Singleton",
                    "Lewis Silva",
                    "Ray Owen",
                    "Corey Greer",
                    "Leon Harrington",
                    "Lilly Garcia",
                    "Winifred Hale",
                    "Adeline Greene",
                    "Elnora Castro",
                    "Amy Hart",
                    "Eugenia McGee",
                    "Ryan Silva",
                    "Chris May",
                    "Etta Harrison",
                    "Ivan Nguyen",
                    "Aaron Swanson",
                    "Birdie Hill",
                    "Virginia Parks",
                    "James Lawson",
                    "Fred Franklin",
                    "Lillie Goodwin",
                    "Alexander Snyder",
                    "Cora Hines",
                    "Cecelia McDaniel",
                    "Martha Duncan",
                    "Ella Kennedy",
                    "Craig Padilla",
                    "Hannah Black",
                    "Frances Swanson",
                    "Ada Floyd",
                    "Ruth Neal",
                    "Bernice Hawkins",
                    "Fanny Payne",
                    "Christian Floyd",
                    "Clayton Mann",
                    "Amy Berry",
                    "Caroline Carter",
                    "Alvin Lopez",
                    "Jared Swanson",
                    "Seth Spencer",
                    "Dennis Dixon",
                    "Michael Harvey",
                    "Augusta Hansen",
                    "Jay Weaver",
                    "Lela Pittman",
                    "Amanda Steele",
                    "Winnie Wong",
                    "Amanda Atkins",
                    "Marc Vasquez",
                    "Janie Gonzalez",
                    "Lewis Wagner",
                    "Marie Norman",
                    "Charles Anderson",
                    "Lloyd Knight",
                    "Callie Ruiz",
                    "Gertrude Parsons",
                    "Derek Day",
                    "George Sharp",
                    "Russell Salazar",
                    "Matthew Fox",
                    "Ollie Soto",
                    "Jessie Holmes",
                    "Louis Rivera",
                    "Hunter Delgado",
                    "Nellie Cummings",
                    "Chad Jefferson",
                    "Ronnie Barber",
                    "Jayden Brewer",
                    "Timothy Wolfe",
                    "Gordon Terry",
                    "Cole Cohen",
                    "Loretta McKinney",
                    "Joe Mitchell",
                    "Rachel Brown",
                    "Violet Kennedy",
                    "Dustin Garza",
                    "Florence Benson",
                    "Justin Henderson",
                    "Jesse Christensen",
                    "Christopher Johnson",
                    "Charles Lee", "Garrett Campbell",
                    "Andrew Griffith",
                    "Mamie Barker",
                    "Aiden Brock",
                    "Cecilia Estrada",
                    "Hallie Cobb",
                    "Olga Watts",
                    "Nannie Graham",
                    "Louise Day",
                    "Ethel Simmons",
                    "Lester Moss",
                    "Lizzie Collier",
                    "Kyle Long",
                    "Ruth Flowers",
                    "Theresa Lambert",
                    "Roy Blair",
                    "Michael Soto",
                    "William Davis",
                    "Minnie Schultz",
                    "Mitchell Curry",
                    "Martha Jennings",
                    "Sophie Cannon",
                    "Cody Riley",
                    "Lily Weber",
                    "Eunice Goodman",
                    "Howard French",
                    "Chris Saunders",
                    "Raymond Mendez",
                    "Estella Soto",
                    "Jorge Gill",
                    "Luis Wade",
                    "Katie Farmer",
                    "Nelle Patton",
                    "Sylvia Bush",
                    "Olga Glover",
                    "Agnes Tyler",
                    "Herman Fisher",
                    "Miguel Wallace",
                    "Philip Barber",
                    "Jonathan Ortiz",
                    "Sue Fletcher",
                    "Moisès Agramunt",
                    "Salvador Antonell",
                    "Silvestre Bolas",
                    "Pau, Pol Castellet",
                    "Francesc Rispau",
                    "Just Merino",
                    "Vicenç Subirós",
                    "Rubèn Barri",
                    "Bernabè Sannicolas",
                    "Isaac Jorba"
            };
            guestNames = new HashMap<String,String>();
            for(String name : guestNameArray){
                String[] splitedName = name.split(" ");
                guestNames.put(splitedName[0],splitedName[1]);
            }
        }
        return guestNames;
    }

    private Date[] getRandomCheckInCheckOut(){
        int seed = 7;
        Random rand = new Random();
        int inDate = -1 * rand.nextInt(seed);
        int outDate = rand.nextInt(seed);
        Date dt = new Date();
        Date checkIn = calculateDate(dt,inDate);
        Date checkOut = calculateDate(dt,outDate);
        return new Date[]{checkIn,checkOut};
    }

    private Date calculateDate(Date dt,int diff){
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, diff);
        return c.getTime();
    }

    @Override
    public void run(String... args) throws Exception {
        for(String str : args){
            System.out.println("InitGuests---------->"+str);
        }
        System.out.println("Data is being initialized, init guests............");
        Map<String,String> mapGuestNames = getGuestNames();
        for (Map.Entry<String, String> entry : mapGuestNames.entrySet()) {
            String firstName = entry.getKey();
            String lastName = entry.getValue();
            Date[] checkInOut = getRandomCheckInCheckOut();
            Guest toAdd = new Guest(firstName,lastName,checkInOut[0],checkInOut[1],getRandomRoomType());
            if(guestRepository.findByFirstNameAndLastName(firstName,lastName).isEmpty()) {
                guestRepository.save(toAdd);
            }
        }
    }

}

