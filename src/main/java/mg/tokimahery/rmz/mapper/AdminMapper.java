package mg.tokimahery.rmz.mapper;

import java.util.List;
import mg.tokimahery.rmz.model.Admin;
import mg.tokimahery.rmz.repository.model.JAdmin;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
  public List<Admin> toModel(List<JAdmin> jAdmins) {
    return jAdmins.stream().map(this::toModel).toList();
  }

  public Admin toModel(JAdmin jAdmin) {
    return Admin.builder()
        .id(jAdmin.getId())
        .phone(jAdmin.getPhone())
        .address(jAdmin.getAddress())
        .password(jAdmin.getPassword())
        .email(jAdmin.getEmail())
        .build();
  }

  public List<JAdmin> toEntity(List<Admin> admins) {
    return admins.stream().map(this::toEntity).toList();
  }

  public JAdmin toEntity(Admin admin) {
    return JAdmin.builder()
        .id(admin.getId())
        .firstName(admin.getFirstName())
        .lastName(admin.getLastName())
        .address(admin.getAddress())
        .password(admin.getPassword())
        .email(admin.getEmail())
        .build();
  }
}
