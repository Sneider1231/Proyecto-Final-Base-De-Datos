package back.Smartcar.IService;

import back.Smartcar.Entity.Administrador;
import java.util.List;
import java.util.Optional;

public interface IAdministradorService {
    List<Administrador> findAll();
    Optional<Administrador> findById(Long id);
    Administrador save(Administrador Administrador);
    void update(Administrador Administrador, Long id);
    void delete(Long id);
}
