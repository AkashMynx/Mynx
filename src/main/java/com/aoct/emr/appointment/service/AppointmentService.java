package com.aoct.emr.appointment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aoct.emr.appointment.entity.AppointmentEntity;
import com.aoct.emr.appointment.repo.AppointmentRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository repo;

	public long  bookAppointment(AppointmentEntity e) {
		// TODO Auto-generated method stub
		AppointmentEntity appointment = repo.save(e);
		if(appointment==null)
		{
			return 0;
		}
		return appointment.getAppointmentId();	
		
		
	}

    public List<AppointmentEntity> getProviderSchedule(LocalDate date, Long providerId) {
		List<AppointmentEntity> appointments = repo.getProviderSchedule(date,providerId);
		return appointments;
    }

	public AppointmentEntity getAppointmentDetail(Long appointmentId) {
		return repo.getReferenceById(appointmentId);
	}

	public List<AppointmentEntity> getProviderSchedule(LocalDate date) {
		return repo.getProviderSchedule(date);
	}

	public Set<LocalDate> getAppointmentsByMonth(int month, int year) {
		Set<LocalDate> dates=repo.findByMonth(month,year);
		return dates;
	}


    public List<AppointmentEntity> getAppointmentByPatientId(Long patientId) {
		return repo.findByPatientId(patientId);
    }

	public List<AppointmentEntity> getProvideAppointmentsByMonth(Long providerId, int month, int year) {
		return repo.getProviderAppointmentByMonth(providerId,month,year);
	}
}
