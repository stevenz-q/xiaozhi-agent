package com.yqz.xiaozhi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yqz.xiaozhi.entity.Appointment;

public interface AppointmentService extends IService<Appointment> {
    Appointment getOne(Appointment appointment);
}