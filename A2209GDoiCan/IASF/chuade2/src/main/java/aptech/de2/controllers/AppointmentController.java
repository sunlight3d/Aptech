package aptech.de2.controllers;

import aptech.de2.models.Appointment;
import aptech.de2.repositories.AppointmentRepository;
import aptech.de2.repositories.DoctorRepository;
import aptech.de2.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("")
    public String index(@RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size,
                        @RequestParam(name = "search", defaultValue = "") String search, Model model) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Appointment> appointments = null;
        appointments = !search.isBlank() ?
                            appointmentRepository.findAllAppointmentsWithSearch(search, pageable):
                            appointmentRepository.findAllAppointmentsWithDetails(pageable);

        model.addAttribute("appointments", appointments.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", appointments.getTotalPages());
        model.addAttribute("search", search);

        return "appointments/index";
    }

    @PostMapping("delete/{id}")
    public String delateAppointment(@PathVariable Integer id) {
        appointmentRepository.deleteById(id);
        return "redirect:/appointments";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("patients", patientRepository.findAll());
        return "appointments/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("appointment") Appointment appointment,
                      BindingResult result,
                      Model model) {
        // Xác định thời gian bắt đầu và kết thúc của ngày
        LocalDate appointmentDate = appointment.getAppointmentDate();
        LocalDateTime appointmentDateStart = appointmentDate.atStartOfDay();
        LocalDateTime appointmentDateEnd = appointmentDate.atTime(23, 59, 59);

        // Kiểm tra bác sĩ có khả dụng không
        boolean doctorAvailable = appointmentRepository.isDoctorAvailable(
                appointment.getDoctor().getId(),
                appointmentDateStart,
                appointmentDateEnd
        );

        if (!doctorAvailable) {
            result.rejectValue("doctor", "error.doctor", "Doctor is not available for the selected time.");
            model.addAttribute("appointment", appointment);
            // Cần thêm dữ liệu cần thiết để render lại view nếu cần
            return "/add";
        }

        // Lưu cuộc hẹn nếu bác sĩ khả dụng
        appointmentRepository.save(appointment);
        return "redirect:/appointments";
    }

}
