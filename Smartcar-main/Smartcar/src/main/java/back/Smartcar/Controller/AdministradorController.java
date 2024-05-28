package back.Smartcar.Controller;

import back.Smartcar.Entity.Administrador;
import back.Smartcar.IService.IAdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("administrador")
public class AdministradorController {
    @Autowired
    private IAdministradorService service;

    @GetMapping()
    public List<Administrador> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Administrador> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping()
    public Administrador save(@RequestBody Administrador administrador){
        return service.save(administrador);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Administrador administrador, @PathVariable Long id){
        service.update(administrador, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
