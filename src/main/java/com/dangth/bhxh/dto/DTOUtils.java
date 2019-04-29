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
            worker.setId(workerDTO.getId());
            worker.setFullName(workerDTO.getFullName().trim());
            worker.setAddress(workerDTO.getAddress());
            worker.setEmail(workerDTO.getEmail());
            worker.setGender(workerDTO.getGender());
            worker.setMsbh(String.valueOf(System.currentTimeMillis()));
            worker.setSalary(Double.parseDouble(workerDTO.getSalary().replace(".","").replace(",","")));
            worker.setPc(Double.parseDouble(workerDTO.getPc().replace(".","").replace(",","")));
            worker.setHt(Double.parseDouble(workerDTO.getHt().replace(".","").replace(",","")));
            worker.setZone(workerDTO.getZone());
            worker.setWorkplace(workerDTO.getWorkplace());
            worker.setPhoneNumber(workerDTO.getPhoneNumber());
            worker.setBirthDate(dateFormat.parse(workerDTO.getBirthDate()));
            identityCard.setId(workerDTO.getIdentityId());
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
    public static WorkerDTO toWorkerDTO(Worker worker) {
        WorkerDTO dto = new WorkerDTO();
        dto.setAddress(worker.getAddress());
        dto.setFullName(worker.getFullName());
        dto.setBirthDate(dateFormat.format(worker.getBirthDate()));
        dto.setId(worker.getId());
        dto.setEmail(worker.getEmail());
        dto.setIdentityNumber(worker.getIdentityCard().getNumber());
        dto.setIdentityId(worker.getIdentityCard().getId());
        dto.setValidFrom(dateFormat.format(worker.getIdentityCard().getValidFrom()));
        dto.setPlace(worker.getIdentityCard().getPlace());
        dto.setGender(worker.getGender());
        dto.setMsbh(worker.getMsbh());
        dto.setPhoneNumber(worker.getPhoneNumber());
        dto.setSalary(String.format("%.0f",worker.getSalary()));
        dto.setPc(String.format("%.0f",worker.getPc()));
        dto.setHt(String.format("%.0f",worker.getHt()));
        dto.setZone(worker.getZone());
        dto.setWorkplace(worker.getWorkplace().trim());
        System.out.println(dto);
        return dto;

    }
}
