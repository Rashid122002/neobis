package kg.neobis.cardealership.model;

import kg.neobis.cardealership.entity.PurchaseDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class PurchaseDescriptionModel {
    private int purchaseId;
    private String description;

    public static PurchaseDescriptionModel purchaseDescriptionToPurchaseDescriptionModeL(PurchaseDescription purchaseDescription) {
        PurchaseDescriptionModel purchaseDescriptionModel = new PurchaseDescriptionModel();
        purchaseDescriptionModel.setPurchaseId(purchaseDescription.getPurchaseId());
        purchaseDescriptionModel.setDescription(purchaseDescription.getDescription());
        return purchaseDescriptionModel;
    }
}
