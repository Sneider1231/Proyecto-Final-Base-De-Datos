package back.Smartcar.Service;

import back.Smartcar.Entity.Administrador;
import back.Smartcar.IRepository.IAdministradorRepository;
import back.Smartcar.IService.IAdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService implements IAdministradorService {
    @Autowired
    private IAdministradorRepository repository;

    @Override
    public List<Administrador> findAll(){
        return repository.findAll();
    }

    @Override
    public Optional<Administrador> findById(Long id){
        return repository.findById(id);
    }

    @Override
    public Administrador save(Administrador administrador){
        return repository.save(administrador);
    }

    @Override
    public void update(Administrador administrador, Long id){
        Optional<Administrador> administradorOld = repository.findById(id);
        if(!administradorOld.isEmpty()){
            Administrador administradorUpdate = administradorOld.get();
            administradorUpdate.setUsuario(administrador.getUsuario());
            administradorUpdate.setContrasenia(administrador.getContrasenia());
            repository.save(administradorUpdate);
        } else {
            System.out.println("No existe el administrador con id " + id);
        }
    }

    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }

}
