package com.dangth.bhxh.repository;

import com.dangth.bhxh.model.Worker;
import org.springframework.data.repository.CrudRepository;

public interface WorkerRepository extends CrudRepository<Worker, Long> {
    Worker findByIdentityCard_Number(String number);
}
