package back.Smartcar.Controller;

import back.Smartcar.Entity.Vehiculo;
import back.Smartcar.IService.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("vehiculo")
public class VehiculoController {
    @Autowired
    private IVehiculoService service;

    @GetMapping()
    public List<Vehiculo> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Vehiculo> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping()
    public Vehiculo save(@RequestBody Vehiculo vehiculo){
        return service.save(vehiculo);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Vehiculo vehiculo, @PathVariable Long id){
        service.update(vehiculo, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
