package com.dangth.bhxh;

import com.dangth.bhxh.model.location.City;
import com.dangth.bhxh.model.location.Province;
import com.dangth.bhxh.repository.CityRepository;
import com.dangth.bhxh.repository.ProvinceRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LocationAPITests {
    @Autowired
    CityRepository cityRepository;
    @Autowired
    ProvinceRepository provinceRepository;

    @Test
    public void testFindCityByName() {
        City expectedResult = cityRepository.findByCity("Tỉnh Tuyên Quang");
        City actual = new City();
        actual.setCity("Tỉnh Tuyên Quang");
        actual.setIdcity("08TTT");
        Assert.assertEquals(expectedResult, actual);
    }
    @Test
    public void testFindCityById() {
        City expectedResult = cityRepository.findById("08TTT").orElse(null);
        City actual = new City();
        actual.setCity("Tỉnh Tuyên Quang");
        actual.setIdcity("08TTT");
        Assert.assertEquals(expectedResult, actual);
    }
    @Test
    public void testFindProvinceById() {
        Province expectedResult = provinceRepository.findById("001HH").orElse(null);
        Province actual = new Province();
        actual.setName("Quận Ba Đình");
        actual.setIdcity("01TTT");
        actual.setIdprovince("001HH");
        Assert.assertEquals(expectedResult, actual);
    }
//    @Test
//    public void testFindProvinceByCityId() {
//        List<Province> expectedResult = provinceRepository.findAllByIdcity("08TTT");
//        System.out.println(expectedResult);
//        City actual = new City();
//        actual.setIdcity("Tỉnh Tuyên Quang");
//        actual.setIdcity("08TTT");
//        Assert.assertEquals(expectedResult, actual);
//    }
}
