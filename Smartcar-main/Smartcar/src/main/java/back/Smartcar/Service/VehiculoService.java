package back.Smartcar.Service;

import back.Smartcar.Entity.Vehiculo;
import back.Smartcar.IRepository.IVehiculoRepository;
import back.Smartcar.IService.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService implements IVehiculoService {
    @Autowired
    private IVehiculoRepository repository;

    @Override
    public List<Vehiculo> findAll(){
        return repository.findAll();
    }

    @Override
    public Optional<Vehiculo> findById(Long id){
        return repository.findById(id);
    }

    @Override
    public Vehiculo save(Vehiculo vehiculo){
        return repository.save(vehiculo);
    }

    @Override
    public void update(Vehiculo vehiculo, Long id){
        Optional<Vehiculo> vehiculoOld = repository.findById(id);
        if(!vehiculoOld.isEmpty()){
            Vehiculo vehiculoUpdate = vehiculoOld.get();
            vehiculoUpdate.setNombre(vehiculo.getNombre());
            vehiculoUpdate.setMarca(vehiculo.getMarca());
            vehiculoUpdate.setDescripcion(vehiculo.getDescripcion());
            vehiculoUpdate.setModelo(vehiculo.getModelo());
            vehiculoUpdate.setUbicacion(vehiculo.getUbicacion());
            vehiculoUpdate.setAnio(vehiculo.getAnio());
            vehiculoUpdate.setCondicion(vehiculo.getCondicion());
            vehiculoUpdate.setTransmision(vehiculo.getTransmision());
            vehiculoUpdate.setTipo(vehiculo.getTipo());
            vehiculoUpdate.setCombustible(vehiculo.getCombustible());
            vehiculoUpdate.setUltimoDigito(vehiculo.getUltimoDigito());
            vehiculoUpdate.setPrecio(vehiculo.getPrecio());
            vehiculoUpdate.setKilometraje(vehiculo.getKilometraje());
            vehiculoUpdate.setImagen(vehiculo.getImagen());
            vehiculoUpdate.setAdministradorRegistroID(vehiculo.getAdministradorRegistroID());
            repository.save(vehiculoUpdate);
        } else {
            System.out.println("No existe el vehiculo con id " + id);
        }
    }

    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }

}
