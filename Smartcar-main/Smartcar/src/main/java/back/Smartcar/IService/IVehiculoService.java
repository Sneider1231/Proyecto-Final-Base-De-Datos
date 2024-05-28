package back.Smartcar.IService;

import back.Smartcar.Entity.Vehiculo;
import java.util.List;
import java.util.Optional;

public interface IVehiculoService {
    List<Vehiculo> findAll();
    Optional<Vehiculo> findById(Long id);
    Vehiculo save(Vehiculo Vehiculo);
    void update(Vehiculo Vehiculo, Long id);
    void delete(Long id);
}
