package com.dangth.bhxh.dto;

import com.dangth.bhxh.model.IdentityCard;
import com.dangth.bhxh.model.Worker;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DTOUtils {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static Worker toWorker(WorkerDTO workerDTO) {
        try {
            Worker worker = new Worker();
            IdentityCard identityCard = new IdentityCard();
            worker.setFullName(workerDTO.getFullName());
            worker.setAddress(workerDTO.getAddress());
            worker.setEmail(workerDTO.getEmail());
            worker.setGender(workerDTO.getGender());
            worker.setMsbh(workerDTO.getMsbh());
            worker.setPhoneNumber(workerDTO.getPhoneNumber());
            worker.setBirthDate(dateFormat.parse(workerDTO.getBirthDate()));
            identityCard.setNumber(workerDTO.getIdentityNumber());
            identityCard.setPlace(workerDTO.getPlace());
            identityCard.setValidFrom(dateFormat.parse(workerDTO.getValidFrom()));
            worker.setIdentityCard(identityCard);
            return worker;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
