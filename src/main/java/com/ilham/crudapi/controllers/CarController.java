package com.ilham.crudapi.controllers;

import com.ilham.crudapi.entities.CarEntity;
import com.ilham.crudapi.entities.CarImage;
import com.ilham.crudapi.repositories.CarRepository;
import com.ilham.crudapi.response.CommonResponse;
import com.ilham.crudapi.response.CommonResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @GetMapping(value = "checkAPI")
    public CommonResponse<String> checkApi() {
        return commonResponseGenerator.successResponse("Hallo Sister", "Hello World");
    }

    @PostMapping(value = "addNewCar")
    public CommonResponse<CarEntity> addNewCar(@RequestBody CarEntity param) {

        carRepository.save(param);
        return commonResponseGenerator.successResponse(param, "Success add data");
    }

    @GetMapping(value = "getAllCar")
    public CommonResponse<List<CarEntity>> getAllCar() {
        return commonResponseGenerator.successResponse(carRepository.findAll(), "Success get all data");
    }

    @GetMapping(value = "getById")
    public CommonResponse<CarEntity> getById(@RequestParam int id) {
        return commonResponseGenerator.successResponse(carRepository.findById(id).get(), "Success get by id: "+id);
    }

    @PostMapping(value = "updateCar")
    public CommonResponse<CarEntity> updateCar(@RequestBody CarEntity param){
        return commonResponseGenerator.successResponse(carRepository.save(param), "Success update data id: "+param.getId());
    }

    @GetMapping(value = "deleteCar")
    public CommonResponse<List<CarEntity>> deleteCar(@RequestParam int id){

        carRepository.deleteById(id);
        List<CarEntity> carList = carRepository.findAll();
        return commonResponseGenerator.successResponse(carList, "Success delete car id: "+id);
    }

    @PostMapping(value = "uploadcar")
    public CommonResponse<CarImage> upload(){
        return null;
    }
}

