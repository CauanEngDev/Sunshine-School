import com.cauandev.database.SunshineSchoolData;
import com.cauandev.model.Address;
import com.cauandev.enums.Qualifications;
import com.cauandev.service.AddressService;
import com.cauandev.service.TeacherService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

public class TeacherServiceTest {
    private final TeacherService teacherService = new TeacherService();

    @BeforeEach
    public void setUp() {
        SunshineSchoolData.TEACHERS.clear();
    }

    @Test
    public void createTeacherTest() {
        Assertions.assertEquals(0, SunshineSchoolData.TEACHERS.size());

        teacherService.register("Henry Cavill", LocalDate.of(1983, 5, 5), Qualifications.OTHER, "55975658595",
                "Kaer Morhen", "Smallville", "Cavillrine", "6", "Kaedwen");

        UUID id = SunshineSchoolData.TEACHERS.keySet().stream().findFirst().orElse(null);
        var teacher = SunshineSchoolData.TEACHERS.get(id);
        Address oldAddress = teacher.getAddress();

        Assertions.assertEquals(1, SunshineSchoolData.TEACHERS.size());
        Assertions.assertEquals("Henry Cavill", teacher.getName());
        Assertions.assertEquals(LocalDate.of(1983, 5, 5), teacher.getDateOfBirth());
        Assertions.assertNotEquals("75982998455", teacher.getPhoneNumber());
        Assertions.assertTrue(teacher.getPhoneNumber().length() != 10);
        Assertions.assertEquals("Kaedwen",  oldAddress.neighborhood());
        Assertions.assertEquals("Smallville", oldAddress.city());
        Assertions.assertEquals("Cavillrine", oldAddress.state());
        Assertions.assertEquals("Kaer Morhen", oldAddress.street());
        Assertions.assertEquals("6", oldAddress.cep());

        Address newAddress = AddressService.createAddress(oldAddress.street(), oldAddress.city(), "Novigrad", "6", "Kaedwen");
        teacher.setAddress(newAddress);

        Assertions.assertNotEquals("Cavillrini", teacher.getAddress().state());
        Assertions.assertNotEquals(oldAddress, teacher.getAddress());
        Assertions.assertEquals(newAddress, teacher.getAddress());
    }
}
