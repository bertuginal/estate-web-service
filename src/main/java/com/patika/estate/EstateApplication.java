package com.patika.estate;

import com.patika.estate.dto.request.HouseSaveRequest;
import com.patika.estate.dto.request.SummerHouseSaveRequest;
import com.patika.estate.dto.request.VillaSaveRequest;
import com.patika.estate.service.GeneralService;
import com.patika.estate.service.HouseService;
import com.patika.estate.service.SummerHouseService;
import com.patika.estate.service.VillaService;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class EstateApplication {

    public static void main(String[] args) throws ClassNotFoundException{
        HouseService houseService = new HouseService();
        SummerHouseService summerHouseService = new SummerHouseService();
        VillaService villaService = new VillaService();
        GeneralService generalService = new GeneralService();


        HouseSaveRequest house1 = new
                HouseSaveRequest(1L,"Apartment Dairesi", "4 katlı lüks daire!", 1000000L, 120, 3, 1, 4, 89);
        HouseSaveRequest house2 = new
                HouseSaveRequest(2L,"Müstakil Ev", "Geniş bahçeli lüks ev!", 2500000L, 180, 4, 1, 7, 78);
        HouseSaveRequest house3 = new
                HouseSaveRequest(3L,"Kır Evi", "Yemyeşil kırların içindeki yaşam!",900000L, 100, 2, 1, 3, 46);

        houseService.save(house1);
        houseService.save(house2);
        houseService.save(house3);


        SummerHouseSaveRequest summerHouse1 = new
                SummerHouseSaveRequest(1L, "Kıyı Retreat","Denize sıfır lüks yazlık!", 2500000L, 160, 4, 2, 3, true);
        SummerHouseSaveRequest summerHouse2 = new
                SummerHouseSaveRequest(2L, "Oasis", "Geniş yüzme havuzlu büyük yazlık!", 1400000L, 180, 6, 1, 2, false);
        SummerHouseSaveRequest summerHouse3 = new
                SummerHouseSaveRequest(3L,"Ocean Side", "6 odalı mükemmel havuzlu denize sıfır yazlık!", 3500000L, 200, 6, 1, 4, true);

        summerHouseService.save(summerHouse1);
        summerHouseService.save(summerHouse2);
        summerHouseService.save(summerHouse3);


        VillaSaveRequest villa1 =
                new VillaSaveRequest(1L, "Storia Konakları", "8 odalı muhteşem büyük villa!",4000000L, 450, 8, 3, 4, true);
        VillaSaveRequest villa2 =
                new VillaSaveRequest(2L, "Demir Park", "2 katlı yüzme havuzlu villa!" ,2300000L, 150, 4, 1, 2, true);
        VillaSaveRequest villa3 =
                new VillaSaveRequest(3L, "Narlı Villaları", "6 odalı 2 katlı geniş bahçeli villa!", 1200000L, 280, 6, 2, 3, true);

        villaService.save(villa1);
        villaService.save(villa2);
        villaService.save(villa3);

        System.out.println("House's List: " + houseService.getAllList());
        System.out.println("Villa's List: " + villaService.getAllList());
        System.out.println("SummerHouse's List: " + summerHouseService.getAllList());

        // Evlerin toplam fiyatlarını dönen metot
        System.out.println("Total price of houses: " + generalService.calculateHousesPrice());

        // Villaların toplam fiyatlarını dönen bir metot
        System.out.println("Total price of villas: " + generalService.calculateVillasPrice());

        //Yazlıkların toplam fiyatlarını dönen metot
        System.out.println("Total price of summerhouses: " + generalService.calculateSummerHousesPrice());

        //Tüm tipteki evlerin toplam fiyatını dönen metot
        System.out.println("Total price of all types of estates: " + generalService.calculateEstatesAveragePrice());

        // Evlerin ortalama metre karesini dönen  metot
        System.out.println("Average square meters of houses: " + generalService.getHousesAverageSquareMeter());

        // Villaların ortalama metrekaresini dönen  metot
        System.out.println("Average square meters of villas: " + generalService.getVillasAverageSquareMeter());

        // Yazlıkların ortalama metre karesini dönen metot
        System.out.println("Average square meters of summerhouses: " + generalService.getSummerHousesAverageSquareMeter());

        // Tüm tipteki evlerin ortalama metre karesini dönen metot
        System.out.println("Average square meters of houses of all types: " + generalService.getAllResidencesAverageSquareMeter());

        // Oda ve salon sayısına göre tüm tipteki evleri filtreleyip dönen metot
        System.out.println("All types of estates according to the number of rooms and living rooms: " + generalService.estateListByRoomCountAndHallCount(6,1));
        System.out.println( generalService.estateListByRoomCountAndHallCount(6,1).stream().map(house -> "Name: " + house.getName() + "Id: " + house.getId().toString() ).toList());



    }

}
