package com.example.demo.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.DoctorRegistration;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	 //@Query("select a from Appointment a where doctor_id=?1 and slot=?2")
	Appointment findBySlotAndDateAndDoctorregistration(String time,Date date,DoctorRegistration doctor) ;
}

