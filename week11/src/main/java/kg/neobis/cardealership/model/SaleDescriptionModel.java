package kg.neobis.cardealership.model;

import kg.neobis.cardealership.entity.SaleDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDescriptionModel {
    private int saleId;
    private String description;

    public static SaleDescriptionModel saleDescriptionModelToSaleDescriptionModelModeL(SaleDescription saleDescription) {
        SaleDescriptionModel saleDescriptionModel = new SaleDescriptionModel();
        saleDescriptionModel.setSaleId(saleDescription.getSaleId());
        saleDescriptionModel.setDescription(saleDescription.getDescription());
        return saleDescriptionModel;
    }
}
