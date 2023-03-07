package tn.esprit.marketplace.restController;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.marketplace.entities.Delivery;
import tn.esprit.marketplace.services.interfaces.IDeliveryService;


import java.util.List;

@RestController
@RequestMapping("api/delivery")
@AllArgsConstructor
public class DeliveryController {


    IDeliveryService ids;


    @PostMapping("add")
    Delivery addDelivery(@RequestBody Delivery delivery) {
        return  ids.addDelivery(delivery);
    }

    @DeleteMapping("deleteById")
    public void deleteDeliveryById(@RequestParam Long idDelivery){
         ids.deleteDeliveryById(idDelivery);
    }

    @PutMapping("updateDelivery/{idDelivery}")
    public ResponseEntity<Delivery> updateDeliveryById(@PathVariable Long idDelivery, @RequestBody Delivery delivery){
        Delivery deliveryU = ids.updateDeliveryById(idDelivery,delivery);
        return deliveryU != null ? ResponseEntity.ok(deliveryU) : ResponseEntity.notFound().build();
    }
    @GetMapping("GetListDelivery")
    public List<Delivery> getListDelivery(){
        return ids.getListDelivery();
    }

    @PostMapping("addDeliveryAndAssignToTransaction")
    public void addDeliveryAndAssignToTransaction(@RequestParam Long idTransaction,@RequestBody Delivery delivery) {

        Delivery delivery1 = ids.addDeliveryAndAssignToTransaction(idTransaction,delivery);

    }
}
